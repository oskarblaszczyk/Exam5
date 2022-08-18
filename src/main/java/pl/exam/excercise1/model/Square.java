package pl.exam.excercise1.model;

import lombok.*;
import pl.exam.excercise1.controller.Shape;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Square implements Shape {
    @NonNull
    private double a;

    @Override
    public double area() {
        return a * a;
    }

    @Override
    public double perimeter() {
        return 0;
    }
}
