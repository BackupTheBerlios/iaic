import java.util.Collection;
import java.util.Iterator;

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
private Habitacion[][][] _habitaciones = null;
private Puerta[][][] _puertasX = null;
private Puerta[][][] _puertasY = null;
private Puerta[][][] _puertasZ = null;

private Puerta[][][][] _puertas = {_puertasX,_puertasY,_puertasZ};


Cubo (int _long){


	_puertasX = new Puerta [_long-1][_long][_long];
	_puertasY = new Puerta [_long][_long-1][_long];
	_puertasZ = new Puerta [_long][_long][_long-1];

//	_puertas = {_puertasX,_puertasY,_puertasZ};

/*	_puertas [0] = _puertasX;
	_puertas [1] = _puertasY;
	_puertas [2] = _puertasZ;
*/

	_habitaciones = new Habitacion[_long][_long][_long];

	this._longitud = _long;

	for (int i = 0; i< _long; i++)
		for	(int j = 0; j < _long; j++)
			for (int k = 0; k < _long-1; k++){
				_puertasX[k][i][j] = new Puerta (2*1000+k*100+i*10+j);	
				_puertasY[i][k][j] = new Puerta (1000+i*100+k*10+j);	
				_puertasZ[i][j][k] = new Puerta (i*100+j*10+k);
			}		

	for (int i = 0; i< _long; i++)
		for	(int j = 0; j < _long; j++)
			for (int k = 0; k < _long; k++)	{

				_habitaciones[i][j][k] = new Habitacion ((i*100+j*10+k),this);
				if (i>0){
					_habitaciones[i][j][k].setPuerta(0,_puertasX[i-1][j][k]);
					_puertasX[i-1][j][k].addHabitacion(_habitaciones[i][j][k]);
				}
				if (j>0){
					_habitaciones[i][j][k].setPuerta(2,_puertasY[i][j-1][k]);
					_puertasY[i][j-1][k].addHabitacion(_habitaciones[i][j][k]);
				}
				if (k>0){
					_habitaciones[i][j][k].setPuerta(4,_puertasZ[i][j][k-1]);
					_puertasZ[i][j][k-1].addHabitacion(_habitaciones[i][j][k]);
				}
				if (i<_long-1){
					_habitaciones[i][j][k].setPuerta(1,_puertasX[i][j][k]);
					_puertasX[i][j][k].addHabitacion(_habitaciones[i][j][k]);
				}
				if (j<_long-1){
					_habitaciones[i][j][k].setPuerta(3,_puertasY[i][j][k]);
					_puertasY[i][j][k].addHabitacion(_habitaciones[i][j][k]);
				}
				if (k<_long-1){
					_habitaciones[i][j][k].setPuerta(5,_puertasZ[i][j][k]);
					_puertasZ[i][j][k].addHabitacion(_habitaciones[i][j][k]);
				}

			}

}


/**
 * Getter of the property <tt>_longitud</tt>
 *
 * @return Returns the _longitud.
 * 
 */
public int get_longitud()
{
	return _longitud;
}

public Puerta getPuertaX(int x, int y, int z){
	return _puertasX[x][y][z];
}

public Puerta getPuertaY(int x, int y, int z){
	return _puertasY[x][y][z];
}

public Puerta getPuertaZ(int x, int y, int z){
	return _puertasZ[x][y][z];
}



/**
 * Getter of the property <tt>habitacion</tt>
 *
 * @return Returns the habitacion.
 * 
 */
public Habitacion get_habitacion(int x, int y, int z)
{
	return this._habitaciones[x][y][z];
}
 
/**
 * Setter of the property <tt>habitacion</tt>
 *
 * @param habitacion the habitacion to set.
 *
 */
public void set_habitacion(int x, int y, int z, Habitacion habitacion){
	this._habitaciones[x][y][z] = habitacion;
}


public static void main (String args[]){
	int _long = 3;
	Cubo cubo = new Cubo(_long);

	for (int i = 0; i< _long; i++)
		for	(int j = 0; j < _long; j++)
			for (int k = 0; k < _long-1; k++)
		{
					System.out.println("Puerta "+(cubo.getPuertaX(k,i,j).getNum()));
					System.out.println("Arriba "+(((Habitacion)(cubo.getPuertaX(k,i,j).getHabitaciones().get(0))).getNum()));
					System.out.println("Abajo "+(((Habitacion)(cubo.getPuertaX(k,i,j).getHabitaciones().get(1))).getNum()));	
System.out.println();
					System.out.println("Puerta "+(cubo.getPuertaY(i,k,j).getNum()));
					System.out.println("Izquierda "+(((Habitacion)(cubo.getPuertaY(i,k,j).getHabitaciones().get(0))).getNum()));
					System.out.println("Derecha "+(((Habitacion)(cubo.getPuertaY(i,k,j).getHabitaciones().get(1))).getNum()));	
System.out.println();
					System.out.println("Puerta "+(cubo.getPuertaZ(i,j,k).getNum()));
					System.out.println("Adelante "+(((Habitacion)(cubo.getPuertaZ(i,j,k).getHabitaciones().get(0))).getNum()));
					System.out.println("Atras "+(((Habitacion)(cubo.getPuertaZ(i,j,k).getHabitaciones().get(1))).getNum()));	
System.out.println();
		}
			

}






}
