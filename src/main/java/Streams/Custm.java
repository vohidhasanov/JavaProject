package Streams;

class Contex {
    String firstName;
    String lastName;
    String address;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class Custm {
private Contex contex = new Contex();

public Custm firstName (String firstName) {
    contex.firstName = firstName;
    return this;
}

public Custm lastname (String lastName) {
    contex.lastName = lastName;
    return this;
}

public Custm address (String address) {
    contex.address = address;
    return this;
}

public void printData() {
    System.out.println(contex.firstName+ " "+ contex.lastName + " "+ contex.address);
}


    public static void main(String[] args) {
    Custm custm = new Custm();
    custm.firstName("Vohid").lastname("Hasanov").address("J.Mirzo 22").printData();

    }
}


