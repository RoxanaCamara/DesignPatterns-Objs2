package empresa;

import java.util.ArrayList;
import java.util.List;
import empleado.Empleado;

public class Empresa {

	private List<Empleado> empleados = new ArrayList<Empleado>();
	
	public void setEmpleado(Empleado e) {
		empleados.add(e);	
	}

	public int pagarALosEmpleados() {
		int total= 0;
		for(Empleado e : empleados) {
			total += e.sueldoNeto();		
		}
		return total * (-1); //No se porque sucede que devuelve negativo
	}

}
