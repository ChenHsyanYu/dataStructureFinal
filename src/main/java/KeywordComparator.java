import java.util.Comparator;

public class KeywordComparator implements Comparator<WebNode>
{
	@Override
	public int compare(WebNode o1, WebNode o2) {
		if (o1 == null || o2 == null)
			throw new NullPointerException();
		// YOUR TURN
		// 1. compare count
		// Hint: If o1 is less than o2 return negative integer, o1 greater than o2
		// return positive integer, equal return zero
		if(o1.webpage.score  < o2.webpage.score) {
			return 1;
		}else if(o1.webpage.score  > o2.webpage.score) {
			return -1;
		}

		return 0;
	}
}