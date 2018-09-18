package testcase;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.IsEqual.equalTo;

public class getSaltWithoutSign {
    @Test
    public void testGetSalt(){
        String responsecode ="SUCCESS";
        Map<String,Object> jsonAsMap= new HashMap<>();
        jsonAsMap.put("service","salt_value");
        jsonAsMap.put("partnerId","188888888888");
        jsonAsMap.put("signType","RSA");
        jsonAsMap.put("sign","");
        jsonAsMap.put("symbol","123");

        given().log().all().
                contentType(JSON).
                body(jsonAsMap).
                when().
                post("http://otcg.test.tigerft.com/otcg/recv").
                then().log().all().
                statusCode(200).
                assertThat().body("responseCode",equalTo("1006")).
                assertThat().body("responseMessage",equalTo("sign需必填"));
    }
}
