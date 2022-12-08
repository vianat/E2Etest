package api.resources.fabrics;

import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class BaseRequestSpecificationBuilder extends DefaultRequestSpecificationBuilder {
    protected String token;

    BaseRequestSpecificationBuilder(String url, String token) {
        super(url);
        this.token = token;
    }

    public abstract RequestSpecification createSPEC() throws IOException;

    public static <T extends BaseRequestSpecificationBuilder> ISpecBuilderSuplier<T> buildSpecBuilderSupplier(String url, String token){
        ISpecBuilderSuplier<T> pie = (IReqSpecConstructor<T> constructor) -> {
            return constructor.apply(url, token);
        };
//        ISpecBuilderSuplier<T> pie2 = new Pie<>(url, token);

        return pie;
    }

    public static class Pie <T extends BaseRequestSpecificationBuilder> implements ISpecBuilderSuplier<T> {
            String url;
            String token;
        Pie(String url, String token){
            this.url = url;
            this.token = token;
        }
        @Override
        public IRequestSpecificationBuilder apply(IReqSpecConstructor<T> constructor) {
            return constructor.apply(url, token);
        }
    }
}