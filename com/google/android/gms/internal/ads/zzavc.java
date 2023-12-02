package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzavc implements Comparator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavc(zzave zzaveVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzavi zzaviVar = (zzavi) obj;
        zzavi zzaviVar2 = (zzavi) obj2;
        int i4 = zzaviVar.zzc - zzaviVar2.zzc;
        if (i4 != 0) {
            return i4;
        }
        return (zzaviVar.zza > zzaviVar2.zza ? 1 : (zzaviVar.zza == zzaviVar2.zza ? 0 : -1));
    }
}
