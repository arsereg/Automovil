
import java.io.*;
import java.util.*;

public class IUAutomovil {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static ArrayList<Automovil> autos = new ArrayList<Automovil>();
    static int autoSelect = 0;
    public static void main(String[] args)throws java.io.IOException{
        autos.add(new Automovil());
        int accion = -1;
        do{
            mostrarMenu();
            accion = Integer.parseInt(in.readLine());
            if(accion != 0){
                realizarAccion(accion);
            }
        }while(accion != 0);
    }
    
    static void mostrarMenu(){
        String[] listaMenu = {
            "Digite 1 para Abrir",
            "Digite 2 para Encender el automovil",
            "Digite 3 para Arrancar",
            "Digite 4 para Acelerar",
            "Digite 5 para Frenar",
            "Digite 6 para Detenerse",
            "Digite 7 para Apagar",
            "Digite 8 para Cerrar",
            "Digite 9 para ver el estado del carro",
            "Digite 10 para ingresar el modelo del automovil",
            "Digite 11 para conocer el modelo del automovil",
            "Digite 12 para ingresar la placa del automovil",
            "Digite 13 para conocer la placa del automovil",
            "Digite 14 para ingresar la marca del automovil",
            "Digite 15 para conocer la marca del automovil",
            "Digite 16 para conocer el número de serie del automovil",
            "Digite 0 para salir"
        };
        
        for(int i = 0; i < listaMenu.length; i++){
            out.println(listaMenu[i]);
        }
    }
    
    static void realizarAccion(int paccion)throws java.io.IOException{
        if(paccion == 0 || paccion == 1 || paccion == 8 || paccion == 9){
            switch(paccion){
                case 0:
                    desplegarDespedida();
                    break;
                case 1:
                    intentarAbrir();
                    break;
                case 8:
                    cerrar();
                    break;
                case 9:
                    verEstado();
                    break;
            }
        }else{
            if(paccion > 0 && paccion <= 16){
                if(autos.get(autoSelect).isAbierto()){
                    switch(paccion){
                    case 2:
                        intentarEncender();
                        break;
                    case 3:
                        intentarArrancar();
                        break;
                    case 4:
                        intentarAcelerar();
                        break;
                    case 5:
                        intentarFrenar();
                        break;
                    case 6:
                        detenerse();
                        break;
                    case 7:
                        intentarApagar();
                        break;
                    case 8:
                        cerrar();
                        break;
                    case 9:
                        verEstado();
                        break;
                    case 10:
                        ingresarModelo();
                        break;
                    case 11:
                        conocerModelo();
                        break;
                    case 12:
                        ingresarPlaca();
                        break;
                    case 13:
                        conocerPlaca();
                        break;
                    case 14:
                        ingresarMarca();
                        break;
                    case 15:
                        conocerMarca();
                        break;
                    case 16:
                        conocerNumSerie();
                        break;
                    }
                }else{
                    out.println();
                    out.println("El automovil debe estar abierto para realizar esa accion");
                    out.println();
                }
            }else{
                desplegarErrorInvalido();
            }
        }
    }
    
    static void intentarAbrir()throws java.io.IOException{
        if(autos.get(autoSelect).isAbierto()){
            out.println("El automovil ya está abierto");
        }else{
            out.println("");
            out.print("Digite la contrasenia para abrir el carro: ");
            String pass = in.readLine();
            boolean seAbrio = autos.get(autoSelect).abrir(pass);
            if(seAbrio){
                out.println();
                out.println("El automovil se ha abierto. Puede comenzar a conducir");
                out.println();
            }else{
                out.println();
                out.println("Contrasenia invalida. Intentelo de nuevo");
                out.println();
            }
        }
    }
    
    static void intentarArrancar(){
        if(!autos.get(autoSelect).isArrancado()){
            autos.get(autoSelect).arrancar();
            out.println();
            out.println("Automovil arrancado");
            out.println();
        }else{
            out.println("El automovil ya está arrancado");
        }
    }
    
    static void intentarEncender(){
        if(!autos.get(autoSelect).isEncendido()){
            autos.get(autoSelect).encender();
            out.println();
            out.println("Automovil encendido");
        }else{
            out.println("El automovil ya está encendido");
        }
    }
    
    static void intentarAcelerar(){
        if(autos.get(autoSelect).isArrancado()){
            autos.get(autoSelect).acelerar();
            out.println();
            out.println("Acelerando. Velocidad actual: " + autos.get(autoSelect).getVelocidad());
            out.println();
        }else{
            out.println();
            out.println("El automovil no ha arrancado. Por favor arranquelo antes de acelerar");
        }
    }
    
    static void intentarFrenar(){
        autos.get(autoSelect).frenar();
        out.println();
        out.println("Frenando. Velocidad actual " + autos.get(autoSelect).getVelocidad());
        out.println();
    }
    
    static void intentarApagar(){
        if(autos.get(autoSelect).isEncendido()){
           autos.get(autoSelect).apagar();
           out.println("");
           out.println("El automovil se ha apagado");
        }else{
            out.println("El automovil ya está apagado.");
        }
    }
    
    static void detenerse(){
        autos.get(autoSelect).detener();
        out.println();
        out.println("Auto Detenido");
        out.println();
    }
    
    static void cerrar(){
        autos.get(autoSelect).cerrar();
        out.println();
        out.println("El auto se ha detenido.");
        out.println("El auto se ha apagado");
        out.println("El auto se ha cerrado");
        out.println();
    }
    
    static void verEstado(){
        out.println();
        out.println(autos.get(autoSelect));
        out.println();
    }
    
    static void desplegarDespedida(){
        out.println();
        out.println("Gracias por usar nuestro servicio. Hasta pronto");
    }
    
    static void desplegarErrorInvalido(){
        out.println("Esa no es una opcion valida. Por favor intentelo de nuevo");
        out.println();
    }
    
    static void ingresarModelo()throws java.io.IOException{
        out.println();
        out.print("Escriba el modelo del automovil: ");
        String mod = in.readLine();
        autos.get(autoSelect).setModelo(mod);
    }
    
    static void ingresarPlaca()throws java.io.IOException{
        out.println();
        out.print("Ingrese el numero de placa del automovil: ");
        String plate = in.readLine();
        autos.get(autoSelect).setPlaca(plate);
    }
    
    static void ingresarMarca()throws java.io.IOException{
        out.println();
        out.print("Ingrese la marca del automovil: ");
        String marca = in.readLine();
        autos.get(autoSelect).setMarca(marca);
    }
    
    static void conocerModelo(){
        String modelo = autos.get(autoSelect).getModelo();
        String msj = "Modelo del automovil: " + modelo;
        out.println();
        out.println(msj);
    }
    static void conocerPlaca(){
        String plate = autos.get(autoSelect).getModelo();
        String msj = "Placa del automovil: " + plate;
        out.println();
        out.println(msj);
    
    }
    static void conocerMarca(){
        String marca = autos.get(autoSelect).getModelo();
        String msj = "Marca: " + marca;
        out.println();
        out.println(msj);
    }
    static void conocerNumSerie(){
        String numSerie = autos.get(autoSelect).getSerie();
        String msj = "Numero de serie: " + numSerie;
        out.println();
        out.println(msj);
    }
}
