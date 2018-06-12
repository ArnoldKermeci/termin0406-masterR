package rs.aleph.android.example12.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.fragments.ListFragment;

public class JeloAdapter extends RecyclerView.Adapter<JeloAdapter.ViewHolder> {
    private List<String> fruits;
    private ListFragment.OnItemSelectedListener listener;

    public JeloAdapter(ListFragment.OnItemSelectedListener listener, List<String> fruits) {
        this.fruits = fruits;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_jelo_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;
        holder.textView.setText(fruits.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemSelected(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.text);
        }
    }
}
