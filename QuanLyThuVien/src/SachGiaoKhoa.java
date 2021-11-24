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
    public void InSach() {
        String header = String.format("%-12s%-12s%s-12s%s", "Ma sach", "Ten NXB", "Phan loai lop", "So luong");
        String row = String.format("%-12s%-12s-12s%s", this.maSach, this.tenNXB,"Lop " + this.lop, this.soluong);
        System.out.println(header);
        System.out.println(row);
}
}