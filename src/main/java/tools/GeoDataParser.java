package tools;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class with only one method, which parse string, which contains info about your location.
 */
public class GeoDataParser {
    public static final String COUNTRY_NAME_ID = "country_name";
    public static final String REGION_NAME_ID = "region_name";
    public static final String CITY_ID = "city";
    public static final String LATITUDE_ID = "latitude";
    public static final String LONGITUDE_ID = "longitude";

    /**
     * Returns information about current location, using the following pattern:
     * {@value COUNTRY_NAME_ID}:{your country name},{@value REGION_NAME_ID},{your region name},{@value CITY_ID}:{city name},{@value LATITUDE_ID}:{your latitude},{@value LONGITUDE_ID}:{your longitude}
     *
     * @param response response from server with location info.
     * @return information about your current location for the mentioned pattern
     * @throws JSONException if one or more fields from the pattern are missing
     */
    public static String parseLocation(String response) throws JSONException {
        StringBuilder result = new StringBuilder();
        JSONObject object = new JSONObject(response);

        result.append(COUNTRY_NAME_ID);
        result.append(":");
        result.append(object.getString(COUNTRY_NAME_ID));
        result.append(',');

        result.append(REGION_NAME_ID);
        result.append(":");
        result.append(object.getString(REGION_NAME_ID));
        result.append(',');

        result.append(CITY_ID);
        result.append(":");
        result.append(object.getString(CITY_ID));
        result.append(',');

        result.append(LATITUDE_ID);
        result.append(":");
        result.append(object.getDouble(LATITUDE_ID));
        result.append(',');

        result.append(LONGITUDE_ID);
        result.append(":");
        result.append(object.getDouble(LONGITUDE_ID));

        return result.toString();
    }
}
