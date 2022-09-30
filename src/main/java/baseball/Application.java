package baseball;

import baseball.domain.BallNumberCreate;
import baseball.domain.BaseballReferee;
import baseball.domain.BaseballResult;
import baseball.view.BaseballPark;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BallNumberCreate ballNumberCreate = new BallNumberCreate();
        List<Integer> baseballNumbers = ballNumberCreate.createBaseballNumbers();
        BaseballPark baseballPark = new BaseballPark();
        BaseballReferee baseballReferee = new BaseballReferee();

        boolean result;
        do {
            List<Integer> inputNumbers = baseballPark.inputNumber();
            BaseballResult match = baseballReferee.match(inputNumbers, baseballNumbers);
            result = baseballPark.gameResult(match);
        } while (!result);
    }
}
