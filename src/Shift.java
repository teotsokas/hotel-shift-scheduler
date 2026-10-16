public class Shift {
    private int endHour, startHour;
    private final double MIN_REST_HOURS = 11;

    public Shift(int startHour, int endHour){
        if( startHour < 0 || startHour > 23 ){
            throw new IllegalArgumentException("startHour must be >= 0 and <24, got: "+startHour);
        }
        else if( endHour < 0 || endHour >23 ){
            throw new IllegalArgumentException("endHour must be >= 0 and <24, got: " + endHour);
        } else if (endHour == startHour) {
            throw new IllegalArgumentException("endHour and startHour must be diffrent");
        }
        this.endHour = endHour;
        this.startHour = startHour;
    }



    public  int length(){
        if(startHour <= endHour)
            return endHour-startHour;
        else
            return endHour - startHour + 24;

     }




    public boolean isRestValid(Shift next){
        double rest ;
        if( endHour >= next.startHour )
            rest = next.startHour -endHour + 24;
        else
            rest = next.startHour - endHour;

        if( rest >= MIN_REST_HOURS)
            return true;
        else
            return false;

    }
}
