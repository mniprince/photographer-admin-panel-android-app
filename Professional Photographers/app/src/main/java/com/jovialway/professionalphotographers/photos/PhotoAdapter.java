package com.jovialway.professionalphotographers.photos;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.photopurches.PhotoBuyActivity;
import com.jovialway.professionalphotographers.topbanner.AllApi;
import com.jovialway.professionalphotographers.views.PgProfileActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PhotoAdapter extends  RecyclerView.Adapter<PhotoAdapter.PhotoViewholder>{
    private Context context;
    private List<Photo> photos;
    ArrayList<Photo> arrayList;

    public PhotoAdapter(Context context, List<Photo> photos) {
        this.context = context;
        this.photos = photos;

        this.arrayList = new ArrayList<Photo>();
        this.arrayList.addAll(photos);
    }

    @NonNull
    @Override
    public PhotoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.photo_image,parent,false);
        return new PhotoViewholder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewholder holder, int position) {
        Photo photo=photos.get(position);
        Glide.with(holder.pimage.getContext()).load(AllApi.BASE_URL+"photography/"+photo.getPhotourl()).into(holder.pimage);
        holder.tv.setText(photo.getPrice()+"৳");

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PhotoBuyActivity.class);
                intent.putExtra("id", photo.getId());
                intent.putExtra("pgid", photo.getPgId());
                intent.putExtra("photourl", photo.getPhotourl()).toString();
                intent.putExtra("price", photo.getPrice()).toString();

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class PhotoViewholder extends RecyclerView.ViewHolder {
        ImageView pimage;
        TextView tv;
        View parentView;

        public PhotoViewholder(@NonNull View itemView) {
            super(itemView);
            parentView=itemView;
            pimage = itemView.findViewById(R.id.pimage);
            tv = itemView.findViewById(R.id.tv);

        }
    }

}