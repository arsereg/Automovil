
public class Automovil {

    private String modelo;
    private String placa;
    private String serie;
    private String marca;
    private boolean encendido;
    private boolean abierto;
    private boolean arrancado;
    private String contrasenia;
    private int velocidad;
    public static int MAX_VELOCIDAD = 120;
    static int enumeradorCarro = 1;
    
    /**
     * @return the MAX_VELOCIDAD
     */
    public static int getMAX_VELOCIDAD() {
        return MAX_VELOCIDAD;
    }
    
    public Automovil(){
        modelo = "";
        placa = "";
        setSerie();
        marca = "";
        encendido = false;
        abierto = false;
        arrancado = false;
        velocidad = 0;
        contrasenia = "123";
    }
    
    public Automovil(String pmodelo, String pplaca, String pmarca){
        modelo = pmodelo;
        placa = pplaca;
        setSerie();
        marca = pmarca;
        encendido = false;
        abierto = false;
        arrancado = false;
        velocidad = 0;
        contrasenia = "123";
    }
    
    public Automovil(String pplaca){
        modelo = "";
        placa = pplaca;
        setSerie();
        marca = "";
        encendido = false;
        abierto = false;
        arrancado = false;
        velocidad = 0;
        contrasenia = "123";
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    private void setSerie() {
        this.serie = generarSerial();
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the encendido
     */
    public boolean isEncendido() {
        return encendido;
    }

    /**
     * @param encendido the encendido to set
     */
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    /**
     * @return the abierto
     */
    public boolean isAbierto() {
        return abierto;
    }

    /**
     * @param abierto the abierto to set
     */
    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    /**
     * @return the arrancado
     */
    public boolean isArrancado() {
        return arrancado;
    }

    /**
     * @param arrancado the arrancado to set
     */
    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }

    /**
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        if(velocidad <= 0){
            setArrancado(false);
        }
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String ppass) {
        this.contrasenia = ppass;
    }
    
    static int getEnumerador(){
        int resul = enumeradorCarro;
        return resul;
    }
    
    private String generarSerial(){
        Automovil serializador = null;
        int numSerie = serializador.getEnumerador();
        String resul = "SC-" + numSerie;
        enumeradorCarro++;
        return resul;
    }
    
    private int getVelMax(){
        int resul = MAX_VELOCIDAD;
        return resul;
    }
    
    public String toString(){
        String model = "Modelo: " + modelo;
        String plate = "Placa: " + placa;
        String serialNum = "Serie: " +serie;
        String brand = "Marca:" + marca;
        String on = "Encendido: " + encendido;
        String open = "Abierto: " + abierto;
        String driving = "Arrancado:" + arrancado;
        String pass = "Contrasenia: " + contrasenia;
        String speed = "Velocidad: " + velocidad;
        String resul = model + "\n" + plate + "\n" + serialNum + "\n" + brand + "\n" + on + "\n" + open + "\n" + driving + "\n" + pass + "\n" + speed;
        return resul;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*Comienza lógica de negocio*/
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void encender(){
        if(isAbierto()){
            if(!isEncendido()){
                setEncendido(true);
            }
        }
    }
    
    public void apagar(){
        if(isAbierto()){
            if(isEncendido()){
                detener();
                setEncendido(false);
            }
        }
    }
    
    public void arrancar(){
        if(isAbierto()){
            if(isEncendido()){
                if(!isArrancado()){
                    setArrancado(true);
                    acelerar();
                }
            }
        }
    }
    
    public void acelerar(){
        if(isAbierto()){
            if(isArrancado()){
                int incremento = 5;
                int velActual = getVelocidad();
                int nuevaVel = velActual + incremento;
                int maxVel = this.getVelMax();
                if(nuevaVel > maxVel){
                    nuevaVel = maxVel;
                }
                if(nuevaVel > velActual){
                    setVelocidad(nuevaVel);
                }
            }
        }
    }
    
    public void frenar(){
        if(isAbierto()){
            int velActual = getVelocidad();
            int indiceFrenado = 5;
            int nuevaVel = 0;
            if(velActual >= indiceFrenado){
                nuevaVel = velActual - indiceFrenado;
            }
            if(nuevaVel < 0){
                nuevaVel = 0;
            }
            setVelocidad(nuevaVel);
        }
    }
    
    public void detener(){
        if(isAbierto()){
            setVelocidad(0);
        }
    }
    
    public boolean abrir(String ppass){
        boolean seAbrio = ppass.equals(contrasenia);
        if(seAbrio){
            setAbierto(true);
        }
        return seAbrio;
    }
    
    public void cerrar(){
        if(isAbierto()){
            apagar();
            setAbierto(false);
        }
    }
    
}
