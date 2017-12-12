package com.example.vishvendu.nyctopnews.view;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vishvendu.nyctopnews.Callbacks.IPassViewToActivity;
import com.example.vishvendu.nyctopnews.R;
import com.example.vishvendu.nyctopnews.database.TopNewsData;
import com.example.vishvendu.nyctopnews.model.Result;

import com.example.vishvendu.nyctopnews.presenter.ITopStoriesPresenter;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by vishvendu on 12/12/17.
 */

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MyViewHolder>{

    List<Result> TopNewsResultList;
    List<TopNewsData> TopNewsOfflineResultList;
    private Context context ;
    private int itemLayout;
    IPassViewToActivity mCallback;
    boolean isNetwork;

    public CardViewAdapter(MainActivity mainActivity, int cards, IPassViewToActivity iPassViewToActivity) {

        this.context = mainActivity;
        this.itemLayout = cards;
        this.mCallback = iPassViewToActivity;

        TopNewsResultList = new ArrayList<>() ;
        TopNewsOfflineResultList = new ArrayList<>();
    }

    @Override
    public CardViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(itemLayout,parent,false);
        MyViewHolder viewHolder= new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewAdapter.MyViewHolder holder, int position) {



        try{

            if(TopNewsResultList.size() > 0){

                holder.titleText.setText(TopNewsResultList.get(position).getTitle());
                holder.byline.setText(TopNewsResultList.get(position).getByline());
                holder.sectionButton.setText(TopNewsResultList.get(position).getSection());
                Glide.with(context)
                        .load(Uri.parse(TopNewsResultList.get(position).getMultimedia().get(4).getUrl()))
                        .into(holder.imageView);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mCallback.passViewtoActivity(holder.getAdapterPosition(),TopNewsResultList,TopNewsResultList.get(position).getShortUrl());
                    }
                });

            }
            else{

                holder.titleText.setText(TopNewsOfflineResultList.get(position).getTitle());
                holder.byline.setText(TopNewsOfflineResultList.get(position).getByline());
                holder.sectionButton.setText(TopNewsOfflineResultList.get(position).getSection());
                /*Glide.with(context)
                        .load(Uri.parse(TopNewsResultList.get(position).getMultimedia().get(4).getUrl()))
                        .into(holder.imageView);*/


                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mCallback.passViewtoActivityoffline(holder.getAdapterPosition(),TopNewsOfflineResultList,TopNewsOfflineResultList.get(position).getShortUrl());
                    }
                });

            }



      }catch(Exception e){


      }


    }

    @Override
    public int getItemCount() {

            if(isNetwork){

                return TopNewsResultList.size();
            }
            else{

                return TopNewsOfflineResultList.size();
            }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

         TextView titleText;
         ImageView imageView;
         TextView byline;
         Button sectionButton;

        public MyViewHolder(View itemView) {
            super(itemView);

            titleText = (TextView)itemView.findViewById(R.id.title);
            imageView = (ImageView)itemView.findViewById(R.id.imageViewPoster);
            byline = (TextView)itemView.findViewById(R.id.byline);
            sectionButton = (Button)itemView.findViewById(R.id.sectionbutton);
        }
    }

    public void setDiscoverNewsResult(List<Result> items , List<TopNewsData> topNewsData , Boolean online ) {
        TopNewsResultList = items;
        TopNewsOfflineResultList = topNewsData;
        this.isNetwork = online;

    }


}
