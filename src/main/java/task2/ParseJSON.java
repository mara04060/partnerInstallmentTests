package task2;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;


public class ParseJSON {
    private ObjectMapper mapper = new ObjectMapper();


    public InterfaceJson toObject(String json, Class className ) throws IOException {;
        return (InterfaceJson) mapper.readValue(json.getBytes(), className);
    }

    public  String toJson(InterfaceJson model) throws JsonProcessingException {
        return mapper.writeValueAsString(model);
    }

    public <T> List<T> toObjectList(String json, TypeReference<List<T>> className ) throws IOException {
        return mapper.readValue(json.getBytes(), className) ;
    }

    public  <T> String listToString(List<T> model) throws JsonProcessingException {
        return mapper.writeValueAsString(model.toArray());
    }

}
