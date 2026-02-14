package model;

import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class MultipleJokes {
    private Boolean error;
    private Integer amount;
    private List<Joke> jokes;
}
