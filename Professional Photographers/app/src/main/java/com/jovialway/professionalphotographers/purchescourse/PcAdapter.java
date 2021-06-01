package com.jovialway.professionalphotographers.purchescourse;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jovialway.professionalphotographers.R;
import com.jovialway.professionalphotographers.pcontent.CPhoto;
import com.jovialway.professionalphotographers.topbanner.AllApi;

import java.util.ArrayList;
import java.util.List;

public class PcAdapter extends  RecyclerView.Adapter<PcAdapter.PcViewholder>{
    private Context context;
    private List<PCourse> pCourses;
    ArrayList<PCourse> arrayList;

    public PcAdapter(Context context, List<PCourse> pCourses) {
        this.context = context;
        this.pCourses = pCourses;

        this.arrayList = new ArrayList<PCourse>();
        this.arrayList.addAll(pCourses);
    }

    @NonNull
    @Override
    public PcViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.course_item,parent,false);
        return new PcViewholder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull PcViewholder holder, int position) {
        PCourse pCourse=pCourses.get(position);
        holder.ctitle.setText(pCourse.getCourseTitle());
        holder.cfee.setText(pCourse.getFee());
        holder.cc.setText(pCourse.getTotalClass());

    }

    @Override
    public int getItemCount() {
        return pCourses.size();
    }

    public class PcViewholder extends RecyclerView.ViewHolder {
        TextView cc,cfee,ctitle;

        public PcViewholder(@NonNull View itemView) {
            super(itemView);
            ctitle = itemView.findViewById(R.id.ctitle);
            cfee = itemView.findViewById(R.id.cfee);
            cc = itemView.findViewById(R.id.cc);

        }
    }


}