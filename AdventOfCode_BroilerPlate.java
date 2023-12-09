// import java.net.URL;
// import java.net.HttpURLConnection;
// import java.util.Scanner;
// import java.io.InputStream;
// import java.io.FileInputStream;
// import java.util.Properties;

// //PLEASE REPLACE BROILER PLATE FUNCTION NAME AND INPUT LINK!

// public class AdventOfCode_BroilerPlate {
//     public static void main(String[] args) throws Exception {
//         Properties prop = new Properties();
//         prop.load(new FileInputStream(".env"));
//         String sessionCookie = prop.getProperty("SESSION_COOKIE");

//         URL url = new URL(prop.getProperty("DAY_TWO_INPUT_URL"));
//         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//         connection.setRequestProperty("Cookie", "session=" + sessionCookie);
//         InputStream in = connection.getInputStream();
//         Scanner scanner = new Scanner(in);
//         int counter = 0;
//         while (scanner.hasNextLine()) {
//             String line = scanner.nextLine();
//             counter++;
//             System.out.println(counter);
//         }
//         scanner.close();
//     }
// }


import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//PLEASE REPLACE BROILER PLATE FUNCTION NAME!

public class AdventOfCode_BroilerPlate {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(".env"));
        String sessionCookie = prop.getProperty("SESSION_COOKIE");

        //PLEASE REPLACE INPUT LINK!

        URL url = new URL(prop.getProperty("DAY_TWO_INPUT_URL"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Cookie", "session=" + sessionCookie);

        try (InputStream in = connection.getInputStream(); Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(lin);
            }
        }
    }

    private static int processGame(String line) {
        //here is a possible helper function.
}