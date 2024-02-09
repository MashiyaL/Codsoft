import java.util.*;

class Question {
    String question;
    List<String> options;
    int correctAnswer;

    Question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class Quiz {
    List<Question> questions;

    Quiz(List<Question> questions) {
        this.questions = questions;
    }
}

class QuizRunner {
    Quiz quiz;
    int score;

    QuizRunner(Quiz quiz) {
        this.quiz = quiz;
        this.score = 0;
    }

    void runQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < quiz.questions.size(); i++) {
            Question question = quiz.questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.question);
            for (int j = 0; j < question.options.size(); j++) {
                System.out.println((j + 1) + ". " + question.options.get(j));
            }
            System.out.println("Please enter the number of your answer within 30 seconds:");
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 30000 && !scanner.hasNextInt()) {}
            if (System.currentTimeMillis() - startTime >= 30000) {
                System.out.println("Time's up!");
            } else {
                int answer = scanner.nextInt();
                if (answer - 1 == question.correctAnswer) {
                    score++;
                }
            }
        }
        System.out.println("Quiz finished! Your score: " + score);
    }
}

public class Timer {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What currency does South Africa use ? ", Arrays.asList("Rand", "Yen", "Nira"), 0));
        questions.add(new Question("Which African country lies on The Equator?", Arrays.asList("Cape Verde", "Egypt", "Somalia"), 2));
        questions.add(new Question("Who is the richest man in history ?", Arrays.asList("Nelson Mandela", "Steve Jobs", "Mansa Musa"), 2));
		questions.add(new Question("When was the first computer built ?", Arrays.asList("1991", "1945", "1973"), 1));
		questions.add(new Question("how many songs could the first ipod hold?", Arrays.asList("1000", "12", "50"), 0));
        Quiz quiz = new Quiz(questions);
        QuizRunner quizRunner = new QuizRunner(quiz);
        quizRunner.runQuiz();
    }
}

