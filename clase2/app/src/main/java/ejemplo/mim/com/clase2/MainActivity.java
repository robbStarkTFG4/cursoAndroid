package ejemplo.mim.com.clase2;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import util.Navigator;
import util.Persona;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener, Navigator {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //setUpFragment2();

    }


    private void setUpFragment2() {
        FragmentManager manager = getSupportFragmentManager();
        //manager.beginTransaction().replace(R.id.main_content, PageThreeFragment.newInstance(null, null)).commit();
    }

    private void setUpFragment() {
        FragmentManager manager = getSupportFragmentManager();
        //manager.beginTransaction().replace(R.id.main_content, BlankFragment.newInstance("clase android", null, new Persona("dasd", 25))).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Snackbar.make(fab, "desde el menu", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //TextView view = (TextView) findViewById(R.id.caja);
                                //view.setTextColor(Color.GREEN);
                            }
                        }).show();
                return true;
            case R.id.action_settings1:
                return true;
            case R.id.action_settings2:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void borraRegistro(String id) {
        Toast.makeText(this, "borra este registro: " + id, Toast.LENGTH_LONG).show();
    }

    @Override
    public void mensaje(String msg) {
        FragmentManager manager = getSupportFragmentManager();
        PageTwoFragment two = (PageTwoFragment) manager.findFragmentById(R.id.layout2);
        two.setMensaje(msg);
    }

    @Override
    public void navigate(String page) {
        FragmentManager manager = getSupportFragmentManager();
        switch (page) {
            case "pagina1":
                break;
            case "pagina2":
                //manager.beginTransaction().replace(R.id.main_content, PageTwoFragment.newInstance(null, null)).commit();
                break;
            case "pagina3":
                //manager.beginTransaction().replace(R.id.main_content, PageThreeFragment.newInstance(null, null)).addToBackStack(null).commit();
                break;
        }
    }
}
