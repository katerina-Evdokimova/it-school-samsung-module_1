import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9\u200D";
        int personLive = 3;
        /* здесь необходимо рассказать про переполнение и про другие типы данных
            int personLive = 2147483649; // мало ли кто-то захочет сделать ооочень много жизней
         */

        String monster = "\uD83E\uDDDF\u200D";
        int sizeBoard = 3;
        int personX = 1;
        int personY = 3;

        int step = 0;
        // \n, \t - спец символ
        String gamingField = "+ —— + —— + —— +\n"
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

    }
}