import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String person = "\uD83E\uDDD9\u200D";
//        int person_live = 3;

//        String monster = "\uD83E\uDDDF\u200D";
        String castle = "\uD83C\uDFF0";
        int size = 5;
//        int person_x = size;
//        int person_y = 1;
        Person person = new Person(size);


        int step = 0;

        String[][] board = new String[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                board[x][y] = "  ";
            }
        }


        int count_monster = size * size - size - 5;
        Random r = new Random();

        // для работы сбольшим количеством монстров воспользуемся массивом
        Monster[] arrMonster = new Monster[count_monster + 1];
        int count = 0;
        Monster test;
        while (count <= count_monster){
            if (r.nextBoolean()) {
                test = new Monster(size);
            }else {
                test = new BigMonster(size);
            }
            if (board[test.getX()][test.getY()].equals("  ")){
                board[test.getX()][test.getY()] = test.getImage();
                arrMonster[count] = test;
                count++;
            }

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
                while (true) {
                    board[person.getX() - 1][person.getY() - 1] = person.getImage();
                    output_board(board, person.getLive());
                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                            "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    // проверка
                    if (person.moveCorrect(x, y)) {
                        String next = board[x - 1][y - 1];
                        if (next.equals("  ")) {
                            board[person.getX() - 1][person.getY() - 1] = "  ";
                            person.move(x, y);
                            step++;
                            System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                    "\nХод номер: " + step);
                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        }else {
                            for (Monster monster : arrMonster) {
                                if (monster.conflictPerson(x, y)) {
                                    if (monster.taskMonster()) {
                                        board[person.getX() - 1][person.getY() - 1] = "  ";
                                        person.move(x, y);

                                    } else {
                                        person.downLive();
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Неккоректный ход");
                    }
                }
            }
            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }

    static void output_board(String[][] board, int live) {
        String left_block = "| ";
        String right_block = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] raw : board) {
            System.out.println(wall);
            for (String col : raw) {
                System.out.print(left_block + col + " ");
            }
            System.out.println(right_block);
        }
        System.out.println(wall);


        System.out.println("Live:\t" + live + "\n");
    }
}