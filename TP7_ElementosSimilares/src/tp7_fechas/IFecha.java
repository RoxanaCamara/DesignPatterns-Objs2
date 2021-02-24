package tp7_fechas;

public interface IFecha {
	public IFecha restarDias(int dias);
	public boolean antesDeAhora();
	public boolean antesDe(IFecha fecha);
	public boolean despuesDeAhora();
	public boolean despuesDeFecha(IFecha fecha);
	public int dia();
	public int mes();
	public int anio();
}
