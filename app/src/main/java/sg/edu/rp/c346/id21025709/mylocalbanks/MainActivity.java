package sg.edu.rp.c346.id21025709.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String bankClicked = "";
    String url = "";
    String phoneNo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == tvDBS) {
            bankClicked = "DBS";
        } else if (v == tvOCBC) {
            bankClicked = "OCBC";
        } else if (v == tvUOB) {
            bankClicked = "UOB";
        } else {
            bankClicked = "";
        }
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView tvSelected = null;
        if (bankClicked.equalsIgnoreCase("DBS")) {
            url = "https://www.dbs.com.sg";
            phoneNo = "18001111111";
            tvSelected = tvDBS;

        } else if (bankClicked.equalsIgnoreCase("OCBC")) {
            url = "https://www.ocbc.com";
            phoneNo = "18003633333";
            tvSelected = tvOCBC;

        } else if (bankClicked.equalsIgnoreCase("UOB")) {
            url = "https://www.uob.com.sg";
            phoneNo = "18002222121";
            tvSelected = tvUOB;

        } else {
            url = "";
            phoneNo = "";
        }

        if (item.getItemId() == 0) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } else if (item.getItemId() == 1) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNo));
            startActivity(intent);
        }

        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;

        } else if (item.getItemId() == R.id.ChineseSelection) {
            tvDBS.setText(getString(R.string.dbs_c));
            tvOCBC.setText(getString(R.string.ocbc_c));
            tvUOB.setText(getString(R.string.uob_c));
            return true;
        } else {
        Log.e("onOptionsItemSelected", "Error, neither English nor Chinese");
    }
        return super.onOptionsItemSelected(item);
    }
}



