package com.getpebble.android.kit.util;

import android.util.Base64;
import com.getpebble.android.kit.util.PebbleTuple;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PebbleDictionary implements Iterable<PebbleTuple> {

    /* renamed from: a  reason: collision with root package name */
    protected final Map<Integer, PebbleTuple> f18339a = new HashMap();

    /* loaded from: classes3.dex */
    public static class PebbleDictTypeException extends RuntimeException {
        public PebbleDictTypeException(long j4, PebbleTuple.a aVar, PebbleTuple.a aVar2) {
            super(String.format("Expected type '%s', but got '%s' for key 0x%08x", aVar.name(), aVar2.name(), Long.valueOf(j4)));
        }
    }

    /* loaded from: classes3.dex */
    public static class TupleOverflowException extends RuntimeException {
        public TupleOverflowException() {
            super("Too many tuples in dict");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18340a;

        static {
            int[] iArr = new int[PebbleTuple.a.values().length];
            f18340a = iArr;
            try {
                iArr[PebbleTuple.a.BYTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18340a[PebbleTuple.a.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18340a[PebbleTuple.a.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18340a[PebbleTuple.a.UINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private PebbleTuple b(int i4, PebbleTuple.a aVar) {
        if (this.f18339a.containsKey(Integer.valueOf(i4)) && this.f18339a.get(Integer.valueOf(i4)) != null) {
            PebbleTuple pebbleTuple = this.f18339a.get(Integer.valueOf(i4));
            if (pebbleTuple.type == aVar) {
                return pebbleTuple;
            }
            throw new PebbleDictTypeException(i4, aVar, pebbleTuple.type);
        }
        return null;
    }

    private static JSONObject c(PebbleTuple pebbleTuple) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", pebbleTuple.key);
        jSONObject.put("type", pebbleTuple.type.getName());
        jSONObject.put("length", pebbleTuple.width.value);
        int i4 = a.f18340a[pebbleTuple.type.ordinal()];
        if (i4 != 1) {
            if (i4 == 2 || i4 == 3 || i4 == 4) {
                jSONObject.put("value", pebbleTuple.value);
            }
        } else {
            jSONObject.put("value", Base64.encodeToString((byte[]) pebbleTuple.value, 2));
        }
        return jSONObject;
    }

    public static PebbleDictionary fromJson(String str) throws JSONException {
        PebbleDictionary pebbleDictionary = new PebbleDictionary();
        JSONArray jSONArray = new JSONArray(str);
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i4);
            int i5 = jSONObject.getInt("key");
            PebbleTuple.b bVar = PebbleTuple.f18343c.get(Integer.valueOf(jSONObject.getInt("length")));
            int i6 = a.f18340a[PebbleTuple.f18342b.get(jSONObject.getString("type")).ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 == 4) {
                            if (bVar == PebbleTuple.b.BYTE) {
                                pebbleDictionary.addUint8(i5, (byte) jSONObject.getInt("value"));
                            } else if (bVar == PebbleTuple.b.SHORT) {
                                pebbleDictionary.addUint16(i5, (short) jSONObject.getInt("value"));
                            } else if (bVar == PebbleTuple.b.WORD) {
                                pebbleDictionary.addUint32(i5, jSONObject.getInt("value"));
                            }
                        }
                    } else if (bVar == PebbleTuple.b.BYTE) {
                        pebbleDictionary.addInt8(i5, (byte) jSONObject.getInt("value"));
                    } else if (bVar == PebbleTuple.b.SHORT) {
                        pebbleDictionary.addInt16(i5, (short) jSONObject.getInt("value"));
                    } else if (bVar == PebbleTuple.b.WORD) {
                        pebbleDictionary.addInt32(i5, jSONObject.getInt("value"));
                    }
                } else {
                    pebbleDictionary.addString(i5, jSONObject.getString("value"));
                }
            } else {
                pebbleDictionary.addBytes(i5, Base64.decode(jSONObject.getString("value"), 2));
            }
        }
        return pebbleDictionary;
    }

    protected void a(PebbleTuple pebbleTuple) {
        if (this.f18339a.size() <= 255) {
            this.f18339a.put(Integer.valueOf(pebbleTuple.key), pebbleTuple);
            return;
        }
        throw new TupleOverflowException();
    }

    public void addBytes(int i4, byte[] bArr) {
        a(PebbleTuple.b(i4, PebbleTuple.a.BYTES, PebbleTuple.b.NONE, bArr));
    }

    public void addInt16(int i4, short s3) {
        a(PebbleTuple.a(i4, PebbleTuple.a.INT, PebbleTuple.b.SHORT, s3));
    }

    public void addInt32(int i4, int i5) {
        a(PebbleTuple.a(i4, PebbleTuple.a.INT, PebbleTuple.b.WORD, i5));
    }

    public void addInt8(int i4, byte b4) {
        a(PebbleTuple.a(i4, PebbleTuple.a.INT, PebbleTuple.b.BYTE, b4));
    }

    public void addString(int i4, String str) {
        a(PebbleTuple.b(i4, PebbleTuple.a.STRING, PebbleTuple.b.NONE, str));
    }

    public void addUint16(int i4, short s3) {
        a(PebbleTuple.a(i4, PebbleTuple.a.UINT, PebbleTuple.b.SHORT, s3));
    }

    public void addUint32(int i4, int i5) {
        a(PebbleTuple.a(i4, PebbleTuple.a.UINT, PebbleTuple.b.WORD, i5));
    }

    public void addUint8(int i4, byte b4) {
        a(PebbleTuple.a(i4, PebbleTuple.a.UINT, PebbleTuple.b.BYTE, b4));
    }

    public boolean contains(int i4) {
        return this.f18339a.containsKey(Integer.valueOf(i4));
    }

    public byte[] getBytes(int i4) {
        PebbleTuple b4 = b(i4, PebbleTuple.a.BYTES);
        if (b4 == null) {
            return null;
        }
        return (byte[]) b4.value;
    }

    public Long getInteger(int i4) {
        PebbleTuple b4 = b(i4, PebbleTuple.a.INT);
        if (b4 == null) {
            return null;
        }
        return (Long) b4.value;
    }

    public String getString(int i4) {
        PebbleTuple b4 = b(i4, PebbleTuple.a.STRING);
        if (b4 == null) {
            return null;
        }
        return (String) b4.value;
    }

    public Long getUnsignedIntegerAsLong(int i4) {
        PebbleTuple b4 = b(i4, PebbleTuple.a.UINT);
        if (b4 == null) {
            return null;
        }
        return (Long) b4.value;
    }

    @Override // java.lang.Iterable
    public Iterator<PebbleTuple> iterator() {
        return this.f18339a.values().iterator();
    }

    public void remove(int i4) {
        this.f18339a.remove(Integer.valueOf(i4));
    }

    public int size() {
        return this.f18339a.size();
    }

    public String toJsonString() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (PebbleTuple pebbleTuple : this.f18339a.values()) {
                jSONArray.put(c(pebbleTuple));
            }
            return jSONArray.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
