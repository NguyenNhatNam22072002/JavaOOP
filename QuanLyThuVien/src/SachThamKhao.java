public class SachThamKhao extends Sach {
    private String loai;
    public SachThamKhao() {
        super();
    }
    public SachThamKhao(String loai) {
        super();
        this.loai = loai;
    }
    public setLoai(String loai) {
        this.loai = loai;
    }
    public getLoai() {
        return this.loai;
    }
    public void NhapSach(){
        super.NhapSach();
        System.out.print("Nhap loai cua sach: ");
        loai = scanner.nextLine();
    }
    @Override
    public String toString() {
        return "Ma sach: " + this.maSach + ", ten nha xuat ban: " + ", phan loai sach: " + this.loai 
        + this.nhaXuatBan + ", gia: " + this.donGia + ", so luong: " + this.soLuong;
    }
}
