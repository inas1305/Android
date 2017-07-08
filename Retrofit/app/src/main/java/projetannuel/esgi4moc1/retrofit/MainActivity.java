package projetannuel.esgi4moc1.retrofit;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText login = (EditText) findViewById(R.id.login);
        final EditText password =  (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.connexion);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DistributorService distributorService = new RestAdapter.Builder()
                        .setEndpoint(DistributorService.ENDPOINT)
                        .setLogLevel(RestAdapter.LogLevel.FULL)
                        .build()
                        .create(DistributorService.class);

                distributorService.listUser(new Callback<List<User>>() {
                    @Override
                    public void success(List<User> users, Response response) {
                        boolean trouve = false;
                        for(User user: users){
                            if(user.getPseudo().equals(login.getText().toString()) && user.getPassword().equals(password.getText().toString())){
                                trouve = true;
                                setContentView(R.layout.activity_sensor);
                                break;
                            }
                        }
                        if(!trouve){
                            Toast.makeText(MainActivity.this, "Identifiants incorrects", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });



    }


    public void afficherUser(List<User> user) {
        Toast.makeText(this, "nombre de users : " + user.size(), Toast.LENGTH_SHORT).show();
    }

    public void notAllowed() {
        Toast.makeText(this, "Impossible d'effectuer cette action", Toast.LENGTH_SHORT).show();
    }

    }
