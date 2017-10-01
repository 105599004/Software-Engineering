package seoo.module1.demo3;

public class PublicJavaTShirt
{
    public String color;

    public String size;

    public void setColor(String inputColor)
    {
        if ("white".equalsIgnoreCase(inputColor) || "black".equalsIgnoreCase(inputColor))
            this.color = inputColor;
        else
            throw new IllegalArgumentException("Color Error.");
    }

}
