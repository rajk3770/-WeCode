//package com.example.raj.minuteio;
//
//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.net.Uri;
//import android.support.annotation.NonNull;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.NetworkError;
//import com.android.volley.NoConnectionError;
//import com.android.volley.ParseError;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.ServerError;
//import com.android.volley.TimeoutError;
//import com.android.volley.VolleyError;
//import com.android.volley.VolleyLog;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//import com.ibm.watson.developer_cloud.android.library.audio.MicrophoneInputStream;
//import com.ibm.watson.developer_cloud.android.library.audio.utils.ContentType;
//import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
//import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
//import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
//import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;
//import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.w3c.dom.Text;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//public class get_summary extends AppCompatActivity {
//
//SpeechToText speechToText = new SpeechToText();
//speechToText.setUsernameAndPassword("", "{password}");
//
//
//try {
//        RecognizeOptions recognizeOptions = null;
//        try {
//            recognizeOptions = new RecognizeOptions.Builder()
//                    .audio(new FileInputStream("audio-file.flac"))
//                    .contentType("audio/flac")
//                    .model("en-US_BroadbandModel")
//                    .keywords(Arrays.asList("colorado", "tornado", "tornadoes"))
//                    .keywordsThreshold((float) 0.5)
//                    .maxAlternatives(3)
//                    .build();
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        }
//
//        BaseRecognizeCallback baseRecognizeCallback =
//                new BaseRecognizeCallback() {
//
//                    @Override
//                    public void onTranscription
//                            (SpeechRecognitionResults speechRecognitionResults) {
//                        System.out.println(speechRecognitionResults);
//                    }
//
//                    @Override
//                    public void onDisconnected() {
//                        System.exit(0);
//                    }
//
//                };
//
//        speechToText.recognizeUsingWebSocket(recognizeOptions,
//                baseRecognizeCallback);
//    } catch (FileNotFoundException e) {
//        e.printStackTrace();
//    }
//}