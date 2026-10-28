package Polizas.Marcas;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import Polizas.General.Conexion;
import Polizas.General.DAO;

public class MarcasModelo extends Conexion implements DAO {
    
    MarcasModelo() {
        super();
    }
    
    @Override
    public List read() {
        List<Marca> lista = new ArrayList<>();
        try {
            this.conectar();
            ps = cnx.prepareStatement("SELECT * FROM marcas");
            rs = ps.executeQuery();
            lista.clear();
            
            while (rs.next()) {
                lista.add(new Marca(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return lista;
    }
    
    @Override
    public int create(Object obj) {
        try {
            this.conectar();
            Marca marca = (Marca) obj;
            ps = cnx.prepareStatement("insert into marcas(nombre) values (?) ");
            ps.setString(1, marca.getNombre());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return 1;
    }
    
    @Override
    public int delete(Object obj) {
        return 0; // Método no implementado en el protocolo
    }
    
    @Override
    public int update(Object lista) {
        return 0; // Método no implementado en el protocolo
    }
}