package task2;

import org.testng.Assert;
import org.testng.annotations.Test;
import task2.model.ModelOrders;

import java.io.IOException;

public class OrderPositiveTest {
    @Test(groups = {"POSITIVE", "FULL_PROCES",  "ALL"}, priority = 10, timeOut = 15600L, testName = "Positive Create|Get|Clear - Method API Order")
    public static void createOrderPositiveTest() throws IOException {

// Step-1
        String orderIdIn = "p29";
        System.out.println("Step1---Post:");

        ModelOrders firstResponse = new BaseTest().methodPost(
                "createOrder/" + ServiceData.getPartner(),
                StabDataTest1.getCreateStabInput(orderIdIn)
                );

        Assert.assertEquals(firstResponse.getStatusCode(), "IN_PROCESSING" );
//        Все тоже но в одну строку:
//        Assert.assertEquals(new BaseTest().methodPost(
//                "createOrder/" + ServiceData.getPartner(),
//                StabDataTest1.getCreateStabInput(orderIdIn)
//        ).getStatusCode(), "IN_PROCESSING" );
        ServiceData.sleepMode(2);

// Step-2
        System.out.println("Step2---Get:");
        ModelOrders twoRespose = new BaseTest().methodGet(
                "getOrder/" + ServiceData.getPartner()
                        +"/" + ServiceData.getPartner()
                        +"/?orderId=" + firstResponse.getOrderId()
                    );

        Assert.assertEquals(twoRespose.getOrderId(), firstResponse.getOrderId());
        Assert.assertEquals(twoRespose.getStatusCode(), "INST_ALLOWED_OK");

        ServiceData.sleepMode(2);


// Step-3
        System.out.println("Step3---Post:");

        ModelOrders requestClear = new BaseTest().methodPost(
                "cancelOrder/" + ServiceData.getPartner(),
                StabDataTest1.getClearStabInput(
                            twoRespose.getOrderId(),
                            null,
                            "cancelP"+twoRespose.getOrderId(),
                            "відмова клієнта")
        );
        ModelOrders expected = new ModelOrders(
                twoRespose.getOrderId(),
                null,
                "Отмена заказа с номером "+ firstResponse.getOrderId() + " в обработке.",
                "CANCEL_IS_OK");

        Assert.assertEquals(requestClear.getStatusCode(), expected.getStatusCode());
        Assert.assertEquals(requestClear.getStatusText(), expected.getStatusText());
    }

    @Test(groups = {"NEGATIVE", "CREATE_ORDER", "ALL"}, priority = 50, timeOut = 15600L, testName = "Negative Create- Партнер 'partnr' не зареєстрований у системі!")
    public static void createOrderNegativeTest() throws IOException {

        String orderIdIn = "p01";
        System.out.println("Negative Create- Партнер 'partnr' не зареєстрований у системі!");

        ModelOrders firstResponse = new BaseTest().methodPost(
                "createOrder/partnr",
                StabDataTest1.getCreateStabInput(orderIdIn)
        );
        Assert.assertEquals(firstResponse.getStatusCode(), "NO_PARTNERID");
        ServiceData.sleepMode(2);
    }
    @Test(groups = {"NEGATIVE",  "GET_ORDER", "ALL"}, priority = 70, timeOut = 15600L, testName = "Negative getOrder NO_IDS - Не передано ідентифікатор замовлення")
    public static void getOrderNoIdsNegativeTest() throws IOException {
        System.out.println("Negative getOrder NO_IDS - Не передано ідентифікатор замовлення");

        ModelOrders twoRespose = new BaseTest().methodGet(
                "getOrder/" + ServiceData.getPartner()
                        +"/" + ServiceData.getPartner()
                        +"/?orderId="
        );
        Assert.assertEquals(twoRespose.getStatusCode(), "NO_IDS");
        ServiceData.sleepMode(2);
    }

    @Test(groups = {"NEGATIVE", "GET_ORDER", "ALL"}, priority = 80, timeOut = 15600L, testName = "Negative getOrder NO_APP - Не передано ідентифікатор замовлення")
    public static void getOrderNoAppNegativeTest() throws IOException {
        System.out.println(" Negative getOrder NO_APP - Не передано ідентифікатор замовлення ");
        String orderIdIn = "p03";
        String messageIdIn = "B8F3737EE0712C81E0539B5A8F0854E7";
        ModelOrders twoRespose = new BaseTest().methodGet(
                "getOrder/" + ServiceData.getPartner()
                        +"/" + ServiceData.getPartner()
                        +"/?orderId="+orderIdIn+"&messageId="+messageIdIn
        );
        Assert.assertEquals(twoRespose.getStatusCode(), "NO_APP");
        ServiceData.sleepMode(2);
    }

    @Test(groups = {"NEGATIVE", "CONFIRM_ORDER", "ALL"}, priority = 90, timeOut = 15600L, testName = "Negative confirmOrder REQUEST_NOT_MATCH - Запит не можна обробити! Перевірте статус замовлення!")
    public static void confirmOrderNotMatchNegativeTest() throws IOException {
        System.out.println("Negative confirmOrder REQUEST_NOT_MATCH - Запит не можна обробити! Перевірте статус замовлення!");
        ModelOrders confirmResponse = new BaseTest().methodPost(
                "confirmOrder/"+ServiceData.getPartner(),
                StabDataTest1.getConfirmStabInput(
                        "с120",
                        "B8F3737EE0712C81E0539B5A8F0A34E7",
                        null,
                        null
                )
        );
        Assert.assertEquals(confirmResponse.getStatusCode(), "REQUEST_NOT_MATCH");
    }
}
