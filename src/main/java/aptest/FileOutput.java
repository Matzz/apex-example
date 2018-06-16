package aptest;

import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.annotation.Stateless;
import com.datatorrent.common.util.BaseOperator;

import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class FileOutput extends BaseOperator {

    FileOutput() {
        super();
        WriteToTmp.write("Creating FileOutput "+ LocalDateTime.now());
    }

    public final transient DefaultInputPort<Object> input = new DefaultInputPort<Object>() {
        @Override
        public void process(Object t) {
            WriteToTmp.write(t);
        }
    };
}
