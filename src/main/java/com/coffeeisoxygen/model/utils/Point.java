package com.coffeeisoxygen.model.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Point {
    private static final Map<String, Point> cache = new HashMap<>();
    private int x;
    private int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        String key = x + "," + y;
        return cache.computeIfAbsent(key, k -> new Point(x, y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double checkDistance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public boolean checkIsEquals(Point other) {
        return this.x == other.x && this.y == other.y;
    }

    public boolean isWithinBounds(int maxX, int maxY) {
        return this.x >= 0 && this.x <= maxX && this.y >= 0 && this.y <= maxY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
