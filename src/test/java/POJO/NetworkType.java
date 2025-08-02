package POJO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum NetworkType {
    SLACK, LINKEDIN, EMAIL, WEBSITE, GITHUB, INSTAGRAM, TWITTER;

    @JsonCreator
    public static NetworkType fromValue(String value) {
        return NetworkType.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
