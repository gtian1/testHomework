package parking4;

import parking.Car;
import parking.ParkTicket;

import java.util.Arrays;
import java.util.List;

public class ParkingManager extends ParkBoyModel{
    private List<ParkBoyModel> parkBoys;
    public ParkingManager(int level, List<ParkBoyModel> parkBoys,ParkLot...parklot) {
        super(level,parklot);
        this.parkBoys= parkBoys;
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
    public ParkTicket parkByBoy(Car car){
        for (int i = 0; parkBoys!=null&&i <parkBoys.size() ; i++) {
            ParkBoyModel parkBoy = parkBoys.get(i);
            ParkTicket ticket = parkBoy.park(car);
            if(ticket!=null){
                return ticket;
            }
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
    public Car pickUpCarByParkBoy(ParkTicket ticket){
        for (int i = 0; parkBoys!=null&&i <parkBoys.size() ; i++) {
            ParkBoyModel parkBoy = parkBoys.get(i);
            Car car = parkBoy.pickUpCar(ticket);
            if(car!=null){
                return car;
            }
        }
        return null;
    }
    public String printParkingReport(){
        StringBuilder returnStr=new StringBuilder();
        returnStr.append(this.getPrintMessageStr("M"));
        for (int i = 0; parkBoys!=null&&i <parkBoys.size() ; i++) {
            ParkBoyModel parkBoy = parkBoys.get(i);
            int level=parkBoy.getLevel();
            for (int j = 0; j < level-1; j++) {
                returnStr.append(" ");
            }
            returnStr.append( parkBoy.getPrintMessageStr("B"));
        }
        return returnStr.toString();
    }
    public String getPrintMessageStr(String levelSimbol){
        int parkingCarNum = countParkingCarNum();
        int totalParkNum=countAllParkingLotNum();
        StringBuilder returnStr=new StringBuilder();
        StringBuilder spaceStr=new StringBuilder();

        for (int i = 0; i < super.getLevel()-1; i++) {
            spaceStr.append(" ");
        }

        returnStr.append(returnStr);
        returnStr.append(levelSimbol);
        returnStr.append(" ");
        returnStr.append(parkingCarNum);
        returnStr.append(" ");
        returnStr.append(totalParkNum);
        returnStr.append("\n");
        List<ParkLot> parklots = super.getParklots();
        for (int i = 0;parklots!=null&& i < parklots.size(); i++) {
            returnStr.append(" ");
            returnStr.append(spaceStr);
            ParkLot parkLot = parklots.get(i);
            returnStr.append(parkLot.getPrintMessageStr());
            returnStr.append("\n");
        }
        return returnStr.toString();
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
        for (int i = 0; parkBoys!=null&&i <parkBoys.size() ; i++) {
            ParkBoyModel parkBoy = parkBoys.get(i);
            if(parkBoy!=null){
                allParkLotNum+=parkBoy.countAllParkingLotNum();
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
        for (int i = 0; parkBoys!=null&&i <parkBoys.size() ; i++) {
            ParkBoyModel parkBoy = parkBoys.get(i);
            if(parkBoy!=null){
                allParkCarNum+=parkBoy.countParkingCarNum();
            }
        }
        return allParkCarNum;
    }
}
