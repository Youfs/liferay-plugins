/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.workflow.kaleo.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.workflow.kaleo.NoSuchActionException;
import com.liferay.portal.workflow.kaleo.model.KaleoAction;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoActionImpl;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoActionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="KaleoActionPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       KaleoActionPersistence
 * @see       KaleoActionUtil
 * @generated
 */
public class KaleoActionPersistenceImpl extends BasePersistenceImpl<KaleoAction>
	implements KaleoActionPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = KaleoActionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_KALEODEFINITIONID = new FinderPath(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByKaleoDefinitionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_KALEODEFINITIONID = new FinderPath(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByKaleoDefinitionId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_KNI_ET = new FinderPath(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByKNI_ET",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_KNI_ET = new FinderPath(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByKNI_ET",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(KaleoAction kaleoAction) {
		EntityCacheUtil.putResult(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionImpl.class, kaleoAction.getPrimaryKey(), kaleoAction);
	}

	public void cacheResult(List<KaleoAction> kaleoActions) {
		for (KaleoAction kaleoAction : kaleoActions) {
			if (EntityCacheUtil.getResult(
						KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
						KaleoActionImpl.class, kaleoAction.getPrimaryKey(), this) == null) {
				cacheResult(kaleoAction);
			}
		}
	}

	public void clearCache() {
		CacheRegistryUtil.clear(KaleoActionImpl.class.getName());
		EntityCacheUtil.clearCache(KaleoActionImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public void clearCache(KaleoAction kaleoAction) {
		EntityCacheUtil.removeResult(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionImpl.class, kaleoAction.getPrimaryKey());
	}

	public KaleoAction create(long kaleoActionId) {
		KaleoAction kaleoAction = new KaleoActionImpl();

		kaleoAction.setNew(true);
		kaleoAction.setPrimaryKey(kaleoActionId);

		return kaleoAction;
	}

	public KaleoAction remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	public KaleoAction remove(long kaleoActionId)
		throws NoSuchActionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KaleoAction kaleoAction = (KaleoAction)session.get(KaleoActionImpl.class,
					new Long(kaleoActionId));

			if (kaleoAction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + kaleoActionId);
				}

				throw new NoSuchActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					kaleoActionId);
			}

			return remove(kaleoAction);
		}
		catch (NoSuchActionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KaleoAction removeImpl(KaleoAction kaleoAction)
		throws SystemException {
		kaleoAction = toUnwrappedModel(kaleoAction);

		Session session = null;

		try {
			session = openSession();

			if (kaleoAction.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(KaleoActionImpl.class,
						kaleoAction.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(kaleoAction);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionImpl.class, kaleoAction.getPrimaryKey());

		return kaleoAction;
	}

	public KaleoAction updateImpl(
		com.liferay.portal.workflow.kaleo.model.KaleoAction kaleoAction,
		boolean merge) throws SystemException {
		kaleoAction = toUnwrappedModel(kaleoAction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, kaleoAction, merge);

			kaleoAction.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoActionImpl.class, kaleoAction.getPrimaryKey(), kaleoAction);

		return kaleoAction;
	}

	protected KaleoAction toUnwrappedModel(KaleoAction kaleoAction) {
		if (kaleoAction instanceof KaleoActionImpl) {
			return kaleoAction;
		}

		KaleoActionImpl kaleoActionImpl = new KaleoActionImpl();

		kaleoActionImpl.setNew(kaleoAction.isNew());
		kaleoActionImpl.setPrimaryKey(kaleoAction.getPrimaryKey());

		kaleoActionImpl.setKaleoActionId(kaleoAction.getKaleoActionId());
		kaleoActionImpl.setGroupId(kaleoAction.getGroupId());
		kaleoActionImpl.setCompanyId(kaleoAction.getCompanyId());
		kaleoActionImpl.setUserId(kaleoAction.getUserId());
		kaleoActionImpl.setUserName(kaleoAction.getUserName());
		kaleoActionImpl.setCreateDate(kaleoAction.getCreateDate());
		kaleoActionImpl.setModifiedDate(kaleoAction.getModifiedDate());
		kaleoActionImpl.setKaleoDefinitionId(kaleoAction.getKaleoDefinitionId());
		kaleoActionImpl.setKaleoNodeId(kaleoAction.getKaleoNodeId());
		kaleoActionImpl.setKaleoNodeName(kaleoAction.getKaleoNodeName());
		kaleoActionImpl.setName(kaleoAction.getName());
		kaleoActionImpl.setDescription(kaleoAction.getDescription());
		kaleoActionImpl.setExecutionType(kaleoAction.getExecutionType());
		kaleoActionImpl.setScript(kaleoAction.getScript());
		kaleoActionImpl.setScriptLanguage(kaleoAction.getScriptLanguage());
		kaleoActionImpl.setPriority(kaleoAction.getPriority());

		return kaleoActionImpl;
	}

	public KaleoAction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	public KaleoAction findByPrimaryKey(long kaleoActionId)
		throws NoSuchActionException, SystemException {
		KaleoAction kaleoAction = fetchByPrimaryKey(kaleoActionId);

		if (kaleoAction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + kaleoActionId);
			}

			throw new NoSuchActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				kaleoActionId);
		}

		return kaleoAction;
	}

	public KaleoAction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	public KaleoAction fetchByPrimaryKey(long kaleoActionId)
		throws SystemException {
		KaleoAction kaleoAction = (KaleoAction)EntityCacheUtil.getResult(KaleoActionModelImpl.ENTITY_CACHE_ENABLED,
				KaleoActionImpl.class, kaleoActionId, this);

		if (kaleoAction == null) {
			Session session = null;

			try {
				session = openSession();

				kaleoAction = (KaleoAction)session.get(KaleoActionImpl.class,
						new Long(kaleoActionId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (kaleoAction != null) {
					cacheResult(kaleoAction);
				}

				closeSession(session);
			}
		}

		return kaleoAction;
	}

	public List<KaleoAction> findByKaleoDefinitionId(long kaleoDefinitionId)
		throws SystemException {
		return findByKaleoDefinitionId(kaleoDefinitionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	public List<KaleoAction> findByKaleoDefinitionId(long kaleoDefinitionId,
		int start, int end) throws SystemException {
		return findByKaleoDefinitionId(kaleoDefinitionId, start, end, null);
	}

	public List<KaleoAction> findByKaleoDefinitionId(long kaleoDefinitionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				kaleoDefinitionId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<KaleoAction> list = (List<KaleoAction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_KALEODEFINITIONID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_KALEOACTION_WHERE);

				query.append(_FINDER_COLUMN_KALEODEFINITIONID_KALEODEFINITIONID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(KaleoActionModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(kaleoDefinitionId);

				list = (List<KaleoAction>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<KaleoAction>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_KALEODEFINITIONID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public KaleoAction findByKaleoDefinitionId_First(long kaleoDefinitionId,
		OrderByComparator orderByComparator)
		throws NoSuchActionException, SystemException {
		List<KaleoAction> list = findByKaleoDefinitionId(kaleoDefinitionId, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("kaleoDefinitionId=");
			msg.append(kaleoDefinitionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KaleoAction findByKaleoDefinitionId_Last(long kaleoDefinitionId,
		OrderByComparator orderByComparator)
		throws NoSuchActionException, SystemException {
		int count = countByKaleoDefinitionId(kaleoDefinitionId);

		List<KaleoAction> list = findByKaleoDefinitionId(kaleoDefinitionId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("kaleoDefinitionId=");
			msg.append(kaleoDefinitionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KaleoAction[] findByKaleoDefinitionId_PrevAndNext(
		long kaleoActionId, long kaleoDefinitionId,
		OrderByComparator orderByComparator)
		throws NoSuchActionException, SystemException {
		KaleoAction kaleoAction = findByPrimaryKey(kaleoActionId);

		Session session = null;

		try {
			session = openSession();

			KaleoAction[] array = new KaleoActionImpl[3];

			array[0] = getByKaleoDefinitionId_PrevAndNext(session, kaleoAction,
					kaleoDefinitionId, orderByComparator, true);

			array[1] = kaleoAction;

			array[2] = getByKaleoDefinitionId_PrevAndNext(session, kaleoAction,
					kaleoDefinitionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KaleoAction getByKaleoDefinitionId_PrevAndNext(Session session,
		KaleoAction kaleoAction, long kaleoDefinitionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KALEOACTION_WHERE);

		query.append(_FINDER_COLUMN_KALEODEFINITIONID_KALEODEFINITIONID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(KaleoActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(kaleoDefinitionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(kaleoAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KaleoAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	public List<KaleoAction> findByKNI_ET(long kaleoNodeId, String executionType)
		throws SystemException {
		return findByKNI_ET(kaleoNodeId, executionType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	public List<KaleoAction> findByKNI_ET(long kaleoNodeId,
		String executionType, int start, int end) throws SystemException {
		return findByKNI_ET(kaleoNodeId, executionType, start, end, null);
	}

	public List<KaleoAction> findByKNI_ET(long kaleoNodeId,
		String executionType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				kaleoNodeId, executionType,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<KaleoAction> list = (List<KaleoAction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_KNI_ET,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(4 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(4);
				}

				query.append(_SQL_SELECT_KALEOACTION_WHERE);

				query.append(_FINDER_COLUMN_KNI_ET_KALEONODEID_2);

				if (executionType == null) {
					query.append(_FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_1);
				}
				else {
					if (executionType.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_3);
					}
					else {
						query.append(_FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(KaleoActionModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(kaleoNodeId);

				if (executionType != null) {
					qPos.add(executionType);
				}

				list = (List<KaleoAction>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<KaleoAction>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_KNI_ET,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public KaleoAction findByKNI_ET_First(long kaleoNodeId,
		String executionType, OrderByComparator orderByComparator)
		throws NoSuchActionException, SystemException {
		List<KaleoAction> list = findByKNI_ET(kaleoNodeId, executionType, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("kaleoNodeId=");
			msg.append(kaleoNodeId);

			msg.append(", executionType=");
			msg.append(executionType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KaleoAction findByKNI_ET_Last(long kaleoNodeId,
		String executionType, OrderByComparator orderByComparator)
		throws NoSuchActionException, SystemException {
		int count = countByKNI_ET(kaleoNodeId, executionType);

		List<KaleoAction> list = findByKNI_ET(kaleoNodeId, executionType,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("kaleoNodeId=");
			msg.append(kaleoNodeId);

			msg.append(", executionType=");
			msg.append(executionType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KaleoAction[] findByKNI_ET_PrevAndNext(long kaleoActionId,
		long kaleoNodeId, String executionType,
		OrderByComparator orderByComparator)
		throws NoSuchActionException, SystemException {
		KaleoAction kaleoAction = findByPrimaryKey(kaleoActionId);

		Session session = null;

		try {
			session = openSession();

			KaleoAction[] array = new KaleoActionImpl[3];

			array[0] = getByKNI_ET_PrevAndNext(session, kaleoAction,
					kaleoNodeId, executionType, orderByComparator, true);

			array[1] = kaleoAction;

			array[2] = getByKNI_ET_PrevAndNext(session, kaleoAction,
					kaleoNodeId, executionType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KaleoAction getByKNI_ET_PrevAndNext(Session session,
		KaleoAction kaleoAction, long kaleoNodeId, String executionType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KALEOACTION_WHERE);

		query.append(_FINDER_COLUMN_KNI_ET_KALEONODEID_2);

		if (executionType == null) {
			query.append(_FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_1);
		}
		else {
			if (executionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(KaleoActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(kaleoNodeId);

		if (executionType != null) {
			qPos.add(executionType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(kaleoAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KaleoAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	public List<KaleoAction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<KaleoAction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<KaleoAction> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<KaleoAction> list = (List<KaleoAction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_KALEOACTION);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_KALEOACTION.concat(KaleoActionModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<KaleoAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<KaleoAction>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<KaleoAction>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByKaleoDefinitionId(long kaleoDefinitionId)
		throws SystemException {
		for (KaleoAction kaleoAction : findByKaleoDefinitionId(
				kaleoDefinitionId)) {
			remove(kaleoAction);
		}
	}

	public void removeByKNI_ET(long kaleoNodeId, String executionType)
		throws SystemException {
		for (KaleoAction kaleoAction : findByKNI_ET(kaleoNodeId, executionType)) {
			remove(kaleoAction);
		}
	}

	public void removeAll() throws SystemException {
		for (KaleoAction kaleoAction : findAll()) {
			remove(kaleoAction);
		}
	}

	public int countByKaleoDefinitionId(long kaleoDefinitionId)
		throws SystemException {
		Object[] finderArgs = new Object[] { kaleoDefinitionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_KALEODEFINITIONID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_KALEOACTION_WHERE);

				query.append(_FINDER_COLUMN_KALEODEFINITIONID_KALEODEFINITIONID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(kaleoDefinitionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KALEODEFINITIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByKNI_ET(long kaleoNodeId, String executionType)
		throws SystemException {
		Object[] finderArgs = new Object[] { kaleoNodeId, executionType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_KNI_ET,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_COUNT_KALEOACTION_WHERE);

				query.append(_FINDER_COLUMN_KNI_ET_KALEONODEID_2);

				if (executionType == null) {
					query.append(_FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_1);
				}
				else {
					if (executionType.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_3);
					}
					else {
						query.append(_FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(kaleoNodeId);

				if (executionType != null) {
					qPos.add(executionType);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KNI_ET,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KALEOACTION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portal.workflow.kaleo.model.KaleoAction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KaleoAction>> listenersList = new ArrayList<ModelListener<KaleoAction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KaleoAction>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = KaleoActionPersistence.class)
	protected KaleoActionPersistence kaleoActionPersistence;
	@BeanReference(type = KaleoDefinitionPersistence.class)
	protected KaleoDefinitionPersistence kaleoDefinitionPersistence;
	@BeanReference(type = KaleoInstancePersistence.class)
	protected KaleoInstancePersistence kaleoInstancePersistence;
	@BeanReference(type = KaleoInstanceTokenPersistence.class)
	protected KaleoInstanceTokenPersistence kaleoInstanceTokenPersistence;
	@BeanReference(type = KaleoLogPersistence.class)
	protected KaleoLogPersistence kaleoLogPersistence;
	@BeanReference(type = KaleoNodePersistence.class)
	protected KaleoNodePersistence kaleoNodePersistence;
	@BeanReference(type = KaleoNotificationPersistence.class)
	protected KaleoNotificationPersistence kaleoNotificationPersistence;
	@BeanReference(type = KaleoNotificationRecipientPersistence.class)
	protected KaleoNotificationRecipientPersistence kaleoNotificationRecipientPersistence;
	@BeanReference(type = KaleoTaskPersistence.class)
	protected KaleoTaskPersistence kaleoTaskPersistence;
	@BeanReference(type = KaleoTaskAssignmentPersistence.class)
	protected KaleoTaskAssignmentPersistence kaleoTaskAssignmentPersistence;
	@BeanReference(type = KaleoTaskAssignmentInstancePersistence.class)
	protected KaleoTaskAssignmentInstancePersistence kaleoTaskAssignmentInstancePersistence;
	@BeanReference(type = KaleoTaskInstanceTokenPersistence.class)
	protected KaleoTaskInstanceTokenPersistence kaleoTaskInstanceTokenPersistence;
	@BeanReference(type = KaleoTransitionPersistence.class)
	protected KaleoTransitionPersistence kaleoTransitionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_KALEOACTION = "SELECT kaleoAction FROM KaleoAction kaleoAction";
	private static final String _SQL_SELECT_KALEOACTION_WHERE = "SELECT kaleoAction FROM KaleoAction kaleoAction WHERE ";
	private static final String _SQL_COUNT_KALEOACTION = "SELECT COUNT(kaleoAction) FROM KaleoAction kaleoAction";
	private static final String _SQL_COUNT_KALEOACTION_WHERE = "SELECT COUNT(kaleoAction) FROM KaleoAction kaleoAction WHERE ";
	private static final String _FINDER_COLUMN_KALEODEFINITIONID_KALEODEFINITIONID_2 =
		"kaleoAction.kaleoDefinitionId = ?";
	private static final String _FINDER_COLUMN_KNI_ET_KALEONODEID_2 = "kaleoAction.kaleoNodeId = ? AND ";
	private static final String _FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_1 = "kaleoAction.executionType IS NULL";
	private static final String _FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_2 = "kaleoAction.executionType = ?";
	private static final String _FINDER_COLUMN_KNI_ET_EXECUTIONTYPE_3 = "(kaleoAction.executionType IS NULL OR kaleoAction.executionType = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kaleoAction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KaleoAction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KaleoAction exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(KaleoActionPersistenceImpl.class);
}