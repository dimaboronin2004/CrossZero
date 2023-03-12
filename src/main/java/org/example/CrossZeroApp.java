package org.example;

import java.util.Scanner;

public class CrossZeroApp {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Время поиграть! Вы играете за крестики, я - за нолики.");
        CrossZero game = new CrossZero();
        System.out.println(game);
        while (true) {
            System.out.println("Ваш ход.");
            System.out.println("Введите координаты клетки");
            int i = sc.nextInt();
            int j = sc.nextInt();
            if (i >= 3 || j >= 3) {
                System.out.println("Введите допустимые координаты");
                i = sc.nextInt();
                j = sc.nextInt();
            }
            game.add('x', i, j);
            System.out.println("Вы добавили символ" + " x " + "в клетку с координатами " + i + " и " + j);
            System.out.println(game);
            if (game.findLongestSequence('x') == 3) {
                System.out.println("Поздравляю, Вы выиграли!");
                break;
            }
            System.out.println("Теперь мой ход.");
            int row = 0;
            int column = 0;
            while (game.field[row][column] != '-') {
                row = (int) (Math.random() * 3);
                column = (int) (Math.random() * 3);
            }
            game.add('0', row, column);
            System.out.println("Я добавляю символ " + '0' + " в клетку с координатами " + row + " и " + column);
            System.out.println(game);
            if (game.findLongestSequence('0') == 3) {
                System.out.println("К сожалению, Вы проиграли...\n" +
                        " Не расстраивайтесь, у Вас обязательно всё получится!");
                break;
            }
        }
    }
}
