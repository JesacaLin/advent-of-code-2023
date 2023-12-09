import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//PLEASE REPLACE BROILER PLATE FUNCTION NAME AND INPUT LINK!

public class AdventOfCodeDay2_5 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(".env"));
        String sessionCookie = prop.getProperty("SESSION_COOKIE");

        URL url = new URL(prop.getProperty("DAY_TWO_INPUT_URL"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Cookie", "session=" + sessionCookie);
        InputStream in = connection.getInputStream();
        Scanner scanner = new Scanner(in);

        int sum = 0;
        
        //Need to find the highest occurrence of count of a particular color
            //need variables to store highest variables for each color
            //iterate and compare the values, replace with higher if it encounters it.
        //Power calculations
            //multiple the top values of three colors
        //add to sum
    
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitInput = line.split(":");

            int highRed = 0;
            int highGreen = 0;
            int highBlue = 0;
   
            String gameBody = splitInput[1];
            String[] games = gameBody.split(";");
            for (String game : games) {
                String[] colorCounts = game.split(",");
                for (String colorCount : colorCounts) {
                    String[] parts = colorCount.trim().split(" ");
                    int count = Integer.parseInt(parts[0]);
                    String color = parts[1];
                    if (color.equals("red") && count > highRed) {
                        highRed = count;
                    }
                    if (color.equals("green") && count > highGreen) {
                        highGreen = count;
                    }
                    if (color.equals("blue") && count > highBlue) {
                        highBlue = count;
                    }
                }
                
            }
            int power = highRed * highGreen * highBlue;
            sum += power;
            System.out.println(sum);
        }
        scanner.close();
    }
}

