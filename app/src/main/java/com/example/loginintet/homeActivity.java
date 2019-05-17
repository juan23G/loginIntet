package com.example.loginintet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class homeActivity extends AppCompatActivity {

    private EditText editUrl, editTelefono;
    private Button botonUrl, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String email = bundle.getString("EXTRA_EMAIL");

        setTitle("Bienvenido " + email);         // genero un titulo de forma dinamica



    }

    private void cargarComponentes(){
        editUrl = findViewById(R.id.editTelefono);
        editTelefono = findViewById(R.id.editUrl);
        botonUrl = findViewById(R.id.botonUrl);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarTelefono();
            }
        });

        botonUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarWeb();
            }

        });


    }
    private void lanzarTelefono(){

        String Telefono = editTelefono.getText().toString();

        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://" + Telefono));
        startActivity(i);
    }

    private void lanzarWeb(){
        String url = editUrl.getText().toString();

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + url));

        startActivity(i);
    }
}
