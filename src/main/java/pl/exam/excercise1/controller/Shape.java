package pl.exam.excercise1.controller;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pl.exam.excercise1.model.Circle;
import pl.exam.excercise1.model.Rectangle;
import pl.exam.excercise1.model.Square;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(
        use = NAME,
        include = PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Square.class, name = "square")
})
public interface Shape {

    double area();

    double perimeter();
}
