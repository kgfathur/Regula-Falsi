package com.pens.kgf.testfunction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }


    public void menuHitung(View view) {

        Intent intent = new Intent(this, MainRegula.class);
        startActivity(intent);
    }

    public void menuTeori(View view) {

        Intent intent = new Intent(this, Teori.class);
        startActivity(intent);
    }
    public void menuAlgoritma(View view) {

        Intent intent = new Intent(this, Algoritma.class);
        startActivity(intent);
    }
    public void menuFlowchart(View view) {

        Intent intent = new Intent(this, Flowchart.class);
        startActivity(intent);
    }
    public void menuCode(View view) {

        Intent intens = new Intent(Intent.ACTION_VIEW);

        intens.setData(Uri.parse("https://github.com/kgfathur/Regula-Falsi"));
        if(intens.resolveActivity(getPackageManager()) != null) {
            startActivity(intens);
        }
    }
    public void menuShare(View view) {

        Intent inten = new Intent(Intent.ACTION_SENDTO);

        inten.setData(Uri.parse("mailto:emailkamu@gmail.com"));
        inten.putExtra(Intent.EXTRA_SUBJECT, "Download Aplikasi Regula Falsi");
        inten.putExtra(Intent.EXTRA_TEXT, "http://www.kangfathur.te.student.pens.ac.id/RegulaFalsi.apk");
        if(inten.resolveActivity(getPackageManager()) != null) {
            startActivity(inten);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar actions click
        int id = item.getItemId();
        switch (id) {
            case R.id.about:

                Intent inten = new Intent(Intent.ACTION_SENDTO);

                inten.setData(Uri.parse("mailto:sahabatsolder@gmail.com"));
                inten.putExtra(Intent.EXTRA_SUBJECT, "Metode Numerik");
                inten.putExtra(Intent.EXTRA_TEXT, "Saya Sangat Senang Dengan Metode Numerik");
                if(inten.resolveActivity(getPackageManager()) != null) {
                    startActivity(inten);
                }

                break;
            case R.id.help:

                Intent intens = new Intent(Intent.ACTION_VIEW);

                intens.setData(Uri.parse("http://kangfathur.te.student.pens.ac.id"));
                if(intens.resolveActivity(getPackageManager()) != null) {
                    startActivity(intens);
                }

                break;
            case R.id.home:
                Intent intent = new Intent(this, MainHome.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
