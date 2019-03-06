package com.matco.manual.jdbc;

import com.matco.administradortransacciones.dao.Transaccion;
import com.matco.administradortransacciones.dao.jdbc.TransaccionJdbc;
import com.matco.manual.dao.AlumnoDao;
import com.matco.manual.dao.DaoFactory;

public class DaoFactoryJdbc extends DaoFactory{

	private TransaccionJdbc transaccion;

	@Override
	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	@Override
	public void setTransaccion(Transaccion conexion) {
		if (conexion instanceof TransaccionJdbc) {
			this.transaccion = (TransaccionJdbc) conexion;
		} else {
			throw new RuntimeException("S esperaba una transaccion JDBC");
		}
	}

	@Override
	public AlumnoDao getAlumnoDao() {
		AlumnoDaoJdbc alumnoDaoJdbc = new AlumnoDaoJdbc();
		alumnoDaoJdbc.setTransaccion(this.transaccion);
		return alumnoDaoJdbc;
	}
}
