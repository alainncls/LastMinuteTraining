package fr.epf.lastminutetraining.service;

import fr.epf.lastminutetraining.dao.TrainingDAO;
import fr.epf.lastminutetraining.domain.Training;
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

    public Training findTraining(String name) {
        return trainingDAO.findTraining(name);
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

    public void remove(Training training) {
        trainingDAO.removeTraining(training);
    }
}
