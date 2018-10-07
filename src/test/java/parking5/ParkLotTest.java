package parking5;

import org.junit.Test;
import parking.Car;
import parking.ParkTicket;
import parking3.ParkBoy;
import parking4.ParkBoyModel;
import parking4.ParkLot;
import parking4.ParkingManager;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ParkLotTest {
    @Test
    public void printReportTest(){
        //given
        Car car =new Car();
        ParkLot lot=new ParkLot(2);
        ParkLot lot2=new ParkLot(3);
        parking2.ParkBoy boy2=new parking2.ParkBoy(2,lot);
        List<ParkBoyModel> parkBoyModels=new ArrayList<ParkBoyModel>();
        parkBoyModels.add(boy2);
        ParkingManager manager=new ParkingManager(1,parkBoyModels,lot2);

        //when
        ParkTicket ticket1=manager.parkByBoy(car);
        ParkTicket ticket7=manager.park(new Car());
        ParkingDirector director=new ParkingDirector(manager);

        //then
        String strMess=director.printParkingReport();
        System.out.print(strMess);
        String str="M 2 5\n" +
                " P 1 3\n" +
                " B 1 2\n" +
                "  P 1 2\n";
        assertThat(strMess).isEqualTo(str);/**/
    }

}
