interface PrintName{
    void Printname();
}
interface PrintAge{
    void Printage();
}
class Person implements PrintName, PrintAge{
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
        this.age = age;
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
}

public class Entry {
	public static void main(String[] args) {
		Student s = new Student("Khanh", 23, "Ha Noi", 9.0);
		s.Printname();
        s.Printage();
		System.out.println();
		Teacher t = new Teacher("Tung", 34, "Ha Noi", 1700);
		t.Printname();
        t.Printage();
	}
}