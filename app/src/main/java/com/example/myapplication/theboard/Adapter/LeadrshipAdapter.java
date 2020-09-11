package com.example.myapplication.gadsleaderboard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.gadsleaderboard.R;
import com.example.myapplication.gadsleaderboard.model.LearningLeaders;

import java.util.List;

public class LeadrshipAdapter extends RecyclerView.Adapter {

    Context context;
    List<LearningLeaders> learningLeadersList;

    public LearningLeadersAdapter(Context context, List<LearningLeaders> learningLeadersList) {
        this.context = context;
        this.learningLeadersList = learningLeadersList;
    }

    @NonNull
    @Override
    public LearningLeadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.learning_leaders_item_layout, parent,false);
        return new LearningLeadersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull LearningLeadersViewHolder holder, int position) {

        holder.leadername.setText(learningLeadersList.get(position).getleaderName());
        holder.learningHours.setText(learningLeadersList.get(position).getLearninghours() + " learning hours,");
        holder.countrytext.setText(learningLeadersList.get(position).getCountryName());
        Glide.with(context).load(learningLeadersList.get(position).getImageUrl()).into(holder.leaderPhoto);

    }

    @Override
    public int getItemCount() {
        return learningLeadersList.size();
    }

    public class LearningLeadersViewHolder extends RecyclerView.ViewHolder{

        ImageView leaderPhoto;
        TextView learningHours,countrytext,leadername;

        public LearningLeadersViewHolder(@NonNull View itemView) {
            super(itemView);

            leaderPhoto = itemView.findViewById(R.id.leaders_image);
            leadername = itemView.findViewById(R.id.leaders_name);
            learningHours= itemView.findViewById(R.id.learning_hours);
            countrytext= itemView.findViewById(R.id.country_name);

        }
    }
}
