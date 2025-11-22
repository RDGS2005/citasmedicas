package dataAccess.DAO;

import dataAccess.DTO.*;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperadorDAO extends MySQLDataHelper implements IDAO<OperadorDTO>{

    public OperadorDTO login(String cedula, String password) throws Exception {
        OperadorDTO dto = new OperadorDTO();
        return dto;
    }
    public boolean registrar(OperadorDTO entity, String password) throws Exception
    {
        try{
            create(entity);
        }catch(Exception e) {}
        return true;
    }

    @Override
    public OperadorDTO readBy(Integer id) throws Exception {
        OperadorDTO dto = new OperadorDTO();
        return dto;
    }
    //VER TODOS LOS OPERADORES
    @Override
    public List<OperadorDTO> readAll() throws Exception {
        OperadorDTO dto;
        List<OperadorDTO> lst = new ArrayList<>();
        return lst;
    }
    //REGISTRAR PERFIL
    @Override
    public boolean create(OperadorDTO entity) throws Exception {
        return true;
    }
    //MODIFICAR PERFIL
    @Override
    public boolean update(OperadorDTO entity) throws Exception {
        return true;
    }
    //ELIMINAR PERFIL
    public boolean dardebaja(Integer id_operador) throws Exception {
        return true;
    }
    //CONSULTAR ELIMINADOS PARA RECUPERARLOS
    public List<OperadorDTO> verEliminados() throws Exception {
        OperadorDTO dto;
        List<OperadorDTO> lst = new ArrayList<>();
        return lst;
    }
}
