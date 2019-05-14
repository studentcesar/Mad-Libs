package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;

public class ChooseStoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_story);


    }


    public void buttonClicked(View view) {
        int id = view.getId();
        int story_id;

        switch (id) {
            default:
                story_id = R.raw.madlib0_simple;
                break;
            case R.id.tarzan:
                story_id = R.raw.madlib1_tarzan;
                break;
            case R.id.university:
                story_id = R.raw.madlib2_university;
                break;
            case R.id.clothing:
                story_id = R.raw.madlib3_clothes;
                break;
            case R.id.dancing:
                story_id = R.raw.madlib4_dance;
                break;
        }
        InputStream is = getResources().openRawResource(story_id);

        Story story = new Story(is);


        Intent intent = new Intent(ChooseStoryActivity.this, Activity2.class);
        intent.putExtra("chosenStory", story);
        startActivity(intent);
    }
}
