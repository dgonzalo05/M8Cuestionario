package org.dgonzalo.m8cuestionario;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PreguntaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button TrueButton,FalseButton,prevButton,nextButton, b_pista;
    private TextView pregunta_view;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private PreguntaFragmentListener mListener;

    public PreguntaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PreguntaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PreguntaFragment newInstance(String param1, String param2) {
        PreguntaFragment fragment = new PreguntaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View VistaFragment = inflater.inflate(R.layout.fragment_container, container);

        TrueButton = (Button) VistaFragment.findViewById(R.id.correct_button);
        FalseButton = (Button) VistaFragment.findViewById(R.id.false_button);
        nextButton = (Button) VistaFragment.findViewById(R.id.next_button);
        prevButton = (Button) VistaFragment.findViewById(R.id.prev_button);
        b_pista = (Button) VistaFragment.findViewById(R.id.pista_button);
        pregunta_view = (TextView) VistaFragment.findViewById(R.id.pregunta);
        TrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.checkAnswer(true);

            }

        });

        FalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.checkAnswer(false);
            }

        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.nextButton();
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.prevButton();
            }
        });

        b_pista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.mostrar_pista(mListener.getPreguntaId());
            }
        });
        return VistaFragment;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PreguntaFragmentListener) {
            mListener = (PreguntaFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public void actualizarPregunta(int idTextoPregunta){
        pregunta_view.setText(getString(idTextoPregunta));
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PreguntaFragmentListener {
        // TODO: Update argument type and name
        void checkAnswer(boolean answer);
        void actualizarPregunta(int indexPregunta);
        int getPreguntaId();
        void mostrar_pista(int idimage);
        void nextButton();
        void prevButton();
    }
}
