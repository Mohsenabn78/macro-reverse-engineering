package com.arlosoft.macrodroid.cache.preference;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.google.gson.Gson;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class PreferenceCache implements Cache {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f9600a;

    /* renamed from: b  reason: collision with root package name */
    private final Gson f9601b = GsonUtils.getGsonBuilder(true, true).create();

    public PreferenceCache(@NonNull Context context, @NonNull String str) {
        this.f9600a = context.getSharedPreferences(str, 0);
    }

    @Override // com.arlosoft.macrodroid.cache.Cache
    public void clear() {
        this.f9600a.edit().clear().apply();
    }

    @Override // com.arlosoft.macrodroid.cache.Cache
    public <T> T get(@NonNull String str, @NonNull Class<T> cls) {
        return (T) this.f9601b.fromJson(this.f9600a.getString(str, null), (Class<Object>) cls);
    }

    @Override // com.arlosoft.macrodroid.cache.Cache
    public <T> void put(@NonNull String str, @Nullable T t3) {
        this.f9600a.edit().putString(str, t3 == null ? null : this.f9601b.toJson(t3, t3.getClass())).apply();
    }

    @Override // com.arlosoft.macrodroid.cache.Cache
    public <T> T get(@NonNull String str, @NonNull Class<T> cls, @NonNull Type type) {
        return (T) this.f9601b.fromJson(this.f9600a.getString(str, null), type);
    }

    @Override // com.arlosoft.macrodroid.cache.Cache
    public <T> void put(Gson gson, @NonNull String str, @Nullable T t3) {
        this.f9600a.edit().putString(str, t3 == null ? null : gson.toJson(t3, t3.getClass())).apply();
    }
}
