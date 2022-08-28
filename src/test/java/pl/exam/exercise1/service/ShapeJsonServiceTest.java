package pl.exam.exercise1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import pl.exam.exercise1.model.Circle;
import pl.exam.exercise1.model.Rectangle;
import pl.exam.exercise1.model.Square;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShapeJsonServiceTest {
    private ShapeJsonService shapeJsonService;
    private Circle c1;
    private Square s1;
    private Rectangle r1;
    private final File file = new File("src/test/resources/shapesTest.json");

    @Before
    public void init() {
        shapeJsonService = new ShapeJsonService(new ObjectMapper());
        c1 = new Circle(2.0);
        s1 = new Square(4.0);
        r1 = new Rectangle(4.0, 2.0);
    }

    @Test
    public void shouldReturnTrueWhenListsAreTheSame() throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write("[{\"type\":\"circle\",\"radius\":2.0},{\"type\":\"square\",\"a\":4.0}]");
        fw.close();
        assertEquals(shapeJsonService.importJson(file), Arrays.asList(c1, s1));
    }

    @Test
    public void shouldReturnTrueWhenSaveAllObjectsToFileProperly() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        shapeJsonService.generateJson(Arrays.asList(c1, r1), file);
        String read = br.readLine();
        br.close();
        String result = "[{\"type\":\"circle\",\"radius\":2.0},{\"type\":\"rectangle\",\"width\":4.0,\"height\":2.0}]";
        assertEquals(read, result);
    }


}