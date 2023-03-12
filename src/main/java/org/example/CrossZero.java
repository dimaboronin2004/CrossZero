package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CrossZero {

    char[][] field = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};


    public void add(char ch, int i, int j) {
        if (ch != 'x' && ch != '0')
            throw new IllegalArgumentException("Forbidden symbol");
        if (i >= 3 || j >= 3)
            throw new IllegalArgumentException("Coords out of field");
        field[i][j] = ch;
    }

    public void clear(int i, int j) {
        if (i >= 3 || j >= 3)
            throw new IllegalArgumentException("Coords out of field");
        field[i][j] = '-';
    }

    public int findLongestSequence(char ch) {
        if (ch != 'x' && ch != '0')
            throw new IllegalArgumentException("Forbidden symbol");
        List<Integer> mas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                List<Integer> localMas = new ArrayList<>();
                if (field[i][j] == ch) {
                    int x = 0;
                    int y = 0;
                    int c = 0;

                    while (x < 3) {
                        if (field[x][j] == ch) c++;
                        x++;
                    }
                    localMas.add(c);
                    x = 2;
                    c = 0;
                    while (x > 0) {
                        if (field[x][j] == ch) c++;
                        x--;
                    }
                    localMas.add(c);
                    c = 0;
                    while (y < 3) {
                        if (field[i][y] == ch) c++;
                        y++;
                    }
                    localMas.add(c);
                    y = 2;
                    c = 0;
                    while (y > 0) {
                        if (field[i][y] == ch) c++;
                        y--;
                    }
                    localMas.add(c);
                    x = 0;
                    y = 0;
                    c = 0;
                    while (x < 3 && y < 3) {
                        if (field[x][y] == ch) c++;
                        x++;
                        y++;
                    }
                    localMas.add(c);
                    x = 0;
                    y = 2;
                    c = 0;
                    while (x < 3 && y > 0) {
                        if (field[x][y] == ch) c++;
                        x++;
                        y--;
                    }
                    localMas.add(c);
                    x = 2;
                    y = 0;
                    c = 0;
                    while (x > 0 && y < 3) {
                        if (field[x][y] == ch) c++;
                        x--;
                        y++;
                    }
                    localMas.add(c);
                    x = 2;
                    y = 2;
                    c = 0;
                    while (x > 0 && y > 0) {
                        if (field[x][y] == ch) c++;
                        x--;
                        y--;
                    }
                    localMas.add(c);
                    mas.add(Collections.max(localMas));
                }
            }
        }
        if (!mas.isEmpty()) return Collections.max(mas);
        else return 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (char[] row : field) {
            StringBuilder s1 = new StringBuilder();
            for (char ch : row) {
                s1.append(ch);
            }
            s.append(s1).append("\n");
        }
        return s.toString();
    }
}
