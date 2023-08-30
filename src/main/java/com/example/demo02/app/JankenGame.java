package com.example.demo02.app;

import org.springframework.stereotype.Component;

import com.example.demo02.Consts;

/**
 * じゃんけんゲーム
 */
@Component // ①
public class JankenGame implements GameProvider {

    /**
     * じゃんけんする
     */
    @Override
    public String play(int playerChoice, int comChoice) {
        return judgeJanken(playerChoice, comChoice);
    }

    /**
     * じゃんけん結果を判定する
     * 
     * @param player プレイヤーの手
     * @param com    COMの手
     * @return 結果
     */
    private String judgeJanken(int player, int com) {
        var result = "";
        if (player == com) {
            result = "あいこです。";
        } else if ((player == Consts.JANKEN_GU && com == Consts.JANKEN_CHOKI)
                || (player == Consts.JANKEN_CHOKI && com == Consts.JANKEN_PAR)
                || (player == Consts.JANKEN_PAR && com == Consts.JANKEN_GU)) {
            result = "あなたの勝ちです。";
        } else {
            result = "あなたの負けです。";
        }

        return result;
    }

}
