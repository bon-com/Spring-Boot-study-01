package com.example.demo02;

import java.util.Map;

/**
 * 定数クラス
 */
public class Consts {
    /** じゃんけんグー */
    public static final int JANKEN_GU = 1;
    /** じゃんけんチョキ */
    public static final int JANKEN_CHOKI = 2;
    /** じゃんけんパー */
    public static final int JANKEN_PAR = 3;
    /** じゃんけん情報 */
    public static final Map<Integer, String> JANKEN_INFO = Map.of(JANKEN_GU, "グー", JANKEN_CHOKI, "チョキ", JANKEN_PAR,
            "パー");
    /** ゲーム終了 */
    public static final int GAME_END = 0;
}
