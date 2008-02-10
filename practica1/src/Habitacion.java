

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author gnufede
 *
 */
public class Habitacion {

	/**
 *
 */
private Collection<Puerta> puerta;

/**
 * Getter of the property <tt>puerta</tt>
 *
 * @return Returns the puerta.
 * 
 */
public Collection<Puerta> getPuerta()
{
	return puerta;
}
 
/**
 * Returns an iterator over the elements in this collection. 
 *
 * @return an <tt>Iterator</tt> over the elements in this collection
 * @see	java.util.Collection#iterator()
 * 
 */
public Iterator<Puerta> puertaIterator(){
	return puerta.iterator();
}

/**
 * Returns <tt>true</tt> if this collection contains no elements.
 *
 * @return <tt>true</tt> if this collection contains no elements
 * @see	java.util.Collection#isEmpty()
 *
 */
public boolean isPuertaEmpty(){
	return puerta.isEmpty();
}

/**
 * Returns <tt>true</tt> if this collection contains the specified element. 
 *
 * @param element whose presence in this collection is to be tested.
 * @see	java.util.Collection#contains(Object)
 *
 */
public boolean containsPuerta(Puerta puerta){
	return this.puerta.contains(puerta);
}

/**
 * Returns <tt>true</tt> if this collection contains all of the elements
 * in the specified collection.
 *
 * @param elements collection to be checked for containment in this collection.
 * @see	java.util.Collection#containsAll(Collection)
 *
 */
public boolean containsAllPuerta(Collection<Puerta> puerta){
	return this.puerta.containsAll(puerta);
}

/**
 * Returns the number of elements in this collection.
 *
 * @return the number of elements in this collection
 * @see	java.util.Collection#size()
 *
 */
public int puertaSize(){
	return puerta.size();
}

/**
 * Returns all elements of this collection in an array.
 *
 * @return an array containing all of the elements in this collection
 * @see	java.util.Collection#toArray()
 *
 */
public Puerta[] puertaToArray(){
	return puerta.toArray(new Puerta[puerta.size()]);
}


/**
 * Ensures that this collection contains the specified element (optional
 * operation). 
 *
 * @param element whose presence in this collection is to be ensured.
 * @see	java.util.Collection#add(Object)
 *
 */
public boolean addPuerta(Puerta puerta){
	return this.puerta.add(puerta);
}

/**
 * Setter of the property <tt>puerta</tt>
 *
 * @param puerta the puerta to set.
 *
 */
public void setPuerta(Collection<Puerta> puerta){
	this.puerta = puerta;
}

/**
 * Removes a single instance of the specified element from this
 * collection, if it is present (optional operation).
 *
 * @param element to be removed from this collection, if present.
 * @see	java.util.Collection#add(Object)
 *
 */
public boolean removePuerta(Puerta puerta){
	return this.puerta.remove(puerta);
}

/**
 * Removes all of the elements from this collection (optional operation).
 *
 * @see	java.util.Collection#clear()
 *
 */
public void clearPuerta(){
	this.puerta.clear();
}

	/*
 * (non-javadoc)
 */
private Cubo cubo = null;
 
/**
 * Getter of the property <tt>cubo</tt>
 *
 * @return Returns the cubo.
 * 
 */
public Cubo getCubo()
{
	return cubo;
}

/**
 * Setter of the property <tt>cubo</tt>
 *
 * @param cubo The cubo to set.
 *
 */
public void setCubo(Cubo cubo ){
	this.cubo = cubo;
}

}

///**
// * Setter of the property <tt>puerta</tt>
// *
// * @param puerta the puerta to set.
// *
// */
//public void setPuerta(Collection<Puerta> puerta){
//	this.puerta = puerta;
//}
///**
// * Returns an iterator over the elements in this collection. 
// *
// * @return an <tt>Iterator</tt> over the elements in this collection
// * @see	java.util.Collection#iterator()
// * 
// */
//public Iterator<Puerta> puertaIterator(){
//	return puerta.iterator();
//}
///**
// * Getter of the property <tt>puerta</tt>
// *
// * @return Returns the puerta.
// * 
// */
//public Collection<Puerta> getPuerta()
//{
//	return puerta;
//}
///**
// * Ensures that this collection contains the specified element (optional
// * operation). 
// *
// * @param element whose presence in this collection is to be ensured.
// * @see	java.util.Collection#add(Object)
// *
// */
//public boolean addPuerta(Puerta puerta){
//	return this.puerta.add(puerta);
//}
///**
// * Returns the number of elements in this collection.
// *
// * @return the number of elements in this collection
// * @see	java.util.Collection#size()
// *
// */
//public int puertaSize(){
//	return puerta.size();
//}
///**
// * Returns <tt>true</tt> if this collection contains the specified element. 
// *
// * @param element whose presence in this collection is to be tested.
// * @see	java.util.Collection#contains(Object)
// *
// */
//public boolean containsPuerta(Puerta puerta){
//	return this.puerta.contains(puerta);
//}
///**
// * Returns <tt>true</tt> if this collection contains all of the elements
// * in the specified collection.
// *
// * @param elements collection to be checked for containment in this collection.
// * @see	java.util.Collection#containsAll(Collection)
// *
// */
//public boolean containsAllPuerta(Collection<Puerta> puerta){
//	return this.puerta.containsAll(puerta);
//}
///**
// * Returns all elements of this collection in an array.
// *
// * @return an array containing all of the elements in this collection
// * @see	java.util.Collection#toArray()
// *
// */
//public Puerta[] puertaToArray(){
//	return puerta.toArray(new Puerta[puerta.size()]);
//}
///**
// * Returns <tt>true</tt> if this collection contains no elements.
// *
// * @return <tt>true</tt> if this collection contains no elements
// * @see	java.util.Collection#isEmpty()
// *
// */
//public boolean isPuertaEmpty(){
//	return puerta.isEmpty();
//}
///**
// * Removes all of the elements from this collection (optional operation).
// *
// * @see	java.util.Collection#clear()
// *
// */
//public void clearPuerta(){
//	this.puerta.clear();
//}
///**
// * Removes a single instance of the specified element from this
// * collection, if it is present (optional operation).
// *
// * @param element to be removed from this collection, if present.
// * @see	java.util.Collection#add(Object)
// *
// */
//public boolean removePuerta(Puerta puerta){
//	return this.puerta.remove(puerta);
//}
///**
// * Appends the specified element to the end of this list (optional
// * operation).
// *
// * @param element element to be appended to this list.
// * @return <tt>true</tt> (as per the general contract of the
// *            <tt>Collection.add</tt> method).
// * @see java.util.List#add(Object)
// *
// */
//public boolean addPuerta(Puerta Puerta){
//	return puerta.add(Puerta);
//}
///**
// * Returns <tt>true</tt> if this list contains the specified element.
// *
// * @param element element whose presence in this list is to be tested.
// * @return <tt>true</tt> if this list contains the specified element.
// * @see java.util.List#contains(Object)
// * 
// */
//public boolean containsPuerta(Puerta Puerta){
//	return puerta.contains(Puerta);
//}
///**
// * Returns an array containing all of the elements in this list in proper
// * sequence.
// *
// * @return an array containing all of the elements in this list in proper
// *	       sequence.
// * @see java.util.List#toArray()
// * 
// */
//public Puerta[] puertaToArray(){
//	return puerta.toArray(new Puerta[puerta.size()]);
//}
///**
// * Returns <tt>true</tt> if this list contains no elements.
// * 
// * @return <tt>true</tt> if this list contains no elements.
// * @see java.util.List#isEmpty()
// *
// */
//public boolean isPuertaEmpty(){
//	return puerta.isEmpty();
//}
///**
// * Returns <tt>true</tt> if this list contains all of the elements of the
// * specified collection.
// *
// * @param elements collection to be checked for containment in this list.
// * @return <tt>true</tt> if this list contains all of the elements of the
// * 	       specified collection.
// * @see java.util.List#containsAll(Collection)
// *
// */
//public boolean containsAllPuerta(Collection<? extends Puerta> puerta){
//	return this.puerta.containsAll(puerta);
//}
///**
// * Getter of the property <tt>puerta</tt>
// *
// * @return Returns the puerta.
// *
// */
//public List<Puerta> getPuerta()
//{
//	return puerta;
//}
///**
// * Returns an iterator over the elements in this list in proper sequence.
// *
// * @return an iterator over the elements in this list in proper sequence.
// * @see java.util.List#iterator()
// *
// */
//public Iterator<Puerta> puertaIterator(){
//	return puerta.iterator();
//}
///**
// * Returns the element at the specified position in this list.
// *
// * @param index index of element to return.
// * @return the element at the specified position in this list.
// * @see	java.util.List#get(int)
// *
// */
//public Puerta getPuerta(int i){
//	return (Puerta) puerta.get(i);
//}
///**
// * Returns the number of elements in this list.
// *
// * @return the number of elements in this list.
// * @see java.util.List#size()
// *
// */
//public int puertaSize(){
//	return puerta.size();
//}
///**
// * Inserts the specified element at the specified position in this list
// * (optional operation)
// *
// * @param index index at which the specified element is to be inserted.
// * @param element element to be inserted.
// * @see java.util.List#add(int, Object)
// *
// */
//public void addPuerta(int index, Puerta Puerta){
//	puerta.add(index, Puerta);
//}
///**
// * Setter of the property <tt>puerta</tt>
// *
// * @param puerta the puerta to set.
// *
// */
//public void setPuerta(List<Puerta> puerta){
//	this.puerta = puerta;
//}
///**
// * Removes the element at the specified position in this list (optional
// * operation).
// *
// * @param index the index of the element to removed.
// * @return the element previously at the specified position.
// * @see java.util.List#remove(int)
// * 
// */
//public Object removePuerta(int index){
//	return puerta.remove(index);
//}
///**
// * Removes the first occurrence in this list of the specified element 
// * (optional operation).
// *
// * @param element element to be removed from this list, if present.
// * @return <tt>true</tt> if this list contained the specified element.
// * @see java.util.List#remove(Object)
// *
// */
//public boolean removePuerta(Puerta Puerta){
//	return puerta.remove(Puerta);
//}
///**
// * Removes all of the elements from this list (optional operation).
// *
// * @see java.util.List#clear()
// *
// */
//public void clearPuerta(){
//	puerta.clear();
//}