import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheThuVien {
    private NguoiMuon _nm = new NguoiMuon();
    private String _Mathe;
    private ArrayList<Date> _ngaymuon = new ArrayList<Date>();
    private ArrayList<String> _ngaytra = new ArrayList<String>();
    private ArrayList<Sach> _thuvien = new ArrayList<Sach>();
    private int _sosachdamuon = 0;

    Scanner sc = new Scanner(System.in);

    public TheThuVien() {

    }

    public TheThuVien(NguoiMuon nm, String mathe) {
        this._nm = nm;
        this._Mathe = mathe;
    }

    public String getMaThe() {
        return this._Mathe;
    }

    public void setMaThe(String mathe) {
        this._Mathe = mathe;
    }

    public NguoiMuon getNM() {
        return this._nm;
    }

    public void setNM(NguoiMuon nm) {
        this._nm = nm;
    }

    public ArrayList<Date> getngaymuon() {
        return this._ngaymuon;
    }

    public void setNM(ArrayList<Date> ngaymuon) {
        this._ngaymuon = ngaymuon;
    }

    public ArrayList<String> getngaytra() {
        return this._ngaytra;
    }

    public void setngaytra(ArrayList<String> ngaytra) {
        this._ngaytra = ngaytra;
    }

    public int getsosachdamuon() {
        return this._sosachdamuon;
    }

    public void setsosachdamuon(int sosachdamuon) {
        this._sosachdamuon = sosachdamuon;
    }
    
    public void Dangky() {
        this._nm.NhapInfo();
        System.out.print("Nhap ma the muon dang ky: ");
        this._Mathe = sc.nextLine();
    }

    public ArrayList<Sach> getthuvien() {
        return this._thuvien;
    }

    public void setthuvien(ArrayList<Sach> thuvien) {
        this._thuvien = thuvien;
    }

    public void NhapInfo() {
        System.out.print("Nhap so loai sach muon: ");
        int Sosach;
        Sosach = sc.nextInt();
        this._nm.setSosach(Sosach);
        for (int i = 0; i < this._nm.getSosach(); i++) {
            int number;
            System.out.print("Loai sach ban muon muon (SGK: chon 1/ Sach Tham khao: chon 2/ Sach khac: chon 3): ");
            number = sc.nextInt();
            Sach sach;
            switch (number) {
                case 1:
                    sc.nextLine();
                    sach = new SachGiaoKhoa();
                    sach.MuonSach();
                    break;
                case 2:
                    sc.nextLine();
                    sach = new SachThamKhao();
                    sach.MuonSach();
                    break;
                default:
                    sc.nextLine();
                    sach = new SachKhac();
                    sach.MuonSach();
                    break;
            }
            this._thuvien.add(sach);
            long maToday = System.currentTimeMillis();
            Date today = new Date(maToday);
            this._ngaymuon.add(today);
        }
        this._sosachdamuon += this._nm.getSosach();
    }

    public List<String> XuatInfo() {
        return Arrays.asList(this._nm.getHoten(), this._nm.getSdt(), this._nm.getDiachi(), this._Mathe);
    }
}
