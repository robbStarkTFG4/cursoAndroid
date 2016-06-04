package ejemplo.mim.com.libreria.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ejemplo.mim.com.libreria.R;
import ejemplo.mim.com.libreria.local.Libro;
import ejemplo.mim.com.libreria.util.interfaces.FragmentLink;

/**
 * Created by marcoisaac on 6/4/2016.
 */
public class LibrosAdapter extends RecyclerView.Adapter<LibrosAdapter.ViewHolder> {

    private final List<Libro> bookList;
    private final Context context;
    private final FragmentLink link;

    public LibrosAdapter(List<Libro> bookList, Context context, FragmentLink link) {
        this.bookList = bookList;
        this.context = context;
        this.link = link;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final FragmentLink link;
        public TextView label;
        public TextView sinopsis;

        private Context context;

        public ViewHolder(LinearLayout v, Context context, FragmentLink link) {
            super(v);
            this.context = context;
            this.link = link;
            v.setOnClickListener(this);
            label = (TextView) v.findViewById(R.id.titulo_ver);
            sinopsis = (TextView) v.findViewById(R.id.sinopsis_ver);
        }

        @Override
        public void onClick(View v) {
            link.linkPosition(getLayoutPosition());
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.libro_item, parent, false);

        ViewHolder vh = new ViewHolder(v, context, link);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Libro libro = bookList.get(position);
        holder.label.setText(libro.getNombre());
        holder.sinopsis.setText(libro.getSinopsis());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

}
