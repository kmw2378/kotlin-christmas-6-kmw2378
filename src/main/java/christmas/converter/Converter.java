package christmas.converter;

public interface Converter <S, T>{
    T convert(S source);
}
