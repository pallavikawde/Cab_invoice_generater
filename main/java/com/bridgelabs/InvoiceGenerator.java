package com.bridgelabs;

public class InvoiceGenerator {
    RideRepository rideRepository;

    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    /********************************************************************************
     * @author pallavi
     * purpose-calculating Amount
     * @param rides
     * @return
     ************************************************************************************/
    public InvoiceSummary calculateAmount(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += RideType.calculateFare(ride.rideType, ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /***************************************************************************************************
     *purpose-adding Rides
     * @param userId
     * @param ride
     ******************************************************************************************************/

    public void addRides(String userId, Ride[] ride) {
        rideRepository.addRide(userId, ride);
    }

    public InvoiceSummary getInvoiceSummary(String userId) throws ExceptionType {
        return this.calculateAmount(rideRepository.getRides(userId));
    }

}

