package projetannuel.esgi4moc1.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        appelAsynchrone();

        /*final EditText login = (EditText) findViewById(R.id.login);
        final EditText password =  (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.connexion);*/


    }
}

