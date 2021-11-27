import java.util.Arrays;
import java.util.List;

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
    public List<String> InSach() {
        return Arrays.asList(this.maSach, this.tenSach, this.tenNXB, this.loai, String.valueOf(this.soluong));
}
}