/**
 * Put your copyright and license info here.
 */
package aptest;

import com.datatorrent.api.DefaultOutputPort;
import com.datatorrent.api.InputOperator;
import com.datatorrent.common.util.BaseOperator;

import java.time.LocalDateTime;

/**
 * This is a simple operator that emits random number.
 */
public class SequenceGenerator extends BaseOperator implements InputOperator {

    SequenceGenerator() {
        super();
        WriteToTmp.write("Creating SequenceGenerator " + LocalDateTime.now());
    }

    private int count = 0;
    private boolean emittedInWindow = false;

    public final transient DefaultOutputPort<Double> out = new DefaultOutputPort<Double>();

    @Override
    public void beginWindow(long windowId) {
        emittedInWindow = false;
    }

    @Override
    public void emitTuples() {

        if (!emittedInWindow) {
//      FailureGenerator.failOrNot("sequence generator");
            count++;
            out.emit(new Double(count));
            emittedInWindow = true;
        }
    }
}
