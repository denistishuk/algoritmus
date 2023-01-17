package kz.lakida.learn.oop.workout;

import java.time.Clock;
import java.time.Instant;

public class Resting extends Workout {

    private static final int REST_SECOND_COUNT = 60;

    private final Instant startTime;
    private final Clock clock;

    public Resting(WorkoutTask workoutTask, int currentSet, Clock clock) {
        super(workoutTask);

        this.currentSet = currentSet;
        this.clock = clock;
        startTime = clock.instant();
    }

    public int getSecondsLeft() {
        Instant currentTime = clock.instant();

        return (int) (currentTime.getEpochSecond() - startTime.getEpochSecond());
    }

    public Workout tickTheRestTime() {
        if (getSecondsLeft() >= REST_SECOND_COUNT) {
            return new WorkingOut(workoutTask, currentSet++);
        } else {
            return this;
        }
    }
}
