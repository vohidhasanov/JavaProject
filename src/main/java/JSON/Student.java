package JSON;

public class Student {
    private int id;
    private Name name;

//    public Student(int id, Name name) {
//        this.id = id;
//        this.name = name;
//    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public String getSurname() {
        return name.getLastName();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(Name name) {
        this.name = name;
    }


    public static void main(String[] args) {
        Student st = new Student();
      //  Student st2 = new Student(1, new Name());
        st.id=10;
        st.setName(new Name());
        st.name.setFirstName("John");
        st.name.setLastName("Johnson");

      //  st2.name.setFirstName("Hellloo");

        System.out.println(st.getFirstName()+ " - "+ st.getSurname());

    }
}
