package baseball.view;

import baseball.domain.BaseballResult;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballView {
    private static final int INPUT_SIZE = 3;

    public static List<Integer> inputNumber() {
        System.out.println("숫자를 입력해주세요: ");
        String input = Console.readLine();

        return createInputNumbers(input);
    }

    public static Boolean gameResult(BaseballResult result) {
        String viewResult = "";
        if (result.getStrike() == INPUT_SIZE) {
            System.out.println("게임 종료!");
            return true;
        }
        if (result.getBall() > 0) {
            viewResult += result.getBall() + "볼 ";
        }
        if (result.getStrike() > 0) {
            viewResult += result.getStrike() + "스트라이크";
        }
        if (viewResult.equals("")) {
            viewResult += "낫싱";
        }
        System.out.println(viewResult);
        return false;
    }

    private static List<Integer> createInputNumbers(String input) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        for (char charAsInteger : input.toCharArray()) {
            uniqueNumbers.add(StringToInteger(String.valueOf(charAsInteger)));
        }

        validateSize(input);
        validateDuplicated(uniqueNumbers);

        return new ArrayList<>(uniqueNumbers);
    }

    private static Integer StringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateSize(String input) {
        if (input.length() != INPUT_SIZE) {
            throw new IllegalArgumentException(String.format("입력 숫자은 %s자리를 넘을 수 없습니다. ", INPUT_SIZE));
        }
    }

    private static void validateDuplicated(Set<Integer> uniqueNumbers) {
        if (uniqueNumbers.size() != INPUT_SIZE) {
            throw new IllegalArgumentException("같은 숫자는 입력하실 수 없습니다.");
        }
    }
}
