package pl.exam.excercise1.model;

import lombok.*;
import pl.exam.excercise1.controller.Shape;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle implements Shape {
    @NonNull
    private double width;
    @NonNull
    private double height;


    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }
}
