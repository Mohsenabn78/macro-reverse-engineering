package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgwt extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzgwt(zzbcn zzbcnVar) {
        this.zza = new WeakReference(zzbcnVar);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbcn zzbcnVar = (zzbcn) this.zza.get();
        if (zzbcnVar != null) {
            zzbcnVar.zzc(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbcn zzbcnVar = (zzbcn) this.zza.get();
        if (zzbcnVar != null) {
            zzbcnVar.zzd();
        }
    }
}
