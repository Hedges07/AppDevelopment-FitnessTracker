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

                    case "Pullups":
                        intent_workout.putExtra("workout_title", "Pullups");
                        intent_workout.putExtra("workout_video", "pullups");
                        intent_workout.putExtra("workout_description", "A pullup is a challenging upper body exercise where you grip an overhead bar and lift your body until your chin is above that bar.");
                        context.startActivity(intent_workout);
                        break;

                    case "Lat Pulldown":
                        intent_workout.putExtra("workout_title", "Lat Pulldown");
                        intent_workout.putExtra("workout_video", "lat_pulldown");
                        intent_workout.putExtra("workout_description", "The pulldown exercise works the back muscles and is performed at a workstation with adjustable resistance, usually plates. While seated, you pull a hanging bar toward you to reach chin level, then release it back up with control for one repetition.");
                        context.startActivity(intent_workout);
                        break;

                    case "Bentover Rows":
                        intent_workout.putExtra("workout_title", "Bentover Rows");
                        intent_workout.putExtra("workout_video", "bentover_row");
                        intent_workout.putExtra("workout_description", "The dumbbell row, also known as the bent-over dumbbell row, is a compound back exercise. Perform dumbbell rows by hinging your hips with your back straight and lifting a pair of dumbbells with a neutral grip (palms facing each other)");
                        context.startActivity(intent_workout);
                        break;

                    case "Barbell Deadlift":
                        intent_workout.putExtra("workout_title", "Barbell Deadlift");
                        intent_workout.putExtra("workout_video", "barbell_deadlift");
                        intent_workout.putExtra("workout_description", "The deadlift is a weight training exercise in which a loaded barbell or bar is lifted off the ground to the level of the hips, torso perpendicular to the floor, before being placed back on the ground.");
                        context.startActivity(intent_workout);
                        break;

                    case "Push-ups":
                        intent_workout.putExtra("workout_title", "Push-Ups");
                        intent_workout.putExtra("workout_video", "pushups");
                        intent_workout.putExtra("workout_description", "Pushups are an exercise in which a person, keeping a prone position, with the hands palms down under the shoulders, the balls of the feet on the ground, and the back straight, pushes the body up and lets it down by an alternate straightening and bending of the arms.");
                        context.startActivity(intent_workout);
                        break;

                    case "Bench Press":
                        intent_workout.putExtra("workout_title", "Bench Press");
                        intent_workout.putExtra("workout_video", "bench_press");
                        intent_workout.putExtra("workout_description", "The bench press is a compound exercise that targets the muscles of the upper body. It involves lying on a bench and pressing weight upward using either a barbell or a pair of dumbbells. During a bench press, you lower the weight down to chest level and then press upwards while extending your arms.");
                        context.startActivity(intent_workout);
                        break;

                    case "Chest Flies":
                        intent_workout.putExtra("workout_title", "Chest Flies");
                        intent_workout.putExtra("workout_video", "chest_flies");
                        intent_workout.putExtra("workout_description", "A chest fly is a weightlifting exercise that primarily targets the pectoral muscles. It is a variation of the standard bench press and is performed by lying on a flat bench with a weight in each hand. You can do this exercise with dumbbells, barbells, or cables.");
                        context.startActivity(intent_workout);
                        break;

                    case "Dips":
                        intent_workout.putExtra("workout_title", "Dips");
                        intent_workout.putExtra("workout_video", "dips");
                        intent_workout.putExtra("workout_description", "Dips are a bodyweight exercise that develops the triceps and other upper-body muscles. The exercise begins when you hold on to parallel bars with your arms straight. You then bend your elbows until your upper arms are parallel to the ground before driving up to the starting position.");
                        context.startActivity(intent_workout);
                        break;

                    case "Squats":
                        intent_workout.putExtra("workout_title", "Squats");
                        intent_workout.putExtra("workout_video", "squats");
                        intent_workout.putExtra("workout_description", "Squat is an exercise in which a standing person lowers to a position in which the torso is erect and the knees are deeply bent and then rises to an upright position. Note: A squat can be done while holding weights, with a barbell on the upper back, or without weights.");
                        context.startActivity(intent_workout);
                        break;

                    case "Hamstring Curls":
                        intent_workout.putExtra("workout_title", "Hamstring Curls");
                        intent_workout.putExtra("workout_video", "hamstring_curls");
                        intent_workout.putExtra("workout_description", "e hamstring curl, also called a leg curl, is an exercise that strengthens the hamstrings. It involves bending your knees and moving your heels toward your butt while the rest of your body stays still. Typically, the exercise is done on a leg curl machine.");
                        context.startActivity(intent_workout);
                        break;

                    case "Leg Press":
                        intent_workout.putExtra("workout_title", "Leg Press");
                        intent_workout.putExtra("workout_video", "leg_press");
                        intent_workout.putExtra("workout_description", "Leg presses are seated exercises done on a leg press machine. To start, sit with your back against a padded backrest and your feet on two large footrests. Your knees are bent to start the exercise. To move the weight, you must straighten your legs and then return them to the bent position.");
                        context.startActivity(intent_workout);
                        break;

                    case "Calf Raises":
                        intent_workout.putExtra("workout_title", "Calf Raises");
                        intent_workout.putExtra("workout_video", "calf_raises");
                        intent_workout.putExtra("workout_description", "To do a calf raise with dumbbells, hold a dumbbell in each hand and stand with your feet about shoulder-width apart. Let your arms hang straight below your shoulders. Rise up onto your toes, then slowly return to the starting position. You'll feel tension in the muscles in the back of your lower legs.");
                        context.startActivity(intent_workout);
                        break;

                    case "Leg Extensions":
                        intent_workout.putExtra("workout_title", "Leg Extensions");
                        intent_workout.putExtra("workout_video", "leg_extension");
                        intent_workout.putExtra("workout_description", "A single-joint movement that targets the quads, leg extensions (a.k.a., quad extensions) involves straightening the knee repeatedly under load. Most gyms have dedicated leg extension machines. You can also perform quad extensions at home with a resistance band or just your body weight.");
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