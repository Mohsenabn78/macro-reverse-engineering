package com.arlosoft.macrodroid.templatestore.reportmacro;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReportMacroViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class UiEvent {
    public static final int $stable = 0;

    /* compiled from: ReportMacroViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class CloseScreen extends UiEvent {
        public static final int $stable = 0;
        @NotNull
        public static final CloseScreen INSTANCE = new CloseScreen();

        private CloseScreen() {
            super(null);
        }
    }

    /* compiled from: ReportMacroViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class FailedOperationError extends UiEvent {
        public static final int $stable = 0;
        @NotNull
        public static final FailedOperationError INSTANCE = new FailedOperationError();

        private FailedOperationError() {
            super(null);
        }
    }

    private UiEvent() {
    }

    public /* synthetic */ UiEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
