package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private static final int INPUT_SIZE = 3;

    public List<Integer> inputNumber() {
        String input = Console.readLine();

        return createInputNumbers(input);
    }

    private List<Integer> createInputNumbers(String input) {

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (char charAsInteger : input.toCharArray()) {
            uniqueNumbers.add(StringToInteger(String.valueOf(charAsInteger)));
        }

        validateSize(input);
        validateDuplicated(uniqueNumbers);

        return new ArrayList<>(uniqueNumbers);
    }

   private Integer StringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void validateSize(String input) {
        if (input.length() != INPUT_SIZE) {
            throw new IllegalArgumentException(String.format("입력 숫자은 %s자리를 넘을 수 없습니다. ", INPUT_SIZE));
        }
    }

    private void validateDuplicated(Set<Integer> uniqueNumbers) {
        if (uniqueNumbers.size() != INPUT_SIZE) {
            throw new IllegalArgumentException("같은 숫자는 입력하실 수 없습니다.");
        }
    }
}
