package com.xhx.json.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.xhx.json.entity.Hourse;

import java.io.IOException;

public class HourseSerializer extends StdSerializer<Hourse> {

    public HourseSerializer(){
        super(Hourse.class);
    }

    protected HourseSerializer(Class<Hourse> t) {
        super(t);
    }

    @Override
    public void serialize(Hourse hourse, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("id");
        generator.writeString("自定义");
        generator.writeFieldName("location");
        generator.writeString(hourse.getLocation());
        generator.writeObjectField("buildDate",hourse.getBuildDate());
        generator.writeEndObject();
    }
}
