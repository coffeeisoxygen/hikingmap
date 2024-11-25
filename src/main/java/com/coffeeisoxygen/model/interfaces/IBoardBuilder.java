package com.coffeeisoxygen.model.interfaces;

public interface IBoardBuilder {
    IBoardBuilder setWidth(int width);
    IBoardBuilder setHeight(int height);
    IBoard build();
}