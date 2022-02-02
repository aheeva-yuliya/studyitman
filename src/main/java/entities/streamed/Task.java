package entities.streamed;



import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Task {
    private final String name;
    private final LocalDate plannedDate;
    private final LocalDate completedDate;
    private final Set<Tag> tags;

    public Task(String name, LocalDate plannedDate, LocalDate completedDate, Set<Tag> tags) {
        this.name = name;
        this.plannedDate = plannedDate;
        this.completedDate = completedDate;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(name, task.name)
                && Objects.equals(plannedDate, task.plannedDate)
                && Objects.equals(completedDate, task.completedDate)
                && Objects.equals(tags, task.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, plannedDate, completedDate, tags);
    }
}
