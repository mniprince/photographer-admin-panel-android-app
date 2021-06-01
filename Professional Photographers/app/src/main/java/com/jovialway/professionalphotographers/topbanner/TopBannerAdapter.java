package com.jovialway.professionalphotographers.topbanner;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.jovialway.professionalphotographers.MainActivity;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.photos.PhotoActivity;

import java.util.List;

public class TopBannerAdapter extends  RecyclerView.Adapter<TopBannerAdapter.BannerViewholder>{
    private Context context;
    private List<Topbanner> topbanners;

    public TopBannerAdapter(Context context, List<Topbanner> topbanners) {
        this.context = context;
        this.topbanners = topbanners;
    }

    @NonNull
    @Override
    public BannerViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.top_b_image,parent,false);
        return new BannerViewholder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull BannerViewholder holder, int position) {
        Topbanner topbanner=topbanners.get(position);
        Glide.with(holder.imageView.getContext()).load(AllApi.BASE_URL+"photography/"+topbanner.getBannerimage()).into(holder.imageView);

//        holder.parentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentp=new Intent(context, PhotoActivity.class);
//                context.startActivity(intentp);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return topbanners.size();
    }

    public class BannerViewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        View parentView;
        public BannerViewholder(@NonNull View itemView) {
            super(itemView);
            parentView=itemView;
            imageView = itemView.findViewById(R.id.image);
        }
    }
}