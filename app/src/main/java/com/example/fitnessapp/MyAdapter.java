package com.example.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<CategoryData> data;
    Context context;
    CardView cardView;

    public MyAdapter(ArrayList<CategoryData> data, Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CategoryData datalist = data.get(position);
        holder.textView.setText(datalist.getText());
        Intent intent_workout = new Intent(context,workout_view.class);

        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switch(holder.textView.getText().toString())
                {
                    //Categories
                    case "Arms":
                        Intent intent_arm = new Intent(context,ArmWorkouts.class);
                        context.startActivity(intent_arm);
                        break;

                    case "Legs":
                        Intent intent_leg = new Intent(context,LegWorkouts.class);
                        context.startActivity(intent_leg);
                        break;

                    case "Chest":
                        Intent intent_chest = new Intent(context,ChestWorkouts.class);
                        context.startActivity(intent_chest);
                        break;

                    case "Back":
                        Intent intent_back = new Intent(context,BackWorkouts.class);
                        context.startActivity(intent_back);
                        break;

                    //WORKOUTS
                    case "Bicep Curls":
                        intent_workout.putExtra("workout_title", "Bicep Curls");
                        intent_workout.putExtra("workout_video", "bicep_curls");
                        intent_workout.putExtra("workout_description", "To do a biceps curl with a dumbbell, hold a dumbbell with your palm facing upward. Slowly curl the weight up by bending your elbow, keeping your elbow close to your body. Then slowly lower the weight to the starting position.");
                        context.startActivity(intent_workout);
                        break;

                    case "Preacher Curls":
                        intent_workout.putExtra("workout_title", "Preacher Curls");
                        intent_workout.putExtra("workout_video", "preacher_curls");
                        intent_workout.putExtra("workout_description", "The preacher curl is performed with a bench that is designed for you to sit down with your upper arms resting on a surface that is slightly tilted inwards. This biceps curl variation allows you to hone in on the biceps while not using any other part of your body.");
                        context.startActivity(intent_workout);
                        break;

                    case "Tricep Pushdown":
                        intent_workout.putExtra("workout_title", "Tricep Pushdown");
                        intent_workout.putExtra("workout_video", "tricep_pushdown");
                        intent_workout.putExtra("workout_description", "A tricep pushdown is an isolation exercise designed to target your triceps muscles. Perform tricep pushdowns by standing in front of a pulley machine with your feet shoulder-width apart.");
                        context.startActivity(intent_workout);
                        break;

                    case "Skull Crushers":
                        intent_workout.putExtra("workout_title", "Skull Crushers");
                        intent_workout.putExtra("workout_video", "skull_crushers");
                        intent_workout.putExtra("workout_description", "To do skull crushers, lie on your back with a dumbbell in your hand. Point your upper arm toward the ceiling, with your elbow bent to 90 degrees. Slowly straighten the elbow, moving the weight upward. Then slowly lower the weight to the starting position.");
                        context.startActivity(intent_workout);
                        break;

                    case "Hammer Curls":
                        intent_workout.putExtra("workout_title", "Hammer Curls");
                        intent_workout.putExtra("workout_video", "hammer_curl");
                        intent_workout.putExtra("workout_description", "Keep your back straight and your elbows against your sides. Bend your left elbow, bringing the dumbbell up toward your right chest/shoulder. Your palm will be facing your chest. Pause for a 1–2 count, and then slowly lower the dumbbell back to the starting position at your side.");
                        context.startActivity(intent_workout);
                        break;

                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return data.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView2);
            cardView = itemView.findViewById(R.id.card_View);
        }
    }
}