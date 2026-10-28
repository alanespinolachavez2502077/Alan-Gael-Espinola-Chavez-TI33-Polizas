package Polizas.Marcas;

class Marca {
    protected int id;
    protected String nombre;
    
    @Override
    public String toString() {
        return this.nombre;
    }
    
    public Marca(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}