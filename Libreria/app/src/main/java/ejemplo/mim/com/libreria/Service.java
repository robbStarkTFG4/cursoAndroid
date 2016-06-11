package ejemplo.mim.com.libreria;

import java.util.List;

import ejemplo.mim.com.libreria.local.Libro;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by marcoisaac on 6/4/2016.
 */
public interface Service {
    public static final String BASE_URL = "http://night-contactres.rhcloud.com/WebApplication1/webresources/";

    @GET("com.curso.entities.libro")
    public Call<List<ejemplo.mim.com.libreria.remote.Libro>> getLibros();

    @POST("com.curso.entities.libro")
    public Call<Response> addBook(Libro lib);

    @PUT("com.curso.entities.libro/{id}")
    public Call<Response> editBook(@Path("id") int id, Libro libro);

    @DELETE("com.curso.entities.libro/{id}")
    public Call<Response> editBook(@Path("id") int id);


    @GET("com.curso.entities.ordenes")
    public Call<List<ejemplo.mim.com.libreria.remote.Ordenes>> getOrdenes();


}
