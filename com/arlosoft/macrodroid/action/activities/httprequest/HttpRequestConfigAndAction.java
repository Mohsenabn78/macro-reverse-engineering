package com.arlosoft.macrodroid.action.activities.httprequest;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.HttpRequestAction;
import com.arlosoft.macrodroid.action.HttpRequestConfig;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestConfigViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class HttpRequestConfigAndAction {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final HttpRequestConfig f3023a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final HttpRequestAction f3024b;

    public HttpRequestConfigAndAction(@NotNull HttpRequestConfig requestConfig, @NotNull HttpRequestAction httpRequestionAction) {
        Intrinsics.checkNotNullParameter(requestConfig, "requestConfig");
        Intrinsics.checkNotNullParameter(httpRequestionAction, "httpRequestionAction");
        this.f3023a = requestConfig;
        this.f3024b = httpRequestionAction;
    }

    public static /* synthetic */ HttpRequestConfigAndAction copy$default(HttpRequestConfigAndAction httpRequestConfigAndAction, HttpRequestConfig httpRequestConfig, HttpRequestAction httpRequestAction, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            httpRequestConfig = httpRequestConfigAndAction.f3023a;
        }
        if ((i4 & 2) != 0) {
            httpRequestAction = httpRequestConfigAndAction.f3024b;
        }
        return httpRequestConfigAndAction.copy(httpRequestConfig, httpRequestAction);
    }

    @NotNull
    public final HttpRequestConfig component1() {
        return this.f3023a;
    }

    @NotNull
    public final HttpRequestAction component2() {
        return this.f3024b;
    }

    @NotNull
    public final HttpRequestConfigAndAction copy(@NotNull HttpRequestConfig requestConfig, @NotNull HttpRequestAction httpRequestionAction) {
        Intrinsics.checkNotNullParameter(requestConfig, "requestConfig");
        Intrinsics.checkNotNullParameter(httpRequestionAction, "httpRequestionAction");
        return new HttpRequestConfigAndAction(requestConfig, httpRequestionAction);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequestConfigAndAction)) {
            return false;
        }
        HttpRequestConfigAndAction httpRequestConfigAndAction = (HttpRequestConfigAndAction) obj;
        if (Intrinsics.areEqual(this.f3023a, httpRequestConfigAndAction.f3023a) && Intrinsics.areEqual(this.f3024b, httpRequestConfigAndAction.f3024b)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final HttpRequestAction getHttpRequestionAction() {
        return this.f3024b;
    }

    @NotNull
    public final HttpRequestConfig getRequestConfig() {
        return this.f3023a;
    }

    public int hashCode() {
        return (this.f3023a.hashCode() * 31) + this.f3024b.hashCode();
    }

    @NotNull
    public String toString() {
        HttpRequestConfig httpRequestConfig = this.f3023a;
        HttpRequestAction httpRequestAction = this.f3024b;
        return "HttpRequestConfigAndAction(requestConfig=" + httpRequestConfig + ", httpRequestionAction=" + httpRequestAction + ")";
    }
}
