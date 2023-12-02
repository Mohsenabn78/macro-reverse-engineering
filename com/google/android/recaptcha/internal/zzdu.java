package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzdu extends zzdp {
    final /* synthetic */ Iterable zza;
    final /* synthetic */ int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(Iterable iterable, int i4) {
        this.zza = iterable;
        this.zzb = i4;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        boolean z3;
        Iterable iterable = this.zza;
        if (iterable instanceof List) {
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.zzb), list.size()).iterator();
        }
        Iterator it = iterable.iterator();
        int i4 = this.zzb;
        it.getClass();
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdi.zzb(z3, "numberToAdvance must be nonnegative");
        for (int i5 = 0; i5 < i4 && it.hasNext(); i5++) {
            it.next();
        }
        return new zzdt(this, it);
    }
}
