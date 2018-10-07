package parking2;

import parking.Car;
import parking.ParkTicket;
import parking4.ParkBoyModel;
import parking4.ParkLot;

import java.util.List;

public class ParkBoy extends ParkBoyModel {
    public ParkBoy(int level,ParkLot... parklot) {
        super(level,parklot);
    }

    public ParkTicket park(Car car) {
        ParkLot parkLot = this.getMostEmptySpaceParkingLot();
        if(parkLot!=null){
            return parkLot.park(car);
        }
       return null;
    }

    public Car pickUpCar(ParkTicket ticket) {
        List<ParkLot> parklots = super.getParklots();
        for (int i = 0; parklots!=null&&i <parklots.size() ; i++) {
            ParkLot park = parklots.get(i);
            Car car = park.pickUpCar(ticket);
            if(car!=null){
                return car;
            }
        }
        return null;
    }
    public ParkLot getMostEmptySpaceParkingLot(){
        ParkLot parklot=null;
        List<ParkLot> parklots = super.getParklots();
        int parkLotNum=0;
        for (int i = 0; parklots!=null&&i <parklots.size() ; i++) {
            ParkLot parkLotNow = parklots.get(i);
            int emptyLotNum=parkLotNow.getParkLotNum();
            if(parkLotNow.hasEmptyLot()&&emptyLotNum>=parkLotNum){
                parkLotNum=emptyLotNum;
                parklot=parkLotNow;
            }
        }
        return parklot;
    }
}
