
/**
* @author ZLoganZ :>
* @author NguyenNhatNam22072002
* @author taynguyen0206
*/
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ThuVien {
    public static void main(String[] args) {

        NhanVien Nam = new NhanVien("Nhat Nam", "0355181736", "Binh Dinh");
        NhanVien Hai = new NhanVien(" Hoang Hai", "0987654", "Dong Nai");
        NhanVien Nguyen = new NhanVien("Tay Nguyen", "0135790", "Gia Lai");

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

        int chon = 0;
        do {
            System.out.print("\033[H\033[2J\n");
            System.out.flush();
            System.out.print(
                    "1. Nhan Vien.\n2. Thong tin sach trong thu vien.\n3. Nhap sach.\n4. Dang ky hoi vien\n5. Muon sach.\n(Vui long ky xem thong tin sach truoc khi muon)\n");
            System.out.print("6. Danh sach nguoi muon.\n7. Danh nguoi muon qua thoi han\n8. Exit.\n");
            System.out.print("Ban chon: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    int chon2;
                    System.out.print("\t1. In nhan vien.\n\t2. Them nhan vien\n"); // 2 chức năng của nhân viên
                    System.out.print("\tBan chon: ");
                    chon2 = sc.nextInt();
                    switch (chon2) {
                        case 1:
                            System.out.println("\t\t    -------Thong tin nhan vien--------");
                            List<String> headersList = Arrays.asList("Ho ten", "So dien thoai", "Dia chi");
                            List<List<String>> rowsList = new ArrayList<List<String>>();
                            for (int i = 0; i < listNV.size(); i++) {
                                rowsList.add(listNV.get(i).XuatInfo());
                            }
                            Board board = new Board(75);
                            Table table = new Table(board, 75, headersList, rowsList);
                            List<Integer> colAlignList = Arrays.asList(
                                    Block.DATA_CENTER,
                                    Block.DATA_CENTER,
                                    Block.DATA_CENTER);
                            List<Integer> colWidthsListEdited = Arrays.asList(20, 15, 34);
                            table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited)
                                    .setGridMode(Table.GRID_FULL);
                            Block block = table.tableToBlocks();
                            board.setInitialBlock(block);
                            board.build();
                            String tableString = board.getPreview();
                            System.out.println(tableString);
                            System.out.print("Nhan Enter de tiep tuc!");
                            sc.nextLine();
                            sc.nextLine();
                            break;
                        case 2:
                            System.out.print("\t\tSo nhan vien can them: ");
                            int nv = sc.nextInt();
                            for (int i = 0; i < nv; i++) {
                                System.out.println("\t\t    ----Nhap thong tin nhan vien thu " + (i + 1) + "-----");
                                NhanVien newNV = new NhanVien();
                                newNV.NhapInfo();
                                listNV.add(newNV);
                            }
                            System.out.print("Nhan Enter de tiep tuc!");
                            sc.nextLine();
                            sc.nextLine();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\t\t    ---------Thong tin SGK-----------");
                    if (listsachgiaokhoa.size() == 0) {
                        System.out.println("\n\t\t\t    Khong co sach!\n");
                    } else {
                        List<String> headersList = Arrays.asList("Ma sach", "Ten sach", "Nha xuat ban", "Phan lop",
                                "So luong");
                        List<List<String>> rowsList = new ArrayList<List<String>>();
                        for (int i = 0; i < listsachgiaokhoa.size(); i++) {
                            rowsList.add(listsachgiaokhoa.get(i).InSach());
                        }
                        Board board = new Board(75);
                        Table table = new Table(board, 75, headersList, rowsList);
                        List<Integer> colAlignList = Arrays.asList(
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER);
                        List<Integer> colWidthsListEdited = Arrays.asList(10, 24, 13, 12, 10);
                        table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited)
                                .setGridMode(Table.GRID_FULL);
                        Block tableBlock = table.tableToBlocks();
                        board.setInitialBlock(tableBlock);
                        board.build();
                        String tableString = board.getPreview();
                        System.out.println(tableString);
                    }
                    System.out.println("\t\t    ----Thong tin sach tham khao-----");
                    if (listsachthamkhao.size() == 0) {
                        System.out.println("\n\t\t\t    Khong co sach!\n");
                    } else {
                        List<String> headersList = Arrays.asList("Ma sach", "Ten sach", "Nha xuat ban", "Phan loai",
                                "So luong");
                        List<List<String>> rowsList = new ArrayList<List<String>>();
                        for (int i = 0; i < listsachthamkhao.size(); i++) {
                            rowsList.add(listsachthamkhao.get(i).InSach());
                        }
                        Board board = new Board(75);
                        Table table = new Table(board, 75, headersList, rowsList);
                        List<Integer> colAlignList = Arrays.asList(
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER);
                        List<Integer> colWidthsListEdited = Arrays.asList(10, 24, 13, 12, 10);
                        table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited)
                                .setGridMode(Table.GRID_FULL);
                        Block tableBlock = table.tableToBlocks();
                        board.setInitialBlock(tableBlock);
                        board.build();
                        String tableString = board.getPreview();
                        System.out.println(tableString);
                    }
                    System.out.println("\t\t    -------Thong tin sach khac--------");
                    if (listsachkhac.size() == 0) {
                        System.out.println("\n\t\t\t    Khong co sach!\n");
                    } else {
                        List<String> headersList = Arrays.asList("Ma sach", "Ten sach", "Nha xuat ban", "The loai",
                                "So luong");
                        List<List<String>> rowsList = new ArrayList<List<String>>();
                        for (int i = 0; i < listsachkhac.size(); i++) {
                            rowsList.add(listsachkhac.get(i).InSach());
                        }
                        Board board = new Board(75);
                        Table table = new Table(board, 75, headersList, rowsList);
                        List<Integer> colAlignList = Arrays.asList(
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER);
                        List<Integer> colWidthsListEdited = Arrays.asList(10, 24, 13, 12, 10);
                        table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited)
                                .setGridMode(Table.GRID_FULL);
                        Block tableBlock = table.tableToBlocks();
                        board.setInitialBlock(tableBlock);
                        board.build();
                        String tableString = board.getPreview();
                        System.out.println(tableString);
                    }
                    System.out.print("Nhan Enter de tiep tuc!");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("\t\t    -------Nhap them sach-------");
                    int nhap;
                    do {
                        System.out.print(
                                "Loai sach muon them (SGK: chon 1/ Sach Tham khao: chon 2/ Sach khac: chon 3): ");
                        int number = sc.nextInt();
                        switch (number) {
                            case 1:
                                sc.nextLine();
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
                                sc.nextLine();
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
                                sc.nextLine();
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
                    break;
                case 4:
                    System.out.println("\t\t    -------Dang ky the thu vien--------");
                    TheThuVien the = new TheThuVien();
                    the.Dangky();
                    Boolean check4;
                    do
                    {
                        check4 = true;
                        for(int i = 0; i < ds.size(); i++)
                        {
                            if(the.getMaThe().equals(ds.get(i).getMaThe()))
                            {
                                check4 = false;
                                System.out.println("Ma the da co nguoi dang ky! Vui long nhap ma khac!");
                                System.out.print("Nhap lai ma: ");
                                String mathe = sc.next();
                                the.setMaThe(mathe);
                                break;
                            }
                        }
                    } while(!check4);
                    ds.add(the);
                    System.out.println("Dang ky thanh cong!");
                    System.out.print("Nhan Enter de tiep tuc!");
                    sc.nextLine();
                    sc.nextLine();
                break;
                    // System.out.println("\t\t    -------Dang ky the thu vien--------");
                    // TheThuVien t = new TheThuVien();
                    // t.Dangky();
                    // for (int i = 0; i < ds.size(); i++) {
                    //     if (t.getMaThe().equals(ds.get(i).getMaThe())) {
                    //         System.out.println("Ma the da co nguoi dang ky! Vui long nhap ma khac!");
                    //         System.out.print("Nhap lai ma: ");
                    //         String mathe = sc.next();
                    //         t.setMaThe(mathe);
                    //         i -= 1;
                    //     }
                    // }
                    // ds.add(t);
                    // System.out.println("Dang ky thanh cong!");
                    // System.out.print("Nhan Enter de tiep tuc!");
                    // sc.nextLine();
                    // sc.nextLine();
                    // break;
                case 5:
                    int s = 0;
                    do {
                        System.out.println("\t\t    ----Nhap thong tin muon sach-----");
                        int vitri = -1;
                        if (ds.size() <= 0) {
                            System.out.println("\n\t\t\t    Chua co hoi vien!");
                            System.out.println("\n\t\t\t    Vui long dang ky!");
                            System.out.print("Nhan Enter de tiep tuc!");
                            sc.nextLine();
                            sc.nextLine();
                        } else {
                            System.out.print("Nhap ma the: ");
                            String mathe = sc.next();
                            do {
                                for (int i = 0; i < ds.size(); i++) {
                                    if (ds.get(i).getMaThe().equals(mathe)) {
                                        vitri = i;
                                        break;
                                    }
                                }
                                if (vitri == -1) {
                                    System.out.println("Ma the khong ton tai! Vui long nhap lai!");
                                    System.out.print("Nhap lai ma: ");
                                    mathe = sc.next();
                                }
                            } while (vitri == -1);
                            ds.get(vitri).NhapInfo();
                            for (int i = 0; i < ds.get(vitri)._nm.getSosach(); i++) {
                                boolean check = false;
                                if (String.valueOf(
                                        ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachGiaoKhoa")) {
                                    for (int j = 0; j < listsachgiaokhoa.size(); j++) {
                                        if (ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachgiaokhoa.get(j).getMaSach())) {
                                            check = true;
                                        }
                                    }
                                    if (!check) {
                                        System.out.println("Sach co ma '" + ds.get(vitri)._thuvien
                                                .get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                                + "' trong SGK khong ton tai!");
                                        System.out.print("Vui long nhap lai ma sach: ");
                                        String masach = sc.next();
                                        ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1)
                                                .setMaSach(masach);
                                        i -= 1;
                                        continue;
                                    }
                                }
                                if (String.valueOf(
                                        ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachThamKhao")) {
                                    for (int j = 0; j < listsachgiaokhoa.size(); j++) {
                                        if (ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachthamkhao.get(j).getMaSach())) {
                                            check = true;
                                        }
                                    }
                                    if (!check) {
                                        System.out.println("Sach co ma '" + ds.get(vitri)._thuvien
                                                .get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                                + "' trong sach tham khao khong ton tai!");
                                        System.out.print("Vui long nhap lai ma sach: ");
                                        String masach = sc.next();
                                        ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1)
                                                .setMaSach(masach);
                                        i -= 1;
                                        continue;
                                    }
                                }
                                if (String.valueOf(
                                        ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachKhac")) {
                                    for (int j = 0; j < listsachgiaokhoa.size(); j++) {
                                        if (ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachkhac.get(j).getMaSach())) {
                                            check = true;
                                        }
                                    }
                                    if (!check) {
                                        System.out.println("Sach co ma '" + ds.get(vitri)._thuvien
                                                .get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                                + "' trong sach khac khong ton tai!");
                                        System.out.print("Vui long nhap lai ma sach: ");
                                        String masach = sc.next();
                                        ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1)
                                                .setMaSach(masach);
                                        i -= 1;
                                        continue;
                                    }
                                }
                            }
                            int dem = ds.get(vitri)._nm.getSosach();
                            int Sosachdamuon = ds.get(vitri).sosachdamuon;
                            for (int i = 0; i < ds.get(vitri)._nm.getSosach(); i++) {
                                if (String.valueOf(
                                        ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachKhac")) {
                                    for (int j = 0; j < listsachkhac.size(); j++) {
                                        if (ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachkhac.get(j).getMaSach())) {
                                            if (listsachkhac.get(j).soluong > 0) {
                                                listsachkhac.get(j).soluong -= 1;
                                            } else {
                                                System.out.println("Het sach co ma '" + listsachkhac.get(j).getMaSach()
                                                        + "' roi!!!");
                                                ds.get(vitri)._thuvien.remove(Sosachdamuon - i - 1);
                                                ds.get(vitri).sosachdamuon -= 1;
                                                dem--;
                                            }
                                        }
                                    }
                                    continue;
                                }
                                if (String.valueOf(
                                        ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachGiaoKhoa")) {
                                    for (int j = 0; j < listsachgiaokhoa.size(); j++) {
                                        if (ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachgiaokhoa.get(j).getMaSach())) {
                                            if (listsachgiaokhoa.get(j).soluong > 0) {
                                                listsachgiaokhoa.get(j).soluong -= 1;
                                            } else {
                                                System.out.println("Het sach co ma '"
                                                        + listsachgiaokhoa.get(j).getMaSach() + "' roi!!!");
                                                ds.get(vitri)._thuvien.remove(Sosachdamuon - i - 1);
                                                ds.get(vitri).sosachdamuon -= 1;
                                                dem--;
                                            }
                                        }
                                    }
                                    continue;
                                }
                                if (String.valueOf(
                                        ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachThamKhao")) {
                                    for (int j = 0; j < listsachthamkhao.size(); j++) {
                                        if (ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachthamkhao.get(j).getMaSach())) {
                                            if (listsachthamkhao.get(j).soluong > 0) {
                                                listsachthamkhao.get(j).soluong -= 1;
                                            } else {
                                                System.out.println("Het sach co ma '"
                                                        + listsachthamkhao.get(j).getMaSach() + "' roi!!!");
                                                ds.get(vitri)._thuvien.remove(Sosachdamuon - i - 1);
                                                ds.get(vitri).sosachdamuon -= 1;
                                                dem--;
                                            }
                                        }
                                    }
                                    continue;
                                }
                            }
                            if (dem > 0) {
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Calendar cal = Calendar.getInstance();
                                cal.add(Calendar.DATE, +7);
                                String ngaytra = String.valueOf(dateFormat.format(cal.getTime()));
                                for (int i = 0; i < dem; i++) {
                                    ds.get(vitri)._ngaytra.add(ngaytra);
                                }
                            }
                            System.out.print("Co muon muon tiep khong (1-Yes/2-No): ");
                            s = sc.nextInt();
                        }
                    } while (s == 1);
                    break;
                case 6:
                    System.out.println("\t\t\t\t    -------Thong tin nguoi muon--------");
                    ArrayList<Integer> vitri = new ArrayList<Integer>();
                    if (ds.size() <= 0) {
                        System.out.println("\n\t\t\t\t\t   Khong co nguoi muon!");
                        System.out.print("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                    } else {
                        int count = 0;
                        for (int i = 0; i < ds.size(); i++) {
                            if (ds.get(i)._ngaytra.size() <= 0) {
                                count += 1;
                            } else if (ds.get(i)._ngaytra.size() != 0) {
                                vitri.add(i);
                            }
                        }
                        if (count == ds.size()) {
                            System.out.println("\n\t\t\t\t\t   Khong co nguoi muon!");
                            System.out.print("Nhan Enter de tiep tuc!");
                            sc.nextLine();
                            sc.nextLine();
                        } else {
                            List<String> headersList = Arrays.asList("Ho va ten", "So dien thoai", "Dia chi", "Ma the");
                            List<List<String>> rowsList = new ArrayList<List<String>>();
                            for (int i = 0; i < vitri.size(); i++) {
                                rowsList.add(ds.get(vitri.get(i)).XuatInfo());
                            }
                            Board board = new Board(105);
                            Table table = new Table(board, 83, headersList, rowsList);
                            List<Integer> colAlignList = Arrays.asList(
                                    Block.DATA_CENTER,
                                    Block.DATA_CENTER,
                                    Block.DATA_CENTER,
                                    Block.DATA_CENTER);
                            List<Integer> colWidthsListEdited = Arrays.asList(20, 15, 33, 10);
                            table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited)
                                    .setGridMode(Table.GRID_FULL);
                            Block tableBlock = table.tableToBlocks();
                            board.setInitialBlock(tableBlock);
                            board.build();
                            String tableString = board.getPreview();
                            System.out.println(tableString);
                            int chon3 = 0;
                            System.out.println("1. Xem chi tiet cac sach muon. \n2. Thoat");
                            System.out.print("Ban chon: ");
                            chon3 = sc.nextInt();
                            switch (chon3) {
                                case 1:
                                    System.out.print("\tNhap ma the: ");
                                    String mathe = sc.next();
                                    List<String> header = Arrays.asList("Ma sach", "Ten Sach", "Ten nha xuat ban",
                                            "Ngay muon", "Ngay tra");
                                    List<List<String>> row = new ArrayList<List<String>>();
                                    for (int i = 0; i < ds.size(); i++) {
                                        if (ds.get(i).getMaThe().equals(mathe)) {
                                            ArrayList<Sach> CacSach = ds.get(i)._thuvien;
                                            for (int j = 0; j < CacSach.size(); j++)
                                                for (int k = 0; k < thuvien.size(); k++) {
                                                    if (CacSach.get(j).getMaSach().equals(thuvien.get(k).getMaSach()))
                                                        row.add(Arrays.asList(thuvien.get(k).getMaSach(),
                                                                thuvien.get(k).getTenSach(),
                                                                thuvien.get(k).getNhaXuatBan(),
                                                                String.valueOf(ds.get(i)._ngaymuon.get(j)),
                                                                ds.get(i)._ngaytra.get(j)));
                                                }
                                            break;
                                        }
                                    }
                                    Board board1 = new Board(94);
                                    Table table1 = new Table(board1, 94, header, row);
                                    List<Integer> colAlignList1 = Arrays.asList(
                                            Block.DATA_CENTER,
                                            Block.DATA_CENTER,
                                            Block.DATA_CENTER,
                                            Block.DATA_CENTER,
                                            Block.DATA_CENTER);
                                    List<Integer> colWidthsListEdited1 = Arrays.asList(20, 19, 29, 10, 10);
                                    table1.setColAlignsList(colAlignList1).setColWidthsList(colWidthsListEdited1)
                                            .setGridMode(Table.GRID_FULL);
                                    Block tableBlock1 = table1.tableToBlocks();
                                    board1.setInitialBlock(tableBlock1);
                                    board1.build();
                                    String tableString1 = board1.getPreview();
                                    System.out.println(tableString1);
                                    System.out.print("Nhan Enter de tiep tuc!");
                                    sc.nextLine();
                                    sc.nextLine();
                                    break;
                                case 2:
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    break;
                case 7:
                    long maToday = System.currentTimeMillis();
                    Date today = new Date(maToday);
                    System.out.println("\t\t    -------Thong tin nguoi muon qua han--------");
                    List<String> headersList = Arrays.asList("Ho va ten", "So dien thoai", "Dia chi", "Ma the");
                    List<List<String>> rowsList = new ArrayList<List<String>>();
                    ArrayList<TheThuVien> quahan = new ArrayList<TheThuVien>();
                    ArrayList<Integer> vitri1 = new ArrayList<Integer>();
                    int index = 0;
                    for (int i = 0; i < ds.size(); i++) {
                        if (ds.get(i)._ngaytra.size() != 0) {
                            vitri1.add(i);
                        } else {
                            index += 1;
                        }
                    }
                    if (index != 0) {
                        System.out.println("\n\t\t\t   Khong co nguoi muon qua han!");
                        System.out.print("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                        break;
                    }
                    for (int i = 0; i < vitri1.size(); i++) {
                        for (int j = 0; j < ds.get(vitri1.get(i))._ngaytra.size(); j++) {
                            Date date = Date.valueOf(ds.get(vitri1.get(i))._ngaytra.get(j));
                            if (today.compareTo(date) > 0) {
                                boolean check = false;
                                for (int k = 0; k < rowsList.size(); k++) {
                                    if (rowsList.get(k).equals(ds.get(i).XuatInfo())) {
                                        check = true;
                                    }
                                }
                                if (check == false) {
                                    rowsList.add(ds.get(i).XuatInfo());
                                }
                                quahan.add(ds.get(i));
                            }
                        }
                    }
                    if (rowsList.size() <= 0) {
                        System.out.println("\n\t\t\t   Khong co nguoi muon qua han!");
                        System.out.print("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                    } else {
                        Board board = new Board(105);
                        Table table = new Table(board, 83, headersList, rowsList);
                        List<Integer> colAlignList = Arrays.asList(
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER);
                        List<Integer> colWidthsListEdited = Arrays.asList(20, 15, 33, 10);
                        table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited)
                                .setGridMode(Table.GRID_FULL);
                        Block tableBlock = table.tableToBlocks();
                        board.setInitialBlock(tableBlock);
                        board.build();
                        String tableString = board.getPreview();
                        System.out.println(tableString);
                        int chon3 = 0;
                        System.out.println("1. Xem chi tiet cac sach muon qua han. \n2. Thoat");
                        System.out.print("Ban chon: ");
                        chon3 = sc.nextInt();
                        switch (chon3) {
                            case 1:
                                System.out.print("\tNhap ma the: ");
                                String mathe = sc.next();
                                List<String> header = Arrays.asList("Ma sach", "Ten Sach", "Ten nha xuat ban",
                                        "Ngay muon", "Ngay tra", "Ngay hien tai");
                                List<List<String>> row = new ArrayList<List<String>>();
                                for (int i = 0; i < quahan.size(); i++) {
                                    if (quahan.get(i).getMaThe().equals(mathe)) {
                                        ArrayList<Sach> CacSach = quahan.get(i)._thuvien;
                                        for (int j = 0; j < CacSach.size(); j++)
                                            for (int k = 0; k < thuvien.size(); k++) {
                                                if (CacSach.get(j).getMaSach().equals(thuvien.get(k).getMaSach()))
                                                    row.add(Arrays.asList(thuvien.get(k).getMaSach(),
                                                            thuvien.get(k).getTenSach(),
                                                            thuvien.get(k).getNhaXuatBan(),
                                                            String.valueOf(ds.get(i)._ngaymuon.get(j)),
                                                            ds.get(i)._ngaytra.get(j), String.valueOf(today)));
                                            }
                                        break;
                                    }
                                }
                                Board board1 = new Board(114);
                                Table table1 = new Table(board1, 114, header, row);
                                List<Integer> colAlignList1 = Arrays.asList(
                                        Block.DATA_CENTER,
                                        Block.DATA_CENTER,
                                        Block.DATA_CENTER,
                                        Block.DATA_CENTER,
                                        Block.DATA_CENTER,
                                        Block.DATA_CENTER);
                                List<Integer> colWidthsListEdited1 = Arrays.asList(20, 19, 29, 12, 12, 15);
                                table1.setColAlignsList(colAlignList1).setColWidthsList(colWidthsListEdited1)
                                        .setGridMode(Table.GRID_FULL);
                                Block tableBlock1 = table1.tableToBlocks();
                                board1.setInitialBlock(tableBlock1);
                                board1.build();
                                String tableString1 = board1.getPreview();
                                System.out.println(tableString1);
                                System.out.print("Nhan Enter de tiep tuc!");
                                sc.nextLine();
                                sc.nextLine();
                                break;
                            case 2:
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("\t\tTam biet!!!!!");
                    wait(1000);
                    break;
            }
        } while (chon < 8);
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
