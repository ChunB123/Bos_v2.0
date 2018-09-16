package cn.itcast.bos.dao.base;

import cn.itcast.bos.domain.base.FixedArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author YaphetS
 * @date 2018/9/14 上午9:11
 */
public interface FixedAreaRepository extends JpaRepository<FixedArea, String>,JpaSpecificationExecutor<FixedArea> {
}
