package fr.epf.lastminutetraining.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epf.lastminutetraining.dao.VendorDAO;
import fr.epf.lastminutetraining.domain.Vendor;

@Service
public class VendorDBService {

	@Autowired
	private VendorDAO vendorDAO;

	public VendorDBService() {
	}

	public Vendor findVendor(ObjectId id) {
		//System.out.println(id);
		return vendorDAO.findVendor(id);
	}

	public List<Vendor> findAllVendors() {
		return vendorDAO.findAllVendors();
	}

	public void save(Vendor vendor) {
		vendorDAO.saveVendor(vendor);
	}

	public void create(Vendor vendor) {
		vendorDAO.saveVendor(vendor);
	}

	public void update(Vendor vendor) {
		vendorDAO.saveVendor(vendor);
	}

	public void remove(Vendor vendor) {
		vendorDAO.removeVendor(vendor);
	}

	public Vendor connect(String login, String password) {
		return vendorDAO.connect(login, password);
	}
}
