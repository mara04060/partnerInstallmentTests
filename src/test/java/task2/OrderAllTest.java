package task2;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import task2.model.Order;

import java.io.IOException;

public class OrderAllTest {
    private BaseTest baseTest = new BaseTest();
    
    
    @Test(groups = {"POSITIVE", "FULL_PROCES",  "ALL"}, priority = 10, timeOut = 15600L, testName = "Positive Create|Get|Clear - Method API Order")
    public void createOrderPositiveTest() throws IOException {

// Step-1
        Order firstResponse = baseTest.methodPost(
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
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstResponse.getStatusCode(), ServiceData.StatusCode.IN_PROCESSING.toString() );

// Step-2
        Order twoRespose = baseTest.methodGet(
                "getOrder/" + ServiceData.getPartner()
                        +"?orderId=" + firstResponse.getOrderId()+"&messageId=" + firstResponse.getMessageId()
                    );
        softAssert.assertEquals(twoRespose.getOrderId(), firstResponse.getOrderId());
        softAssert.assertEquals(twoRespose.getStatusCode(), ServiceData.StatusCode.INST_ALLOWED_OK.toString());


// Step-3
        Order requestClear = baseTest.methodPost(
                "cancelOrder/" + ServiceData.getPartner(),
                DataProviderMethod.getCleaOrderDataInput(
                            twoRespose.getOrderId(),
                            twoRespose.getMessageId(),
                            "cancelPart-140-01",
                            "відмова клієнта")
        );
        Order expected = new Order(
                twoRespose.getOrderId(),
                null,
                "Отмена заказа с номером "+ firstResponse.getOrderId() + " в обработке.",
                ServiceData.StatusCode.CANCEL_IS_OK.toString() );


        softAssert.assertEquals(requestClear.getStatusCode(), expected.getStatusCode());
        softAssert.assertEquals(requestClear.getStatusText(), expected.getStatusText());
        softAssert.assertAll();
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
    public void createOrderNegativeTest(
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


        Assert.assertEquals( baseTest.methodPost(
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
    public void getOrderNoIdsNegativeTest(String orderIdIn, String messageIdIn, String expectedStatus) {

        Order twoRespose = baseTest.methodGet(
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
    public void confirmOrderNotMatchNegativeTest(String orderIdIn, String messageIdIn, String expectedCodeStatus ) throws IOException {
         Order confirmResponse = baseTest.methodPost(
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
