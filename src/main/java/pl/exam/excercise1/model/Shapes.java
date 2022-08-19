package pl.exam.excercise1.model;

import lombok.*;
import pl.exam.excercise1.controller.Shape;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Shapes {
    private List<Shape> shapes;
}
