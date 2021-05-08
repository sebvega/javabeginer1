public class Automovil implements  Comparable<Automovil>{

    //variables
    private int id;
    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS;
    private Motor motor;
    private Tanque tanqueComb;
    private Persona propietario;
    private Rueda[] ruedas;
    private int indiceRuedas;

    private TipoAutomovil tipo;


    public static final String COLOR_ROJO = "Rojo";
    public static final String COLOR_AMARILLO = "Amarillo";
    public static final String COLOR_AZUL = "Azul";
    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_GRIS = "Gris";


    private static int capacidadTanqueEstatico = 30;
    private static Color colorPatenete = Color.NARANJA;
    private static int ultimoId;


    public static final Integer VEL_MAX_CARRETERA = 100;
    public static final int VEL_MAX_CIUDAD = 60;

    //constructores
    public Automovil() {
        this.id = ++ultimoId;
        this.ruedas = new Rueda[5];
    }

    public Automovil(String fabricante, String modelo) {
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color) {
        this(fabricante, modelo);
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor) {
        this(fabricante, modelo, color);
        this.motor = motor;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Tanque tanqueComb) {
        this(fabricante, modelo, color, motor);
        this.tanqueComb = tanqueComb;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Tanque tanqueComb, Persona propietario, Rueda[] ruedas) {
        this(fabricante, modelo, color, motor, tanqueComb);
        this.propietario = propietario;
        this.ruedas = ruedas;
    }
    //fin constructores

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public static Color getColorPatenete() {
        return colorPatenete;
    }

    public static void setColorPatenete(Color colorPatenete) {
        Automovil.colorPatenete = colorPatenete;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static int getCapacidadTanqueEstatico() {
        return capacidadTanqueEstatico;
    }

    public static void setCapacidadTanqueEstatico(int capacidadTanqueEstatico) {
        Automovil.capacidadTanqueEstatico = capacidadTanqueEstatico;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Tanque getTanqueComb() {
        return tanqueComb;
    }

    public void setTanqueComb(Tanque tanqueComb) {
        this.tanqueComb = tanqueComb;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public Automovil addRueda(Rueda rueda) {
        if (indiceRuedas < this.ruedas.length) {
            this.ruedas[indiceRuedas++] = rueda;
        }
        return this;
    }


    public String detalle() {
        String sb = "auto.id = " + this.id +
                "\nauto.fabricante = " + this.fabricante +
                "\nauto.modelo = " + this.modelo;
        if (this.getTipo()!=null) {
            sb = "\nauto.tipo = " + this.getTipo().getDescripcion();
        }
        sb = "\nauto.color = " + this.color +
                "\nauto.cilindraje = " + this.motor.getCilindraje() +
                "\nauto.colorPatente =" + this.colorPatenete;
        return sb;
    }

    public String acelerar(int rpm) {

        return "el auto " + fabricante + " acelerando a " + rpm + " rpm";
    }

    public String frenar() {
        return fabricante + " " + modelo + " frenando";
    }

    public String acelerarFrenar(int rpm) {
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }

    public double calcularConsumo(int km, float porcentajeGastado) {
        return km / (this.tanqueComb.getCapacidad() * porcentajeGastado);
    }

    public static float calcularConsumoEstatico(int km, float porcentajeGastado) {
        return km / (Automovil.capacidadTanqueEstatico * porcentajeGastado);
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }
        if (!(obj instanceof Automovil)) {
            return false;
        }
        Automovil a = (Automovil) obj;
        return (this.fabricante!=null && this.modelo!=null &&
                this.fabricante.equals(a.getFabricante())
                && this.modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {

        return this.id + " : " + fabricante + " " + modelo;
/*        String detalle = "Automovil{" +
                "id='" + id + '\'' +
                ", fabricante='" + this.getFabricante() + '\'' +
                ", modelo='" + this.getModelo() + '\'';
        if (this.getTipo()!=null) {

            detalle += ", Tipo=" + this.getTipo().getDescripcion() + '\'';
        }
        detalle += ", color='" + this.color + '\'' +
                ", cilindraje=" + motor +
                ", capacidadTanque=" + tanqueComb +
                '}';

        return detalle;*/
    }

    @Override
    public int compareTo(Automovil a) {
        return this.fabricante.compareTo(a.fabricante);
    }
}
