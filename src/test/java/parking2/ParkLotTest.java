package parking2;

import org.junit.Test;
import parking.Car;
import parking.ParkTicket;
import parking4.ParkLot;

import static org.fest.assertions.api.Assertions.assertThat;

public class ParkLotTest   {
    @Test
    public void parkTest(){
        //given
        Car car =new Car();
        ParkLot lot=new ParkLot(2);
        ParkBoy boy=new ParkBoy(2,lot);
        //when
        ParkTicket ticket=boy.park(car);
        //then
        assertThat(ticket).isNotEqualTo(null);
    }
    @Test
    public void parkMostEmptyLotTest(){
        //given
        Car car =new Car();
        ParkLot lot=new ParkLot(2);
        ParkLot lot1=new ParkLot(4);
        ParkBoy boy=new ParkBoy(2,lot,lot1);
        //when
        ParkTicket ticket=boy.park(car);
        ParkLot lotMot = boy.getMostEmptySpaceParkingLot();
        //then
        assertThat(lotMot.pickUpCar(ticket)).isEqualTo(car);
    }
    @Test
    public void pickUpCar(){
        //given
        Car car =new Car();
        Car car1=new Car();
        ParkLot lot=new ParkLot(2);
        ParkLot lot1=new ParkLot(2);
        ParkBoy boy=new ParkBoy(2,lot,lot1);
        //when
        ParkTicket ticket=boy.park(car);
        ParkTicket ticket1=boy.park(car1);
        //then
        Car car2=boy.pickUpCar(ticket1);
        Car car3=boy.pickUpCar(ticket);
        assertThat(car2).isEqualTo(car1);
        assertThat(car3).isEqualTo(car);
    }
}
