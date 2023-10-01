import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        String apiKey = "1ca260647fbc4277ad5c97b63bcff8db"; // Replace with your Spoonacular API key
        String query = "spaghetti"; // Replace with your desired query string

        // Construct the URL with the query parameter
        String apiUrl = "https://api.spoonacular.com/recipes/complexSearch";
        String urlWithParameters = apiUrl + "?query=" + query + "&apiKey=" + apiKey;

        URL url = new URL(urlWithParameters);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setRequestProperty("Content-Type", "application/json");

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Reading response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response
            System.out.println(response.toString());
        } else {
            System.out.println("HTTP Request Failed with response code: " + responseCode);
        }
    }
}