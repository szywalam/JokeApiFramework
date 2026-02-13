package model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class SingleJoke {
    private boolean error;
    @JsonUnwrapped
    private Joke joke;
}
