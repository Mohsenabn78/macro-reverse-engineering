package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcde implements Iterable {
    private final List zza = new ArrayList();

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzcdd zza(zzcca zzccaVar) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcdd zzcddVar = (zzcdd) it.next();
            if (zzcddVar.zza == zzccaVar) {
                return zzcddVar;
            }
        }
        return null;
    }

    public final void zzb(zzcdd zzcddVar) {
        this.zza.add(zzcddVar);
    }

    public final void zzc(zzcdd zzcddVar) {
        this.zza.remove(zzcddVar);
    }

    public final boolean zzd(zzcca zzccaVar) {
        ArrayList<zzcdd> arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcdd zzcddVar = (zzcdd) it.next();
            if (zzcddVar.zza == zzccaVar) {
                arrayList.add(zzcddVar);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (zzcdd zzcddVar2 : arrayList) {
            zzcddVar2.zzb.zzf();
        }
        return true;
    }
}
