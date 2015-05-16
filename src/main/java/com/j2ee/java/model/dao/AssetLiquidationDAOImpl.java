package com.j2ee.java.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.j2ee.java.model.dto.AssetLiquidation;

public class AssetLiquidationDAOImpl implements AssetLiquidationDAO {

	static Logger logger = Logger.getLogger(AssetLiquidationDAOImpl.class.getName());
	@Override
	public AssetLiquidation getByID(int id) {
		// TODO Auto-generated method stub
		AssetLiquidation result = new AssetLiquidation();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			result = (AssetLiquidation) session.get(AssetLiquidation.class, id);

			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AssetLiquidation> getAllAssetLiquidation() {
		// TODO Auto-generated method stub
		List<AssetLiquidation> list = new ArrayList<AssetLiquidation>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(AssetLiquidation.class);
			list = criteria.list();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return list;
	}

	@Override
	public boolean insertAssetLiquidation(AssetLiquidation assetLiquidation) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.save(assetLiquidation);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save AssetLiquidation");
		}
		return result;
	}

	@Override
	public boolean updateAssetLiquidation(AssetLiquidation assetLiquidation) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.update(assetLiquidation);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update AssetLiquidation");
		}
		return result;
	}

	@Override
	public boolean deleteAssetLiquidation(AssetLiquidation assetLiquidation) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.delete(assetLiquidation);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete AssetLiquidation");
		}
		return result;
	}

}
