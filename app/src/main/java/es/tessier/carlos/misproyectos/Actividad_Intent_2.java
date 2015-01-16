package es.tessier.carlos.misproyectos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Actividad_Intent_2 extends Activity {

    public static final int ACTIVIDAD_INTENT_2_2_REQUEST_CODE = 1;
    public static final String RESULTADO_INTENT_2_2 = "RESULTADO_INTENT_2_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_intent_2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_intent_2, menu);
        return true;
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Actividad_Intent_2_2.class);
        startActivityForResult(intent, ACTIVIDAD_INTENT_2_2_REQUEST_CODE);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVIDAD_INTENT_2_2_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                String resultado = data.getStringExtra(RESULTADO_INTENT_2_2);
                Toast.makeText(this, "Vuelve de la actividad 2: " + resultado, Toast.LENGTH_LONG).show();
            }
        }
    }
}
