public class Webpage {
    public String url;
    public String title;
    public Double score;

    public void setScroe(){
        score = 0.0;
        for(int i =0 ; i<7; i++){
            score += Keyword.Counts[i] * Keyword.getKeyWordweight(Keyword.Keywords[i]); 
        }
        return score;
    }
}
