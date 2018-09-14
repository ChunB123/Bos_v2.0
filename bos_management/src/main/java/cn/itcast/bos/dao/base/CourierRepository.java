package cn.itcast.bos.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.base.Courier;

public interface CourierRepository extends JpaRepository<Courier, Integer>,JpaSpecificationExecutor<Courier>{

	//查询操作,直接使用Query
	//修改删除操作,使用注解Modifying
	@Query(value = "update Courier set deltag='1' where id = ?")
	@Modifying
	void updateDelTag(Integer id);
}
