import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sun.awt.windows.WBufferStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

//Simple Java class to manage getting data from HTTP Requests
public class HttpRequest {

    public void getDataFromGETRequest(String link)
    {
        try
        {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            //conn.setRequestProperty("Content-Type", "text/plain");
            conn.setInstanceFollowRedirects(false);
            int status = conn.getResponseCode();
            BufferedReader streamReader = null;
            if(status > 299)
            {
                streamReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            else {
                streamReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                //Class var = gson.fromJson(streamReader, var.class);
                //Handling received data from GET request
            }
            conn.disconnect();
        } catch(Exception ex)
        {
            System.out.println("URL Hiba!");
        }
    }

    public void getDataFromPOSTRequest(String link)
    {
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "text/plain");
            conn.setDoOutput(true);
            String parameters = "";
            OutputStream os = conn.getOutputStream();
            os.write(parameters.getBytes());
            os.flush();
            os.close();
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_ACCEPTED)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                while((inputLine = reader.readLine()) != null)
                {
                    //Handling received data from POST request
                }
            }
        }catch(Exception ex)
        {
            System.out.println("URL Hiba!");
        }

    }

}
