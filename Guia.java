package taller1;

class Guia {
    private int numeroGuia;
    private String destinatario;
    private double peso;
    private double valorDeclarado;
    private boolean internacional;
    private String estado; // descapacho o finalizada
    private Servicio servicio;

    public Guia(int numeroGuia, String destinatario, double peso, double valorDeclarado, boolean internacional,  Servicio servicio) {
        this.numeroGuia = numeroGuia;
        this.destinatario = destinatario;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.internacional = internacional;
        this.estado = "Despacho";
        this.servicio = servicio;
    }

    public double calcularCosto() {
        double costo = servicio.calcularCosto(peso);
        if(internacional) {
            costo *= 1.25;
        }
        return costo;
    }

    public String finalizarEnvio(){
        this.estado = "Finalizado";
        return "Envio finalizado. El costo total es: $ " + calcularCosto();
    }

    public int getNumeroGuia() {
        return numeroGuia;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getEstado() {
        return estado;
    }

}
