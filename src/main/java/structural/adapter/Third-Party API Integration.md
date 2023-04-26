## Third-Party API Integration
When using a third-party API, you may need to adapt the API's interface to match your application's interface. For example, let's say you're using a weather API that provides weather data in XML format, but your application expects the data in JSON format. To make the API work with your application, you can create an adapter that adapts the XML data to JSON format. Here's an example of a `WeatherDataAdapter` class:
```java
public class WeatherDataAdapter implements WeatherData {
    private ThirdPartyWeatherAPI thirdPartyAPI;

    public WeatherDataAdapter(ThirdPartyWeatherAPI thirdPartyAPI) {
        this.thirdPartyAPI = thirdPartyAPI;
    }

    // Override the methods from WeatherData interface
    public String getTemperature() {
        String xmlTemperature = thirdPartyAPI.getTemperatureXML();
        String jsonTemperature = convertToJSON(xmlTemperature);
        return jsonTemperature;
    }

    // Convert the XML data to JSON format
    private String convertToJSON(String xmlData) {
        // Implementation omitted
        return jsonResult;
    }
}
```