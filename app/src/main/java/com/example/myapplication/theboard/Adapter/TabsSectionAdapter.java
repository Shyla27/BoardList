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
import com.example.myapplication.gadsleaderboard.model.SkillIQLeaders;

import java.util.List;

public class TabsSectionAdapter  extends RecyclerView.Adapter<TabsSectionAdapter.SkillIQLeadersViewHolder>{
    Context context;
    List<SkillIQLeaders> skillIQLeadersList;

    public TabsSectionAdapter(Context context, List<SkillIQLeaders> skillIQLeadersList) {
        this.context = context;
        this.skillIQLeadersList = skillIQLeadersList;
    }

    @NonNull
    @Override
    public SkillIQLeadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.skill_leaders_item_layout, parent,false);
        return new SkillIQLeadersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabsSectionAdapter.SkillIQLeadersViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull SkillIQLeadersViewHolder holder, int position) {

        holder.leadername.setText(skillIQLeadersList.get(position).getSkillLeaderName());
        holder.learningHours.setText(skillIQLeadersList.get(position).getSkillscore() + " skill IQ score,");
        holder.countrytext.setText(skillIQLeadersList.get(position).getCountrySkillName());
        Glide.with(context).load(skillIQLeadersList.get(position).getImageUrl()).into(holder.leaderPhoto);

    }

    @Override
    public int getItemCount() {
        return skillIQLeadersList.size();
    }

    public class SkillIQLeadersViewHolder extends RecyclerView.ViewHolder{

        ImageView leaderPhoto;
        TextView learningHours,countrytext,leadername;

        public SkillIQLeadersViewHolder(@NonNull View itemView) {
            super(itemView);

            leaderPhoto = itemView.findViewById(R.id.skill_image);
            leadername = itemView.findViewById(R.id.skill_name);
            learningHours= itemView.findViewById(R.id.skill_scores);
            countrytext= itemView.findViewById(R.id.countryskill_name);

        }
    }
}
