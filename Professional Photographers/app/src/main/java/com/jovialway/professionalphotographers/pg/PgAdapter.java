package com.jovialway.professionalphotographers.pg;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.topbanner.AllApi;
import com.jovialway.professionalphotographers.topbanner.Topbanner;
import com.jovialway.professionalphotographers.views.PgProfileActivity;

import java.util.List;

public class PgAdapter extends  RecyclerView.Adapter<PgAdapter.PgViewholder>{
    private Context context;
    private List<Pg> photographer;

    public PgAdapter(Context context, List<Pg> photographers) {
        this.context = context;
        this.photographer = photographers;
    }

    @NonNull
    @Override
    public PgViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.pg_image,parent,false);
        return new PgViewholder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull PgViewholder holder, int position) {
        Pg photographers = photographer.get(position);
        holder.name.setText(photographers.getPgName());
        holder.locationtv.setText(photographers.getPgLocation());
        Glide.with(holder.pgimage.getContext()).load(AllApi.BASE_URL+"photography/"+photographers.getPgImage()).into(holder.pgimage);

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PgProfileActivity.class);
                intent.putExtra("pgimage", photographers.getPgImage());
                intent.putExtra("pgid", photographers.getPgId());
                intent.putExtra("pgname", photographers.getPgName()).toString();
                intent.putExtra("category", photographers.getCategory()).toString();
                intent.putExtra("pgmail", photographers.getPgEmail()).toString();
                intent.putExtra("location", photographers.getPgLocation()).toString();
                intent.putExtra("like", photographers.getPgLike()).toString();

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photographer.size();
    }

    public class PgViewholder extends RecyclerView.ViewHolder {
        ImageView pgimage;
        TextView locationtv,name;
        View parentView;

        public PgViewholder(@NonNull View itemView) {
            super(itemView);
            parentView=itemView;
            pgimage = itemView.findViewById(R.id.pgimage);

            name = itemView.findViewById(R.id.name);
            locationtv = itemView.findViewById(R.id.locationtv);
        }
    }
}