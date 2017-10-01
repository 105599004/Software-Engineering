package seoo.module1.demo3;

public class MainProgram
{

    public static void main(String[] args)
    {
        PublicJavaTShirt tshirt1 = new PublicJavaTShirt();

        tshirt1.setColor("Black");
        System.out.println("The color of c1 is " + tshirt1.color);

        tshirt1.setColor("White");
        System.out.println("The color of c1 is " + tshirt1.color);

        // No Such Color: will cause error
        //tshirt1.setColor("Red");

        // No Such Color: but will not cause error
        tshirt1.color = "red";

        System.out.println("The color of c1 is " + tshirt1.color);
    }

}
