package com.arlosoft.macrodroid.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public interface Cache {
    void clear();

    <T> T get(@NonNull String str, @NonNull Class<T> cls);

    <T> T get(@NonNull String str, @NonNull Class<T> cls, @NonNull Type type);

    <T> void put(Gson gson, @NonNull String str, @Nullable T t3);

    <T> void put(@NonNull String str, @Nullable T t3);
}
