package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class EncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f17383a = new ArrayList();

    /* loaded from: classes3.dex */
    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f17384a;

        /* renamed from: b  reason: collision with root package name */
        final Encoder<T> f17385b;

        a(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.f17384a = cls;
            this.f17385b = encoder;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f17384a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void append(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f17383a.add(new a<>(cls, encoder));
    }

    @Nullable
    public synchronized <T> Encoder<T> getEncoder(@NonNull Class<T> cls) {
        for (a<?> aVar : this.f17383a) {
            if (aVar.a(cls)) {
                return (Encoder<T>) aVar.f17385b;
            }
        }
        return null;
    }

    public synchronized <T> void prepend(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f17383a.add(0, new a<>(cls, encoder));
    }
}
