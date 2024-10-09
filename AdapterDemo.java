// Sistema antigo de entrega
class DeliverySystem {
    public String sendPackage(String pkg) {
        return "Enviando " + pkg + " via sistema de entrega.";
    }
}

// Adapter para o sistema antigo
class DeliveryAdapter {
    private DeliverySystem deliverySystem;

    public DeliveryAdapter(DeliverySystem deliverySystem) {
        this.deliverySystem = deliverySystem;
    }

    public String deliverFood(String food) {
        return deliverySystem.sendPackage(food);
    }
}

// Uso
public class AdapterDemo {
    public static void main(String[] args) {
        DeliverySystem deliverySystem = new DeliverySystem();
        DeliveryAdapter adapter = new DeliveryAdapter(deliverySystem);
        System.out.println(adapter.deliverFood("alimentos"));  // "Enviando alimentos via sistema de entrega."
    }
}
