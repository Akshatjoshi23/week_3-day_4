import java.util.*;
import java.util.Objects;
interface Coffee{
    double cost();
    String description();
}

class SimpleCoffee implements Coffee{
    @Override
    public double cost() {
        return 2.0;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}
abstract class CoffeeDecorator implements Coffee{
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = Objects.requireNonNull(decoratedCoffee,"decoratedCoffee is required");
    }

}
class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 20.5;
    }

    @Override
    public String description() {
        return decoratedCoffee.description() + ", Milk";
    }
}
class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 10.0;
    }

    @Override
    public String description() {
        return decoratedCoffee.description() + ", Sugar";
    }
}
class WhippedCreamDecorator extends CoffeeDecorator{
    public WhippedCreamDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 30.0;
    }

    @Override
    public String description() {
        return decoratedCoffee.description() + ", Whipped Cream";
    }
}
public class DecoratorPattern {
    static void print(Coffee c){
        System.out.println(c.description() + " costs " + c.cost());
    }
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        print(coffee);

        coffee = new MilkDecorator(coffee);
        print(coffee);

        coffee = new SugarDecorator(coffee);
        print(coffee);

        coffee = new WhippedCreamDecorator(coffee);
        print(coffee);

        Coffee order=new SimpleCoffee();
        order=new MilkDecorator(order);
        order=new SugarDecorator(order);
        order=new WhippedCreamDecorator(order);
        print(order);
    }
}
