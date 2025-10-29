package Entidades;

import java.util.Random;

public abstract class Producto {

    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;

    // Bloque estatico
    static {
        generadorAleatorio = new Random();
    }

    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
    }

    public Producto(String nombre, double precio, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante);
    }

    public int getCalorias() {
        if (this.calorias == 0) {
            this.calorias = generadorAleatorio.nextInt(601) + 200;
        }
        return this.calorias;
    }

    public int getTiempoPreparacion() {
        if (this.tiempoPreparacion == 0) {
            this.tiempoPreparacion = generadorAleatorio.nextInt(16) + 5; 
        }
        return this.tiempoPreparacion;
    }

    private static String mostrar(Producto p) {
        return "Nombre: " + p.nombre + "\n" +
               "Precio Base: " + p.precio + "\n" +
               "Fabricante: " + p.fabricante + "\n" +
               "Calorías: " + p.getCalorias() + "\n" +
               "Tiempo Preparación: " + p.getTiempoPreparacion();
    }

    public static boolean sonIguales(Producto p1, Producto p2) {  //Le cambie la visibilidad porque sino no se podia utilizar
        if (p1 == null || p2 == null) return false;
        return p1.nombre.equals(p2.nombre)
            && Fabricante.sonIguales(p1.fabricante, p2.fabricante);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Producto)) return false;

        Producto other = (Producto) obj;
        return this.nombre.equals(other.nombre)
            && Fabricante.sonIguales(this.fabricante, other.fabricante);
    }

    @Override
    public String toString() {
        return mostrar(this);
    }
}