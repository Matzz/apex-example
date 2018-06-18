package aptest;

import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.DefaultOutputPort;
import com.datatorrent.common.util.BaseOperator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Aggregator extends BaseOperator {
    List<Double> state = new LinkedList<Double>();
    public final transient DefaultOutputPort<List<Double>> out = new DefaultOutputPort<List<Double>>();


    Aggregator() {
        super();
        WriteToTmp.write("Creating aggregator " + LocalDateTime.now());
    }

    public final transient DefaultInputPort<Double> input = new DefaultInputPort<Double>() {
        @Override
        public void process(Double tuple) {
            FailureGenerator.failOrNot("aggregator");
            state.add(tuple);
            out.emit(state);
        }
    };

}
