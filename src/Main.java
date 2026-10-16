import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee teo = new Employee("Teo", 6, Department.RECEPTION);
        Employee marianna = new Employee("marianna", 6, Department.CATERING);
       // teo.printInfo();
        // marianna.printInfo();
        Shift s1 = new Shift(7, 15);
        Shift s2 = new Shift(15, 23);
        Shift s3 = new Shift(22, 6);
        Shift s4 = new Shift(23, 7);
        Shift s5 = new Shift(0, 8);
        Shift s6 = new Shift(10,18);
        Shift s7 = new Shift(9, 17);
        Shift s8 = new Shift(8, 10);



        teo.addShift(s1);
        teo.addShift(s3);
        teo.addShift(s5);
        teo.printInfo();
        System.out.println(s1.isRestValid(s1));
        System.out.println(s2.isRestValid(s1));
        System.out.println(s3.isRestValid(s3));
        System.out.println(s3.isRestValid(s2));
        System.out.println(s2.isRestValid(s6));
        System.out.println(s2.isRestValid(s7));
        System.out.println(s1.isRestValid(s4));
        System.out.println(s5.isRestValid(s3));
        System.out.println(s4.isRestValid(s8));

        ArrayList<Shift> shifts = new ArrayList<>();
        shifts.add(new Shift(6,16));
        shifts.add(new Shift(6,17));
        shifts.add(new Shift(6,18));
        shifts.add(new Shift(6,19));
        shifts.add(new Shift(6,20));

        for(int i=0; i < shifts.size(); i++){
            System.out.println("Shift " + (i+1) +": " + shifts.get(i).length());
        }

        Employee a = new Employee("Teo", 8, Department.CLEAN);
        a.addShift(new Shift(7, 15));
        a.addShift(new Shift(7, 15));
        a.addShift(new Shift(7, 15));
        System.out.println("Test A (exp true):  " + a.allRestValid());

        Employee b = new Employee("Marianna", 6, Department.RECEPTION);
        b.addShift(new Shift(7, 15));
        b.addShift(new Shift(15, 23));
        b.addShift(new Shift(7, 15));
        System.out.println("Test B (exp false): " + b.allRestValid());

        Employee c = new Employee("Nikos", 7, Department.CLEAN);
        System.out.println("Test C (exp true):  " + c.allRestValid());

        new Shift(0, 8);
        new Shift(23, 7);

    }
}


