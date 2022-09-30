package baseball;

import baseball.domain.BaseBallCreate;
import baseball.domain.BaseballReferee;
import baseball.domain.BaseballResult;
import baseball.view.BaseballView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        do {
            BaseBallCreate ballNumberCreate = new BaseBallCreate();
            playGame(ballNumberCreate.createBaseballNumbers());
        } while (playAgain());
    }

    public static void playGame(List<Integer> baseballNumbers) {
        boolean result;
        do {
            List<Integer> inputNumbers = BaseballView.inputNumber();
            BaseballResult match = BaseballReferee.match(inputNumbers, baseballNumbers);
            result = BaseballView.gameResult(match);
        } while (!result);
    }

    public static boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputAgain = Console.readLine();
        if (inputAgain.equals("1")) {
            return true;
        }
        if (inputAgain.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
