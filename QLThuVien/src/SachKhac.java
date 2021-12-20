import java.util.Arrays;
import java.util.List;

public class SachKhac extends Sach {
    private String theloai;

    public SachKhac() {
        super();
    }

    public SachKhac(String maSach, String tenSach, String nhaXuatBan, int soLuong, String theloai) {
        super(maSach, tenSach, nhaXuatBan, soLuong);
        this.theloai = theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getTheloai() {
        return this.theloai;
    }

    public void NhapSach() {
        super.NhapSach();
        System.out.print("Nhap the loai cua sach: ");
        scanner.nextLine();
        theloai = scanner.nextLine();
    }

    @Override
    public List<String> InSach() {
        return Arrays.asList(this.maSach, this.tenSach, this.tenNXB, this.theloai, String.valueOf(this.soluong));
    }
}