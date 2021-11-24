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
    public void InSach() {
        String header = String.format("%-12s%-12s%s-12s%s", "Ma sach", "Ten NXB", "Phan loai", "So luong");
        String row = String.format("%-12s%-12s-12s%s", this.maSach, this.tenNXB, this.loai, this.soluong);
        System.out.println(header);
        System.out.println(row);
    }
}
