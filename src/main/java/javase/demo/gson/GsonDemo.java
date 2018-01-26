package javase.demo.gson;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class GsonDemo {
    public void objToJson() {
        BagOfPrimitives obj = new BagOfPrimitives();
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        System.out.println("json=" + json);
    }

    public void jsonToObj() {
        String json = "{\"value1\":1,\"value2\":\"abc\"}";
        Gson gson = new Gson();
        BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
        String output = ReflectionToStringBuilder.toString(obj2, ToStringStyle.MULTI_LINE_STYLE);
        System.out.println("obj2=" + output);
    }
}
