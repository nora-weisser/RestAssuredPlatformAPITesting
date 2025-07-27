package config;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigUtil {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getBaseUrl() {
        return dotenv.get("BASE_URL");
    }

    public static String getApiKey() {
        return dotenv.get("API_KEY");
    }
}
