package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class DataRewinderRegistry {

    /* renamed from: b  reason: collision with root package name */
    private static final DataRewinder.Factory<?> f16753b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, DataRewinder.Factory<?>> f16754a = new HashMap();

    /* loaded from: classes3.dex */
    class a implements DataRewinder.Factory<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public DataRewinder<Object> build(@NonNull Object obj) {
            return new b(obj);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    @NonNull
    public synchronized <T> DataRewinder<T> build(@NonNull T t3) {
        DataRewinder.Factory<?> factory;
        Preconditions.checkNotNull(t3);
        factory = this.f16754a.get(t3.getClass());
        if (factory == null) {
            Iterator<DataRewinder.Factory<?>> it = this.f16754a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DataRewinder.Factory<?> next = it.next();
                if (next.getDataClass().isAssignableFrom(t3.getClass())) {
                    factory = next;
                    break;
                }
            }
        }
        if (factory == null) {
            factory = f16753b;
        }
        return (DataRewinder<T>) factory.build(t3);
    }

    public synchronized void register(@NonNull DataRewinder.Factory<?> factory) {
        this.f16754a.put(factory.getDataClass(), factory);
    }

    /* loaded from: classes3.dex */
    private static final class b implements DataRewinder<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f16755a;

        b(@NonNull Object obj) {
            this.f16755a = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        @NonNull
        public Object rewindAndGet() {
            return this.f16755a;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void cleanup() {
        }
    }
}
