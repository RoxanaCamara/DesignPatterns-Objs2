package proyecto;

public class ProyectoSimple extends Proyecto{
   public ProyectoSimple(String nombre) {
	   super(nombre);
   }

@Override
public void agregarSubproyecto(Proyecto p) {}

@Override
public void quitarSubproyecto(Proyecto p) {}

@Override
protected boolean puedoAgregarSubproyecto(Proyecto proyecto) {
	
	return true;
}

   
}
