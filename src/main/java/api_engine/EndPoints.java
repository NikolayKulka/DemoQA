package api_engine;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndPoints {

    private static final String BASE_URL = "https://demoqa.com";

    public static Response getBooks()
    {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);

        return request.get(Route.books());
    }
}
