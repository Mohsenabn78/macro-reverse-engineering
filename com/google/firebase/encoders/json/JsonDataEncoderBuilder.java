package com.google.firebase.encoders.json;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes5.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {

    /* renamed from: e  reason: collision with root package name */
    private static final ObjectEncoder<Object> f30077e = new ObjectEncoder() { // from class: com.google.firebase.encoders.json.a
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            JsonDataEncoderBuilder.h(obj, (ObjectEncoderContext) obj2);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static final ValueEncoder<String> f30078f = new ValueEncoder() { // from class: com.google.firebase.encoders.json.b
        @Override // com.google.firebase.encoders.ValueEncoder
        public final void encode(Object obj, Object obj2) {
            ((ValueEncoderContext) obj2).add((String) obj);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static final ValueEncoder<Boolean> f30079g = new ValueEncoder() { // from class: com.google.firebase.encoders.json.c
        @Override // com.google.firebase.encoders.ValueEncoder
        public final void encode(Object obj, Object obj2) {
            JsonDataEncoderBuilder.j((Boolean) obj, (ValueEncoderContext) obj2);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private static final TimestampEncoder f30080h = new TimestampEncoder();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f30081a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f30082b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private ObjectEncoder<Object> f30083c = f30077e;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30084d = false;

    /* loaded from: classes5.dex */
    private static final class TimestampEncoder implements ValueEncoder<Date> {

        /* renamed from: a  reason: collision with root package name */
        private static final DateFormat f30086a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f30086a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private TimestampEncoder() {
        }

        @Override // com.google.firebase.encoders.ValueEncoder
        /* renamed from: a */
        public void encode(@NonNull Date date, @NonNull ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.add(f30086a.format(date));
        }
    }

    public JsonDataEncoderBuilder() {
        registerEncoder(String.class, (ValueEncoder) f30078f);
        registerEncoder(Boolean.class, (ValueEncoder) f30079g);
        registerEncoder(Date.class, (ValueEncoder) f30080h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Boolean bool, ValueEncoderContext valueEncoderContext) throws IOException {
        valueEncoderContext.add(bool.booleanValue());
    }

    @NonNull
    public DataEncoder build() {
        return new DataEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder.1
            @Override // com.google.firebase.encoders.DataEncoder
            public void encode(@NonNull Object obj, @NonNull Writer writer) throws IOException {
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, JsonDataEncoderBuilder.this.f30081a, JsonDataEncoderBuilder.this.f30082b, JsonDataEncoderBuilder.this.f30083c, JsonDataEncoderBuilder.this.f30084d);
                jsonValueObjectEncoderContext.e(obj, false);
                jsonValueObjectEncoderContext.o();
            }

            @Override // com.google.firebase.encoders.DataEncoder
            public String encode(@NonNull Object obj) {
                StringWriter stringWriter = new StringWriter();
                try {
                    encode(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
    }

    @NonNull
    public JsonDataEncoderBuilder configureWith(@NonNull Configurator configurator) {
        configurator.configure(this);
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder ignoreNullValues(boolean z3) {
        this.f30084d = z3;
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder registerFallbackEncoder(@NonNull ObjectEncoder<Object> objectEncoder) {
        this.f30083c = objectEncoder;
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ObjectEncoder<? super T> objectEncoder) {
        this.f30081a.put(cls, objectEncoder);
        this.f30082b.remove(cls);
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ValueEncoder<? super T> valueEncoder) {
        this.f30082b.put(cls, valueEncoder);
        this.f30081a.remove(cls);
        return this;
    }
}
