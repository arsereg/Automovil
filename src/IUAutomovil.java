
import java.io.*;

public class IUAutomovil {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Automovil[] autos = new Automovil[1];
    static int autoSelect = 0;
    public static void main(String[] args)throws java.io.IOException{
        autos[0] = new Automovil();
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
            "Digite 2 para Arrancar",
            "Digite 3 para Acelerar",
            "Digite 4 para Frenar",
            "Digite 5 para Detenerse",
            "Digite 6 para Cerrar",
            "Digite 7 para ver el estado del carro",
            "Digite 0 para salir"
        };
        
        for(int i = 0; i < listaMenu.length; i++){
            out.println(listaMenu[i]);
        }
    }
    
    static void realizarAccion(int paccion)throws java.io.IOException{
        if(paccion == 0 || paccion == 1 || paccion == 6 || paccion == 7){
            switch(paccion){
                case 0:
                    desplegarDespedida();
                    break;
                case 1:
                    intentarAbrir();
                    break;
                case 6:
                    cerrar();
                    break;
                case 7:
                    verEstado();
                    break;
            }
        }else{
            if(paccion > 0 && paccion <= 5){
                if(autos[autoSelect].isAbierto()){
                    switch(paccion){
                    case 1:
                        intentarAbrir();
                        break;
                    case 2:
                        intentarArrancar();
                        break;
                    case 3:
                        intentarAcelerar();
                        break;
                    case 4:
                        intentarFrenar();
                        break;
                    case 5:
                        detenerse();
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
        out.println("");
        out.print("Digite la contrasenia para abrir el carro: ");
        String pass = in.readLine();
        boolean seAbrio = autos[autoSelect].abrir(pass);
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
    
    static void intentarArrancar(){
        autos[autoSelect].arrancar();
        out.println();
        out.println("Automovil arrancado");
        out.println();
    }
    
    static void intentarAcelerar(){
        autos[autoSelect].acelerar();
        out.println();
        out.println("Acelerando");
        out.println();
    }
    
    static void intentarFrenar(){
        autos[autoSelect].frenar();
        out.println();
        out.println("Frenando");
        out.println();
    }
    
    static void detenerse(){
        autos[autoSelect].detener();
        out.println();
        out.println("Auto Detenido");
        out.println();
    }
    
    static void cerrar(){
        autos[autoSelect].cerrar();
        out.println();
        out.println("El auto se ha detenido.");
        out.println("El auto se ha apagado");
        out.println("El auto se ha cerrado");
        out.println();
    }
    
    static void verEstado(){
        out.println();
        out.println(autos[autoSelect]);
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
}
