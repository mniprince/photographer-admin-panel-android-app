package com.jovialway.professionalphotographers.purchesphoto;


import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.pcontent.CPhoto;
import com.jovialway.professionalphotographers.topbanner.AllApi;
import com.jovialway.professionalphotographers.views.PgProfileActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PAdapter extends  RecyclerView.Adapter<PAdapter.PPhotoViewholder>{
    private Context context;
    private List<PPhoto> pphotos;
    ArrayList<PPhoto> arrayList;


    public PAdapter(Context context, List<PPhoto> pphotos) {
        this.context = context;
        this.pphotos = pphotos;

        this.arrayList = new ArrayList<PPhoto>();
        this.arrayList.addAll(pphotos);
    }

    @NonNull
    @Override
    public PPhotoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.p_image,parent,false);
        return new PPhotoViewholder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull PPhotoViewholder holder, int position) {
        PPhoto pphoto=pphotos.get(position);
        Glide.with(holder.pcimage.getContext()).load(AllApi.BASE_URL+"photography/"+pphoto.getPhotourl()).into(holder.pcimage);

    }



    @Override
    public int getItemCount() {
        return pphotos.size();
    }

    public class PPhotoViewholder extends RecyclerView.ViewHolder {
        ImageView pcimage,dload;

        public PPhotoViewholder(@NonNull View itemView) {
            super(itemView);
            pcimage = itemView.findViewById(R.id.pcimage);
            dload = itemView.findViewById(R.id.dload);

        }
    }


}