package seoo.module1.demo4;

public class EncapJavaTShirt
{
    private String color;

    private String size;

    public void setColor(String inputColor)
    {
        if ("white".equalsIgnoreCase(inputColor) || "black".equalsIgnoreCase(inputColor))
            this.color = inputColor;
        else
            throw new IllegalArgumentException("Color Error.");
    }

    public String getColor()
    {
        return color;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

}
