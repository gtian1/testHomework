package parking;

import parking4.ParkBoyModel;
import parking4.ParkLot;

import java.util.Arrays;
import java.util.List;

public class ParkBoy extends ParkBoyModel {
    public ParkBoy(int level,ParkLot parklot) {
        super(level,parklot);
    }

    public ParkTicket park(Car car) {
        List<ParkLot> parklots = super.getParklots();
        for (int i = 0; parklots!=null&&i <parklots.size() ; i++) {
            ParkLot park = parklots.get(i);
            if(park.hasEmptyLot()){
                return park.park(car);
            }
        }
        return null;
    }

    public Car pickUpCar(ParkTicket ticket) {
        List<ParkLot> parklots = super.getParklots();
        ParkLot parklot=null;
        for (int i = 0; parklots!=null&&i < parklots.size(); i++) {
            parklot=parklots.get(i);
            Car car = parklot.pickUpCar(ticket);
            if(car!=null){
                return car;
            }
        }
        return null;
    }

}
