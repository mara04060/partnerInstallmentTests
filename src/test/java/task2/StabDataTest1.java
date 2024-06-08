package task2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import task2.model.ModelOrders;

public class StabDataTest1 {
    public static String getCreateStabInput(String orderId) throws JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(new ModelOrders(
                "+380967896608",
                "9654",
                "46546-БwfqК",
                orderId,
                "121600",
                "9",
                "test@mytestemail.com",
                "https://dpartnapu01.sensebank.com.ua:8243/installmentseventwo/orders"
        ));
    }

    public static String getConfirmStabInput(String orderId, String messageId, String cancelId, String statusCode) throws JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(new ModelOrders(
                orderId,
                messageId,
                cancelId,
                statusCode
        ));
    }

    /** Example
     *
     * @return ModelOrders  POJO
     */
    public static ModelOrders  getCreateActualStabOutput(){
        return new ModelOrders(
                "NO_APP",
                "Заказ не найден!",
                "19E9833406F9423AE0639B5A8F0A61FC",
                "p12"
        );
    }

    public static String getClearStabInput(String orderId,
                                           String messageId,
                                           String cancelId,
                                           String reasonCancel) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new ModelOrders(
                orderId,
                messageId,
                cancelId,
                reasonCancel,
                null
        ));
    }
}
