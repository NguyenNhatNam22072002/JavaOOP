public class SachKhac extends Sach {
    private String theloai;
    public SachKhac(){
        super();
    }
    public SachKhac(String theloai){
        super();
        this.theloai = theloai;
    }
    public void setTheloai(String theloai){
        this.theloai = theloai;
    }
    public String getTheloai(){
        return this.theloai;
    }
    public void NhapSach(){
        super.NhapSach();
        System.out.print("Nhap the loai cua sach: ");
        theloai = scanner.nextLine();
    }
    @Override
    public void InSach(){
        String header = String.format("%-12s%-12s%s-12s%s", "Ma sach", "Ten NXB", "The loai", "So luong");
        String row = String.format("%-12s%-12s-12s%s", this.maSach, this.tenNXB, this.theloai, this.soluong);
        System.out.println(header);
        System.out.println(row);
    }
}
