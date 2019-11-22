package br.com.Interface.dao;

import java.sql.SQLException;
import java.util.List;

public interface VehicleDao extends BaseDao {

    public abstract List searchByModelAndBrand(String model, String brand) throws SQLException;

    public abstract List searchByYpva(double ipva) throws SQLException;

}
