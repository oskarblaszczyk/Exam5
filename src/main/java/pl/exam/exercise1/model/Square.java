package pl.exam.exercise1.model;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Square extends Shape {
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
