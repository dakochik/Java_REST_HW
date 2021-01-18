package tools;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeoDataParserTester {

    @Test
    public void testCorrectDataParse(){
        String answer = "country_name:Nibiru,region_name:Nibiru - city 1,city:city 1,latitude:34.8515,longitude:99.3745";
        String request = "{\"name\":\"Oleg\",\"country_name\":\"Nibiru\",\"region_name\":\"Nibiru - city 1\",\"city\":\"city 1\",\"latitude\":34.8515,\"longitude\":99.3745}";
        Assertions.assertEquals(GeoDataParser.parseLocation(request), answer);
    }

    @Test
    public void testExceptionDAtaParse(){
        String request = "{\"name\":\"Oleg\",\"couu\",\"regio\":\"Nibiru - city 1\",\"city\":\"city 1\",\"latitude\":34.8515,\"longitude\":99.3745}";
        Assertions.assertThrows(JSONException.class, ()->GeoDataParser.parseLocation(request));
    }
}
