package top.ourck.dao;

public interface SimpleDAO<T> {

	int add(T obj);
	void delete(int id);
	void update(T obj);
	T select(int id);
}
