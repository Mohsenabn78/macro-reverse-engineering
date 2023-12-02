package com.arlosoft.macrodroid.templatestore.translation;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ModelDownloadState.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class ModelDownloadState {
    public static final int $stable = 0;

    /* compiled from: ModelDownloadState.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Failed extends ModelDownloadState {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Exception f13681a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(@NotNull Exception e4) {
            super(null);
            Intrinsics.checkNotNullParameter(e4, "e");
            this.f13681a = e4;
        }

        @NotNull
        public final Exception getE() {
            return this.f13681a;
        }
    }

    /* compiled from: ModelDownloadState.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Ok extends ModelDownloadState {
        public static final int $stable = 0;
        @NotNull
        public static final Ok INSTANCE = new Ok();

        private Ok() {
            super(null);
        }
    }

    private ModelDownloadState() {
    }

    public /* synthetic */ ModelDownloadState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
