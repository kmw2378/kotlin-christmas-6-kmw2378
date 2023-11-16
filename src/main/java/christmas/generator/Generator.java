package christmas.generator;

public interface Generator<S, T> {
    T generate(S source);
}
