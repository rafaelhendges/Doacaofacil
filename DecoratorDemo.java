// Componente base
abstract class Donation {
    public abstract String description();
}

// Componente concreto
class BasicDonation extends Donation {
    @Override
    public String description() {
        return "Alimentos doados";
    }
}

// Decorator abstrato
abstract class DonationDecorator extends Donation {
    protected Donation donation;

    public DonationDecorator(Donation donation) {
        this.donation = donation;
    }

    @Override
    public String description() {
        return donation.description();
    }
}

// Decorators concretos
class PerishableDonation extends DonationDecorator {
    public PerishableDonation(Donation donation) {
        super(donation);
    }

    @Override
    public String description() {
        return donation.description() + " (Perecível)";
    }
}

class RefrigeratedDonation extends DonationDecorator {
    public RefrigeratedDonation(Donation donation) {
        super(donation);
    }

    @Override
    public String description() {
        return donation.description() + " (Requer Refrigeração)";
    }
}

// Uso
public class DecoratorDemo {
    public static void main(String[] args) {
        Donation donation = new BasicDonation();
        Donation perishableDonation = new PerishableDonation(donation);
        Donation refrigeratedPerishableDonation = new RefrigeratedDonation(perishableDonation);
        System.out.println(refrigeratedPerishableDonation.description());  // "Alimentos doados (Perecível) (Requer Refrigeração)"
    }
}

