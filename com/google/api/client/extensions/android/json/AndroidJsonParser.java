package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonReader;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Beta
@TargetApi(11)
/* loaded from: classes5.dex */
class AndroidJsonParser extends JsonParser {

    /* renamed from: c  reason: collision with root package name */
    private final JsonReader f25543c;

    /* renamed from: d  reason: collision with root package name */
    private final AndroidJsonFactory f25544d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f25545e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private JsonToken f25546f;

    /* renamed from: g  reason: collision with root package name */
    private String f25547g;

    /* renamed from: com.google.api.client.extensions.android.json.AndroidJsonParser$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25548a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f25549b;

        static {
            int[] iArr = new int[android.util.JsonToken.values().length];
            f25549b = iArr;
            try {
                iArr[android.util.JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25549b[android.util.JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25549b[android.util.JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25549b[android.util.JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25549b[android.util.JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25549b[android.util.JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25549b[android.util.JsonToken.STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25549b[android.util.JsonToken.NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25549b[android.util.JsonToken.NAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[JsonToken.values().length];
            f25548a = iArr2;
            try {
                iArr2[JsonToken.START_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25548a[JsonToken.START_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidJsonParser(AndroidJsonFactory androidJsonFactory, JsonReader jsonReader) {
        this.f25544d = androidJsonFactory;
        this.f25543c = jsonReader;
        jsonReader.setLenient(true);
    }

    private void h() {
        boolean z3;
        JsonToken jsonToken = this.f25546f;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
    }

    @Override // com.google.api.client.json.JsonParser
    public void close() throws IOException {
        this.f25543c.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger getBigIntegerValue() {
        h();
        return new BigInteger(this.f25547g);
    }

    @Override // com.google.api.client.json.JsonParser
    public byte getByteValue() {
        h();
        return Byte.valueOf(this.f25547g).byteValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getCurrentName() {
        if (this.f25545e.isEmpty()) {
            return null;
        }
        List<String> list = this.f25545e;
        return list.get(list.size() - 1);
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken getCurrentToken() {
        return this.f25546f;
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal getDecimalValue() {
        h();
        return new BigDecimal(this.f25547g);
    }

    @Override // com.google.api.client.json.JsonParser
    public double getDoubleValue() {
        h();
        return Double.valueOf(this.f25547g).doubleValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonFactory getFactory() {
        return this.f25544d;
    }

    @Override // com.google.api.client.json.JsonParser
    public float getFloatValue() {
        h();
        return Float.valueOf(this.f25547g).floatValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public int getIntValue() {
        h();
        return Integer.valueOf(this.f25547g).intValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public long getLongValue() {
        h();
        return Long.valueOf(this.f25547g).longValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public short getShortValue() {
        h();
        return Short.valueOf(this.f25547g).shortValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getText() {
        return this.f25547g;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken nextToken() throws IOException {
        android.util.JsonToken jsonToken;
        JsonToken jsonToken2;
        JsonToken jsonToken3 = this.f25546f;
        if (jsonToken3 != null) {
            int i4 = AnonymousClass1.f25548a[jsonToken3.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    this.f25543c.beginObject();
                    this.f25545e.add(null);
                }
            } else {
                this.f25543c.beginArray();
                this.f25545e.add(null);
            }
        }
        try {
            jsonToken = this.f25543c.peek();
        } catch (EOFException unused) {
            jsonToken = android.util.JsonToken.END_DOCUMENT;
        }
        switch (AnonymousClass1.f25549b[jsonToken.ordinal()]) {
            case 1:
                this.f25547g = "[";
                this.f25546f = JsonToken.START_ARRAY;
                break;
            case 2:
                this.f25547g = "]";
                this.f25546f = JsonToken.END_ARRAY;
                List<String> list = this.f25545e;
                list.remove(list.size() - 1);
                this.f25543c.endArray();
                break;
            case 3:
                this.f25547g = "{";
                this.f25546f = JsonToken.START_OBJECT;
                break;
            case 4:
                this.f25547g = "}";
                this.f25546f = JsonToken.END_OBJECT;
                List<String> list2 = this.f25545e;
                list2.remove(list2.size() - 1);
                this.f25543c.endObject();
                break;
            case 5:
                if (this.f25543c.nextBoolean()) {
                    this.f25547g = "true";
                    this.f25546f = JsonToken.VALUE_TRUE;
                    break;
                } else {
                    this.f25547g = "false";
                    this.f25546f = JsonToken.VALUE_FALSE;
                    break;
                }
            case 6:
                this.f25547g = "null";
                this.f25546f = JsonToken.VALUE_NULL;
                this.f25543c.nextNull();
                break;
            case 7:
                this.f25547g = this.f25543c.nextString();
                this.f25546f = JsonToken.VALUE_STRING;
                break;
            case 8:
                String nextString = this.f25543c.nextString();
                this.f25547g = nextString;
                if (nextString.indexOf(46) == -1) {
                    jsonToken2 = JsonToken.VALUE_NUMBER_INT;
                } else {
                    jsonToken2 = JsonToken.VALUE_NUMBER_FLOAT;
                }
                this.f25546f = jsonToken2;
                break;
            case 9:
                this.f25547g = this.f25543c.nextName();
                this.f25546f = JsonToken.FIELD_NAME;
                List<String> list3 = this.f25545e;
                list3.set(list3.size() - 1, this.f25547g);
                break;
            default:
                this.f25547g = null;
                this.f25546f = null;
                break;
        }
        return this.f25546f;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser skipChildren() throws IOException {
        JsonToken jsonToken = this.f25546f;
        if (jsonToken != null) {
            int i4 = AnonymousClass1.f25548a[jsonToken.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    this.f25543c.skipValue();
                    this.f25547g = "}";
                    this.f25546f = JsonToken.END_OBJECT;
                }
            } else {
                this.f25543c.skipValue();
                this.f25547g = "]";
                this.f25546f = JsonToken.END_ARRAY;
            }
        }
        return this;
    }
}
