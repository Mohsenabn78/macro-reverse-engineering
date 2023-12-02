package com.arlosoft.macrodroid.javascript;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavaScripResult.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class JavaScripResult {
    public static final int $stable = 0;

    /* compiled from: JavaScripResult.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Failure extends JavaScripResult {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f12587a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(@NotNull Throwable error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.f12587a = error;
        }

        @NotNull
        public final Throwable getError() {
            return this.f12587a;
        }
    }

    /* compiled from: JavaScripResult.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Success extends JavaScripResult {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f12588a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(@NotNull String result) {
            super(null);
            Intrinsics.checkNotNullParameter(result, "result");
            this.f12588a = result;
        }

        @NotNull
        public final String getResult() {
            return this.f12588a;
        }
    }

    private JavaScripResult() {
    }

    public /* synthetic */ JavaScripResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
