package seoo.module1.demo2;

public class MainProgram
{

    public static void main(String[] args)
    {
        PublicJavaTShirt tshirt1 = new PublicJavaTShirt();
        tshirt1.color = "red";
        tshirt1.size = "L";
                
        System.out.println("The color of c1 is "+ tshirt1.color);
        System.out.println("The size of c1 is "+ tshirt1.size);
    }

}
