import java.util.Arrays;
import java.util.List;

public class SachThamKhao extends Sach {
    private String loai;
    public SachThamKhao() {
        super();
    }
    public SachThamKhao(String maSach, String tenSach,String nhaXuatBan, int soLuong, String loai) {
        super(maSach,tenSach,nhaXuatBan,soLuong);
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
        scanner.nextLine();
        loai = scanner.nextLine();
    }
    @Override
    public List<String> InSach() {
        return Arrays.asList(this.maSach, this.tenSach, this.tenNXB, this.loai, String.valueOf(this.soluong));
}
}