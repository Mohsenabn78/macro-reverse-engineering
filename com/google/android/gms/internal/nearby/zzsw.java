package com.google.android.gms.internal.nearby;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzsw extends zztb {
    boolean zza;
    final /* synthetic */ Object zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsw(Object obj) {
        this.zzb = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.zza) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
