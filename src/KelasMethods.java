import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream wrapper that expresses the methods of a Kelas.
 * Methods can be chained, except for terminal operations listed below.
 */
public class KelasMethods {
    private Stream<Method> stream;

    public KelasMethods(Stream<Method> stream) {
        this.stream = stream;
    }

    /*
     * Basic method checks
     */
    public KelasMethods arePublic(boolean allowed) {
        Predicate<Method> pred = allowed
            ? m -> Modifier.isPublic(m.getModifiers())
            : m -> !Modifier.isPublic(m.getModifiers());
        this.stream = this.stream.filter(pred);
        return this;
    }

    public KelasMethods arePrivate(boolean allowed) {
        Predicate<Method> pred = allowed
            ? m -> Modifier.isPrivate(m.getModifiers())
            : m -> !Modifier.isPrivate(m.getModifiers());
        this.stream = this.stream.filter(pred);
        return this;
    }

    public KelasMethods areProtected(boolean allowed) {
        Predicate<Method> pred = allowed
            ? m -> Modifier.isProtected(m.getModifiers())
            : m -> !Modifier.isProtected(m.getModifiers());
        this.stream = this.stream.filter(pred);
        return this;
    }

    public KelasMethods areAbstract(boolean allowed) {
        Predicate<Method> pred = allowed
            ? m -> Modifier.isAbstract(m.getModifiers())
            : m -> !Modifier.isAbstract(m.getModifiers());
        this.stream = this.stream.filter(pred);
        return this;
    }

    public KelasMethods areStatic(boolean allowed) {
        Predicate<Method> pred = allowed
            ? m -> Modifier.isStatic(m.getModifiers())
            : m -> !Modifier.isStatic(m.getModifiers());
        this.stream = this.stream.filter(pred);
        return this;
    }

    public KelasMethods areFinal(boolean allowed) {
        Predicate<Method> pred = allowed
            ? m -> Modifier.isFinal(m.getModifiers())
            : m -> !Modifier.isFinal(m.getModifiers());
        this.stream = this.stream.filter(pred);
        return this;
    }

    // For edge cases that require OR operations
    public KelasMethods filter(Predicate<Method> pred) {
        this.stream = this.stream.filter(pred);
        return this;
    }

    /*
     * Have methods
     */
    /**
     * Check if methods have name
     * @param name the name to check
     * @return KelasMethods object to chain
     */
    public KelasMethods haveName(String name) {
        this.stream = this.stream.filter(m -> m.getName() == name);
        return this;
    }

    /**
     * Check if methods have parameters
     * @param parameters the parameters to check (varargs)
     * @return KelasFields object to chain
     */
    public KelasMethods haveParameters(Class<?>... parameters) {
        this.stream = this.stream.filter(m -> Arrays.equals(m.getParameterTypes(), parameters));
        return this;
    }

    /*
     * Terminal
     */
    /**
     * Terminal operation.
     * Collects the methods into a List.
     * @return List of methods
     */
    public List<Method> collect() {
        return this.stream.collect(Collectors.toList());
    }

    /**
     * Terminal operation.
     * Count the number of methods.
     * @return Number of methods
     */
    public int count() {
        return (int) this.stream.count();
    }

    /**
     * Terminal operation.
     * Returns true if methods are absent. Returns false otherwise.
     */
    public boolean areAbsent() {
        return count() == 0;
    }

    /**
     * Terminal operation.
     * Returns true if methods are present. Returns false otherwise.
     */
    public boolean arePresent() {
        return !areAbsent();
    }
}
