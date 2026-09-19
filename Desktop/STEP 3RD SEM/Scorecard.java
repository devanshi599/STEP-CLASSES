public class Scorecard {

    private boolean[] results;
    private final int totalQuestions;
    private int answerCount;
    private int score;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        results = new boolean[totalQuestions];
        answerCount = 0;
        score = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answerCount < totalQuestions) {
            results[answerCount] = correct;
            answerCount++;

            if (correct) {
                score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}