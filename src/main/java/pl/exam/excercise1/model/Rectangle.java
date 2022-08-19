package pl.exam.excercise1.model;

import lombok.*;
import pl.exam.excercise1.controller.Shape;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle implements Shape {

    private double width;
    private double height;


    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * width + 2 * height;
    }
}
