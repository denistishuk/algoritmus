package kz.lakida.learn.oop.workout;

import kz.lakida.learn.oop.workout.WorkoutTask.Level;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WorkoutTask workoutTask = new WorkoutTask(Arrays.asList(8, 8, 6, 5, 7), Level.EASY);

        StartingWorkout workout = Workout.create(workoutTask);

        WorkingOut workingOut = workout.start();

        Workout nextStep = workingOut.doRepetition();
        if (nextStep instanceof WorkingOut) {
            WorkingOut nextWorkingOut = (WorkingOut) nextStep;
        } else if(nextStep instanceof Resting) {

        } else {
            throw new IllegalStateException();
        }

    }

}
