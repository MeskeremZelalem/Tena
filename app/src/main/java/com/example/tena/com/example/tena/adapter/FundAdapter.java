package com.example.tena.com.example.tena.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tena.R;
import com.example.tena.com.example.tena.activity.RequestItem;

import java.util.ArrayList;
import java.util.List;

public class FundAdapter extends RecyclerView.Adapter<FundAdapter.FundViewAdapter> implements Filterable {


    Context context;
    List<RequestItem> data;
    List<RequestItem> dataFiltered;

    public FundAdapter(Context context, List<RequestItem> data) {
        this.context = context;
        this.data = data;
        this.dataFiltered = data;
    }

    @NonNull
    @Override
    public FundViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(context).inflate(R.layout.item_request, parent,false);
        return new FundViewAdapter(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull FundViewAdapter holder, int position) {

        //animation

        holder.image.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transtion_animation));
        holder.ll_container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transtion_animation));

        holder.tv_title.setText(dataFiltered.get(position).getTitle());
        holder.tv_age.setText(dataFiltered.get(position).getAge());
        holder.tv_detail.setText(dataFiltered.get(position).getDescription());
        holder.tv_amount.setText(dataFiltered.get(position).getAmount());
        holder.image.setImageResource(dataFiltered.get(position).getPatientImage());
    }

    @Override
    public int getItemCount() {
        return dataFiltered.size();
    }

    @Override
    public  Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String key = charSequence.toString();
                if(key.isEmpty()){
                    dataFiltered = data;
                }
                else {
                    List<RequestItem> listFiltered = new ArrayList<>();
                    for (RequestItem row : data){
                        if (row.getTitle().toLowerCase().contains(key.toLowerCase())){
                            listFiltered.add(row);
                        }
                    }
                    dataFiltered = listFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = dataFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                dataFiltered = (List<RequestItem>)filterResults.values;
                notifyDataSetChanged();

            }
        };
    }

    public class FundViewAdapter extends RecyclerView.ViewHolder {

        TextView tv_title , tv_age , tv_detail  , tv_amount;
        ImageView image;
        LinearLayout ll_container;

        public FundViewAdapter(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_age = itemView.findViewById(R.id.tv_age);
            tv_detail = itemView.findViewById(R.id.tv_detail);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            image = itemView.findViewById(R.id.image);
            ll_container = itemView.findViewById(R.id.container);
        }
    }
}
