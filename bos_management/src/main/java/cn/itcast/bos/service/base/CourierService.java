package cn.itcast.bos.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import cn.itcast.bos.domain.base.Courier;

import java.util.List;

/**
 * 快递员操作接口
 * 
 * @author itcast
 *
 */
public interface CourierService {

	// 保存快递员
	void save(Courier courier);


	Page<Courier> findPageData(Specification<Courier> specification,Pageable pageable);

	void delBatch(String[] idArray);

	List<Courier> findNoAssociation();
}
