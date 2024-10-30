package gabrielhtg.maven.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageData {
    @JsonProperty()
    private String message;

    public String getMessage() {
        return message;
    }
}
