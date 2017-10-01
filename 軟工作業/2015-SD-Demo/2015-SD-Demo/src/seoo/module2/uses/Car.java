package seoo.module2.uses;

public class Car
{
    private double weight = 10;

    public void addBaggageWeight(Baggage b)
    {
        weight += b.getWeight();
    }

    public double getWeight()
    {
        return weight;
    }

    public static void main(String[] args)
    {
        Car car = new Car();
        System.out.println("Car weight=" + car.getWeight());
        
        car.addBaggageWeight(new Baggage(10));
        car.addBaggageWeight(new Baggage(10));
        car.addBaggageWeight(new Baggage(10));
        System.out.println("Car weight=" + car.getWeight());
    }

}
