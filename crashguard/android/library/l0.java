package crashguard.android.library;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes6.dex */
final class l0 implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    private final String f38901a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(String str) {
        this.f38901a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        return this.f38901a.equalsIgnoreCase(str);
    }
}
