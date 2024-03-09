package mg.librarymanager.configuration;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class Config {

    private static Config instance = null;
    private static Properties properties;

    private Config() {
        loadConfig();
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    private void loadConfig() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            //logowanie todo
            e.printStackTrace();
        }
    }

    public Integer getLecturerLimit() {
        return Integer.valueOf(properties.getProperty("lecturer_limit"));
    }

    public Integer getStudentLimit() {
        return Integer.valueOf(properties.getProperty("student_limit"));
    }

    public Integer getPersonOutOfUniversityLimit() {
        return Integer.valueOf(properties.getProperty("person_out_of_university_limit"));
    }

    public static BigDecimal getLowerValueDailyPunishment() {
        return new BigDecimal(properties.getProperty("lower_tier_punishment"));
    }

    public static BigDecimal getHigherValueDailyPunishment() {
        return new BigDecimal(properties.getProperty("higher_tier_punishment"));
    }

    public Integer gerLowerDaysLimitToPunishment(){
        return Integer.valueOf(properties.getProperty("lower_days_limit_to_punishment"));
    }

    public Integer gerHigherDaysLimitToPunishment(){
        return Integer.valueOf(properties.getProperty("higher_days_limit_to_punishment"));
    }

   private String getProperty(String key) {
        return properties.getProperty(key);
    }
}
