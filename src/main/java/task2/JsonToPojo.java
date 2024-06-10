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

    public List<ModelUserIsCardData> parseList(String json, TypeReference<List<ModelUserIsCardData>> className ) throws IOException {
        return new ObjectMapper().readValue(json.getBytes(),  className) ;
    }

    public  String unParseList(List<InterfaceJsonList> model) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(model.toArray());
    }

}
