import java.util.ArrayList;
import java.util.Scanner;

public class NguoiMuon extends Person {
    public int _Sosach;
    public ArrayList<Sach> _thuvien = new ArrayList<Sach>();
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