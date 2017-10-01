package seoo.module2.knows;

public class Airplane
{
    private Bitmap bitmap = new Bitmap();

    private int x;

    private int y;

    public void draw()
    {
        bitmap.draw(x, y);
    }

    public void move()
    {
        x++;

        y++;
    }

    public static void main(String[] args)
    {
        Airplane airplane = new Airplane();
        
        airplane.move();
        airplane.move();
        airplane.move();
        
        airplane.draw();

    }

}
