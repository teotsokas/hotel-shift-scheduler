import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void totalHoursSumsAllShifts(){

        Employee e = new Employee("kat",8, Department.CATERING);

        e.addShift( new Shift(10,18));
        e.addShift( new Shift(11,19));
        e.addShift( new Shift(12,20));
        assertEquals(24,e.totalHours());
    }

    @Test
    void allRestValidWithEnoughRest(){
        Employee e = new Employee("kat",8, Department.CLEAN);

        e.addShift( new Shift(10,18));
        e.addShift( new Shift(11,19));
        e.addShift( new Shift(12,20));
        assertTrue(e.allRestValid() );

    }

    @Test
    void allRestValidDetectsShortRest(){
        Employee e = new Employee("kat",8, Department.RECEPTION);
        e.addShift( new Shift(7,15));
        e.addShift( new Shift(15,23));
        e.addShift( new Shift(7,15));
        assertFalse(e.allRestValid() );


    }

    @Test
    void employeeWithNoShiftsHasValidRest(){
        Employee e = new Employee("kat",8, Department.CLEAN);
        assertTrue(e.allRestValid() );
    }

    @Test
    void zeroHourlyRateIsRejected(){
        assertThrows(IllegalArgumentException.class, () -> new Employee("kate",0, Department.CLEAN));
    }

    @Test
    void smallPositiveHourlyRateIsAccepted(){
        assertDoesNotThrow(() -> new Employee("kate", 0.5, Department.CATERING));
    }



}