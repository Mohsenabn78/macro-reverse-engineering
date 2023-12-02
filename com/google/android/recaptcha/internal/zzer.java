package com.google.android.recaptcha.internal;

import java.util.Comparator;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzer implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzez zzezVar = (zzez) obj;
        zzez zzezVar2 = (zzez) obj2;
        zzeq zzeqVar = new zzeq(zzezVar);
        zzeq zzeqVar2 = new zzeq(zzezVar2);
        while (zzeqVar.hasNext() && zzeqVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzeqVar.zza() & 255).compareTo(Integer.valueOf(zzeqVar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzezVar.zzd()).compareTo(Integer.valueOf(zzezVar2.zzd()));
    }
}
