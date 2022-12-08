package api.resources.fabrics;

import java.util.function.BiFunction;
@FunctionalInterface
public interface IReqSpecConstructor<T> extends BiFunction<String, String, T> {
}