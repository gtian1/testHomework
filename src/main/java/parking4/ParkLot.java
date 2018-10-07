package parking4;

import parking.Car;
import parking.ParkTicket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParkLot {
    private Map<ParkTicket, Car> ticketCarMap=new HashMap<ParkTicket, Car>();
    private int parkLotNum;
    private int totalParkNum;
    public ParkLot(int parkLotNum) {
        this.totalParkNum= parkLotNum;
        this.parkLotNum = parkLotNum;
    }

    public ParkTicket park(Car car) {
        ParkTicket ticket=null;
        if(this.hasEmptyLot()){
            ticket = new ParkTicket();
            ticketCarMap.put(ticket,car);
            parkLotNum--;
        }
        return ticket;
    }

    public Car pickUpCar(ParkTicket ticket) {
        Car car=ticketCarMap.get(ticket);
        if(car!=null){
            ticketCarMap.put(ticket,null);
        }
        return car;
    }
    public boolean hasEmptyLot(){
        if(parkLotNum >0){
            return  true;
        }
        return false;
    }

    public int getParkLotNum() {
        return parkLotNum;
    }
    public double getVancyRate(){
        double vancyRate=new BigDecimal(parkLotNum).divide(new BigDecimal(totalParkNum)).doubleValue();
        return vancyRate;
    }
    public int getParkingCarNum(){
        return totalParkNum-parkLotNum;
    }

    public int getTotalParkNum() {
        return totalParkNum;
    }
    public String getPrintMessageStr(){
        int parkingCarNum = getParkingCarNum();
        int totalParkNum=getTotalParkNum();
        StringBuilder returnStr=new StringBuilder();
        returnStr.append("P ");
        returnStr.append(parkingCarNum);
        returnStr.append(" ");
        returnStr.append(totalParkNum);
        return returnStr.toString();
    }
}
