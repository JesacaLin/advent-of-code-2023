import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

public class AdventOfCodeDay1 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(".env"));
        String sessionCookie = prop.getProperty("SESSION_COOKIE");

        URL url = new URL("https://adventofcode.com/2023/day/1/input");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Cookie", "session=" + sessionCookie);
        InputStream in = connection.getInputStream();
        Scanner scanner = new Scanner(in);
        //input: a string
        //output: sum of all the calibration values

        //create counter to add all calibration values;
        //somehow split the string into characters, stored in an array.
        //create variables to hold first int and last int
        //create variable to hold current line's calibration values
            //iterate through - forward
                //if an int is encountered, set it to first int variable, break.
            //iterate backwards? 
                //if an int is encountered, set it to last int variable, break.
            //set current calibration value to first in and last int
                //convert current calibration value to string then to int
            //add to total int
        int calibrationTotal = 0;
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            char[] characters = currentLine.toCharArray();
            char first = '0';
            char last = '0';
            for (char c : characters) {
                if (Character.isDigit(c)) {
                    first = c;
                    break;
                }
            }
            for (int i = characters.length - 1; i >= 0; i--) {
                if (Character.isDigit(characters[i])) {
                    last = characters[i];
                    break;
                }
            }
            int currentCalibrationTotal = Integer.parseInt(String.valueOf(first) + String.valueOf(last));
            calibrationTotal += currentCalibrationTotal;
            
            System.out.println(calibrationTotal);
        }
        scanner.close();
    }
}
