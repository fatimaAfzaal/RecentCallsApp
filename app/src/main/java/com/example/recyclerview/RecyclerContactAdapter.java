package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    private RecyclerViewClickListener listener;
    ArrayList<ContactModel> arrContacts;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts,RecyclerViewClickListener listener)
    {
        this.context=context;
        this.arrContacts=arrContacts;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

       View view= LayoutInflater.from(context).inflate(R.layout.contactview_row,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.imgContact.setImageResource(arrContacts.get(i).img);
        holder.imgCon.setImageResource(arrContacts.get(i).call);
        holder.txt_name.setText(arrContacts.get(i).name);
        holder.txt_no.setText(arrContacts.get(i).no);
        holder.txt_day.setText(arrContacts.get(i).day);
    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View view,int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txt_name,txt_no,txt_day;
        ImageView imgContact,imgCon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name= itemView.findViewById(R.id.textView3);
            txt_no= itemView.findViewById(R.id.textView4);
            txt_day= itemView.findViewById(R.id.textView5);
            imgContact=itemView.findViewById(R.id.imageView2);
            imgCon=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());

        }
    }


}
