import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private ArrayList<Employee> employees ;


    public Hotel(){
        this.employees = new ArrayList<>();
    }


    public void  addEmployee(Employee e){
        employees.add(e);
    }


    public int getEmployeeCount(){
        return employees.size();
    }

    public HashMap<Department, Integer> countByDepartment(){
        HashMap<Department, Integer> staffPerDepartment = new HashMap<>();
        for( Department department : Department.values()){
            staffPerDepartment.put(department,0);
        }

        for( Employee e : employees){
                int current = staffPerDepartment.getOrDefault(e.getDepartment(), 0);
                staffPerDepartment.put(e.getDepartment(),current +1);
        }
        return staffPerDepartment;
    }

}
