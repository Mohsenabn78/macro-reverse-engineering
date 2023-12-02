package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@SuppressLint({"RestrictedApi"})
@TargetApi(18)
/* loaded from: classes4.dex */
final class zzfnj {
    private static final zzfnw zzb = new zzfnw("OverlayDisplayService");
    private static final Intent zzc = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");
    @Nullable
    @VisibleForTesting
    final zzfoh zza;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfnj(Context context) {
        if (zzfok.zza(context)) {
            this.zza = new zzfoh(context.getApplicationContext(), zzb, "OverlayDisplayService", zzc, zzfne.zza, null);
        } else {
            this.zza = null;
        }
        this.zzd = context.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        if (this.zza == null) {
            return;
        }
        zzb.zzc("unbind LMD display overlay service", new Object[0]);
        this.zza.zzu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(zzfna zzfnaVar, zzfno zzfnoVar) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzs(new zzfng(this, taskCompletionSource, zzfnaVar, zzfnoVar, taskCompletionSource), taskCompletionSource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(zzfnl zzfnlVar, zzfno zzfnoVar) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
        } else if (zzfnlVar.zzg() == null) {
            zzb.zza("Failed to convert OverlayDisplayShowRequest when to create a new session: appId cannot be null.", new Object[0]);
            zzfnm zzc2 = zzfnn.zzc();
            zzc2.zzb(8160);
            zzfnoVar.zza(zzc2.zzc());
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzs(new zzfnf(this, taskCompletionSource, zzfnlVar, zzfnoVar, taskCompletionSource), taskCompletionSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(zzfnq zzfnqVar, zzfno zzfnoVar, int i4) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzs(new zzfnh(this, taskCompletionSource, zzfnqVar, i4, zzfnoVar, taskCompletionSource), taskCompletionSource);
    }
}
