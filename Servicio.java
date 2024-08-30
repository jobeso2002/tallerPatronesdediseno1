package taller1;

abstract class Servicio {
    protected double CostoBase = 5000;

    public  abstract double calcularCosto(double peso);
}


class Sobre extends Servicio {
    @Override
    public  double calcularCosto(double peso) {
        return CostoBase + peso;
    }
}

class Caja extends Servicio {
    @Override
    public  double calcularCosto(double peso) {
        return CostoBase * peso + 25000;
    }
}

class Paquete extends Servicio {
    @Override
    public  double calcularCosto(double peso) {
        return CostoBase * peso;
    }
}