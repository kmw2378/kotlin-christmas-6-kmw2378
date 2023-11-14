package christmas.mapper;

public interface ResponseMapper<S, T> {
    T map(final S source);
}
