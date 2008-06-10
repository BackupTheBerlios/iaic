package algoritmos;
/*
 * Implements the k-means algorithm
 *
 * Manas Somaiya
 * Computer and Information Science and Engineering
 * University of Florida
 *
 * Created: October 29, 2003
 * Last updated: October 30, 2003
 *
 */

import java.io.*;
import java.util.*;
 
 
 
/**
 * Implements the k-means algorithm
 * @author	Manas Somaiya	mhs@cise.ufl.edu
 */ 
public class kMeans {


	/** Number of Clases */
	private int k;
	

	/** Array of Clases */
	private Clase[] Clases;
	
	
	/** Number of iterations */
	private int nIterations;
	
	
	/** Vector of data points */
	private Vector<kMeansPoint> kMeansPoints;
	
	
	/** Name of the input file */
	private String inputFileName;
	
	
	/**
	 * Returns a new instance of kMeans algorithm
	 *
	 * @param	k		number of Clases
	 * @param	inputFileName	name of the file containing input data
	 */
         public kMeans(int k, String inputFileName) {
	
		this.k = k;
		this.inputFileName = inputFileName;
		this.Clases = new Clase[this.k];
		this.nIterations = 0;
		this.kMeansPoints = new Vector<kMeansPoint>();
	
	} // end of kMeans()


	/**
	 * Returns a new instance of kMeans algorithm
	 *
	 * @param	k		number of Clases
	 * @param	kMeansPoints	List containing objects of type kMeansPoint
	 */
         public kMeans(int k, List<kMeansPoint> kMeansPoints) {
	
		this.k = k;
	//	this.inputFileName = inputFileName;
		this.Clases = new Clase[this.k];
		this.nIterations = 0;
		this.kMeansPoints=new Vector<kMeansPoint>(kMeansPoints);
	
	} // end of kMeans()
	
	
	/**
	 * Reads the input data from the file 
	 * and stores the data points in the vector
	 */
	public void readData() throws IOException{
	
		BufferedReader in = new BufferedReader(
										new FileReader(this.inputFileName));
		String line = "";
		while ((line = in.readLine()) != null ){
                        
			StringTokenizer st = new StringTokenizer(line, " \t\n\r\f,");
				if (st.countTokens() == 2) {					
					kMeansPoint dp = new kMeansPoint(
								new float[]{
										Float.parseFloat(st.nextToken()),
										Float.parseFloat(st.nextToken())
								}
							);
					dp.assignToClase(0);
					this.kMeansPoints.add(dp);
                        
                        }
                        
		}
		
		in.close();
	
	} // end of readData()
	
	
	/**
	 * Runs the k-means algorithm over the data set
	 */
	public void runKMeans() {
	
		// Select k points as initial means
		for (int i=0; i < k; i++){
		
			this.Clases[i] = new Clase(i);
			this.Clases[i].setCentro(
									(kMeansPoint)(this.kMeansPoints.get
										(
												(int)(Math.random() 
													* this.kMeansPoints.size()
												)
										)
									)
									);
		
		}
		
		
		do {
			// Form k Clases
			Iterator<kMeansPoint> i = this.kMeansPoints.iterator();
			while (i.hasNext())
				this.assignToClase((kMeansPoint)(i.next()));
				
			this.nIterations++;
		
		}
		// Repeat while centroids do not change
		while (this.updateMeans());
		
		Iterator<kMeansPoint> i = this.kMeansPoints.iterator();
		int j = 0;
		kMeansPoint aux = new kMeansPoint();

		while (i.hasNext()){

			//this.assignToClase((kMeansPoint)(i.next()));
			aux =(kMeansPoint)i.next(); 
			j = aux.getClaseNumber();
			this.Clases[j].addMuestra(aux.toFloatArray());
		}
		
	
	
	} // end of runKMeans()
	
	
	/**
	 * Assigns a data point to one of the k Clases based on its distance 
	 * from the means of the Clases
	 *
	 * @param	dp	data point to be assigned
	 */
	private void assignToClase(kMeansPoint dp) {
	
		int currentClase = dp.getClaseNumber();
		double minDistance = kMeansPoint.distance
				(dp, new kMeansPoint(this.Clases[currentClase].getCentro()));
		
		for (int i=0; i <this.k; i++){
			kMeansPoint dc = new kMeansPoint(this.Clases[i].getCentro());
			if (kMeansPoint.distance(dp, dc) < minDistance) {
					minDistance = kMeansPoint.distance(dp, dc);
					currentClase = i;
				
			}
		}
		dp.assignToClase(currentClase);	
	
	} // end of assignToClase
	
	
	/**
	 * Updates the means of all k Clases, 
	 * and returns if they have changed or not
	 *
	 * @return	have the updated means of the Clases changed or not
	 */
	private boolean updateMeans() {
	
		boolean reply = false;
		
		int[] x = new int[this.k];
		int[] y = new int[this.k];
		int[] size = new int[this.k];
		kMeansPoint[] pastMeans = new kMeansPoint[this.k];
		
		for (int i=0; i<this.k; i++) {
		
			x[i] = 0;
			y[i] = 0;
			size[i] = 0;
			pastMeans[i] = new kMeansPoint(this.Clases[i].getCentro());
		
		}
		
		Iterator<kMeansPoint> i = this.kMeansPoints.iterator();
		while (i.hasNext()) {
		
		
			kMeansPoint dp = (kMeansPoint)(i.next());
			int currentClase = dp.getClaseNumber();
			
			x[currentClase] += dp.getX();
			y[currentClase] += dp.getY();
			size[currentClase]++;
		
		}
		
		for (int j=0; j < this.k; j++ ) 
			if(size[j] != 0) {
			
				x[j] /= size[j];
				y[j] /= size[j];
				kMeansPoint temp = new kMeansPoint(new float[] {x[j], y[j]});
				temp.assignToClase(j);
				this.Clases[j].setCentro(temp);
				if (kMeansPoint.distance(pastMeans[j], 
							new kMeansPoint(this.Clases[j].getCentro())) !=0 )
					reply = true;
					
			}
		
		return reply;
		
	} // end of updateMeans()


	/**
	 * Returns the value of k
	 *
	 * @return	the value of k
	 */
	public int getK() {

		return this.k;

	} // end of getK()
	
	
	/**
	 * Returns the specified Clase by index
	 *
	 * @param	index	index of the Clase to be returned
	 * @return	return the specified Clase by index
	 */
	public Clase getClase(int index) {
	
		return this.Clases[index];
	
	} // end of getClase()
        
        
	/**
	 * Returns the string output of the data points
	 *
	 * @return  the string output of the data points
	 */
	public String toString(){
            
		return this.kMeansPoints.toString();
            
	} // end of toString()
        
        
	/**
	 * Returns the data points
	 *
	 * @return  the data points
	 */
	public Vector<kMeansPoint> getDataPoints() {
            
		return this.kMeansPoints ;
            
	} // end of getDataPoints()
        
        
	/**
	 * Main method -- to test the kMeans class
	 *
	 * @param   args    command line arguments
	 */
	public static void main(String[] args) {
            
		kMeans km = new kMeans(2, "input1");
		
		try {
			km.readData();
		} catch (Exception e) {
			System.err.println(e);
			System.exit(-1);
		}
            
		km.runKMeans();
		System.out.println(km);
                    
        } // end of main()

} // end of class


/*
 * Represents an abstraction for a Clase of data points in two dimensional space
 *
 * Manas Somaiya
 * Computer and Information Science and Engineering
 * University of Florida
 *
 * Created: October 29, 2003
 * Last updated: October 30, 2003
 *
 */
 


