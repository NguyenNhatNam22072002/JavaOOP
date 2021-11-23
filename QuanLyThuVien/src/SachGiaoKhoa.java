public class SachGiaoKhoa extends Sach {
    private int lop;
    public SachGiaoKhoa(){
        super();
    }
    public SachGiaoKhoa(String lop){
        super();
        this.lop = lop;
    }
    public int setLop(int lop){
        this.lop = lop;
    }
    public int getLop(){
        return lop;
    }
    public void nhapSach() {
        super.nhapSach();
        System.out.print("Nhap lop cua sach: ");
        lop = scanner.nextInt();
    }
    @Override
    public String toString() {
        return "Ma sach: " + this.maSach + ", ten nha xuat ban: " + this.nhaXuatBan + ", gia: " + 
        this.donGia + ", so luong: " + this.soLuong + ", phan loai lop: " + this.lop;
    }
}
