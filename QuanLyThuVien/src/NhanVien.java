import java.util.Scanner;

public class NhanVien extends Person {
    Scanner sc = new Scanner(System.in);
    public NhanVien() 
    {
        super();
    }
    public NhanVien(String hoten, String sdt, String diachi)
    {
        super(hoten, sdt, diachi);
    }
    public NhanVien(NhanVien n)
    {
        super(n);
    }
    @Override
    public void NhapInfo()
    {
        System.out.print("Nhap ho ten nhan vien: ");
        this.Hoten = sc.nextLine();
        System.out.print("Nhap sdt: ");
        this.Sdt = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        this.Diachi = sc.nextLine();
    }
    @Override
    public void XuatInfo()
    {
        System.out.println("Ho va ten nhan vien: " + this.Hoten);
        System.out.println("Sdt: " + this.Sdt);
        System.out.println("Dia chi: " + this.Diachi);
    }
}