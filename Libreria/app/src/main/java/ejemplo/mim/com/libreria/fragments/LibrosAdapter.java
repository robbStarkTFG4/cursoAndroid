package ejemplo.mim.com.libreria.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ejemplo.mim.com.libreria.R;
import ejemplo.mim.com.libreria.local.Libro;

/**
 * Created by marcoisaac on 6/4/2016.
 */
public class LibrosAdapter extends RecyclerView.Adapter<LibrosAdapter.ViewHolder> {

    private final List<Libro> bookList;

    public LibrosAdapter(List<Libro> bookList) {
        this.bookList = bookList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView label;

        public ViewHolder(LinearLayout v) {
            super(v);
            label = (TextView) v.findViewById(R.id.titulo);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.libro_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.label.setText(bookList.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
