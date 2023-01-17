package kz.lakida.learn.oop.workout;

public abstract class Workout {

    protected final WorkoutTask workoutTask;
    protected int currentSet;
    protected int currentRepetition;

    protected Workout(WorkoutTask workoutTask) {
        this.workoutTask = workoutTask;
    }

    public static StartingWorkout create(WorkoutTask workoutTask) {
        return new StartingWorkout(workoutTask);
    }
}
