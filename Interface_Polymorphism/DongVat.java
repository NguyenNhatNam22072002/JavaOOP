interface An{
    void an();
}

interface Keu{
    void keu();
}

public class DongVat implements An, Keu{
    private String ten;
    public String getTen()
    {
        return this.ten;
    }
    public void setTen(String ten)
    {
        this.ten = ten;
    }
    public DongVat()
    {
        this.ten = "";
    }
    public DongVat(String ten)
    {
        this.ten = ten;
    }
    public void an() { }
    public void keu() { }
}

