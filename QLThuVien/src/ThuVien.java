/**
* @author ZLoganZ :>
* @author NguyenNhatNam22072002
* @author taynguyen0206
*/
import java.util.ArrayList;
import java.util.Scanner;

public class ThuVien {
    public static void main(String[] args) {

        NhanVien Nam = new NhanVien("Nhat Nam", "0355181736", "Binh Dinh");
        NhanVien Hai = new NhanVien(" Hoang Hai", "0985927403", "Dong Nai");
        NhanVien Nguyen = new NhanVien("Tay Nguyen", "0944398092", "Gia Lai");

        ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
        listNV.add(Nam);
        listNV.add(Hai);
        listNV.add(Nguyen);

        SachGiaoKhoa sachToan = new SachGiaoKhoa("sgktoan1", "ToanCaoCap", "Kim Dong", 1, 13);
        SachKhac Conan = new SachKhac("conan1", "Conan", "Kim Dong", 1, "Tieu thuyet");
        SachThamKhao thamkhao = new SachThamKhao("tkvan1", "Sach Giai Van 12", "Kim Dong", 2, "Van");

        ArrayList<SachGiaoKhoa> listsachgiaokhoa = new ArrayList<SachGiaoKhoa>();
        ArrayList<SachThamKhao> listsachthamkhao = new ArrayList<SachThamKhao>();
        ArrayList<SachKhac> listsachkhac = new ArrayList<SachKhac>();

        listsachkhac.add(Conan);
        listsachgiaokhoa.add(sachToan);
        listsachthamkhao.add(thamkhao);

        ArrayList<Sach> thuvien = new ArrayList<Sach>();
        thuvien.add(Conan);
        thuvien.add(sachToan);
        thuvien.add(thamkhao);

        Scanner sc = new Scanner(System.in);

        ArrayList<TheThuVien> ds = new ArrayList<TheThuVien>();

        String chon;
        do {
            System.out.print("\033[H\033[2J\n");
            System.out.flush();
            System.out.print(
                    "1. Nhan Vien.\n2. Thong tin sach trong thu vien.\n3. Nhap sach.\n4. Dang ky hoi vien\n5. Muon sach.\n(Vui long ky xem thong tin sach truoc khi muon)\n");
            System.out.print("6. Danh sach nguoi muon.\n7. Danh nguoi muon qua thoi han\n8. Exit.\n");
            System.out.print("Ban chon: ");
            chon = sc.next();
            switch (chon) {
                case "1":
                    int chon2;
                    System.out.print("\t1. In nhan vien.\n\t2. Them nhan vien\n"); // 2 chức năng của nhân viên
                    System.out.print("\tBan chon: ");
                    chon2 = sc.nextInt();
                    switch (chon2) {
                        case 1:
                            NhanVien.InNhanVien(listNV);
                        break;
                        case 2:
                            NhanVien.ThemNhanVien(listNV);
                        break;
                    }
                    break;
                case "2":
                    SachGiaoKhoa.ThongtinSach(listsachgiaokhoa);
                    SachThamKhao.ThongtinSach(listsachthamkhao);
                    SachKhac.ThongtinSach(listsachkhac);
                    System.out.print("Nhan Enter de tiep tuc!");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case "3":
                    Sach.NhapThemSach(thuvien, listsachgiaokhoa, listsachthamkhao, listsachkhac);
                    break;
                case "4":
                    TheThuVien.DangKyThe(ds);
                    break;
                case "5":
                    TheThuVien.MuonSach(ds, listsachgiaokhoa, listsachthamkhao, listsachkhac);
                    break;
                case "6":
                    TheThuVien.ThongTinNguoiMuon(ds, thuvien);
                    break;
                case "7":
                    TheThuVien.ThongTinNguoiMuonQuaHan(ds, thuvien);
                    break;
                case "8":
                    System.out.println("\t\tTam biet!!!!!");
                    wait(1000);
                    break;
                default:
                    break;
            }
        } while (chon != "8");
        sc.close();
    }

    
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
//meow meow