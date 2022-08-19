package pl.exam.excercise1.model;

import lombok.*;
import pl.exam.excercise1.controller.Shape;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Circle implements Shape {
    private double radius;


    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
