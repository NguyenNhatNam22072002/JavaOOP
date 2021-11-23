@FunctionalInterface
interface Say{
    void say();
} 
public class Main {
	public static void main(String[] args) {
        DongVat[] dv = new DongVat[5];
        dv[0] = new ConBo("Bo sua Vinamilk");
        dv[1] = new ConDe("De nui");
        dv[2] = new ConSoi("Soi xam");
        dv[3] = new ConHo("Ho rang kiem");
        dv[4] = new ConBo("Bo sua Ha Lan");
        for (DongVat dongVat : dv) {            //Giới thiệu các con vật
            System.out.println("Toi ten la: " + dongVat.getTen());
            dongVat.an();
            dongVat.keu();
        }
        Say s = () -> {System.out.println("Chung toi la Dong Vat!!!");};
        s.say();
    }
}





