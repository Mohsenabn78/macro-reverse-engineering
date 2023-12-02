package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ResourceEncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f17397a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f17398a;

        /* renamed from: b  reason: collision with root package name */
        final ResourceEncoder<T> f17399b;

        a(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            this.f17398a = cls;
            this.f17399b = resourceEncoder;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f17398a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void append(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f17397a.add(new a<>(cls, resourceEncoder));
    }

    @Nullable
    public synchronized <Z> ResourceEncoder<Z> get(@NonNull Class<Z> cls) {
        int size = this.f17397a.size();
        for (int i4 = 0; i4 < size; i4++) {
            a<?> aVar = this.f17397a.get(i4);
            if (aVar.a(cls)) {
                return (ResourceEncoder<Z>) aVar.f17399b;
            }
        }
        return null;
    }

    public synchronized <Z> void prepend(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f17397a.add(0, new a<>(cls, resourceEncoder));
    }
}
