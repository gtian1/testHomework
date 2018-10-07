package parking;

import org.junit.Test;
import parking4.ParkLot;

import static org.fest.assertions.api.Assertions.assertThat;

public class ParkLotTest {
    @Test
    public void parkTest(){
        //given
        Car car =new Car();
        ParkLot lot=new ParkLot(1);
        ParkBoy boy=new ParkBoy(2,lot);
        //when
        ParkTicket ticket=boy.park(car);
        //then
        assertThat(ticket).isNotEqualTo(null);
    }
    @Test
    public void pickUpCar(){
        //given
        Car car =new Car();
        ParkLot lot=new ParkLot(1);
        ParkBoy boy=new ParkBoy(2,lot);
        //when
        ParkTicket ticket=boy.park(car);
        //then
        Car car1=boy.pickUpCar(ticket);
        assertThat(car1).isEqualTo(car);
    }
}
