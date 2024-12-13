package entities;

import java.util.ArrayList;
import java.util.List;

public class Agente extends Entidad {
    private String habilidadEspecial;
    private String misionAsignada;
    private List<String> misionesCompletadas; // Lista de misiones completadas
    private List<String> anomalíasNeutralizadas; // Lista de anomalías neutralizadas

    public Agente(int id, String nombre, String habilidadEspecial) {
        super(id, nombre);
        this.habilidadEspecial = habilidadEspecial;
        this.misionesCompletadas = new ArrayList<>(); //inicializar la lista
        this.anomalíasNeutralizadas = new ArrayList<>();
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }

    public void asignarMision(String mision) {
        this.misionAsignada = mision;
    }

    public void completarMision(String mision) { //metodos para agregar misiones 
        misionesCompletadas.add(mision); // Agregar misión a la lista de completadas
    }

    public void neutralizarAnomalia(String anomalia) { //método para agregar anomalias 
        anomalíasNeutralizadas.add(anomalia); // Agregar anomalía a la lista de neutralizadas
    }

    public void generarReporte() {
        System.out.println("Reporte de Actividad del Agente: " + super.getNombre()); //para obtener el nombre del agente
        System.out.println("Misiones Completadas: " + misionesCompletadas);
        System.out.println("Anomalías Neutralizadas: " + anomalíasNeutralizadas);
    }

    @Override
    public String toString() {
        return super.toString() + ", Habilidad Especial: " + habilidadEspecial +
                (misionAsignada != null ? ", Misión: " + misionAsignada : "");
    }
    public static void main(String[] args) {
        Agente agente = new Agente(1915, "Albert", "Velocidad");
        agente.asignarMision("Misión 1");
        agente.completarMision("Misión 1");
        agente.neutralizarAnomalia("Anomalía A");
        agente.generarReporte();

    }
}
