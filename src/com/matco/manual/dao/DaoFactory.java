package com.matco.manual.dao;

import com.matco.administradortransacciones.dao.Transaccion;
import com.matco.manual.jdbc.DaoFactoryJdbc;
public abstract class DaoFactory {

	public static DaoFactoryJdbc crearFabrica(TipoFabrica tipo) {
		switch (tipo) {
		case JDBC:
			return new DaoFactoryJdbc();
		default:
			throw new RuntimeException("No se encontro la implementacion de la fabrica: "+tipo);
		}
	}

	public abstract Transaccion getTransaccion();
	
	public abstract void setTransaccion(Transaccion conexion);
	
	public abstract AlumnoDao getAlumnoDao();
	
	
}