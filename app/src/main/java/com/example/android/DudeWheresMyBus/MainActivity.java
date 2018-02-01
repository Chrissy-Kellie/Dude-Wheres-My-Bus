package com.example.android.DudeWheresMyBus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    //adding variables
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning variables to XML layout
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.Info);
        Login = (Button)findViewById(R.id.buttonLogin);

        Info.setText("Number of attempts remaining: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //compare variable to user input to validate
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });


    }

    //function to validate is password is correct
    private void validate(String userName, String userPassword){
        if((userName.equals("Hello")) && (userPassword.equals("1234"))){
            //if correct, go to the next activity
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            //if not correct, login button will disable after 3 attempts
        }else{
            counter--;

            Info.setText(MessageFormat.format("Number of attempts remaining: {0}", String.valueOf(counter)));

            if(counter == 0){
                Login.setEnabled(false);
            }

        }
    }
}
