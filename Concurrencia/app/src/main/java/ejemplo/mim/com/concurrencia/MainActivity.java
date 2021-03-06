package ejemplo.mim.com.concurrencia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView text;
    static int cantidad = 0;
    static int cantidad2 = 0;
    static boolean control = true;
    static boolean control2 = true;
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("HILO", "ejecute tarea: " + cantidad++);
            text.setText("hola!!!!!!!  " + cantidad);
            callThread();
        }
    };

    private void callThread() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                Log.d("CADENA", "TAREA DEPENDIENTE");
            }
        };
        thread.start();
    }

    private final Handler handler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("HILO", "ejecute tarea: " + cantidad2++);
            text2.setText("hola 2!!!!!!!  " + cantidad2);
        }
    };
    private Thread thread;
    private Thread thread2;
    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        text = (TextView) findViewById(R.id.texto);
        text2 = (TextView) findViewById(R.id.texto2);
        //Thread thread = new Thread(new ProcesoLargo());

        thread = getThread();
        thread2 = getThread2();


        Button btnStart = (Button) findViewById(R.id.start_btn);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thread.getState() == Thread.State.NEW) {
                    thread.start();
                } else {
                    Log.d("DASDAS", "DSADAS");
                    control = true;
                    thread = getThread();
                    thread.start();
                }
            }
        });

        Button btnStop = (Button) findViewById(R.id.stop_btn);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control = false;
            }
        });

        Button btnStart2 = (Button) findViewById(R.id.start_btn2);
        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thread2.getState() == Thread.State.NEW) {
                    thread2.start();
                } else {
                    Log.d("ASDAS", "DSADAS");
                    control2 = true;
                    thread2 = getThread2();
                    thread2.start();
                }
            }
        });

        Button btnStop2 = (Button) findViewById(R.id.stop_btn2);
        btnStop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control2 = false;
            }
        });
    }

    @NonNull
    private Thread getThread() {
        return new Thread() {
            @Override
            public void run() {
                while (control) {
                    try {
                        sleep(1000);
                        handler.sendMessage(new Message());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    @NonNull
    private Thread getThread2() {
        return new Thread() {
            @Override
            public void run() {
                while (control2) {
                    try {
                        sleep(500);
                        handler2.sendMessage(new Message());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private class ProcesoLargo implements Runnable {

        @Override
        public void run() {
            while (true) {
                //tarea sincrona que requiera mucho tiempo
                handler.sendMessage(new Message());
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
