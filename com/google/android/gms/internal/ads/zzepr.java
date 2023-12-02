package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzepr implements zzeqx {
    private final String zza;
    private final String zzb;

    public zzepr(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgJ)).booleanValue()) {
            bundle.putString(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, this.zzb);
        } else {
            bundle.putString(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, this.zza);
        }
    }
}
