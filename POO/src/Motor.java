public class Motor {

    private int cilindraje;
    private  TipoMotor tipo;

    public Motor() {
    }

    public Motor(int cilindraje, TipoMotor tipo) {
        this.cilindraje = cilindraje;
        this.tipo = tipo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public TipoMotor getTipo() {
        return tipo;
    }

    public void setTipo(TipoMotor tipo) {
        this.tipo = tipo;
    }
}
