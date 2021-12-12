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
        return Arrays.asList(this._nm.getHoten(), this._nm.getSdt(), this._nm.getDiachi(), this._Mathe);
    }


    public static void DangKyThe(ArrayList<TheThuVien> ds) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t    -------Dang ky the thu vien--------");
        TheThuVien the = new TheThuVien();
        the.Dangky();
        Boolean check4;     
        do {    //Hàm kiểm tra xem mã thẻ đã có trước đó chưa
            check4 = true;  
            for (int i = 0; i < ds.size(); i++) {      //Cho for chạy từ đầu list mã thẻ               
                if (the.getMaThe().equals(ds.get(i).getMaThe()))    //Nếu đã có trước đó
                {
                    check4 = false;
                    System.out.println("Ma the da co nguoi dang ky! Vui long nhap ma khac!");
                    System.out.print("Nhap lai ma: ");
                    String mathe = sc.next();   //Nhập lại mã
                    the.setMaThe(mathe);    //Set lại mã người này
                    break;
                }
            }
        } while (!check4);
        ds.add(the);    //Thêm thẻ mới được tạo vào list đăng ký thẻ
        System.out.println("Dang ky thanh cong!");
        System.out.print("Nhan Enter de tiep tuc!");
        sc.nextLine();
    }

    public static void MuonSach(ArrayList<TheThuVien> ds, ArrayList<SachGiaoKhoa> listsachgiaokhoa,
            ArrayList<SachThamKhao> listsachthamkhao, ArrayList<SachKhac> listsachkhac) {
        Scanner sc = new Scanner(System.in);
        int s = 0;
        do {
            System.out.println("\t\t    ----Nhap thong tin muon sach-----");
            int vitri = -1;
            if (ds.size() <= 0) //kiểm tra xem đã có hội viên chưa
            {
                System.out.println("\n\t\t\t    Chua co hoi vien!");
                System.out.println("\n\t\t\t    Vui long dang ky!");
                System.out.print("Nhan Enter de tiep tuc!");
                sc.nextLine();
            } 
            else 
            {
                System.out.print("Nhap ma the: ");  //Nhập mã
                String mathe = sc.next();
                do {
                    for (int i = 0; i < ds.size(); i++) {
                        if (ds.get(i).getMaThe().equals(mathe)) {   //kiểm tra xem mã có trùng với danh sách không
                            vitri = i;
                            break;
                        }
                    }
                    if (vitri == -1) {  // nếu không trùng thì nhập lại
                        System.out.println("Ma the khong ton tai! Vui long nhap lai!");
                        System.out.print("Nhap lai ma: ");
                        mathe = sc.next();
                    }
                } while (vitri == -1);
                ds.get(vitri).NhapInfo();   //nhập thông tin sách được mượn
                for (int i = 0; i < ds.get(vitri)._nm.getSosach(); i++) {
                    boolean check = false;  //biến kiểm tra sách
                    if (String.valueOf(
                            ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass())
                            .equalsIgnoreCase("class SachGiaoKhoa")) {  //kiểm tra loại sách
                        for (int j = 0; j < listsachgiaokhoa.size(); j++) {
                            if (ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                    .equals(listsachgiaokhoa.get(j).getMaSach())) {
                                check = true;   //nếu mã sách có trong list sách, check thành true
                            }
                        }
                        if (!check) {   //nếu không trùng mã trong list sách, thì nhập lại mã
                            System.out.println("Sach co ma '" + ds.get(vitri)._thuvien
                                    .get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                    + "' trong SGK khong ton tai!");
                            System.out.print("Vui long nhap lai ma sach: ");
                            String masach = sc.next();
                            ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1)
                                    .setMaSach(masach); //set mã sách vừa nhập lại
                            i -= 1; //duyệt lại từ đầu
                            continue;
                        }
                    }
                    if (String.valueOf( 
                            ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass())
                            .equalsIgnoreCase("class SachThamKhao")) {  //kiểm tra loại sách
                        for (int j = 0; j < listsachthamkhao.size(); j++) {
                            if (ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                    .equals(listsachthamkhao.get(j).getMaSach())) { //nếu mã sách có trong list sách, check thành true
                                check = true;
                            }
                        }
                        if (!check) {    //nếu không trùng mã trong list sách, thì nhập lại mã
                            System.out.println("Sach co ma '" + ds.get(vitri)._thuvien
                                    .get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                    + "' trong sach tham khao khong ton tai!");
                            System.out.print("Vui long nhap lai ma sach: ");
                            String masach = sc.next();
                            ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1)
                                    .setMaSach(masach);  //set mã sách vừa nhập lại
                            i -= 1; //duyệt lại từ đầu
                            continue;
                        }
                    }
                    if (String.valueOf( 
                            ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass())
                            .equalsIgnoreCase("class SachKhac")) {   //kiểm tra loại sách
                        for (int j = 0; j < listsachkhac.size(); j++) {
                            if (ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                    .equals(listsachkhac.get(j).getMaSach())) { //nếu mã sách có trong list sách, check thành true
                                check = true;
                            }
                        }
                        if (!check) {    //nếu không trùng mã trong list sách, thì nhập lại mã
                            System.out.println("Sach co ma '" + ds.get(vitri)._thuvien
                                    .get(ds.get(vitri).sosachdamuon - i - 1).getMaSach()
                                    + "' trong sach khac khong ton tai!");
                            System.out.print("Vui long nhap lai ma sach: ");
                            String masach = sc.next();
                            ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1)
                                    .setMaSach(masach);  //set mã sách vừa nhập lại
                            i -= 1; //duyệt lại từ đầu
                            continue;
                        }
                    }
                }
                int dem = ds.get(vitri)._nm.getSosach();    //biến đếm số sách
                int Sosachdamuon = ds.get(vitri).sosachdamuon;  //biến số sách mượn
                for (int i = 0; i < ds.get(vitri)._nm.getSosach(); i++) {
                    if (String.valueOf(
                            ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getClass())
                            .equalsIgnoreCase("class SachKhac")) { //kiểm tra loại sách
                        for (int j = 0; j < listsachkhac.size(); j++) {
                            if (ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getMaSach()
                                    .equals(listsachkhac.get(j).getMaSach())) { //kiểm tra còn sách thì trừ số lượng
                                if (listsachkhac.get(j).soluong > 0) {
                                    listsachkhac.get(j).soluong -= 1;
                                } else {
                                    System.out.println("Het sach co ma '" + listsachkhac.get(j).getMaSach()
                                            + "' roi!!!");  //hết sách thì thông báo
                                    ds.get(vitri)._thuvien.remove(Sosachdamuon - i - 1);    //bỏ sách ra khỏi danh sách mượn
                                    ds.get(vitri).sosachdamuon -= 1;    //giảm số sách mượn
                                    dem--;
                                }
                            }
                        }
                        continue;
                    }
                    if (String.valueOf(
                            ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getClass())
                            .equalsIgnoreCase("class SachGiaoKhoa")) {  //kiểm tra loại sách
                        for (int j = 0; j < listsachgiaokhoa.size(); j++) {
                            if (ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getMaSach()
                                    .equals(listsachgiaokhoa.get(j).getMaSach())) { //kiểm tra còn sách thì trừ số lượng
                                if (listsachgiaokhoa.get(j).soluong > 0) {
                                    listsachgiaokhoa.get(j).soluong -= 1;
                                } else {
                                    System.out.println("Het sach co ma '"
                                            + listsachgiaokhoa.get(j).getMaSach() + "' roi!!!");    //hết sách thì thông báo
                                    ds.get(vitri)._thuvien.remove(Sosachdamuon - i - 1);     //bỏ sách ra khỏi danh sách mượn
                                    ds.get(vitri).sosachdamuon -= 1;    //giảm số sách mượn
                                    dem--;
                                }
                            }
                        }
                        continue;
                    }
                    if (String.valueOf(
                            ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getClass())
                            .equalsIgnoreCase("class SachThamKhao")) {  //kiểm tra loại sách
                        for (int j = 0; j < listsachthamkhao.size(); j++) {
                            if (ds.get(vitri)._thuvien.get(Sosachdamuon - i - 1).getMaSach()
                                    .equals(listsachthamkhao.get(j).getMaSach())) { //kiểm tra còn sách thì trừ số lượng
                                if (listsachthamkhao.get(j).soluong > 0) {
                                    listsachthamkhao.get(j).soluong -= 1;
                                } else {
                                    System.out.println("Het sach co ma '"
                                            + listsachthamkhao.get(j).getMaSach() + "' roi!!!");    //hết sách thì thông báo
                                    ds.get(vitri)._thuvien.remove(Sosachdamuon - i - 1);    //bỏ sách ra khỏi danh sách mượn
                                    ds.get(vitri).sosachdamuon -= 1;     //giảm số sách mượn
                                    dem--;
                                }
                            }
                        }
                        continue;
                    }
                }
                if (dem > 0) {  //nếu có sách mượn
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, +7);
                    String ngaytra = String.valueOf(dateFormat.format(cal.getTime()));
                    for (int i = 0; i < dem; i++) {
                        ds.get(vitri)._ngaytra.add(ngaytra);    //thêm ngày trả vào thông người mượn
                    }
                }
                System.out.print("Co muon muon tiep khong (1-Yes/2-No): ");
                s = sc.nextInt();
            }
        } while (s == 1);
    }

    public static void ThongTinNguoiMuon(ArrayList<TheThuVien> ds, ArrayList<Sach> thuvien) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\t    -------Thong tin nguoi muon--------");
        ArrayList<Integer> vitri = new ArrayList<Integer>();    //tạo 1 danh sách dạng mảng lưu vị trí
        if (ds.size() <= 0) {   //kiểm tra xem có người mượn hay không
            System.out.println("\n\t\t\t\t\t   Khong co nguoi muon!");
            System.out.print("Nhan Enter de tiep tuc!");    //không có thì thông báo và kết thúc hàm
            sc.nextLine();
        } else {
            int count = 0; //biến đếm
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i)._ngaytra.size() <= 0) {
                    count += 1; //nếu không có ngày trả thì tăng biến đếm
                } else if (ds.get(i)._ngaytra.size() != 0) {
                    vitri.add(i);
                }
            }
            if (count == ds.size()) {   //nếu biến đếm bằng số lượng hội viên thì chưa có người mượn
                System.out.println("\n\t\t\t\t\t   Khong co nguoi muon!");
                System.out.print("Nhan Enter de tiep tuc!");    //thông báo và kết thúc hàm
                sc.nextLine();
            } else {
                List<String> headersList = Arrays.asList("Ho va ten", "So dien thoai", "Dia chi", "Ma the");    //tạo danh sách chứa hàng đầu của bảng
                List<List<String>> rowsList = new ArrayList<List<String>>();    //tạo danh sách 2 chiều chứa thông tin của bảng
                for (int i = 0; i < vitri.size(); i++) {
                    rowsList.add(ds.get(vitri.get(i)).XuatInfo());  //add thông tin vào danh sách
                }
                Board board = new Board(105);   //tạo bảng
                Table table = new Table(board, 83, headersList, rowsList);  //tạo sườn
                List<Integer> colAlignList = Arrays.asList(
                        Block.DATA_CENTER,
                        Block.DATA_CENTER,
                        Block.DATA_CENTER,
                        Block.DATA_CENTER);     //căn lề
                List<Integer> colWidthsListEdited = Arrays.asList(20, 15, 33, 10);  //căn độ rộng của ô
                table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited)
                        .setGridMode(Table.GRID_FULL);  //set căn lề, độ rộng và vẽ full viền
                Block tableBlock = table.tableToBlocks();   //tạo các khối block
                board.setInitialBlock(tableBlock);  //vẽ các khối lên bảng
                board.build();  //build bảng
                String tableString = board.getPreview();    //lấy bảng gán vào 1 string in ra
                System.out.println(tableString);    //in bảng
                int chon3 = 0;
                System.out.println("1. Xem chi tiet cac sach muon. \n2. Thoat");    //tạo menu
                System.out.print("Ban chon: ");
                chon3 = sc.nextInt();
                switch (chon3) {
                    case 1:
                        System.out.print("\tNhap ma the: ");
                        String mathe = sc.next();   //nhập mã thẻ
                        List<String> header = Arrays.asList("Ma sach", "Ten Sach", "Ten nha xuat ban",
                                "Ngay muon", "Ngay tra");    //tạo danh sách chứa hàng đầu của bảng
                        List<List<String>> row = new ArrayList<List<String>>(); //tạo danh sách 2 chiều chứa thông tin của bảng
                        for (int i = 0; i < ds.size(); i++) {
                            if (ds.get(i).getMaThe().equals(mathe)) {   //tìm mã thẻ trong danh sách hội viên
                                ArrayList<Sach> CacSach = ds.get(i)._thuvien;
                                for (int j = 0; j < CacSach.size(); j++)
                                    for (int k = 0; k < thuvien.size(); k++) {
                                        if (CacSach.get(j).getMaSach().equals(thuvien.get(k).getMaSach()))
                                            row.add(Arrays.asList(thuvien.get(k).getMaSach(),
                                                    thuvien.get(k).getTenSach(),
                                                    thuvien.get(k).getNhaXuatBan(),
                                                    String.valueOf(ds.get(i)._ngaymuon.get(j)),
                                                    ds.get(i)._ngaytra.get(j)));    //add thông tin vào danh sách
                                    }
                                break;
                            }
                        }
                        Board board1 = new Board(94);   //tạo bảng
                        Table table1 = new Table(board1, 94, header, row);  //tạo sườn
                        List<Integer> colAlignList1 = Arrays.asList(
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER,
                                Block.DATA_CENTER); //căn lề
                        List<Integer> colWidthsListEdited1 = Arrays.asList(20, 19, 29, 10, 10); //căn độ rộng của ơ
                        table1.setColAlignsList(colAlignList1).setColWidthsList(colWidthsListEdited1)
                                .setGridMode(Table.GRID_FULL);  //set căn lề, độ rộng và vẽ full viền
                        Block tableBlock1 = table1.tableToBlocks(); //tạo các khối block
                        board1.setInitialBlock(tableBlock1);    //vẽ các khối lên bảng
                        board1.build(); //build bảng
                        String tableString1 = board1.getPreview();  //gán bảng vào 1 string
                        System.out.println(tableString1);   //in bảng
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

    public static void ThongTinNguoiMuonQuaHan(ArrayList<TheThuVien> ds, ArrayList<Sach> thuvien) {
        Scanner sc = new Scanner(System.in);
        long maToday = System.currentTimeMillis(); 
        Date today = new Date(maToday); //lấy ngày hiện tại
        System.out.println("\t\t    -------Thong tin nguoi muon qua han--------");
        List<String> headersList = Arrays.asList("Ho va ten", "So dien thoai", "Dia chi", "Ma the");    //tạo danh sách chứa hàng đầu của bảng
        List<List<String>> rowsList = new ArrayList<List<String>>();    //tạo danh sách 2 chiều chứa thông tin của bảng
        ArrayList<TheThuVien> quahan = new ArrayList<TheThuVien>();     //tạo danh sách chứa những người quá hạn
        ArrayList<Integer> vitri1 = new ArrayList<Integer>();   //tạo danh sách chứa vị trí
        int index = 0; //biến tạm
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i)._ngaytra.size() != 0) {
                vitri1.add(i);  //nếu có mượn sách thì thêm vị trí
            } else {
                index += 1; //không thì +1 biến tạm
            }
        }
        if (index != 0) {   //biến tạm khác 0 là không có người mượn
            System.out.println("\n\t\t\t   Khong co nguoi muon qua han!");
            System.out.print("Nhan Enter de tiep tuc!");//thông báo và kết thúc hàm
            sc.nextLine();
            return;
        }
        for (int i = 0; i < vitri1.size(); i++) {
            for (int j = 0; j < ds.get(vitri1.get(i))._ngaytra.size(); j++) {   //duyệt những hội viên mượn sách
                Date date = Date.valueOf(ds.get(vitri1.get(i))._ngaytra.get(j));
                if (today.compareTo(date) > 0) { // nếu mượn sách quá hạn
                    boolean check = false;  //tạo biến check
                    for (int k = 0; k < rowsList.size(); k++) { //duyệt danh sách thông tin
                        if (rowsList.get(k).equals(ds.get(i).XuatInfo())) { //nếu đã có trong dánh sách
                            check = true;   //gán check bằng true
                        }
                    }
                    if (check == false) {   //không có trong danh sách thông tin
                        rowsList.add(ds.get(i).XuatInfo()); //thêm vào danh sách
                    }
                    quahan.add(ds.get(i));  //thêm vào danh sách quá hạn
                }
            }
        }
        if (rowsList.size() <= 0) { //nếu danh sách trống
            System.out.println("\n\t\t\t   Khong co nguoi muon qua han!");
            System.out.print("Nhan Enter de tiep tuc!");//thông báo và kết thúc hàm
            sc.nextLine();
        } else {
            Board board = new Board(105);// tạo bảng
            Table table = new Table(board, 83, headersList, rowsList);  //tạo sườn
            List<Integer> colAlignList = Arrays.asList(
                    Block.DATA_CENTER,
                    Block.DATA_CENTER,
                    Block.DATA_CENTER,
                    Block.DATA_CENTER);//căn lề
            List<Integer> colWidthsListEdited = Arrays.asList(20, 15, 33, 10);//căn độ rộng
            table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited)
                    .setGridMode(Table.GRID_FULL);//set căn lề, độ rộng và vẽ full viền
            Block tableBlock = table.tableToBlocks();   //tạo các khối block
            board.setInitialBlock(tableBlock);  //vẽ các khối lên bảng
            board.build();  //build bảng
            String tableString = board.getPreview();    //gán bảng vào 1 String
            System.out.println(tableString);//in bảng
            int chon3 = 0;
            System.out.println("1. Xem chi tiet cac sach muon qua han. \n2. Thoat");
            System.out.print("Ban chon: ");
            chon3 = sc.nextInt();
            switch (chon3) {
                case 1:
                    System.out.print("\tNhap ma the: ");
                    String mathe = sc.next();   //nhập mã thẻ
                    List<String> header = Arrays.asList("Ma sach", "Ten Sach", "Ten nha xuat ban",
                            "Ngay muon", "Ngay tra", "Ngay hien tai");  //tạo danh sách chứa hàng đầu của bảng
                    List<List<String>> row = new ArrayList<List<String>>(); //tạo danh sách 2 chiều chứa thông tin bảng
                    for (int i = 0; i < quahan.size(); i++) {   //xét những người quá hạn
                        if (quahan.get(i).getMaThe().equals(mathe)) {   //nếu trùng mã thẻ
                            ArrayList<Sach> CacSach = quahan.get(i)._thuvien;   //tạo biến lưu các sách đã mượn
                            for (int j = 0; j < CacSach.size(); j++)    //duyệt các sách mượn
                                for (int k = 0; k < thuvien.size(); k++) {  //duyệt thư viện
                                    if (CacSach.get(j).getMaSach().equals(thuvien.get(k).getMaSach()))  //tìm sách trong thư viện
                                        row.add(Arrays.asList(thuvien.get(k).getMaSach(),
                                                thuvien.get(k).getTenSach(),
                                                thuvien.get(k).getNhaXuatBan(),
                                                String.valueOf(ds.get(i)._ngaymuon.get(j)),
                                                ds.get(i)._ngaytra.get(j), String.valueOf(today)));//add thông tin vào danh sách thông tin
                                }
                            break;//ngừng khi tìm được mã thẻ
                        }
                    }
                    Board board1 = new Board(114); //tạo bảng
                    Table table1 = new Table(board1, 114, header, row); //tạo sườn
                    List<Integer> colAlignList1 = Arrays.asList(
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER);//căn lề
                    List<Integer> colWidthsListEdited1 = Arrays.asList(20, 19, 29, 12, 12, 15); //căn độ rộng
                    table1.setColAlignsList(colAlignList1).setColWidthsList(colWidthsListEdited1)
                            .setGridMode(Table.GRID_FULL);  //set căn lề, độ rộng và vẽ full viền
                    Block tableBlock1 = table1.tableToBlocks(); //tạo các khối block
                    board1.setInitialBlock(tableBlock1);//vẽ các khối lên bảng
                    board1.build();//build bảng
                    String tableString1 = board1.getPreview();//gán bảng vào 1 String
                    System.out.println(tableString1);//in bảng
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
