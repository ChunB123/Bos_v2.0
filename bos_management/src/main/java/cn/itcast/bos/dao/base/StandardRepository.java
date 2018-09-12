package cn.itcast.bos.dao.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.base.Standard;

//Integer是主键的属性
public interface StandardRepository extends JpaRepository<Standard, Integer> {
	
	// 根据收派标准名称查询 
	//List<Standard> findByNameLike(String name);
	
	/*@Query(value="from Standard where name = ?" ,nativeQuery=false)
	// nativeQuery 为 false 配置J PQL 、 为true 配置SQL
	List<Standard> queryName(String name);*/
	
	/*@Query
	List<Standard> queryName(String name);*/
	

	/*@Query(value = "update Standard set minLength=? where id =?")
	@Modifying
	void updateMinLength(Integer minLength,Integer id);*/
}
