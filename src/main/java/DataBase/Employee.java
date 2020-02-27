package DataBase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Employee {
    private Long id;
    private String name;
    private BigDecimal salary;
    private LocalDateTime createDate;

    public Employee() {}

    public Employee(Long id, String name, BigDecimal salary, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.createDate = createDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", createDate=" + createDate +
                '}';
    }
}
