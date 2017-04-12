import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.StringTokenizer;

public class SimpleConsumer {
    public static void main(String[] args) throws Exception {
        if(args.length == 0){
            System.out.println("Consumer");
            return;
        }
        String topicName = "test";
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer
                <String, String>(props);
        consumer.subscribe(Arrays.asList(topicName));
        int i = 0;

        StringTokenizer st = null, st1;
        String[] temp_split = null; // 최초에 { 를 구분
        String[] temp_split1 = null; // 추후에 : 를 구분
        String buf; // first_switched 에서 : 가 여러개이므로 필요한 temp변수
        String buf_join; //first_switched에서 join을 위한 temp변수
        String[] bufff;

//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                temp_split = record.value().split("\\{");
//                st = new StringTokenizer(temp_split[2],",");
//                while(st.hasMoreTokens()){
//                    bufff = null;
//                    buf = null;
//                    buf = st.nextToken();
//                    if(buf.contains("first_switched") || buf.contains("last_switched") || buf.contains("timestamp")){
//                        bufff = buf.split(":");
//                        buf_join = bufff[1] + ":"+bufff[2]+":"+bufff[3];
//                    }else{
//                        temp_split1 = buf.split(":");
//                        buf_join = temp_split1[1];
//                    }
//                    if(buf_join.contains("\"")){
//                        st1 = new StringTokenizer(buf_join,"\"");
//                        System.out.print(st1.nextToken()+"\t");
//                    }else{
//                        System.out.print(buf_join+"\t");
//                    }
//                }
//                System.out.println();
//            }
//        }

//                while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//
//                temp_split = record.value().split("\\{");
//
//                st = new StringTokenizer(temp_split[2],",");
//
//                while(st.hasMoreTokens()){
//                    temp_split1 = st.nextToken().split(":");
//                    if(temp_split[1].contains("\"")){
//                        st1 = new StringTokenizer(temp_split[1],"\"");
//                        System.out.print(st1.nextToken()+"\t");
//                    }else
//                        System.out.print(temp_split1[1]+"\t");
////                    System.out.print(st.nextToken()+"\n" );
//                }
//                System.out.println();
//                // System.out.printf("%s\n", record.value());
//            }
//        }


//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                st = new StringTokenizer(record.value(),",");
//                while(st.hasMoreTokens()){
//                    temp_split = st.nextToken().split(":");
//                    System.out.print(temp_split[1]+"\t");
////                    System.out.print(st.nextToken()+"\n" );
//                }
//                System.out.println();
//                // System.out.printf("%s\n", record.value());
//            }
//        }
//
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                st = new StringTokenizer(record.value(),",");
//
//                while(st.hasMoreTokens()){
//                    System.out.print(st.nextToken()+"\n" );
//                }
//               // System.out.printf("%s\n", record.value());
//            }
//        }
            while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.print(record.value());
//                    st = new StringTokenizer(record.value(),",");
//
//                    while(st.hasMoreTokens()){
//                        System.out.print(st.nextToken()+"\n" );
//                    }
                // System.out.printf("%s\n", record.value());
            }
        }
    }
}
