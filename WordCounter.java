import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;

public class WordCounter {
    private String urlstr;
    private String content;
    static int NO_OF_CHARS = 256;
    static int Matchtimes;

    private String fetchContent() throws IOException{
        URL url = new URL(this.urlStr);
        URLConnection conn = url.openConnection();
        ImputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        String retVal = "";
        String line = null;

        while((line = br.readLine()) != null){
            retVal = retVal + line + "\n";
        }
        return retVal;
    } 

    public int BoyerMoore(String T, String P){
		int i = P.length() -1;
        int j = P.length() -1;
		int restart = 0;

        do
        {
			while(restart <= T.length()-1){
				if (P.charAt(j) == T.charAt(i))
				{
					if (j == 0)
					{
						MatchTimes++; // a match!
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
		return -1;
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

    public void countKeyword(ArrayList Keywords) throws IOException{
        if (content == null){
		    content = fetchContent();
		}
		
        //To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		content = content.toUpperCase();
        for(int i =0 ; i< Keyword.Keywords.length; i++){
            keyword = Keyword.Kerwordsp[i].toUpperCase();
            int retVal = 0;
            BoyerMoore(content, keyword);
            retVal = MatchTimes;
            Keyword.Counts[i] = retVal;
        }	
		return Keyword.Counts;
        }
        
}

