package APITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class BDDStyleGetRequest {

	protected static final String API_KEY="c34f2f19f3cd9caa0fcce6b864abd4d9";
	private static final String BASE_STATION_URI = "http://api.openweathermap.org/data/2.5/weather";

	 protected static ResponseOptions<Response> currentResponse = null;

	@Test
	public static void getResponseBody2() {
		currentResponse= getcurrentWeather(API_KEY,"Meerut");
		getStatusCode(currentResponse);
	}


	
    public static String getStatusCode(ResponseOptions<Response> resp) {
    	System.out.println(String.valueOf(((RestAssuredResponseImpl) resp).then().extract().statusCode()));
        return String.valueOf(((RestAssuredResponseImpl) resp).then().extract().statusCode());
    }

	
    public static ResponseOptions<Response> getcurrentWeather(String apiKey, String cityName ) {
        ResponseOptions<Response> responseOptionReturn = null;
        try {
            responseOptionReturn = RestAssured.given()
    				.when().get(BASE_STATION_URI+"?q="+cityName+"&appid="+apiKey);
        } catch (Exception ex) {
            System.out.println("EXCEPTION!: " + ex.getMessage());
        }
        return responseOptionReturn;
    }
    
    
}
