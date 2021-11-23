public class SachKhac extends Sach {
    private String theloai;
    public SachKhac(){
        super();
    }
    public SachKhac(String theloai){
        super();
        this.theloai = theloai;
    }
    public String setTheloai(String theloai){
        this.theloai = theloai;
    }
    public getTheloai(){
        return this.theloai;
    }
    @Override
    public String toString(){
        return "Ma sach: " + this.maSach + ", ten nha xuat ban: " + this.nhaXuatBan  + ", the loai: " + 
        this.theloai + ", gia: " + this.donGia + ", so luong: " + this.soLuong;
    }
}
