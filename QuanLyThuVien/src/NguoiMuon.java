import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class NguoiMuon extends Person {
    private int _Sosach;
    private ArrayList<ThuVien> _thuvien;
    Scanner sc = new Scanner(System.in);

    public NguoiMuon() 
    {
        super();
    }
    public NguoiMuon(String hoten, String sdt, String diachi)
    {
        super(hoten, sdt, diachi);
    }
    public NguoiMuon(NguoiMuon n)
    {
        super(n);
    }
    public int getSosach()
    {
        return this._Sosach;
    }
    public ArrayList<ThuVien> thuvien()
    {
        return this._thuvien;
    }

    @Override
    public void NhapInfo()
    {
        System.out.print("Nhap ho ten nguoi muon: ");
        this.Hoten = sc.nextLine();
        System.out.print("Nhap sdt: ");
        this.Sdt = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        this.Diachi = sc.nextLine();
    }
    
    @Override
    public void XuatInfo()
    {
        System.out.println("-Ho va ten: " + this.Hoten);
        System.out.println("-Sdt: " + this.Sdt);
        System.out.println("-Dia chi: " + this.Diachi);
    }
}