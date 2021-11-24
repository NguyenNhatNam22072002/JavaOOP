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
    public String InSach(){
        return "Ma sach: " + this.maSach + ", ten nha xuat ban: " + this.tenNXB  + ", the loai: " + 
        this.theloai + ", gia: " + this.gia + ", so luong: " + this.soluong;
    }
}
