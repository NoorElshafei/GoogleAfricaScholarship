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

import java.util.List;

public class HoursLearningAdapter extends RecyclerView.Adapter<HoursLearningAdapter.HoursViewModel> {
    private List<LearningModel> list;
    private Context context;

    public HoursLearningAdapter(List<LearningModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HoursViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.learining_item, parent, false);

        return new HoursViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoursViewModel holder, int position) {
        LearningModel currentLearning = list.get(position);
        holder.nameLearning.setText(currentLearning.getName());
        holder.hoursLearning.setText(currentLearning.getHours()+" learning hours, "+currentLearning.getCountry());
        Glide.with(context).load(currentLearning.getBadgeUrl()).into(holder.hoursBadge);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HoursViewModel extends RecyclerView.ViewHolder {
        TextView nameLearning,hoursLearning;
        ImageView hoursBadge;
        public HoursViewModel(@NonNull View itemView) {
            super(itemView);

            nameLearning = itemView.findViewById(R.id.name_laerning);
            hoursLearning = itemView.findViewById(R.id.hours_learning);
            hoursBadge = itemView.findViewById(R.id.learning_image);
        }
    }
}
