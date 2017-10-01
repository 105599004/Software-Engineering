package seoo.module1.demo1;

public class MainProgram
{

    public static void main(String[] args)
    {
        JavaTShirt c1 = new JavaTShirt("black", "L");
        
        System.out.println("The color of c1 is "+ c1.getColor());
        System.out.println("The size of c1 is "+ c1.getSize());
    }

}
