import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//PLEASE REPLACE BROILER PLATE FUNCTION NAME AND INPUT LINK!

public class AdventOfCodeDay2 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(".env"));
        String sessionCookie = prop.getProperty("SESSION_COOKIE");

        URL url = new URL(prop.getProperty("DAY_TWO_INPUT_URL"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Cookie", "session=" + sessionCookie);
        InputStream in = connection.getInputStream();
        Scanner scanner = new Scanner(in);
        
        //split the input by : to separate game number and game result

        Map<String, Integer> thresholds = new HashMap<>();
        thresholds.put("red", 12);
        thresholds.put("green", 13);
        thresholds.put("blue", 14);

        int gameTotal = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitInput = line.split(":");
            String gameTitle = splitInput[0];
            String[] splitTitle = gameTitle.split(" ");
            int gameNumber = Integer.parseInt(splitTitle[1]);
   
            String gameBody = splitInput[1];
            String[] games = gameBody.split(";");
            boolean exceedsThreshold = false;
            for (String game : games) {
                String[] colorCounts = game.split(",");
                for (String colorCount : colorCounts) {
                    String[] parts = colorCount.trim().split(" ");
                    int count = Integer.parseInt(parts[0]);
                    String color = parts[1];
                    if (count > thresholds.get(color)) {
                        exceedsThreshold = true;
                        break;
                    }
                }
                if (exceedsThreshold) {
                    break;
                }
            }
            if (!exceedsThreshold) {
                gameTotal += gameNumber;
            }
            System.out.println("Game number :" + gameNumber);
            System.out.println("Game Total :" + gameTotal);
        }
        scanner.close();
    }
}
