package kz.lakida.learn.oop.workout;

public class StartingWorkout extends Workout {

    protected StartingWorkout(WorkoutTask workoutTask) {
        super(workoutTask);
        currentSet = -1;
        currentRepetition = -1;
    }

    public WorkingOut start() {
        return new WorkingOut(workoutTask);
    }
}
