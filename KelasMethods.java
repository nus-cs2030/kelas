import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
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
    public KelasMethods arePublic() {
        this.stream.filter(m -> Modifier.isPublic(m.getModifiers()));
        return this;
    }

    public KelasMethods arePrivate() {
        this.stream.filter(m -> Modifier.isPrivate(m.getModifiers()));
        return this;
    }

    public KelasMethods areProtected() {
        this.stream.filter(m -> Modifier.isProtected(m.getModifiers()));
        return this;
    }

    public KelasMethods areAbstract() {
        this.stream.filter(m -> Modifier.isAbstract(m.getModifiers()));
        return this;
    }

    public KelasMethods areStatic() {
        this.stream.filter(m -> Modifier.isStatic(m.getModifiers()));
        return this;
    }

    public KelasMethods areFinal() {
        this.stream.filter(m -> Modifier.isFinal(m.getModifiers()));
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
        this.stream.filter(m -> m.getName() == name);
        return this;
    }

    /**
     * Check if methods have parameters
     * @param parameters the parameters to check (varargs)
     * @return KelasFields object to chain
     */
    @SafeVarargs
    public final KelasMethods haveParameters(Class<?>... parameters) {
        this.stream.filter(m -> Arrays.equals(m.getParameters(), parameters));
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
        return this.stream.collect(Collectors.toList()).size();
    }

    /**
     * Terminal operation. 
     * Returns true if methods are absent. Returns false otherwise.
     */
    public boolean areAbsent() {
        return this.stream
                    .collect(Collectors.toList())
                    .isEmpty();
    }

    /**
     * Terminal operation. 
     * Returns true if methods are present. Returns false otherwise.
     */
    public boolean arePresent() {
        return !areAbsent();
    }
}