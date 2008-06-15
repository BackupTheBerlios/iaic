package algoritmos;

public class Muestra {

	float[] contenido;
	int clase;
	
	public Muestra(float[] content){
		contenido = content;
		clase = -1;
	}
	
	public int getClase(){
		return clase;
	}
	
	public void setClase(int nuevaClase){
		clase = nuevaClase;
	}
	
	public float[] getContent(){
		return contenido;
	}
	
	public String toString(){
		String cadena = "[";
		for (int i = 0; i < contenido.length; i++)
			cadena += "\t"+contenido[i];
		cadena += " ] :\tClase: ";
		cadena += clase;
		return cadena;
	}
	
}
