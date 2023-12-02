package crashguard.android.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.ArrayList;

/* loaded from: classes6.dex */
final class e0 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f38707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(Context context) {
        this.f38707a = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ArrayList<String> a() {
        Network[] allNetworks;
        boolean z3;
        ArrayList<String> arrayList = new ArrayList<>();
        Context context = this.f38707a.get();
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        if (connectivityManager.getNetworkInfo(network).isConnected()) {
                            for (InetAddress inetAddress : connectivityManager.getLinkProperties(network).getDnsServers()) {
                                String hostAddress = inetAddress.getHostAddress();
                                if (hostAddress != null && !hostAddress.isEmpty() && !arrayList.contains(hostAddress)) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    arrayList.add(hostAddress);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
