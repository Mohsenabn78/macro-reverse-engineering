package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 21)
/* loaded from: classes6.dex */
final class z4 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    static String f39157a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context) {
        ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public final z4 b(Context context) {
        ((ConnectivityManager) context.getSystemService("connectivity")).registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).addCapability(12).build(), this);
        return this;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
        String str = "SSID: ";
        String networkCapabilities2 = networkCapabilities.toString();
        int indexOf = networkCapabilities2.indexOf(str);
        if (indexOf > -1) {
            String replace = networkCapabilities2.substring(indexOf).replace(str, "");
            int i4 = Build.VERSION.SDK_INT;
            if (i4 > 27) {
                if (i4 < 30) {
                    int lastIndexOf = replace.lastIndexOf("]");
                    if (lastIndexOf > -1) {
                        String trim = replace.substring(0, lastIndexOf).replace("\\\"", "").trim();
                        if (!trim.isEmpty()) {
                            f39157a = trim;
                            return;
                        }
                        return;
                    }
                    return;
                }
                int indexOf2 = replace.indexOf("RequestorUid: ");
                if (indexOf2 > -1) {
                    String trim2 = replace.substring(0, indexOf2).replace("\\\"", "").replace("Private DNS is broken", "").trim();
                    if (!trim2.isEmpty()) {
                        f39157a = trim2;
                    }
                }
            }
        }
    }
}
