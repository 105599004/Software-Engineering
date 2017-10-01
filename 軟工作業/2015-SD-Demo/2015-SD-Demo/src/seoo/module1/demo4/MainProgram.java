package seoo.module1.demo4;

public class MainProgram
{

    public static void main(String[] args)
    {
        EncapJavaTShirt tshirt1 = new EncapJavaTShirt();

        tshirt1.setColor("Black");
        System.out.println("The color of c1 is " + tshirt1.getColor());

        tshirt1.setColor("White");
        System.out.println("The color of c1 is " + tshirt1.getColor());

        // No Such Color: pass the compile process, but will cause runtime exception 
        tshirt1.setColor("Red");

        // No Such Color: compile error, since the TShirt is encapsulated, direct access is not allowed
        //tshirt1.color = "red";
        
        System.out.println("The color of c1 is " + tshirt1.getColor());
    }

}
