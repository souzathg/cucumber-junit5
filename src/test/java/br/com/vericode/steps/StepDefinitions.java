package br.com.vericode.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StepDefinitions {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String baseURL;
    Response response;
    OkHttpClient client = new OkHttpClient();

    @Given("the application is available at {string}")
    public void theApplicationIsAvailableAt(String url) throws IOException {
        baseURL = url;

        Request req = new Request.Builder()
                .url(baseURL + "/health")
                .get()
                .build();

        Call call = client.newCall(req);
        Response res = call.execute();

        String responseBody = res.body().string();

        assertEquals(200, res.code(), "The status code was different than 200");
        assertEquals("The application is running", responseBody, "The message was different than expected.");
    }

    @When("I send a payload containing two numbers: {double} and {double}, to {string}")
    public void iSendAPayloadContainingTwoNumbersAndTo(Double num1, Double num2, String path) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        String json = "{\"num1\":" + num1 + ", \"num2\":" + num2 + "}";
        RequestBody body = RequestBody.create(json, JSON);

        Request req = new Request.Builder()
                .url(baseURL + path)
                .post(body)
                .build();

        Call call = client.newCall(req);
        response = call.execute();

        assertEquals(200, response.code());

    }

    @Then("I should receive a response of {double}")
    public void iShouldReceiveAResponseOf(Double result) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();

        String responseBody = response.body().string();
        Double responseDouble = Double.parseDouble(responseBody);

        assertEquals(result, responseDouble, "The actual value differs from the expected");
    }
}
