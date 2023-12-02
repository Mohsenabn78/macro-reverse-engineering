package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f16787a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends ResourceDecoder<DataType, ResourceType>> f16788b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<ResourceType, Transcode> f16789c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f16790d;

    /* renamed from: e  reason: collision with root package name */
    private final String f16791e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a<ResourceType> {
        @NonNull
        Resource<ResourceType> a(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.f16787a = cls;
        this.f16788b = list;
        this.f16789c = resourceTranscoder;
        this.f16790d = pool;
        this.f16791e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private Resource<ResourceType> a(DataRewinder<DataType> dataRewinder, int i4, int i5, @NonNull Options options) throws GlideException {
        List<Throwable> list = (List) Preconditions.checkNotNull(this.f16790d.acquire());
        try {
            return b(dataRewinder, i4, i5, options, list);
        } finally {
            this.f16790d.release(list);
        }
    }

    @NonNull
    private Resource<ResourceType> b(DataRewinder<DataType> dataRewinder, int i4, int i5, @NonNull Options options, List<Throwable> list) throws GlideException {
        int size = this.f16788b.size();
        Resource<ResourceType> resource = null;
        for (int i6 = 0; i6 < size; i6++) {
            ResourceDecoder<DataType, ResourceType> resourceDecoder = this.f16788b.get(i6);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i4, i5, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e4) {
                if (Log.isLoggable("DecodePath", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode data for ");
                    sb.append(resourceDecoder);
                }
                list.add(e4);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f16791e, new ArrayList(list));
    }

    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i4, int i5, @NonNull Options options, a<ResourceType> aVar) throws GlideException {
        return this.f16789c.transcode(aVar.a(a(dataRewinder, i4, i5, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f16787a + ", decoders=" + this.f16788b + ", transcoder=" + this.f16789c + '}';
    }
}
