package com.google.android.gms.internal.mlkit_translate;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzov {
    @Nullable
    private static zzov zza;
    private final zzot zzb;
    private final zzpa zzc;
    private final zzoy zzd;
    @Nullable
    private zzpb zze;

    @VisibleForTesting
    public zzov(Context context, zzou zzouVar) {
        zzoy zzoyVar = new zzoy(context);
        this.zzd = zzoyVar;
        this.zzc = new zzpa(context);
        this.zzb = new zzot(zzouVar, zzoyVar);
    }

    public static synchronized zzov zzb(Context context) {
        zzov zzovVar;
        synchronized (zzov.class) {
            if (zza == null) {
                zza = new zzov(context, zzpc.zza);
            }
            zzovVar = zza;
        }
        return zzovVar;
    }

    public final zzop zza() {
        boolean z3;
        if (this.zze != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return this.zze.zzb();
    }

    public final String zzc() throws InterruptedException {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (this.zze != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (this.zze != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState(z4);
        if (this.zze.zze()) {
            zzox zzoxVar = new zzox();
            zzoxVar.zzg();
            try {
                if (this.zzb.zzc(zzoxVar)) {
                    this.zze = this.zzb.zza();
                }
            } finally {
                zzoxVar.zze();
                this.zzd.zza(zzle.INSTALLATION_ID_REFRESH_TEMPORARY_TOKEN, zzoxVar);
            }
        }
        if (this.zze == null) {
            z5 = false;
        }
        Preconditions.checkState(z5);
        return this.zze.zzd();
    }

    public final void zzd() throws IOException, InterruptedException {
        zzoy zzoyVar;
        zzle zzleVar;
        zzox zzoxVar = new zzox();
        zzoxVar.zzg();
        try {
            zzpb zza2 = this.zzc.zza(zzoxVar);
            if (zza2 != null) {
                this.zze = zza2;
            } else {
                final zzox zzoxVar2 = new zzox();
                zzoxVar2.zzg();
                final zzop zzopVar = new zzop(zzow.zza());
                final zzot zzotVar = this.zzb;
                if (!zzrd.zza(new zzrc() { // from class: com.google.android.gms.internal.mlkit_translate.zzos
                    @Override // com.google.android.gms.internal.mlkit_translate.zzrc
                    public final boolean zza() {
                        return zzot.this.zzb(zzopVar, zzoxVar2);
                    }
                })) {
                    zzoxVar2.zzd(zznk.RPC_EXPONENTIAL_BACKOFF_FAILED);
                    zzoxVar2.zzd(zznk.RPC_ERROR);
                    zzoxVar2.zze();
                    zzoyVar = this.zzd;
                    zzleVar = zzle.INSTALLATION_ID_REGISTER_NEW_ID;
                } else {
                    zzpb zza3 = this.zzb.zza();
                    this.zze = zza3;
                    if (zza3 != null) {
                        this.zzc.zzc(zza3, zzoxVar2);
                    }
                    zzoxVar2.zze();
                    zzoyVar = this.zzd;
                    zzleVar = zzle.INSTALLATION_ID_REGISTER_NEW_ID;
                }
                zzoyVar.zza(zzleVar, zzoxVar2);
            }
        } finally {
            zzoxVar.zze();
            this.zzd.zza(zzle.INSTALLATION_ID_INIT, zzoxVar);
        }
    }
}
