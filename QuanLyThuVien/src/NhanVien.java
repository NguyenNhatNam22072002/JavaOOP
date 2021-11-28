import java.util.Arrays;
import java.util.List;
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
    public List<String> XuatInfo()
    {
        return Arrays.asList(this.Hoten, this.Sdt, this.Diachi);
    }
}