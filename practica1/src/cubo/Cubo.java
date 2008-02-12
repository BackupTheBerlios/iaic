package cubo;
import Problema;

//import java.util.ArrayList;
/**
 * @author gnufede
 *
 */
public class Cubo implements Problema {

	/*
	 * (non-javadoc)
	 */
	private int _longitud;
	/**
	 *
	 */
	private EstadoCubo _estado;

	public Cubo (int longitud){
		_longitud = longitud;
		_estado = new EstadoCubo (longitud);
	}

	public EstadoCubo getEstado(){
		return this._estado;
	}

	public void setEstado(EstadoCubo newEstado){
		this._estado = newEstado;
	}

	public boolean[][][][] abrirPuerta(int puerta, boolean[][][][] puertasAbiertas){
		int x,y,z,pos;
System.out.println("Abrimos la puerta "+puerta);
		x = (puerta/100)%10;
		y = (puerta/10)%10;
		z = puerta%10;
		pos = (puerta/1000)%10;
		puertasAbiertas[x][y][z][pos] = true;
		return puertasAbiertas;
	}

	public EstadoCubo irHacia(int direccion){
		return irHacia(direccion, _estado);
	}

	public int irHacia(int direccion, int num){
		switch (direccion){
			case 0: //Arriba
				if ((num/100)%10 != _longitud-1)
					return num+100;
				else return num;
			case 1: //Abajo
				if ((num/100)%10 != 0)
					return num-100;
				else return num;
			case 2: //Izquierda
				if ((num/10)%10 != _longitud-1)
					return num+10;
				else return num;
			case 3: //Derecha
				if ((num/10)%10 != 0)
					return num-10;
				else return num;
			case 4:	//Adelante
				if (num % 10 != _longitud-1)
					return num+1;
				else return num;
			case 5:	//Atras
				if (num % 10 != 0)
					return num-1;
				else return num;
			default: 
				return num;
		}
	}


	public EstadoCubo irHacia(int direccion, EstadoCubo estado){
		int num = estado.getNumHabitacion();
		boolean[][][][] puertas = estado.getPuertasAbiertas();
		switch (direccion){
			case 0: //Arriba
				if ((num/100)%10 != _longitud-1)
					return new EstadoCubo(num+100,abrirPuerta(num,puertas));
				else return estado;
			case 1: //Abajo
				if ((num/100)%10 != 0)
					return new EstadoCubo(num-100,abrirPuerta(num-100,puertas));
				else return estado;
			case 2: //Izquierda
				if ((num/10)%10 != _longitud-1)
					return new EstadoCubo(num+10,abrirPuerta(num+1000,puertas));
				else return estado;
			case 3: //Derecha
				if ((num/10)%10 != 0)
					return new EstadoCubo(num-10,abrirPuerta(num-10+1000,puertas));
				else return estado;
			case 4:	//Adelante
				if (num % 10 != _longitud-1)
					return new EstadoCubo(num+1,abrirPuerta(num+2000,puertas));
				else return estado;
			case 5:	//Atras
				if (num % 10 != 0)
					return new EstadoCubo(num-1,abrirPuerta(num-1+2000,puertas));
				else return estado;
			default: 
				return estado;
		}
	}

	public boolean isExit (){
		return isExit(this._estado);
	}

	private boolean isExit (EstadoCubo estado) {
		int num = estado.getNumHabitacion();
		if ((num % (_longitud-1) != 0) 
			|| ((num/10) % (_longitud-1) != 0)
			||((num/100) % (_longitud-1) != 0))
				return false;
		return true;
	}

	public int H(){
		return H(_estado);
	}	

	public int H (int num){

		int x = (num % 10);
		int y = (num/10) % 10;
		int z = (num/100) % 10;
		int h = 0;//1; //FIXME: Antes era 0
/*

//System.out.println("x: "+x+" y: "+y+" z: "+z);
		h*= x % (_longitud-1);
//System.out.println("hx1: "+h);
		h*= y % (_longitud-1);
//System.out.println("hy1: "+h);
		h*= z % (_longitud-1);	
//System.out.println("hz1: "+h);

		h*= ((_longitud-1-x) % (_longitud-1));
//System.out.println("hx2: "+h);
		h*= ((_longitud-1-y) % (_longitud-1));
//System.out.println("hy2: "+h);
		h*= ((_longitud-1-z) % (_longitud-1));
//System.out.println("hz2: "+h);		
*/
		h+= Math.min ((x % (_longitud-1)), ((_longitud-1-x) % (_longitud-1)));
		h+= Math.min ((y % (_longitud-1)),((_longitud-1-y) % (_longitud-1)));
		h+= Math.min ((z % (_longitud-1)), ((_longitud-1-z) % (_longitud-1))) ;	
		return h;
	//	return Math.abs(((num % 10)+((num/10) % 10)+((num/100) % 10)) - 3*(_longitud/2));
	}
	
	public int H (EstadoCubo estado) {
		int num = estado.getNumHabitacion();
		return H(num);
//		return Math.abs(((num % 10)+((num/10) % 10)+((num/100) % 10)) - 3*(_longitud/2));
		//esto calcula la heuristica, funciona de puta madre
	}

	public static void main (String args[]){
	try{
		int longitud_cubo = Integer.parseInt(args[0]);
		Cubo cubo = new Cubo(longitud_cubo);
/*
		for (int i = 0; i<longitud_cubo; i++){
			for (int j = 0; j < longitud_cubo; j++){
				for (int k = 0; k < longitud_cubo; k++)
					System.out.print(cubo.H(i*100+j*10+k) + " ");
				System.out.println();
			}
			System.out.println();
		}
*/


System.out.println("Empezamos en: " +cubo.getEstado().getNumHabitacion());
		while (!cubo.isExit()){
			int direcc = cubo.getEstado().getNumHabitacion();
//			int dir2 = direcc;
			for (int direccion = (int)(Math.random()*6); direccion<6; direccion++){
				int dirnueva = cubo.irHacia(direccion,cubo.getEstado().getNumHabitacion());
	System.out.println(direccion+": "+cubo.H(dirnueva)+" vs "+cubo.H());

				if (cubo.H(dirnueva) < cubo.H()){

	System.out.println(cubo.H(dirnueva)+" < "+cubo.H());
	System.out.println("vamos hacia: "+direccion);

					cubo.setEstado(cubo.irHacia(direccion));
	System.out.println("Ahora estamos en "+cubo.getEstado().getNumHabitacion());
					if ((direccion%2)==0) direccion --;
	//				direccion--;
				}

			}
//		if (direcc == cubo.getEstado().getNumHabitacion())
//			break;
		}
System.out.println("Salida: "+	cubo.getEstado().getNumHabitacion());



		}catch (Exception e){
		System.out.println("Ha ocurrido una excepcion");
		e.printStackTrace();
		}
	}

}
