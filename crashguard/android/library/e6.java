package crashguard.android.library;

import android.content.Context;
import android.util.Pair;
import java.nio.ByteBuffer;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
class e6 extends b0 {

    /* renamed from: e  reason: collision with root package name */
    private static final int f38732e = 8;

    /* renamed from: f  reason: collision with root package name */
    private static final int f38733f = 4;

    /* renamed from: c  reason: collision with root package name */
    private final k2 f38734c;

    /* renamed from: d  reason: collision with root package name */
    private final SecretKeySpec f38735d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e6(Context context, String str) {
        super(context, str);
        this.f38734c = new k2();
        this.f38735d = new e1(context).e();
    }

    private Object d(String str) {
        SecretKeySpec secretKeySpec;
        byte[] bArr;
        int i4;
        this.f38734c.getClass();
        String string = this.f38622a.getString(k2.g(str), null);
        if (string == null || (secretKeySpec = this.f38735d) == null) {
            return null;
        }
        try {
            this.f38734c.getClass();
            bArr = k2.f(string, secretKeySpec);
        } catch (Throwable unused) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        boolean z3 = false;
        wrap.position(0);
        int i5 = wrap.getInt();
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 != 5) {
                                i4 = 0;
                            } else {
                                i4 = 6;
                            }
                        } else {
                            i4 = 5;
                        }
                    } else {
                        i4 = 4;
                    }
                } else {
                    i4 = 3;
                }
            } else {
                i4 = 2;
            }
        } else {
            i4 = 1;
        }
        int a4 = y.a(i4);
        if (a4 != 0) {
            if (a4 != 2) {
                if (a4 != 3) {
                    if (a4 != 4) {
                        if (a4 != 5) {
                            return null;
                        }
                        if (wrap.get() != 0) {
                            z3 = true;
                        }
                        return Boolean.valueOf(z3);
                    }
                    return Float.valueOf(wrap.getFloat());
                }
                return Long.valueOf(wrap.getLong());
            }
            return Integer.valueOf(wrap.getInt());
        }
        byte[] bArr2 = new byte[wrap.remaining()];
        wrap.get(bArr2);
        String str2 = new String(bArr2);
        if ("__NULL__".equals(str2)) {
            return null;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // crashguard.android.library.b0
    public final void a(String str, long j4, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate(f38733f + f38732e);
        allocate.putInt(w0.a(4));
        allocate.putLong(j4);
        byte[] array = allocate.array();
        if (this.f38735d != null) {
            try {
                this.f38734c.getClass();
                String g4 = k2.g(str);
                k2 k2Var = this.f38734c;
                SecretKeySpec secretKeySpec = this.f38735d;
                k2Var.getClass();
                Pair pair = new Pair(g4, k2.d(array, secretKeySpec));
                super.b((String) pair.first, (String) pair.second, z3);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // crashguard.android.library.b0
    public final void b(String str, String str2, boolean z3) {
        if (str2 == null) {
            str2 = "__NULL__";
        }
        byte[] bytes = str2.getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(f38733f + bytes.length);
        allocate.putInt(w0.a(1));
        allocate.put(bytes);
        byte[] array = allocate.array();
        if (this.f38735d != null) {
            try {
                this.f38734c.getClass();
                String g4 = k2.g(str);
                k2 k2Var = this.f38734c;
                SecretKeySpec secretKeySpec = this.f38735d;
                k2Var.getClass();
                Pair pair = new Pair(g4, k2.d(array, secretKeySpec));
                super.b((String) pair.first, (String) pair.second, z3);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long c(long j4, String str) {
        Object d4 = d(str);
        if (d4 instanceof Long) {
            return ((Long) d4).longValue();
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String e(String str, String str2) {
        Object d4 = d(str);
        if (d4 instanceof String) {
            return (String) d4;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(String str, int i4) {
        ByteBuffer allocate = ByteBuffer.allocate(f38733f * 2);
        allocate.putInt(w0.a(3));
        allocate.putInt(i4);
        byte[] array = allocate.array();
        if (this.f38735d != null) {
            try {
                this.f38734c.getClass();
                String g4 = k2.g(str);
                k2 k2Var = this.f38734c;
                SecretKeySpec secretKeySpec = this.f38735d;
                k2Var.getClass();
                Pair pair = new Pair(g4, k2.d(array, secretKeySpec));
                super.b((String) pair.first, (String) pair.second, false);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int g(String str) {
        Object d4 = d(str);
        if (d4 instanceof Integer) {
            return ((Integer) d4).intValue();
        }
        return 0;
    }
}
