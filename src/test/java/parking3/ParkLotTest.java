package parking3;

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
        Car car1 =new Car();
        ParkLot lot=new ParkLot(2);
        ParkLot lot1=new ParkLot(5);
        ParkBoy boy=new ParkBoy(2,lot,lot1);
        //when
        ParkTicket ticket1=boy.park(new Car());
        ParkTicket ticket=boy.park(car);
        ParkTicket ticket2=boy.park(car1);
        ParkLot lotMot = boy.getMostVancyRateParkingLot();
        //then
        assertThat(lotMot.pickUpCar(ticket2)).isEqualTo(car1);
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
