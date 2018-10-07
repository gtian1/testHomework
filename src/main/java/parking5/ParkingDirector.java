package parking5;

import parking4.ParkingManager;

public class ParkingDirector {
    private ParkingManager manager;

    public ParkingDirector(ParkingManager manager) {
        this.manager = manager;
    }

    public String printParkingReport(){
       return manager.printParkingReport();
    }
}
