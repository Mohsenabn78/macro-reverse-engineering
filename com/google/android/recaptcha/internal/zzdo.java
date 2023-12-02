package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzdo extends zzds implements Serializable {
    final int zza;
    private final Queue zzb;

    private zzdo(int i4) {
        if (i4 >= 0) {
            this.zzb = new ArrayDeque(i4);
            this.zza = i4;
            return;
        }
        throw new IllegalArgumentException(zzdl.zza("maxSize (%s) must >= 0", Integer.valueOf(i4)));
    }

    public static zzdo zza(int i4) {
        return new zzdo(i4);
    }

    @Override // com.google.android.recaptcha.internal.zzdq, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        obj.getClass();
        if (this.zza == 0) {
            return true;
        }
        if (size() == this.zza) {
            this.zzb.remove();
        }
        this.zzb.add(obj);
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzdq, java.util.Collection
    public final boolean addAll(Collection collection) {
        boolean z3;
        int size = collection.size();
        if (size >= this.zza) {
            clear();
            int i4 = size - this.zza;
            if (i4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzdi.zzb(z3, "number to skip cannot be negative");
            return zzdv.zza(this, new zzdu(collection, i4).iterator());
        }
        return zzdv.zza(this, collection.iterator());
    }

    @Override // com.google.android.recaptcha.internal.zzds, java.util.Queue
    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzdq, com.google.android.recaptcha.internal.zzdr
    protected final /* synthetic */ Object zzb() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzds, com.google.android.recaptcha.internal.zzdq
    protected final /* synthetic */ Collection zzc() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzds
    protected final Queue zzd() {
        return this.zzb;
    }
}
