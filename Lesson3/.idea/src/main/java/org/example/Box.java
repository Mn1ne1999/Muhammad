import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float total = 0.0f;
        for (T fruit : fruits) {
            total += fruit.getWeight();
        }
        return total;
    }

    public boolean compare(Box<? extends Fruit> other) {
        return Math.abs(this.getWeight() - other.getWeight()) < 0.0001;
    }

    public void transferFruitsTo(Box<T> other) {
        if (this == other) return;
        other.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public int size() {
        return fruits.size();
    }

    public void printContents() {
        System.out.println("Коробка содержит: " + fruits);
    }
}
