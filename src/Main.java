import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9\u200D";
        int person_live = 3;

        String monster = "\uD83E\uDDDF\u200D";
        String castle = "\uD83C\uDFF0";
        int size = 5;
        int person_x = size;
        int person_y = 1;


        int step = 0;
        String left_block = "| ";
        String right_block = "|";
        String wall = "+ —— + —— + —— +";
        // \n, \t - как спец символ(упомянуть)
//        String output_str = "+ —— + —— + —— +\n"
//                + "|    |    | \uD83C\uDFE0 |\n"
//                + "+ —— + —— + —— +\n"
//                + "|    | " + monster + " |    |\n"
//                + "+ —— + —— + —— +\n"
//                + "| " + person + " |    |    |\n"
//                + "+ —— + —— + —— +";
        String[][] board = new String[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                board[x][y] = "  ";
            }
        }


        int count_monster = size * size - size - 1;
        Random r = new Random();
        for (int i = 0; i <= count_monster; i++) {
            board[r.nextInt(size - 1)][r.nextInt(size)] = monster;
        }
        int castle_x = 0;
        int castle_y = r.nextInt(size);

        board[castle_x][castle_y] = castle;


        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {
            case "ДА" -> {

                int max_step = 2;

                while (true) {
                    board[person_x - 1][person_y - 1] = person;
//                    System.out.println(output_str);
//                    for (int x = 0; x < size; x++) {
//                        System.out.println(wall);
//                        for (int y = 0; y < size; y++) {
////                            if (person_x - 1 == x && person_y - 1 == y) System.out.print(left_block + person + " ");
////                            else System.out.print(left_block + "   ");
//                            System.out.print(left_block + board[x][y] + " ");
//                        }
//                        System.out.println(right_block);
//                    }
//                    System.out.println(wall);

                    for (String[] raw : board) {
                        System.out.println(wall);
                        for (String col : raw) {
                            System.out.print(left_block + col + " ");
                        }
                        System.out.println(right_block);
                    }
                    System.out.println(wall);


                    System.out.println("Live:\t" + person_live + "\n");

                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                            "\nКоординаты персонажа - (x: " + person_x + ", y: " + person_y + "))");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    System.out.println(x + ", " + y);

                    // проверка
                    if (x != person_x && y != person_y) {
                        System.out.println("Неккоректный ход");
                    } else if (Math.abs(x - person_x) == 1 || Math.abs(y - person_y) == 1) {
                        if (board[x - 1][y - 1].equals("  ")) {
                            board[person_x - 1][person_y - 1] = "  ";
                            person_x = x;
                            person_y = y;
                            step++;
                            System.out.println("Ход корректный; Новые координаты: " + person_x + ", " + person_y +
                                    "\nХод номер: " + step);
                        } else {
                            System.out.println("Решите задачу.");
                        }
                    } else {
                        System.out.println("Координаты не изменены");
                    }

                    if (person_live <= 0) {
                        break;
                    }
                }

                System.out.println("Закончились жизни. Итог: ...");
            }
            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }
}