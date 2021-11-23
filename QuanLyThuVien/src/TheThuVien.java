import java.util.Scanner;

public class TheThuVien {
    private NguoiMuon _nm;
    private String _Mathe;
    private String _ngaymuon;
    private String _ngaytra;
    public TheThuVien() 
    {
        
    }
    public TheThuVien(NguoiMuon nm, String mathe, String ngaymuon, String ngaytra)
    {
        this._nm = nm;
        this._Mathe = mathe;
        this._ngaymuon = ngaymuon;
        this._ngaytra = ngaytra;
    }
    public String getNgaymuon()
    {
        return this._ngaymuon;
    }
    public String getNgaytra()
    {
        return this._ngaytra;
    }
    public void setNgaytra(String ngaytra)
    {
        this._ngaytra = ngaytra;
    }
    public void NhapInfo()
    {
        this._nm = new NguoiMuon();
        this._nm.NhapInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma the: ");
        this._Mathe = sc.nextLine();
        System.out.print("Nhap ngay muon: ");
        this._ngaymuon = sc.nextLine();
        System.out.print("Nhap ngay tra: ");
        this._ngaytra = sc.nextLine();
    }
    public void XuatInfo()
    {
        this._mn.XuatInfo();
        System.out.println("Ma the: " + this._Mathe);
        System.out.print("Ngay tra: " + this._ngaytra);
        //System.out.print("Ten sach tra: " + );
    }
}
