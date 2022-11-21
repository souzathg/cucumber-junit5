package br.com.vericode.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StepDefinitions {
    String baseURL;

    @Given("the application is available at {string}")
    public void theApplicationIsAvailableAt(String url) throws IOException {
        baseURL = url;

        OkHttpClient client = new OkHttpClient();

        Request req = new Request.Builder()
                .url("http://" + baseURL + "/health")
                .get()
                .build();

        Call call = client.newCall(req);
        Response res = call.execute();

        String responseBody = res.body().string();

        assertEquals(res.code(), 200, "The status code was different than 200");
        assertEquals(responseBody, "The application is running.", "The message was different than expected.");
    }

    @When("I send a payload containing two numbers: {double} and {double}, to {string}")
    public void iSendAPayloadContainingTwoNumbersAndTo(Double double1, Double double2, String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should receive a response of {double}")
    public void iShouldReceiveAResponseOf(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
