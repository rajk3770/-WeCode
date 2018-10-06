package com.example.raj.minuteio;

//
//import android.os.Bundle;
//import android.os.Environment;
//import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//
//import com.google.cloud.speech.v1.SpeechClient;
//import com.google.cloud.speech.v1.RecognitionAudio;
//import com.google.cloud.speech.v1.RecognitionConfig;
//import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
//import com.google.cloud.speech.v1.RecognizeResponse;
//import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
//import com.google.cloud.speech.v1.SpeechRecognitionResult;
//import com.google.protobuf.ByteString;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.Map;


public class Upload_audio_google extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_upload_audio_google);
//        try {
//
//            enableStrictMode();
//            Log.e("He","She");
//
//            Log.e("Env",System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
//            Map<String,String> env=System.getenv();
//            for(String envName:env.keySet()){
//                Log.e(envName,env.get(envName));
//            }
//            SpeechClient speech = SpeechClient.create();
//            Log.e("Speech",speech.toString());
//            // The path to the audio file to transcribe
//            String fileName = String.valueOf(getResources().openRawResource(getResources().getIdentifier("recording.wav","raw",getPackageName()))); // for example "./resources/audio.raw";
//
//            // Reads the audio file into memory
//            Path path = Paths.get(fileName);
//            byte[] data = Files.readAllBytes(path);
//            ByteString audioBytes = ByteString.copyFrom(data);
//            Log.e("Byte Array",data.toString());
//            // Builds the sync recognize request
//            RecognitionConfig config = RecognitionConfig.newBuilder()
//                    .setEncoding(AudioEncoding.LINEAR16)
//                    .setSampleRateHertz(16000)
//                    .setLanguageCode("en-US")
//                    .build();
//            RecognitionAudio audio = RecognitionAudio.newBuilder()
//                    .setContent(audioBytes)
//                    .build();
//
//            // Performs speech recognition on the audio file
//            RecognizeResponse response = speech.recognize(config, audio);
//            List<SpeechRecognitionResult> results = response.getResultsList();
//
//            for (SpeechRecognitionResult result : results) {
//                List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
//                for (SpeechRecognitionAlternative alternative : alternatives) {
//                    System.out.printf("Transcription: %s%n", alternative.getTranscript());
//                    Log.e("Hello",alternative.getTranscript().toString());
//                }
//            }
//            speech.close();
//        }
//        catch (Exception e){
//            Log.e("Exception",e.toString());
//        }
//        }
//        public void enableStrictMode()
//        {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//
//            StrictMode.setThreadPolicy(policy);
//        }
    }

