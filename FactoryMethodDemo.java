// Produto abstrato
abstract class Donor {
    public abstract String donate();
}

// Produtos concretos
class IndividualDonor extends Donor {
    @Override
    public String donate() {
        return "Indivíduo está doando alimentos.";
    }
}

class RestaurantDonor extends Donor {
    @Override
    public String donate() {
        return "Restaurante está doando alimentos.";
    }
}

// Fábrica abstrata
abstract class DonorFactory {
    public abstract Donor createDonor();
}

// Fábricas concretas
class IndividualDonorFactory extends DonorFactory {
    @Override
    public Donor createDonor() {
        return new IndividualDonor();
    }
}

class RestaurantDonorFactory extends DonorFactory {
    @Override
    public Donor createDonor() {
        return new RestaurantDonor();
    }
}

// Uso
public class FactoryMethodDemo {
    public static void main(String[] args) {
        DonorFactory factory = new IndividualDonorFactory();
        Donor donor = factory.createDonor();
        System.out.println(donor.donate());  // "Indivíduo está doando alimentos."

        factory = new RestaurantDonorFactory();
        donor = factory.createDonor();
        System.out.println(donor.donate());  // "Restaurante está doando alimentos."
    }
}
