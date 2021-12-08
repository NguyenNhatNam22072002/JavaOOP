import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NhanVien extends Person {
    Scanner sc = new Scanner(System.in);

    public NhanVien() {
        super();
    }

    public NhanVien(String hoten, String sdt, String diachi) {
        super(hoten, sdt, diachi);
    }

    public NhanVien(NhanVien n) {
        super(n);
    }
    

    @Override
    public void NhapInfo() {
        System.out.print("Nhap ho ten nhan vien: ");
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

    public static void InNhanVien(ArrayList<NhanVien> listNV)
    {
        Scanner sc = new Scanner(System.in);
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
                                sc.close();
    }
    public static void ThemNhanVien(ArrayList<NhanVien> listNV)
    {
        Scanner sc = new Scanner(System.in); 
            System.out.print("\t\tSo nhan vien can them: ");
                                int nv; 
                                nv = sc.nextInt();
                                for (int i = 0; i < nv; i++) {
                                    System.out.println("\t\t    ----Nhap thong tin nhan vien thu " + (i + 1) + "-----");
                                    NhanVien newNV = new NhanVien();
                                    newNV.NhapInfo();
                                    listNV.add(newNV);
                                }
                                System.out.print("Nhan Enter de tiep tuc!");
                                sc.nextLine();
                                sc.nextLine();
                                sc.close();
    }
}