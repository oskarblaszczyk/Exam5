package pl.exam.excercise1.model;

import lombok.*;
import pl.exam.excercise1.controller.Shape;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Circle implements Shape {
    @NonNull
    private double radius;


    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 0;
    }
}
