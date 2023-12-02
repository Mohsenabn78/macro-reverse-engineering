package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzd  reason: invalid package */
/* loaded from: classes4.dex */
abstract class zzd implements Iterator {
    @CheckForNull
    private Object zza;
    private int zzb = 2;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i4 = this.zzb;
        if (i4 != 4) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                if (i5 == 0) {
                    return true;
                }
                if (i5 != 2) {
                    this.zzb = 4;
                    this.zza = zza();
                    if (this.zzb != 3) {
                        this.zzb = 1;
                        return true;
                    }
                }
                return false;
            }
            throw null;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.zzb = 2;
            Object obj = this.zza;
            this.zza = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    protected abstract Object zza();

    /* JADX INFO: Access modifiers changed from: protected */
    @CheckForNull
    public final Object zzb() {
        this.zzb = 3;
        return null;
    }
}
