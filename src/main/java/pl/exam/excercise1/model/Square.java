package pl.exam.excercise1.model;

import lombok.*;
import pl.exam.excercise1.controller.Shape;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Square implements Shape {

    private double a;

    @Override
    public double area() {
        return a * a;
    }

    @Override
    public double perimeter() {
        return 4*a;
    }
}
