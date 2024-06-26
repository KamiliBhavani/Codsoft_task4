import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String questionText;
    private String[] options;
    private int correctOptionIndex;

    public Question(String questionText, String[] options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

public class QuizApplication{
    private List<Question> questions;
    private int score;
    private Scanner scanner;

    public QuizApplication() {
        questions = new ArrayList<>();
        score = 0;
        scanner = new Scanner(System.in);

        // Add sample questions
        questions.add(new Question("What is the capital of France?", new String[]{"A) London", "B) Paris", "C) Rome", "D) Berlin"}, 1));
        questions.add(new Question("What is 2 + 2?", new String[]{"A) 3", "B) 4", "C) 5", "D) 6"}, 1));
    }

    public void startQuiz() {
        for (Question question : questions) {
            displayQuestion(question);
            if (submitAnswer(question)) {
                score++;
            }
        }
        displayResult();
    }

    private void displayQuestion(Question question) {
        System.out.println(question.getQuestionText());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
    }

    private boolean submitAnswer(Question question) {
        System.out.print("Enter your answer (A/B/C/D): ");
        String userAnswer = scanner.nextLine().toUpperCase();
        int userOptionIndex = userAnswer.charAt(0) - 'A';

        return userOptionIndex == question.getCorrectOptionIndex();
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        QuizApplication quiz = new QuizApplication();
        quiz.startQuiz();
    }
}