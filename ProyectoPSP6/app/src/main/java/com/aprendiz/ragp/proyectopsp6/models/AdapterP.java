package com.aprendiz.ragp.proyectopsp6.models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.aprendiz.ragp.proyectopsp6.R;

import java.util.List;

public class AdapterP extends RecyclerView.Adapter<AdapterP.Holder> {
    List<Project> projectList;
    private OnItemClickListener mlistener;
    public interface OnItemClickListener{
        void itemClick(int position);
    }

    public AdapterP(List<Project> projectList) {
        this.projectList = projectList;
    }

    public OnItemClickListener getMlistener() {
        return mlistener;
    }

    public void setMlistener(OnItemClickListener mlistener) {
        this.mlistener = mlistener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_proyecto,parent,false);
        Holder holder = new Holder(view,mlistener);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.connectData(projectList.get(position));
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView txtName= itemView.findViewById(R.id.txtNameP) ;
        public Holder(final View itemView, final OnItemClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mlistener!=null){
                        int position = getLayoutPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            listener.itemClick(position);
                        }
                    }
                }
            });
        }


        public void connectData(Project project){
            txtName.setText(project.getName());
        }
    }
}