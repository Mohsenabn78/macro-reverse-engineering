package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbhx implements zzbij {
    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcezVar = (zzcez) obj;
        try {
            zzfmh.zzj(zzcezVar.getContext()).zzk();
            zzfmi.zzi(zzcezVar.getContext()).zzj();
        } catch (IOException e4) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "DefaultGmsgHandlers.ResetPaid");
        }
    }
}
