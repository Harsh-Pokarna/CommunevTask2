package com.example.comunevtask2java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
    ArrayList<Model> data;
    Context context;
    public NameAdapter(Context context, ArrayList<Model> data){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
            view = layoutInflater.inflate(R.layout.eachrow, parent, false);
            return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
            NameViewHolder nameViewHolder = (NameViewHolder) holder;
            Model currentData = data.get(position);
            nameViewHolder.container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.rowanim));
            nameViewHolder.title.setText(currentData.getTitle());
            nameViewHolder.firstName.setText(currentData.getFirstName());
            nameViewHolder.lastName.setText(currentData.getLastName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class NameViewHolder extends RecyclerView.ViewHolder{
        public TextView title, firstName, lastName;
        public CardView container;

    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.titleOfPerson);
        firstName = itemView.findViewById(R.id.firstNameOfPerson);
        lastName = itemView.findViewById(R.id.lastNameOfPerson);
        container = itemView.findViewById(R.id.containerCard);
    }
}

}
