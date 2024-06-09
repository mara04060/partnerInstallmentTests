package task2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import task2.model.ModelOrders;

public class StabDataTest1 {
    public static String getCreateStabInput(String mPhone,
                                            String panEnd,
                                            String shopId,
                                            String orderId,
                                            String orderSum,
                                            String orderTerm,
                                            String eMailPartner,
                                            String calBackUrl) throws JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(new ModelOrders(
                mPhone,
                panEnd,
                shopId,
                orderId,
                orderSum,
                orderTerm,
                eMailPartner,
                calBackUrl
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
