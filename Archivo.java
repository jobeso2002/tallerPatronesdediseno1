package taller1;
import java.util.ArrayList;
import java.util.List;

class Archivo {
    private List<Guia> guias;

    public Archivo() {
        this.guias = new ArrayList<>();
    }

    public void registrarGUia(Guia guia) {
        guias.add(guia);
    }

    public List<Guia> consultarGuiasPorEstado(String estado) {
        List<Guia> resultado = new ArrayList<>();
        for (Guia guia : guias) {
            if(guia.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(guia);
            }
        }
        return resultado;
    }

    public List<Guia> consultarGuiasPorDestinatario(String destinatario) {
        List<Guia> resultado = new ArrayList<>();
        for (Guia guia : guias) {
            if(guia.getDestinatario().equalsIgnoreCase(destinatario)) {
                resultado.add(guia);
            }
        }
        return resultado;
    }

    public String finalizarGuiaPorNumero(int numeroGuia) {
        for (Guia guia : guias) {
            if(guia.getNumeroGuia() == numeroGuia) {
                return guia.finalizarEnvio();
            }
        }
        return "no se encontro el numero de guia" + numeroGuia + ".";
    }


}
