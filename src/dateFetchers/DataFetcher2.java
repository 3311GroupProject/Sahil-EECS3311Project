package dateFetchers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;



public class DataFetcher1 {

    public static String aCountry ="CAN" ;
    public static int startDate ;
    public static int endDate;

    //Make an adaptor here to get indicators

    public static String indicatorType="SP.POP.TOTL";




    public static void main(String[] args) {

        Scanner askUser=new Scanner(System.in);

        System.out.println("Enter start date");
        startDate=askUser.nextInt() ;
        System.out.println("Enter end date");
        endDate=askUser.nextInt();



        String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/"+indicatorType+ "?date="+ startDate+":"+endDate+"&format=json", aCountry);

        //	"http://api.worldbank.org/v2/country/%s/indicator/SP.POP.TOTL?date=${startDate}:${endDate}&format=json", aCountry);

        System.out.println(urlString);
        int populationForYear = 0;
        int cummulativePopulation = 0;
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode == 200) {
                String inline = "";
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                sc.close();

                JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
                int size = jsonArray.size();
                int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
                int year;
                for (int i = 0; i < sizeOfResults; i++) {
                    year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
                    if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
                        populationForYear = 0;
                    else
                        populationForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
                                .getAsInt();

                    System.out.println("Population for " + aCountry + " in " + year + " is " + populationForYear);
                    cummulativePopulation = cummulativePopulation + populationForYear;
                }
                System.out.println(
                        "The average population over the selected years is " + cummulativePopulation / sizeOfResults);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block e.printStackTrace();
        }

        return;
    }

}