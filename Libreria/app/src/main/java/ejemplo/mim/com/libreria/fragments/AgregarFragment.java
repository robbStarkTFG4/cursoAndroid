package ejemplo.mim.com.libreria.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ejemplo.mim.com.libreria.R;
import ejemplo.mim.com.libreria.local.Libro;
import ejemplo.mim.com.libreria.util.interfaces.Navigator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private BookConsumer consumer;
    private Navigator navigator;


    public AgregarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgregarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarFragment newInstance(String param1, String param2) {
        AgregarFragment fragment = new AgregarFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar, container, false);

        final EditText nombre = (EditText) view.findViewById(R.id.nombre_field_agregar);
        final EditText autor = (EditText) view.findViewById(R.id.autor_field_agregar);
        final EditText sinopsis = (EditText) view.findViewById(R.id.sinopsis_field_agregar);
        final EditText editorial = (EditText) view.findViewById(R.id.editorial_field_agregar);


        Button btn = (Button) view.findViewById(R.id.guardar_agregar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editable name = nombre.getText();
                Editable aut = autor.getText();
                Editable sinop = sinopsis.getText();
                Editable edito = editorial.getText();
                if (name.length() > 0 && aut.length() > 0 && sinop.length() > 0 && edito.length() > 0) {
                    Toast.makeText(getContext(), "guardando...", Toast.LENGTH_SHORT).show();
                    Libro lib = new Libro();
                    lib.setNombre(name.toString());
                    lib.setAutor(aut.toString());
                    lib.setSinopsis(sinop.toString());
                    lib.setEditorial(edito.toString());
                    consumer.consumeBook(lib);
                    navigator.navigate("dasdas");

                } else {
                    AlertDialog alert = new AlertDialog.Builder(getContext())
                            .setMessage("escribe todos los datos").setPositiveButton("ok", null).create();
                    alert.show();
                    alert.setCanceledOnTouchOutside(false);
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BookConsumer) {
            consumer = (BookConsumer) context;
            navigator = (Navigator) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        consumer = null;
    }

    public interface BookConsumer {
        public void consumeBook(Libro libro);
    }
}
