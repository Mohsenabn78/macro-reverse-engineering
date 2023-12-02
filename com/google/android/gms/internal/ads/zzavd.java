package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import androidx.annotation.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
final class zzavd {
    @VisibleForTesting
    ByteArrayOutputStream zza = new ByteArrayOutputStream(4096);
    @VisibleForTesting
    Base64OutputStream zzb = new Base64OutputStream(this.zza, 10);

    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.ByteArrayOutputStream, android.util.Base64OutputStream] */
    public final String toString() {
        try {
            this.zzb.close();
        } catch (IOException e4) {
            zzbzr.zzh("HashManager: Unable to convert to Base64.", e4);
        }
        try {
            this.zza.close();
            return this.zza.toString();
        } catch (IOException e5) {
            zzbzr.zzh("HashManager: Unable to convert to Base64.", e5);
            return "";
        } finally {
            this.zza = null;
            this.zzb = null;
        }
    }
}
