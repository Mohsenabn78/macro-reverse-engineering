package crashguard.android.library;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
final class s0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f39031a;

    /* loaded from: classes6.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f39032a = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public final a a(@NonNull s0 s0Var) {
            for (Map.Entry entry : s0Var.f39031a.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    this.f39032a.put(str, null);
                } else {
                    Class<?> cls = value.getClass();
                    if (cls != Boolean.class && cls != Byte.class && cls != Integer.class && cls != Long.class && cls != Float.class && cls != Double.class && cls != String.class && cls != Boolean[].class && cls != Byte[].class && cls != Integer[].class && cls != Long[].class && cls != Float[].class && cls != Double[].class && cls != String[].class) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Key ");
                        sb.append(str);
                        sb.append("has invalid type ");
                        sb.append(cls);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f39032a.put(str, value);
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public final a b(@NonNull String str, @Nullable String str2) {
            this.f39032a.put(str, str2);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public final s0 c() {
            return new s0(this.f39032a);
        }
    }

    s0(HashMap hashMap) {
        this.f39031a = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s0 a(@NonNull byte[] bArr) {
        HashMap hashMap = new HashMap();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                if (objectInputStream.available() > 0) {
                    objectInputStream.readInt();
                    while (objectInputStream.available() > 0) {
                        hashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                    }
                }
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (Throwable th) {
                try {
                    objectInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable unused) {
        }
        return new s0(hashMap);
    }

    public final boolean c(@NonNull String str) {
        Object obj = this.f39031a.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] d() {
        byte[] bArr = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeInt(this.f39031a.size());
            for (Map.Entry<String, Object> entry : this.f39031a.entrySet()) {
                objectOutputStream.writeUTF(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            bArr = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (Throwable unused) {
        }
        return bArr;
    }

    @Nullable
    public final String e(@NonNull String str) {
        Object obj = this.f39031a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}
