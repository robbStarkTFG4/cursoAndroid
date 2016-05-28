package ejemplo.mim.com.libreria;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ejemplo.mim.com.libreria.fragments.AgregarFragment;
import ejemplo.mim.com.libreria.fragments.CarritoFragment;
import ejemplo.mim.com.libreria.fragments.MenuFragment;
import ejemplo.mim.com.libreria.fragments.VerFragment;
import ejemplo.mim.com.libreria.local.DaoMaster;
import ejemplo.mim.com.libreria.local.DaoSession;
import ejemplo.mim.com.libreria.local.Libro;
import ejemplo.mim.com.libreria.local.Orden;
import ejemplo.mim.com.libreria.util.interfaces.Navigator;


public class MainActivity extends AppCompatActivity implements Navigator {
    // database objects
    private SQLiteDatabase db;
    private DaoMaster master;
    public DaoSession session;
    private int currentPortablePos;

    //End database objects
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* try {
            DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "mimDb14", null);
            db = openHelper.getWritableDatabase();
            master = new DaoMaster(db);
            session = master.newSession();

            Libro libro = new Libro();
            libro.setAutor("asdasdas");
            libro.setEditorial("dasdas");
            libro.setNombre("dasdasda");
            libro.setSinopsis("dasdasdas");

            session.getLibroDao().insert(libro);

            Log.d("ID_LIBRO", libro.getId().toString());


            Orden or = new Orden();
            or.setCantidad(5);
            or.setCosto(12);
            or.setTotal(5 * 12);
            or.setLibro(libro);

            session.getOrdenDao().insert(or);

            Log.d("ID_ORDEN", or.getId().toString());

        } catch (Exception e) {
            Log.d("d", e.getMessage());
        }*/
        launchMenuFragment();
    }

    private void launchMenuFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.main_content, MenuFragment.newInstance(null, null)).commit();
    }

    @Override
    public void navigate(String name) {
        FragmentManager manager = getSupportFragmentManager();
        switch (name) {
            case "agregar":
                manager.beginTransaction().replace(R.id.main_content, AgregarFragment.newInstance(null,null)).addToBackStack(null).commit();
                break;
            case "ver":
                manager.beginTransaction().replace(R.id.main_content, VerFragment.newInstance(null,null)).addToBackStack(null).commit();
                break;
            case "carrito":
                manager.beginTransaction().replace(R.id.main_content, CarritoFragment.newInstance(null,null)).addToBackStack(null).commit();
                break;
        }
    }
}
