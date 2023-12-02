package com.google.android.gms.internal.ads;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfhj extends ContentObserver {
    private final Context zza;
    private final AudioManager zzb;
    private final zzfhh zzc;
    private float zzd;
    private final zzfhr zze;

    public zzfhj(Handler handler, Context context, zzfhh zzfhhVar, zzfhr zzfhrVar) {
        super(handler);
        this.zza = context;
        this.zzb = (AudioManager) context.getSystemService("audio");
        this.zzc = zzfhhVar;
        this.zze = zzfhrVar;
    }

    private final float zzc() {
        int streamVolume = this.zzb.getStreamVolume(3);
        int streamMaxVolume = this.zzb.getStreamMaxVolume(3);
        float f4 = 0.0f;
        if (streamMaxVolume > 0 && streamVolume > 0) {
            float f5 = streamVolume / streamMaxVolume;
            f4 = 1.0f;
            if (f5 <= 1.0f) {
                return f5;
            }
        }
        return f4;
    }

    private final void zzd() {
        this.zze.zzd(this.zzd);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z3) {
        super.onChange(z3);
        float zzc = zzc();
        if (zzc != this.zzd) {
            this.zzd = zzc;
            zzd();
        }
    }

    public final void zza() {
        this.zzd = zzc();
        zzd();
        this.zza.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void zzb() {
        this.zza.getContentResolver().unregisterContentObserver(this);
    }
}
