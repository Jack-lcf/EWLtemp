package domain;

public class Word extends AbstractEntity {
    private String eng;
    private String rus;
    private int correct;
    private int total;

    public Word() {
        correct = 0;
        total = 0;
    }

    /**
     * @param eng
     * @param rus
     */
    public Word(String eng, String rus) {
        this.eng = eng;
        this.rus = rus;
        correct = 0;
        total = 0;
    }

    /**
     * @return the eng
     */
    public String getEng() {
        return eng;
    }

    /**
     * @param eng
     *            the eng to set
     */
    public void setEng(String eng) {
        this.eng = eng;
    }

    /**
     * @return the rus
     */
    public String getRus() {
        return rus;
    }

    /**
     * @param rus
     *            the rus to set
     */
    public void setRus(String rus) {
        this.rus = rus;
    }

    /**
     * @return the correct
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * @param correct
     *            the correct to set
     */
    public void setCorrect(int correct) {
        this.correct = correct;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total
     *            the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

}
