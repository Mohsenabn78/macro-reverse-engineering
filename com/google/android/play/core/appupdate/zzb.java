package com.google.android.play.core.appupdate;

import android.content.Context;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzb {

    /* renamed from: a  reason: collision with root package name */
    private static zza f25226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized zza a(Context context) {
        zza zzaVar;
        synchronized (zzb.class) {
            if (f25226a == null) {
                zzab zzabVar = new zzab(null);
                zzabVar.zzb(new zzi(com.google.android.play.core.appupdate.internal.zzz.zza(context)));
                f25226a = zzabVar.zza();
            }
            zzaVar = f25226a;
        }
        return zzaVar;
    }
}
