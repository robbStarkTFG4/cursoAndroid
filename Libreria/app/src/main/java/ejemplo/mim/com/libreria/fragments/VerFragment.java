package ejemplo.mim.com.libreria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ejemplo.mim.com.libreria.Holder;
import ejemplo.mim.com.libreria.R;
import ejemplo.mim.com.libreria.local.Libro;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Libro> bookList;


    public VerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VerFragment newInstance(Holder param1, String param2) {
        VerFragment fragment = new VerFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bookList = ((Holder) getArguments().getSerializable(ARG_PARAM1)).getBookList();
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        for (Libro lib : bookList) {
            Toast.makeText(getContext(), lib.getNombre(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ver, container, false);
    }

}
