package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.firebase.messaging.Constants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(17)
/* loaded from: classes4.dex */
public final class zzzd implements DisplayManager.DisplayListener, zzzb {
    private final DisplayManager zza;
    @Nullable
    private zzyz zzb;

    private zzzd(DisplayManager displayManager) {
        this.zza = displayManager;
    }

    @Nullable
    public static zzzb zzc(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        if (displayManager != null) {
            return new zzzd(displayManager);
        }
        return null;
    }

    private final Display zzd() {
        return this.zza.getDisplay(0);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i4) {
        zzyz zzyzVar = this.zzb;
        if (zzyzVar != null && i4 == 0) {
            zzzf.zzb(zzyzVar.zza, zzd());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final void zza() {
        this.zza.unregisterDisplayListener(this);
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzzb
    public final void zzb(zzyz zzyzVar) {
        this.zzb = zzyzVar;
        this.zza.registerDisplayListener(this, zzfj.zzt(null));
        zzzf.zzb(zzyzVar.zza, zzd());
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i4) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i4) {
    }
}
