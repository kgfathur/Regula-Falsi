package com.pens.kgf.testfunction;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainRegula extends ListActivity {

    Button hitung, bersih;
    ImageView bgfalsi;
    EditText txtBawah, txtAtas, txtIterasi, txtError;
    TextView akar, error;
    float nBB, nBA, nError, hasilError, nAkar, xi[], fxi[], fbai[], fbbi[];
    int nIterasi;


    DecimalFormat precision = new DecimalFormat("0.00000");

    public static float Fx(float x) {
        float hasil;
        hasil = (float) Math.exp(-x) - x;
        return hasil;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_13);

        bgfalsi = (ImageView) findViewById(R.id.bgregulafalsi);
        txtAtas = (EditText) findViewById(R.id.text_bAtas);
        txtBawah = (EditText) findViewById(R.id.text_bBawah);
        txtIterasi = (EditText) findViewById(R.id.text_nIterasi);
        txtError = (EditText) findViewById(R.id.text_nError);

        akar = (TextView) findViewById(R.id.txtHasilAkar);
        error = (TextView) findViewById(R.id.txtHasilError);

        hitung = (Button) findViewById(R.id.btn_calc);
        bersih = (Button) findViewById(R.id.btn_reset);
        bersih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgfalsi.setVisibility(View.VISIBLE);
                EditText txt_bAtas = (EditText) findViewById(R.id.text_bAtas);
                txt_bAtas.setText("");
                EditText txt_bBawah = (EditText) findViewById(R.id.text_bBawah);
                txt_bBawah.setText("");
                EditText txt_nError = (EditText) findViewById(R.id.text_nError);
                txt_nError.setText("");
                EditText txt_nIterasi = (EditText) findViewById(R.id.text_nIterasi);
                txt_nIterasi.setText("");
                akar.setText("Nilai x = ");
                error.setText("Nilai Error = ");
                xi = new float[1];
                fxi = new float[1];
                fbai = new float[1];
                fbbi = new float[1];
                generateData().clear();
                setListAdapter(null);
            }
        });

        hitung.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    bgfalsi.setVisibility(View.INVISIBLE);
                    nBA = Float.parseFloat(txtAtas.getText().toString());
                    nBB = Float.parseFloat(txtBawah.getText().toString());
                    nIterasi = Integer.parseInt(txtIterasi.getText().toString());
                    nError = Float.parseFloat(txtError.getText().toString());

                    xi = new float[nIterasi + 1];
                    fxi = new float[nIterasi + 1];
                    fbai = new float[nIterasi + 1];
                    fbbi = new float[nIterasi + 1];

                    generateData().clear();
                    setListAdapter(null);
                    nBA = Float.parseFloat(txtAtas.getText().toString());
                    nBB = Float.parseFloat(txtBawah.getText().toString());
                    if (Fx(nBA) * Fx(nBB) < 0) {

                        MyAdapter adapter = new MyAdapter(getApplicationContext(), generateData());
                        setListAdapter(adapter);

                        akar.setText("Nilai x = " + String.valueOf(precision.format(nAkar)));
                        error.setText("Nilai Error = " + String.valueOf(precision.format(hasilError)) + " %");
                    } else {
                        bgfalsi.setVisibility(View.VISIBLE);
                        Toast.makeText(getApplicationContext(), "Tidak Ada Akar\nAkar tidak ada pada range " + nBB + " sampai " + nBA, Toast.LENGTH_SHORT).show();
                        akar.setText("Nilai x = TIDAK ADA AKAR");
                        error.setText("Nilai Error = Error!!!");
                    }


                } catch (NumberFormatException e) {
                    bgfalsi.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Error :\nSilahkan isi data dengan angka", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public ArrayList<Model> generateData() {
        ArrayList<Model> models = new ArrayList<Model>();
        for (int i = 0; i <= nIterasi; i++) {

            fbai[i] = Fx(nBA);
            fbbi[i] = Fx(nBB);
            xi[i] = ((fbai[i] * nBB) - (fbbi[i] * nBA)) / (fbai[i] - fbbi[i]);
            fxi[i] = Fx(xi[i]);
            models.add(new Model(
                    String.valueOf(i + 1),
                    String.valueOf(precision.format(nBB)),
                    String.valueOf(precision.format(nBA)),
                    String.valueOf(precision.format(xi[i])),
                    String.valueOf(precision.format(fxi[i]))));

            hasilError = Math.abs(fxi[i]);
            nAkar = xi[i];
            if (fxi[i] * fbbi[i] < 0) {
                nBA = xi[i];
            } else if (fxi[i] * fbbi[i] > 0) {
                nBB = xi[i];
            } else if (fxi[i] * fbai[i] == 0) {
                nAkar = xi[i];
            }
            nAkar = xi[i];
            if (Math.abs(fxi[i]) < nError) {
                i = nIterasi;
            }
        }
        return models;
    }

}
