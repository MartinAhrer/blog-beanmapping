package at.softwarecraftsmen.test.shared

public interface EntityFactory<T> {
    /**
     * Create a new {@code T}.
     * @param args map may override internally wired construction values
     * @return a {@code T}.
     */
    T newEntity(Map args);
}