package com.example;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.connectors.kudu.streaming.KuduSource;

public class FlinkReplicationJob{
    public static void main(String[] args) throws Exception {
        final String kuduMaster = "127.0.0.1:8764";
        final String tableName = "test_table";

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> kuduSourceStream = env.addSource(new KuduSource(kuduMaster, tableName));

//        kuduSourceStream.sinkTo()

        kuduSourceStream.print();

        env.execute("Kudu Source Job");
    }
}
