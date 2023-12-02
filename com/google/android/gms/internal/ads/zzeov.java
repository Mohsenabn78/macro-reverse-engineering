package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeov implements zzeqy {
    private final zzfwn zza;
    private final zzfai zzb;
    @Nullable
    private final PackageInfo zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;

    public zzeov(zzfwn zzfwnVar, zzfai zzfaiVar, @Nullable PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzfwnVar;
        this.zzb = zzfaiVar;
        this.zzc = packageInfo;
        this.zzd = zzgVar;
    }

    public static /* synthetic */ zzeow zzc(final zzeov zzeovVar) {
        final ArrayList arrayList = zzeovVar.zzb.zzg;
        if (arrayList == null) {
            return new zzeow() { // from class: com.google.android.gms.internal.ads.zzeor
                @Override // com.google.android.gms.internal.ads.zzeqx
                public final void zzh(Object obj) {
                    Bundle bundle = (Bundle) obj;
                }
            };
        }
        if (arrayList.isEmpty()) {
            return new zzeow() { // from class: com.google.android.gms.internal.ads.zzeos
                @Override // com.google.android.gms.internal.ads.zzeqx
                public final void zzh(Object obj) {
                    ((Bundle) obj).putInt("native_version", 0);
                }
            };
        }
        return new zzeow() { // from class: com.google.android.gms.internal.ads.zzeot
            @Override // com.google.android.gms.internal.ads.zzeqx
            public final void zzh(Object obj) {
                zzeov.this.zzd(arrayList, (Bundle) obj);
            }
        };
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 26;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeou
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeov.zzc(zzeov.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fc, code lost:
        if (r9 == 3) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void zzd(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeov.zzd(java.util.ArrayList, android.os.Bundle):void");
    }
}
