package informants;

import org.json.JSONException;
import tools.GeoDataParser;
import tools.RequestCreator;

import java.io.IOException;
import java.util.Scanner;

public class Dialog {
    private static final String INFO_COM_ID = "INFO";
    private static final String LOCATION_COM_ID = "GET /location/";
    private static final String FINISH_ID = "END";

    private static final String WEBSITE_URI = "https://freegeoip.app/json/";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printInfo();
        String answer;
        do {
            answer = sc.nextLine();
        }
        while (performCommand(answer));
    }

    /**
     * Prints info about possible commands.
     */
    private static void printInfo() {
        System.out.println("Now there are only two commands:");
        System.out.printf("%s - prints information about possible commands%n", INFO_COM_ID);
        System.out.printf("%s - prints information about your current location%n", LOCATION_COM_ID);
        System.out.printf("%s - to finish execution\n%n", FINISH_ID);
    }

    /**
     * Compute current user location.
     */
    private static void getLocation() {
        try {
            System.out.println(GeoDataParser.parseLocation("{\"country_name\":\"Nibiru\",\"region_name\":\"Nibiru - city 1\",\"city\":\"city 1\",\"latitude\":34.8515,\"longitude\":99.3745}"));
//        } catch (IOException e) {
//            System.out.println("There are some problems with connection. Check if it's work and try again.");
        } catch (JSONException e) {
            System.out.println("Incorrect response from the server. Please, contact technical support.");
        }
    }

    /**
     * Tells user that it's incorrect command.
     */
    private static void wrongCommand() {
        System.out.println("Incorrect command. Please try again or use \"INFO\" command to get some info.");
    }

    /**
     * Reads user command and calls appropriate methods.
     * @param commandID user's command
     * @return should program still running
     */
    private static boolean performCommand(String commandID) {
        switch (commandID) {
            case INFO_COM_ID:
                printInfo();
                break;
            case LOCATION_COM_ID:
                getLocation();
                break;
            case FINISH_ID:
                return false;
            default:
                wrongCommand();
                break;
        }
        return true;
    }
}
