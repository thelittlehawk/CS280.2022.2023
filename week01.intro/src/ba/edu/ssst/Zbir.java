package ba.edu.ssst;

public class Zbir {
    private int broja;
    private int brojb;

    Zbir(int broja, int brojb) {
        this.broja = broja;
        this.brojb = brojb;
    }

    public int getA() {
        return broja;
    }

    public int getB() {
        return brojb;
    }

    public void setA(int broja) {
        if(broja < 0) return;
        this.broja = broja;
    }

    public int saberi() {
        int brojaTmp = broja + 10;
        int brojbTmp = brojb - 10;
        return broja + this.brojb;
    }
}
