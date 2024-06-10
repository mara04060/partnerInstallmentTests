package task2;

import org.testng.Assert;
import org.testng.annotations.*;
import task2.model.ModelOrders;

import java.io.IOException;

public class OrderAllTest {
    @Test(groups = {"POSITIVE", "FULL_PROCES",  "ALL"}, priority = 10, timeOut = 15600L, testName = "Positive Create|Get|Clear - Method API Order")
    public static void createOrderPositiveTest() throws IOException {

// Step-1
        ModelOrders firstResponse = new BaseTest().methodPost(
                "createOrder/" + ServiceData.getPartner(),
                DataProviderMethod.getCreateOrderDataInput(
                            ServiceData.getMPhone(),
                            ServiceData.getPanEnd(),
                            ServiceData.getShopId(),
                            ServiceData.getOrderId(),
                            ServiceData.getOrderSum(),
                            ServiceData.getOrderTerm(),
                            ServiceData.getOrderTerm(),
                            ServiceData.getCalBackUrlr()
                    )
                );
        Assert.assertEquals(firstResponse.getStatusCode(), ServiceData.StatusCode.IN_PROCESSING.toString() );

        ServiceData.sleepMode(2);

// Step-2
        System.out.println("Step2---Get:");
        ModelOrders twoRespose = new BaseTest().methodGet(
                "getOrder/" + ServiceData.getPartner()
                        +"/" + ServiceData.getPartner()
                        +"/?orderId=" + firstResponse.getOrderId() +"&messageId="+firstResponse.getMessageId()
                    );

        Assert.assertEquals(twoRespose.getOrderId(), firstResponse.getOrderId());
        Assert.assertEquals(twoRespose.getStatusCode(), ServiceData.StatusCode.INST_ALLOWED_OK.toString());

        ServiceData.sleepMode(2);

// Step-3
        ModelOrders requestClear = new BaseTest().methodPost(
                "cancelOrder/" + ServiceData.getPartner(),
                DataProviderMethod.getCleaOrderDataInput(
                            twoRespose.getOrderId(),
                            null,
                            "cancelP"+twoRespose.getOrderId(),
                            ServiceData.getReasonCancel())
        );
        ModelOrders expected = new ModelOrders(
                twoRespose.getOrderId(),
                null,
                "Отмена заказа с номером "+ firstResponse.getOrderId() + " в обработке.",
                ServiceData.StatusCode.CANCEL_IS_OK.toString() );

        Assert.assertEquals(requestClear.getStatusCode(), expected.getStatusCode());
        Assert.assertEquals(requestClear.getStatusText(), expected.getStatusText());
    }

    @DataProvider(name = "postOrderTest")
    public Object[][] postOrderDataTest() {
        return new Object[][] {
            {   "partnr",
                ServiceData.getMPhone(),
                ServiceData.getPanEnd(),
                ServiceData.getShopId(),
                "p01",
                ServiceData.getOrderSum(),
                ServiceData.getOrderTerm(),
                ServiceData.getEMailPartner(),
                ServiceData.getCalBackUrlr(),
                ServiceData.StatusCode.NO_PARTNERID.toString()
            },

            {   ServiceData.getPartner(),
                ServiceData.getMPhone(),
                "965",
                ServiceData.getShopId(),
                "p15",
                "1216.00",
                ServiceData.getOrderTerm(),
                ServiceData.getEMailPartner(),
                ServiceData.getCalBackUrlr() ,
                ServiceData.StatusCode.MATCH_ORDERID.toString()
            }
        };
    }
    @Test(groups = {"NEGATIVE", "CREATE_ORDER", "ALL"}, priority = 50, dataProvider = "postOrderTest",timeOut = 15600L, testName = "Negative CreateOrder")
    public static void createOrderNegativeTest(
           String partner,
           String mPhone,
           String panEnd,
           String shopId,
           String orderId,
           String orderSum,
           String orderTerm,
           String eMailPartner,
           String calBackUrl,
           String expectedStatusCode) throws IOException {


        Assert.assertEquals( new BaseTest().methodPost(
                "createOrder/"+partner,
                DataProviderMethod.getCreateOrderDataInput(
                        mPhone,
                        panEnd,
                        shopId,
                        orderId,
                        orderSum,
                        orderTerm,
                        eMailPartner,
                        calBackUrl
                )
        ).getStatusCode(), expectedStatusCode );
    }
    @DataProvider(name = "getOrderTest1")
    public Object[][] getOrderDataTest1() {
        return new Object[][] {{"","", ServiceData.StatusCode.NO_IDS.toString() },
                {"p03","", ServiceData.StatusCode.NO_APP.toString() }};
    }
    @Test(groups = {"NEGATIVE",  "GET_ORDER", "ALL"}, priority = 70, dataProvider = "getOrderTest1", timeOut = 15600L, testName = "Negative getOrder")
    public static void getOrderNoIdsNegativeTest(String orderIdIn, String messageIdIn, String expectedStatus) {

        ModelOrders twoRespose = new BaseTest().methodGet(
                "getOrder/" + ServiceData.getPartner()
                        +"/" + ServiceData.getPartner()
                        +"/?orderId="+orderIdIn+"&messageId="+messageIdIn
        );
        Assert.assertEquals(twoRespose.getStatusCode(), expectedStatus);
    }

    @DataProvider(name = "confirmOrderTest")
    public Object[][] confirmOrderTest() {
        return new Object[][] {{"с196","B8F3737EE0712C81E0539B5A8F0854E7", ServiceData.StatusCode.NO_APP.toString() },
                {"c120", "B8F3737EE0712C81E0539B5A8F0A34E7", ServiceData.StatusCode.REQUEST_NOT_MATCH.toString() }};
    }
    @Test(groups = {"NEGATIVE", "CONFIRM_ORDER", "ALL"}, priority = 90, dataProvider = "confirmOrderTest", timeOut = 15600L, testName = "Negative confirmOrder")
    public static void confirmOrderNotMatchNegativeTest(String orderIdIn, String messageIdIn, String expectedCodeStatus ) throws IOException {
         ModelOrders confirmResponse = new BaseTest().methodPost(
                "confirmOrder/"+ServiceData.getPartner(),
                DataProviderMethod.getConfirmOrderDataInput(
                        orderIdIn,
                        messageIdIn,
                        null,
                        null
                )
        );
        Assert.assertEquals(confirmResponse.getStatusCode(), expectedCodeStatus);
    }
}
