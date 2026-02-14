package controllers;

import clients.JokeClient;
import model.MultipleJokes;
import model.NegativeResponse;
import model.SingleJoke;
import io.qameta.allure.Step;
import clients.JokeClient.JokeRequest;
import io.restassured.response.Response;

public class JokeController {

    private final static JokeClient jokeClient = new JokeClient();

    @Step("Get any Joke using Joke API")
    public SingleJoke getJoke() {
        JokeRequest request = JokeRequest.builder()
                .build();
        Response createResponse = jokeClient.getJokes(request);
        return createResponse.as(SingleJoke.class);
    }

    @Step("Get a joke with known ID")
    public SingleJoke getJokeById(int id) {
        JokeRequest request = JokeRequest.builder()
                .lowerIdRange(id)
                .upperIdRange(id)
                .build();
        Response createResponse = jokeClient.getJokes(request);
        return createResponse.as(SingleJoke.class);
    }

    @Step("Get multiple jokes using Joke API")
    public MultipleJokes getMultipleJokes(int numberOfJokes) {
        JokeRequest request = JokeRequest.builder()
                .amount(numberOfJokes)
                .build();
        Response createResponse = jokeClient.getJokes(request);
        return createResponse.as(MultipleJokes.class);
    }

    @Step("Get a negative response using Joke API")
    public NegativeResponse getNegativeJoke() {
        JokeRequest request = JokeRequest.builder()
                .language("aaaaa")
                .build();
        Response createResponse = jokeClient.getJokes(request);
        return createResponse.as(NegativeResponse.class);
    }

}
