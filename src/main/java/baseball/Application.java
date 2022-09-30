package baseball;

import baseball.domain.BaseBallNumberCreate;
import baseball.domain.BaseballReferee;
import baseball.domain.BaseballResult;
import baseball.view.BaseballPark;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BaseBallNumberCreate ballNumberCreate = new BaseBallNumberCreate();
        BaseballReferee baseballReferee = new BaseballReferee();
        BaseballPark baseballPark = new BaseballPark();

        do {
            playGame(baseballReferee, ballNumberCreate.createBaseballNumbers(), baseballPark);
        } while (playAgain());
    }

    public static void playGame(BaseballReferee baseballReferee, List<Integer> baseballNumbers, BaseballPark baseballPark) {

        for (Integer baseballNumber : baseballNumbers) {
            System.out.println("baseballNumber = " + baseballNumber);
        }

        boolean result;
        do {
            List<Integer> inputNumbers = baseballPark.inputNumber();
            BaseballResult match = baseballReferee.match(inputNumbers, baseballNumbers);
            result = baseballPark.gameResult(match);
        } while (!result);
    }

    public static boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputAgain = Console.readLine();
        if (inputAgain.equals("1")) {
            return true;
        }
        return false;
    }
}
