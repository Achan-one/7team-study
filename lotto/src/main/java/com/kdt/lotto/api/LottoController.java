package com.kdt.lotto.api;

import com.kdt.lotto.entity.Drawing;

import java.util.List;

public class LottoController implements LottoApi {

    //11.08(02:31)
    ///enum :
    //등수와 상금
    ///객체 :
    //로또 :
        // 규칙, 가격, 발급 번호
    // Drawing
        //사용자 입력, 당첨 번호, 보너스 번호, 수익률

    private final Drawing drawing = new Drawing();

    //번호로 로또 한 장 만들기, 오름차순 번호 목록
    @Override
    public List<Integer> ticket(List<Integer> numbers) {
        return drawing.ticket(numbers);
    }

    //당첨 번호 정하기, 없음
    @Override
    public void winning(List<Integer> numbers, int bonus) {
        throw new UnsupportedOperationException("2단계");
    }

    //이 번호의 등수	"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH", "NONE"
    @Override
    public String rank(List<Integer> numbers) {
        throw new UnsupportedOperationException("3단계");
    }

    //이 번호의 상금	원 단위 정수 (long)
    @Override
    public long prize(List<Integer> numbers) {
        throw new UnsupportedOperationException("3단계");
    }

    //금액만큼 자동 발급	로또 번호 목록들
    @Override
    public List<List<Integer>> buyAuto(int money) {
        throw new UnsupportedOperationException("4단계");
    }

    //여러 장의 수익률	예: 62.5
    @Override
    public double profitRate(List<List<Integer>> tickets) {
        throw new UnsupportedOperationException("4단계");
    }
}
