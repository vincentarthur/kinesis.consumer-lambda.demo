package kinesis.consumer.lambda.demo.entity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;

/**
 * Created by vwmc on 9/25/17.
 */
@Data
public class UberRequestRecord {
    private final static ObjectMapper JSON = new ObjectMapper();

    static {
        JSON.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private String longtitude;
    private String latitude;
    private String time;
    private String location;


    public byte[] toJsonAsBytes() {
        try {
            return JSON.writeValueAsBytes(this);
        } catch (IOException e) {
            return null;
        }
    }

    public static UberRequestRecord fromJsonAsBytes(byte[] bytes) {
        try {
            return JSON.readValue(bytes, UberRequestRecord.class);
        } catch (IOException e) {
            return null;
        }
    }
}
