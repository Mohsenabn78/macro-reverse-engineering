package com.google.android.gms.internal.ads;

import java.util.Iterator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfpr implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfpu zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfpr(zzfpu zzfpuVar, CharSequence charSequence) {
        this.zzb = zzfpuVar;
        this.zza = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator zzg;
        zzg = this.zzb.zzg(this.zza);
        return zzg;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        zzfow.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}
