package dev.jcm.jvm.oom.lotto2;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication2 {
    public static void main(String[] args) throws InterruptedException {
        LottoGenerator2 generator = new LottoGenerator2();
        // 생성된 로또 번호들을 저장할 리스트 (메모리 누수를 유도)
        List<List<Integer>> storage = new ArrayList<>();
        
        while (true) {
            // 로또 번호 생성 및 저장
            List<Integer> lotto = generator.generate();
            if(storage.size() > 100) {
                storage.clear();
            }
            storage.add(lotto);

            
            // 생성된 번호 출력 (옵션)
            System.out.println(lotto);
        }
    }
}