package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcce implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager zza;
    private final zzccd zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private float zzf = 1.0f;

    public zzcce(Context context, zzccd zzccdVar) {
        this.zza = (AudioManager) context.getSystemService("audio");
        this.zzb = zzccdVar;
    }

    private final void zzf() {
        boolean z3 = false;
        if (this.zzd && !this.zze && this.zzf > 0.0f) {
            if (!this.zzc) {
                AudioManager audioManager = this.zza;
                if (audioManager != null) {
                    if (audioManager.requestAudioFocus(this, 3, 2) == 1) {
                        z3 = true;
                    }
                    this.zzc = z3;
                }
                this.zzb.zzn();
            }
        } else if (this.zzc) {
            AudioManager audioManager2 = this.zza;
            if (audioManager2 != null) {
                if (audioManager2.abandonAudioFocus(this) == 0) {
                    z3 = true;
                }
                this.zzc = z3;
            }
            this.zzb.zzn();
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i4) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzc = z3;
        this.zzb.zzn();
    }

    public final float zza() {
        float f4;
        if (this.zze) {
            f4 = 0.0f;
        } else {
            f4 = this.zzf;
        }
        if (!this.zzc) {
            return 0.0f;
        }
        return f4;
    }

    public final void zzb() {
        this.zzd = true;
        zzf();
    }

    public final void zzc() {
        this.zzd = false;
        zzf();
    }

    public final void zzd(boolean z3) {
        this.zze = z3;
        zzf();
    }

    public final void zze(float f4) {
        this.zzf = f4;
        zzf();
    }
}
