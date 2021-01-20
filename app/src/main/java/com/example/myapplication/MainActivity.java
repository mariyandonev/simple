package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkNum();
        setOnClick();
}
    private void setOnClick(){
        final Button btnCheck = (Button)findViewById(R.id.buttonCheck);

         btnCheck.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 final Integer testNum = Integer.parseInt(((EditText)findViewById(R.id.editText1)).getEditableText().toString());
                 setContentView(R.layout.result);

                 TextView result = (TextView)findViewById(R.id.editTextResult);
                 TextView number = (TextView)findViewById(R.id.editText);
                 Button btnResult = (Button)findViewById(R.id.buttonResult);

                 if(num==testNum){
                     number.setText("Congratulations");
                     result.setText("You guessed the number: " + testNum);
                     btnResult.setText("New game");
                     btnResult.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             setContentView(R.layout.activity_main);
                             checkNum();
                             setOnClick();
                         }
                     });
                 }
                 else if(testNum>num) {
                     number.setText("Wrong");
                     result.setText("Try with a lower number.");
                     btnResult.setText("Try again");
                     btnResult.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             setContentView(R.layout.activity_main);
                             setOnClick();
                         }
                     });
                 }
                else if (testNum<num){
                     number.setText("Wrong");
                 result.setText("Try with a higher number.");
                 btnResult.setText("Try again");
                     btnResult.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             setContentView(R.layout.activity_main);
                             setOnClick();
                         }
                     });

             }}

         });

    }

    private void checkNum(){
        num =(int)Math.round( (Math.random()*10));
    }
}




