package top.ourck.service;

import java.util.Map;

/**
 * 通用的用户Service接口。<br>
 * 不同角色的用户Service都要实现该接口。
 * @author ourck
 * @param <T>
 */
public interface LoginCharacterService<T> {

	/**
	 * 根据给定的用户名和密码完成验证。
	 * @param userName 用户名
	 * @param password 密码
	 * @return 参数。验证成功返回的Map里包含有通过验证的用户实体和对应的UesrType
	 */
	Map<String, Object> getAuth(String userName, String password);
	Map<String, Object> register(T obj);
	T getById(int id);
	
}
