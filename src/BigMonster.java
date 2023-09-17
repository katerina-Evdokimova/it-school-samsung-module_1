import java.util.Scanner;

public class BigMonster extends Monster{

    private String image = "\uD83D\uDC79";

    BigMonster(int sizeBoard) {
        super(sizeBoard);
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    // переопредилим метод:
    @Override
    public boolean taskMonster(){
        System.out.println("Решите задачу:");
        int x = r.nextInt(15);
        int y = r.nextInt(10);
        int z = r.nextInt(20);
        int trueAnswer = x * y - z;
        System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (trueAnswer == ans) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        }
        System.out.println("Ты проиграл эту битву!");
        return false;
    }
}