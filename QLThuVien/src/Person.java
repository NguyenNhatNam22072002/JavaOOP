import java.util.List;

public abstract class Person {
    protected String Hoten;
    protected String Sdt;
    protected String Diachi;

    public Person() {

    }

    public Person(String hoten, String sdt, String diachi) {
        this.Hoten = hoten;
        this.Sdt = sdt;
        this.Diachi = diachi;
    }

    public Person(Person p) {
        this.Hoten = p.Hoten;
        this.Sdt = p.Sdt;
        this.Diachi = p.Diachi;
    }

    public String getHoten() {
        return this.Hoten;
    }

    public void setHoten(String hoten) {
        this.Hoten = hoten;
    }

    public String getSdt() {
        return this.Sdt;
    }

    public void setSdt(String sdt) {
        this.Sdt = sdt;
    }

    public String getDiachi() {
        return this.Diachi;
    }

    public void setDiachi(String diachi) {
        this.Diachi = diachi;
    }

    public abstract void NhapInfo();

    public abstract List<String> XuatInfo();
}
