package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;

@Deprecated
/* loaded from: classes3.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {

    /* renamed from: b  reason: collision with root package name */
    private final int f17518b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17519c;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.f17518b, this.f17519c)) {
            sizeReadyCallback.onSizeReady(this.f17518b, this.f17519c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f17518b + " and height: " + this.f17519c + ", either provide dimensions in the constructor or call override()");
    }

    public SimpleTarget(int i4, int i5) {
        this.f17518b = i4;
        this.f17519c = i5;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }
}
