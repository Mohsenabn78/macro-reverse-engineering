package crashguard.android.library;

import android.content.Context;
import android.os.Build;
import java.security.KeyStore;
import java.security.PrivateKey;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o1 {

    /* renamed from: a  reason: collision with root package name */
    private final i1 f39011a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o1(Context context) throws Exception {
        this.f39011a = new t0(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:2|3)|(3:7|8|(5:(1:15)|16|17|18|19)(2:11|12))|23|8|(0)|(0)|16|17|18|19) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static javax.crypto.SecretKey b(android.content.Context r4, crashguard.android.library.k2 r5) throws java.lang.Exception {
        /*
            crashguard.android.library.o1 r5 = new crashguard.android.library.o1
            r5.<init>(r4)
            crashguard.android.library.e1 r0 = new crashguard.android.library.e1
            r0.<init>(r4)
            crashguard.android.library.i1 r4 = r5.f39011a
            r4.getClass()
            r1 = 0
            java.security.KeyStore r2 = r4.f38829e     // Catch: java.lang.Throwable -> L29
            java.lang.String r3 = r4.f38825a     // Catch: java.lang.Throwable -> L29
            boolean r2 = r2.containsAlias(r3)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L2a
            java.security.KeyStore r2 = r4.f38829e     // Catch: java.lang.Throwable -> L29
            java.lang.String r4 = r4.f38825a     // Catch: java.lang.Throwable -> L29
            java.security.cert.Certificate r4 = r2.getCertificate(r4)     // Catch: java.lang.Throwable -> L29
            if (r4 == 0) goto L2a
            java.security.PublicKey r4 = r4.getPublicKey()     // Catch: java.lang.Throwable -> L29
            goto L2b
        L29:
        L2a:
            r4 = r1
        L2b:
            java.lang.String r2 = r0.c()
            if (r4 == 0) goto L3d
            if (r2 != 0) goto L34
            goto L3d
        L34:
            java.security.PrivateKey r4 = r5.a()
            javax.crypto.spec.SecretKeySpec r4 = crashguard.android.library.k2.e(r2, r4)
            goto L69
        L3d:
            if (r4 != 0) goto L49
            crashguard.android.library.i1 r4 = r5.f39011a
            java.security.KeyPair r4 = r4.a()
            java.security.PublicKey r4 = r4.getPublic()
        L49:
            java.lang.String r5 = crashguard.android.library.k2.f38889a     // Catch: java.lang.Throwable -> L5d
            javax.crypto.KeyGenerator r5 = javax.crypto.KeyGenerator.getInstance(r5)     // Catch: java.lang.Throwable -> L5d
            java.security.SecureRandom r2 = new java.security.SecureRandom     // Catch: java.lang.Throwable -> L5d
            r2.<init>()     // Catch: java.lang.Throwable -> L5d
            r3 = 256(0x100, float:3.59E-43)
            r5.init(r3, r2)     // Catch: java.lang.Throwable -> L5d
            javax.crypto.SecretKey r1 = r5.generateKey()     // Catch: java.lang.Throwable -> L5d
        L5d:
            byte[] r5 = r1.getEncoded()
            java.lang.String r4 = crashguard.android.library.k2.c(r5, r4)
            r0.d(r4)
            r4 = r1
        L69:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: crashguard.android.library.o1.b(android.content.Context, crashguard.android.library.k2):javax.crypto.SecretKey");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PrivateKey a() {
        PrivateKey privateKey;
        i1 i1Var = this.f39011a;
        int i4 = Build.VERSION.SDK_INT;
        i1Var.getClass();
        try {
            if (!i1Var.f38829e.containsAlias(i1Var.f38825a)) {
                return null;
            }
            if (i4 > 27) {
                privateKey = (PrivateKey) i1Var.f38829e.getKey(i1Var.f38825a, null);
            } else {
                KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) i1Var.f38829e.getEntry(i1Var.f38825a, null);
                if (privateKeyEntry == null) {
                    return null;
                }
                privateKey = privateKeyEntry.getPrivateKey();
            }
            return privateKey;
        } catch (Throwable unused) {
            return null;
        }
    }
}
