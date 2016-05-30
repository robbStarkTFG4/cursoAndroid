package ejemplo.mim.com.libreria;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import ejemplo.mim.com.libreria.fragments.AgregarFragment;
import ejemplo.mim.com.libreria.fragments.CarritoFragment;
import ejemplo.mim.com.libreria.fragments.MenuFragment;
import ejemplo.mim.com.libreria.fragments.VerFragment;
import ejemplo.mim.com.libreria.local.DaoMaster;
import ejemplo.mim.com.libreria.local.DaoSession;
import ejemplo.mim.com.libreria.local.Libro;
import ejemplo.mim.com.libreria.local.Orden;
import ejemplo.mim.com.libreria.util.interfaces.Navigator;


public class MainActivity extends AppCompatActivity implements Navigator, AgregarFragment.BookConsumer {
    // database objects
    private SQLiteDatabase db;
    private DaoMaster master;
    public DaoSession session;

    //End database objects
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "mimDb14", null);
            db = openHelper.getWritableDatabase();
            master = new DaoMaster(db);
            session = master.newSession();

        } catch (Exception e) {
            Log.d("d", e.getMessage());
        }
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
                manager.beginTransaction().replace(R.id.main_content, AgregarFragment.newInstance(null, null), "asd").addToBackStack(null).commit();
                break;
            case "ver":
                Holder holder = new Holder();
                holder.setBookList(session.getLibroDao().loadAll());
                manager.beginTransaction().replace(R.id.main_content, VerFragment.newInstance(holder, null)).addToBackStack(null).commit();
                break;
            case "carrito":
                manager.beginTransaction().replace(R.id.main_content, CarritoFragment.newInstance(null, null)).addToBackStack(null).commit();
                break;
            default:
                manager.beginTransaction().replace(R.id.main_content, MenuFragment.newInstance(null, null)).commit();
                manager.beginTransaction().remove(manager.findFragmentByTag("asd"));
                break;
        }
    }

    @Override
    public void consumeBook(Libro libro) {
        session.getLibroDao().insert(libro);
        Toast.makeText(this, String.valueOf(libro.getId()), Toast.LENGTH_LONG).show();
    }
}
