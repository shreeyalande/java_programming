import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizQuestion {
    
    static class Question {
        String question;
        List<String> options;
        int correctAnswerIndex;
        
        public Question(String question, List<String> options, int correctAnswerIndex) {
            this.question = question;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }
    }
    
    static class Quiz {
        List<Question> questions;
        int currentQuestionIndex;
        int score;
        int correctAnswers;
        int incorrectAnswers;
        
        public Quiz(List<Question> questions) {
            this.questions = questions;
            this.currentQuestionIndex = 0;
            this.score = 0;
            this.correctAnswers = 0;
            this.incorrectAnswers = 0;
        }
        
        public void startQuiz() {
            Scanner scanner = new Scanner(System.in);
            
            for (Question question : questions) {
                displayQuestion(question);
                System.out.print("Enter your answer (1-" + question.options.size() + "): ");
                int userAnswer = scanner.nextInt();
                
                if (userAnswer == question.correctAnswerIndex + 1) {
                    System.out.println("Correct!");
                    score++;
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect. The correct answer was: " + (question.correctAnswerIndex + 1));
                    incorrectAnswers++;
                }
                
                System.out.println("----------------------------------");
            }
            
            scanner.close();
            displayResult();
        }
        
        private void displayQuestion(Question question) {
            System.out.println("Question: " + question.question);
            for (int i = 0; i < question.options.size(); i++) {
                System.out.println((i + 1) + ". " + question.options.get(i));
            }
        }
        
        private void displayResult() {
            System.out.println("Quiz Over!");
            System.out.println("Your Score: " + score + "/" + questions.size());
            System.out.println("Correct Answers: " + correctAnswers);
            System.out.println("Incorrect Answers: " + incorrectAnswers);
        }
    }
    
    public static void main(String[] args) {
        // Sample quiz questions
        List<Question> questions = new ArrayList<>();
        
        Question q1 = new Question(" What is the name of the process by which plants convert sunlight into energy?",
                                   List.of("Respiration", "Photosynthesis", "Oxidation", "Evolution"),
                                   1);
        Question q2 = new Question("What is the largest planet in our solar system?",
                                   List.of("Earth", "Jupiter", "Mars", "Saturn"),
                                   1);
        Question q3 = new Question("What is the official currency of Japan?",
                                   List.of("Yuan", "Won", "Dollars", "yen"),
                                   3);
                                   
        Question q4 = new Question(" What element is the main constituent of diamonds?",
                                   List.of("Oxygen", "Silver", "Carbon", "Gold"),
                                   2);                           
        
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        
        Quiz quiz = new Quiz(questions);
        
        // Start the quiz
        quiz.startQuiz();
    }
}

