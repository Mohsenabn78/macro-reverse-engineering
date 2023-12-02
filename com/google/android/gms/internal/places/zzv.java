package com.google.android.gms.internal.places;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzv extends zzx {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzw zzef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzw zzwVar) {
        this.zzef = zzwVar;
        this.limit = zzwVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.position < this.limit) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.places.zzab
    public final byte nextByte() {
        int i4 = this.position;
        if (i4 < this.limit) {
            this.position = i4 + 1;
            return this.zzef.zzj(i4);
        }
        throw new NoSuchElementException();
    }
}
