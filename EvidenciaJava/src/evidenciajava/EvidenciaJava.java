/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidenciajava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
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
        
        //Leer datos guardados
        File archivodoc = new File("Doctores.csv");
        if(archivodoc.isFile()){
            Scanner lectordoc = new Scanner(archivodoc);
            lectordoc.useDelimiter(",");
            while(lectordoc.hasNext()){
                String[] datosdoc = lectordoc.nextLine().split(",");
                doctores.add(new Doctor(datosdoc[0], datosdoc[1], datosdoc[2]));
            }
            lectordoc.close();
        }else{
            System.out.println("No hay un registro de doctores, creando nuevo registro...");
        }
        
        File archivopac = new File("Pacientes.csv");
        if(archivopac.isFile()){
            Scanner lectorpac = new Scanner(archivopac);
            lectorpac.useDelimiter(",");
            while(lectorpac.hasNext()){
                String[] datospac = lectorpac.nextLine().split(",");
                pacientes.add(new Paciente(datospac[0], datospac[1]));
            }
            lectorpac.close();
        }else{
            System.out.println("No hay un registro de pacientes, creando nuevo registro...");
        }
        
        File archivocita = new File("Citas.csv");
        if(archivocita.isFile()){
            Scanner lectorcita = new Scanner(archivocita);
            lectorcita.useDelimiter(",");
            while(lectorcita.hasNext()){
                String[] datoscita = lectorcita.nextLine().split(",");
                int indexdoc = -1;
                for (int i = 0; i < doctores.size(); i++) {
                    if(doctores.get(i).getId().equals(datoscita[3])){
                        indexdoc = i;
                    } 
                }
                int indexpac = -1;
                for (int i = 0; i < pacientes.size(); i++) {
                    if(pacientes.get(i).getId().equals(datoscita[4])){
                        indexpac = i;
                    } 
                }
                //citas.add(new Cita(datospac[0], datospac[1]));
                citas.add(new Cita(datoscita[0], datoscita[1], datoscita[2], doctores.get(indexdoc), pacientes.get(indexpac)));
            }
            lectorcita.close();
        }else{
            System.out.println("No hay un registro de citas, creando nuevo registro...");
        }
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;
        boolean volver = false;
        int opcion, opcion2;
        
        while(!salir){
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
                    volver = false;
                    while(!volver){
                        System.out.println("---DOCTORES---\n");
                        System.out.println("Elija una opcion:");
                        System.out.println("1. Imprimir lista de doctores");
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
                
                case 2:{
                    volver = false;
                    while(!volver){
                        System.out.println("---PACIENTES---\n");
                        System.out.println("Elija una opcion:");
                        System.out.println("1. Imprimir lista de pacientes");
                        System.out.println("2. Agregar paciente");
                        System.out.println("3. Eliminar paciente");
                        System.out.println("0. Volver");
                        try{
                            opcion2 = Integer.parseInt(br.readLine());
                        }catch(Exception e){
                            opcion2 = -1;
                            System.out.println("Opcion no valida ->" + e);
                        }
                        switch(opcion2){
                            case 1:{
                                for (int i = 0; i < pacientes.size(); i++) {
                                    System.out.println(pacientes.get(i));
                                }
                                continuar();
                                break;
                            }
                            
                            case 2:{
                                System.out.println("Ingrese ID del nuevo paciente");
                                String id = br.readLine();
                                boolean existe = false;
                                for (int i = 0; i < pacientes.size(); i++) {
                                    if(pacientes.get(i).getId().equals(id))
                                        existe = true;
                                }
                                if(existe){
                                    System.out.println("Ya existe un paciente con ese ID");
                                }else{
                                    System.out.println("Ingrese el nombre del nuevo paciente");
                                    String nom = br.readLine();
                                    pacientes.add(new Paciente(id, nom));
                                    System.out.println("Nuevo paciente agregado correctamente");
                                }
                                continuar();
                                break;
                            }
                            
                            case 3:{
                                System.out.println("Ingrese ID del paciente a eliminar");
                                String id = br.readLine();
                                boolean existe = false;
                                for (int i = 0; i < pacientes.size(); i++) {
                                    if(pacientes.get(i).getId().equals(id)){
                                        existe = true;
                                        pacientes.remove(i);
                                        System.out.println("Paciente eliminado correctamente");
                                        break;
                                    }
                                }
                                if(!existe){
                                    System.out.println("No existe un paciente con ese ID");
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
                
                case 3:{
                    volver = false;
                    while(!volver){
                        System.out.println("---CITAS---\n");
                        System.out.println("Elija una opcion:");
                        System.out.println("1. Imprimir citas existentes");
                        System.out.println("2. Agregar cita");
                        System.out.println("3. Eliminar cita");
                        System.out.println("0. Volver");
                        try{
                            opcion2 = Integer.parseInt(br.readLine());
                        }catch(Exception e){
                            opcion2 = -1;
                            System.out.println("Opcion no valida ->" + e);
                        }
                        switch(opcion2){
                            case 1:{
                                for (int i = 0; i < citas.size(); i++) {
                                    System.out.println(citas.get(i));
                                }
                                continuar();
                                break;
                            }
                            
                            case 2:{
                                System.out.println("Ingrese ID de la nueva cita");
                                String id = br.readLine();
                                boolean existe = false;
                                for (int i = 0; i < citas.size(); i++) {
                                    if(citas.get(i).getId().equals(id))
                                        existe = true;
                                }
                                if(existe){
                                    System.out.println("Ya existe una cita con ese ID");
                                }else{
                                    System.out.println("Ingrese el motivo de la cita");
                                    String mot = br.readLine();
                                    System.out.println("Ingrese la fecha de la cita");
                                    String fecha = br.readLine();
                                    System.out.println("Ingrese el ID del doctor");
                                    String iddoc = br.readLine();
                                    boolean existedoc = false;
                                    int indexdoc = -1;
                                    for (int i = 0; i < doctores.size(); i++) {
                                        if(doctores.get(i).getId().equals(iddoc)){
                                            existedoc = true;
                                            indexdoc = i;
                                        } 
                                    }
                                    System.out.println("Ingrese el ID del paciente");
                                    String idpac = br.readLine();
                                    boolean existepac = false;
                                    int indexpac = -1;
                                    for (int i = 0; i < pacientes.size(); i++) {
                                        if(pacientes.get(i).getId().equals(idpac)){
                                            existepac = true;
                                            indexpac = i;
                                        } 
                                    }
                                    if(existedoc && existepac){
                                        citas.add(new Cita(id, mot, fecha, doctores.get(indexdoc), pacientes.get(indexpac)));
                                        System.out.println("Nueva cita agregada correctamente");
                                    }else{
                                        System.out.println("Error: ID de doctor o paciente no validos");
                                    }
                                }
                                continuar();
                                break;
                            }
                            
                            case 3:{
                                System.out.println("Ingrese ID de la cita a eliminar");
                                String id = br.readLine();
                                boolean existe = false;
                                for (int i = 0; i < citas.size(); i++) {
                                    if(citas.get(i).getId().equals(id)){
                                        existe = true;
                                        citas.remove(i);
                                        System.out.println("Cita eliminada correctamente");
                                        break;
                                    }
                                }
                                if(!existe){
                                    System.out.println("No existe una cita con ese ID");
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
                    //Guardar doctores
                    FileWriter escritordoc = new FileWriter("Doctores.csv");
                    for (int i = 0; i < doctores.size(); i++) {
                        String guardardoc = doctores.get(i).getId() + "," + doctores.get(i).getNombre() + "," + doctores.get(i).getEspecialidad() + "\n";
                        escritordoc.write(guardardoc);
                        escritordoc.flush();
                    }
                    System.out.println("Lista de doctores guardada");
                    escritordoc.close();
                    
                    //Guardar pacientes
                    FileWriter escritorpac = new FileWriter("Pacientes.csv");
                    for (int i = 0; i < pacientes.size(); i++) {
                        String guardarpac = pacientes.get(i).getId() + "," + pacientes.get(i).getNombre() + "\n";
                        escritorpac.write(guardarpac);
                        escritorpac.flush();
                    }
                    System.out.println("Lista de pacientes guardada");
                    escritorpac.close();
                    
                    //Guardar citas
                    FileWriter escritorcita = new FileWriter("Citas.csv");
                    for (int i = 0; i < citas.size(); i++) {
                        String guardarcita = citas.get(i).getId() + "," + citas.get(i).getMotivo() + "," +
                                citas.get(i).getFecha() + "," + citas.get(i).getDoctor().getId() + "," + 
                                citas.get(i).getPaciente().getId() + "\n";
                        escritorcita.write(guardarcita);
                        escritorcita.flush();
                    }
                    System.out.println("Lista de citas guardada");
                    escritorcita.close();
                    
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
