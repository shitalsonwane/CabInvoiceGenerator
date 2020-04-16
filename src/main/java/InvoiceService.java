public class InvoiceService {
    private static final double NORMAL_MINIMUM_COST_PER_KILOMETER = 10;
    private static final int NORMAL_COST_PER_MIN = 1;
    private static final double NORMAL_MINIMUM_FARE = 5;
    private TypesOfCabs types;
    private double averagePerRide;

    public InvoiceService(TypesOfCabs types) {
        this.types = types;
    }

    public double calculateFare(double distance, int time) {
        if (this.types.equals(TypesOfCabs.NORMAL_RIDES)) {
            double totalFare = (distance * NORMAL_MINIMUM_COST_PER_KILOMETER) + (time * NORMAL_COST_PER_MIN);
            return Math.max(totalFare, NORMAL_MINIMUM_FARE);
        }
        return 0.0;
    }

    public double[] calculateFare(Rides[] rides) {
        double[] result = new double[3];
        double totalFare = 0;
        for(Rides ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        result[0] = rides.length;
        result[1] = totalFare;
        result[2] = totalFare/rides.length;
        return result;
    }
}
