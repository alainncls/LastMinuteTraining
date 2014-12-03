package fr.epf.lastminutetraining.service;

import fr.epf.lastminutetraining.dao.TrainingDAO;
import fr.epf.lastminutetraining.domain.Training;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingDBService {

	@Autowired
	private TrainingDAO trainingDAO;

	public TrainingDBService() {
	}

	public List<Training> findLastTraining() {
		return trainingDAO.findLastTraining();
	}

	public List<Training> findAllTrainings() {
		return trainingDAO.findAllTrainings();
	}
	
	public Training findOneTraining() {
		return trainingDAO.findOneTraining();
	}

	public List<Training> findAllTrainings(ObjectId id) {
		return trainingDAO.findAllTrainings(id);
	}

	public Training findTraining(String id) {
		return trainingDAO.findTraining(id);
	}

	public List<Training> searchTraining(String name) {
		return trainingDAO.searchTraining(name);
	}

	public List<Training> searchTraining(Training training) {
		return trainingDAO.searchTraining(training);
	}

	public void save(Training training) {
		trainingDAO.saveTraining(training);
	}

	public void create(Training training) {
		trainingDAO.saveTraining(training);
	}

	public void update(Training training) {
		trainingDAO.saveTraining(training);
	}

	public void remove(ObjectId id) {
		trainingDAO.removeTraining(id);
	}
}
