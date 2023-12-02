package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class zzcdl implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzcdl(zzcca zzccaVar) {
        Context context = zzccaVar.getContext();
        this.zza = context;
        this.zzb = com.google.android.gms.ads.internal.zzt.zzp().zzc(context, zzccaVar.zzn().zza);
        this.zzc = new WeakReference(zzccaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zze(zzcdl zzcdlVar, String str, Map map) {
        zzcca zzccaVar = (zzcca) zzcdlVar.zzc.get();
        if (zzccaVar != null) {
            zzccaVar.zzd("onPrecacheEvent", map);
        }
    }

    public abstract void zzf();

    public final void zzg(String str, @Nullable String str2, String str3, @Nullable String str4) {
        zzbzk.zza.post(new zzcdk(this, str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzh(String str, String str2, int i4) {
        zzbzk.zza.post(new zzcdi(this, str, str2, i4));
    }

    public final void zzj(String str, String str2, long j4) {
        zzbzk.zza.post(new zzcdj(this, str, str2, j4));
    }

    public final void zzn(String str, String str2, int i4, int i5, long j4, long j5, boolean z3, int i6, int i7) {
        zzbzk.zza.post(new zzcdh(this, str, str2, i4, i5, j4, j5, z3, i6, i7));
    }

    public final void zzo(String str, String str2, long j4, long j5, boolean z3, long j6, long j7, long j8, int i4, int i5) {
        zzbzk.zza.post(new zzcdg(this, str, str2, j4, j5, j6, j7, j8, z3, i4, i5));
    }

    public abstract boolean zzt(String str);

    public boolean zzu(String str, String[] strArr) {
        return zzt(str);
    }

    public boolean zzw(String str, String[] strArr, zzcdd zzcddVar) {
        return zzt(str);
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzp(int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzq(int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzr(int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzs(int i4) {
    }
}
