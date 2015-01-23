package es.tessier.carlos.misproyectos;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Pulsame extends Activity {

    public static final class Parameters {
        public static final String CNT = "CNT";
    }

    private Button boton;
    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsame);

        boton = (Button) findViewById(R.id.botonPulsame);
        refreshBotonText();
    }

    public void onClick(View v) {
        cnt++;
        refreshBotonText();
    }

    private void refreshBotonText() {
        Resources res = getResources();
        String litBoton = "";
        if(cnt == 0) {
            litBoton = res.getString(R.string.pulsame);
        } else {
            litBoton = res.getQuantityString(R.plurals.litPulsame, cnt, cnt);
        }
        boton.setText(litBoton);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(Parameters.CNT, cnt);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        cnt = savedInstanceState.getInt(Parameters.CNT);
        refreshBotonText();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pulsame, menu);
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
}
