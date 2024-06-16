package task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ServiceData {
    public static final String CONFIG_FILE = "src/test/resources/config.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum StatusCode {
        NO_PARTNERID,
        MATCH_ORDERID,
        INVALID_ORDERID,
        INVALID_MPHONE,
        INVALID_PANEND,
        INVALID_ORDERSUM,
        INVALID_ORDERTERM,
        INVALID_CALLBACKURL,
        ORDERSUM_EXCEEDS,
        ORDERSUM_LOW,
        PAC_NOT_SUCCESS,
        PAC_IS_REVERSED,
        PAC_DUP_COMPL,
        PAC_DAY_LMT_EXC,
        PAC_AMOUNT_EXT,
        PAC_ERROR,
        PAC_NOT_FOUND,
        INVALID_EMAIL,
        IN_PROCESSING,

        REQUEST_NOT_MATCH,
        GUARANTEE_IS_FAIL,
        NO_APP,
        NO_IDS,
        INST_ALLOWED_OK,
        CANCEL_IS_OK,
        FINAL_CANCEL_OK
    }
    static String getBaseUrl() {
        return properties.getProperty("api.url");
    }

    static String getUsername() {
        return properties.getProperty("api.username");
    }

    static String getPassword() {
        return properties.getProperty("api.password");
    }
    static String getPartner() {
        return properties.getProperty("api.partner");
    }
    static String getOrderId() {
        return properties.getProperty("data.orderId");
    }
    static String getMPhone() {
        return properties.getProperty("data.mPhone");
    }
    static String getPanEnd() {
        return properties.getProperty("data.panEnd");
    }
    static String getShopId() {
        return properties.getProperty("data.shopId");
    }
    static String getOrderSum() {
        return properties.getProperty("data.orderSum");
    }
    static String getOrderTerm() {
        return properties.getProperty("data.orderTerm");
    }
    static String getEMailPartner() {
        return properties.getProperty("data.eMailPartner");
    }
    static String getCalBackUrlr() {
        return properties.getProperty("data.calBackUrl");
    }
    static String getReasonCancel() {
        return properties.getProperty("data.reasonCancel");
    }

    public static void sleepMode(int time){
        try {
            Thread.sleep(time * 1000); // Время указывается в миллисекундах
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}