package kinesis.consumer.lambda.demo.event;

import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import kinesis.consumer.lambda.demo.entity.SampleRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vwmc on 9/16/17.
 */
public class ProcessKinesisEvents {

    private Logger logger = LoggerFactory.getLogger(ProcessKinesisEvents.class);

    public void processEvent(KinesisEvent event) {

        event.getRecords().forEach(
                record -> {
                    SampleRecord sampleRecord = SampleRecord.fromJsonAsBytes(record.getKinesis().getData().array());
                    logger.info("Retrieved sample record.");
                    logger.info("   |------- id : " + sampleRecord.getId());
                    logger.info("   |------- content : " + sampleRecord.getContent());
                }
        );

    }

}
