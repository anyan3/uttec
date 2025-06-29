package gestionBD;

public class Pojoregistrop {
    private int id;  // Campo id
    private String usr;
    private String app;
    private String apm;
    private String mat;
    private String cor;
    private String contra;

    // Constructor
    public Pojoregistrop(int id, String usr, String app, String apm, String mat, String cor, String contra) {
        this.id = id;  // Inicialización del campo id
        this.usr = usr;
        this.app = app;
        this.apm = apm;
        this.mat = mat;
        this.cor = cor;
        this.contra = contra;
    }

    // Getter y Setter para id
    public int getId() {
        return id;  // Método que devuelve el id
    }

    public void setId(int id) {
        this.id = id;  // Método que asigna el valor del id
    }

    // Getters y setters para otros campos
    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}
