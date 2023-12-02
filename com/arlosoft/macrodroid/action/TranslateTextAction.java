package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.TranslateTextAction;
import com.arlosoft.macrodroid.action.info.TranslateTextActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.templatestore.translation.ModelDownloadState;
import com.arlosoft.macrodroid.templatestore.translation.TranslationActionHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TranslateTextAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTranslateTextAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslateTextAction.kt\ncom/arlosoft/macrodroid/action/TranslateTextAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,480:1\n1549#2:481\n1620#2,3:482\n65#3,16:485\n93#3,3:501\n*S KotlinDebug\n*F\n+ 1 TranslateTextAction.kt\ncom/arlosoft/macrodroid/action/TranslateTextAction\n*L\n173#1:481\n173#1:482,3\n209#1:485,16\n209#1:501,3\n*E\n"})
/* loaded from: classes2.dex */
public final class TranslateTextAction extends Action implements SupportsMagicText, HasStringVariableName, BlockingAction {
    @Nullable
    private DictionaryKeys dictionaryKeys;
    private int option;
    @Nullable
    private String outputLanguageCode;
    @Nullable
    private transient MaterialDialog progressDialog;
    @Nullable
    private String sourceLanguageCode;
    @NotNull
    private String text;
    @Inject
    public transient TranslationActionHelper translationHelper;
    @Nullable
    private String variableName;
    @Nullable
    private transient DictionaryKeys workingDictionaryKeys;
    @Nullable
    private transient String workingVariableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<TranslateTextAction> CREATOR = new Parcelable.Creator<TranslateTextAction>() { // from class: com.arlosoft.macrodroid.action.TranslateTextAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public TranslateTextAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TranslateTextAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public TranslateTextAction[] newArray(int i4) {
            return new TranslateTextAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranslateTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ Function1<Boolean, Unit> $isAvailable;
        final /* synthetic */ String $outputLanguage;
        final /* synthetic */ String $sourceLanguage;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TranslateTextAction.kt */
        /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0071a extends Lambda implements Function1<Boolean, Unit> {
            final /* synthetic */ Function1<Boolean, Unit> $isAvailable;
            final /* synthetic */ String $outputLanguage;
            final /* synthetic */ String $sourceLanguage;
            final /* synthetic */ TranslateTextAction this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TranslateTextAction.kt */
            /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0072a extends Lambda implements Function0<Unit> {
                final /* synthetic */ Function1<Boolean, Unit> $isAvailable;
                final /* synthetic */ String $outputLanguage;
                final /* synthetic */ String $sourceLanguage;
                final /* synthetic */ TranslateTextAction this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: TranslateTextAction.kt */
                /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes2.dex */
                public static final class C0073a extends Lambda implements Function1<ModelDownloadState, Unit> {
                    final /* synthetic */ Function1<Boolean, Unit> $isAvailable;
                    final /* synthetic */ TranslateTextAction this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0073a(TranslateTextAction translateTextAction, Function1<? super Boolean, Unit> function1) {
                        super(1);
                        this.this$0 = translateTextAction;
                        this.$isAvailable = function1;
                    }

                    public final void a(@NotNull ModelDownloadState it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        this.this$0.d0();
                        if (Intrinsics.areEqual(it, ModelDownloadState.Ok.INSTANCE)) {
                            this.$isAvailable.invoke(Boolean.TRUE);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ModelDownloadState modelDownloadState) {
                        a(modelDownloadState);
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0072a(TranslateTextAction translateTextAction, String str, String str2, Function1<? super Boolean, Unit> function1) {
                    super(0);
                    this.this$0 = translateTextAction;
                    this.$sourceLanguage = str;
                    this.$outputLanguage = str2;
                    this.$isAvailable = function1;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.i0();
                    this.this$0.getTranslationHelper().downloadModel(this.$sourceLanguage, this.$outputLanguage, new C0073a(this.this$0, this.$isAvailable));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0071a(Function1<? super Boolean, Unit> function1, TranslateTextAction translateTextAction, String str, String str2) {
                super(1);
                this.$isAvailable = function1;
                this.this$0 = translateTextAction;
                this.$outputLanguage = str;
                this.$sourceLanguage = str2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z3) {
                if (z3) {
                    this.$isAvailable.invoke(Boolean.TRUE);
                    return;
                }
                TranslationActionHelper translationHelper = this.this$0.getTranslationHelper();
                Activity activity = this.this$0.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                String str = this.$outputLanguage;
                translationHelper.displayModelDownloadDialog(activity, str, new C0072a(this.this$0, this.$sourceLanguage, str, this.$isAvailable));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TranslateTextAction.kt */
        /* loaded from: classes2.dex */
        public static final class b extends Lambda implements Function0<Unit> {
            final /* synthetic */ Function1<Boolean, Unit> $isAvailable;
            final /* synthetic */ String $outputLanguage;
            final /* synthetic */ String $sourceLanguage;
            final /* synthetic */ TranslateTextAction this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TranslateTextAction.kt */
            /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0074a extends Lambda implements Function1<ModelDownloadState, Unit> {
                final /* synthetic */ Function1<Boolean, Unit> $isAvailable;
                final /* synthetic */ TranslateTextAction this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0074a(TranslateTextAction translateTextAction, Function1<? super Boolean, Unit> function1) {
                    super(1);
                    this.this$0 = translateTextAction;
                    this.$isAvailable = function1;
                }

                public final void a(@NotNull ModelDownloadState it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.d0();
                    if (Intrinsics.areEqual(it, ModelDownloadState.Ok.INSTANCE)) {
                        this.$isAvailable.invoke(Boolean.TRUE);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ModelDownloadState modelDownloadState) {
                    a(modelDownloadState);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(TranslateTextAction translateTextAction, String str, String str2, Function1<? super Boolean, Unit> function1) {
                super(0);
                this.this$0 = translateTextAction;
                this.$sourceLanguage = str;
                this.$outputLanguage = str2;
                this.$isAvailable = function1;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.i0();
                this.this$0.getTranslationHelper().downloadModel(this.$sourceLanguage, this.$outputLanguage, new C0074a(this.this$0, this.$isAvailable));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(String str, String str2, Function1<? super Boolean, Unit> function1) {
            super(1);
            this.$outputLanguage = str;
            this.$sourceLanguage = str2;
            this.$isAvailable = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            if (z3) {
                TranslationActionHelper translationHelper = TranslateTextAction.this.getTranslationHelper();
                String str = this.$outputLanguage;
                translationHelper.isModelAvailable(str, new C0071a(this.$isAvailable, TranslateTextAction.this, str, this.$sourceLanguage));
                return;
            }
            TranslationActionHelper translationHelper2 = TranslateTextAction.this.getTranslationHelper();
            Activity activity = TranslateTextAction.this.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            String str2 = this.$sourceLanguage;
            translationHelper2.displayModelDownloadDialog(activity, str2, new b(TranslateTextAction.this, str2, this.$outputLanguage, this.$isAvailable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranslateTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ EditText $textToTranslate;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TranslateTextAction.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f2683d = new a();

            a() {
                super(1);
            }

            public final void invoke(boolean z3) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TranslateTextAction.kt */
        /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0075b extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final C0075b f2684d = new C0075b();

            C0075b() {
                super(1);
            }

            public final void invoke(boolean z3) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EditText editText, AppCompatDialog appCompatDialog) {
            super(1);
            this.$textToTranslate = editText;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            if (z3) {
                TranslateTextAction.this.text = this.$textToTranslate.getText().toString();
                TranslateTextAction translateTextAction = TranslateTextAction.this;
                translateTextAction.variableName = translateTextAction.workingVariableName;
                TranslateTextAction translateTextAction2 = TranslateTextAction.this;
                translateTextAction2.dictionaryKeys = translateTextAction2.workingDictionaryKeys;
                this.$dialog.dismiss();
                TranslateTextAction.this.itemComplete();
            }
            TranslationActionHelper translationHelper = TranslateTextAction.this.getTranslationHelper();
            String str = TranslateTextAction.this.sourceLanguageCode;
            Intrinsics.checkNotNull(str);
            translationHelper.isModelAvailable(str, a.f2683d);
            TranslationActionHelper translationHelper2 = TranslateTextAction.this.getTranslationHelper();
            String str2 = TranslateTextAction.this.outputLanguageCode;
            Intrinsics.checkNotNull(str2);
            translationHelper2.isModelAvailable(str2, C0075b.f2684d);
        }
    }

    /* compiled from: TranslateTextAction.kt */
    /* loaded from: classes2.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $allLanguages;
        final /* synthetic */ Spinner $outputLanguageSpinner;
        final /* synthetic */ Spinner $sourceLanguageSpinner;
        int label;
        final /* synthetic */ TranslateTextAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Spinner spinner, Spinner spinner2, List<String> list, TranslateTextAction translateTextAction, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$sourceLanguageSpinner = spinner;
            this.$outputLanguageSpinner = spinner2;
            this.$allLanguages = list;
            this.this$0 = translateTextAction;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$sourceLanguageSpinner, this.$outputLanguageSpinner, this.$allLanguages, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TranslateTextAction.W(this.$sourceLanguageSpinner, this.$outputLanguageSpinner, this.$allLanguages, this.this$0, true);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TranslateTextAction.kt */
    /* loaded from: classes2.dex */
    static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $allLanguages;
        final /* synthetic */ Spinner $outputLanguageSpinner;
        final /* synthetic */ Spinner $sourceLanguageSpinner;
        int label;
        final /* synthetic */ TranslateTextAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Spinner spinner, Spinner spinner2, List<String> list, TranslateTextAction translateTextAction, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$sourceLanguageSpinner = spinner;
            this.$outputLanguageSpinner = spinner2;
            this.$allLanguages = list;
            this.this$0 = translateTextAction;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$sourceLanguageSpinner, this.$outputLanguageSpinner, this.$allLanguages, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TranslateTextAction.W(this.$sourceLanguageSpinner, this.$outputLanguageSpinner, this.$allLanguages, this.this$0, false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: TranslateTextAction.kt */
    /* loaded from: classes2.dex */
    static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $allLanguages;
        final /* synthetic */ Spinner $outputLanguageSpinner;
        final /* synthetic */ Spinner $sourceLanguageSpinner;
        final /* synthetic */ EditText $textToTranslate;
        int label;
        final /* synthetic */ TranslateTextAction this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TranslateTextAction.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements Function1<Boolean, Unit> {
            final /* synthetic */ List<String> $allLanguages;
            final /* synthetic */ String $outputLanguage;
            final /* synthetic */ Spinner $outputLanguageSpinner;
            final /* synthetic */ String $sourceLanguage;
            final /* synthetic */ Spinner $sourceLanguageSpinner;
            final /* synthetic */ EditText $textToTranslate;
            final /* synthetic */ TranslateTextAction this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TranslateTextAction.kt */
            /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0076a extends Lambda implements Function2<Translator, Boolean, Unit> {
                final /* synthetic */ String $outputLanguage;
                final /* synthetic */ String $sourceLanguage;
                final /* synthetic */ EditText $textToTranslate;
                final /* synthetic */ TranslateTextAction this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: TranslateTextAction.kt */
                /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$e$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes2.dex */
                public static final class C0077a extends Lambda implements Function1<String, Unit> {
                    final /* synthetic */ String $outputLanguage;
                    final /* synthetic */ String $sourceLanguage;
                    final /* synthetic */ TranslateTextAction this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TranslateTextAction.kt */
                    /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$e$a$a$a$a  reason: collision with other inner class name */
                    /* loaded from: classes2.dex */
                    public static final class C0078a extends Lambda implements Function1<Boolean, Unit> {

                        /* renamed from: d  reason: collision with root package name */
                        public static final C0078a f2685d = new C0078a();

                        C0078a() {
                            super(1);
                        }

                        public final void invoke(boolean z3) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TranslateTextAction.kt */
                    /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$e$a$a$a$b */
                    /* loaded from: classes2.dex */
                    public static final class b extends Lambda implements Function1<Boolean, Unit> {

                        /* renamed from: d  reason: collision with root package name */
                        public static final b f2686d = new b();

                        b() {
                            super(1);
                        }

                        public final void invoke(boolean z3) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0077a(TranslateTextAction translateTextAction, String str, String str2) {
                        super(1);
                        this.this$0 = translateTextAction;
                        this.$sourceLanguage = str;
                        this.$outputLanguage = str2;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        ToastCompat.makeText(this.this$0.getContext().getApplicationContext(), (CharSequence) str, 1).show();
                        TranslationActionHelper translationHelper = this.this$0.getTranslationHelper();
                        String sourceLanguage = this.$sourceLanguage;
                        Intrinsics.checkNotNullExpressionValue(sourceLanguage, "sourceLanguage");
                        translationHelper.isModelAvailable(sourceLanguage, C0078a.f2685d);
                        TranslationActionHelper translationHelper2 = this.this$0.getTranslationHelper();
                        String outputLanguage = this.$outputLanguage;
                        Intrinsics.checkNotNullExpressionValue(outputLanguage, "outputLanguage");
                        translationHelper2.isModelAvailable(outputLanguage, b.f2686d);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0076a(TranslateTextAction translateTextAction, EditText editText, String str, String str2) {
                    super(2);
                    this.this$0 = translateTextAction;
                    this.$textToTranslate = editText;
                    this.$sourceLanguage = str;
                    this.$outputLanguage = str2;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void e(Function1 tmp0, Object obj) {
                    Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                    tmp0.invoke(obj);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void f(TranslateTextAction this$0, Exception it) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    Intrinsics.checkNotNullParameter(it, "it");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String r4 = SelectableItem.r(R.string.translation_failed_with_reason);
                    Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.translation_failed_with_reason)");
                    String format = String.format(r4, Arrays.copyOf(new Object[]{it}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    ToastCompat.makeText(this$0.getContext().getApplicationContext(), (CharSequence) format, 1).show();
                    SystemLog.logError(format);
                }

                public final void c(@NotNull Translator translator, boolean z3) {
                    Intrinsics.checkNotNullParameter(translator, "translator");
                    if (z3) {
                        Task<String> translate = translator.translate(this.this$0.g(this.$textToTranslate.getText().toString(), null));
                        final C0077a c0077a = new C0077a(this.this$0, this.$sourceLanguage, this.$outputLanguage);
                        Task<String> addOnSuccessListener = translate.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.action.ir
                            @Override // com.google.android.gms.tasks.OnSuccessListener
                            public final void onSuccess(Object obj) {
                                TranslateTextAction.e.a.C0076a.e(Function1.this, obj);
                            }
                        });
                        final TranslateTextAction translateTextAction = this.this$0;
                        addOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.action.jr
                            @Override // com.google.android.gms.tasks.OnFailureListener
                            public final void onFailure(Exception exc) {
                                TranslateTextAction.e.a.C0076a.f(TranslateTextAction.this, exc);
                            }
                        });
                        return;
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String r4 = SelectableItem.r(R.string.translation_failed_with_reason);
                    Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.translation_failed_with_reason)");
                    String format = String.format(r4, Arrays.copyOf(new Object[]{SelectableItem.r(R.string.language_model_download_failed)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    ToastCompat.makeText(this.this$0.getContext().getApplicationContext(), (CharSequence) format, 1).show();
                    SystemLog.logError(format);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ Unit mo1invoke(Translator translator, Boolean bool) {
                    c(translator, bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TranslateTextAction translateTextAction, List<String> list, Spinner spinner, Spinner spinner2, EditText editText, String str, String str2) {
                super(1);
                this.this$0 = translateTextAction;
                this.$allLanguages = list;
                this.$sourceLanguageSpinner = spinner;
                this.$outputLanguageSpinner = spinner2;
                this.$textToTranslate = editText;
                this.$sourceLanguage = str;
                this.$outputLanguage = str2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z3) {
                TranslationActionHelper translationHelper = this.this$0.getTranslationHelper();
                String str = this.$allLanguages.get(this.$sourceLanguageSpinner.getSelectedItemPosition() - 1);
                Intrinsics.checkNotNullExpressionValue(str, "allLanguages[sourceLangu…selectedItemPosition - 1]");
                String str2 = this.$allLanguages.get(this.$outputLanguageSpinner.getSelectedItemPosition() - 1);
                Intrinsics.checkNotNullExpressionValue(str2, "allLanguages[outputLangu…selectedItemPosition - 1]");
                translationHelper.enableTranslation(str, str2, new C0076a(this.this$0, this.$textToTranslate, this.$sourceLanguage, this.$outputLanguage));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(List<String> list, Spinner spinner, Spinner spinner2, TranslateTextAction translateTextAction, EditText editText, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$allLanguages = list;
            this.$sourceLanguageSpinner = spinner;
            this.$outputLanguageSpinner = spinner2;
            this.this$0 = translateTextAction;
            this.$textToTranslate = editText;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$allLanguages, this.$sourceLanguageSpinner, this.$outputLanguageSpinner, this.this$0, this.$textToTranslate, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String sourceLanguage = this.$allLanguages.get(this.$sourceLanguageSpinner.getSelectedItemPosition() - 1);
                String outputLanguage = this.$allLanguages.get(this.$outputLanguageSpinner.getSelectedItemPosition() - 1);
                TranslateTextAction translateTextAction = this.this$0;
                Intrinsics.checkNotNullExpressionValue(sourceLanguage, "sourceLanguage");
                Intrinsics.checkNotNullExpressionValue(outputLanguage, "outputLanguage");
                translateTextAction.V(sourceLanguage, outputLanguage, new a(this.this$0, this.$allLanguages, this.$sourceLanguageSpinner, this.$outputLanguageSpinner, this.$textToTranslate, sourceLanguage, outputLanguage));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TranslateTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class f extends Lambda implements Function0<Unit> {
        final /* synthetic */ boolean $isSource;
        final /* synthetic */ String $outputLanguage;
        final /* synthetic */ String $sourceLanguage;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TranslateTextAction.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements Function1<ModelDownloadState, Unit> {
            final /* synthetic */ String $outputLanguage;
            final /* synthetic */ String $sourceLanguage;
            final /* synthetic */ TranslateTextAction this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TranslateTextAction.kt */
            /* renamed from: com.arlosoft.macrodroid.action.TranslateTextAction$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0079a extends Lambda implements Function1<Boolean, Unit> {

                /* renamed from: d  reason: collision with root package name */
                public static final C0079a f2687d = new C0079a();

                C0079a() {
                    super(1);
                }

                public final void invoke(boolean z3) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TranslateTextAction.kt */
            /* loaded from: classes2.dex */
            public static final class b extends Lambda implements Function1<Boolean, Unit> {

                /* renamed from: d  reason: collision with root package name */
                public static final b f2688d = new b();

                b() {
                    super(1);
                }

                public final void invoke(boolean z3) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TranslateTextAction translateTextAction, String str, String str2) {
                super(1);
                this.this$0 = translateTextAction;
                this.$sourceLanguage = str;
                this.$outputLanguage = str2;
            }

            public final void a(@NotNull ModelDownloadState downloadState) {
                Intrinsics.checkNotNullParameter(downloadState, "downloadState");
                this.this$0.d0();
                TranslationActionHelper translationHelper = this.this$0.getTranslationHelper();
                String sourceLanguage = this.$sourceLanguage;
                Intrinsics.checkNotNullExpressionValue(sourceLanguage, "sourceLanguage");
                translationHelper.isModelAvailable(sourceLanguage, C0079a.f2687d);
                TranslationActionHelper translationHelper2 = this.this$0.getTranslationHelper();
                String outputLanguage = this.$outputLanguage;
                Intrinsics.checkNotNullExpressionValue(outputLanguage, "outputLanguage");
                translationHelper2.isModelAvailable(outputLanguage, b.f2688d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelDownloadState modelDownloadState) {
                a(modelDownloadState);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(boolean z3, String str, String str2) {
            super(0);
            this.$isSource = z3;
            this.$sourceLanguage = str;
            this.$outputLanguage = str2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TranslateTextAction.this.i0();
            TranslationActionHelper translationHelper = TranslateTextAction.this.getTranslationHelper();
            String str = this.$isSource ? this.$sourceLanguage : this.$outputLanguage;
            Intrinsics.checkNotNullExpressionValue(str, "if (isSource) sourceLanguage else outputLanguage");
            String str2 = this.$isSource ? this.$outputLanguage : this.$sourceLanguage;
            Intrinsics.checkNotNullExpressionValue(str2, "if (isSource) outputLanguage else sourceLanguage");
            translationHelper.downloadModel(str, str2, new a(TranslateTextAction.this, this.$sourceLanguage, this.$outputLanguage));
        }
    }

    /* compiled from: TranslateTextAction.kt */
    /* loaded from: classes2.dex */
    static final class g extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ ArrayList<String> $keys;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
        final /* synthetic */ MacroDroidVariable $stringVariable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(MacroDroidVariable macroDroidVariable, ArrayList<String> arrayList, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo) {
            super(1);
            this.$stringVariable = macroDroidVariable;
            this.$keys = arrayList;
            this.$nextAction = i4;
            this.$contextInfo = triggerContextInfo;
            this.$forceEvenIfNotEnabled = z3;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TranslateTextAction this$0, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack skipEndifIndexStack, ResumeMacroInfo resumeMacroInfo) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(skipEndifIndexStack, "$skipEndifIndexStack");
            this$0.getMacro().invokeActions(this$0.getMacro().getActions(), i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(String it) {
            SystemLog.logInfo("Text translated: " + it);
            TranslateTextAction translateTextAction = TranslateTextAction.this;
            MacroDroidVariable macroDroidVariable = this.$stringVariable;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            translateTextAction.variableUpdate(macroDroidVariable, new VariableValue.StringValue(it, this.$keys));
            Handler handler = new Handler(Looper.getMainLooper());
            final TranslateTextAction translateTextAction2 = TranslateTextAction.this;
            final int i4 = this.$nextAction;
            final TriggerContextInfo triggerContextInfo = this.$contextInfo;
            final boolean z3 = this.$forceEvenIfNotEnabled;
            final Stack<Integer> stack = this.$skipEndifIndexStack;
            final ResumeMacroInfo resumeMacroInfo = this.$resumeMacroInfo;
            handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.kr
                @Override // java.lang.Runnable
                public final void run() {
                    TranslateTextAction.g.b(TranslateTextAction.this, i4, triggerContextInfo, z3, stack, resumeMacroInfo);
                }
            });
        }
    }

    public /* synthetic */ TranslateTextAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(String str, String str2, Function1<? super Boolean, Unit> function1) {
        getTranslationHelper().isModelAvailable(str, new a(str2, str, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Spinner spinner, Spinner spinner2, List<String> list, TranslateTextAction translateTextAction, boolean z3) {
        String str;
        if (spinner.getSelectedItemPosition() > 0 && spinner2.getSelectedItemPosition() > 0) {
            return;
        }
        String str2 = list.get(spinner.getSelectedItemPosition() - 1);
        String str3 = list.get(spinner2.getSelectedItemPosition() - 1);
        TranslationActionHelper translationHelper = translateTextAction.getTranslationHelper();
        Activity activity = translateTextAction.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        if (z3) {
            str = str2;
        } else {
            str = str3;
        }
        translationHelper.displayModelDownloadDialog(activity, str, new f(z3, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(TranslateTextAction this$0, MagicText.MagicTextListener titleMagicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(titleMagicTextListener, "$titleMagicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), titleMagicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EditText textToTranslate, TranslateTextAction this$0, Spinner stringVariableSpinner, String noStringVarsConfigured, List allLanguages, Spinner sourceLanguageSpinner, Spinner outputLanguageSpinner, AppCompatDialog dialog, View view) {
        boolean z3;
        Intrinsics.checkNotNullParameter(textToTranslate, "$textToTranslate");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stringVariableSpinner, "$stringVariableSpinner");
        Intrinsics.checkNotNullParameter(noStringVarsConfigured, "$noStringVarsConfigured");
        Intrinsics.checkNotNullParameter(allLanguages, "$allLanguages");
        Intrinsics.checkNotNullParameter(sourceLanguageSpinner, "$sourceLanguageSpinner");
        Intrinsics.checkNotNullParameter(outputLanguageSpinner, "$outputLanguageSpinner");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Editable text = textToTranslate.getText();
        Intrinsics.checkNotNullExpressionValue(text, "textToTranslate.text");
        if (text.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ToastCompat.makeText(this$0.getActivity().getApplicationContext(), (int) R.string.enter_text, 0).show();
        } else if (stringVariableSpinner.getAdapter().getCount() != 0 && !Intrinsics.areEqual(stringVariableSpinner.getSelectedItem(), noStringVarsConfigured)) {
            if (this$0.workingVariableName == null) {
                ToastCompat.makeText(this$0.getActivity().getApplicationContext(), (int) R.string.action_set_variable_select, 0).show();
                return;
            }
            this$0.sourceLanguageCode = (String) allLanguages.get(sourceLanguageSpinner.getSelectedItemPosition() - 1);
            this$0.outputLanguageCode = (String) allLanguages.get(outputLanguageSpinner.getSelectedItemPosition() - 1);
            String str = this$0.sourceLanguageCode;
            Intrinsics.checkNotNull(str);
            String str2 = this$0.outputLanguageCode;
            Intrinsics.checkNotNull(str2);
            this$0.V(str, str2, new b(textToTranslate, dialog));
        } else {
            ToastCompat.makeText(this$0.getActivity().getApplicationContext(), (int) R.string.invalid_value, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(final TranslateTextAction this$0, final Spinner stringVariableSpinner, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stringVariableSpinner, "$stringVariableSpinner");
        VariablesHelper.createNewVariable(this$0.getActivity(), stringVariableSpinner, this$0, this$0.getDialogTheme(), 2, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.gr
            @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
            public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                TranslateTextAction.b0(TranslateTextAction.this, stringVariableSpinner, macroDroidVariable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(final TranslateTextAction this$0, Spinner stringVariableSpinner, MacroDroidVariable macroDroidVariable) {
        List listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stringVariableSpinner, "$stringVariableSpinner");
        this$0.workingVariableName = macroDroidVariable.getName();
        String str = null;
        this$0.workingDictionaryKeys = null;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select));
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = this$0.getMacro();
        String str2 = this$0.workingVariableName;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this$0.dictionaryKeys);
        }
        VariableHelper.configureStringVarSpinner(activity, R.style.Theme_App_Dialog_Action, this$0, stringVariableSpinner, macro, listOf, str, true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.TranslateTextAction$handleItemSelected$9$1$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                TranslateTextAction.this.workingVariableName = null;
                TranslateTextAction.this.workingDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                TranslateTextAction.this.workingVariableName = variable.getName();
                TranslateTextAction translateTextAction = TranslateTextAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                translateTextAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(EditText textToTranslate, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(textToTranslate, "$textToTranslate");
        int max = Math.max(textToTranslate.getSelectionStart(), 0);
        int max2 = Math.max(textToTranslate.getSelectionEnd(), 0);
        Editable text = textToTranslate.getText();
        Intrinsics.checkNotNull(text);
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        MaterialDialog materialDialog = this.progressDialog;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
        this.progressDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(final TranslateTextAction this$0, final int i4, final TriggerContextInfo triggerContextInfo, final boolean z3, final Stack skipEndifIndexStack, final ResumeMacroInfo resumeMacroInfo, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "$skipEndifIndexStack");
        Intrinsics.checkNotNullParameter(it, "it");
        SystemLog.logError("Text could not be translated: " + it);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.action.hr
            @Override // java.lang.Runnable
            public final void run() {
                TranslateTextAction.g0(TranslateTextAction.this, i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(TranslateTextAction this$0, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack skipEndifIndexStack, ResumeMacroInfo resumeMacroInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "$skipEndifIndexStack");
        this$0.getMacro().invokeActions(this$0.getMacro().getActions(), i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(Spinner spinner, Spinner spinner2, String str, Button button, Button button2) {
        boolean z3;
        boolean z4 = false;
        if (spinner.getSelectedItemPosition() > 0 && spinner2.getSelectedItemPosition() > 0) {
            if (str.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                z4 = true;
            }
        }
        button.setEnabled(z4);
        button2.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        d0();
        MaterialDialog build = new MaterialDialog.Builder(getActivity()).title(R.string.please_wait).content(R.string.downloading_language_model).progress(true, 0).cancelable(false).widgetColorRes(R.color.actions_accent).build();
        this.progressDialog = build;
        if (build != null) {
            build.show();
        }
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String displayName = new Locale(this.sourceLanguageCode).getDisplayName();
        String displayName2 = new Locale(this.outputLanguageCode).getDisplayName();
        String str = this.text;
        return displayName + " > " + displayName2 + ": " + str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return TranslateTextActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.text};
    }

    @NotNull
    public final TranslationActionHelper getTranslationHelper() {
        TranslationActionHelper translationActionHelper = this.translationHelper;
        if (translationActionHelper != null) {
            return translationActionHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("translationHelper");
        return null;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.variableName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        WindowManager.LayoutParams layoutParams;
        int collectionSizeOrDefault;
        List mutableList;
        List listOf;
        String str;
        List listOf2;
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_translate_text);
        appCompatDialog.setTitle(R.string.action_translate_text);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        View findViewById = appCompatDialog.findViewById(R.id.textToTranslate);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.magicTextButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.sourceLanguageSpinner);
        Intrinsics.checkNotNull(findViewById3);
        final Spinner spinner = (Spinner) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.outputLanguageSpinner);
        Intrinsics.checkNotNull(findViewById4);
        final Spinner spinner2 = (Spinner) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.addStringVariableButton);
        Intrinsics.checkNotNull(findViewById5);
        Button button2 = (Button) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.stringVariableSpinner);
        Intrinsics.checkNotNull(findViewById6);
        final Spinner spinner3 = (Spinner) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.testButton);
        Intrinsics.checkNotNull(findViewById7);
        final Button button3 = (Button) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.downloadSourceModel);
        Intrinsics.checkNotNull(findViewById8);
        TextView textView = (TextView) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.downloadOutputModel);
        Intrinsics.checkNotNull(findViewById9);
        TextView textView2 = (TextView) findViewById9;
        View findViewById10 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById10);
        final Button button4 = (Button) findViewById10;
        View findViewById11 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById11);
        Button button5 = (Button) findViewById11;
        final List<String> allLanguages = TranslateLanguage.getAllLanguages();
        Intrinsics.checkNotNullExpressionValue(allLanguages, "getAllLanguages()");
        List<String> list = allLanguages;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            arrayList.add(new Locale((String) it.next()).getDisplayName());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        editText.setText(this.text);
        ViewExtensionsKt.onClick$default(textView, null, new c(spinner, spinner2, allLanguages, this, null), 1, null);
        ViewExtensionsKt.onClick$default(textView2, null, new d(spinner, spinner2, allLanguages, this, null), 1, null);
        mutableList.add(0, SelectableItem.r(R.string.translate_select_language));
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.TranslateTextAction$handleItemSelected$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                TranslateTextAction.this.h0(spinner, spinner2, String.valueOf(editable), button4, button3);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        ViewExtensionsKt.onClick$default(button3, null, new e(allLanguages, spinner, spinner2, this, editText, null), 1, null);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), (int) R.layout.simple_spinner_item, mutableList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        String str2 = this.sourceLanguageCode;
        if (str2 != null) {
            spinner.setSelection(Math.max(0, allLanguages.indexOf(str2) + 1));
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.action.TranslateTextAction$handleItemSelected$6

            /* compiled from: TranslateTextAction.kt */
            /* loaded from: classes2.dex */
            static final class a extends Lambda implements Function1<Boolean, Unit> {

                /* renamed from: d  reason: collision with root package name */
                public static final a f2697d = new a();

                a() {
                    super(1);
                }

                public final void invoke(boolean z3) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@NotNull AdapterView<?> parent, @Nullable View view, int i4, long j4) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (i4 > 0) {
                    TranslateTextAction.this.h0(spinner, spinner2, editText.getText().toString(), button4, button3);
                    String language = allLanguages.get(i4 - 1);
                    TranslationActionHelper translationHelper = TranslateTextAction.this.getTranslationHelper();
                    Intrinsics.checkNotNullExpressionValue(language, "language");
                    translationHelper.isModelAvailable(language, a.f2697d);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@NotNull AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getContext(), (int) R.layout.simple_spinner_item, mutableList);
        arrayAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
        String str3 = this.outputLanguageCode;
        if (str3 != null) {
            spinner2.setSelection(Math.max(0, allLanguages.indexOf(str3) + 1));
        }
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.action.TranslateTextAction$handleItemSelected$8

            /* compiled from: TranslateTextAction.kt */
            /* loaded from: classes2.dex */
            static final class a extends Lambda implements Function1<Boolean, Unit> {

                /* renamed from: d  reason: collision with root package name */
                public static final a f2705d = new a();

                a() {
                    super(1);
                }

                public final void invoke(boolean z3) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@NotNull AdapterView<?> parent, @Nullable View view, int i4, long j4) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (i4 > 0) {
                    TranslateTextAction.this.h0(spinner, spinner2, editText.getText().toString(), button4, button3);
                    String language = allLanguages.get(i4 - 1);
                    TranslationActionHelper translationHelper = TranslateTextAction.this.getTranslationHelper();
                    Intrinsics.checkNotNullExpressionValue(language, "language");
                    translationHelper.isModelAvailable(language, a.f2705d);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@NotNull AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TranslateTextAction.a0(TranslateTextAction.this, spinner3, view);
            }
        });
        this.workingVariableName = this.variableName;
        this.workingDictionaryKeys = this.dictionaryKeys;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select));
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Macro macro = getMacro();
        String str4 = this.variableName;
        if (str4 != null) {
            str = str4 + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner3, macro, listOf, str, true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.TranslateTextAction$handleItemSelected$10
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                TranslateTextAction.this.workingVariableName = null;
                TranslateTextAction.this.workingDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list2) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                TranslateTextAction.this.workingVariableName = variable.getName();
                TranslateTextAction translateTextAction = TranslateTextAction.this;
                if (list2 != null) {
                    dictionaryKeys = new DictionaryKeys(list2);
                } else {
                    dictionaryKeys = null;
                }
                translateTextAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
        final String string = getContext().getString(R.string.no_string_variables_defined);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…string_variables_defined)");
        if (spinner3.getCount() == 0) {
            Activity activity3 = getActivity();
            listOf2 = kotlin.collections.e.listOf(string);
            ArrayAdapter arrayAdapter3 = new ArrayAdapter(activity3, (int) R.layout.simple_spinner_item, listOf2);
            arrayAdapter3.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner3.setAdapter((SpinnerAdapter) arrayAdapter3);
        }
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ar
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                TranslateTextAction.c0(editText, magicTextPair);
            }
        };
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.br
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TranslateTextAction.X(TranslateTextAction.this, magicTextListener, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.cr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TranslateTextAction.Y(editText, this, spinner3, string, allLanguages, spinner, spinner2, appCompatDialog, view);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TranslateTextAction.Z(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.text = magicText[0];
            return;
        }
        int length = magicText.length;
        SystemLog.logError("Invalid magic text array size: " + length);
    }

    public final void setTranslationHelper(@NotNull TranslationActionHelper translationActionHelper) {
        Intrinsics.checkNotNullParameter(translationActionHelper, "<set-?>");
        this.translationHelper = translationActionHelper;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(@Nullable String str) {
        this.variableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.text);
        out.writeString(this.variableName);
        out.writeParcelable(this.dictionaryKeys, i4);
        out.writeString(this.sourceLanguageCode);
        out.writeString(this.outputLanguageCode);
    }

    public TranslateTextAction() {
        this.text = "";
        init();
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable final TriggerContextInfo triggerContextInfo, final int i4, final boolean z3, @NotNull final Stack<Integer> skipEndifIndexStack, @Nullable final ResumeMacroInfo resumeMacroInfo, boolean z4) {
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        MacroDroidVariable variableByName = getVariableByName(this.variableName);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<String> applyMagicTextToDictionaryKeys = VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro());
        if (variableByName == null) {
            String str = this.variableName;
            SystemLog.logError("Could not get string variable: " + str);
            return;
        }
        String g4 = g(this.text, triggerContextInfo);
        if (this.outputLanguageCode == null) {
            SystemLog.logError("Text could not be translated: Output language is note set");
        } else if (this.sourceLanguageCode == null) {
            SystemLog.logError("Text could not be translated: Source language is note set");
        } else {
            TranslatorOptions.Builder builder = new TranslatorOptions.Builder();
            String str2 = this.sourceLanguageCode;
            Intrinsics.checkNotNull(str2);
            TranslatorOptions.Builder sourceLanguage = builder.setSourceLanguage(str2);
            String str3 = this.outputLanguageCode;
            Intrinsics.checkNotNull(str3);
            TranslatorOptions build = sourceLanguage.setTargetLanguage(str3).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            Translator client = Translation.getClient(build);
            Intrinsics.checkNotNullExpressionValue(client, "getClient(options)");
            Task<String> translate = client.translate(g4);
            final g gVar = new g(variableByName, applyMagicTextToDictionaryKeys, i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
            translate.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.action.er
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    TranslateTextAction.e0(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.action.fr
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TranslateTextAction.f0(TranslateTextAction.this, i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo, exc);
                }
            });
        }
    }

    public TranslateTextAction(@Nullable Activity activity, @Nullable Macro macro) {
        this.text = "";
        init();
        setActivity(activity);
        this.m_macro = macro;
    }

    private TranslateTextAction(Parcel parcel) {
        super(parcel);
        List emptyList;
        this.text = "";
        init();
        String readString = parcel.readString();
        this.text = readString != null ? readString : "";
        this.variableName = parcel.readString();
        DictionaryKeys dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        if (dictionaryKeys == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            dictionaryKeys = new DictionaryKeys(emptyList);
        }
        this.dictionaryKeys = dictionaryKeys;
        this.sourceLanguageCode = parcel.readString();
        this.outputLanguageCode = parcel.readString();
    }

    /* compiled from: TranslateTextAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
