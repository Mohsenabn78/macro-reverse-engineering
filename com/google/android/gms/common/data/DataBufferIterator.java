package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class DataBufferIterator<T> implements Iterator<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    protected final DataBuffer f20365a;

    /* renamed from: b  reason: collision with root package name */
    protected int f20366b = -1;

    public DataBufferIterator(@NonNull DataBuffer dataBuffer) {
        this.f20365a = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f20366b < this.f20365a.getCount() - 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    @NonNull
    public Object next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.f20365a;
            int i4 = this.f20366b + 1;
            this.f20366b = i4;
            return dataBuffer.get(i4);
        }
        int i5 = this.f20366b;
        throw new NoSuchElementException("Cannot advance the iterator beyond " + i5);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
