import java.util.ArrayList;
import java.util.Scanner;

public class TheThuVien {
    private NguoiMuon _nm;
    private String _Mathe;
    private String _ngaymuon;
    private String _ngaytra;
    Scanner sc = new Scanner(System.in);
    
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
        System.out.print("Nhap ma the: ");
        this._Mathe = sc.nextLine();
        System.out.print("Nhap so sach muon: ");
        this._nm._Sosach = sc.nextInt();
        System.out.println("Loai sach ban muon muon (SGK: chon 1/ Sach Tham khao: chon 2/ Sach khac: chon 3): ");
        for (int i = 0; i < this._nm.getSosach(); i++) {
            int number;
            number = sc.nextInt();
            Sach sach;
            String tensach;
            switch (number) {
                case 1:
                    tensach = sc.nextLine();
                    sach = new SachGiaoKhoa();
                    sach.MuonSach();
                    break;
                case 2:
                    tensach = sc.nextLine();
                    sach = new SachThamKhao();
                    sach.MuonSach();
                    break;
                default:
                    tensach = sc.nextLine();
                    sach= new SachKhac();
                    sach.MuonSach();
                    break;
            }
            this._nm._thuvien.add(sach);
        }
        System.out.print("Nhap ngay muon: ");
        this._ngaymuon = sc.nextLine();
        System.out.print("Nhap ngay tra: ");
        this._ngaytra = sc.nextLine();
    }
    public void XuatInfo()
    {
        this._nm.XuatInfo();
        System.out.println("-Ma the: " + this._Mathe);
        System.out.print("-Ngay tra: " + this._ngaytra);
        System.out.println("-So sach muon: " + this._nm.getSosach());
        ArrayList<Sach> Cacsach = this._nm._thuvien; 
        for(int i = 0; i < this._nm.getSosach(); i++)
        {
            System.out.print("Ten sach thu " + i + " la:" + Cacsach.get(i));
            System.out.println();
        }
    }
}
