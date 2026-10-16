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

    @Test
    void ShiftStartingAt22IsNight(){
        Shift s =new Shift(22, 6);
        assertEquals(ShiftType.NIGHT, s.getType() );
    }

    @Test
    void ShiftStartingAt14IsAfternoon(){
        Shift s =new Shift(14, 0);
        assertEquals(ShiftType.AFTERNOON, s.getType() );
    }

    @Test
    void ShiftStartingAt6IsMorning(){
        Shift s =new Shift(6, 14);
        assertEquals(ShiftType.MORNING, s.getType() );
    }


    @Test
    void ShiftStartingAt13IsAlsoMorning(){
        Shift s =new Shift(13, 21);
        assertEquals(ShiftType.MORNING, s.getType() );
    }

    @Test
    void ShiftStartingAt21IsAlsoAfternoon(){
        Shift s =new Shift(21, 5);
        assertEquals(ShiftType.AFTERNOON, s.getType() );
    }

    @Test
    void ShiftStartingAt5IsAlsoNight(){
        Shift s =new Shift(5, 13);
        assertEquals(ShiftType.NIGHT, s.getType() );
    }


    }