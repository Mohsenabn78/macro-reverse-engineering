package com.bumptech.glide.provider;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class LoadPathCache {

    /* renamed from: c  reason: collision with root package name */
    private static final LoadPath<?, ?, ?> f17387c = new LoadPath<>(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);

    /* renamed from: a  reason: collision with root package name */
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> f17388a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<MultiClassKey> f17389b = new AtomicReference<>();

    private MultiClassKey a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey andSet = this.f17389b.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.set(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> get(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey a4 = a(cls, cls2, cls3);
        synchronized (this.f17388a) {
            loadPath = (LoadPath<Data, TResource, Transcode>) this.f17388a.get(a4);
        }
        this.f17389b.set(a4);
        return loadPath;
    }

    public boolean isEmptyLoadPath(@Nullable LoadPath<?, ?, ?> loadPath) {
        return f17387c.equals(loadPath);
    }

    public void put(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable LoadPath<?, ?, ?> loadPath) {
        synchronized (this.f17388a) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.f17388a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f17387c;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
