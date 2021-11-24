public class SachGiaoKhoa extends Sach {
    private int lop;
    public SachGiaoKhoa(){
        super();
    }
    public SachGiaoKhoa(int lop){
        super();
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
    public String InSach() {
        return "Ma sach: " + this.maSach + ", ten nha xuat ban: " + this.tenNXB + ", gia: " + 
        this.gia + ", so luong: " + this.soluong + ", phan loai lop: " + this.lop;
    }
}
