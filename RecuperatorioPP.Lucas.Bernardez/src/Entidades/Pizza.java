package Entidades;

public class Pizza extends Producto implements IVendible {

    private TipoPizza sabor;
    private TamañoPizza tamano;
//
    public Pizza(String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamañoPizza tamano) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamano = tamano;
    }

    @Override
    public double getPrecioTotal() {
        double base = this.precio;
        switch (this.tamano) {
            case CHICA:
                return base * 1.05;
            case MEDIANA:
                return base * 1.10;
            case GRANDE:
                return base * 1.20;
            default:
                return base;
        }
    }

    @Override
    public String toString() {
        return "Pizza - " + this.nombre +
               " - Fabricante: " + this.fabricante+
               " - Sabor: " + this.sabor +
               " - Tamaño: " + this.tamano +
               " - Precio total: " + getPrecioTotal();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Pizza)) return false;
        Pizza other = (Pizza) obj;
        return this.sabor == other.sabor && this.tamano == other.tamano;
    }
}