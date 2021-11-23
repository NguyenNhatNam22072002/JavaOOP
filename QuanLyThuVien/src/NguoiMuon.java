import java.util.Scanner;

public class NguoiMuon extends Person {
    private int _Sosach;

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
    @Override
    public void NhapInfo()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten nguoi muon: ");
        this.Hoten = sc.nextLine();
        System.out.print("Nhap sdt: ");
        this.Sdt = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        this.Diachi = sc.nextLine();
        System.out.print("Nhap so sach muon: ");
        this._Sosach = sc.nextInt();
        // Sach[] sach = new Sach[this._Sosach];
        // for (Sach s : sach) {
        //     s[i].NhapInfo();
        // }
    }
    @Override
    public void XuatInfo()
    {
        System.out.println("Ho va ten nguoi muon: " + this.Hoten);
        System.out.println("Sdt: " + this.Sdt);
        System.out.println("Dia chi: " + this.Diachi);
        System.out.println("So sach muon: " + this._Sosach);
    }
}