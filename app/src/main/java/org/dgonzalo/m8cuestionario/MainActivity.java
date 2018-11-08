package org.dgonzalo.m8cuestionario;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements PreguntaFragment.PreguntaFragmentListener{

    public pregunta[] ListPreguntas = new pregunta[]{
            new pregunta(R.string.pregunta1, true, R.drawable.image1),
            new pregunta(R.string.pregunta2, false, R.drawable.image2),
            new pregunta(R.string.pregunta3, true, R.drawable.image3),
    };
    public int indexPregunta = 0;
    private PreguntaFragment.PreguntaFragmentListener mListener;
    PreguntaFragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miToolbar = (Toolbar) findViewById(R.id.toolbar_m8);
        setSupportActionBar(miToolbar);

        FragmentManager fm = getSupportFragmentManager();
        frag = new PreguntaFragment();
        fm.beginTransaction().replace(R.id.fragment_container, frag).commit();

    }
    //@Override
    //public int dibujar_Dialog() {
      //  mi_dialog_fi = new DialogFiPartida();
        //mi_dioalog_fi.show(getSupportFragmentManager(),null);
        //return 0;
    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.cambio_juego:
                //cambio juego
            case R.id.juego1 :
                //juego 1
            case R.id.juego2 :
                //juego 2
            default:
                super.onOptionsItemSelected(item);
        }

        return true;
    }

    public void nextButton(){
        if(indexPregunta < ListPreguntas.length - 1) {
            indexPregunta++;
        }else{
            indexPregunta = 0;
        }
        frag.actualizarPregunta(ListPreguntas[indexPregunta].getPreguntaId());
    }
    public void prevButton(){
        if(indexPregunta > 0) {
            indexPregunta--;
        }else{
            indexPregunta = ListPreguntas.length - 1;
        }
        frag.actualizarPregunta(ListPreguntas[indexPregunta].getPreguntaId());
    }

    public void mostrar_pista(int idimage) {
        Intent intent = new Intent(this,ImageActivity.class);
        intent.putExtra("pista_tag", idimage);
        startActivity(intent);
    }

    public int getPreguntaId(){

        int idpreg = ListPreguntas[indexPregunta].getPreguntaId();
        return idpreg;
    }

    public void checkAnswer(boolean answer) {
        boolean answerIsTrue = ListPreguntas[indexPregunta].isRespPregunta();
        int messageResId = 0;
        if (answer == answerIsTrue) { messageResId = R.string.correct_toast; }
        else { messageResId = R.string.false_toast; }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT) .show();
    }

    @Override
    public void actualizarPregunta(int indexPregunta) {

    }

}
