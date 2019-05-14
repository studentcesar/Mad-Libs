package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;

public class Activity2 extends AppCompatActivity {
    Story story;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);





        Intent intent = getIntent();

        story = (Story) intent.getSerializableExtra("chosenStory");




        text = (EditText) findViewById(R.id.edit_text);

        TextView word_count = findViewById(R.id.word_count);

        text.setHint(story.getNextPlaceholder());
        String words_left = String.valueOf(story.getPlaceholderRemainingCount());
        word_count.setText((words_left + " " +  "word(s) left"));



        Button ok_button = (Button) findViewById(R.id.ok);

        ok_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String word = text.getText().toString();

                if(text.length() == 0){
                    Toast.makeText(getApplicationContext(), "fill in a word!", Toast.LENGTH_SHORT).show();
                }
                else{
                    story.fillInPlaceholder(word);
                    text.setHint(story.getNextPlaceholder());
                }



                if(story.getPlaceholderRemainingCount() == 0 && story.isFilledIn()){
                    Intent intent = new Intent(Activity2.this, Activity3.class);
                    intent.putExtra("story", story.toString());
                    startActivity(intent);

                }
                else{

                    text.getText().clear();

                    TextView word_count = findViewById(R.id.word_count);
                    String words_left = String.valueOf(story.getPlaceholderRemainingCount());
                    word_count.setText((words_left + " " +  "word(s) left"));

                }

            }


        });



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("story",story);
    }
}
