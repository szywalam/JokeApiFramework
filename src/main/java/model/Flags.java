package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class Flags{
    private Boolean nsfw;
    private Boolean religious;
    private Boolean political;
    private Boolean racist;
    private Boolean sexist;
    private Boolean explicit;
}
