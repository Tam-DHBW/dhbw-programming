package dhbw.tam.pollutionmap;

import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PollutionApi {
    public static float getPM25(float latitude, float longitude) throws IOException {
        URL url = new URL("https://air-quality-api.open-meteo.com/v1/air-quality?current=pm2_5&latitude=" + latitude + "&longitude=" + longitude);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        String response = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();

        return JsonParser.parseString(response)
                .getAsJsonObject()
                .get("current")
                .getAsJsonObject()
                .get("pm2_5")
                .getAsFloat();
    }
}
