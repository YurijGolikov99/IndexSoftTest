package api;

import api_module.Specifications;
import common_module.constants.PropertyPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static common_module.property.PropertyHelper.getProperty;

public class BaseTest {

    protected final Logger logger = LogManager.getRootLogger();
    private final Specifications specifications = new Specifications();

    protected Response sendGetRequest(String paramName, String countryCode) {
        try {
            return specifications.httpGetRequestWithQueryParameters(getProperty(PropertyPath.BASE_URL.getPath()), paramName, List.of(countryCode));
        } catch (Exception e) {
            logger.error("Failed to send GET request: {}", e.getMessage());
            throw new RuntimeException("Failed to send GET request", e);
        }
    }
}
