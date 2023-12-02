package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfsj extends zzfqd {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfpi zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfsj(Iterator it, zzfpi zzfpiVar) {
        this.zza = it;
        this.zzb = zzfpiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfqd
    @CheckForNull
    protected final Object zza() {
        while (this.zza.hasNext()) {
            Object next = this.zza.next();
            if (this.zzb.zza(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
