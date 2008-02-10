

import java.util.Collection;
import java.util.Iterator;/**
 * 
 */

/**
 * @author gnufede
 *
 */
public class Cubo implements Problema {

	/**
 *
 */
private Collection<Habitacion> habitacion = null;

/**
 * Getter of the property <tt>habitacion</tt>
 *
 * @return Returns the habitacion.
 * 
 */
public Collection<Habitacion> getHabitacion()
{
	return habitacion;
}
 
/**
 * Returns an iterator over the elements in this collection. 
 *
 * @return an <tt>Iterator</tt> over the elements in this collection
 * @see	java.util.Collection#iterator()
 * 
 */
public Iterator<Habitacion> habitacionIterator(){
	return habitacion.iterator();
}

/**
 * Returns <tt>true</tt> if this collection contains no elements.
 *
 * @return <tt>true</tt> if this collection contains no elements
 * @see	java.util.Collection#isEmpty()
 *
 */
public boolean isHabitacionEmpty(){
	return habitacion.isEmpty();
}

/**
 * Returns <tt>true</tt> if this collection contains the specified element. 
 *
 * @param element whose presence in this collection is to be tested.
 * @see	java.util.Collection#contains(Object)
 *
 */
public boolean containsHabitacion(Habitacion habitacion){
	return this.habitacion.contains(habitacion);
}

/**
 * Returns <tt>true</tt> if this collection contains all of the elements
 * in the specified collection.
 *
 * @param elements collection to be checked for containment in this collection.
 * @see	java.util.Collection#containsAll(Collection)
 *
 */
public boolean containsAllHabitacion(Collection<Habitacion> habitacion){
	return this.habitacion.containsAll(habitacion);
}

/**
 * Returns the number of elements in this collection.
 *
 * @return the number of elements in this collection
 * @see	java.util.Collection#size()
 *
 */
public int habitacionSize(){
	return habitacion.size();
}

/**
 * Returns all elements of this collection in an array.
 *
 * @return an array containing all of the elements in this collection
 * @see	java.util.Collection#toArray()
 *
 */
public Habitacion[] habitacionToArray(){
	return habitacion.toArray(new Habitacion[habitacion.size()]);
}


/**
 * Ensures that this collection contains the specified element (optional
 * operation). 
 *
 * @param element whose presence in this collection is to be ensured.
 * @see	java.util.Collection#add(Object)
 *
 */
public boolean addHabitacion(Habitacion habitacion){
	return this.habitacion.add(habitacion);
}

/**
 * Setter of the property <tt>habitacion</tt>
 *
 * @param habitacion the habitacion to set.
 *
 */
public void setHabitacion(Collection<Habitacion> habitacion){
	this.habitacion = habitacion;
}

/**
 * Removes a single instance of the specified element from this
 * collection, if it is present (optional operation).
 *
 * @param element to be removed from this collection, if present.
 * @see	java.util.Collection#add(Object)
 *
 */
public boolean removeHabitacion(Habitacion habitacion){
	return this.habitacion.remove(habitacion);
}

/**
 * Removes all of the elements from this collection (optional operation).
 *
 * @see	java.util.Collection#clear()
 *
 */
public void clearHabitacion(){
	this.habitacion.clear();
}

}
