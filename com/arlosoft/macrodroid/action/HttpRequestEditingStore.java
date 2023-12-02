package com.arlosoft.macrodroid.action;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class HttpRequestEditingStore {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static HttpRequestAction f2254a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static HttpRequestConfig f2255b;
    @NotNull
    public static final HttpRequestEditingStore INSTANCE = new HttpRequestEditingStore();
    public static final int $stable = 8;

    private HttpRequestEditingStore() {
    }

    @Nullable
    public final HttpRequestAction getHttpRequestAction() {
        return f2254a;
    }

    @Nullable
    public final HttpRequestConfig getHttpRequestConfig() {
        return f2255b;
    }

    public final void setHttpRequestAction(@Nullable HttpRequestAction httpRequestAction) {
        f2254a = httpRequestAction;
    }

    public final void setHttpRequestConfig(@Nullable HttpRequestConfig httpRequestConfig) {
        f2255b = httpRequestConfig;
    }
}
