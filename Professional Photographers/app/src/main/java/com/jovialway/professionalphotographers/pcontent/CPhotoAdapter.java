package com.jovialway.professionalphotographers.pcontent;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.topbanner.AllApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CPhotoAdapter extends  RecyclerView.Adapter<CPhotoAdapter.CPhotoViewholder>{
    private Context context;
    private List<CPhoto> cphotos;
    ArrayList<CPhoto> arrayList;

    public CPhotoAdapter(Context context, List<CPhoto> cphotos) {
        this.context = context;
        this.cphotos = cphotos;

        this.arrayList = new ArrayList<CPhoto>();
        this.arrayList.addAll(cphotos);
    }

    @NonNull
    @Override
    public CPhotoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.photo_content,parent,false);
        return new CPhotoViewholder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull CPhotoViewholder holder, int position) {
        CPhoto cphoto=cphotos.get(position);
        Glide.with(holder.pimage.getContext()).load(AllApi.BASE_URL+"photography/"+cphoto.getPhotourl()).into(holder.pimage);

    }

    @Override
    public int getItemCount() {
        return cphotos.size();
    }

    public class CPhotoViewholder extends RecyclerView.ViewHolder {
        ImageView pimage;

        public CPhotoViewholder(@NonNull View itemView) {
            super(itemView);
            pimage = itemView.findViewById(R.id.cimage);

        }
    }


}