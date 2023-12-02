package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzerf implements zzeqy {
    private final zzfwn zza;
    private final Context zzb;

    public zzerf(zzfwn zzfwnVar, Context context) {
        this.zza = zzfwnVar;
        this.zzb = context;
    }

    @Nullable
    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 38;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzere
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzerf.this.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(3:3|(1:6)|7)|8|(3:52|53|(16:55|11|12|13|(12:15|16|17|(1:19)(2:35|(3:38|(3:41|(2:44|45)(1:43)|39)|46))|20|21|(2:23|(5:25|(1:27)(1:33)|(1:29)|30|31))|34|(0)(0)|(0)|30|31)|48|17|(0)(0)|20|21|(0)|34|(0)(0)|(0)|30|31))|10|11|12|13|(0)|48|17|(0)(0)|20|21|(0)|34|(0)(0)|(0)|30|31) */
    /* JADX WARN: Incorrect condition in loop: B:6:0x004b */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a0 A[Catch: Exception -> 0x00b8, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b8, blocks: (B:18:0x0092, B:20:0x00a0), top: B:55:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzerd zzc() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzerf.zzc():com.google.android.gms.internal.ads.zzerd");
    }
}
