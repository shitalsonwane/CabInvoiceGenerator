import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_GeneratorShouldReturn_TotalFareForNormalRide() {
        double distance = 2.0;
        int time = 5;
        InvoiceService invoiceGenerator = new InvoiceService(TypesOfCabs.NORMAL_RIDES);
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_GeneratorShouldReturn_MinimumFareForNormalRide() {
        double distance = 0.1;
        int time = 1;
        InvoiceService invoiceGenerator = new InvoiceService(TypesOfCabs.NORMAL_RIDES);
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }
}
