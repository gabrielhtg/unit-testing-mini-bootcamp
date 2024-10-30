package gabrielhtg.maven.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorData {
    @JsonProperty()
    private String error;

    public String getError() {
        return error;
    }
}
