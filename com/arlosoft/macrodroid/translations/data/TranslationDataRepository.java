package com.arlosoft.macrodroid.translations.data;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.translations.api.MacroDroidTranslationsApi;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TranslationDataRepository.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TranslationDataRepository {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f14305a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MacroDroidTranslationsApi f14306b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranslationDataRepository.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TranslationDataRepository.this.getTranslationData(this);
        }
    }

    @Inject
    public TranslationDataRepository(@ApplicationContext @NotNull Context context, @NotNull MacroDroidTranslationsApi api) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(api, "api");
        this.f14305a = context;
        this.f14306b = api;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getTranslationData(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.arlosoft.macrodroid.translations.data.Translation>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.arlosoft.macrodroid.translations.data.TranslationDataRepository.a
            if (r0 == 0) goto L13
            r0 = r5
            com.arlosoft.macrodroid.translations.data.TranslationDataRepository$a r0 = (com.arlosoft.macrodroid.translations.data.TranslationDataRepository.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.translations.data.TranslationDataRepository$a r0 = new com.arlosoft.macrodroid.translations.data.TranslationDataRepository$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L42
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            com.arlosoft.macrodroid.translations.api.MacroDroidTranslationsApi r5 = r4.f14306b     // Catch: java.lang.Exception -> L42
            r0.label = r3     // Catch: java.lang.Exception -> L42
            java.lang.Object r5 = r5.getLanguages(r0)     // Catch: java.lang.Exception -> L42
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L42
            goto L43
        L42:
            r5 = 0
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.translations.data.TranslationDataRepository.getTranslationData(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
