public abstract class Sach {
    private String maSach, tenNXB;
    private double gia;
    private int soluong;
    Scanner scanner = new Scanner(System.in);

    public Sach(){
        super();
    }
    public Sach(String maSach, String nhaXuatBan, double donGia, int soLuong) {
        super();
        this.maSach = maSach;
        this.tenNXB = nhaXuatBan;
        this.gia = donGia;
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
 
    public double getDonGia() {
        return gia;
    }
 
    public void setDonGia(double donGia) {
        this.gia = donGia;
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
        System.out.print("Nhap don gia: ");
        gia = scanner.nextDouble();
        System.out.print("Nhap so luong: ");
        soluong = scanner.nextInt();
    }
    public abstract String toString();
}
