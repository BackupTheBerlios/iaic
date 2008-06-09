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


	/** Number of clusters */
	private int k;
	

	/** Array of clusters */
	private cluster[] clusters;
	
	
	/** Number of iterations */
	private int nIterations;
	
	
	/** Vector of data points */
	private Vector<kMeansPoint> kMeansPoints;
	
	
	/** Name of the input file */
	private String inputFileName;
	
	
	/**
	 * Returns a new instance of kMeans algorithm
	 *
	 * @param	k		number of clusters
	 * @param	inputFileName	name of the file containing input data
	 */
         public kMeans(int k, String inputFileName) {
	
		this.k = k;
		this.inputFileName = inputFileName;
		this.clusters = new cluster[this.k];
		this.nIterations = 0;
		this.kMeansPoints = new Vector<kMeansPoint>();
	
	} // end of kMeans()


	/**
	 * Returns a new instance of kMeans algorithm
	 *
	 * @param	k		number of clusters
	 * @param	kMeansPoints	List containing objects of type kMeansPoint
	 */
         public kMeans(int k, List<kMeansPoint> kMeansPoints) {
	
		this.k = k;
		this.inputFileName = inputFileName;
		this.clusters = new cluster[this.k];
		this.nIterations = 0;
		this.kMeansPoints=new Vector<kMeansPoint>(kMeansPoints);
	
	} // end of kMeans()
	
	
	/**
	 * Reads the input data from the file and stores the data points in the vector
	 */
	public void readData() throws IOException{
	
		BufferedReader in = new BufferedReader(new FileReader(this.inputFileName));
		String line = "";
		while ((line = in.readLine()) != null ){
                        
			StringTokenizer st = new StringTokenizer(line, " \t\n\r\f,");
				if (st.countTokens() == 2) {
					
					kMeansPoint dp = new kMeansPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					dp.assignToCluster(0);
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
		
			this.clusters[i] = new cluster(i);
			this.clusters[i].setMean((kMeansPoint)(this.kMeansPoints.get((int)(Math.random() * this.kMeansPoints.size()))));
		
		}
		
		
		do {
			// Form k clusters
			Iterator<kMeansPoint> i = this.kMeansPoints.iterator();
			while (i.hasNext())
				this.assignToCluster((kMeansPoint)(i.next()));
				
			this.nIterations++;
		
		}
		// Repeat while centroids do not change
		while (this.updateMeans());
	
	} // end of runKMeans()
	
	
	/**
	 * Assigns a data point to one of the k clusters based on its distance from the means of the clusters
	 *
	 * @param	dp	data point to be assigned
	 */
	private void assignToCluster(kMeansPoint dp) {
	
		int currentCluster = dp.getClusterNumber();
		double minDistance = kMeansPoint.distance(dp, this.clusters[currentCluster].getMean());;
		
		for (int i=0; i <this.k; i++)
			if (kMeansPoint.distance(dp, this.clusters[i].getMean()) < minDistance) {
		
				minDistance = kMeansPoint.distance(dp, this.clusters[i].getMean());
				currentCluster = i;
				
			}
		
		dp.assignToCluster(currentCluster);	
	
	} // end of assignToCluster
	
	
	/**
	 * Updates the means of all k clusters, and returns if they have changed or not
	 *
	 * @return	have the updated means of the clusters changed or not
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
			pastMeans[i] = this.clusters[i].getMean();
		
		}
		
		Iterator<kMeansPoint> i = this.kMeansPoints.iterator();
		while (i.hasNext()) {
		
		
			kMeansPoint dp = (kMeansPoint)(i.next());
			int currentCluster = dp.getClusterNumber();
			
			x[currentCluster] += dp.getX();
			y[currentCluster] += dp.getY();
			size[currentCluster]++;
		
		}
		
		for (int j=0; j < this.k; j++ ) 
			if(size[j] != 0) {
			
				x[j] /= size[j];
				y[j] /= size[j];
				kMeansPoint temp = new kMeansPoint(x[j], y[j]);
				temp.assignToCluster(j);
				this.clusters[j].setMean(temp);
				if (kMeansPoint.distance(pastMeans[j], this.clusters[j].getMean()) !=0 )
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
	 * Returns the specified cluster by index
	 *
	 * @param	index	index of the cluster to be returned
	 * @return	return the specified cluster by index
	 */
	public cluster getCluster(int index) {
	
		return this.clusters[index];
	
	} // end of getCluster()
        
        
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
 * Represents an abstraction for a cluster of data points in two dimensional space
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
 * Represents an abstraction for a cluster of data points in two dimensional space
 * @author	Manas Somaiya	mhs@cise.ufl.edu
 */
 class cluster {


	/** Cluster Number */
	private int clusterNumber;
	
	
	/** Mean data point of this cluster */
	private kMeansPoint mean;
	
	
	/**
	 * Returns a new instance of cluster
	 *
	 * @param	_clusterNumber	the cluster number of this cluster
	 */
	public cluster(int _clusterNumber) {
	
		this.clusterNumber = _clusterNumber;
		
	} // end of cluster()
	
	
	/**
	 * Sets the mean data point of this cluster
	 *
	 * @param	meanDataPoint	the new mean data point for this cluster
	 */
	public void setMean(kMeansPoint meanDataPoint) {
	
		this.mean = meanDataPoint;
	
	} // end of setMean()
	
	
	/**
	 * Returns the mean data point of this cluster
	 *
	 * @return	the mean data point of this cluster
	 */
	public kMeansPoint getMean() {
	
		return this.mean;
	
	} // end of getMean()
	
	
	/**
	 * Returns the cluster number of this cluster
	 *
	 * @return	the cluster number of this cluster
	 */
	public int getClusterNumber() {
	
		return this.clusterNumber;
	
	} // end of getClusterNumber()
	

	/**
	 * Main method -- to test the cluster class
	 *
	 * @param	args	command line arguments
	 */
	public static void main(String[] args) {
	
		cluster c1 = new cluster(1);
		c1.setMean(new kMeansPoint(3,4));
		System.out.println(c1.getMean());

	
	} // end of main()

} // end of class
