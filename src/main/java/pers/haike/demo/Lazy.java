package pers.haike.demo;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

public final class Lazy<T> {
    private volatile T value;

    public T getOrCompute(Supplier<T> supplier) {
        final T result = value; // Just one volatile read
        return result == null ? maybeCompute(supplier) : result;
    }

    private synchronized T maybeCompute(Supplier<T> supplier) {
        if (value == null) {
            value = requireNonNull(supplier.get());
        }
        return value;
    }
}
