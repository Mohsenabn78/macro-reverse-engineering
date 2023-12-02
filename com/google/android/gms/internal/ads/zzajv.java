package com.google.android.gms.internal.ads;

import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzajv {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private String zze;

    public zzajv(int i4, int i5, int i6) {
        String str;
        if (i4 == Integer.MIN_VALUE) {
            str = "";
        } else {
            str = i4 + RemoteSettings.FORWARD_SLASH_STRING;
        }
        this.zza = str;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = Integer.MIN_VALUE;
        this.zze = "";
    }

    private final void zzd() {
        if (this.zzd != Integer.MIN_VALUE) {
            return;
        }
        throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
    }

    public final int zza() {
        zzd();
        return this.zzd;
    }

    public final String zzb() {
        zzd();
        return this.zze;
    }

    public final void zzc() {
        int i4;
        int i5 = this.zzd;
        if (i5 == Integer.MIN_VALUE) {
            i4 = this.zzb;
        } else {
            i4 = i5 + this.zzc;
        }
        this.zzd = i4;
        String str = this.zza;
        this.zze = str + i4;
    }
}
