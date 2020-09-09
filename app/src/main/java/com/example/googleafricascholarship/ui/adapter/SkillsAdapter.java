package com.example.googleafricascholarship.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.googleafricascholarship.R;
import com.example.googleafricascholarship.data.model.LearningModel;
import com.example.googleafricascholarship.data.model.SkillsModel;

import java.util.List;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SkillsViewModel> {

    private List<SkillsModel> list;
    private Context context;

    public SkillsAdapter(List<SkillsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SkillsViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.skill_item, parent, false);

        return new SkillsViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsViewModel holder, int position) {
        SkillsModel currentLearning = list.get(position);
        holder.nameLearning.setText(currentLearning.getName());
        holder.hoursLearning.setText(currentLearning.getScore()+" skill IQ Score, "+currentLearning.getCountry());
        Glide.with(context).load(currentLearning.getBadgeUrl()).into(holder.hoursBadge);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SkillsViewModel extends RecyclerView.ViewHolder {
        TextView nameLearning,hoursLearning;
        ImageView hoursBadge;
        public SkillsViewModel(@NonNull View itemView) {
            super(itemView);
            nameLearning = itemView.findViewById(R.id.name_skills);
            hoursLearning = itemView.findViewById(R.id.score_skills);
            hoursBadge = itemView.findViewById(R.id.learning_image);
        }
    }
}
