package a2_BI12_019.studentman;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class DocIndexer {
	private Map<Word, List<Line>> wordIndex;

	public Map<Word, List<Line>> getWordIndex() {
		return wordIndex;
	}

	public void setWordIndex(Map<Word, List<Line>> wordIndex) {
		this.wordIndex = wordIndex;
	}
	
	public void index(String doc) {
		if(!(doc.isEmpty())) {
			String[] ls = doc.split("\n");
			for (int lineNo = 0; lineNo <= ls.length; lineNo++) {
				String[] l = Line(lineNo);
				String words = ls[lineNo];
				if(words.length() > 1) {
					l.add(words);
				for (int i = 0; i <= l.length(); i++) {
					Word w = l[i];
					wordIndex.put(w,l);
				}
				}
			}
		}
	}
	
	public Set getWords() {
		if (wordIndex != null) {
			return wordIndex.keySet();
		}
		else
			return null;
	}
	
	public Map getWordPositions() {
		if (!(wordIndex.isEmpty())) {
			return (Map) wordIndex.entrySet();
		}
	}
 	public void printIndex() {
		if (this.wordIndex == null) {
			System.out.println("empty");
		}
		else {
			for (int i = 0; i <= wordIndex.size(); i++) {
				List<Line> tuple = wordIndex.get(i);
				w = tuple.
				System.out.println(w + ": " + lines);
			}
		}
	}
}
