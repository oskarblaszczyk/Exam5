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

    private ShapeMathService shapeMathService;

    @Before
    public void init() {
        shapeMathService = new ShapeMathService();
        c1 = new Circle(2.0);
        s1 = new Square(4.0);
        r1 = new Rectangle(4.0, 2.0);
    }

    @Test
    public void shouldReturnS1WithBiggestArea(){
        assertEquals(s1, shapeMathService.biggestArea(Arrays.asList(c1,s1,r1)));
    }

    @Test
    public void shouldReturnTrueWhenC1HaveBiggestPerimeterForType(){
        assertEquals(c1, shapeMathService.biggestPerimeter(Arrays.asList(c1,s1,r1), Circle.class));
    }

    @Test
    public void shouldReturnFalseWhenC1HaveWithBiggestPerimeterForType(){
        assertNotEquals(s1, shapeMathService.biggestPerimeter(Arrays.asList(c1,s1,r1), Circle.class));
    }

    @Test
    public void shouldReturnTrueWhenShapesHaveCorrectPerimeter(){
        assertEquals(16.0, s1.perimeter(), 0.001);
        assertEquals(12.0, r1.perimeter(), 0.001);
        assertEquals(12.56, c1.perimeter(), 0.01);
    }

}