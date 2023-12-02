package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;
import com.google.android.gms.internal.ads.zzfvy;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzz implements zzfvy {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzaa f19575a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(zzaa zzaaVar) {
        this.f19575a = zzaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzdqf zzdqfVar;
        zzdpv zzdpvVar;
        com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzaa zzaaVar = this.f19575a;
        zzdqfVar = zzaaVar.f19516m;
        zzdpvVar = zzaaVar.f19508e;
        zzf.zzc(zzdqfVar, zzdpvVar, "sgf", new Pair("sgf_reason", th.getMessage()));
        zzbzr.zzh("Failed to initialize webview for loading SDKCore. ", th);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* synthetic */ void zzb(@Nullable Object obj) {
        zzam zzamVar = (zzam) obj;
        zzbzr.zze("Initialized webview successfully for SDKCore.");
    }
}
