import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream wrapper that expresses the fields of a Kelas.
 * Methods can be chained, except for terminal operations listed below.
 */
public class KelasFields{
    private Stream<Field> stream;

    public KelasFields(Stream<Field> stream) {
        this.stream = stream;
    }

    /*
     * Basic field checks
     */
    public KelasFields arePublic() {
        this.stream.filter(f -> Modifier.isPublic(f.getModifiers()));
        return this;
    }

    public KelasFields arePrivate() {
        this.stream.filter(f -> Modifier.isPrivate(f.getModifiers()));
        return this;
    }

    public KelasFields areProtected() {
        this.stream.filter(f -> Modifier.isProtected(f.getModifiers()));
        return this;
    }

    public KelasFields areStatic() {
        this.stream.filter(f -> Modifier.isStatic(f.getModifiers()));
        return this;
    }

    public KelasFields areFinal() {
        this.stream.filter(f -> Modifier.isFinal(f.getModifiers()));
        return this;
    }

    public KelasFields areEnum() {
        this.stream.filter(f -> Enum.class.isAssignableFrom(f.getType()));
        return this;
    }

    /*
    * Have methods
    */
    /**
     * Filter fields with name
     * @param name the name to check
     * @return KelasFields object to chain
     */
    public KelasFields haveName(String name) {
        this.stream.filter(f -> f.getName().equals(name));
        return this;
    }

    /**
     * Filter fields with type
     * @param type the type to check
     * @return KelasFields object to chain
     */
    public KelasFields haveType(Class<?> type) {
        this.stream.filter(f -> f.getType() == type);
        return this;
    }

    /**
     * Filter fields with type and generic type
     * @param type the type to check
     * @param genericType the generic type to check
     * @return KelasFields object to chain
     */
    public KelasFields haveType(Class<?> type, Type genericType) {
        this.stream.filter(f -> {
            if (f.getType() == type) {
                ParameterizedType currentType = (ParameterizedType) f.getGenericType();;
                Type typeArgument = currentType.getActualTypeArguments()[0]; // Fix - handle misc number of generic types
                if (typeArgument.equals(genericType)) {
                    return true;
                }
            }
            return false;
        });
        return this;
    }

    /**
     * Filter fields with type and value
     * @param type the type to check
     * @param value the value to check
     * @return KelasFields object to chain
     */
    public <T> KelasFields haveTypeWithValue(Class<T> type, T value) {
        this.stream.filter(f -> {
            try {
                if (f.getType() == type && type.cast(f.get(null)).equals(value)) {
                    return true;
                } else {
                    return false;
                }
            } catch (IllegalAccessException e) {
                return false;
            }
        });
        return this;
    }

    /*
     * Terminal operations
     */
    /**
     * Terminal operation. 
     * Collects the fields into a List.
     * @return List of fields
     */
    public List<Field> collect() {
        return this.stream.collect(Collectors.toList());
    }

    /**
     * Terminal operation. 
     * Count the number of fields.
     * @return Number of fields
     */
    public int count() {
        return this.stream.collect(Collectors.toList()).size();
    }

    /**
     * Terminal operation. 
     * Returns true if fields are absent. Returns false otherwise.
     */
    public boolean areAbsent() {
        return this.stream
                    .collect(Collectors.toList())
                    .isEmpty();
    }

    /**
     * Terminal operation. 
     * Returns true if fields are present. Returns false otherwise.
     */
    public boolean arePresent() {
        return !areAbsent();
    }
}