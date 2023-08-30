package com.example.demo02;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo02.app.GameProvider;

@SpringBootApplication
public class Demo02Application implements CommandLineRunner { // ①

    @Autowired // ②
    private GameProvider gameProvider;

    public static void main(String[] args) {
        SpringApplication.run(Demo02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception { // ③
        while (true) {
            // ゲーム案内
            System.out.println("★じゃんけん勝負★\n"
                    + "以下の中から選択してください。\n"
                    + "----------\n"
                    + "1：グー\n"
                    + "2：チョキ\n"
                    + "3：パー\n"
                    + "0：終了\n");

            try {
                // プレイヤー選択
                var sc = new Scanner(System.in); // ④
                int playerChoice = sc.nextInt();
                
                // 入力チェック
                if (!Consts.JANKEN_INPUT_RANGE.contains(playerChoice)) {
                    System.out.println("0～3の範囲で入力してください。\n");
                    continue;
                }
                
                // 終了判定
                if (playerChoice == Consts.GAME_END) { // ⑤
                    System.out.println("ゲーム終了");
                    break;
                }
                
                
                // COMの手（1～3をランダム生成）
                int comChoice = new Random().nextInt(1, 4); 

                // じゃんけん開始
                var result = gameProvider.play(playerChoice, comChoice); // ⑥

                // じゃんけん結果;
                System.out.println("★じゃんけん結果★"
                        + "\n----------"
                        + "\nあなたの手：" + Consts.JANKEN_INFO.get(playerChoice)
                        + "\nCPUの手：" + Consts.JANKEN_INFO.get(comChoice)
                        + "\n結果：" + result + "\n");

            } catch (InputMismatchException e) { // ⑦
                System.out.println("0～2の数字を入力してください。\n");
                
            }
        }

    }

}
