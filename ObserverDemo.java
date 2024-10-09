import java.util.ArrayList;
import java.util.List;

// Observador
interface Observer {
    void update(String donation);
}

// ONG que será notificada
class Organization implements Observer {
    @Override
    public void update(String donation) {
        System.out.println("ONG recebeu notificação de nova doação: " + donation);
    }
}

// Sujeito (Notifier)
class DonorNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String donation) {
        for (Observer observer : observers) {
            observer.update(donation);
        }
    }
}

// Uso
public class ObserverDemo {
    public static void main(String[] args) {
        DonorNotifier notifier = new DonorNotifier();
        Observer ong = new Organization();
        notifier.addObserver(ong);
        notifier.notifyObservers("10 caixas de leite");  // ONG é notificada
    }
}
