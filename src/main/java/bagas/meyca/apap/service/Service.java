package bagas.meyca.apap.service;

import java.util.List;

public interface Service<T> {
	
	T get(Long id);
	List<T> getAll();
	
	T add(T object);
	T update(T object);
	T delete(Long id);
	
}
