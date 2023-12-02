package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzhx {
    private final AudioManager zza;
    private final zzhv zzb;
    @Nullable
    private zzhw zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzhx(Context context, Handler handler, zzhw zzhwVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        audioManager.getClass();
        this.zza = audioManager;
        this.zzc = zzhwVar;
        this.zzb = new zzhv(this, handler);
        this.zzd = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(zzhx zzhxVar, int i4) {
        if (i4 != -3 && i4 != -2) {
            if (i4 != -1) {
                if (i4 != 1) {
                    zzer.zzf("AudioFocusManager", "Unknown focus change type: " + i4);
                    return;
                }
                zzhxVar.zzg(1);
                zzhxVar.zzf(1);
                return;
            }
            zzhxVar.zzf(-1);
            zzhxVar.zze();
        } else if (i4 != -2) {
            zzhxVar.zzg(3);
        } else {
            zzhxVar.zzf(0);
            zzhxVar.zzg(2);
        }
    }

    private final void zze() {
        if (this.zzd == 0) {
            return;
        }
        if (zzfj.zza < 26) {
            this.zza.abandonAudioFocus(this.zzb);
        }
        zzg(0);
    }

    private final void zzf(int i4) {
        int zzY;
        zzhw zzhwVar = this.zzc;
        if (zzhwVar != null) {
            zzjt zzjtVar = (zzjt) zzhwVar;
            boolean zzv = zzjtVar.zza.zzv();
            zzY = zzjx.zzY(zzv, i4);
            zzjtVar.zza.zzal(zzv, i4, zzY);
        }
    }

    private final void zzg(int i4) {
        float f4;
        if (this.zzd == i4) {
            return;
        }
        this.zzd = i4;
        if (i4 == 3) {
            f4 = 0.2f;
        } else {
            f4 = 1.0f;
        }
        if (this.zze == f4) {
            return;
        }
        this.zze = f4;
        zzhw zzhwVar = this.zzc;
        if (zzhwVar != null) {
            ((zzjt) zzhwVar).zza.zzai();
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z3, int i4) {
        zze();
        if (z3) {
            return 1;
        }
        return -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }
}
