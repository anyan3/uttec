package gestionBD;

public class Pojoconvocatoria {
private int idc;
private String visas;
private String pasaportes;
private String cert;
private String nil;
private String cuatri;
private double prom1;

    public Pojoconvocatoria(int idc, String visas, String pasaportes, String cert, String nil, String cuatri, double prom1) {
        this.idc = idc;
        this.visas = visas;
        this.pasaportes = pasaportes;
        this.cert = cert;
        this.nil = nil;
        this.cuatri = cuatri;
        this.prom1 = prom1;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getVisas() {
        return visas;
    }

    public void setVisas(String visas) {
        this.visas = visas;
    }

    public String getPasaportes() {
        return pasaportes;
    }

    public void setPasaportes(String pasaportes) {
        this.pasaportes = pasaportes;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getNil() {
        return nil;
    }

    public void setNil(String nil) {
        this.nil = nil;
    }

    public String getCuatri() {
        return cuatri;
    }

    public void setCuatri(String cuatri) {
        this.cuatri = cuatri;
    }

    public double getProm1() {
        return prom1;
    }

    public void setProm1(double prom1) {
        this.prom1 = prom1;
    }

}
