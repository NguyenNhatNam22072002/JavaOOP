import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class TheThuVien {
    private NguoiMuon _nm = new NguoiMuon();
    private String _Mathe;
    private ArrayList<Date> _ngaymuon = new ArrayList<Date>();
    private ArrayList<String> _ngaytra = new ArrayList<String>();
    private ArrayList<Sach> _thuvien = new ArrayList<Sach>();
    private int sosachdamuon = 0;

    Scanner sc = new Scanner(System.in);

    public TheThuVien() {

    }

    public TheThuVien(NguoiMuon nm, String mathe) {
        this._nm = nm;
        this._Mathe = mathe;
    }

    public String getMaThe() {
        return this._Mathe;
    }

    public void setMaThe(String mathe) {
        this._Mathe = mathe;
    }

    public void Dangky() {
        this._nm.NhapInfo();
        System.out.print("Nhap ma the muon dang ky: ");
        this._Mathe = sc.nextLine();
    }

    public void NhapInfo() {
        System.out.print("Nhap so loai sach muon: ");
        int Sosach;
        Sosach = sc.nextInt();
        this._nm.setSosach(Sosach);
        for (int i = 0; i < this._nm.getSosach(); i++) {
            int number;
            System.out.print("Loai sach ban muon muon (SGK: chon 1/ Sach Tham khao: chon 2/ Sach khac: chon 3): ");
            number = sc.nextInt();
            Sach sach;
            switch (number) {
                case 1:
                    sc.nextLine();
                    sach = new SachGiaoKhoa();
                    sach.MuonSach();
                    break;
                case 2:
                    sc.nextLine();
                    sach = new SachThamKhao();
                    sach.MuonSach();
                    break;
                default:
                    sc.nextLine();
                    sach = new SachKhac();
                    sach.MuonSach();
                    break;
            }
            this._thuvien.add(sach);
            long maToday = System.currentTimeMillis();
            Date today = new Date(maToday);
            this._ngaymuon.add(today);
        }
        sosachdamuon += this._nm.getSosach();
    }

    public List<String> XuatInfo() {
        /*this._nm.XuatInfo();
        System.out.println("-Ma the: " + this._Mathe);
        System.out.println("-Ngay muon: " + this._ngaymuon);
        System.out.println("-Ngay tra: " + this._ngaytra);
        System.out.println("-So sach muon: " + this._nm.getSosach());
        ArrayList<Sach> Cacsach = this._nm._thuvien;
        for(int i = 0; i < this._nm.getSosach(); i++)
        {
        System.out.print("+Ma sach thu " + (i+1) + " la:" +
        Cacsach.get(i).getMaSach());
        System.out.println();
        }*/
        return Arrays.asList(this._nm.getHoten(), this._nm.getSdt(), this._nm.getDiachi(), this._Mathe);
    }

    public static void DangKyThe(ArrayList<TheThuVien> ds)
    {
        Scanner sc = new Scanner(System.in);
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
    }
    
    public static void MuonSach(ArrayList<TheThuVien> ds, ArrayList<SachGiaoKhoa> listsachgiaokhoa, ArrayList<SachThamKhao> listsachthamkhao, ArrayList<SachKhac> listsachkhac)
    {
        Scanner sc = new Scanner(System.in);
        int s = 0;
                    do {
                        System.out.println("\t\t    ----Nhap thong tin muon sach-----");
                        int vitri = -1;
                        if (ds.size() <= 0) 
                        {
                            System.out.println("\n\t\t\t    Chua co hoi vien!");
                            System.out.println("\n\t\t\t    Vui long dang ky!");
                            System.out.print("Nhan Enter de tiep tuc!");
                            sc.nextLine();
                        } else 
                        {
                            System.out.print("Nhap ma the: ");
                            String mathe = sc.next();
                            do {
                                for (int i = 0; i < ds.size(); i++) {
                                    if (ds.get(i).getMaThe().equals(mathe))
                                    {
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
                            for (int i = 0; i < ds.get(vitri)._nm.getSosach(); i++) 
                            {
                                boolean check = false;
                                if (String.valueOf(
                                        ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachGiaoKhoa")) {
                                    for (int j = 0; j < listsachgiaokhoa.size(); j++) 
                                    {
                                        if (ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachgiaokhoa.get(j).getMaSach())) {
                                            check = true;
                                        }
                                    }
                                    if (!check) 
                                    {
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
                                        .equalsIgnoreCase("class SachThamKhao")) 
                                        {
                                    for (int j = 0; j < listsachgiaokhoa.size(); j++) 
                                    {
                                        if (ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachthamkhao.get(j).getMaSach())) {
                                            check = true;
                                        }
                                    }
                                    if (!check) 
                                    {
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
                                    for (int j = 0; j < listsachgiaokhoa.size(); j++) 
                                    {
                                        if (ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachkhac.get(j).getMaSach())) {
                                            check = true;
                                        }
                                    }
                                    if (!check) 
                                    {
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
                            for (int i = 0; i < ds.get(vitri)._nm.getSosach(); i++) 
                            {
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
    }

    public static void ThongTinNguoiMuon(ArrayList<TheThuVien> ds, ArrayList<Sach> thuvien)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\t    -------Thong tin nguoi muon--------");
        ArrayList<Integer> vitri = new ArrayList<Integer>();
        if (ds.size() <= 0) {
            System.out.println("\n\t\t\t\t\t   Khong co nguoi muon!");
            System.out.print("Nhan Enter de tiep tuc!");
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
    }
    public static void ThongTinNguoiMuonQuaHan(ArrayList<TheThuVien> ds, ArrayList<Sach> thuvien)
    {
        Scanner sc = new Scanner(System.in);
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
                        return;
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
    }
}
