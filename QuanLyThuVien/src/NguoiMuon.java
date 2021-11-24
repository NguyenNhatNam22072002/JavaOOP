import java.util.ArrayList;
import java.util.Scanner;

public class NguoiMuon extends Person {
    private int _Sosach;
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
    @Override
    public void NhapInfo()
    {
        System.out.print("Nhap ho ten nguoi muon: ");
        this.Hoten = sc.nextLine();
        System.out.print("Nhap sdt: ");
        this.Sdt = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        this.Diachi = sc.nextLine();
        System.out.print("Nhap so sach muon: ");
        this._Sosach = sc.nextInt();
        ArrayList<ThuVien> thuvien = new ArrayList<ThuVien>();
        for (ThuVien t : thuvien) {
            int number = 0;
            System.out.print("Loai sach ban muon muon(SGK: 1/ Sach Tham khao: 2/ Sach khac: 3): ");
            number = sc.nextInt();
            Sach sach;
            switch (number) {
                case 1:
                    sach = new SachGiaoKhoa();
                    sach.MuonSach();
                    break;
                case 2:
                    sach = new SachThamKhao();
                    sach.MuonSach();
                    break;
                default:
                    sach= new SachKhac();
                    sach.MuonSach();
                    break;
            }
            t.them(sach);
        }
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