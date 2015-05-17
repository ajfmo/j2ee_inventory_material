package com.j2ee.java.model.bo;

import java.util.List;

import com.j2ee.java.model.dao.ProviderDAO;
import com.j2ee.java.model.dao.ProviderDAOImpl;
import com.j2ee.java.model.dto.Provider;

public class ProviderBOImpl implements ProviderBO {

	ProviderDAO providerDAO = new ProviderDAOImpl();
	@Override
	public Provider getByID(int id) {
		// TODO Auto-generated method stub
		return providerDAO.getByID(id);
	}

	@Override
	public List<Provider> getAllProvider() {
		// TODO Auto-generated method stub
		return providerDAO.getAllProvider();
	}

	@Override
	public boolean insertProvider(Provider Provider) {
		// TODO Auto-generated method stub
		return providerDAO.insertProvider(Provider);
	}

	@Override
	public boolean updateProvider(Provider Provider) {
		// TODO Auto-generated method stub
		return providerDAO.updateProvider(Provider);
	}

	@Override
	public boolean deleteProvider(Provider Provider) {
		// TODO Auto-generated method stub
		return providerDAO.deleteProvider(Provider);
	}

}
