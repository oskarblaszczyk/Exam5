package pl.exam.exercise1.service;

import lombok.NoArgsConstructor;
import pl.exam.exercise1.model.Shape;

import java.util.*;

@NoArgsConstructor
public class ShapeMathService {

    public Shape biggestArea(List<Shape> shapes) {
        return Optional.ofNullable(shapes)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Shape::area))
                .orElseThrow();
    }

    public Shape biggestPerimeter(List<Shape> shapes, String type) {
        return Optional.ofNullable(shapes)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.getType().equals(type))
                .max(Comparator.comparingDouble(Shape::perimeter))
                .orElseThrow();
    }

}
