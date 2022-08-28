package pl.exam.exercise1.model;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle extends Shape {
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
