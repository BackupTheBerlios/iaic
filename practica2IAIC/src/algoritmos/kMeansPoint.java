package algoritmos;
/*
 * Represents an abstraction for a data point in two dimensional space
 *
 * Manas Somaiya
 * Computer and Information Science and Engineering
 * University of Florida
 *
 * Created: October 29, 2003
 * Last updated: October 30, 2003
 *
 */
 
 
 
/**
 * Represents an abstraction for a data point in two dimensional space
 * @author	Manas Somaiya	mhs@cise.ufl.edu
 */ 
public class kMeansPoint {


	/** Value in dimension x */
	private int x;
	

	/** Value in dimension y */
	private int y;
	

	
	private float[] muestra;
	
	/** Assigned Clase */
	private int ClaseNumber;
	


	/**
	 * Creates a new instance of data point
	 *
	 * @param	_x	value in dimension x
	 * @param	_y	value in dimension y
	 */
	public kMeansPoint(float [] muestra) {
		this.muestra = muestra;
		this.ClaseNumber=0;
	} // end of kMeansPoint()
	
	
	
	/**
	 * Assigns the data point to a Clase
	 *
	 * @param _ClaseNumber the Clase to which this data point is to be assigned
	 */
	public void assignToClase(int _ClaseNumber) {
	
		this.ClaseNumber = _ClaseNumber;
	
	} // end of assignToClase()
	
	
	/**
	 * Returns the Clase to which the data point belongs
	 *
	 * @return	the Clase number to which the data point belongs
	 */
	public int getClaseNumber() {
	
		return this.ClaseNumber;
	
	} // end of getClaseNumber()
	
	
	/**
	 * Returns the value of data point in x dimension
	 *
	 * @return	the value in x dimension
	 */
	public float getX() {
	
		return muestra[0];// this.x;
	
	} // end of getX()
	
	
	/**
	 * Returns the value of data point in y dimension
	 *
	 * @return	the value in y dimension
	 */
	public float getY() {
	
		return muestra[1]; //this.y;
	
	} // end of getY()
	
	public float get(int pos){
		return muestra[pos];
	}
	

	public float[] toFloatArray(){
		return muestra;
	}
	
	public int length(){
		return muestra.length;
	}
	/**
	 * Returns the distance between two data points
	 *
	 * @param	dp1 	the first data point
	 * @param	dp2 	the second data point
	 * @return	the distance between the two data points
	 */
	public static double distance(kMeansPoint dp1, kMeansPoint dp2) {
	
		double result = 0;
		long arg0 = 0;
		double [] resultVector = new double[dp1.length()];
		for (int i = 0; i < resultVector.length; i++){
			resultVector[i] = dp1.get(i) - dp2.get(i);
			arg0 += (resultVector[i]*resultVector[i]);
		}
		result = Math.sqrt(arg0);
		return result;	
	} // end of distance()
	
	
	/**
	 * Returns a string representation of this kMeansPoint
	 *
	 * @return	a string representation of this data point
	 */
	public String toString(){
	
		return "(" + this.x + "," + this.y + ")[" + this.ClaseNumber + "]";
	
	} // end of toString()
	
	
	/**
	 * Main method -- to test the kMeansPoint class
	 *
	 * @param	args	command line arguments
	 */
	public static void main(String[] args) {
		float[] a = {-3f,-4f};
		kMeansPoint dp1 = new kMeansPoint(a);
		a = new float[] {0f,4f};
		kMeansPoint dp2 = new kMeansPoint(a);
		System.out.println(kMeansPoint.distance(dp1, dp2));
		System.out.println(dp1.getX());
		System.out.println(dp2.getY());
		dp1.assignToClase(7);
		System.out.println(dp1.getClaseNumber());
		dp1.assignToClase(17);
		System.out.println(dp1.getClaseNumber());
		System.out.println(dp2.getClaseNumber());
		System.out.println(dp1);
	
	} // end of main()


} // end of class
