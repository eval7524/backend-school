package dev.jcm.jvm.oom.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGenerator {
    private final Random random = new Random();

    // 1~45 사이의 중복 없는 6개의 랜덤 숫자 리스트를 생성
    public List<Integer> generate() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < 6) {
            int num = random.nextInt(45) + 1;
            if (!lottoNumbers.contains(num)) {
                lottoNumbers.add(num);
            }
        }
        return lottoNumbers;
    }
}