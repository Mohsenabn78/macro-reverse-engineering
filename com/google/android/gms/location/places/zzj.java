package com.google.android.gms.location.places;

import com.google.android.gms.location.places.internal.zzak;
import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzj implements Comparator<zzak> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzak zzakVar, zzak zzakVar2) {
        return -Float.compare(zzakVar.getLikelihood(), zzakVar2.getLikelihood());
    }
}
