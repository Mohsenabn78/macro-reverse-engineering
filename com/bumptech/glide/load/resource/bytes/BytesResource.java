package com.bumptech.glide.load.resource.bytes;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public class BytesResource implements Resource<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f17284a;

    public BytesResource(byte[] bArr) {
        this.f17284a = (byte[]) Preconditions.checkNotNull(bArr);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f17284a.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public byte[] get() {
        return this.f17284a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
