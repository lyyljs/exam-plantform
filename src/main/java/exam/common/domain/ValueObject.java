package exam.common.domain;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
