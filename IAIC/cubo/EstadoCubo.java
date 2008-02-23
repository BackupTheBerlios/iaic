package cubo;

public class EstadoCubo  implements Estado{
	private int numHabitacion;
	private boolean[][][][] puertasAbiertas; 


	EstadoCubo(int longitud){
		numHabitacion = (int)(Math.random()*longitud-1) *100 + (int)(Math.random()*longitud-1) * 10 + (int)(Math.random()*longitud-1);
//numHabitacion = 1;
		puertasAbiertas = new boolean [longitud][longitud][longitud][3];
		for (int i = 0; i<longitud; i++)
			for (int j = 0; j<longitud; j++)
				for (int k = 0; k<longitud; k++)
					for (int l = 0; l<3; l++)
						puertasAbiertas[i][j][k][l] = false;
	}

	EstadoCubo(int numHabitacion, boolean[][][][] puertas){
		this.numHabitacion = numHabitacion;
		this.puertasAbiertas = puertas;
	}

	public int getNumHabitacion(){
		return this.numHabitacion;
	}

	public void setNumHabitacion(int num){
		numHabitacion = num;
	}

	public boolean[][][][] getPuertasAbiertas(){
		return this.puertasAbiertas;
	}

	public void setPuertasAbiertas(boolean[][][][] puertas){
		this.puertasAbiertas = puertas;
	}


}
