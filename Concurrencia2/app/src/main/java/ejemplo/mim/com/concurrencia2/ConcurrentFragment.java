package ejemplo.mim.com.concurrencia2;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConcurrentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConcurrentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int SELECT_PHOTO = 12312;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView image;


    public ConcurrentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConcurrentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConcurrentFragment newInstance(String param1, String param2) {
        ConcurrentFragment fragment = new ConcurrentFragment();
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

        View view = inflater.inflate(R.layout.fragment_concurrent, container, false);
        Button btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launchTask();
                Log.d("TAREA", "ejecuta tarea");
                //imageTask();
                pickPhoto();
            }
        });

        image = (ImageView) view.findViewById(R.id.imageContainer);

        return view;
    }

    private void pickPhoto() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case SELECT_PHOTO:
                if (resultCode == ((Activity) getContext()).RESULT_OK) {
                    try {
                        final Uri imageUri = data.getData();
                        final InputStream imageStream = ((Activity) getContext()).getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        image.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    private void imageTask() {
        ImageDownloader task = new ImageDownloader(image);
        task.execute("http://science-all.com/images/wallpapers/bear/bear-4.jpg");
    }

    private void launchTask() {

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... params) {
                //tarea que requiere mucho tiempo
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aVoid) {
                super.onPostExecute(aVoid);
                if (aVoid) {
                    Toast.makeText(getContext(), "hola", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }

            @Override
            protected void onCancelled(Boolean aVoid) {
                super.onCancelled(aVoid);
            }
        }.execute();
    }

}
