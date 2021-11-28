import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheThuVien {
    public NguoiMuon _nm = new NguoiMuon();
    private String _Mathe;
    public ArrayList<Date> _ngaymuon = new ArrayList<Date>();
    public ArrayList<String> _ngaytra = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);
    public ArrayList<Sach> _thuvien = new ArrayList<Sach>();
    public int sosachdamuon = 0;
    
    public TheThuVien() 
    {
        
    }
    public TheThuVien(NguoiMuon nm, String mathe)
    {
        this._nm = nm;
        this._Mathe = mathe;
    }
    public String getMaThe(){
        return this._Mathe;
    }
    public void setMaThe(String mathe){
        this._Mathe = mathe;
    }
    public void Dangky(){
        this._nm.NhapInfo();
        System.out.print("Nhap ma the muon dang ky: ");
        this._Mathe = sc.nextLine();
    }
    public void NhapInfo()
    {
        System.out.print("Nhap so loai sach muon: ");
        this._nm._Sosach = sc.nextInt();
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
                    sach= new SachKhac();
                    sach.MuonSach();
                    break;
            }
            this._thuvien.add(sach);
        }
        sosachdamuon += this._nm.getSosach();
        long maToday = System.currentTimeMillis();   
        Date today = new Date(maToday);   
        this._ngaymuon.add(today);
    }
    public List<String> XuatInfo()
    {
    //     this._nm.XuatInfo();
    //     System.out.println("-Ma the: " + this._Mathe);
    //     System.out.println("-Ngay muon: " + this._ngaymuon);
    //     System.out.println("-Ngay tra: " + this._ngaytra);
    //     System.out.println("-So sach muon: " + this._nm.getSosach());
    //     ArrayList<Sach> Cacsach = this._nm._thuvien; 
    //     for(int i = 0; i < this._nm.getSosach(); i++)
    //     {
    //         System.out.print("+Ma sach thu " + (i+1) + " la:" + Cacsach.get(i).getMaSach());
    //         System.out.println();
    //     }
        return Arrays.asList(this._nm.getHoten(), this._nm.getSdt(), this._nm.getDiachi(), this._Mathe);
    }
}
