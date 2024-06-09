package task2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.*;
import task2.model.ModelOrders;


public class BaseTest {
    private RequestSpecification startRequestSpecificatiuon(){
        return RestAssured.given()
                    .baseUri(ServiceData.getBaseUrl())
                .when().log().body()
                    .auth()
                    .preemptive()
                    .basic(ServiceData.getUsername(),    ServiceData.getPassword() );
    }
    public ModelOrders methodPost(String postUrl, String jsonBody){
        return startRequestSpecificatiuon()
                    .contentType(ContentType.JSON)
                    .body(jsonBody)
                    .post(postUrl)
                .then().log().body()
                    .assertThat()
                    .statusCode(200)
                .extract()
                    .as(ModelOrders.class);
    }
    public ModelOrders methodGet(String getUrl){
        return startRequestSpecificatiuon()
                    .get(getUrl)
                .then().log().body()
                    .assertThat()
                    .statusCode(200)
                .extract()
                .as(ModelOrders.class);
    }

}
