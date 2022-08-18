package pl.exam.excercise1.service;

import pl.exam.excercise1.controller.Shape;

import java.util.*;

public class ShapeMathService {

    public static Shape biggestArea(List<Shape> shapes) {
        return Optional.ofNullable(shapes)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Shape::area))
                .orElseThrow();
    }

    public static <T> Shape biggestPerimeter(List<Shape> shapes, Class<T> type) {
        return Optional.ofNullable(shapes)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.getClass().equals(type))
                .max(Comparator.comparingDouble(Shape::perimeter))
                .orElseThrow();
    }

}
