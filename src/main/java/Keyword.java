import java.util.ArrayList;
import java.util.List;

public class Keyword {

    public static String[] Keywords = { "政治大學", "政大", "選課心得", "修課心得", "心得", "評價", "Dcard" };
    public static double[] Counts = new double[7]; // to store the number of keywords in the webpage

    public Keyword() {
    }

    // Return the weight of the keyword
    public static double getKeyWordweight(String keyword) {

        switch (keyword) {
            case "政治大學":
                return 8.0;
            case "政大":
                return 8.0;
            case "選課心得":
                return 2.0;
            case "修課心得":
                return 2.0;
            case "心得":
                return 2.0;
            case "評價":
                return 2.0;
            case "Dcard":
                return 1.0;
        }
        return 0;
    }
}