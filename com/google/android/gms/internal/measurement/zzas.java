package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzas implements Iterator {
    final /* synthetic */ zzat zza;
    private int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzat zzatVar) {
        this.zza = zzatVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String str;
        int i4 = this.zzb;
        str = this.zza.zza;
        if (i4 < str.length()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        String str;
        String str2;
        int i4 = this.zzb;
        zzat zzatVar = this.zza;
        str = zzatVar.zza;
        if (i4 < str.length()) {
            str2 = zzatVar.zza;
            this.zzb = i4 + 1;
            return new zzat(String.valueOf(str2.charAt(i4)));
        }
        throw new NoSuchElementException();
    }
}
