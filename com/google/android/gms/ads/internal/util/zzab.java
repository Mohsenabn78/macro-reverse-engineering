package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzab {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19258a = false;

    /* renamed from: b  reason: collision with root package name */
    private float f19259b = 1.0f;

    private final synchronized boolean a() {
        if (this.f19259b >= 0.0f) {
            return true;
        }
        return false;
    }

    public static float zzb(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / streamMaxVolume;
    }

    public final synchronized float zza() {
        if (a()) {
            return this.f19259b;
        }
        return 1.0f;
    }

    public final synchronized void zzc(boolean z3) {
        this.f19258a = z3;
    }

    public final synchronized void zzd(float f4) {
        this.f19259b = f4;
    }

    public final synchronized boolean zze() {
        return this.f19258a;
    }
}
