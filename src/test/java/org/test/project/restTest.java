package org.test.project;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class restTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);


    @Test
    public void restEndpointTest() throws Exception {
        String postMessage = "Make this into chars";
        char[] chars = postMessage.toCharArray();

        //for unit testing only
        stubFor(post(urlEqualTo("/charArray"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/plain")
                        .withBody(postMessage)));

        Response response =
                given().
                        body(chars).
                        when().
                        post("http://localhost:8089/charArray").
                        then().
                        extract().
                        response();
        int status = response.getStatusCode();

        assertThat(status, is(200));
        assertThat("The response from the endpoint was not a string of the original characters", response.asString(), is(postMessage));
    }
}
