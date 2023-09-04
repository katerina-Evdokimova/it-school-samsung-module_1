import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9\u200D";
        int person_live = 3;
        /* здесь необходимо рассказать про переполнение и про другие типы данных
            int person_live = 2147483649; // мало ли кто-то захочет сделать ооочень много жизней
         */

        String monster = "\uD83E\uDDDF\u200D";
        int size = 3;
        int person_x = 3;
        int person_y = 1;

        int step = 0;
        // \n, \t - как спец символ(упомянуть)
        String output_str = "+ —— + —— + —— +\n"
                + "|    |    | \uD83C\uDFE0 |\n"
                + "+ —— + —— + —— +\n"
                + "|    | " + monster + " |    |\n"
                + "+ —— + —— + —— +\n"
                + "| " + person + " |    |    |\n"
                + "+ —— + —— + —— +";

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

//        if (answer.equals("ДА")) {
//            System.out.println("Сколько жизней будет у персонажа?");
////            person_live = sc.nextInt(); // здесь необходимо рассказать о возможных ошибках(неверный тип, переполнение - еще раз и тд)
//            System.out.println(output_str);
//            System.out.println("Live:\t" + person_live + "\n");
//
//            System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
//                    "\nКоординаты персонажа - (x: " + person_x + ", y: " + person_y + "))");
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            System.out.println(x + ", " + y);
//
//            // проверка
//            if (x != person_x && y != person_y) {
//                System.out.println("Неккоректный ход");
//            } else if (Math.abs(x - person_x) == 1) {
//                person_x = x;
//                System.out.println("Ход корректный; Новые координаты: " + person_x + ", " + person_y);
//            } else if (Math.abs(y - person_y) == 1) {
//                person_y = y;
//                System.out.println("Ход корректный; Новые координаты: " + person_x + ", " + person_y);
//            }else {
//                System.out.println("Координаты не изменены");
//            }
//
//        } else if (answer.equals("НЕТ")) {
//            System.out.println("Жаль, приходи еще!");
//        } else {
//            System.out.println("Данные введены неккоректно");
//        }

        switch (answer) {
            case "ДА" -> {
//                System.out.println("Сколько жизней будет у персонажа?");
//            person_live = sc.nextInt(); // здесь необходимо рассказать о возможных ошибках(неверный тип, переполнение - еще раз и тд)

                System.out.println(output_str);
                System.out.println("Live:\t" + person_live + "\n");
                System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                        "\nКоординаты персонажа - (x: " + person_x + ", y: " + person_y + "))");
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(x + ", " + y);

                // проверка
                if (x != person_x && y != person_y) {
                    System.out.println("Неккоректный ход");
                } else if (Math.abs(x - person_x) == 1) {
                    person_x = x;
                    step++;
                    System.out.println("Ход корректный; Новые координаты: " + person_x + ", " + person_y +
                            "\nХод номер: " + step);

                } else if (Math.abs(y - person_y) == 1) {
                    person_y = y;
                    step++;
                    System.out.println("Ход корректный; Новые координаты: " + person_x + ", " + person_y +
                            "\nХод номер: " + step);
                } else {
                    System.out.println("Координаты не изменены");
                }
            }
            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }
}