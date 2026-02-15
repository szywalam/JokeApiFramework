package clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


public class JokeClient extends RestClient {

    public Response getJokes(JokeRequest request) {
        RequestSpecification spec = basicRequestSpecification();
        String path = (request.getCategories() == null)
                ? "Any"
                : String.join(",", request.getCategories());

        if (request.getLanguage() != null) {
            spec.queryParam("lang", request.getLanguage());
        }


        if (request.getBlacklistFlags() != null) {
            spec = spec.queryParam("blacklistFlags", String.join(",", request.getBlacklistFlags()));
        }

        if (request.getResponseFormat() != null) {
            spec = spec.queryParam("format", request.getResponseFormat());
        }

        if (request.getJokeType() != null) {
            spec = spec.queryParam("type", request.getJokeType());
        }

        if (request.getSearchQuery() != null) {
            spec = spec.queryParam("contains", request.getSearchQuery());
        }

        if (request.getLowerIdRange() != null || request.getUpperIdRange() != null) {
            int lower = request.getLowerIdRange() != null ? request.getLowerIdRange() : 0;
            int upper = request.getUpperIdRange() != null ? request.getUpperIdRange() : 1367;

            if (lower < 0 || upper > 1367 || lower > upper) {
                throw new IllegalArgumentException("Passed idRange is invalid: " + lower + "-" + upper);
            }

            spec = spec.queryParam("idRange", lower + "-" + upper);

        }

        if (request.getAmount() != null) {
            spec = spec.queryParam("amount", request.getAmount());
        }

        return spec.get(path);
    }

    /* START AI */
    @Builder
    @Getter
    public static class JokeRequest {
        private List<String> categories;
        private String language;
        private List<String> blacklistFlags;
        private String responseFormat;
        private String jokeType;
        private String searchQuery;
        private Integer lowerIdRange;
        private Integer upperIdRange;
        private Integer amount;
    }
    /* END AI */
}
