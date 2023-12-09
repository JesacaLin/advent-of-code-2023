import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;

public class AdventOfCodeDay1_5 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(".env"));
        String sessionCookie = prop.getProperty("SESSION_COOKIE");

        URL url = new URL(prop.getProperty("DAY_ONE_INPUT_URL"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Cookie", "session=" + sessionCookie);
        InputStream in = connection.getInputStream();
        Scanner scanner = new Scanner(in);
       
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1); map.put("two", 2); map.put("three", 3);map.put("four", 4);map.put("five", 5);map.put("six", 6);map.put("seven", 7);map.put("eight", 8);map.put("nine", 9); map.put("1", 1); map.put("2", 2); map.put("3", 3); map.put("4", 4); map.put("5", 5); map.put("6", 6); map.put("7", 7); map.put("8", 8); map.put("9", 9);
        
        int calibrationTotal = 0;
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            String first = null;
            String last = null;
            //String currentTotal = "";

            for (int i = 0; i < currentLine.length(); i++) {
                for (String key : map.keySet()) {
                    if (i + key.length() <= currentLine.length() && currentLine.substring(i, i + key.length()).equals(key)) {
                    if (first == null) {
                        first = map.get(key).toString();
                        //System.out.println("First key: " + key + ", value: " + first);
                        }
                    last = map.get(key).toString();
                    //System.out.println("Last key: " + key + ", value: " + last);
                    }
                }
            }
            if (first != null && last != null) {
                String result = first + last;
                System.out.println("Result: " + result);
                calibrationTotal += Integer.parseInt(result);
                System.out.println("Calibration Total: " + calibrationTotal);
            }
        }
        scanner.close();
    }
}

