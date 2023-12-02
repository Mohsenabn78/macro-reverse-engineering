package com.arlosoft.macrodroid.triggers.services;

import android.view.View;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatingTextService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FloatingView {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f15486a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final View f15487b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f15488c;

    public FloatingView(@NotNull String id, @NotNull View container, @NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.f15486a = id;
        this.f15487b = container;
        this.f15488c = textView;
    }

    public static /* synthetic */ FloatingView copy$default(FloatingView floatingView, String str, View view, TextView textView, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = floatingView.f15486a;
        }
        if ((i4 & 2) != 0) {
            view = floatingView.f15487b;
        }
        if ((i4 & 4) != 0) {
            textView = floatingView.f15488c;
        }
        return floatingView.copy(str, view, textView);
    }

    @NotNull
    public final String component1() {
        return this.f15486a;
    }

    @NotNull
    public final View component2() {
        return this.f15487b;
    }

    @NotNull
    public final TextView component3() {
        return this.f15488c;
    }

    @NotNull
    public final FloatingView copy(@NotNull String id, @NotNull View container, @NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(textView, "textView");
        return new FloatingView(id, container, textView);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatingView)) {
            return false;
        }
        FloatingView floatingView = (FloatingView) obj;
        if (Intrinsics.areEqual(this.f15486a, floatingView.f15486a) && Intrinsics.areEqual(this.f15487b, floatingView.f15487b) && Intrinsics.areEqual(this.f15488c, floatingView.f15488c)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final View getContainer() {
        return this.f15487b;
    }

    @NotNull
    public final String getId() {
        return this.f15486a;
    }

    @NotNull
    public final TextView getTextView() {
        return this.f15488c;
    }

    public int hashCode() {
        return (((this.f15486a.hashCode() * 31) + this.f15487b.hashCode()) * 31) + this.f15488c.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f15486a;
        View view = this.f15487b;
        TextView textView = this.f15488c;
        return "FloatingView(id=" + str + ", container=" + view + ", textView=" + textView + ")";
    }
}
