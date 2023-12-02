package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* loaded from: classes3.dex */
class e<DataType> implements DiskCache.Writer {

    /* renamed from: a  reason: collision with root package name */
    private final Encoder<DataType> f16929a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f16930b;

    /* renamed from: c  reason: collision with root package name */
    private final Options f16931c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.f16929a = encoder;
        this.f16930b = datatype;
        this.f16931c = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public boolean write(@NonNull File file) {
        return this.f16929a.encode(this.f16930b, file, this.f16931c);
    }
}
