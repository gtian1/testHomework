package parking3;

import parking.Car;
import parking.ParkTicket;
import parking4.ParkBoyModel;
import parking4.ParkLot;

import java.util.Arrays;
import java.util.List;

public class ParkBoy extends ParkBoyModel {
    public ParkBoy(int level,ParkLot... parklot) {
        super(level,parklot);
    }

    public ParkTicket park(Car car) {
        ParkLot parkLot = this.getMostVancyRateParkingLot();
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
    public ParkLot getMostVancyRateParkingLot(){
        ParkLot parklot=null;
        List<ParkLot> parklots = super.getParklots();
        double maxVancyRate=0;
        for (int i = 0; parklots!=null&&i <parklots.size() ; i++) {
            ParkLot parkLotNow = parklots.get(i);
            double vancyRate=parkLotNow.getVancyRate();
            if(parkLotNow.hasEmptyLot()&&vancyRate>=maxVancyRate){
                maxVancyRate=vancyRate;
                parklot=parkLotNow;
            }
        }
        return parklot;
    }
    public int countAllParkingLotNum(){
        int allParkLotNum=0;
        List<ParkLot> parklots = super.getParklots();
        for (int i = 0; parklots!=null&&i <parklots.size() ; i++) {
            ParkLot park = parklots.get(i);
            if(park!=null){
                allParkLotNum+=park.getTotalParkNum();
            }
        }
        return allParkLotNum;
    }
    public int countParkingCarNum(){
        int allParkCarNum=0;
        List<ParkLot> parklots = super.getParklots();
        for (int i = 0; parklots!=null&&i <parklots.size() ; i++) {
            ParkLot park = parklots.get(i);
            if(park!=null){
                allParkCarNum+=park.getParkingCarNum();
            }
        }
        return allParkCarNum;
    }
}
