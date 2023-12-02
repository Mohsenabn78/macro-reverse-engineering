package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class AdService extends IntentService {
    @NonNull
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdService";

    public AdService() {
        super("AdService");
    }

    @Override // android.app.IntentService
    protected final void onHandleIntent(@NonNull Intent intent) {
        try {
            zzay.zza().zzm(this, new zzbnt()).zze(intent);
        } catch (RemoteException e4) {
            zzbzr.zzg("RemoteException calling handleNotificationIntent: ".concat(e4.toString()));
        }
    }
}
