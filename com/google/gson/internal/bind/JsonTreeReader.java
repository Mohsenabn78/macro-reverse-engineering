package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import net.bytebuddy.pool.TypePool;

/* loaded from: classes5.dex */
public final class JsonTreeReader extends JsonReader {

    /* renamed from: e  reason: collision with root package name */
    private static final Reader f32680e = new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i4, int i5) {
            throw new AssertionError();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static final Object f32681f = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Object[] f32682a;

    /* renamed from: b  reason: collision with root package name */
    private int f32683b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f32684c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f32685d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.bind.JsonTreeReader$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32686a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f32686a = iArr;
            try {
                iArr[JsonToken.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32686a[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32686a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32686a[JsonToken.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public JsonTreeReader(JsonElement jsonElement) {
        super(f32680e);
        this.f32682a = new Object[32];
        this.f32683b = 0;
        this.f32684c = new String[32];
        this.f32685d = new int[32];
        g(jsonElement);
    }

    private void b(JsonToken jsonToken) throws IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    private String d(boolean z3) throws IOException {
        String str;
        b(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) e()).next();
        String str2 = (String) entry.getKey();
        String[] strArr = this.f32684c;
        int i4 = this.f32683b - 1;
        if (z3) {
            str = "<skipped>";
        } else {
            str = str2;
        }
        strArr[i4] = str;
        g(entry.getValue());
        return str2;
    }

    private Object e() {
        return this.f32682a[this.f32683b - 1];
    }

    private Object f() {
        Object[] objArr = this.f32682a;
        int i4 = this.f32683b - 1;
        this.f32683b = i4;
        Object obj = objArr[i4];
        objArr[i4] = null;
        return obj;
    }

    private void g(Object obj) {
        int i4 = this.f32683b;
        Object[] objArr = this.f32682a;
        if (i4 == objArr.length) {
            int i5 = i4 * 2;
            this.f32682a = Arrays.copyOf(objArr, i5);
            this.f32685d = Arrays.copyOf(this.f32685d, i5);
            this.f32684c = (String[]) Arrays.copyOf(this.f32684c, i5);
        }
        Object[] objArr2 = this.f32682a;
        int i6 = this.f32683b;
        this.f32683b = i6 + 1;
        objArr2[i6] = obj;
    }

    private String getPath(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        int i4 = 0;
        while (true) {
            int i5 = this.f32683b;
            if (i4 < i5) {
                Object[] objArr = this.f32682a;
                Object obj = objArr[i4];
                if (obj instanceof JsonArray) {
                    i4++;
                    if (i4 < i5 && (objArr[i4] instanceof Iterator)) {
                        int i6 = this.f32685d[i4];
                        if (z3 && i6 > 0 && (i4 == i5 - 1 || i4 == i5 - 2)) {
                            i6--;
                        }
                        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                        sb.append(i6);
                        sb.append(']');
                    }
                } else if ((obj instanceof JsonObject) && (i4 = i4 + 1) < i5 && (objArr[i4] instanceof Iterator)) {
                    sb.append('.');
                    String str = this.f32684c[i4];
                    if (str != null) {
                        sb.append(str);
                    }
                }
                i4++;
            } else {
                return sb.toString();
            }
        }
    }

    private String locationString() {
        return " at path " + getPath();
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        b(JsonToken.BEGIN_ARRAY);
        g(((JsonArray) e()).iterator());
        this.f32685d[this.f32683b - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        b(JsonToken.BEGIN_OBJECT);
        g(((JsonObject) e()).entrySet().iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonElement c() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.NAME && peek != JsonToken.END_ARRAY && peek != JsonToken.END_OBJECT && peek != JsonToken.END_DOCUMENT) {
            JsonElement jsonElement = (JsonElement) e();
            skipValue();
            return jsonElement;
        }
        throw new IllegalStateException("Unexpected " + peek + " when reading a JsonElement.");
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f32682a = new Object[]{f32681f};
        this.f32683b = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        b(JsonToken.END_ARRAY);
        f();
        f();
        int i4 = this.f32683b;
        if (i4 > 0) {
            int[] iArr = this.f32685d;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        b(JsonToken.END_OBJECT);
        this.f32684c[this.f32683b - 1] = null;
        f();
        f();
        int i4 = this.f32683b;
        if (i4 > 0) {
            int[] iArr = this.f32685d;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.END_OBJECT && peek != JsonToken.END_ARRAY && peek != JsonToken.END_DOCUMENT) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        b(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) f()).getAsBoolean();
        int i4 = this.f32683b;
        if (i4 > 0) {
            int[] iArr = this.f32685d;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        double asDouble = ((JsonPrimitive) e()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + asDouble);
        }
        f();
        int i4 = this.f32683b;
        if (i4 > 0) {
            int[] iArr = this.f32685d;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        int asInt = ((JsonPrimitive) e()).getAsInt();
        f();
        int i4 = this.f32683b;
        if (i4 > 0) {
            int[] iArr = this.f32685d;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asInt;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        long asLong = ((JsonPrimitive) e()).getAsLong();
        f();
        int i4 = this.f32683b;
        if (i4 > 0) {
            int[] iArr = this.f32685d;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        return d(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        b(JsonToken.NULL);
        f();
        int i4 = this.f32683b;
        if (i4 > 0) {
            int[] iArr = this.f32685d;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek != jsonToken && peek != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        String asString = ((JsonPrimitive) f()).getAsString();
        int i4 = this.f32683b;
        if (i4 > 0) {
            int[] iArr = this.f32685d;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.f32683b == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object e4 = e();
        if (e4 instanceof Iterator) {
            boolean z3 = this.f32682a[this.f32683b - 2] instanceof JsonObject;
            Iterator it = (Iterator) e4;
            if (it.hasNext()) {
                if (z3) {
                    return JsonToken.NAME;
                }
                g(it.next());
                return peek();
            } else if (z3) {
                return JsonToken.END_OBJECT;
            } else {
                return JsonToken.END_ARRAY;
            }
        } else if (e4 instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (e4 instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (e4 instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) e4;
                if (jsonPrimitive.isString()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (e4 instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (e4 == f32681f) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new MalformedJsonException("Custom JsonElement subclass " + e4.getClass().getName() + " is not supported");
            }
        }
    }

    public void promoteNameToValue() throws IOException {
        b(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) e()).next();
        g(entry.getValue());
        g(new JsonPrimitive((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        int i4 = AnonymousClass2.f32686a[peek().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        f();
                        int i5 = this.f32683b;
                        if (i5 > 0) {
                            int[] iArr = this.f32685d;
                            int i6 = i5 - 1;
                            iArr[i6] = iArr[i6] + 1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                endObject();
                return;
            }
            endArray();
            return;
        }
        d(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return JsonTreeReader.class.getSimpleName() + locationString();
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        return getPath(false);
    }
}
