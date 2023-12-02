package com.arlosoft.macrodroid.templatestore.translation;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.nl.translate.TranslateRemoteModel;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: TemplatesTranslationHelper.kt */
@StabilityInferred(parameters = 0)
@Singleton
@SourceDebugExtension({"SMAP\nTemplatesTranslationHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplatesTranslationHelper.kt\ncom/arlosoft/macrodroid/templatestore/translation/TemplatesTranslationHelper\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,102:1\n314#2,11:103\n314#2,11:114\n*S KotlinDebug\n*F\n+ 1 TemplatesTranslationHelper.kt\ncom/arlosoft/macrodroid/templatestore/translation/TemplatesTranslationHelper\n*L\n41#1:103,11\n90#1:114,11\n*E\n"})
/* loaded from: classes3.dex */
public final class TemplatesTranslationHelper {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f13682a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private TranslatorOptions f13683b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Translator f13684c;

    /* compiled from: TemplatesTranslationHelper.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<Void, Unit> {
        final /* synthetic */ Function1<Boolean, Unit> $translationReady;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Boolean, Unit> function1) {
            super(1);
            this.$translationReady = function1;
        }

        public final void a(Void r22) {
            this.$translationReady.invoke(Boolean.TRUE);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TemplatesTranslationHelper.kt */
    @SourceDebugExtension({"SMAP\nTemplatesTranslationHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplatesTranslationHelper.kt\ncom/arlosoft/macrodroid/templatestore/translation/TemplatesTranslationHelper$isModelAvailable$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n1549#2:103\n1620#2,3:104\n*S KotlinDebug\n*F\n+ 1 TemplatesTranslationHelper.kt\ncom/arlosoft/macrodroid/templatestore/translation/TemplatesTranslationHelper$isModelAvailable$2$1\n*L\n46#1:103\n46#1:104,3\n*E\n"})
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<Set<TranslateRemoteModel>, Unit> {
        final /* synthetic */ CancellableContinuation<Boolean> $continuation;
        final /* synthetic */ String $language;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplatesTranslationHelper.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Throwable, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f13685d = new a();

            a() {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplatesTranslationHelper.kt */
        /* renamed from: com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0112b extends Lambda implements Function1<Throwable, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final C0112b f13686d = new C0112b();

            C0112b() {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(String str, CancellableContinuation<? super Boolean> cancellableContinuation) {
            super(1);
            this.$language = str;
            this.$continuation = cancellableContinuation;
        }

        public final void a(Set<TranslateRemoteModel> models) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullExpressionValue(models, "models");
            Set<TranslateRemoteModel> set = models;
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(set, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (TranslateRemoteModel translateRemoteModel : set) {
                arrayList.add(translateRemoteModel.getLanguage());
            }
            if (arrayList.contains(this.$language)) {
                this.$continuation.resume(Boolean.TRUE, a.f13685d);
            } else {
                this.$continuation.resume(Boolean.FALSE, C0112b.f13686d);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<TranslateRemoteModel> set) {
            a(set);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TemplatesTranslationHelper.kt */
    /* loaded from: classes3.dex */
    static final class c implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f13687a;

        /* compiled from: TemplatesTranslationHelper.kt */
        /* loaded from: classes3.dex */
        static final class a extends Lambda implements Function1<Throwable, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f13688d = new a();

            a() {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f13687a = cancellableContinuation;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(@NotNull Exception it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.f13687a.resume(Boolean.FALSE, a.f13688d);
        }
    }

    /* compiled from: TemplatesTranslationHelper.kt */
    /* loaded from: classes3.dex */
    static final class d implements OnSuccessListener {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13689a;

        d(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f13689a = function;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final /* synthetic */ void onSuccess(Object obj) {
            this.f13689a.invoke(obj);
        }
    }

    /* compiled from: TemplatesTranslationHelper.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final e f13690d = new e();

        e() {
            super(1);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TemplatesTranslationHelper.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ CancellableContinuation<String> $continuation;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplatesTranslationHelper.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Throwable, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f13691d = new a();

            a() {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(CancellableContinuation<? super String> cancellableContinuation) {
            super(1);
            this.$continuation = cancellableContinuation;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(String it) {
            CancellableContinuation<String> cancellableContinuation = this.$continuation;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cancellableContinuation.resume(it, a.f13691d);
        }
    }

    /* compiled from: TemplatesTranslationHelper.kt */
    /* loaded from: classes3.dex */
    static final class g implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<String> f13692a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13693b;

        /* compiled from: TemplatesTranslationHelper.kt */
        /* loaded from: classes3.dex */
        static final class a extends Lambda implements Function1<Throwable, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f13694d = new a();

            a() {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        g(CancellableContinuation<? super String> cancellableContinuation, String str) {
            this.f13692a = cancellableContinuation;
            this.f13693b = str;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(@NotNull Exception it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.f13692a.resume(this.f13693b, a.f13694d);
        }
    }

    @Inject
    public TemplatesTranslationHelper(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13682a = context;
        String templateStoreAutoTranslateLanguage = Settings.getTemplateStoreAutoTranslateLanguage(context);
        if (templateStoreAutoTranslateLanguage != null) {
            try {
                TranslatorOptions build = new TranslatorOptions.Builder().setSourceLanguage("en").setTargetLanguage(templateStoreAutoTranslateLanguage).build();
                this.f13683b = build;
                Intrinsics.checkNotNull(build);
                this.f13684c = Translation.getClient(build);
            } catch (Exception e4) {
                SystemLog.logError("Could not initialise translator: " + e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 acceptListener, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(acceptListener, "$acceptListener");
        acceptListener.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 translationReady, Exception e4) {
        Intrinsics.checkNotNullParameter(translationReady, "$translationReady");
        Intrinsics.checkNotNullParameter(e4, "e");
        Timber.e("Failed to download translation model: " + e4, new Object[0]);
        translationReady.invoke(Boolean.FALSE);
    }

    public final void displayModelDownloadDialog(@NotNull Activity activity, @NotNull String languageName, @NotNull final Function0<Unit> acceptListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(languageName, "languageName");
        Intrinsics.checkNotNullParameter(acceptListener, "acceptListener");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.language_model_required);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = activity.getString(R.string.language_model_required_download_for_language_name);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.a…wnload_for_language_name)");
        String format = String.format(string, Arrays.copyOf(new Object[]{languageName}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        builder.setMessage(format);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TemplatesTranslationHelper.d(Function0.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public final void enableTranslation(@NotNull String language, @NotNull final Function1<? super Boolean, Unit> translationReady) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(translationReady, "translationReady");
        try {
            TranslatorOptions build = new TranslatorOptions.Builder().setSourceLanguage("en").setTargetLanguage(language).build();
            this.f13683b = build;
            Intrinsics.checkNotNull(build);
            this.f13684c = Translation.getClient(build);
            DownloadConditions build2 = new DownloadConditions.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build2, "Builder().build()");
            Translator translator = this.f13684c;
            Intrinsics.checkNotNull(translator);
            Task<Void> downloadModelIfNeeded = translator.downloadModelIfNeeded(build2);
            final a aVar = new a(translationReady);
            downloadModelIfNeeded.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.a
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    TemplatesTranslationHelper.e(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.b
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TemplatesTranslationHelper.f(Function1.this, exc);
                }
            });
        } catch (Exception e4) {
            SystemLog.logError("Could not initialise translator: " + e4);
        }
    }

    @Nullable
    public final Object isModelAvailable(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        RemoteModelManager remoteModelManager = RemoteModelManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(remoteModelManager, "getInstance()");
        remoteModelManager.getDownloadedModels(TranslateRemoteModel.class).addOnSuccessListener(new d(new b(str, cancellableContinuationImpl))).addOnFailureListener(new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object translateCoroutine(@NotNull String str, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (this.f13684c == null) {
            Timber.e("Translation failed. The translator is null", new Object[0]);
            cancellableContinuationImpl.resume(str, e.f13690d);
        }
        Translator translator = this.f13684c;
        Intrinsics.checkNotNull(translator);
        translator.translate(str).addOnSuccessListener(new d(new f(cancellableContinuationImpl))).addOnFailureListener(new g(cancellableContinuationImpl, str));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
