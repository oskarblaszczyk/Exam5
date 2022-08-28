package pl.exam.exercise1.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import pl.exam.exercise1.model.Shape;

import java.io.File;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class ShapeJsonService {
    private final ObjectMapper om;

    public void generateJson(List<Shape> shapes, File file) throws IOException {
        om.writeValue(file, shapes);
    }

    public List<Shape> importJson(File file) throws IOException {
        return om.readValue(file, new TypeReference<>() {
        });
    }
}