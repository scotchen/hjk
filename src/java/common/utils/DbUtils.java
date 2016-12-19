package utils;

import com.ibm.topscore.component.dao.support.inner.BeanTransformerAdpter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Component
public class DbUtils {

	@PersistenceContext
	private EntityManager em;

	public <T> List<T> query(String sql, Map<String, ?> queryParams) {
		return internalQuery(sql, queryParams);
	}

	public <T> List<T> nativeQuery(String sql, Map<String, ?> queryParams, Class<T> clazz) {
		return internalNativeQuery(sql, new BeanTransformerAdpter<>(clazz), queryParams);
	}

	public List<Map<String, Object>> nativeQuery(String sql, Map<String, ?> queryParams) {
		return internalNativeQuery(sql, Transformers.ALIAS_TO_ENTITY_MAP, queryParams);
	}

	private <T> List<T> internalNativeQuery(String sql, ResultTransformer resultTransformer, Map<String, ?> queryParams) {
		Session session = getCurrentSession();
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(resultTransformer);
		if (queryParams != null && !queryParams.isEmpty()) {
			query.setProperties(queryParams);
		}
		@SuppressWarnings("unchecked")
		List<T> result = query.list();
		return result;
	}

	private <T> List<T> internalQuery(String sql, Map<String, ?> queryParams) {
		Session session = getCurrentSession();
		Query query = session.createQuery(sql);
		if (queryParams != null && !queryParams.isEmpty()) {
			query.setProperties(queryParams);
		}
		@SuppressWarnings("unchecked")
		List<T> result = query.list();
		return result;
	}


	public Page<Map<String, Object>> nativeQueryForPaging(String sql, Map<String, ?> queryParams, PageRequest pageRequest) {
		return internalNativePagingQuery(sql, queryParams, pageRequest, Transformers.ALIAS_TO_ENTITY_MAP);
	}

	public <T> Page<T> nativeQueryForPaging(String sql, Map<String, ?> queryParams, PageRequest pageRequest, Class<T> clazz) {
		return internalNativePagingQuery(sql, queryParams, pageRequest, new BeanTransformerAdpter<>(clazz));
	}

	public <T> Page<T> queryForPaging(String sql, Map<String, ?> queryParams, PageRequest pageRequest) {
		return internalPagingQuery(sql, queryParams, pageRequest);
	}

	private <T> Page<T> internalNativePagingQuery(String sql, Map<String, ?> queryParams, PageRequest pageRequest, ResultTransformer resultTransformer) {
		int totalRow = createCountNativeQuery(sql, queryParams);
		Session session = getCurrentSession();
		Query query = session.createSQLQuery(sql);
		query.setProperties(queryParams);
		query.setResultTransformer(resultTransformer);
		query.setFirstResult(pageRequest.getOffset());
		query.setMaxResults(pageRequest.getPageSize());
		@SuppressWarnings("unchecked")
		List<T> result = query.list();
		return new PageImpl<>(result, pageRequest, totalRow);
	}

	private <T> Page<T> internalPagingQuery(String sql, Map<String, ?> queryParams, PageRequest pageRequest) {
		int totalRow = createCountQuery(sql, queryParams);
		Session session = getCurrentSession();
		Query query = session.createQuery(sql);
		query.setProperties(queryParams);
		query.setFirstResult(pageRequest.getOffset());
		query.setMaxResults(pageRequest.getPageSize());
		@SuppressWarnings("unchecked")
		List<T> result = query.list();
		return new PageImpl<>(result, pageRequest, totalRow);
	}


	public int createCountNativeQuery(String sql, Map<String, ?> param) {
		Assert.hasText(sql);
		Session session = getCurrentSession();
		Query query = session.createSQLQuery("select count(*) from (" + sql + ") t");
		query.setProperties(param);
		Object obj = query.uniqueResult();
		return obj == null ? 0 : ((BigInteger) obj).intValue();
	}

	public int createCountQuery(String hql, Map<String, ?> param) {
		Assert.hasText(hql);
		Session session = getCurrentSession();
		Query query = session.createQuery("select count(*) " + hql);
		query.setProperties(param);
		Object obj = query.uniqueResult();
		return obj == null ? 0 : ((Long) obj).intValue();
	}

	private Session getCurrentSession() {
		return em.unwrap(Session.class);
	}
}
