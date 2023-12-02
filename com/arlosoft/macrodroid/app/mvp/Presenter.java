package com.arlosoft.macrodroid.app.mvp;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.Nullable;

/* compiled from: Presenter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public class Presenter<T> {
    public static final int $stable = 8;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private T f9293a;

    public final void dropView() {
        a();
        this.f9293a = null;
    }

    @Nullable
    public final T getView() {
        return this.f9293a;
    }

    public final boolean isBoundToView() {
        if (this.f9293a != null) {
            return true;
        }
        return false;
    }

    public final void setView(@Nullable T t3) {
        this.f9293a = t3;
    }

    public final void takeView(T t3) {
        if (this.f9293a == null) {
            this.f9293a = t3;
            b();
            return;
        }
        throw new IllegalStateException("Presenter already has the view or the dropView isn't called");
    }

    protected void a() {
    }

    protected void b() {
    }
}
