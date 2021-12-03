/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidenciajava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alan Franco
 */
public class EvidenciaJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        ArrayList<Cita> citas = new ArrayList<Cita>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;
        boolean volver = false;
        int opcion, opcion2;
        
        while(!salir){
            //leer CSV
            volver = false;
            System.out.println("------CITAS CONSULTORIO------\n");
            System.out.println("Elija una opcion:");
            System.out.println("1. Doctores");
            System.out.println("2. Pacientes");
            System.out.println("3. Citas");
            System.out.println("0. Salir");            
            try{
                opcion = Integer.parseInt(br.readLine());
            }catch(Exception e){
                opcion = -1;
                System.out.println("Opcion no valida ->" + e);
            }
            switch(opcion){
                case 1:{
                    while(!volver){
                        System.out.println("---DOCTORES---\n");
                        System.out.println("Elija una opcion:");
                        System.out.println("1.Imprimir lista de doctores");
                        System.out.println("2. Agregar doctor");
                        System.out.println("3. Eliminar doctor");
                        System.out.println("0. Volver");
                        try{
                            opcion2 = Integer.parseInt(br.readLine());
                        }catch(Exception e){
                            opcion2 = -1;
                            System.out.println("Opcion no valida ->" + e);
                        }
                        switch(opcion2){
                            case 1:{
                                for (int i = 0; i < doctores.size(); i++) {
                                    System.out.println(doctores.get(i));
                                }
                                continuar();
                                break;
                            }
                            
                            case 2:{
                                System.out.println("Ingrese ID del nuevo doctor");
                                String id = br.readLine();
                                boolean existe = false;
                                for (int i = 0; i < doctores.size(); i++) {
                                    if(doctores.get(i).getId().equals(id))
                                        existe = true;
                                }
                                if(existe){
                                    System.out.println("Ya existe un doctor con ese ID");
                                }else{
                                    System.out.println("Ingrese el nombre del nuevo doctor");
                                    String nom = br.readLine();
                                    System.out.println("Ingrese la especialidad del nuevo doctor");
                                    String esp = br.readLine();
                                    doctores.add(new Doctor(id, nom, esp));
                                    System.out.println("Nuevo doctor agregado correctamente");
                                }
                                continuar();
                                break;
                            }
                            
                            case 3:{
                                System.out.println("Ingrese ID del doctor a eliminar");
                                String id = br.readLine();
                                boolean existe = false;
                                for (int i = 0; i < doctores.size(); i++) {
                                    if(doctores.get(i).getId().equals(id)){
                                        existe = true;
                                        doctores.remove(i);
                                        System.out.println("Doctor eliminado correctamente");
                                        break;
                                    }
                                }
                                if(!existe){
                                    System.out.println("No existe un doctor con ese ID");
                                }
                                continuar();
                                break;
                            }
                            
                            case 0:{
                                volver = true;
                                break;
                            }
                            
                            default:{
                                System.out.println("Ingrese una opcion valida, por favor");
                                continuar();
                            }
                        }
                    }
                    break;
                }
                
                case 0:{
                    salir = true;
                    break;
                }
                
                default:{
                    System.out.println("Ingrese una opcion valida, por favor");
                    continuar();
                }
            }
        }
        
        
        
    }
    
    public static void continuar(){
        System.out.println("Pulse una tecla para continuar...");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }
    
}
