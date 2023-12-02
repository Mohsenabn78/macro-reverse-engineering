package com.arlosoft.macrodroid.action.services;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIInteractionAccessibilityService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class TextWithActiveRootNodeState {
    public static final int $stable = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f4905a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4906b;

    public TextWithActiveRootNodeState(@NotNull String text, boolean z3) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.f4905a = text;
        this.f4906b = z3;
    }

    public static /* synthetic */ TextWithActiveRootNodeState copy$default(TextWithActiveRootNodeState textWithActiveRootNodeState, String str, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = textWithActiveRootNodeState.f4905a;
        }
        if ((i4 & 2) != 0) {
            z3 = textWithActiveRootNodeState.f4906b;
        }
        return textWithActiveRootNodeState.copy(str, z3);
    }

    @NotNull
    public final String component1() {
        return this.f4905a;
    }

    public final boolean component2() {
        return this.f4906b;
    }

    @NotNull
    public final TextWithActiveRootNodeState copy(@NotNull String text, boolean z3) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TextWithActiveRootNodeState(text, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextWithActiveRootNodeState)) {
            return false;
        }
        TextWithActiveRootNodeState textWithActiveRootNodeState = (TextWithActiveRootNodeState) obj;
        if (Intrinsics.areEqual(this.f4905a, textWithActiveRootNodeState.f4905a) && this.f4906b == textWithActiveRootNodeState.f4906b) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getText() {
        return this.f4905a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f4905a.hashCode() * 31;
        boolean z3 = this.f4906b;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    public final boolean isActiveRootNode() {
        return this.f4906b;
    }

    @NotNull
    public String toString() {
        String str = this.f4905a;
        boolean z3 = this.f4906b;
        return "TextWithActiveRootNodeState(text=" + str + ", isActiveRootNode=" + z3 + ")";
    }
}
