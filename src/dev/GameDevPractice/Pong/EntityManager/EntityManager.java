package dev.GameDevPractice.Pong.EntityManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import dev.GameDevPractice.Pong.Component.Component;

public class EntityManager {
	private static int lowestUnassignedEntityID=1;
	public static List<Integer> Entities;
	public static HashMap<Class<?>, HashMap<Integer, ? extends Component>> componentStores;
	private static boolean init = false;
	
	public EntityManager(){
		if(init == false){
			Entities = new LinkedList<Integer>();
			componentStores = new HashMap<Class<?>, HashMap<Integer, ? extends Component>>();
			init = true;
		} else {
			throw new IllegalArgumentException("There is already an EntityManager");
		}
	}
	public <T extends Component> T getComponent(int entity, Class<T> componentType){
		HashMap<Integer, ? extends Component> store = componentStores.get(componentType);
		if(store == null)
			throw new IllegalArgumentException("GET FAIL: there are no entities with a Component of class: "+ componentType);
		T result = componentType.cast(store.get(entity));
		if(result == null)
			throw new IllegalArgumentException("GET FAIL: " + entity + "does not possess Component of class \n missing "+ componentType);
		return result;
	}
	public <T extends Component> List<T> getAllComponentsOfType(Class<T> componentType){
		HashMap<Integer, ? extends Component> store = componentStores.get(componentType);
		if (store == null){
			return new LinkedList<T>();
		}
		else{
			List<T> result = new ArrayList<T>((java.util.Collection<T>)store.values());
			return result;
		}
	}
	public <T extends Component> void addComponent(int entity, T component){
		HashMap<Integer, ? extends Component> store = componentStores.get(component.getClass());
		
		if(store == null){
			store = new HashMap<Integer, T>();
			componentStores.put(component.getClass(), store);
		}
		((HashMap<Integer, T>)store).put(entity, component);
	}
	
	public int createEntity(){
		int newID = generateNewEntityID();
		if(newID < 1){
			return 0;
		}
		else {
			Entities.add(newID);
			return newID;
		}
	}
	public int generateNewEntityID(){
		synchronized(this)
		{
			if(lowestUnassignedEntityID < Integer.MAX_VALUE){
				return lowestUnassignedEntityID++;
			}
			else{
				for(int i =1; i<Integer.MAX_VALUE; i++){
					if(!Entities.contains(i))
						return i;		
				}
				throw new Error("ERROR: no available Entity IDs; too many entities!");
			}
		}
	}
}
 