package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

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
