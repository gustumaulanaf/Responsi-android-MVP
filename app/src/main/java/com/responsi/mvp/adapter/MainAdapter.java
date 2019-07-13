package com.responsi.mvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.responsi.mvp.DetailActivity;
import com.responsi.mvp.R;
import com.responsi.mvp.model.ResultsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    List<ResultsItem> resultsItemList;
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public MainAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList = resultsItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ResultsItem resultsItem = resultsItemList.get(position);
        String namaFull = resultsItem.getName().getFirst()+" "+resultsItem.getName().getLast();
        Picasso.with(context).load(resultsItem.getPicture().getThumbnail()).into(holder.img);
        holder.nomor.setText(resultsItem.getPhone());
        holder.email.setText(resultsItem.getEmail());
        holder.nama.setText(namaFull);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("posisi",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (resultsItemList.size() > 0) {
            return resultsItemList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView nama, nomor, email;
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            relativeLayout = itemView.findViewById(R.id.relative1);
            img = itemView.findViewById(R.id.imgPeople);
            nama = itemView.findViewById(R.id.namaPeople);
            nomor = itemView.findViewById(R.id.noHP);
            email = itemView.findViewById(R.id.email);
        }
    }
}
