package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseBallCreate {
    private static final int BALL_SIZE = 3;
    private static final int BALL_MIN_NUM = 1;
    private static final int BALL_MAX_NUM = 9;

    public List<Integer> createBaseballNumbers() {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        while (uniqueNumbers.size() < BALL_SIZE) {
            int pickedNumber = Randoms.pickNumberInRange(BALL_MIN_NUM, BALL_MAX_NUM);
            uniqueNumbers.add(pickedNumber);
        }

        return new ArrayList<>(uniqueNumbers);
    }
}
