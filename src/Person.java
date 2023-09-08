import java.util.Random;

public class Person {
    int x, y;
    String image = "\uD83E\uDDD9\u200D";
    int live = 3;
    Random r = new Random();

    Person(int size) {
        this.y = size;
        int n = r.nextInt(size);
        this.x = n == 0 ? 1 : n;
    }

    int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLive() {
        return live;
    }

    public String getImage(){
        return image;
    }

    public boolean moveCorrect(int x, int y){
        if (this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1){
            return true;
        }
        return false;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void downLive(){
        live--;
    }
}