package task2;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;


public class JsonToPojo {

    public InterfaceJson parse(String json, Class className ) throws IOException {;
        return (InterfaceJson) new ObjectMapper().readValue(json.getBytes(), className);
    }

    public  String unParse(InterfaceJson model) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(model);
    }

    public <T> List<T> parseList(String json, TypeReference<List<T>> className ) throws IOException {
        return new ObjectMapper().readValue(json.getBytes(), className) ;
    }

    public  <T> String unParseList(List<T> model) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(model.toArray());
    }

}
