package task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ServiceData {
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sleepMode(int time){
        try {
            Thread.sleep(time*1000); // Время указывается в миллисекундах
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

}