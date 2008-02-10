

import java.util.Collection;
import java.util.Iterator;

/**
 * @author gnufede
 *
 */
public class Puerta {

	/*
 * (non-javadoc)
 */
private Habitacion habitacion = null;
 
/**
 * Getter of the property <tt>habitacion</tt>
 *
 * @return Returns the habitacion.
 * 
 */
public Habitacion getHabitacion()
{
	return habitacion;
}

/**
 * Setter of the property <tt>habitacion</tt>
 *
 * @param habitacion The habitacion to set.
 *
 */
public void setHabitacion(Habitacion habitacion ){
	this.habitacion = habitacion;
}

/*
 * (non-javadoc)
 */
private Problema problema = null;
 
/**
 * Getter of the property <tt>problema</tt>
 *
 * @return Returns the problema.
 * 
 */
public Problema getProblema()
{
	return problema;
}

/**
 * Setter of the property <tt>problema</tt>
 *
 * @param problema The problema to set.
 *
 */
public void setProblema(Problema problema ){
	this.problema = problema;
}

}

///**
// * Returns <tt>true</tt> if this collection contains no elements.
// *
// * @return <tt>true</tt> if this collection contains no elements
// * @see	java.util.Collection#isEmpty()
// *
// */
//public boolean isProblemaEmpty(){
//	return problema.isEmpty();
//}
///**
// * Returns the number of elements in this collection.
// *
// * @return the number of elements in this collection
// * @see	java.util.Collection#size()
// *
// */
//public int problemaSize(){
//	return problema.size();
//}
///**
// * Removes a single instance of the specified element from this
// * collection, if it is present (optional operation).
// *
// * @param element to be removed from this collection, if present.
// * @see	java.util.Collection#add(Object)
// *
// */
//public boolean removeProblema(Problema problema){
//	return this.problema.remove(problema);
//}
///**
// * Returns all elements of this collection in an array.
// *
// * @return an array containing all of the elements in this collection
// * @see	java.util.Collection#toArray()
// *
// */
//public Problema[] problemaToArray(){
//	return problema.toArray(new Problema[problema.size()]);
//}
///**
// * Returns <tt>true</tt> if this collection contains all of the elements
// * in the specified collection.
// *
// * @param elements collection to be checked for containment in this collection.
// * @see	java.util.Collection#containsAll(Collection)
// *
// */
//public boolean containsAllProblema(Collection<Problema> problema){
//	return this.problema.containsAll(problema);
//}
///**
// * Returns an iterator over the elements in this collection. 
// *
// * @return an <tt>Iterator</tt> over the elements in this collection
// * @see	java.util.Collection#iterator()
// * 
// */
//public Iterator<Problema> problemaIterator(){
//	return problema.iterator();
//}
///**
// * Returns <tt>true</tt> if this collection contains the specified element. 
// *
// * @param element whose presence in this collection is to be tested.
// * @see	java.util.Collection#contains(Object)
// *
// */
//public boolean containsProblema(Problema problema){
//	return this.problema.contains(problema);
//}
///**
// * Setter of the property <tt>problema</tt>
// *
// * @param problema the problema to set.
// *
// */
//public void setProblema(Collection<Problema> problema){
//	this.problema = problema;
//}
///**
// * Getter of the property <tt>problema</tt>
// *
// * @return Returns the problema.
// * 
// */
//public Collection<Problema> getProblema()
//{
//	return problema;
//}
///**
// * Ensures that this collection contains the specified element (optional
// * operation). 
// *
// * @param element whose presence in this collection is to be ensured.
// * @see	java.util.Collection#add(Object)
// *
// */
//public boolean addProblema(Problema problema){
//	return this.problema.add(problema);
//}
///**
// * Removes all of the elements from this collection (optional operation).
// *
// * @see	java.util.Collection#clear()
// *
// */
//public void clearProblema(){
//	this.problema.clear();
//}
///**
// * Getter of the property <tt>habitacion</tt>
// *
// * @return Returns the habitacion.
// * 
// */
//public Habitacion getHabitacion()
//{
//	return habitacion;
//}
///**
// * Setter of the property <tt>habitacion</tt>
// *
// * @param habitacion The habitacion to set.
// *
// */
//public void setHabitacion(Habitacion habitacion ){
//	this.habitacion = habitacion;
//}