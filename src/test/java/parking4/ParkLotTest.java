package parking4;

import org.junit.Test;
import parking.Car;
import parking.ParkTicket;
import parking3.ParkBoy;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ParkLotTest  {
    @Test
    public void parkTest(){
        //given
        Car car =new Car();
        ParkLot lot=new ParkLot(2);
        ParkLot lot1=new ParkLot(2);
        ParkLot lot2=new ParkLot(2);
        ParkLot lot3=new ParkLot(2);
        ParkLot lot4=new ParkLot(2);
        ParkLot lot5=new ParkLot(2);
        ParkLot lot6=new ParkLot(2);
        ParkLot lot7=new ParkLot(2);
        parking1.ParkBoy boy1=new parking1.ParkBoy(2,lot2,lot3);
        parking2.ParkBoy boy2=new parking2.ParkBoy(2,lot,lot1);
        ParkBoy boy3=new ParkBoy(2,lot4,lot5);
        List<ParkBoyModel> parkBoyModels=new ArrayList<ParkBoyModel>();
        parkBoyModels.add(boy1);
        parkBoyModels.add(boy2);
        parkBoyModels.add(boy3);
        ParkingManager manager=new ParkingManager(1,parkBoyModels,lot6,lot7);

        //when
        ParkTicket ticket=manager.park(car);
        //then
        assertThat(ticket).isNotEqualTo(null);
    }
    @Test
    public void parkByParkBoyTest(){
        //given
        Car car =new Car();
        ParkLot lot=new ParkLot(2);
        ParkLot lot1=new ParkLot(2);
        ParkLot lot2=new ParkLot(2);
        ParkLot lot3=new ParkLot(2);
        ParkLot lot4=new ParkLot(2);
        ParkLot lot5=new ParkLot(2);
        ParkLot lot6=new ParkLot(2);
        ParkLot lot7=new ParkLot(2);
        parking1.ParkBoy boy1=new parking1.ParkBoy(2,lot2,lot3);
        parking2.ParkBoy boy2=new parking2.ParkBoy(2,lot,lot1);
        ParkBoy boy3=new ParkBoy(2,lot4,lot5);
        List<ParkBoyModel> parkBoyModels=new ArrayList<ParkBoyModel>();
        parkBoyModels.add(boy1);
        parkBoyModels.add(boy2);
        parkBoyModels.add(boy3);
        ParkingManager manager=new ParkingManager(1,parkBoyModels,lot6,lot7);

        //when
        ParkTicket ticket1=manager.parkByBoy(car);
        //then
        assertThat(ticket1).isNotEqualTo(null);

    }
    @Test
    public void pickUpCar(){
        //given
        Car car =new Car();
        ParkLot lot=new ParkLot(2);
        ParkLot lot1=new ParkLot(2);
        ParkLot lot2=new ParkLot(2);
        ParkLot lot3=new ParkLot(2);
        ParkLot lot4=new ParkLot(2);
        ParkLot lot5=new ParkLot(2);
        ParkLot lot6=new ParkLot(2);
        ParkLot lot7=new ParkLot(2);
        parking1.ParkBoy boy1=new parking1.ParkBoy(2,lot2,lot3);
        parking2.ParkBoy boy2=new parking2.ParkBoy(2,lot,lot1);
        ParkBoy boy3=new ParkBoy(2,lot4,lot5);
        List<ParkBoyModel> parkBoyModels=new ArrayList<ParkBoyModel>();
        parkBoyModels.add(boy1);
        parkBoyModels.add(boy2);
        parkBoyModels.add(boy3);
        ParkingManager manager=new ParkingManager(1,parkBoyModels,lot6,lot7);

        //when
        ParkTicket ticket1=manager.parkByBoy(car);
        Car carPick = manager.pickUpCarByParkBoy(ticket1);
        //then
        assertThat(carPick).isEqualTo(car);
    }
    @Test
    public void pickUpCarByBoyTest(){
        //given
        Car car =new Car();
        ParkLot lot=new ParkLot(2);
        ParkLot lot1=new ParkLot(2);
        ParkLot lot2=new ParkLot(2);
        ParkLot lot3=new ParkLot(2);
        ParkLot lot4=new ParkLot(2);
        ParkLot lot5=new ParkLot(2);
        ParkLot lot6=new ParkLot(2);
        ParkLot lot7=new ParkLot(2);
        parking1.ParkBoy boy1=new parking1.ParkBoy(2,lot2,lot3);
        parking2.ParkBoy boy2=new parking2.ParkBoy(2,lot,lot1);
        ParkBoy boy3=new ParkBoy(2,lot4,lot5);
        List<ParkBoyModel> parkBoyModels=new ArrayList<ParkBoyModel>();
        parkBoyModels.add(boy1);
        parkBoyModels.add(boy2);
        parkBoyModels.add(boy3);
        ParkingManager manager=new ParkingManager(1,parkBoyModels,lot6,lot7);

        //when
        ParkTicket ticket1=manager.parkByBoy(car);
        Car carPick = manager.pickUpCarByParkBoy(ticket1);
        //then
        assertThat(carPick).isEqualTo(car);
    }
}
