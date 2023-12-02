package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfmi extends zzfmf {
    private static zzfmi zzc;

    private zzfmi(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfmi zzi(Context context) {
        zzfmi zzfmiVar;
        synchronized (zzfmi.class) {
            if (zzc == null) {
                zzc = new zzfmi(context);
            }
            zzfmiVar = zzc;
        }
        return zzfmiVar;
    }

    public final zzfme zzh(long j4, boolean z3) throws IOException {
        synchronized (zzfmi.class) {
            if (!zzo()) {
                return new zzfme();
            }
            return zzb(null, null, j4, z3);
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzfmi.class) {
            if (zzg(false)) {
                zzf(false);
            }
        }
    }

    public final void zzk() throws IOException {
        this.zzb.zze("paidv2_publisher_option");
    }

    public final void zzl() throws IOException {
        this.zzb.zze("paidv2_user_option");
    }

    public final void zzm(boolean z3) throws IOException {
        this.zzb.zzd("paidv2_user_option", Boolean.valueOf(z3));
    }

    public final void zzn(boolean z3) throws IOException {
        this.zzb.zzd("paidv2_publisher_option", Boolean.valueOf(z3));
        if (!z3) {
            zzj();
        }
    }

    public final boolean zzo() {
        return this.zzb.zzf("paidv2_publisher_option", true);
    }

    public final boolean zzp() {
        return this.zzb.zzf("paidv2_user_option", true);
    }
}
