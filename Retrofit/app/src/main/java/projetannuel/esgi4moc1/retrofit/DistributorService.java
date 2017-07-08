package projetannuel.esgi4moc1.retrofit;

/**
 * Created by inas on 08/07/2017.
 */

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit.http.Query;

public interface DistributorService {

    public static final String ENDPOINT = "http://10.0.2.2:8000/api";


    @GET("/user")
    void listUser(Callback<List<User>> callback);

    @GET("/sensors")
    void listSensors(Callback<List<Sensors>> callback);


}