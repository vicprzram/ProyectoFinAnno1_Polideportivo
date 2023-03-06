package script_log;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.nio.file.Path;
import java.nio.file.Paths;

public class log{
    private static final File file = new File("log.log");
    private static Scanner scanner = new Scanner(System.in);
    private static Path path = Paths.get("log.log");
    public static void main(String[] args){
        //Errores de fichero
        checkFile();

        //Inserciones a fichero
        insertFile();

        scanner.close();
    }

    private static void checkFile() {
        String mensaje;
        try{
            if(file.exists() == false){
                file.createNewFile();
                System.out.println("[INFO]: El archivo no existe, creando uno nuevo...");
                System.out.println("[INFO]: Archivo creado en: " + file.getPath());

                mensaje = "[INFO]: Archivo creado el: " + LocalDate.now() + " a las: " + LocalTime.now();
                Files.write(path, mensaje.getBytes(), StandardOpenOption.APPEND);

            }else{
                System.out.println("[INFO]: Archivo existente en: " + file.getPath());
            }
            System.out.println("[INFO]: El programa puede escribir: " + ((file.canWrite()) ? "Si" : "No"));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void insertFile(){
        try{
            String user;
            String description;

            user = getUser();
            description = getDescripton();

            String mensaje = "\n[!] " + user + ": " + description + " realizado el: (" +  LocalDate.now() + " - " + LocalTime.now() + ")";
            Files.write(path, mensaje.getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static String getUser(){
        String user = "";
        int userInput;
        boolean finish = false;
        
        System.out.println("\nUsuarios disponibles:\n1 - Daniel Gallo\n2 - Raul\n3 - Dani Rodriguez\n4 - Victor");
        while(finish != true){

            System.out.print("Usuario: ");

            userInput = Integer.parseInt(scanner.nextLine());

            switch(userInput){
                case 1:
                    user = "Daniel Gallo";
                    finish = true;
                    break;
                case 2:
                    user = "Raul";
                    finish = true;
                    break;
                case 3:
                    user = "Dani Rodriguez";
                    finish = true;
                    break;
                case 4:
                    user = "Victor";
                    finish = true;
                    break;
                default:
                    System.out.println("[ERROR]: Usuario no valido, vuelva a intentar");
                    break;
            }
        }

        return user;
    }

    private static String getDescripton(){
        String description = "";
        final int MAX_LENGTH = 50;
        boolean finish = false;

        System.out.println("\nMaxima longitud de descripcion: 50 caracteres");
        
        while(finish != true){
            System.out.print("Descripcion: ");
            description = scanner.nextLine();

            if(description.length() > MAX_LENGTH){
                System.out.println("[ERROR]: La descripcion es desmasiado larga, intente de nuevo");
            }else{
                finish = true;
            }
        }

        return description;
    }
}