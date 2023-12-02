package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbra extends NativeAd.Image {
    private final zzber zza;
    @Nullable
    private final Drawable zzb;
    @Nullable
    private final Uri zzc;
    private final double zzd;

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|2|3|(13:5|6|7|8|9|10|11|12|13|14|16|17|18)|33|6|7|8|9|10|11|12|13|14|16|17|18|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        com.google.android.gms.internal.ads.zzbzr.zzh("", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        com.google.android.gms.internal.ads.zzbzr.zzh("", r4);
        r1 = 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        com.google.android.gms.internal.ads.zzbzr.zzh("", r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzbra(com.google.android.gms.internal.ads.zzber r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            r3.<init>()
            r3.zza = r4
            r1 = 0
            com.google.android.gms.dynamic.IObjectWrapper r4 = r4.zzf()     // Catch: android.os.RemoteException -> L15
            if (r4 == 0) goto L19
            java.lang.Object r4 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r4)     // Catch: android.os.RemoteException -> L15
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch: android.os.RemoteException -> L15
            goto L1a
        L15:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzbzr.zzh(r0, r4)
        L19:
            r4 = r1
        L1a:
            r3.zzb = r4
            com.google.android.gms.internal.ads.zzber r4 = r3.zza     // Catch: android.os.RemoteException -> L23
            android.net.Uri r1 = r4.zze()     // Catch: android.os.RemoteException -> L23
            goto L27
        L23:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzbzr.zzh(r0, r4)
        L27:
            r3.zzc = r1
            com.google.android.gms.internal.ads.zzber r4 = r3.zza     // Catch: android.os.RemoteException -> L30
            double r1 = r4.zzb()     // Catch: android.os.RemoteException -> L30
            goto L36
        L30:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzbzr.zzh(r0, r4)
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L36:
            r3.zzd = r1
            com.google.android.gms.internal.ads.zzber r4 = r3.zza     // Catch: android.os.RemoteException -> L3e
            r4.zzd()     // Catch: android.os.RemoteException -> L3e
            goto L42
        L3e:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzbzr.zzh(r0, r4)
        L42:
            com.google.android.gms.internal.ads.zzber r4 = r3.zza     // Catch: android.os.RemoteException -> L48
            r4.zzc()     // Catch: android.os.RemoteException -> L48
            return
        L48:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzbzr.zzh(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbra.<init>(com.google.android.gms.internal.ads.zzber):void");
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    @Nullable
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final double getScale() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    @Nullable
    public final Uri getUri() {
        return this.zzc;
    }
}
