package ejemplo.mim.com.dia1curso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    /**
     * Para archivo xml representando interfaz
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "restart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "DESTROY", Toast.LENGTH_LONG).show();
    }

    /**
     * para recuperar hardware "sensores, camara,etc"
     */
    @Override
    protected void onResume() {
        super.onResume();
        btn = (Button) findViewById(R.id.btn);
       /* btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });*/
        Toast.makeText(this, "resume", Toast.LENGTH_LONG).show();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                Toast.makeText(this, "Soy boton 2", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "start", Toast.LENGTH_LONG).show();
    }
}
