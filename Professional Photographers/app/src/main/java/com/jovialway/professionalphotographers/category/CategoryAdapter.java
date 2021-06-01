package com.jovialway.professionalphotographers.category;


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
import com.jovialway.professionalphotographers.photos.PhotoActivity;
import com.jovialway.professionalphotographers.topbanner.AllApi;
import com.jovialway.professionalphotographers.views.PgProfileActivity;

import java.util.List;

public class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.CategoryViewholder>{
    private Context context;
    private List<Categorytbl> categorytbl;

    public CategoryAdapter(Context context, List<Categorytbl> categorytbl) {
        this.context = context;
        this.categorytbl = categorytbl;
    }

    @NonNull
    @Override
    public CategoryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.category_image,parent,false);
        return new CategoryViewholder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewholder holder, int position) {
        Categorytbl category=categorytbl.get(position);
        holder.categorytv.setText(category.getCname());
        Glide.with(holder.cimage.getContext()).load(AllApi.BASE_URL+"photography/"+category.getCimage()).into(holder.cimage);

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PhotoActivity.class);
                intent.putExtra("cname", category.getCname());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categorytbl.size();
    }

    public class CategoryViewholder extends RecyclerView.ViewHolder {
        ImageView cimage;
        TextView categorytv;
        View parentView;

        public CategoryViewholder(@NonNull View itemView) {
            super(itemView);
            parentView=itemView;
            cimage = itemView.findViewById(R.id.cimage);
            categorytv = itemView.findViewById(R.id.categorytv);
        }
    }
}