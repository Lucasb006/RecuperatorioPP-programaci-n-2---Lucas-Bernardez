package Entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto> {

    private String nombre;
    private int capacidad;
    private Collection<Producto> productos;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }

    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }

    private boolean sonIguales(Producto p) {
        if (p == null) return false;
        for (Producto prod : productos) {
            if (Producto.sonIguales(prod, p)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(Producto p) {
        if (p == null) {
            System.out.println("No se puede agregar: producto nulo.");
            return;
        }

        if (this.productos.size() >= this.capacidad) {
            System.out.println("No se puede agregar: no hay lugar en la pizzería.");
            return;
        }

        if (sonIguales(p)) {
            System.out.println("No se puede agregar: el producto ya existe en la pizzería.");
            return;
        }

        this.productos.add(p);
        System.out.println("Producto agregado: " + p.nombre);
    }

    private double getPrecioProductos(TipoProducto tipo) {
        double suma = 0.0;
        for (Producto p : productos) {
            if (tipo == TipoProducto.PIZZAS && p instanceof Pizza) {
                suma += ((IVendible) p).getPrecioTotal();
            } else if (tipo == TipoProducto.POSTRES && p instanceof Postre) {
                suma += ((IVendible) p).getPrecioTotal();
            } else if (tipo == TipoProducto.TODOS && p instanceof IVendible) {
                suma += ((IVendible) p).getPrecioTotal();
            }
        }
        return suma;
    }

    public double getPrecioDePizzas() {
        return getPrecioProductos(TipoProducto.PIZZAS);
    }

    public double getPrecioDePostres() {
        return getPrecioProductos(TipoProducto.POSTRES);
    }

    public double getPrecioTotal() {
        return getPrecioProductos(TipoProducto.TODOS);
    }

    @Override
    public Iterator<Producto> iterator() {
        return this.productos.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizzería: ").append(this.nombre).append(" | Capacidad: ").append(this.capacidad).append("\n");
        sb.append("Cantidad de productos: ").append(this.productos.size()).append("\n\n");
        for (Producto p : this.productos) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("\nPrecios Totales:\n");
        sb.append("Pizzas: ").append(getPrecioDePizzas()).append("\n");
        sb.append("Postres: ").append(getPrecioDePostres()).append("\n");
        sb.append("Total: ").append(getPrecioTotal()).append("\n");
        return sb.toString();
    }
}