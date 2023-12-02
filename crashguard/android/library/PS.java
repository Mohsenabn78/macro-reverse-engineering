package crashguard.android.library;

import crashguard.android.library.g0;
import java.io.ByteArrayInputStream;

/* loaded from: classes6.dex */
class PS extends i {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f38608c;

    /* renamed from: j  reason: collision with root package name */
    private final String f38609j;

    PS(byte[] bArr, String str) {
        this.f38608c = bArr;
        this.f38609j = str;
    }

    byte[] g(String str) throws Exception {
        byte[] bArr;
        u uVar = new u(str, new ByteArrayInputStream(this.f38608c));
        try {
            uVar.f38746a.setRequestProperty(getSignatureHeader(), this.f38609j);
            g0.a b4 = uVar.b();
            if (b4.a() == 200) {
                bArr = b4.b();
            } else {
                bArr = null;
            }
            uVar.close();
            return bArr;
        } catch (Throwable th) {
            try {
                uVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
