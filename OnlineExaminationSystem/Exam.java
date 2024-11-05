import java.util.HashMap;
import java.util.Map;

public class Exam {
    private Map<Integer, String> questions;
    private Map<Integer, String[]> options; // Options for each question
    private Map<Integer, String> correctAnswers; // Correct answer for each question
    private Map<Integer, String> userAnswers;

    public Exam() {
        questions = new HashMap<>();
        options = new HashMap<>();
        correctAnswers = new HashMap<>();
        userAnswers = new HashMap<>();

        // Sample questions with options and correct answers
        questions.put(1, "What is the capital of France?");
        options.put(1, new String[] { "A) London", "B) Berlin", "C) Paris", "D) Madrid" });
        correctAnswers.put(1, "C");

        questions.put(2, "What is 2 + 2?");
        options.put(2, new String[] { "A) 3", "B) 4", "C) 5", "D) 6" });
        correctAnswers.put(2, "B");

        questions.put(3, "Who wrote 'To Kill a Mockingbird'?");
        options.put(3, new String[] { "A) Harper Lee", "B) Mark Twain", "C) J.K. Rowling", "D) Ernest Hemingway" });
        correctAnswers.put(3, "A");
    }

    // Display questions with MCQ options
    public void showQuestions() {
        for (Map.Entry<Integer, String> entry : questions.entrySet()) {
            int questionId = entry.getKey();
            System.out.println("Q" + questionId + ": " + entry.getValue());

            // Display options
            for (String option : options.get(questionId)) {
                System.out.println(option);
            }
            System.out.print("Your Answer (A/B/C/D): ");
            String answer = System.console().readLine().toUpperCase(); // Read answer as uppercase
            userAnswers.put(questionId, answer);
        }
    }

    // Check answers and show results
    public void submitAnswers() {
        int correctCount = 0;
        for (Map.Entry<Integer, String> entry : correctAnswers.entrySet()) {
            int questionId = entry.getKey();
            String correctAnswer = entry.getValue();
            String userAnswer = userAnswers.get(questionId);

            if (correctAnswer.equals(userAnswer)) {
                correctCount++;
            }
        }
        System.out.println("You scored: " + correctCount + "/" + questions.size());
    }
}
