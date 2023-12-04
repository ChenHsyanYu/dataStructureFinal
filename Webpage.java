public class Webpage {
    public String url;
    public String title;
    public double score;

    public double setScore() {
        score = 0.0;
        for (int i = 0; i < 7; i++) {
            score += Keyword.Counts[i] * Keyword.getKeyWordweight(Keyword.Keywords[i]);
        }
        return score;
    }
}
