public class SachGiaoKhoa extends Sach {
    private int lop;
    public SachGiaoKhoa(){
        super();
    }
    public SachGiaoKhoa(String maSach, String tenSach,String nhaXuatBan, int soLuong ,int lop){
        super(maSach, tenSach, nhaXuatBan, soLuong);
        this.lop = lop;
    }
    public void setLop(int lop){
        this.lop = lop;
    }
    public int getLop(){
        return lop;
    }
    public void nhapSach() {
        super.NhapSach();
        System.out.print("Nhap lop cua sach: ");
        lop = scanner.nextInt();
    }
    @Override
    public void InSach() {
        // String header = String.format("%12s%12s%12s%12s", "Ma sach", "Ten NXB", "Phan loai lop", "So luong");
        // String row = String.format("%12s%12s%12d%12d", this.maSach, this.tenNXB,"Lop " + this.lop, this.soluong);
        // System.out.println(header);
        // System.out.println(row);
        System.out.println("Ma sach: " + this.maSach);
        System.out.println("Ten sach: " + this.tenSach);
        System.out.println("Nha xuat ban: " + this.tenNXB);
        System.out.println("So luong: " + this.soluong);
        System.out.println("Phan loai lop: "+this.lop);
}
}