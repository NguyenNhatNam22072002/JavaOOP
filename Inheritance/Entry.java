interface PrintName{
    void Printname();
}
interface PrintAge{
    void Printage();
}
interface PrintAddress{
    void Printaddress();
}
class Person implements PrintName, PrintAge, PrintAddress{
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        if(age > 0) this.age = age;
        else System.out.println("Age must be >0");
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void Printname(){
        System.out.println("Name :" + name);
    }

    public void Printage(){
        System.out.println("Age :" + age);
    } 

    public void Printaddress(){
        System.out.println("Address :" + address);
    }
    public void NAM()
    {
        System.out.println("CHA");
    }
    int n = 5;
}

public class Entry {
	public static void main(String[] args) {
        Person s = new Student("Khanh", 23, "Ha Noi", 9.0);
        System.out.println(s.n);
        
        // s.Printage();
        // s.Printaddress();
        // s.Printgpa();
        // System.out.println();
        // Teacher t = new Teacher("Tung", 34, "Ha Noi", 1700);
        // t.Printname();
        // t.Printage();
        // t.Printaddress();
        // t.Printsalary();
	}
}
