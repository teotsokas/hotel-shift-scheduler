import java.util.ArrayList;

public class Employee {
    private String name;
    private double   hourlyRate;
    private ArrayList<Shift> shifts;
    private Department department;

    public Employee(String name, double hourlyRate, Department department){
        if(hourlyRate <=0)
            throw new IllegalArgumentException("hourlyRate must be > 0, got: " + hourlyRate);
        this.hourlyRate = hourlyRate;
        this.name = name;
        this.shifts = new ArrayList<>();
        this.department = department;

    }

    public Department getDepartment() {
        return department;
    }


    public void addShift(Shift s){
        shifts.add(s);

    }

    public double totalHours(){
        double sum = 0;
        for (Shift s : shifts){
            sum += s.length();

        }
        return sum;
    }

    public void printInfo(){
        System.out.println("The employee : " + name + " from the department : " + department + " with hourlyRate : " + hourlyRate +" has "  + totalHours() +" hours this week");
    }

    public boolean allRestValid() {
        for (int i = 0; i < shifts.size() - 1; i++) {
            Shift current = shifts.get(i);
            Shift next = shifts.get(i + 1);
            if (!current.isRestValid(next)) {
                return false;
            }
        }
        return true;
    }

}
