package de.eestec_kl.IntentExample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    String TAG = "EESTEC";
    int REQ_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_press = (Button)findViewById(R.id.btn_press);

        btn_press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//      3 lines below is explicit use of intent for calling second activity
                Intent callSecondAct = new Intent();
                callSecondAct.setClass(getApplicationContext(), SecondActivity.class);
                startActivity(callSecondAct);

//      3 lines below is explicit use of intent for calling second activity for result
//                Intent callSecondAct = new Intent();
//                callSecondAct.setClass(getApplicationContext(), SecondActivity.class);
//                startActivityForResult(callSecondAct,REQ_CODE);

//      Five line below is for implicit use of Intent for calling web browser to open an address
//                String url = "http://www.eestec-kl.de";
//                Intent i = new Intent();
//                i.setAction(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);

            }
        });

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQ_CODE) {
            if(resultCode == RESULT_OK){
                String result=data.getStringExtra("result");
                Toast.makeText(getApplication(),result,Toast.LENGTH_SHORT).show();
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
