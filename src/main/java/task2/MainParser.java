package task2;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.List;

public class MainParser {

    public static void main(String[] args) throws IOException {
        String json = "{\"isCardAccount\":false,\"data\":{\"order_id\":\"p100\"," +
                "\"message_id\":\"EB4BFBBCA7167857E0539B5A8F0ACB76\"},\"isRevaluation\":false," +
                "\"userId\":20069,\"userLogin\":\"55555F3\",\"docIds\":[597405],\"locale\":\"UA\"}\"\n";
        ModelJson modelOne= JsonToPojo.parse(json, ModelDataAll.class);
        System.out.println("========================");
        System.out.println("======= Task* 2.1 ==========");
        System.out.println("--Data Input " + json);
        System.out.println("Data OutPut:");
        System.out.println(modelOne);


        json = "[{\"isCard\":false,\"userPass\":\"test\",\"userLogin\":\"55555F3\",\"locale\":\"UA\"}," +
                "{\"isCard\":true,\"userPass\":\"test\",\"userLogin\":\"11111F3\",\"locale\":\"UK\"}]";
        Object ModelTwo = JsonToPojo.parseList(json, new TypeReference<List<ModelUserData>>(){});
        System.out.println("======= Task* 2.2 ==========");
        System.out.println("--Data Input " + json);
        System.out.println("Data OutPut:");
        System.out.println(ModelTwo);
    }
}
