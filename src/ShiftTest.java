import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {

    @Test
    void dayShiftLasts8Hours(){
        Shift s = new Shift(7,15);
        int result = s.length();
        assertEquals(8,result);
    }

    @Test
    void overnightShiftLasts8Hours(){
        Shift s = new Shift(22,6);
        int result = s.length();
        assertEquals(8,result);


    }

    @Test
    void shiftStartingAtMidnightLasts8Hours(){
        Shift s = new Shift(0,8);
        int result = s.length();
        assertEquals(8,result);

    }

    @Test
    void restOfExactly11HoursIsValid(){
        Shift s = new Shift(7,15);
        Shift s1 = new Shift(2,10);
        assertTrue(s.isRestValid(s1));
    }

    @Test
    void restOf10HoursIsNotValid(){
        Shift s = new Shift(15,23);
        Shift s1 = new Shift(9,17);
        assertFalse(s.isRestValid(s1));
    }

    @Test
    void shiftWithSameStartAndEndIsRejected(){
        assertThrows(IllegalArgumentException.class, () -> new Shift(8,8));
    }

    @Test
    void startHourBelowZeroIsRejected(){
        assertThrows(IllegalArgumentException.class, () -> new Shift(-1,6));
    }

    @Test
    void endHourAbove23IsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Shift(6, 24));

    }

    @Test
    void hour0IsAccepted(){
        assertDoesNotThrow(()-> new Shift(0,8));
        }


    @Test
    void hour23IsAccepted(){
        assertDoesNotThrow(()-> new Shift(23,7));
    }



    }