package task2;

import com.fasterxml.jackson.core.type.TypeReference;
import task2.pojo.CardData;
import task2.pojo.UserIsCardData;

import java.io.IOException;
import java.util.List;

public class MainParser {
    private static ParseJSON parseJSON = new ParseJSON();

    public static void main(String[] args) throws IOException {

        System.out.println("========================");
        System.out.println("======= Task* 2.1 ==========");

        String json = "{\"isCardAccount\":false,\"data\":{\"order_id\":\"p100\"," +
                "\"message_id\":\"EB4BFBBCA7167857E0539B5A8F0ACB76\"},\"isRevaluation\":false," +
                "\"userId\":20069,\"userLogin\":\"55555F3\",\"docIds\":[597405],\"locale\":\"UA\"}\"\n";
        System.out.println("--Data Input " + json);

        InterfaceJson modelOne= parseJSON.toObject(json, CardData.class);
        System.out.println("Data OutPut: \n" + modelOne);

//      Проверка, что Обьект можно опять преобразовать к иходной строке
        System.out.println("toJson:\n"+  parseJSON.toJson(modelOne) );



        System.out.println("======= Task* 2.2 ==========");

        json = "[{\"isCard\":false,\"userPass\":\"test\",\"userLogin\":\"55555F3\",\"locale\":\"UA\"}," +
                "{\"isCard\":false,\"userPass\":\"test\",\"userLogin\":\"11111F3\",\"locale\":\"UK\"}," +
                "{\"isCard\":true,\"userPass\":\"test\",\"userLogin\":\"1001F3\",\"locale\":\"UA\"}," +
        "{\"isCard\":false,\"userPass\":\"test\",\"userLogin\":\"1001F3\",\"locale\":\"UA\"}" + "]";
        System.out.println("--Data Input " + json);

        List<UserIsCardData> ModelTwo = parseJSON.toObjectList( json, new TypeReference<>(){});

        System.out.println("Data OutPut:\n" + ModelTwo.toString());

//      Проверка, что Обьект можно опять преобразовать к иходной строке
        System.out.println("toJson :\n"+parseJSON.listToString((ModelTwo) ));

    }
}
