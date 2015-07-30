package domain;

import java.util.ArrayList;
import java.util.List;

public class Dictionary extends AbstractEntity {
    private List<Word> words;

    public Dictionary() {
        words = new ArrayList<Word>();
    }

    /**
     * @param words
     */
    public Dictionary(List<Word> words) {
        this.words = words;
    }

    /**
     * @return the words
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * @param words
     *            the words to set
     */
    public void setWords(List<Word> words) {
        this.words = words;
    }

}
