package baseball;

import static baseball.RegularExpression.END_OR_NOT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class BaseBallGame {

    Computer computer = Computer.getInstance();
    User user = User.getInstance();
    Score score = Score.getInstance();

    private static BaseBallGame baseBallGame;

    private BaseBallGame() {
    }

    public static BaseBallGame getInstance() {
        if (baseBallGame == null) {
            baseBallGame = new BaseBallGame();
        }
        return baseBallGame;
    }

    public void run() {
        do {
            System.out.print(OutputMessage.START_GAME);

            computer.setRandomNumber();
            // 정답 확인용 임시 코드
            System.out.println(Arrays.toString(computer.getRandomNumber().toArray()));

            guessNumber();

            System.out.println(OutputMessage.END_OR_NOT);

        } while (!isEnd());
    }

    private void guessNumber() {
        do {
            System.out.print(OutputMessage.ENTER_NUMBER);
            user.setUserNumberFromConsole();
            score.calculateScore(computer, user);
            score.printOutScore();
        } while (!score.isSuccess());
    }

    public boolean isEnd() {
        String chooseNumber = Console.readLine();
        throwException(chooseNumber);
        return chooseNumber.equals("2");
    }

    private void throwException(String st) {
        if (!st.matches(END_OR_NOT)) {
            throw new IllegalArgumentException();
        }
    }

}
