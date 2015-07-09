package SpringCacheExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledJob {
    private static Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

    @Autowired
    private SizeUnitsRepository sizeUnitsRepository;

    @Scheduled(fixedRate = 5000)
    public void doQuery(){
        logger.debug("Getting SizeUnits");
        List<SizeUnit> sizeUnits = sizeUnitsRepository.getSizeUnits();
        logger.debug("Got SizeUnits {}", sizeUnits.size());

        logger.debug("Getting SizeUnit " + 1);
        sizeUnitsRepository.getSizeUnit(1);
        logger.debug("Got SizeUnit " + 1);
    }
}
