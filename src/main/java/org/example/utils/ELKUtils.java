package org.example.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.enums.ConfigProperties;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * This class is for interacting with Kibana.
 * <p>
* 2023/8/29
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class ELKUtils {
    private ELKUtils() {

    }

    /**
     * Send data to elasticsearch.
     * <p>
    * 2023/8/30
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @param testName
     * @param testResult
    */
    public static void post(String testName, String testResult) {
        if (PropertiesUtils.getValue(ConfigProperties.RESULTTOELK).equalsIgnoreCase("yes")) {
            Map<String, String> map = new HashMap<>();
            map.put("testName", testName);
            map.put("status", testResult);
            map.put("executeionTime", LocalDateTime.now().toString());

            given()
                    .contentType(ContentType.JSON)
                    .body(map)
                    .post(PropertiesUtils.getValue(ConfigProperties.ELASTICURL))
                    .then()
                    .log()
                    .body()
                    .extract().response();
        }
    }
}
