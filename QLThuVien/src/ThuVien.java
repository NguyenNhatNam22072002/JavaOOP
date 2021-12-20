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
        //Tạo 3 nhân viên quản lý thư viện
        NhanVien Nam = new NhanVien("Nhat Nam", "0355181736", "Binh Dinh");
        NhanVien Hai = new NhanVien(" Hoang Hai", "0985927403", "Dong Nai");
        NhanVien Nguyen = new NhanVien("Tay Nguyen", "0944398092", "Gia Lai");
        //Tạo danh sách nhân viên và thêm 3 nhân viên vào danh sách
        ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
        listNV.add(Nam);
        listNV.add(Hai);
        listNV.add(Nguyen);
        //Khởi tạo 3 sách trong thư viện 
        SachGiaoKhoa sachToan = new SachGiaoKhoa("sgktoan1", "Toan Cao Cap", "Kim Dong", 1, 13);
        SachKhac Conan = new SachKhac("conan1", "Conan tap 1", "Kim Dong", 1, "Tieu thuyet");
        SachThamKhao thamkhao = new SachThamKhao("tkvan1", "Sach Giai Van 12", "Kim Dong", 2, "Van");
        //Tạo danh sách SGK, Sách tham khảo, Sách khác
        ArrayList<SachGiaoKhoa> listsachgiaokhoa = new ArrayList<SachGiaoKhoa>();
        ArrayList<SachThamKhao> listsachthamkhao = new ArrayList<SachThamKhao>();
        ArrayList<SachKhac> listsachkhac = new ArrayList<SachKhac>();
        //Thêm vào mỗi listsach mỗi loại sách
        listsachkhac.add(Conan);
        listsachgiaokhoa.add(sachToan);
        listsachthamkhao.add(thamkhao);
        //Tạo list toàn bộ sách của thư viện
        ArrayList<Sach> thuvien = new ArrayList<Sach>();
        thuvien.add(Conan);
        thuvien.add(sachToan);
        thuvien.add(thamkhao);

        Scanner sc = new Scanner(System.in);
        //Tạo danh sách những người đăng ký thẻ 
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
                case "1":   //Nhân viên
                    int chon2;
                    System.out.print("\t1. In nhan vien.\n\t2. Them nhan vien\n"); // 2 chức năng của nhân viên
                    System.out.print("\tBan chon: ");
                    chon2 = sc.nextInt();
                    switch (chon2) {
                        case 1:
                            System.out.println("\t\t    -------Thong tin nhan vien--------");
                            List<String> headersList = Arrays.asList("Ho ten", "So dien thoai", "Dia chi");
                            List<List<String>> rowsList = new ArrayList<List<String>>();
                            for (int i = 0; i < listNV.size(); i++)             //duyệt qua tất cả sinh viên trong listNV
                            {
                            rowsList.add(listNV.get(i).XuatInfo());             //in ra tất cả thông tin của nhân viên đó    
                            }
                            Board board = new Board(75);
                            Table table = new Table(board, 75, headersList, rowsList);
                            List<Integer> colAlignList = Arrays.asList(
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER);
                            List<Integer> colWidthsListEdited = Arrays.asList(20, 15, 34);
                            table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited).setGridMode(Table.GRID_FULL);
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
                            int nv; 
                            nv = sc.nextInt();          //nhập số nhân viên cần thêm
                            for (int i = 0; i < nv; i++) // duyệt qua số nhân viên được thêm
                            {
                            System.out.println("\t\t    ----Nhap thong tin nhan vien thu " + (i + 1) + "-----");
                            NhanVien newNV = new NhanVien();    // khởi tạo đối tượng nhân viên mới
                            newNV.NhapInfo();                   //nhập thông tin cho sinh viên
                            listNV.add(newNV);                  //thêm nhân viên mới đƯợc thêm vào listNV
                            }
                            System.out.print("Nhan Enter de tiep tuc!");
                            sc.nextLine();
                            sc.nextLine();
                            break;
                    }
                    break;
                case "2":   //Thông tin sách trong thư viện
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
                case "3":   //Nhập sách
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
                                Boolean check1 = false;     //Cho sách vừa tạo chưa có trong listsach
                                for (int i = 0; i < listsachgiaokhoa.size(); i++)       //Kiểm tra sách vừa tạo đã có chưa
                                    if (sachgk.getMaSach().equals(listsachgiaokhoa.get(i).getMaSach()))     //Nếu đã có
                                    {
                                        listsachgiaokhoa.get(i).setSoLuong(listsachgiaokhoa.get(i).getSoLuong() + sachgk.getSoLuong()); //Set lại số lượng sách đó
                                        check1 = true;  //Cho sách vừa tạo đã có
                                        break;
                                    }
                                
                                if (check1 == false)    //Nếu sách vừa tạo chưa có 
                                {
                                    thuvien.add(sachgk);    //Thêm sách mới tạo vào listsach
                                    listsachgiaokhoa.add(sachgk);   //Thêm sách mới tạo vào list thư viện
                                }
                                break;
                            case 2:
                                SachThamKhao sachtk = new SachThamKhao();   
                                sachtk.NhapSach();
                                Boolean check2 = false;     //Cho sách vừa tạo chưa có trong listsach
                                for (int i = 0; i < listsachthamkhao.size(); i++)      //Kiểm tra sách vừa tạo đã có chưa
                                    if (sachtk.getMaSach().equals(listsachthamkhao.get(i).getMaSach()))     //Nếu đã có
                                    {   
                                        listsachthamkhao.get(i).setSoLuong(listsachthamkhao.get(i).getSoLuong() + sachtk.getSoLuong());     //Set lại số lượng sách đó
                                        check2 = true;  //Cho sách vừa tạo đã có
                                        break;
                                    }
                                if (check2 == false)
                                {
                                    thuvien.add(sachtk);    //Thêm sách mới tạo vào listsach
                                    listsachthamkhao.add(sachtk);   //Thêm sách mới tạo vào list thư viện
                                }
                                break;
                            case 3:
                                SachKhac sachkhac = new SachKhac();
                                sachkhac.NhapSach();
                                Boolean check3 = false;     //Cho sách vừa tạo chưa có trong listsach
                                for (int i = 0; i < listsachkhac.size(); i++)       //Kiểm tra sách vừa tạo đã có chưa
                                    if (sachkhac.getMaSach().equals(listsachkhac.get(i).getMaSach()))       //Nếu đã có
                                    {
                                        listsachkhac.get(i).setSoLuong(listsachkhac.get(i).getSoLuong() + sachkhac.getSoLuong());       //Set lại số lượng sách đó
                                        check3 = true;  //Cho sách vừa tạo đã có
                                        break;
                                    }
                                if (check3 == false)
                                {
                                    thuvien.add(sachkhac);      //Thêm sách mới tạo vào listsach
                                    listsachkhac.add(sachkhac);     //Thêm sách mới tạo vào list thư viện
                                }
                                break;
                            default:
                                break;
                        }
                        System.out.print("Ban co muon nhap sach nua khong (1-Yes/2-No):");
                        nhap = sc.nextInt();
                    } while (nhap == 1);
                    break;
                case "4":   //Đăng ký hội viên
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
                    sc.nextLine();
                    break;
                case "5":   //Mượn sách
                    sc.nextLine();
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
                            for (int i = 0; i < ds.get(vitri).getNM().getSosach(); i++) {
                                boolean check = false;  //biến kiểm tra sách
                                if (String.valueOf(
                                        ds.get(vitri).getthuvien().get(ds.get(vitri).getsosachdamuon() - i - 1).getClass())
                                        .equalsIgnoreCase("class SachGiaoKhoa")) {  //kiểm tra loại sách
                                    for (int j = 0; j < listsachgiaokhoa.size(); j++) {
                                        if (ds.get(vitri).getthuvien().get(ds.get(vitri).getsosachdamuon() - i - 1).getMaSach()
                                                .equals(listsachgiaokhoa.get(j).getMaSach())) {
                                            check = true;   //nếu mã sách có trong list sách, check thành true
                                        }
                                    }
                                    if (!check) {   //nếu không trùng mã trong list sách, thì nhập lại mã
                                        System.out.println("Sach co ma '" + ds.get(vitri).getthuvien()
                                                .get(ds.get(vitri).getsosachdamuon() - i - 1).getMaSach()
                                                + "' trong SGK khong ton tai!");
                                        System.out.print("Vui long nhap lai ma sach: ");
                                        String masach = sc.next();
                                        ds.get(vitri).getthuvien().get(ds.get(vitri).getsosachdamuon() - i - 1)
                                                .setMaSach(masach); //set mã sách vừa nhập lại
                                        i =- 1; //duyệt lại từ đầu
                                        continue;
                                    }
                                }
                                if (String.valueOf( 
                                        ds.get(vitri).getthuvien().get(ds.get(vitri).getsosachdamuon() - i - 1).getClass())
                                        .equalsIgnoreCase("class SachThamKhao")) {  //kiểm tra loại sách
                                    for (int j = 0; j < listsachthamkhao.size(); j++) {
                                        if (ds.get(vitri).getthuvien().get(ds.get(vitri).getsosachdamuon() - i - 1).getMaSach()
                                                .equals(listsachthamkhao.get(j).getMaSach())) { //nếu mã sách có trong list sách, check thành true
                                            check = true;
                                        }
                                    }
                                    if (!check) {    //nếu không trùng mã trong list sách, thì nhập lại mã
                                        System.out.println("Sach co ma '" + ds.get(vitri).getthuvien()
                                                .get(ds.get(vitri).getsosachdamuon() - i - 1).getMaSach()
                                                + "' trong sach tham khao khong ton tai!");
                                        System.out.print("Vui long nhap lai ma sach: ");
                                        String masach = sc.next();
                                        ds.get(vitri).getthuvien().get(ds.get(vitri).getsosachdamuon() - i - 1)
                                                .setMaSach(masach);  //set mã sách vừa nhập lại
                                        i =- 1; //duyệt lại từ đầu
                                        continue;
                                    }
                                }
                                if (String.valueOf( 
                                        ds.get(vitri).getthuvien().get(ds.get(vitri).getsosachdamuon() - i - 1).getClass())
                                        .equalsIgnoreCase("class SachKhac")) {   //kiểm tra loại sách
                                    for (int j = 0; j < listsachkhac.size(); j++) {
                                        if (ds.get(vitri).getthuvien().get(ds.get(vitri).getsosachdamuon() - i - 1).getMaSach()
                                                .equals(listsachkhac.get(j).getMaSach())) { //nếu mã sách có trong list sách, check thành true
                                            check = true;
                                        }
                                    }
                                    if (!check) {    //nếu không trùng mã trong list sách, thì nhập lại mã
                                        System.out.println("Sach co ma '" + ds.get(vitri).getthuvien()
                                                .get(ds.get(vitri).getsosachdamuon() - i - 1).getMaSach()
                                                + "' trong sach khac khong ton tai!");
                                        System.out.print("Vui long nhap lai ma sach: ");
                                        String masach = sc.next();
                                        ds.get(vitri).getthuvien().get(ds.get(vitri).getsosachdamuon() - i - 1)
                                                .setMaSach(masach);  //set mã sách vừa nhập lại
                                        i =- 1; //duyệt lại từ đầu
                                        continue;
                                    }
                                }
                            }
                            int dem = ds.get(vitri).getNM().getSosach();    //biến đếm số sách
                            int Sosachdamuon = ds.get(vitri).getsosachdamuon();  //biến số sách mượn
                            for (int i = 0; i < ds.get(vitri).getNM().getSosach(); i++) {
                                if (String.valueOf(
                                        ds.get(vitri).getthuvien().get(Sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachKhac")) { //kiểm tra loại sách
                                    for (int j = 0; j < listsachkhac.size(); j++) {
                                        if (ds.get(vitri).getthuvien().get(Sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachkhac.get(j).getMaSach())) { //kiểm tra còn sách thì trừ số lượng
                                            if (listsachkhac.get(j).soluong > 0) {
                                                listsachkhac.get(j).soluong -= 1;
                                            } else {
                                                System.out.println("Het sach co ma '" + listsachkhac.get(j).getMaSach()
                                                        + "' roi!!!");  //hết sách thì thông báo
                                                ds.get(vitri).getthuvien().remove(Sosachdamuon - i - 1);    //bỏ sách ra khỏi danh sách mượn
                                                ds.get(vitri).setsosachdamuon(ds.get(vitri).getsosachdamuon()-1);    //giảm số sách mượn
                                                dem--;
                                            }
                                        }
                                    }
                                    continue;
                                }
                                if (String.valueOf(
                                        ds.get(vitri).getthuvien().get(Sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachGiaoKhoa")) {  //kiểm tra loại sách
                                    for (int j = 0; j < listsachgiaokhoa.size(); j++) {
                                        if (ds.get(vitri).getthuvien().get(Sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachgiaokhoa.get(j).getMaSach())) { //kiểm tra còn sách thì trừ số lượng
                                            if (listsachgiaokhoa.get(j).soluong > 0) {
                                                listsachgiaokhoa.get(j).soluong -= 1;
                                            } else {
                                                System.out.println("Het sach co ma '"
                                                        + listsachgiaokhoa.get(j).getMaSach() + "' roi!!!");    //hết sách thì thông báo
                                                ds.get(vitri).getthuvien().remove(Sosachdamuon - i - 1);     //bỏ sách ra khỏi danh sách mượn
                                                ds.get(vitri).setsosachdamuon(ds.get(vitri).getsosachdamuon()-1);    //giảm số sách mượn
                                                dem--;
                                            }
                                        }
                                    }
                                    continue;
                                }
                                if (String.valueOf(
                                        ds.get(vitri).getthuvien().get(Sosachdamuon - i - 1).getClass())
                                        .equalsIgnoreCase("class SachThamKhao")) {  //kiểm tra loại sách
                                    for (int j = 0; j < listsachthamkhao.size(); j++) {
                                        if (ds.get(vitri).getthuvien().get(Sosachdamuon - i - 1).getMaSach()
                                                .equals(listsachthamkhao.get(j).getMaSach())) { //kiểm tra còn sách thì trừ số lượng
                                            if (listsachthamkhao.get(j).soluong > 0) {
                                                listsachthamkhao.get(j).soluong -= 1;
                                            } else {
                                                System.out.println("Het sach co ma '"
                                                        + listsachthamkhao.get(j).getMaSach() + "' roi!!!");    //hết sách thì thông báo
                                                ds.get(vitri).getthuvien().remove(Sosachdamuon - i - 1);    //bỏ sách ra khỏi danh sách mượn
                                                ds.get(vitri).setsosachdamuon(ds.get(vitri).getsosachdamuon()-1);     //giảm số sách mượn
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
                                    ds.get(vitri).getngaytra().add(ngaytra);    //thêm ngày trả vào thông người mượn
                                }
                            }
                            System.out.print("Co muon muon tiep khong (1-Yes/2-No): ");
                            s = sc.nextInt();
                        }
                    } while (s == 1);
                    break;
                case "6":   //In danh sach người mượn
                    System.out.println("\t\t\t\t    -------Thong tin nguoi muon--------");
                    ArrayList<Integer> vitri = new ArrayList<Integer>();    //tạo 1 danh sách dạng mảng lưu vị trí
                    if (ds.size() <= 0) {   //kiểm tra xem có người mượn hay không
                        System.out.println("\n\t\t\t\t\t   Khong co nguoi muon!");
                        System.out.print("Nhan Enter de tiep tuc!");    //không có thì thông báo và kết thúc hàm
                        sc.nextLine();
                    } else {
                        int count = 0; //biến đếm
                        for (int i = 0; i < ds.size(); i++) {
                            if (ds.get(i).getngaytra().size() <= 0) {
                                count += 1; //nếu không có ngày trả thì tăng biến đếm
                            } else if (ds.get(i).getngaytra().size() != 0) {
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
                                            ArrayList<Sach> CacSach = ds.get(i).getthuvien();
                                            for (int j = 0; j < CacSach.size(); j++)
                                                for (int k = 0; k < thuvien.size(); k++) {
                                                    if (CacSach.get(j).getMaSach().equals(thuvien.get(k).getMaSach()))
                                                        row.add(Arrays.asList(thuvien.get(k).getMaSach(),
                                                                thuvien.get(k).getTenSach(),
                                                                thuvien.get(k).getNhaXuatBan(),
                                                                String.valueOf(ds.get(i).getngaymuon().get(j)),
                                                                ds.get(i).getngaytra().get(j)));    //add thông tin vào danh sách
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
                    break;
                case "7":   //In danh sach người mượn quá thời hạn
                    long maToday = System.currentTimeMillis(); 
                    Date today = new Date(maToday); //lấy ngày hiện tại
                    System.out.println("\t\t    -------Thong tin nguoi muon qua han--------");
                    List<String> headersList = Arrays.asList("Ho va ten", "So dien thoai", "Dia chi", "Ma the");    //tạo danh sách chứa hàng đầu của bảng
                    List<List<String>> rowsList = new ArrayList<List<String>>();    //tạo danh sách 2 chiều chứa thông tin của bảng
                    ArrayList<TheThuVien> quahan = new ArrayList<TheThuVien>();     //tạo danh sách chứa những người quá hạn
                    ArrayList<Integer> vitri1 = new ArrayList<Integer>();   //tạo danh sách chứa vị trí
                    int index = 0; //biến tạm
                    for (int i = 0; i < ds.size(); i++) {
                        if (ds.get(i).getngaytra().size() != 0) {
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
                        for (int j = 0; j < ds.get(vitri1.get(i)).getngaytra().size(); j++) {   //duyệt những hội viên mượn sách
                            Date date = Date.valueOf(ds.get(vitri1.get(i)).getngaytra().get(j));
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
                                        ArrayList<Sach> CacSach = quahan.get(i).getthuvien();   //tạo biến lưu các sách đã mượn
                                        for (int j = 0; j < CacSach.size(); j++)    //duyệt các sách mượn
                                            for (int k = 0; k < thuvien.size(); k++) {  //duyệt thư viện
                                                if (CacSach.get(j).getMaSach().equals(thuvien.get(k).getMaSach()))  //tìm sách trong thư viện
                                                    row.add(Arrays.asList(thuvien.get(k).getMaSach(),
                                                            thuvien.get(k).getTenSach(),
                                                            thuvien.get(k).getNhaXuatBan(),
                                                            String.valueOf(ds.get(i).getngaymuon().get(j)),
                                                            ds.get(i).getngaytra().get(j), String.valueOf(today)));//add thông tin vào danh sách thông tin
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
                    break;
                case "8":
                    System.out.print("\t\tTam biet!!!!! ");
                    wait(1000);
                    break;
                default:
                    break;
            }
        } while (!chon.equals("8"));
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
