package pl.exam.excercise1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.exam.excercise1.controller.Shape;
import pl.exam.excercise1.model.Shapes;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ShapeJsonService {
    private ObjectMapper om;

    public ShapeJsonService(ObjectMapper om) {
        this.om = om;
    }

    public void generateJson(List<Shape> shapes, File file) throws IOException {
        Shapes shapesSerialization = new Shapes(shapes);
        om.writeValue(file, shapesSerialization);
    }

    public  List<Shape> importJson(File file) throws IOException {
        Shapes shapesDeserialization = om.readValue(file, Shapes.class);
        return shapesDeserialization.getShapes();
    }
}