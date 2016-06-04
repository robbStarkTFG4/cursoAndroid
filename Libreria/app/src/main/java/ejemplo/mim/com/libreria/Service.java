package ejemplo.mim.com.libreria;

import ejemplo.mim.com.libreria.local.Libro;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by marcoisaac on 6/4/2016.
 */
public interface Service {
    public static final String BASE_URL = "http://night-contactres.rhcloud.com/WebApplication1/webresources/";

    @GET("com.curso.entities.libro/libs")
    public Call<String> getLibros();
}
