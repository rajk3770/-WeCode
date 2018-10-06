package bhumil.test.minutes;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by bhumil on 27/5/18.
 */

public class summary_adapter extends RecyclerView.Adapter<summary_adapter.ViewHolder> {

    private List<helper> listItems;
    private Context context;

    public summary_adapter(List<helper> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardsummary,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final helper listItem = listItems.get(position);
        holder.head.setText(listItem.getHead());

        holder.radio_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.radio_off.getVisibility() == View.VISIBLE){
                    holder.radio_off.setVisibility(View.GONE);
                    holder.radio_on.setVisibility(View.VISIBLE);
                    holder.head.setPaintFlags(holder.head.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else{
                    holder.radio_on.setVisibility(View.GONE);
                    holder.radio_off.setVisibility(View.VISIBLE);
                    holder.head.setPaintFlags(holder.head.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView head;
        private Button radio_off;
        private Button radio_on;
        public ViewHolder(View itemView) {
            super(itemView);

            head = itemView.findViewById(R.id.places_name);
            radio_off = itemView.findViewById(R.id.button5);
            radio_on = itemView.findViewById(R.id.button7);
        }
    }
}