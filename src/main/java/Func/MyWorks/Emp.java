package Func.MyWorks;

public class Emp {
    private String name;
    private String address;
    private int number;

    public Emp(String name, String address, int number) {
        System.out.println("Construncting an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void mailCheck () {
        System.out.println("Mainling a check to " + this.name+ " " + this.address);
    }
    public String toString () {
        return name+ " " + address + " " + number;
}

    public String getName () {
    return name;    }

    public String getAddress () {
    return address;
    }

    public void setAddress (String newAdress) {
    address = newAdress;
}

    public int getNumber () {
    return number;
    }

        }


class Salary extends Emp {
    private double salary;

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary (salary);
    }
    public void mailCheck () {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName() + " with salary " + salary);
    }
    public double getSalary () {
        return salary;
    }
    public void setSalary (double newSalary) {
        if (newSalary >= 0.0)
            salary = newSalary;    }

    public double computePay () {
        System.out.println("Computing salary pay for " + getName());
        return salary/52;
    }

    public static void main(String[] args) {
        Salary s = new Salary("Mohd Mohtwshim", "Ambehta st", 3, 3600.00);
        Emp e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
        System.out.println("Call mailcheck using Salary referece ---");
        s.mailCheck();
        System.out.println("\n Call mailcheck using Employee referech---");
        e.mailCheck();
    }
}