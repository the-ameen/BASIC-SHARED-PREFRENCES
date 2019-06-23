package com.ameen.basicsharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etusername,etpass;
    Button btnsave,btnshow;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.result);
        etpass=findViewById(R.id.etpass);
        etusername=findViewById(R.id.etusename);
        btnsave=findViewById(R.id.btnsave);
        btnshow=findViewById(R.id.btnshow);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();
                editor.putString("username",etusername.getText().toString());
                editor.putString("password",etpass.getText().toString());
                editor.apply();
               Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_LONG).show();
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                String user=sharedPref.getString("username","");
                String pass=sharedPref.getString("password","");
                result.setText(user +" \n"+pass);

            }
        });
    }

}
