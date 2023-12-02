package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzasj extends zzath {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzasj(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5) {
        super(zzartVar, "iZXNXN9xUbn1GVaYCV3sL1wKWUe/HGVr+Kc3Vh94EyUz5Y8L5QIgpXYgDdLj2Tdj", "bBmsyCj4vQqoPhkiTKWAfAhlVNxJgrtws7pZHadifrc=", zzanqVar, i4, 44);
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (Long) this.zzf.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzo(zzi.longValue());
        }
    }
}
