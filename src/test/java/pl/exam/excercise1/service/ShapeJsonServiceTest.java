package pl.exam.excercise1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import pl.exam.excercise1.controller.Shape;
import pl.exam.excercise1.model.Circle;
import pl.exam.excercise1.model.Rectangle;
import pl.exam.excercise1.model.Shapes;
import pl.exam.excercise1.model.Square;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShapeJsonServiceTest {
    private Circle c1;
    private Square s1;
    private Rectangle r1;
    private ShapeJsonService shapeJsonService;
    private final ObjectMapper om = new ObjectMapper();


    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        shapeJsonService = new ShapeJsonService(om);
        c1 = new Circle(2.0);
        s1 = new Square(4.0);
        r1 = new Rectangle(4.0, 2.0);
    }

    @Test
    public void shoulReturnTrueWhenSaveAllObjectsToFileProperly() throws IOException {
        shapeJsonService.generateJson(Arrays.asList(c1, s1, r1), new File("test"));
        Shapes result = new ObjectMapper().readValue(new File("test"), Shapes.class);
        assertEquals(Arrays.asList(c1, s1, r1), result.getShapes());
    }

    @Test
    public void test() throws IOException {
        File importTest = new File("importTest");
        PrintWriter pw = new PrintWriter(importTest);
        pw.println("{\"shapes\":[{\"type\":\"square\",\"a\":2.0}]}");
        pw.close();
        Shape s = shapeJsonService.importJson(new File("importTest")).get(0);
        Square s2 = new Square(2.0);
        assertEquals(s,s2);
    }

}