public class SachThamKhao extends Sach {
    private String loai;
    public SachThamKhao() {
        super();
    }
    public SachThamKhao(String loai) {
        super();
        this.loai = loai;
    }
    public void setLoai(String loai) {
        this.loai = loai;
    }
    public String getLoai() {
        return this.loai;
    }
    public void NhapSach(){
        super.NhapSach();
        System.out.print("Nhap loai cua sach: ");
        loai = scanner.nextLine();
    }
    @Override
    public String InSach() {
        return "Ma sach: " + this.maSach + ", ten nha xuat ban: " + ", phan loai sach: " + this.loai 
        + this.tenNXB + ", gia: " + this.gia + ", so luong: " + this.soluong;
    }
}
