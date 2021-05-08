public class Rueda {

    private String fabricante;
    private int rin;
    private int ancho;



    public Rueda(String fabricante, int rin, int ancho) {
        this.fabricante = fabricante;
        this.rin = rin;
        this.ancho = ancho;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getRin() {
        return rin;
    }

    public int getAncho() {
        return ancho;
    }
}
