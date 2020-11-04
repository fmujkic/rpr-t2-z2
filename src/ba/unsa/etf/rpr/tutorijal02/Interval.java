package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double PocetakIntervala, KrajIntervala;
    private boolean poc, kra;


    Interval(double prvi, double drugi, boolean p, boolean d) {
        if (prvi > drugi) throw new IllegalArgumentException("Pogresan unos");

        this.PocetakIntervala = prvi;
        this.KrajIntervala = drugi;
        this.poc = p;
        this.kra = d;
    }

    Interval() {
        this.PocetakIntervala = 0;
        this.KrajIntervala = 0;
        this.poc = false;
        this.kra = false;
    }


    private boolean jednaki(double a, double b){
        return (java.lang.Math.abs(a-b)<0.0001);
    }

    boolean isIn(double k) {
        return (k != PocetakIntervala || poc) && (!(k < PocetakIntervala)) && (k != KrajIntervala || kra) && (!(k > KrajIntervala));
    }

    boolean isNull() {
        return (this.PocetakIntervala == 0 && this.KrajIntervala == 0 && !poc && !kra);
    }

    Interval intersect(Interval pom) {
        if (pom.PocetakIntervala == this.PocetakIntervala && (!pom.poc || !this.poc)) this.poc = false;
        else if (pom.PocetakIntervala > this.PocetakIntervala) {
            this.PocetakIntervala = pom.PocetakIntervala;
            this.poc = pom.poc;
        }

        if (pom.KrajIntervala == this.KrajIntervala && (!pom.kra || !this.kra)) this.kra = false;
        else if (pom.KrajIntervala < this.KrajIntervala) {
            this.KrajIntervala = pom.KrajIntervala;
            this.kra = pom.kra;
        }

        return this;
    }


    static Interval intersect(Interval pom, Interval thi) {
        return pom.intersect(thi);
    }

    boolean equals(Interval pom) {

        return jednaki(this.PocetakIntervala, pom.PocetakIntervala) && jednaki(this.KrajIntervala, pom.KrajIntervala) && this.poc == pom.poc && this.kra == pom.kra;
    }

    public String toString() {

        if (this.isNull()) return "()";


        if (this.poc && this.kra) return "[" + this.PocetakIntervala + "," + this.KrajIntervala + "]";
        else if (!this.poc && this.kra) return "(" + this.PocetakIntervala + "," + this.KrajIntervala + "]";
        else if (this.poc) return "[" + this.PocetakIntervala + "," + this.KrajIntervala + ")";
        else return "(" + this.PocetakIntervala + "," + this.KrajIntervala + ")";

    }

}
