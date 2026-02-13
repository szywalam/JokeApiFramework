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
    private boolean error;
    private int amount;
    private List<Joke> jokes;
}
