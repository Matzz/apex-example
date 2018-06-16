/**
 * Put your copyright and license info here.
 */
package aptest;

import org.apache.hadoop.conf.Configuration;

import com.datatorrent.api.annotation.ApplicationAnnotation;
import com.datatorrent.api.StreamingApplication;
import com.datatorrent.api.DAG;
import com.datatorrent.api.DAG.Locality;
import com.datatorrent.lib.io.ConsoleOutputOperator;

@ApplicationAnnotation(name = "MyFirstApplication")
public class Application implements StreamingApplication {

    @Override
    public void populateDAG(DAG dag, Configuration conf) {
        SequenceGenerator generator = dag.addOperator("SequenceGenerator", new SequenceGenerator());
        Aggregator aggregator = dag.addOperator("Aggregator", new Aggregator());
        FileOutput fileOutput = dag.addOperator("FileOutput", new FileOutput());

        dag.addStream("aggregate", generator.out, aggregator.input);
        dag.addStream("writer", aggregator.out, fileOutput.input);
    }
}
