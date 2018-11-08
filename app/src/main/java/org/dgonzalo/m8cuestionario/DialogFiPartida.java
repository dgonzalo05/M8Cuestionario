package org.dgonzalo.m8cuestionario;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class DialogFiPartida extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setMessage("Has finalizado el juegom quieres volver a empezar?").setTitle("Mensaje del juego")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Fragment PreguntaFragment = new PreguntaFragment();

                        FragmentManager Manager = getFragmentManager();
                        FragmentTransaction Transaction = Manager.beginTransaction();
                        Transaction.replace(R.id.fragment_container,PreguntaFragment);
                        Transaction.addToBackStack(null);
                        Transaction.commit();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return super.onCreateDialog(savedInstanceState);
    }
}

