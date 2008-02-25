package modelo.problema.cuadradoMagico;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.LinkedList;
import java.util.List;
import modelo.problema.*;

public class EstadoCuadradoMagico implements Estado{

	int x,y,z;
	
	public EstadoCuadradoMagico(int x,int y,int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	

	//Muestra informacion de un estado
	public String mostrarInfo(){
		String s = this.getX() + " " + this.getY() + " " + (15-this.getX()-this.getY());
		s = s + "\n" + this.getZ() + " " + 5 + " " + (10-this.getZ());
		s = s + "\n" + (15-this.getX()-this.getZ()) + " " + (10-this.getY()) + " " + (10-this.getX());
		return s;
	}
	//Comprobacion de igualdad de dos estados
	public boolean equals(Object e2){
		return ((x == ((EstadoCuadradoMagico)e2).getX()) &&
				(y == ((EstadoCuadradoMagico)e2).getY()) &&
				(z == ((EstadoCuadradoMagico)e2).getZ()));
	}
	//Lista de operadores aplicables a un estado
	public List<Operador> getOperadoresAplicables(){
		List<Operador>	listaOperadores	=	new	LinkedList<Operador>();
		listaOperadores.add(new OperadorPonX1(this));
		listaOperadores.add(new OperadorPonX2(this));
		listaOperadores.add(new OperadorPonX3(this));
		listaOperadores.add(new OperadorPonX4(this));
		listaOperadores.add(new OperadorPonX6(this));
		listaOperadores.add(new OperadorPonX7(this));
		listaOperadores.add(new OperadorPonX8(this));
		listaOperadores.add(new OperadorPonX9(this));
		listaOperadores.add(new OperadorPonY1(this));
		listaOperadores.add(new OperadorPonY2(this));
		listaOperadores.add(new OperadorPonY3(this));
		listaOperadores.add(new OperadorPonY4(this));
		listaOperadores.add(new OperadorPonY6(this));
		listaOperadores.add(new OperadorPonY7(this));
		listaOperadores.add(new OperadorPonY8(this));
		listaOperadores.add(new OperadorPonY9(this));
		listaOperadores.add(new OperadorPonZ1(this));
		listaOperadores.add(new OperadorPonZ2(this));
		listaOperadores.add(new OperadorPonZ3(this));
		listaOperadores.add(new OperadorPonZ4(this));
		listaOperadores.add(new OperadorPonZ6(this));
		listaOperadores.add(new OperadorPonZ7(this));
		listaOperadores.add(new OperadorPonZ8(this));
		listaOperadores.add(new OperadorPonZ9(this));		
	
		return listaOperadores;
	}
	//Calcula la heuristica de un estado
	public int getHeuristica(){
		int h = x % 2;
		h += (y+1) % 2;
		h += (z+1) % 2;
		h += (y+x) % 4;
		return h;
	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getZ() {
		return z;
	}


	public void setZ(int z) {
		this.z = z;
	}
}
