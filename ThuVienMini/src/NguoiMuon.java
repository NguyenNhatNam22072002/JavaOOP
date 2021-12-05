
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NguoiMuon extends Person {
    public int _Sosach;
    Scanner sc = new Scanner(System.in);

    public NguoiMuon() {
        super();
    }

    public NguoiMuon(String hoten, String sdt, String diachi) {
        super(hoten, sdt, diachi);
    }

    public NguoiMuon(NguoiMuon n) {
        super(n);
    }

    public int getSosach() {
        return this._Sosach;
    }

    @Override
    public void NhapInfo() {
        System.out.print("Nhap ho ten nguoi muon: ");
        this.Hoten = sc.nextLine();
        System.out.print("Nhap sdt: ");
        this.Sdt = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        this.Diachi = sc.nextLine();
    }

    @Override
    public List<String> XuatInfo() {
        return Arrays.asList(this.Hoten, this.Sdt, this.Diachi);
    }
}