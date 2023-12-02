package com.google.android.gms.wearable;

import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public class ChannelIOException extends IOException {
    private final int zza;
    private final int zzb;

    public ChannelIOException(@NonNull String str, int i4, int i5) {
        super(str);
        this.zza = i4;
        this.zzb = i5;
    }

    public int getAppSpecificErrorCode() {
        return this.zzb;
    }

    public int getCloseReason() {
        return this.zza;
    }
}
