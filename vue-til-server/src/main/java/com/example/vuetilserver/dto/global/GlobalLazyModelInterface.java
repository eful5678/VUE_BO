package com.example.vuetilserver.dto.global;

@FunctionalInterface
public interface GlobalLazyModelInterface<T, R> {

    R lazyModeling(T t);
}
