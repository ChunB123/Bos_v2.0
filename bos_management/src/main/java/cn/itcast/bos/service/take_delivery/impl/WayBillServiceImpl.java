package cn.itcast.bos.service.take_delivery.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.take_delivery.WayBillRepository;
import cn.itcast.bos.domain.take_delivery.WayBill;

import cn.itcast.bos.service.take_delivery.WayBillService;

import java.lang.reflect.InvocationTargetException;

@Service
@Transactional
public class WayBillServiceImpl implements WayBillService {

	@Autowired
	private WayBillRepository wayBillRepository;
/*
	@Autowired
	private WayBillIndexRepository wayBillIndexRepository;*/

	@Override
	public void save(WayBill wayBill) {

		// 判断运单号是否存在
		WayBill persistWayBill = wayBillRepository.findByWayBillNum(wayBill
				.getWayBillNum());
		if (persistWayBill == null || persistWayBill.getId() == null) {
			// 运单不存在
			wayBillRepository.save(wayBill);
			// 保存索引
			//wayBillIndexRepository.save(wayBill);
		} else {
			// 运单存在
			try {
				Integer id = persistWayBill.getId();
				BeanUtils.copyProperties(persistWayBill, wayBill);
				persistWayBill.setId(id);
				//为什么此处不用save,自动保存,是不是因为修改了hibernate的持久化对象
				// 保存索引
				//wayBillIndexRepository.save(persistWayBill);

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
		}

	}

	@Override
	public Page<WayBill> findPageData(Pageable pageable) {
		// 判断WayBill 中条件是否存在
		/*if (StringUtils.isBlank(wayBill.getWayBillNum())
				&& StringUtils.isBlank(wayBill.getSendAddress())
				&& StringUtils.isBlank(wayBill.getRecAddress())
				&& StringUtils.isBlank(wayBill.getSendProNum())
				&& (wayBill.getSignStatus() == null || wayBill.getSignStatus() == 0)) {
			// 无条件查询 、查询数据库
			return wayBillRepository.findAll(pageable);
		} else {
			// 查询条件
			// must 条件必须成立 and
			// must not 条件必须不成立 not
			// should 条件可以成立 or
			BoolQueryBuilder query = new BoolQueryBuilder(); // 布尔查询 ，多条件组合查询
			// 向组合查询对象添加条件
			if (StringUtils.isNoneBlank(wayBill.getWayBillNum())) {
				// 运单号查询
				QueryBuilder tempQuery = new TermQueryBuilder("wayBillNum",
						wayBill.getWayBillNum());
				query.must(tempQuery);
			}
			if (StringUtils.isNoneBlank(wayBill.getSendAddress())) {
				// 发货地 模糊查询
				QueryBuilder wildcardQuery = new WildcardQueryBuilder(
						"sendAddress", "*" + wayBill.getSendAddress() + "*");
				query.must(wildcardQuery);
			}
			if (StringUtils.isNoneBlank(wayBill.getRecAddress())) {
				// 收货地 模糊查询
				QueryBuilder wildcardQuery = new WildcardQueryBuilder(
						"recAddress", "*" + wayBill.getRecAddress() + "*");
				query.must(wildcardQuery);
			}
			if (StringUtils.isNoneBlank(wayBill.getSendProNum())) {
				// 速运类型 等值查询
				QueryBuilder termQuery = new TermQueryBuilder("sendProNum",
						wayBill.getSendProNum());
				query.must(termQuery);
			}
			if (StringUtils.isNoneBlank(wayBill.getSendProNum())) {
				// 速运类型 等值查询
				QueryBuilder termQuery = new TermQueryBuilder("sendProNum",
						wayBill.getSendProNum());
				query.must(termQuery);
			}
			if (wayBill.getSignStatus() != null && wayBill.getSignStatus() != 0) {
				// 签收状态查询
				QueryBuilder termQuery = new TermQueryBuilder("signStatus",
						wayBill.getSignStatus());
				query.must(termQuery);
			}

			SearchQuery searchQuery = new NativeSearchQuery(query);
			searchQuery.setPageable(pageable); // 分页效果
			// 有条件查询 、查询索引库
			return wayBillIndexRepository.search(searchQuery);
		}*/
		return wayBillRepository.findAll(pageable);

	}

	@Override
	public WayBill findByWayBillNum(String wayBillNum) {
		return wayBillRepository.findByWayBillNum(wayBillNum);
	}

}
