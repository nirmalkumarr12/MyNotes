package com.example.hanya.starterapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Bundle;
import java.util.*;
/**
 * Created by Hanya on 10/18/2017.
 */

public class NumberListAdapter extends RecyclerView.Adapter<NumberListAdapter.NumberViewHolder> {
    ImageButton img_btn;
    ArrayList<String> input_list;
    NumberListAdapter adapter;
    private int numitems;
    private ListClick s;
    interface ListClick{
        void onListClick(String click);
    }
    public NumberListAdapter(ListClick ls){
        input_list=new ArrayList<String>();
    adapter=this;
        numitems=input_list.size();
        s=ls;
    }
    public void update(String word){
        input_list.add(word);
        numitems=input_list.size();
        adapter.notifyDataSetChanged();
    }
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_list,parent,false);

        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
    holder.bind(position);
    }

    public int getItemCount(){
        return numitems;
    }
    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_number;
        public NumberViewHolder(View itemView) {
            super(itemView);
            img_btn=(ImageButton)itemView.findViewById(R.id.img_delete);
            tv_number=(TextView)itemView.findViewById(R.id.tv_numbers);
            tv_number.setOnClickListener(this);
            img_btn.setOnClickListener(this);

        }
        void bind(int index){
            tv_number.setText(input_list.get(index));
        }

        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.tv_numbers)
            s.onListClick(input_list.get(getAdapterPosition()));
            else if(v.getId()==R.id.img_delete){
                input_list.remove(getAdapterPosition());
                numitems=input_list.size();
                adapter.notifyDataSetChanged();

            }
        }
    }

}
