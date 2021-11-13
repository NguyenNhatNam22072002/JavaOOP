interface PrintGpa{
    void Printgpa();
}
public class Student extends Person{
    private double gpa;

    public Student(String name, int age, String address, double gpa){
        super(name, age, address);
        this.gpa = gpa;
    }

    public double getGpa(){
        return gpa;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    public void Printgpa(){
        System.out.println("GPA :" + gpa);
    }
}