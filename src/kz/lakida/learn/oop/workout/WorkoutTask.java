package kz.lakida.learn.oop.workout;

import java.util.List;
import java.util.Objects;

public class WorkoutTask {

    private final List<Integer> task;

    private final Level level;

    public WorkoutTask(List<Integer> task, Level level) {
        this.task = task;
        this.level = level;
    }

    public List<Integer> getTask() {
        return task;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutTask that = (WorkoutTask) o;
        return task.equals(that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
    }

    enum Level {
        EASY, MEDIUM, HARD
    }
}
