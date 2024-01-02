import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;

public class WordCounter {
//    private String urlstr;
	private String title;
    private String content;
    static int NO_OF_CHARS = 256;
    static int Matchtimes;
    Keyword keyword = new Keyword();

    public WordCounter(String title) {
    	this.title = title;
    	System.out.println(title);
    }
    //fetch the content from the given URL
//    private String fetchContent() throws IOException{
//        URL url = new URL(this.urlstr);
//        URLConnection conn = url.openConnection();
//        InputStream in = conn.getInputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        
//        String retVal = "";
//        String line = null;
//
//        while((line = br.readLine()) != null){
//            retVal = retVal + line + "\n";
//        }
//        return retVal;
//    } 

    //count the number of keywords in the content
    public int BoyerMoore(String T, String P){
		int i = P.length() -1;
        int j = P.length() -1;
		int restart = 0;
		Matchtimes = 0;
        do
        {
			while(restart <= T.length()-1){
				if (P.charAt(j) == T.charAt(i))
				{
					if (j == 0)
					{
					    Matchtimes++; // a match!
						restart = i;
						i = i + P.length();
					}
					else
					{
						i--;
						j--;
					}
				}
				else
				{
					i = i + P.length() - min(j, 1+last(T.charAt(i), P));    
					j = P.length()-1;
					restart = i ;
				}
				
			}
			
        } while(i <= T.length()-1);
        return Matchtimes;
		
	} 

    public int last(char c, String P){
        for (int i = P.length()-1; i>=0; i--)
        {
            if (P.charAt(i) == c)
            {
                return i;
            }
        }
        return -1;
    }

    public int min(int a, int b){
        if (a < b)
            return a;
        else if (b < a)
            return b;
        else 
            return a;
    }

    //retrun the counts Array of keywords in the content
    public double[] countKeyword() throws IOException{
//        if (content == null){
//		    content = fetchContent();
//		}
		
        //To do a case-insensitive search, we turn the whole content and keyword into upper-case:
//		content = content.toUpperCase();
        for(int i =0 ; i< Keyword.Keywords.length; i++){
            String keyword = Keyword.Keywords[i].toUpperCase();
            int retVal = 0;
            BoyerMoore(title, keyword);
            retVal = Matchtimes;
            System.out.println(Matchtimes);
            Keyword.Counts[i] = retVal;
            System.out.println("計數");
//            for(Double d: Keyword.Counts) {
//            	System.out.println(d);
//            }
            
        }	
		return Keyword.Counts;
        }
        
}

