import java.util.Scanner;

public abstract class Sach {
    protected String maSach;
    protected String tenNXB;
    protected int soluong;
    Scanner scanner = new Scanner(System.in);

    public Sach(){
        super();
    }
    public Sach(String maSach, String nhaXuatBan, int soLuong) {
        super();
        this.maSach = maSach;
        this.tenNXB = nhaXuatBan;
        this.soluong = soLuong;
    }
    public String getMaSach() {
        return maSach;
    }
 
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
 
    public String getNhaXuatBan() {
        return tenNXB;
    }
 
    public void setNhaXuatBan(String nhaXuatBan) {
        this.tenNXB = nhaXuatBan;
    }
 
    public int getSoLuong() {
        return soluong;
    }
 
    public void setSoLuong(int soLuong) {
        this.soluong = soLuong;
    }
    public void NhapSach(){
        System.out.print("Nhap ma sach: ");
        maSach = scanner.nextLine();
        System.out.print("Nhap ten nha xuat ban: ");
        tenNXB = scanner.nextLine();
        System.out.print("Nhap so luong: ");
        soluong = scanner.nextInt();
    }
    public void MuonSach(){
        System.out.print("Nhap ma sach: ");
        maSach = scanner.nextLine();
        System.out.print("Nhap so luong muon: ");
        soluong = scanner.nextInt();
    }
    public abstract void InSach();
}
