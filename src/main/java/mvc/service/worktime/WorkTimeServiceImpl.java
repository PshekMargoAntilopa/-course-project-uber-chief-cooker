package mvc.service.worktime;

import mvc.entity.worktime.WorkTime;
import mvc.repository.worktime.WorkTimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class WorkTimeServiceImpl implements WorkTimeService {

    private final WorkTimeRepository workTimeRepository;

    public WorkTimeServiceImpl(WorkTimeRepository workTimeRepository) {
        this.workTimeRepository = workTimeRepository;
    }

    @Transactional
    @Override
    public void create(WorkTime time) {
        workTimeRepository.create(time);
    }

    @Transactional
    @Override
    public WorkTime read(int id) {
        return workTimeRepository.read(id);
    }

    @Transactional
    @Override
    public void update(WorkTime time) {
        WorkTime updateWorkTime = workTimeRepository.read(time.getId());
        updateWorkTime.setDay(time.getDay());
        updateWorkTime.setStartTime(time.getStartTime());
        updateWorkTime.setEndTime(time.getEndTime());
        workTimeRepository.update(time);
    }

    @Transactional
    @Override
    public void delete(int id) {
        workTimeRepository.delete(id);
    }








}
