package com.example.raj.minuteio;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by raj on 5/10/18.
 */



public class upload_audio extends AppCompatActivity {
    private Button play, stop, record;
    private MediaRecorder myAudioRecorder;
    private static final String MyPREFERENCES = "MyAndroidFCMIIDService";
    private String outputFile;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabase;
    String myData = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_audio);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        record = (Button) findViewById(R.id.record);
        stop.setEnabled(false);
        play.setEnabled(false);
        outputFile = "/recording.wav";
                //Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.wav";
        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    myAudioRecorder.prepare();
                    myAudioRecorder.start();
                } catch (IllegalStateException ise) {
                    // make something ...
                } catch (IOException ioe) {
                    // make something
                }
                record.setEnabled(false);
                stop.setEnabled(true);
                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioRecorder.stop();
                myAudioRecorder.release();
                myAudioRecorder = null;
                record.setEnabled(true);
                stop.setEnabled(false);
                play.setEnabled(true);
                Toast.makeText(getApplicationContext(), "Audio Recorder successfully", Toast.LENGTH_LONG).show();
                save_audio_on_firebase();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(outputFile);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(), "Playing Audio", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    // make something
                }
            }
        });


    }

    public void save_audio_on_firebase(){

        try {
            FileInputStream fis = new FileInputStream(outputFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
            Log.e("Data",myData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //inputText.setText(myData);
        //response.setText("SampleFile.txt data retrieved from Internal Storage...");
    }



//
//    private static boolean isExternalStorageReadOnly() {
//        String extStorageState = Environment.getExternalStorageState();
//            if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
//            return true;
//            }
//            return false;
//            }
//
//    private static boolean isExternalStorageAvailable() {
//            String extStorageState = Environment.getExternalStorageState();
//            if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
//            return true;
//            }
//            return false;
//            }
//
//    if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
//            saveButton.setEnabled(false);
//            }
//            else {
//            myExternalFile = new File(getExternalFilesDir(filepath), filename);
//            }
//
//        }
//
//    String[] p= MediaStore.Audio.Media.
//    Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
//    StorageReference riversRef = storageRef.child("images/rivers.jpg");
//
//    riversRef.putFile(file)
//            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//        @Override
//        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//            // Get a URL to the uploaded content
//            Uri downloadUrl = taskSnapshot.getDownloadUrl();
//            upload_link_in_db(randomAlphaNumeric(16),downloadUrl);
//        }
//    })
//            .addOnFailureListener(new OnFailureListener() {
//        @Override
//        public void onFailure(@NonNull Exception exception) {
//            // Handle unsuccessful uploads
//            // ...
//        }
//    });


    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {

        StringBuilder builder = new StringBuilder();

        while (count-- != 0) {

            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

            builder.append(ALPHA_NUMERIC_STRING.charAt(character));

        }

        return builder.toString();

    }

    public void upload_link_in_db(String uid, String path){


        mDatabase=FirebaseDatabase.getInstance().getReference();
        mDatabase.child(uid).setValue(path);


        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("uid",uid);
        editor.commit();
    }



}




