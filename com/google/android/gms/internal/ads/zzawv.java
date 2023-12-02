package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawv {
    @Nullable
    private zzawk zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawv(Context context) {
        this.zzc = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zze(zzawv zzawvVar) {
        synchronized (zzawvVar.zzd) {
            zzawk zzawkVar = zzawvVar.zza;
            if (zzawkVar == null) {
                return;
            }
            zzawkVar.disconnect();
            zzawvVar.zza = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future zzc(zzawl zzawlVar) {
        zzawp zzawpVar = new zzawp(this);
        zzawt zzawtVar = new zzawt(this, zzawlVar, zzawpVar);
        zzawu zzawuVar = new zzawu(this, zzawpVar);
        synchronized (this.zzd) {
            zzawk zzawkVar = new zzawk(this.zzc, com.google.android.gms.ads.internal.zzt.zzt().zzb(), zzawtVar, zzawuVar);
            this.zza = zzawkVar;
            zzawkVar.checkAvailabilityAndConnect();
        }
        return zzawpVar;
    }
}
