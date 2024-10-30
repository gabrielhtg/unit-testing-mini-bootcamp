package gabrielhtg.maven.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Item {
    @JsonProperty()
    private String id;

    @JsonProperty()
    private String name;

    @JsonProperty()
    private Map<String, Object> data;

    @JsonProperty()
    private String createdAt;

    @JsonProperty()
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return createdAt;
    }
}
