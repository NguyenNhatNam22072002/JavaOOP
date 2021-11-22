interface PrintSalary{
    void Printsalary();
}

public class Teacher extends Person {
    private int salary;

    public Teacher(String name, int age, String address, int salary){
        super(name, age, address);
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalaty(int salary){
        this.salary = salary;
    }

    public void Printsalary(){
        System.out.println("Salary :" + salary);
    }
}