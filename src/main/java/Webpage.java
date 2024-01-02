import java.io.IOException;

public class Webpage {
    public String url;
    public String title;
    public double score;
    public WordCounter counter;
     
    public Webpage(String url, String title) {
    	this.url = url;
    	this.title = title;
    	this.counter = new WordCounter(title);
    	this.setScore(); 
    }
    //set the score of the webpage, by mutiplying the weight of the keyword and the counts of the keyword
    public double setScore() {

        score = 0.0;
        for (int i = 0; i < 7; i++) {
            try {
				score += counter.countKeyword()[i] * Keyword.getKeyWordweight(Keyword.Keywords[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return score;
    }
}
