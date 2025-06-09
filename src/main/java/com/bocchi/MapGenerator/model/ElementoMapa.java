package com.bocchi.MapGenerator.model;

/**
 * Un elemento de mapa 3D: guarda tipo y coordenadas (x, y, z).
 */
public class ElementoMapa {
    private String tipo;
    private int x;
    private int y;
    private int z;  // añadimos la coordenada z

    /**
     * Constructor que recibe tipo y tres coordenadas.
     *
     * @param tipo El nombre/tipo del elemento (p.ej. "pino", "cueva", etc.)
     * @param x    Coordenada X en el mapa
     * @param y    Coordenada Y en el mapa
     * @param z    Coordenada Z (altura/profundidad) en el mapa
     */
    public ElementoMapa(String tipo, int x, int y, int z) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Si lo deseas, puedes mantener también un constructor de 2D:
    public ElementoMapa(String tipo, int x, int y) {
        this(tipo, x, y, 0);
    }

    // Getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return tipo + " en (" + x + ", " + y + ", " + z + ")";
    }
}
