package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        List<Agente> agentes = new ArrayList<>(); // Lista para almacenar agentes

        System.out.print("Ingrese el número de agentes a registrar: ");
        int numeroAgentes = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < numeroAgentes; i++) {
            System.out.print("Ingrese el ID del agente: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese el nombre del agente: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la habilidad especial del agente: ");
            String habilidadEspecial = scanner.nextLine();

            Agente agente = new Agente(id, nombre, habilidadEspecial);

            System.out.print("Ingrese la misión asignada: ");
            String mision = scanner.nextLine();
            agente.asignarMision(mision);

            System.out.print("¿Completó la misión? (sí/no): ");
            String completado = scanner.nextLine();
            if (completado.equalsIgnoreCase("sí")) {
                agente.completarMision(mision);
            }

            System.out.print("Ingrese una anomalía neutralizada: ");
            String anomalia = scanner.nextLine();
            agente.neutralizarAnomalia(anomalia);

            agentes.add(agente); // Agregar agente a la lista
        }

        // Generar y mostrar el reporte de todos los agentes
        for (Agente agente : agentes) {
            agente.generarReporte();
            System.out.println(); // Para separar los reportes de cada agente
        }

        scanner.close(); // Cerrar el scanner
    }
}
