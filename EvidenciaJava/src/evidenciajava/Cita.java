/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidenciajava;

/**
 *
 * @author Alan Franco
 */
public class Cita {
    
    String id;
    String motivo;
    String fecha;
    Doctor doctor;
    Paciente paciente;

    public Cita(String id, String motivo, String fecha, Doctor doctor, Paciente paciente) {
        this.id = id;
        this.motivo = motivo;
        this.fecha = fecha;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public String toString() {
        return "Cita{" + "ID=" + id + ", Motivo=" + motivo + ", Fecha=" + fecha + ", Doctor=" + doctor.getNombre() + ", Paciente=" + paciente.getNombre() + '}';
    }
    
    
}
