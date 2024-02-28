import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int score;
    private int timeLimitPerQuestion; // in seconds

    public Quiz(List<QuizQuestion> questions, int timeLimitPerQuestion) {
        this.questions = questions;
        this.timeLimitPerQuestion = timeLimitPerQuestion;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            System.out.println(question.getQuestion());

            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your answer (1-" + options.size() + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == question.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + question.getCorrectOption() + "\n");
            }

            // Add a timer pause (sleep) for demonstration purposes.
            try {
                Thread.sleep(timeLimitPerQuestion * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Quiz completed! Your final score is: " + score + "/" + questions.size());
        scanner.close();
    }
}

public class QuizApp {
    public static void main(String[] args) {
        List<QuizQuestion> quizQuestions = new ArrayList<>();

        // Example quiz questions
        quizQuestions.add(new QuizQuestion("What is the capital of France?",
                Arrays.asList("Berlin", "Paris", "London", "Madrid"), 2));
        quizQuestions.add(new QuizQuestion("Which planet is known as the Red Planet?",
                Arrays.asList("Mars", "Jupiter", "Venus", "Mercury"), 1));
        quizQuestions.add(new QuizQuestion("What is the largest mammal in the world?",
                Arrays.asList("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 2));

        Quiz quiz = new Quiz(quizQuestions, 10); // 10 seconds time limit per question
        quiz.startQuiz();
    }
}
