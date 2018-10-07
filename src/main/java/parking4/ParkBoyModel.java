package parking4;

import parking.Car;
import parking.ParkTicket;

import java.util.Arrays;
import java.util.List;

public abstract class  ParkBoyModel {
    private List<ParkLot> parklots;
    private int level=0;
    public ParkBoyModel(int level,ParkLot... parklot) {
        this.level=level;
        this.parklots= Arrays.asList(parklot);
    }
    public abstract ParkTicket park(Car car);

    public abstract Car pickUpCar(ParkTicket ticket);
    public int countAllParkingLotNum(){
        int allParkLotNum=0;
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
        for (int i = 0; parklots!=null&&i <parklots.size() ; i++) {
            ParkLot park = parklots.get(i);
            if(park!=null){
                allParkCarNum+=park.getParkingCarNum();
            }
        }
        return allParkCarNum;
    }

    public List<ParkLot> getParklots() {
        return parklots;
    }
    public String getPrintMessageStr(String levelSimbol){
        int parkingCarNum = countParkingCarNum();
        int totalParkNum=countAllParkingLotNum();
        StringBuilder returnStr=new StringBuilder();
        StringBuilder spaceStr=new StringBuilder();
        for (int i = 0; i < level-1; i++) {
            spaceStr.append(" ");
        }

        returnStr.append(returnStr);
        returnStr.append(levelSimbol);
        returnStr.append(" ");
        returnStr.append(parkingCarNum);
        returnStr.append(" ");
        returnStr.append(totalParkNum);
        returnStr.append("\n");
        for (int i = 0;parklots!=null&& i < parklots.size(); i++) {
            returnStr.append(" ");
            returnStr.append(spaceStr);
            ParkLot parkLot = parklots.get(i);
            returnStr.append(parkLot.getPrintMessageStr());
            returnStr.append("\n");
        }
        return returnStr.toString();
    }

    public int getLevel() {
        return level;
    }
}
