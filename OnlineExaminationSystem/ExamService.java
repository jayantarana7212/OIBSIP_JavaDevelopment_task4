import java.util.Timer;
import java.util.TimerTask;

public class ExamService {
    private Exam exam;
    private Timer timer;
    private boolean isExamCompleted;

    public ExamService() {
        exam = new Exam();
    }

    public void startExam(int durationSeconds) {
        System.out.println("Exam started. You have " + durationSeconds + " seconds to complete it.");

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isExamCompleted) {
                    System.out.println("\nTime's up! Auto-submitting your exam...");
                    submitExam();
                }
            }
        }, durationSeconds * 1000);

        exam.showQuestions();
        submitExam();
    }

    public void submitExam() {
        isExamCompleted = true;
        timer.cancel();
        exam.submitAnswers();
    }
}
