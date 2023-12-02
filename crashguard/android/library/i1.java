package crashguard.android.library;

import java.security.KeyPair;
import java.security.KeyStore;

/* loaded from: classes6.dex */
abstract class i1 {

    /* renamed from: c  reason: collision with root package name */
    protected String f38827c;

    /* renamed from: d  reason: collision with root package name */
    protected String f38828d;

    /* renamed from: a  reason: collision with root package name */
    final String f38825a = "crashguard.android.library.keystore.alias";

    /* renamed from: b  reason: collision with root package name */
    protected int f38826b = 2048;

    /* renamed from: e  reason: collision with root package name */
    protected KeyStore f38829e = b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1(String str, String str2) throws Exception {
        this.f38828d = str;
        this.f38827c = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract KeyPair a() throws Exception;

    abstract KeyStore b() throws Exception;
}
