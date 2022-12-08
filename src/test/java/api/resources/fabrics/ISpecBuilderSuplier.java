package api.resources.fabrics;

import java.util.function.Function;

public interface ISpecBuilderSuplier<T> extends Function<IReqSpecConstructor<T>, IRequestSpecificationBuilder> {
}
