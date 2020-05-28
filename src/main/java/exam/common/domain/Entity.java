package exam.common.domain;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
