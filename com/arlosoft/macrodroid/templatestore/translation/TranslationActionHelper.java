package com.arlosoft.macrodroid.templatestore.translation;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.templatestore.translation.ModelDownloadState;
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
import java.util.Locale;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TranslationActionHelper.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class TranslationActionHelper {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f13696a;

    /* compiled from: TranslationActionHelper.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<Void, Unit> {
        final /* synthetic */ Function1<ModelDownloadState, Unit> $downloadComplete;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super ModelDownloadState, Unit> function1) {
            super(1);
            this.$downloadComplete = function1;
        }

        public final void a(Void r22) {
            this.$downloadComplete.invoke(ModelDownloadState.Ok.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TranslationActionHelper.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<Void, Unit> {
        final /* synthetic */ Function2<Translator, Boolean, Unit> $translationReady;
        final /* synthetic */ Translator $translator;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Translator, ? super Boolean, Unit> function2, Translator translator) {
            super(1);
            this.$translationReady = function2;
            this.$translator = translator;
        }

        public final void a(Void r32) {
            this.$translationReady.mo1invoke(this.$translator, Boolean.TRUE);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TranslationActionHelper.kt */
    @SourceDebugExtension({"SMAP\nTranslationActionHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslationActionHelper.kt\ncom/arlosoft/macrodroid/templatestore/translation/TranslationActionHelper$isModelAvailable$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1549#2:100\n1620#2,3:101\n*S KotlinDebug\n*F\n+ 1 TranslationActionHelper.kt\ncom/arlosoft/macrodroid/templatestore/translation/TranslationActionHelper$isModelAvailable$1\n*L\n27#1:100\n27#1:101,3\n*E\n"})
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<Set<TranslateRemoteModel>, Unit> {
        final /* synthetic */ Function1<Boolean, Unit> $isAvailable;
        final /* synthetic */ String $language;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(String str, Function1<? super Boolean, Unit> function1) {
            super(1);
            this.$language = str;
            this.$isAvailable = function1;
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
                this.$isAvailable.invoke(Boolean.TRUE);
            } else {
                this.$isAvailable.invoke(Boolean.FALSE);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<TranslateRemoteModel> set) {
            a(set);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public TranslationActionHelper(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13696a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function0 acceptListener, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(acceptListener, "$acceptListener");
        acceptListener.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 downloadComplete, Exception e4) {
        Intrinsics.checkNotNullParameter(downloadComplete, "$downloadComplete");
        Intrinsics.checkNotNullParameter(e4, "e");
        downloadComplete.invoke(new ModelDownloadState.Failed(e4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function2 translationReady, Translator translator, Exception e4) {
        Intrinsics.checkNotNullParameter(translationReady, "$translationReady");
        Intrinsics.checkNotNullParameter(translator, "$translator");
        Intrinsics.checkNotNullParameter(e4, "e");
        SystemLog.logError("Failed to download translation model: " + e4);
        translationReady.mo1invoke(translator, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 isAvailable, Exception it) {
        Intrinsics.checkNotNullParameter(isAvailable, "$isAvailable");
        Intrinsics.checkNotNullParameter(it, "it");
        SystemLog.logError("Could not get downloaded language models: " + it);
        isAvailable.invoke(Boolean.FALSE);
    }

    public final void displayModelDownloadDialog(@NotNull Activity activity, @Nullable String str, @NotNull final Function0<Unit> acceptListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(acceptListener, "acceptListener");
        if (str != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(R.string.language_model_required);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = activity.getString(R.string.translate_text_download_language_model);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.a…_download_language_model)");
            String format = String.format(string, Arrays.copyOf(new Object[]{new Locale(str).getDisplayName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            builder.setMessage(format);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    TranslationActionHelper.h(Function0.this, dialogInterface, i4);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    public final void downloadModel(@NotNull String sourceLanguage, @NotNull String outLanguage, @NotNull final Function1<? super ModelDownloadState, Unit> downloadComplete) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(outLanguage, "outLanguage");
        Intrinsics.checkNotNullParameter(downloadComplete, "downloadComplete");
        try {
            TranslatorOptions build = new TranslatorOptions.Builder().setSourceLanguage(sourceLanguage).setTargetLanguage(outLanguage).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
            Translator client = Translation.getClient(build);
            Intrinsics.checkNotNullExpressionValue(client, "getClient(options)");
            DownloadConditions build2 = new DownloadConditions.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build2, "Builder().build()");
            Task<Void> downloadModelIfNeeded = client.downloadModelIfNeeded(build2);
            final a aVar = new a(downloadComplete);
            downloadModelIfNeeded.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.f
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    TranslationActionHelper.i(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.g
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TranslationActionHelper.j(Function1.this, exc);
                }
            });
        } catch (Exception e4) {
            downloadComplete.invoke(new ModelDownloadState.Failed(e4));
        }
    }

    public final void enableTranslation(@NotNull String sourceLanguage, @NotNull String outLanguage, @NotNull final Function2<? super Translator, ? super Boolean, Unit> translationReady) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(outLanguage, "outLanguage");
        Intrinsics.checkNotNullParameter(translationReady, "translationReady");
        try {
            TranslatorOptions build = new TranslatorOptions.Builder().setSourceLanguage(sourceLanguage).setTargetLanguage(outLanguage).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
            final Translator client = Translation.getClient(build);
            Intrinsics.checkNotNullExpressionValue(client, "getClient(options)");
            DownloadConditions build2 = new DownloadConditions.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build2, "Builder().build()");
            Task<Void> downloadModelIfNeeded = client.downloadModelIfNeeded(build2);
            final b bVar = new b(translationReady, client);
            downloadModelIfNeeded.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.h
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    TranslationActionHelper.k(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.i
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TranslationActionHelper.l(Function2.this, client, exc);
                }
            });
        } catch (Exception e4) {
            SystemLog.logError("Could not initialise translator: " + e4);
        }
    }

    public final void isModelAvailable(@NotNull String language, @NotNull final Function1<? super Boolean, Unit> isAvailable) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(isAvailable, "isAvailable");
        RemoteModelManager remoteModelManager = RemoteModelManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(remoteModelManager, "getInstance()");
        Task downloadedModels = remoteModelManager.getDownloadedModels(TranslateRemoteModel.class);
        final c cVar = new c(language, isAvailable);
        downloadedModels.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.d
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                TranslationActionHelper.m(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.translation.e
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TranslationActionHelper.n(Function1.this, exc);
            }
        });
    }
}
