public class Webpage {
    public String url;
    public String title;
    public double score;

    //set the score of the webpage, by mutiplying the weight of the keyword and the counts of the keyword
    public double setScore() {
        score = 0.0;
        for (int i = 0; i < 7; i++) {
            score += Keyword.Counts[i] * Keyword.getKeyWordweight(Keyword.Keywords[i]);
        }
        return score;
    }
}
