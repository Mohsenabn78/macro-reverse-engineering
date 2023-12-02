package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.WindowManager;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzzc implements zzzb {
    private final WindowManager zza;

    private zzzc(WindowManager windowManager) {
        this.zza = windowManager;
    }

    @Nullable
    public static zzzb zzc(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            return new zzzc(windowManager);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final void zzb(zzyz zzyzVar) {
        zzzf.zzb(zzyzVar.zza, this.zza.getDefaultDisplay());
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final void zza() {
    }
}
