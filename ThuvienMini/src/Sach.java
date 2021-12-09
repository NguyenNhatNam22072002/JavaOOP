
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public abstract class Sach {
    protected String maSach;
    protected String tenSach;
    protected String tenNXB;
    protected int soluong;
    Scanner scanner = new Scanner(System.in);

    public Sach() {
        super();
    }

    public Sach(String maSach, String tenSach, String nhaXuatBan, int soLuong) {
        super();
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenNXB = nhaXuatBan;
        this.soluong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNhaXuatBan() {
        return tenNXB;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.tenNXB = nhaXuatBan;
    }

    public int getSoLuong() {
        return soluong;
    }

    public void setSoLuong(int soLuong) {
        this.soluong = soLuong;
    }

    public void NhapSach() {
        System.out.print("Nhap ma sach: ");
        maSach = scanner.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = scanner.nextLine();
        System.out.print("Nhap ten nha xuat ban: ");
        tenNXB = scanner.nextLine();
        System.out.print("Nhap so luong: ");
        soluong = scanner.nextInt();
    }

    public void MuonSach() {
        System.out.print("Nhap ma sach: ");
        maSach = scanner.nextLine();
    }

    public abstract List<String> InSach();
    public static void NhapThemSach(ArrayList<SachGiaoKhoa> listsachgiaokhoa, ArrayList<SachThamKhao> listsachthamkhao, ArrayList<SachKhac> listsachkhac)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t    -------Nhap them sach-------");
                    int nhap;
                    do {
                        System.out.print(
                                "Loai sach muon them (SGK: chon 1/ Sach Tham khao: chon 2/ Sach khac: chon 3): ");
                        int number; 
                        number = sc.nextInt();
                        switch (number) {
                            case 1:
                                SachGiaoKhoa sachgk = new SachGiaoKhoa();
                                sachgk.NhapSach();
                                Boolean check1 = false;
                                for (int i = 0; i < listsachgiaokhoa.size(); i++)
                                    if (sachgk.getMaSach().equals(listsachgiaokhoa.get(i).getMaSach())) {
                                        listsachgiaokhoa.get(i)
                                                .setSoLuong(listsachgiaokhoa.get(i).getSoLuong() + sachgk.getSoLuong());
                                        check1 = true;
                                        break;
                                    }
                                if (check1 == false)
                                    listsachgiaokhoa.add(sachgk);
                                break;
                            case 2:
                                SachThamKhao sachtk = new SachThamKhao();
                                sachtk.NhapSach();
                                Boolean check2 = false;
                                for (int i = 0; i < listsachthamkhao.size(); i++)
                                    if (sachtk.getMaSach().equals(listsachthamkhao.get(i).getMaSach())) {
                                        listsachthamkhao.get(i)
                                                .setSoLuong(listsachthamkhao.get(i).getSoLuong() + sachtk.getSoLuong());
                                        check2 = true;
                                        break;
                                    }
                                if (check2 == false)
                                    listsachthamkhao.add(sachtk);
                                break;
                            default:
                                SachKhac sachkhac = new SachKhac();
                                sachkhac.NhapSach();
                                Boolean check3 = false;
                                for (int i = 0; i < listsachkhac.size(); i++)
                                    if (sachkhac.getMaSach().equals(listsachkhac.get(i).getMaSach())) {
                                        listsachkhac.get(i)
                                                .setSoLuong(listsachkhac.get(i).getSoLuong() + sachkhac.getSoLuong());
                                        check3 = true;
                                        break;
                                    }
                                if (check3 == false)
                                    listsachkhac.add(sachkhac);
                                break;
                        }
                        System.out.print("Ban co muon nhap sach nua khong (1-Yes/2-No):");
                        nhap = sc.nextInt();
                    } while (nhap == 1);
    }
}
