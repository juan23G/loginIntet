package com.example.loginintet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textEmail, textContraseña;
    private Button botonIngresar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ocultamos la barra de titulo
        getSupportActionBar().hide();

        this.cargarComponentes();



    }

    private void cargarComponentes() {

        textEmail = findViewById(R.id.textEmail);
        textContraseña = findViewById(R.id.textcontraseña);

        botonIngresar = findViewById(R.id.botonIngresar);


        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuario();


            }
        });
    }


    private void validarUsuario() {
        String email = textEmail.getText().toString();
        String contraseña = textContraseña.getText().toString();

        if (email.equals("ites") && contraseña.equals("1234")) {

            Intent intent = new Intent(MainActivity.this, homeActivity.class);

            intent.putExtra("EXTRA_EMAIL", email);

            startActivity(intent);

        } else {
            Toast.makeText(this, "datos incorrectos, reintente", Toast.LENGTH_SHORT).show();
        }
    }
}
