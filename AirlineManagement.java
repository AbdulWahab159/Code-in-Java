package wahab;

interface Display {
    void show();
}

interface Aircraft extends Display {
    String aircraftType();
    int calculateCapacity();
}

class PassengerJet implements Aircraft {
    private final int rows;
    private final int seatsPerRow;

    public PassengerJet(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

    @Override
    public String aircraftType() {
        return "Passenger Jet";
    }

    @Override
    public int calculateCapacity() {
        return rows * seatsPerRow;
    }

    @Override
    public void show() {
        System.out.println("Aircraft Type: " + aircraftType());
        System.out.println("Passenger Capacity: " + calculateCapacity());
    }
}

class CargoPlane implements Aircraft {
    private final double length; 
    private final double width;  
    private final int CONVERSION_FACTOR = 2;

    public CargoPlane(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String aircraftType() {
        return "Cargo Plane";
    }

    @Override
    public int calculateCapacity() {
        double area = length * width;
        return (int) (area / CONVERSION_FACTOR); // Estimated capacity
    }

    @Override
    public void show() {
        System.out.println("Aircraft Type: " + aircraftType());
        System.out.println("Estimated Passenger Equivalent Capacity: " + calculateCapacity());
    }
}


class PrivateJet implements Aircraft {
    private final int seats;

    public PrivateJet(int seats) {
        this.seats = seats;
    }

    @Override
    public String aircraftType() {
        return "Private Jet";
    }

    @Override
    public int calculateCapacity() {
        return seats;
    }

    @Override
    public void show() {
        System.out.println("Aircraft Type: " + aircraftType());
        System.out.println("Luxury Seats: " + calculateCapacity());
    }
}

// Main class
public class AirlineManagement {
    public static void main(String[] args) {
        Aircraft passengerJet = new PassengerJet(30, 6); // 30 rows, 6 seats per row
        Aircraft cargoPlane = new CargoPlane(20.0, 5.0); // 20m x 5m area
        Aircraft privateJet = new PrivateJet(10);

        System.out.println("=== Passenger Jet ===");
        passengerJet.show();

        System.out.println("\n=== Cargo Plane ===");
        cargoPlane.show();

        System.out.println("\n=== Private Jet ===");
        privateJet.show();
    }
}

