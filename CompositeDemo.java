import java.util.ArrayList;
import java.util.List;

// Componente
abstract class FoodItem {
    public abstract String donate();
}

// Folhas
class Fruit extends FoodItem {
    @Override
    public String donate() {
        return "Doando frutas.";
    }
}

class Grains extends FoodItem {
    @Override
    public String donate() {
        return "Doando grãos.";
    }
}

// Composite
class DonationComposite extends FoodItem {
    private List<FoodItem> items = new ArrayList<>();

    public void add(FoodItem item) {
        items.add(item);
    }

    @Override
    public String donate() {
        StringBuilder result = new StringBuilder();
        for (FoodItem item : items) {
            result.append(item.donate()).append(" ");
        }
        return result.toString();
    }
}

// Uso
public class CompositeDemo {
    public static void main(String[] args) {
        DonationComposite composite = new DonationComposite();
        composite.add(new Fruit());
        composite.add(new Grains());
        System.out.println(composite.donate());  // "Doando frutas. Doando grãos."
    }
}
