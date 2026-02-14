package model;

import lombok.Data;
import java.util.ArrayList;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class NegativeResponse {
    public Boolean error;
    public Boolean internalError;
    public Integer code;
    public String message;
    public ArrayList<String> causedBy;
    public String additionalInfo;
    public Long timestamp;
}
