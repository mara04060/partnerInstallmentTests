package task2;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonToPojo {

    public  ModelJson parse(String json, Class className ) throws IOException {;
        return (ModelJson) new ObjectMapper().readValue(json.getBytes(), className);
    }

    public  String unParse(ModelJson model) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(model);
    }

    public List<ModelUserDataJson> parseList(String json, TypeReference className ) throws IOException {;
        return (List<ModelUserDataJson>) new ObjectMapper().readValue(json.getBytes(), className);
    }

}
