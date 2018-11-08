package org.dgonzalo.m8cuestionario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    ImageView pista;
    int res_pista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        res_pista = getIntent().getIntExtra("pista_tag",0);

        pista = findViewById(R.id.id_pista);
        pista.setImageResource(res_pista);
    }
}
