package com.example.raj.minuteio;
//
//import android.os.Bundle;
//import android.os.StrictMode;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//
//import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
//import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
//import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
//import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
//import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
//import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
//import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;

public class ibm_nlp{
//        extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ibm_nlp);
//
//        enableStrictMode();
//        NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
//                "2018-03-16",
//                "ca8370b2-819c-4d8d-9c03-66d855186d99",
//                "wTikxpr5LEn8"
//        ); "IBM is an American multinational technology " +
////                "company headquartered in Armonk, New York, " +
////                "United States, with operations in over 170 countries.";
//
////
////        String text =
//        String text="You fucking bastard!Hell with your company";
//        EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
//                .emotion(true)
//                .sentiment(true)
//                .limit(2)
//                .build();
//
//        KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
//                .emotion(true)
//                .sentiment(true)
//                .limit(2)
//                .build();
//
//        Features features = new Features.Builder()
//                .entities(entitiesOptions)
//                .keywords(keywordsOptions)
//                .build();
//
//        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
//                .text(text)
//                .features(features)
//                .build();
//
//        AnalysisResults response = service
//                .analyze(parameters)
//                .execute();
//
//        Log.e("Response",response.toString());
//
//
//    }
//
//    public void enableStrictMode()
//    {
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//
//        StrictMode.setThreadPolicy(policy);
//    }
//

}
