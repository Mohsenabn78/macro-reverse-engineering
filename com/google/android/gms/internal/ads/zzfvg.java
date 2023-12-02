package com.google.android.gms.internal.ads;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfvg extends zzfvd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfvg(zzfvf zzfvfVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzfvd
    public final int zza(zzfvh zzfvhVar) {
        int i4;
        int i5;
        synchronized (zzfvhVar) {
            i4 = zzfvhVar.remaining;
            i5 = i4 - 1;
            zzfvhVar.remaining = i5;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzfvd
    public final void zzb(zzfvh zzfvhVar, @CheckForNull Set set, Set set2) {
        Set set3;
        synchronized (zzfvhVar) {
            set3 = zzfvhVar.seenExceptions;
            if (set3 == null) {
                zzfvhVar.seenExceptions = set2;
            }
        }
    }

    private zzfvg() {
        super(null);
    }
}
