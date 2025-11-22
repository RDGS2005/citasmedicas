package dataAccess.DAO;

import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.MedicamentoDTO;
import dataAccess.DTO.MedicoDTO;
import dataAccess.DTO.PacienteDTO;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO extends MySQLDataHelper implements IDAO<MedicoDTO>{

    public MedicoDTO login(String cedula, String password) throws Exception {
        MedicoDTO dto = new MedicoDTO();
        return dto;
    }
    public boolean registrar(MedicoDTO entity, String password) throws Exception
    {
        try{
            create(entity);
        }catch(Exception e) {}
        return true;
    }
    @Override
    public MedicoDTO readBy(Integer id) throws Exception {
        MedicoDTO dto = new MedicoDTO();
        return dto;
    }
    //VER TODOS LOS DOCTORES
    @Override
    public List<MedicoDTO> readAll() throws Exception {
        MedicoDTO dto;
        List<MedicoDTO> lst = new ArrayList<>();
        return lst;
    }
    //REGISTRAR PERFIL
    @Override
    public boolean create(MedicoDTO entity) throws Exception {
        return true;
    }
    //MODIFICAR PERFIL
    @Override
    public boolean update(MedicoDTO entity) throws Exception {
        return true;
    }
    //ELIMINAR PERFIL
    public boolean dardebaja(Integer id_medico) throws Exception {
        return true;
    }
    //CONSULTAR ELIMINADOS PARA RECUPERARLOS
    public List<MedicoDTO> verEliminados() throws Exception {
        MedicoDTO dto;
        List<MedicoDTO> lst = new ArrayList<>();
        return lst;
    }

    public List<MedicamentoDTO> consultarMedicamentos() throws Exception {
        List<MedicamentoDTO> lst = new ArrayList<>();
        return lst;
    }

}
