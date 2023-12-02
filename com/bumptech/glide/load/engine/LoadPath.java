package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f16820a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f16821b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f16822c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16823d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f16820a = cls;
        this.f16821b = pool;
        this.f16822c = (List) Preconditions.checkNotEmpty(list);
        this.f16823d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource<Transcode> a(DataRewinder<Data> dataRewinder, @NonNull Options options, int i4, int i5, DecodePath.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f16822c.size();
        Resource<Transcode> resource = null;
        for (int i6 = 0; i6 < size; i6++) {
            try {
                resource = this.f16822c.get(i6).decode(dataRewinder, i4, i5, options, aVar);
            } catch (GlideException e4) {
                list.add(e4);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f16823d, new ArrayList(list));
    }

    public Class<Data> getDataClass() {
        return this.f16820a;
    }

    public Resource<Transcode> load(DataRewinder<Data> dataRewinder, @NonNull Options options, int i4, int i5, DecodePath.a<ResourceType> aVar) throws GlideException {
        List<Throwable> list = (List) Preconditions.checkNotNull(this.f16821b.acquire());
        try {
            return a(dataRewinder, options, i4, i5, aVar, list);
        } finally {
            this.f16821b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f16822c.toArray()) + '}';
    }
}
