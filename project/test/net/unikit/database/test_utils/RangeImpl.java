package net.unikit.database.test_utils;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Andreas on 15.12.2015.
 */
final class RangeImpl<T extends Comparable<T>> implements Range<T> {
    private T from;
    private T to;

    private RangeImpl(T from, T to) {
        checkNotNull(from);
        checkNotNull(to);

        this.from = from;
        this.to = to;
    }

    public static <T extends Comparable<T>> Range<T> create(T from, T to) {
        return new RangeImpl<T>(from, to);
    }

    @Override
    public T getFrom() {
        return from;
    }

    @Override
    public T getTo() {
        return to;
    }

    @Override
    public boolean includes(T value) {
        return (from.compareTo(value) <= 0) && (to.compareTo(value) >= 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RangeImpl)) return false;

        RangeImpl<?> range = (RangeImpl<?>) o;

        if (getFrom() != null ? !getFrom().equals(range.getFrom()) : range.getFrom() != null) return false;
        return !(getTo() != null ? !getTo().equals(range.getTo()) : range.getTo() != null);

    }

    @Override
    public int hashCode() {
        int result = getFrom() != null ? getFrom().hashCode() : 0;
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Range{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
