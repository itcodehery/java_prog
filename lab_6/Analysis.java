import java.util.List;

@FunctionalInterface
interface Analysis<T extends Number> {
    Number perform(List<T> data);
}
