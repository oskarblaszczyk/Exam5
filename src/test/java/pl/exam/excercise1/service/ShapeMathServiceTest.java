package pl.exam.excercise1.service;

import org.junit.Before;
import org.junit.Test;
import pl.exam.excercise1.model.Circle;
import pl.exam.excercise1.model.Rectangle;
import pl.exam.excercise1.model.Square;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ShapeMathServiceTest {

    private Circle c1;
    private Square s1;
    private Rectangle r1;

    @Before
    public void init() {
        c1 = new Circle(2.0);
        s1 = new Square(4.0);
        r1 = new Rectangle(4.0, 2.0);
    }

    @Test
    public void shouldReturnS1WithBiggestArea(){
        assertEquals(s1, ShapeMathService.biggestArea(Arrays.asList(c1,s1,r1)));
    }

    @Test
    public void shouldReturnC1WithBiggestPerimeterForType(){
        assertEquals(c1, ShapeMathService.biggestPerimeter(Arrays.asList(c1,s1,r1), Circle.class));
    }

}