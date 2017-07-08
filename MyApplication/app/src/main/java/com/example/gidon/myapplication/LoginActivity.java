package com.example.gidon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private static final String API_URL = "http://10.0.2.2:8000" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Declaration des vues
        final EditText login = (EditText) findViewById(R.id.login);
        final EditText password =  (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.connexion);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Create a very simple REST adapter which points the GitHub API.
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                // Create an instance of our GitHub API interface.
                final MyService myService = retrofit.create(MyService.class);

                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try  {
                            // Create a call instance for looking up Retrofit contributors.
                            Call<List<User>> call = myService.user();


                            // Fetch and print a list of the Sensor to the library.
                            List<User> users = null;
                            try {
                                users = call.execute().body();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            for (User user : users) {

                                if(user.getPseudo().equals(login.getText().toString()) && user.getPassword().equals(password.getText().toString())){
                                    Intent intent = new Intent(LoginActivity.this,StatsActivity.class);
                                    startActivity(intent);
                                }
                                else{
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            Toast.makeText(getBaseContext(),"Identifiants incorrects",Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                });
                thread.start();

            }


        });


    }

}
