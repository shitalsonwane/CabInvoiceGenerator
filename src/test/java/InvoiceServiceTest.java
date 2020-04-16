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

    @Test
    public void givenMultipleRides_ShouldReturn_TotalRide() {
        InvoiceService cabInvoiceGenerator = new InvoiceService(TypesOfCabs.NORMAL_RIDES);
        Rides[] rides = {new Rides(2.0, 5),
                new Rides(0.1, 1)};
        InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedResult = new InvoiceSummary(2,30.0);
        Assert.assertEquals(summary, expectedResult);
    }

    @Test
    public void givenUserId_ShouldReturn_InvoiceSummery() {
        InvoiceService cabInvoiceGenerator = new InvoiceService(TypesOfCabs.NORMAL_RIDES);
        String userId = "a@b.com";
        Rides[] rides = {new Rides(2.0, 5),
                new Rides(0.1, 1)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = cabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedResult = new InvoiceSummary(2,30.0);
        Assert.assertEquals(summary, expectedResult);
    }
}
