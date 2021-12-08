import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SachKhac extends Sach {
    private String theloai;

    public SachKhac() {
        super();
    }

    public SachKhac(String maSach, String tenSach, String nhaXuatBan, int soLuong, String theloai) {
        super(maSach, tenSach, nhaXuatBan, soLuong);
        this.theloai = theloai;
    }

    public void setTheloai(String theloai) {
        
        this.theloai = theloai;
    }

    public String getTheloai() {
        return this.theloai;
    }

    public void NhapSach() {
        super.NhapSach();
        System.out.print("Nhap the loai cua sach: ");
        scanner.nextLine();
        theloai = scanner.nextLine();
    }

    @Override
    public List<String> InSach() {
        return Arrays.asList(this.maSach, this.tenSach, this.tenNXB, this.theloai, String.valueOf(this.soluong));
    }

    public static void ThongtinSach(ArrayList<SachKhac> listsachkhac)
    {
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
    }
}