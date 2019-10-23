package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetni, krajnji;
    private boolean poc, kra;


    Interval(double prvi, double drugi, boolean p, boolean d) {
        if (prvi > drugi) throw new IllegalArgumentException("Pogresan unos");

        this.pocetni = prvi;
        this.krajnji = drugi;
        this.poc = p;
        this.kra = d;
    }

    Interval() {
        this.pocetni = 0;
        this.krajnji = 0;
        this.poc = false;
        this.kra = false;
    }


    private boolean jednaki(double a, double b){
        return (java.lang.Math.abs(a-b)<0.0001);
    }

    boolean isIn(double k) {
        return (k != pocetni || poc) && (!(k < pocetni)) && (k != krajnji || kra) && (!(k > krajnji));
    }

    boolean isNull() {
        return (this.pocetni == 0 && this.krajnji == 0 && !poc && !kra);
    }

    Interval intersect(Interval pom) {
        if (pom.pocetni == this.pocetni && (!pom.poc || !this.poc)) this.poc = false;
        else if (pom.pocetni > this.pocetni) {
            this.pocetni = pom.pocetni;
            this.poc = pom.poc;
        }

        if (pom.krajnji == this.krajnji && (!pom.kra || !this.kra)) this.kra = false;
        else if (pom.krajnji < this.krajnji) {
            this.krajnji = pom.krajnji;
            this.kra = pom.kra;
        }

        return this;
    }


    static Interval intersect(Interval pom, Interval thi) {
        return pom.intersect(thi);
    }

    boolean equals(Interval pom) {

        return jednaki(this.pocetni, pom.pocetni) && jednaki(this.krajnji, pom.krajnji) && this.poc == pom.poc && this.kra == pom.kra;
    }

    public String toString() {

        if (this.isNull()) return "()";


        if (this.poc && this.kra) return "[" + this.pocetni + "," + this.krajnji + "]";
        else if (!this.poc && this.kra) return "(" + this.pocetni + "," + this.krajnji + "]";
        else if (this.poc) return "[" + this.pocetni + "," + this.krajnji + ")";
        else return "(" + this.pocetni + "," + this.krajnji + ")";

    }

}
