package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class Joke{
    private String category;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String type;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String setup;
    private String delivery;
    private Flags flags;
    private boolean safe;
    private int id;
    private String lang;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String joke;
}
