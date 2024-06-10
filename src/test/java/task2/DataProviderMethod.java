package task2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import task2.model.Order;

public class DataProviderMethod {

    public static String getCreateOrderDataInput(String mPhone,
                                                 String panEnd,
                                                 String shopId,
                                                 String orderId,
                                                 String orderSum,
                                                 String orderTerm,
                                                 String eMailPartner,
                                                 String calBackUrl) throws JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(
                new Order(
                    mPhone,
                    panEnd,
                    shopId,
                    orderId,
                    orderSum,
                    orderTerm,
                    eMailPartner,
                    calBackUrl
            )
        );
    }

    public static String getConfirmOrderDataInput(String orderId,
                                                  String messageId,
                                                  String cancelId,
                                                  String statusCode) throws JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(
                new Order(
                    orderId,
                    messageId,
                    cancelId,
                    statusCode
            )
        );
    }

    public static String getCleaOrderDataInput(String orderId,
                                               String messageId,
                                               String cancelId,
                                               String reasonCancel) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(
                new Order(
                    orderId,
                    messageId,
                    cancelId,
                    reasonCancel,
                    null
            )
        );
    }

}
