package pl.exam.exercise1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;


@JsonTypeInfo(use = DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(Circle.class),
        @JsonSubTypes.Type(Rectangle.class),
        @JsonSubTypes.Type(Square.class)
})
public abstract class Shape {
    private final String type;

    public Shape() {
        this.type = this.getClass().getSimpleName().toLowerCase();
    }

    public abstract double area();

    public abstract double perimeter();

    public String getType() {
        return type;
    }
}
