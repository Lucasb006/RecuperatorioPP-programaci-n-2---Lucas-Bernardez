package Entidades;

public class Postre extends Producto implements IVendible {

    private TipoPostre tipoPostre;

    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }

    @Override
    public double getPrecioTotal() {
        double base = this.precio;
        switch (this.tipoPostre) {
            case TIRAMISU:
                return base * 1.20;
            case HELADO:
                return base * 1.15;
            case FLAN:
                return base * 1.10;
            default:
                return base;
        }
    }

    @Override
    public String toString() {
        return "Postre - " + this.nombre +
               " | Fabricante: " + this.fabricante +
               " | Tipo: " + this.tipoPostre +
               " | Precio total: " + getPrecioTotal();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Postre)) return false;
        Postre other = (Postre) obj;
        return this.tipoPostre == other.tipoPostre;
    }
}