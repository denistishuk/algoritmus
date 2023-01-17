package kz.lakida.learn.oop.workout;

import java.time.Clock;

public class WorkingOut extends Workout {

    public WorkingOut(WorkoutTask workoutTask) {
        this(workoutTask, 0);
        currentRepetition = 0;
    }

    public WorkingOut(WorkoutTask workoutTask, int currentSet) {
        super(workoutTask);
        this.currentSet = currentSet;
        currentRepetition = 0;
    }

    public int getSetNumber() {
        return currentSet;
    }

    public int getLeftRepetitionsCount() {
        int currentSetRepetitionsCount = workoutTask.getTask().get(currentSet);
        return currentSetRepetitionsCount - currentRepetition;
    }

    public Workout doRepetition() {
        currentRepetition++;

        if (finishedSet()) {
            return new Resting(workoutTask, currentSet, Clock.systemUTC());
        } else {
            return this;
        }
    }

    private boolean finishedSet() {
        int currentSetRepetitionsCount = workoutTask.getTask().get(currentSet);
        return currentSetRepetitionsCount == currentRepetition;
    }
}
