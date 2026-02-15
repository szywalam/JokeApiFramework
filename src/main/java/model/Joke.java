package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class Joke {
    private String category;
    private String type;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String setup;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String delivery;
    private Flags flags;
    private Boolean safe;
    private Integer id;
    private String lang;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String joke;
}
