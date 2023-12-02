package com.arlosoft.macrodroid.triggers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.RefreshEditMacroPageEvent;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.HasVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Defaults;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.WebHookTrigger;
import com.arlosoft.macrodroid.triggers.info.WebHookTriggerInfo;
import com.arlosoft.macrodroid.triggers.webhook.WhiteListAdapter;
import com.arlosoft.macrodroid.triggers.webtrigger.WebTriggerInteractor;
import com.arlosoft.macrodroid.triggers.webtrigger.api.TinyUrlApi;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebHookTrigger.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 4 ContextUtils.kt\norg/jetbrains/anko/ContextUtilsKt\n*L\n1#1,905:1\n262#2,2:906\n262#2,2:908\n262#2,2:910\n262#2,2:912\n262#2,2:914\n262#2,2:916\n262#2,2:918\n65#3,16:920\n93#3,3:936\n65#3,16:939\n93#3,3:955\n65#3,16:959\n93#3,3:975\n78#4:958\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger\n*L\n300#1:906,2\n302#1:908,2\n303#1:910,2\n304#1:912,2\n469#1:914,2\n488#1:916,2\n489#1:918,2\n582#1:920,16\n582#1:936,3\n585#1:939,16\n585#1:955,3\n699#1:959,16\n699#1:975,3\n697#1:958\n*E\n"})
/* loaded from: classes3.dex */
public final class WebHookTrigger extends Trigger implements SupportsMagicText, HasVariableName {
    private static int triggerCounter;
    @NotNull
    private String identifier;
    @NotNull
    private ArrayList<String> ipAddressWhiteList;
    @Nullable
    private transient MaterialDialog progressDialog;
    @Nullable
    private DictionaryKeys saveBodyDictionaryKeys;
    @Nullable
    private String saveBodyVariableName;
    @Inject
    public transient TinyUrlApi tinyUrlApi;
    @Nullable
    private transient Disposable tokenUpdloadDisposable;
    @Inject
    public transient WebTriggerInteractor webTriggerInteractor;
    @Nullable
    private transient DictionaryKeys workingSaveBodyDictionaryKeys;
    @Nullable
    private transient String workingSaveBodyVariableName;
    @NotNull
    private transient ArrayList<String> workingWhiteList;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<WebHookTrigger> CREATOR = new Parcelable.Creator<WebHookTrigger>() { // from class: com.arlosoft.macrodroid.triggers.WebHookTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WebHookTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WebHookTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WebHookTrigger[] newArray(int i4) {
            return new WebHookTrigger[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Disposable, Unit> {
        a() {
            super(1);
        }

        public final void a(Disposable disposable) {
            WebHookTrigger webHookTrigger = WebHookTrigger.this;
            String string = webHookTrigger.getContext().getString(R.string.generate_tiny_url);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.generate_tiny_url)");
            webHookTrigger.o1(string);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
            a(disposable);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ Function1<Boolean, Unit> $completeHander;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            super(1);
            this.$completeHander = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Long macroGuid = WebHookTrigger.this.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Generate new device id failed: " + th, macroGuid.longValue());
            this.$completeHander.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ Function1<Boolean, Unit> $completeHander;
        final /* synthetic */ WebHookTrigger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Boolean, Unit> function1, WebHookTrigger webHookTrigger) {
            super(1);
            this.$completeHander = function1;
            this.this$0 = webHookTrigger;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.$completeHander.invoke(Boolean.FALSE);
            Long macroGuid = this.this$0.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Webhook device id import failed: " + th, macroGuid.longValue());
        }
    }

    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WebHookTrigger.this.h1();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $urlLinkText;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function0<Unit> {
            final /* synthetic */ TextView $urlLinkText;
            final /* synthetic */ WebHookTrigger this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TextView textView, WebHookTrigger webHookTrigger) {
                super(0);
                this.$urlLinkText = textView;
                this.this$0 = webHookTrigger;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextView textView = this.$urlLinkText;
                if (textView == null) {
                    return;
                }
                String uniqueId = Settings.getUniqueId(this.this$0.getContext(), false);
                String str = this.this$0.identifier;
                textView.setText("https://trigger.macrodroid.com/" + uniqueId + RemoteSettings.FORWARD_SLASH_STRING + str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(TextView textView, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$urlLinkText = textView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$urlLinkText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WebHookTrigger webHookTrigger = WebHookTrigger.this;
                webHookTrigger.m1(new a(this.$urlLinkText, webHookTrigger));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $urlLinkText;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function0<Unit> {
            final /* synthetic */ TextView $urlLinkText;
            final /* synthetic */ WebHookTrigger this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TextView textView, WebHookTrigger webHookTrigger) {
                super(0);
                this.$urlLinkText = textView;
                this.this$0 = webHookTrigger;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextView textView = this.$urlLinkText;
                if (textView == null) {
                    return;
                }
                String uniqueId = Settings.getUniqueId(this.this$0.getContext(), false);
                String str = this.this$0.identifier;
                textView.setText("https://trigger.macrodroid.com/" + uniqueId + RemoteSettings.FORWARD_SLASH_STRING + str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(TextView textView, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$urlLinkText = textView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$urlLinkText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WebHookTrigger webHookTrigger = WebHookTrigger.this;
                webHookTrigger.k1(new a(this.$urlLinkText, webHookTrigger));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    static final class g extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ TextView $tinyUrlLinkText;
        final /* synthetic */ TextView $urlLinkText;
        final /* synthetic */ WebHookTrigger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(TextView textView, WebHookTrigger webHookTrigger, TextView textView2) {
            super(1);
            this.$urlLinkText = textView;
            this.this$0 = webHookTrigger;
            this.$tinyUrlLinkText = textView2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            TextView textView = this.$urlLinkText;
            if (textView != null) {
                String uniqueId = Settings.getUniqueId(this.this$0.getContext(), false);
                textView.setText("https://trigger.macrodroid.com/" + uniqueId + RemoteSettings.FORWARD_SLASH_STRING + it);
            }
            TextView textView2 = this.$tinyUrlLinkText;
            if (textView2 == null) {
                return;
            }
            String tinyUrl = Settings.getTinyUrl(this.this$0.getContext());
            textView2.setText(tinyUrl + RemoteSettings.FORWARD_SLASH_STRING + it);
        }
    }

    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $whiteListEntriesText;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function0<Unit> {
            final /* synthetic */ TextView $whiteListEntriesText;
            final /* synthetic */ WebHookTrigger this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TextView textView, WebHookTrigger webHookTrigger) {
                super(0);
                this.$whiteListEntriesText = textView;
                this.this$0 = webHookTrigger;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextView textView = this.$whiteListEntriesText;
                WebHookTrigger webHookTrigger = this.this$0;
                textView.setText(webHookTrigger.A0(webHookTrigger.workingWhiteList));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(TextView textView, Continuation<? super h> continuation) {
            super(3, continuation);
            this.$whiteListEntriesText = textView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(this.$whiteListEntriesText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WebHookTrigger webHookTrigger = WebHookTrigger.this;
                webHookTrigger.f1(webHookTrigger.workingWhiteList, new a(this.$whiteListEntriesText, WebHookTrigger.this));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$handleItemSelected$6$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n262#2,2:908\n262#2,2:910\n262#2,2:912\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$handleItemSelected$6$1\n*L\n345#1:906,2\n346#1:908,2\n347#1:910,2\n348#1:912,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class i extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ Button $tinyUrlButton;
        final /* synthetic */ TextView $tinyUrlLinkText;
        final /* synthetic */ ImageView $urlCopyButtonTinyUrl;
        final /* synthetic */ ImageView $urlShareTinyUrlApi;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(TextView textView, ImageView imageView, ImageView imageView2, Button button) {
            super(1);
            this.$tinyUrlLinkText = textView;
            this.$urlCopyButtonTinyUrl = imageView;
            this.$urlShareTinyUrlApi = imageView2;
            this.$tinyUrlButton = button;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            ToastCompat.makeText(WebHookTrigger.this.getContext().getApplicationContext(), (CharSequence) str, 0).show();
            Settings.setTinyUrl(WebHookTrigger.this.getContext(), str);
            TextView textView = this.$tinyUrlLinkText;
            if (textView != null) {
                String str2 = WebHookTrigger.this.identifier;
                textView.setText(str + RemoteSettings.FORWARD_SLASH_STRING + str2);
            }
            ImageView imageView = this.$urlCopyButtonTinyUrl;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.$urlShareTinyUrlApi;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            TextView textView2 = this.$tinyUrlLinkText;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            this.$tinyUrlButton.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class j extends Lambda implements Function1<Throwable, Unit> {
        j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ToastCompat.makeText(WebHookTrigger.this.getContext().getApplicationContext(), (int) R.string.could_not_connect_to_server, 0).show();
        }
    }

    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ NDSpinner $saveBodyVariableSpinner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(NDSpinner nDSpinner, Continuation<? super k> continuation) {
            super(3, continuation);
            this.$saveBodyVariableSpinner = nDSpinner;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(NDSpinner nDSpinner, WebHookTrigger webHookTrigger, MacroDroidVariable macroDroidVariable) {
            nDSpinner.setEnabled(true);
            nDSpinner.setAlpha(1.0f);
            webHookTrigger.workingSaveBodyVariableName = macroDroidVariable.getName();
            webHookTrigger.workingSaveBodyDictionaryKeys = null;
            webHookTrigger.w0(nDSpinner);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(this.$saveBodyVariableSpinner, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Activity activity = WebHookTrigger.this.getActivity();
                final NDSpinner nDSpinner = this.$saveBodyVariableSpinner;
                final WebHookTrigger webHookTrigger = WebHookTrigger.this;
                VariablesHelper.createNewVariable(activity, nDSpinner, webHookTrigger, (int) R.style.Theme_App_Dialog_Action, 2, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.triggers.jb
                    @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                    public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                        WebHookTrigger.k.c(NDSpinner.this, webHookTrigger, macroDroidVariable);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class l extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ Function1<Boolean, Unit> $completeHander;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        l(Function1<? super Boolean, Unit> function1) {
            super(1);
            this.$completeHander = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Long macroGuid = WebHookTrigger.this.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Export webhook failed: " + th, macroGuid.longValue());
            this.$completeHander.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showEditWhiteListDialog$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n262#2,2:908\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showEditWhiteListDialog$1\n*L\n476#1:906,2\n477#1:908,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class m extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ ViewGroup $emptyState;
        final /* synthetic */ List<String> $listOfWhiteLists;
        final /* synthetic */ Ref.ObjectRef<WhiteListAdapter> $whiteListAdapter;
        final /* synthetic */ RecyclerView $whiteListList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Ref.ObjectRef<WhiteListAdapter> objectRef, ViewGroup viewGroup, List<String> list, RecyclerView recyclerView) {
            super(1);
            this.$whiteListAdapter = objectRef;
            this.$emptyState = viewGroup;
            this.$listOfWhiteLists = list;
            this.$whiteListList = recyclerView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            WebHookTrigger.this.workingWhiteList.remove(it);
            WhiteListAdapter whiteListAdapter = this.$whiteListAdapter.element;
            Intrinsics.checkNotNull(whiteListAdapter);
            whiteListAdapter.setItems(WebHookTrigger.this.workingWhiteList);
            this.$emptyState.setVisibility(this.$listOfWhiteLists.isEmpty() ? 0 : 8);
            this.$whiteListList.setVisibility(this.$listOfWhiteLists.isEmpty() ^ true ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class n extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ ViewGroup $emptyState;
        final /* synthetic */ List<String> $listOfWhiteLists;
        final /* synthetic */ Ref.ObjectRef<WhiteListAdapter> $whiteListAdapter;
        final /* synthetic */ RecyclerView $whiteListList;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<String, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f14465d = new a();

            a() {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showEditWhiteListDialog$2$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n262#2,2:908\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showEditWhiteListDialog$2$2\n*L\n482#1:906,2\n483#1:908,2\n*E\n"})
        /* loaded from: classes3.dex */
        public static final class b extends Lambda implements Function1<String, Unit> {
            final /* synthetic */ ViewGroup $emptyState;
            final /* synthetic */ List<String> $listOfWhiteLists;
            final /* synthetic */ String $oldValue;
            final /* synthetic */ Ref.ObjectRef<WhiteListAdapter> $whiteListAdapter;
            final /* synthetic */ RecyclerView $whiteListList;
            final /* synthetic */ WebHookTrigger this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(WebHookTrigger webHookTrigger, String str, Ref.ObjectRef<WhiteListAdapter> objectRef, ViewGroup viewGroup, List<String> list, RecyclerView recyclerView) {
                super(1);
                this.this$0 = webHookTrigger;
                this.$oldValue = str;
                this.$whiteListAdapter = objectRef;
                this.$emptyState = viewGroup;
                this.$listOfWhiteLists = list;
                this.$whiteListList = recyclerView;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.workingWhiteList.set(this.this$0.workingWhiteList.indexOf(this.$oldValue), it);
                WhiteListAdapter whiteListAdapter = this.$whiteListAdapter.element;
                Intrinsics.checkNotNull(whiteListAdapter);
                whiteListAdapter.setItems(this.this$0.workingWhiteList);
                this.$emptyState.setVisibility(this.$listOfWhiteLists.isEmpty() ? 0 : 8);
                this.$whiteListList.setVisibility(this.$listOfWhiteLists.isEmpty() ^ true ? 0 : 8);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(Ref.ObjectRef<WhiteListAdapter> objectRef, ViewGroup viewGroup, List<String> list, RecyclerView recyclerView) {
            super(1);
            this.$whiteListAdapter = objectRef;
            this.$emptyState = viewGroup;
            this.$listOfWhiteLists = list;
            this.$whiteListList = recyclerView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String oldValue) {
            Intrinsics.checkNotNullParameter(oldValue, "oldValue");
            WebHookTrigger webHookTrigger = WebHookTrigger.this;
            webHookTrigger.a1(oldValue, a.f14465d, new b(webHookTrigger, oldValue, this.$whiteListAdapter, this.$emptyState, this.$listOfWhiteLists, this.$whiteListList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class o extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $emptyState;
        final /* synthetic */ List<String> $listOfWhiteLists;
        final /* synthetic */ Ref.ObjectRef<WhiteListAdapter> $whiteListAdapter;
        final /* synthetic */ RecyclerView $whiteListList;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<String, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f14466d = new a();

            a() {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showEditWhiteListDialog$3$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n262#2,2:908\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showEditWhiteListDialog$3$2\n*L\n495#1:906,2\n496#1:908,2\n*E\n"})
        /* loaded from: classes3.dex */
        public static final class b extends Lambda implements Function1<String, Unit> {
            final /* synthetic */ ViewGroup $emptyState;
            final /* synthetic */ List<String> $listOfWhiteLists;
            final /* synthetic */ Ref.ObjectRef<WhiteListAdapter> $whiteListAdapter;
            final /* synthetic */ RecyclerView $whiteListList;
            final /* synthetic */ WebHookTrigger this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(WebHookTrigger webHookTrigger, Ref.ObjectRef<WhiteListAdapter> objectRef, ViewGroup viewGroup, List<String> list, RecyclerView recyclerView) {
                super(1);
                this.this$0 = webHookTrigger;
                this.$whiteListAdapter = objectRef;
                this.$emptyState = viewGroup;
                this.$listOfWhiteLists = list;
                this.$whiteListList = recyclerView;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.workingWhiteList.add(it);
                this.$whiteListAdapter.element.setItems(this.this$0.workingWhiteList);
                this.$emptyState.setVisibility(this.$listOfWhiteLists.isEmpty() ? 0 : 8);
                this.$whiteListList.setVisibility(this.$listOfWhiteLists.isEmpty() ^ true ? 0 : 8);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(Ref.ObjectRef<WhiteListAdapter> objectRef, ViewGroup viewGroup, List<String> list, RecyclerView recyclerView, Continuation<? super o> continuation) {
            super(3, continuation);
            this.$whiteListAdapter = objectRef;
            this.$emptyState = viewGroup;
            this.$listOfWhiteLists = list;
            this.$whiteListList = recyclerView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new o(this.$whiteListAdapter, this.$emptyState, this.$listOfWhiteLists, this.$whiteListList, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WebHookTrigger webHookTrigger = WebHookTrigger.this;
                webHookTrigger.a1(null, a.f14466d, new b(webHookTrigger, this.$whiteListAdapter, this.$emptyState, this.$listOfWhiteLists, this.$whiteListList));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class p extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(AppCompatDialog appCompatDialog, Continuation<? super p> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new p(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class q extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(AppCompatDialog appCompatDialog, Continuation<? super q> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new q(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showExportDeviceIdDialog$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showExportDeviceIdDialog$2\n*L\n704#1:906,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class r extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $deviceIdValue;
        final /* synthetic */ Button $exportButton;
        final /* synthetic */ EditText $password;
        final /* synthetic */ TextView $passwordValue;
        final /* synthetic */ ProgressBar $progressIndicator;
        final /* synthetic */ ImageView $shareDeviceIdButton;
        final /* synthetic */ ViewFlipper $viewFlipper;
        int label;
        final /* synthetic */ WebHookTrigger this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showExportDeviceIdDialog$2$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showExportDeviceIdDialog$2$1\n*L\n723#1:906,2\n*E\n"})
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Boolean, Unit> {
            final /* synthetic */ TextView $deviceIdValue;
            final /* synthetic */ Button $exportButton;
            final /* synthetic */ EditText $password;
            final /* synthetic */ TextView $passwordValue;
            final /* synthetic */ ProgressBar $progressIndicator;
            final /* synthetic */ ImageView $shareDeviceIdButton;
            final /* synthetic */ ViewFlipper $viewFlipper;
            final /* synthetic */ WebHookTrigger this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: WebHookTrigger.kt */
            /* renamed from: com.arlosoft.macrodroid.triggers.WebHookTrigger$r$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0127a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
                final /* synthetic */ TextView $deviceIdValue;
                int label;
                final /* synthetic */ WebHookTrigger this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0127a(TextView textView, WebHookTrigger webHookTrigger, Continuation<? super C0127a> continuation) {
                    super(3, continuation);
                    this.$deviceIdValue = textView;
                    this.this$0 = webHookTrigger;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                /* renamed from: a */
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                    return new C0127a(this.$deviceIdValue, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.TEXT", this.$deviceIdValue.getText());
                        intent.setType("text/plain");
                        this.this$0.getActivity().startActivity(Intent.createChooser(intent, null));
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ViewFlipper viewFlipper, TextView textView, WebHookTrigger webHookTrigger, TextView textView2, EditText editText, ImageView imageView, Button button, ProgressBar progressBar) {
                super(1);
                this.$viewFlipper = viewFlipper;
                this.$deviceIdValue = textView;
                this.this$0 = webHookTrigger;
                this.$passwordValue = textView2;
                this.$password = editText;
                this.$shareDeviceIdButton = imageView;
                this.$exportButton = button;
                this.$progressIndicator = progressBar;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z3) {
                if (z3) {
                    this.$viewFlipper.setDisplayedChild(1);
                    this.$deviceIdValue.setText(Settings.getUniqueId(this.this$0.getContext(), false));
                    this.$passwordValue.setText(this.$password.getText().toString());
                    ViewExtensionsKt.onClick$default(this.$shareDeviceIdButton, null, new C0127a(this.$deviceIdValue, this.this$0, null), 1, null);
                    return;
                }
                this.$exportButton.setEnabled(true);
                this.$progressIndicator.setVisibility(0);
                ToastCompat.makeText(this.this$0.getContext(), (int) R.string.webhook_device_id_export_failed_message, 0).show();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(ProgressBar progressBar, Button button, WebHookTrigger webHookTrigger, EditText editText, ViewFlipper viewFlipper, TextView textView, TextView textView2, ImageView imageView, Continuation<? super r> continuation) {
            super(3, continuation);
            this.$progressIndicator = progressBar;
            this.$exportButton = button;
            this.this$0 = webHookTrigger;
            this.$password = editText;
            this.$viewFlipper = viewFlipper;
            this.$deviceIdValue = textView;
            this.$passwordValue = textView2;
            this.$shareDeviceIdButton = imageView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new r(this.$progressIndicator, this.$exportButton, this.this$0, this.$password, this.$viewFlipper, this.$deviceIdValue, this.$passwordValue, this.$shareDeviceIdButton, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$progressIndicator.setVisibility(0);
                this.$exportButton.setEnabled(false);
                this.this$0.W0(this.$password.getText().toString(), new a(this.$viewFlipper, this.$deviceIdValue, this.this$0, this.$passwordValue, this.$password, this.$shareDeviceIdButton, this.$exportButton, this.$progressIndicator));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class s extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Button $exportButton;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(Button button, Continuation<? super s> continuation) {
            super(4, continuation);
            this.$exportButton = button;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            s sVar = new s(this.$exportButton, continuation);
            sVar.Z$0 = z3;
            return sVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$exportButton.setEnabled(this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showGenerateNewDeviceIdDialog$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showGenerateNewDeviceIdDialog$2\n*L\n658#1:906,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class t extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ Button $exportButton;
        final /* synthetic */ ProgressBar $progressIndicator;
        final /* synthetic */ Function0<Unit> $updatedIdHandler;
        int label;
        final /* synthetic */ WebHookTrigger this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showGenerateNewDeviceIdDialog$2$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showGenerateNewDeviceIdDialog$2$1\n*L\n667#1:906,2\n*E\n"})
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Boolean, Unit> {
            final /* synthetic */ AppCompatDialog $dialog;
            final /* synthetic */ Button $exportButton;
            final /* synthetic */ ProgressBar $progressIndicator;
            final /* synthetic */ Function0<Unit> $updatedIdHandler;
            final /* synthetic */ WebHookTrigger this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Function0<Unit> function0, WebHookTrigger webHookTrigger, AppCompatDialog appCompatDialog, ProgressBar progressBar, Button button) {
                super(1);
                this.$updatedIdHandler = function0;
                this.this$0 = webHookTrigger;
                this.$dialog = appCompatDialog;
                this.$progressIndicator = progressBar;
                this.$exportButton = button;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z3) {
                if (z3) {
                    this.$updatedIdHandler.invoke();
                    ToastCompat.makeText(this.this$0.getContext(), (int) R.string.webhook_new_device_id_was_generated, 1).show();
                    this.$dialog.dismiss();
                    return;
                }
                ToastCompat.makeText(this.this$0.getContext(), (int) R.string.webhook_new_device_id_generation_failed, 1).show();
                this.$progressIndicator.setVisibility(8);
                this.$exportButton.setEnabled(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(ProgressBar progressBar, Button button, WebHookTrigger webHookTrigger, Function0<Unit> function0, AppCompatDialog appCompatDialog, Continuation<? super t> continuation) {
            super(3, continuation);
            this.$progressIndicator = progressBar;
            this.$exportButton = button;
            this.this$0 = webHookTrigger;
            this.$updatedIdHandler = function0;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new t(this.$progressIndicator, this.$exportButton, this.this$0, this.$updatedIdHandler, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$progressIndicator.setVisibility(0);
                this.$exportButton.setEnabled(false);
                WebHookTrigger webHookTrigger = this.this$0;
                webHookTrigger.B0(new a(this.$updatedIdHandler, webHookTrigger, this.$dialog, this.$progressIndicator, this.$exportButton));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showImportDialog$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showImportDialog$3\n*L\n594#1:906,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class u extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ EditText $deviceId;
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ Button $importButton;
        final /* synthetic */ Function0<Unit> $importComplete;
        final /* synthetic */ ProgressBar $importingProgressIndicator;
        final /* synthetic */ EditText $password;
        int label;
        final /* synthetic */ WebHookTrigger this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebHookTrigger.kt */
        @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showImportDialog$3$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,905:1\n262#2,2:906\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$showImportDialog$3$1\n*L\n605#1:906,2\n*E\n"})
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Boolean, Unit> {
            final /* synthetic */ EditText $deviceId;
            final /* synthetic */ AppCompatDialog $dialog;
            final /* synthetic */ Button $importButton;
            final /* synthetic */ Function0<Unit> $importComplete;
            final /* synthetic */ ProgressBar $importingProgressIndicator;
            final /* synthetic */ WebHookTrigger this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(EditText editText, WebHookTrigger webHookTrigger, Function0<Unit> function0, AppCompatDialog appCompatDialog, Button button, ProgressBar progressBar) {
                super(1);
                this.$deviceId = editText;
                this.this$0 = webHookTrigger;
                this.$importComplete = function0;
                this.$dialog = appCompatDialog;
                this.$importButton = button;
                this.$importingProgressIndicator = progressBar;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z3) {
                if (z3) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String r4 = SelectableItem.r(R.string.webhook_device_id_ported_message);
                    Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.webho…device_id_ported_message)");
                    String format = String.format(r4, Arrays.copyOf(new Object[]{this.$deviceId.getText().toString()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    ToastCompat.makeText(this.this$0.getContext(), (CharSequence) format, 0).show();
                    this.$importComplete.invoke();
                    this.$dialog.dismiss();
                    return;
                }
                ToastCompat.makeText(this.this$0.getContext(), (int) R.string.webhook_device_id_import_failed_message, 0).show();
                this.$importButton.setEnabled(true);
                this.$importingProgressIndicator.setVisibility(8);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(Button button, ProgressBar progressBar, WebHookTrigger webHookTrigger, EditText editText, EditText editText2, Function0<Unit> function0, AppCompatDialog appCompatDialog, Continuation<? super u> continuation) {
            super(3, continuation);
            this.$importButton = button;
            this.$importingProgressIndicator = progressBar;
            this.this$0 = webHookTrigger;
            this.$deviceId = editText;
            this.$password = editText2;
            this.$importComplete = function0;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new u(this.$importButton, this.$importingProgressIndicator, this.this$0, this.$deviceId, this.$password, this.$importComplete, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$importButton.setEnabled(false);
                this.$importingProgressIndicator.setVisibility(0);
                this.this$0.G0(this.$deviceId.getText().toString(), this.$password.getText().toString(), new a(this.$deviceId, this.this$0, this.$importComplete, this.$dialog, this.$importButton, this.$importingProgressIndicator));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebHookTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class v extends Lambda implements Function1<Throwable, Unit> {
        v() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Long macroGuid = WebHookTrigger.this.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Push token upload failed, webhook trigger will not function: " + th, macroGuid.longValue());
            FirebaseCrashlytics.getInstance().recordException(th);
            Settings.setPushTokenUploadFailed(WebHookTrigger.this.getContext(), true);
            WebHookTrigger.this.Z0();
        }
    }

    public /* synthetic */ WebHookTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String A0(List<String> list) {
        List take;
        String joinToString$default;
        String joinToString$default2;
        if (this.workingWhiteList.isEmpty()) {
            String r4 = SelectableItem.r(R.string.variable_multi_entry_no_entries);
            Intrinsics.checkNotNullExpressionValue(r4, "{\n            getString(…try_no_entries)\n        }");
            return r4;
        } else if (this.workingWhiteList.size() <= 6) {
            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(this.workingWhiteList, ", ", null, null, 0, null, null, 62, null);
            return joinToString$default2;
        } else {
            take = CollectionsKt___CollectionsKt.take(this.workingWhiteList, 6);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(take, ", ", null, null, 0, null, null, 62, null);
            return joinToString$default + "...";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(final Function1<? super Boolean, Unit> function1) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.triggers.ca
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                WebHookTrigger.C0(WebHookTrigger.this, function1, task);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.triggers.da
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                WebHookTrigger.F0(Function1.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(final WebHookTrigger this$0, final Function1 completeHander, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(completeHander, "$completeHander");
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            if (task.isComplete()) {
                final String firebaseToken = (String) task.getResult();
                final String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                WebTriggerInteractor webTriggerInteractor = this$0.getWebTriggerInteractor();
                Intrinsics.checkNotNullExpressionValue(firebaseToken, "firebaseToken");
                Completable uploadTriggerTokenNoRetry = webTriggerInteractor.uploadTriggerTokenNoRetry(uuid, "", firebaseToken, Defaults.REGISTER_COMMERCIAL_DEVICE_COMPANY_ID);
                Action action = new Action() { // from class: com.arlosoft.macrodroid.triggers.sa
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        WebHookTrigger.D0(uuid, this$0, firebaseToken, completeHander);
                    }
                };
                final b bVar = new b(completeHander);
                this$0.tokenUpdloadDisposable = uploadTriggerTokenNoRetry.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.triggers.ta
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        WebHookTrigger.E0(Function1.this, obj);
                    }
                });
            } else {
                SystemLog.logError("No push token available, Web URL trigger will not currently work");
                completeHander.invoke(Boolean.FALSE);
            }
        } catch (Exception e4) {
            SystemLog.logError("Firebase token is not available: " + e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(String uid, WebHookTrigger this$0, String str, Function1 completeHander) {
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(completeHander, "$completeHander");
        Long macroGuid = this$0.getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logInfo("Generated new device id for webhook: " + uid + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, macroGuid.longValue());
        Settings.setUniqueId(this$0.getContext(), uid);
        Settings.setPushTokenUploadedId(this$0.getContext(), str);
        completeHander.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(Function1 completeHander, Exception it) {
        Intrinsics.checkNotNullParameter(completeHander, "$completeHander");
        Intrinsics.checkNotNullParameter(it, "it");
        SystemLog.logError("No push token available, Web URL trigger will not currently work");
        completeHander.invoke(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(final String str, final String str2, final Function1<? super Boolean, Unit> function1) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.triggers.na
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                WebHookTrigger.H0(WebHookTrigger.this, str, str2, function1, task);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.triggers.oa
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                WebHookTrigger.K0(Function1.this, this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(final WebHookTrigger this$0, final String deviceId, String password, final Function1 completeHander, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deviceId, "$deviceId");
        Intrinsics.checkNotNullParameter(password, "$password");
        Intrinsics.checkNotNullParameter(completeHander, "$completeHander");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isComplete()) {
            String firebaseToken = (String) task.getResult();
            WebTriggerInteractor webTriggerInteractor = this$0.getWebTriggerInteractor();
            String sha256 = StringExtensionsKt.sha256(password);
            Intrinsics.checkNotNullExpressionValue(firebaseToken, "firebaseToken");
            Completable updateDeviceIdToken = webTriggerInteractor.updateDeviceIdToken(deviceId, sha256, firebaseToken);
            Action action = new Action() { // from class: com.arlosoft.macrodroid.triggers.xa
                @Override // io.reactivex.functions.Action
                public final void run() {
                    WebHookTrigger.I0(WebHookTrigger.this, deviceId, completeHander);
                }
            };
            final c cVar = new c(completeHander, this$0);
            this$0.tokenUpdloadDisposable = updateDeviceIdToken.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.triggers.ya
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WebHookTrigger.J0(Function1.this, obj);
                }
            });
            return;
        }
        completeHander.invoke(Boolean.FALSE);
        Long macroGuid = this$0.getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("Webhook device id import failed: No push token available on this device.", macroGuid.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(WebHookTrigger this$0, String deviceId, Function1 completeHander) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deviceId, "$deviceId");
        Intrinsics.checkNotNullParameter(completeHander, "$completeHander");
        Settings.setUniqueId(this$0.getContext(), deviceId);
        Long macroGuid = this$0.getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logInfo("Webhook device id (" + deviceId + ") ported to this devivce.", macroGuid.longValue());
        completeHander.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(Function1 completeHander, WebHookTrigger this$0, Exception it) {
        Intrinsics.checkNotNullParameter(completeHander, "$completeHander");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        completeHander.invoke(Boolean.FALSE);
        Long macroGuid = this$0.getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("Webhook device id import failed: No push token available on this device.", macroGuid.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(WebHookTrigger this$0, TextView textView, ImageView imageView, ImageView imageView2, Button button, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String uniqueId = Settings.getUniqueId(this$0.getContext(), false);
        Single<String> x02 = this$0.x0("https://trigger.macrodroid.com/" + uniqueId);
        final i iVar = new i(textView, imageView, imageView2, button);
        Consumer<? super String> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.triggers.ua
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WebHookTrigger.N0(Function1.this, obj);
            }
        };
        final j jVar = new j();
        x02.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.triggers.wa
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WebHookTrigger.O0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(WebHookTrigger this$0, TextView textView, View view) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        clipboardManager.setText(String.valueOf(charSequence));
        Context applicationContext = this$0.getContext().getApplicationContext();
        String string = this$0.getContext().getString(R.string.copied_to_clipboard);
        CharSequence text = clipboardManager.getText();
        ToastCompat.makeText(applicationContext, (CharSequence) (string + "\n\n" + ((Object) text)), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(WebHookTrigger this$0, TextView textView, View view) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        clipboardManager.setText(String.valueOf(charSequence));
        Context applicationContext = this$0.getContext().getApplicationContext();
        String string = this$0.getContext().getString(R.string.copied_to_clipboard);
        CharSequence text = clipboardManager.getText();
        ToastCompat.makeText(applicationContext, (CharSequence) (string + "\n\n" + ((Object) text)), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(TextView textView, WebHookTrigger this$0, View view) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", SelectableItem.r(R.string.trigger_web_hook));
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        intent.putExtra("android.intent.extra.TEXT", String.valueOf(charSequence));
        Intent createChooser = Intent.createChooser(intent, this$0.getContext().getResources().getString(R.string.share_web_link));
        createChooser.addFlags(268435456);
        this$0.getContext().startActivity(createChooser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(TextView textView, WebHookTrigger this$0, View view) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", SelectableItem.r(R.string.trigger_web_hook));
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        intent.putExtra("android.intent.extra.TEXT", String.valueOf(charSequence));
        Intent createChooser = Intent.createChooser(intent, this$0.getContext().getResources().getString(R.string.share_web_link));
        createChooser.addFlags(268435456);
        this$0.getContext().startActivity(createChooser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(EditText identifierText, MagicText.MagicTextPair pair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(identifierText, "$identifierText");
        Intrinsics.checkNotNullParameter(pair, "pair");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(identifierText.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(identifierText.getSelectionEnd(), 0);
        Editable text = identifierText.getText();
        coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
        coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
        String str = pair.magicText;
        text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(WebHookTrigger this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), magicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(EditText identifierText, TextView textView, WebHookTrigger this$0, AppCompatDialog dialog, View view) {
        CharSequence charSequence;
        boolean z3;
        Intrinsics.checkNotNullParameter(identifierText, "$identifierText");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        String valueOf = String.valueOf(identifierText.getText());
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        String valueOf2 = String.valueOf(charSequence);
        this$0.saveBodyVariableName = this$0.workingSaveBodyVariableName;
        this$0.saveBodyDictionaryKeys = this$0.workingSaveBodyDictionaryKeys;
        if (valueOf.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && this$0.v0(valueOf2)) {
            this$0.identifier = valueOf;
            dialog.dismiss();
            this$0.itemComplete();
            return;
        }
        ToastCompat.makeText(this$0.getContext(), (int) R.string.invalid_value, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(String str, final Function1<? super Boolean, Unit> function1) {
        final String deviceId = Settings.getUniqueId(getContext(), false);
        WebTriggerInteractor webTriggerInteractor = getWebTriggerInteractor();
        Intrinsics.checkNotNullExpressionValue(deviceId, "deviceId");
        Completable exportToken = webTriggerInteractor.exportToken(deviceId, StringExtensionsKt.sha256(str));
        Action action = new Action() { // from class: com.arlosoft.macrodroid.triggers.fa
            @Override // io.reactivex.functions.Action
            public final void run() {
                WebHookTrigger.X0(WebHookTrigger.this, deviceId, function1);
            }
        };
        final l lVar = new l(function1);
        this.tokenUpdloadDisposable = exportToken.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.triggers.ga
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WebHookTrigger.Y0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(WebHookTrigger this$0, String str, Function1 completeHander) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(completeHander, "$completeHander");
        Settings.setUniqueId(this$0.getContext(), str);
        completeHander.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0() {
        EventBusUtils.getEventBus().post(new RefreshEditMacroPageEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(String str, Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12) {
        boolean z3;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_enter_ip_address);
        appCompatDialog.setTitle(R.string.constraint_ip_address);
        View findViewById = appCompatDialog.findViewById(R.id.text);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.magic_text_button);
        Intrinsics.checkNotNull(findViewById2);
        Button button = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById3);
        final Button button2 = (Button) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById4);
        Button button3 = (Button) findViewById4;
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.ia
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                WebHookTrigger.b1(editText, magicTextPair);
            }
        };
        if (str != null) {
            editText.setText(str);
        }
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        button2.setEnabled(!z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.ja
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebHookTrigger.c1(Function1.this, editText, this, appCompatDialog, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.la
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebHookTrigger.d1(AppCompatDialog.this, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.ma
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebHookTrigger.e1(WebHookTrigger.this, magicTextListener, view);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.triggers.WebHookTrigger$showAddIpAddressDialog$5
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                boolean z4;
                Intrinsics.checkNotNullParameter(s3, "s");
                Button button4 = button2;
                if (editText.getText().length() > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                button4.setEnabled(z4);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(EditText text, MagicText.MagicTextPair pair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(text, "$text");
        Intrinsics.checkNotNullParameter(pair, "pair");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(text.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(text.getSelectionEnd(), 0);
        Editable text2 = text.getText();
        coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
        coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
        String str = pair.magicText;
        text2.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(Function1 entryAdded, EditText text, WebHookTrigger this$0, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(entryAdded, "$entryAdded");
        Intrinsics.checkNotNullParameter(text, "$text");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        entryAdded.invoke(text.getText().toString());
        this$0.itemComplete();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(WebHookTrigger this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), magicTextListener, this$0.getMacro(), false, true, false, R.style.Theme_App_Dialog_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.arlosoft.macrodroid.triggers.webhook.WhiteListAdapter, T] */
    public final void f1(List<String> list, final Function0<Unit> function0) {
        WindowManager.LayoutParams layoutParams;
        List mutableList;
        int i4;
        int i5;
        AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.Theme_App_Dialog_Trigger_NoTitle);
        appCompatDialog.setContentView(R.layout.dialog_ip_address_whitelist);
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
        View findViewById = appCompatDialog.findViewById(R.id.emptyStateContainer);
        Intrinsics.checkNotNull(findViewById);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.recyclerView);
        Intrinsics.checkNotNull(findViewById2);
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.addIpAddressButton);
        Intrinsics.checkNotNull(findViewById3);
        ImageView imageView = (ImageView) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById4);
        Button button = (Button) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById5);
        Button button2 = (Button) findViewById5;
        button.setVisibility(8);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        ?? whiteListAdapter = new WhiteListAdapter(mutableList, new m(objectRef, viewGroup, list, recyclerView), new n(objectRef, viewGroup, list, recyclerView));
        objectRef.element = whiteListAdapter;
        recyclerView.setAdapter((RecyclerView.Adapter) whiteListAdapter);
        if (list.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        if (!list.isEmpty()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        recyclerView.setVisibility(i5);
        ViewExtensionsKt.onClick$default(imageView, null, new o(objectRef, viewGroup, list, recyclerView, null), 1, null);
        ViewExtensionsKt.onClick$default(button2, null, new p(appCompatDialog, null), 1, null);
        appCompatDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.arlosoft.macrodroid.triggers.ha
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                WebHookTrigger.g1(WebHookTrigger.this, function0, dialogInterface);
            }
        });
        ViewExtensionsKt.onClick$default(button, null, new q(appCompatDialog, null), 1, null);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(WebHookTrigger this$0, Function0 dialogClosed, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogClosed, "$dialogClosed");
        this$0.ipAddressWhiteList = this$0.workingWhiteList;
        dialogClosed.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1() {
        WindowManager.LayoutParams layoutParams;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_webhook_export_deviceid);
        appCompatDialog.setTitle(R.string.webhook_export_device_id_title);
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
        View findViewById = appCompatDialog.findViewById(R.id.password);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.exportButton);
        Intrinsics.checkNotNull(findViewById2);
        final Button button = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById3);
        View findViewById4 = appCompatDialog.findViewById(R.id.exportingProgressIndicator);
        Intrinsics.checkNotNull(findViewById4);
        ProgressBar progressBar = (ProgressBar) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.viewFlipper);
        Intrinsics.checkNotNull(findViewById5);
        ViewFlipper viewFlipper = (ViewFlipper) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.deviceIdValue);
        Intrinsics.checkNotNull(findViewById6);
        TextView textView = (TextView) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.passwordValue);
        Intrinsics.checkNotNull(findViewById7);
        TextView textView2 = (TextView) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.dismissButton);
        Intrinsics.checkNotNull(findViewById8);
        Button button2 = (Button) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.shareDeviceIdButton);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "findViewById(id)");
        Intrinsics.checkNotNull(findViewById9);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.triggers.WebHookTrigger$showExportDeviceIdDialog$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                boolean z3;
                Button button3 = button;
                if (editText.length() >= 5) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                button3.setEnabled(z3);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        button.setEnabled(false);
        ViewExtensionsKt.onClick$default(button, null, new r(progressBar, button, this, editText, viewFlipper, textView, textView2, (ImageView) findViewById9, null), 1, null);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.z9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebHookTrigger.i1(AppCompatDialog.this, view);
            }
        });
        ((Button) findViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.ka
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebHookTrigger.j1(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(Function0<Unit> function0) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_webhook_generate_new_deviceid);
        appCompatDialog.setTitle(R.string.webhook_trigger_generate_new_device_id);
        View findViewById = appCompatDialog.findViewById(R.id.generateNewIdButton);
        Intrinsics.checkNotNull(findViewById);
        Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.generatingProgressIndicator);
        Intrinsics.checkNotNull(findViewById3);
        ProgressBar progressBar = (ProgressBar) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.understoodCheckBox);
        Intrinsics.checkNotNull(findViewById4);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default((CheckBox) findViewById4, (CoroutineContext) null, new s(button, null), 1, (Object) null);
        button.setEnabled(false);
        ViewExtensionsKt.onClick$default(button, null, new t(progressBar, button, this, function0, appCompatDialog, null), 1, null);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.pa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebHookTrigger.l1(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(Function0<Unit> function0) {
        WindowManager.LayoutParams layoutParams;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_webhook_import_deviceid);
        appCompatDialog.setTitle(R.string.webhook_import_device_id_title);
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
        View findViewById = appCompatDialog.findViewById(R.id.deviceId);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.password);
        Intrinsics.checkNotNull(findViewById2);
        final EditText editText2 = (EditText) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById3);
        Button button = (Button) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.importButton);
        Intrinsics.checkNotNull(findViewById4);
        final Button button2 = (Button) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.importingProgressIndicator);
        Intrinsics.checkNotNull(findViewById5);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.triggers.WebHookTrigger$showImportDialog$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                boolean z3;
                Button button3 = button2;
                if (editText.length() > 0 && editText2.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                button3.setEnabled(z3);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.triggers.WebHookTrigger$showImportDialog$$inlined$addTextChangedListener$default$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                boolean z3;
                Button button3 = button2;
                if (editText.length() > 0 && editText2.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                button3.setEnabled(z3);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        button2.setEnabled(false);
        ViewExtensionsKt.onClick$default(button2, null, new u(button2, (ProgressBar) findViewById5, this, editText, editText2, function0, appCompatDialog, null), 1, null);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.ba
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebHookTrigger.n1(AppCompatDialog.this, view);
            }
        });
        ViewExtensionsKt.focusAndShowKeyboard(editText);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(String str) {
        this.progressDialog = new MaterialDialog.Builder(getActivity()).title(R.string.please_wait).widgetColor(ContextCompat.getColor(getContext(), R.color.trigger_primary)).content(str).progress(true, 0).cancelable(false).show();
    }

    private final void p1() {
        Settings.setPushTokenUploadFailed(getContext(), false);
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.triggers.ea
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                WebHookTrigger.q1(WebHookTrigger.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(final WebHookTrigger this$0, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            boolean z3 = false;
            String deviceId = Settings.getUniqueId(this$0.getContext(), false);
            final String firebaseToken = (String) task.getResult();
            if (task.getResult() == null) {
                SystemLog.logError("No push token available, Web URL trigger will not currently work");
                return;
            } else if (!Intrinsics.areEqual(firebaseToken, Settings.getPushTokenUploadedId(this$0.getContext()))) {
                Long macroGuid = this$0.getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logInfo("WebHook Trigger -> Uploading push token id to macrodroid backend for this device Id (" + deviceId + ")", macroGuid.longValue());
                Disposable disposable = this$0.tokenUpdloadDisposable;
                if (disposable != null) {
                    if (disposable != null && !disposable.isDisposed()) {
                        z3 = true;
                    }
                    if (z3) {
                        return;
                    }
                }
                try {
                    WebTriggerInteractor webTriggerInteractor = this$0.getWebTriggerInteractor();
                    Intrinsics.checkNotNullExpressionValue(deviceId, "deviceId");
                    Intrinsics.checkNotNullExpressionValue(firebaseToken, "firebaseToken");
                    Completable uploadTriggerToken = webTriggerInteractor.uploadTriggerToken(deviceId, "", firebaseToken, Defaults.REGISTER_COMMERCIAL_DEVICE_COMPANY_ID);
                    Action action = new Action() { // from class: com.arlosoft.macrodroid.triggers.qa
                        @Override // io.reactivex.functions.Action
                        public final void run() {
                            WebHookTrigger.r1(WebHookTrigger.this, firebaseToken);
                        }
                    };
                    final v vVar = new v();
                    this$0.tokenUpdloadDisposable = uploadTriggerToken.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.triggers.ra
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            WebHookTrigger.s1(Function1.this, obj);
                        }
                    });
                    return;
                } catch (Exception e4) {
                    SystemLog.logError("Could not upload push token id: " + e4);
                    FirebaseCrashlytics.getInstance().recordException(e4);
                    return;
                }
            } else {
                return;
            }
        }
        SystemLog.logError("No Firebase Messaging token available, Web URL trigger will not currently work (" + task.getException() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(WebHookTrigger this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.setPushTokenUploadedId(this$0.getContext(), str);
        Long macroGuid = this$0.getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logInfo("Push token upload success", macroGuid.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean v0(String str) {
        List split$default;
        boolean contains$default;
        if (URLUtil.isValidUrl(str)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{RemoteSettings.FORWARD_SLASH_STRING}, false, 0, 6, (Object) null);
            if (split$default.size() == 5) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "#", false, 2, (Object) null);
                if (contains$default) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(final Spinner spinner) {
        List listOf;
        String str;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.dont_save_output_in_variable));
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = getMacro();
        String str2 = this.workingSaveBodyVariableName;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.workingSaveBodyDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, listOf, str, true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.triggers.WebHookTrigger$configureStringVarSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                WebHookTrigger.this.workingSaveBodyVariableName = null;
                WebHookTrigger.this.workingSaveBodyDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                spinner.setEnabled(true);
                spinner.setAlpha(1.0f);
                WebHookTrigger.this.workingSaveBodyVariableName = variable.getName();
                WebHookTrigger webHookTrigger = WebHookTrigger.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                webHookTrigger.workingSaveBodyDictionaryKeys = dictionaryKeys;
            }
        });
    }

    private final Single<String> x0(String str) {
        if (this.tinyUrlApi != null) {
            Single<String> observeOn = getTinyUrlApi().urlTriggerToken(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final a aVar = new a();
            Single<String> doFinally = observeOn.doOnSubscribe(new Consumer() { // from class: com.arlosoft.macrodroid.triggers.za
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WebHookTrigger.y0(Function1.this, obj);
                }
            }).doFinally(new Action() { // from class: com.arlosoft.macrodroid.triggers.ab
                @Override // io.reactivex.functions.Action
                public final void run() {
                    WebHookTrigger.z0(WebHookTrigger.this);
                }
            });
            Intrinsics.checkNotNullExpressionValue(doFinally, "private fun getTinyUrl(u…G).show()\n        }\n    }");
            return doFinally;
        }
        Single<String> just = Single.just(str);
        Intrinsics.checkNotNullExpressionValue(just, "just(url)");
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(WebHookTrigger this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MaterialDialog materialDialog = this$0.progressDialog;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        triggerCounter--;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCounter == 0) {
            p1();
        }
        triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getEditModeWarning() {
        if (Settings.getPushTokenUploadFailed(getContext())) {
            return "UPLOAD FAILED - CLICK TO TRY AGAIN";
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String uniqueId = Settings.getUniqueId(getContext(), false);
        String str = this.identifier;
        return "https://trigger.macrodroid.com/" + uniqueId + RemoteSettings.FORWARD_SLASH_STRING + str;
    }

    @NotNull
    public final String getIdentifierWithMagicTextApplied() {
        String g4 = g(this.identifier, null);
        Intrinsics.checkNotNullExpressionValue(g4, "applyMagicText(identifier, null)");
        return g4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return WebHookTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String str = this.identifier;
        return name + " (" + str + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.identifier};
    }

    @Nullable
    public final DictionaryKeys getSaveBodyDictionaryKeys() {
        return this.saveBodyDictionaryKeys;
    }

    @Nullable
    public final String getSaveBodyVariableName() {
        return this.saveBodyVariableName;
    }

    @NotNull
    public final TinyUrlApi getTinyUrlApi() {
        TinyUrlApi tinyUrlApi = this.tinyUrlApi;
        if (tinyUrlApi != null) {
            return tinyUrlApi;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tinyUrlApi");
        return null;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.saveBodyVariableName;
    }

    @NotNull
    public final WebTriggerInteractor getWebTriggerInteractor() {
        WebTriggerInteractor webTriggerInteractor = this.webTriggerInteractor;
        if (webTriggerInteractor != null) {
            return webTriggerInteractor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webTriggerInteractor");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @SuppressLint({"CheckResult"})
    public void handleItemSelected() {
        NDSpinner nDSpinner;
        int i4;
        final TextView textView;
        ImageView imageView;
        final AppCompatDialog appCompatDialog;
        AppCompatDialog appCompatDialog2 = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog2.setContentView(R.layout.dialog_web_url_trigger);
        appCompatDialog2.setTitle(R.string.trigger_web_hook);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog2.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog2.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        Button button = (Button) appCompatDialog2.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog2.findViewById(R.id.cancelButton);
        final TextView textView2 = (TextView) appCompatDialog2.findViewById(R.id.urlLinkText);
        View findViewById = appCompatDialog2.findViewById(R.id.identifier);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        final Button button3 = (Button) appCompatDialog2.findViewById(R.id.tinyUrlButton);
        ImageView imageView2 = (ImageView) appCompatDialog2.findViewById(R.id.urlCopyButton);
        ImageView imageView3 = (ImageView) appCompatDialog2.findViewById(R.id.urlShareButton);
        final ImageView imageView4 = (ImageView) appCompatDialog2.findViewById(R.id.urlCopyButtonTinyUrl);
        final ImageView imageView5 = (ImageView) appCompatDialog2.findViewById(R.id.urlShareButtonTinyUrl);
        final TextView textView3 = (TextView) appCompatDialog2.findViewById(R.id.tinyUrlLinkText);
        View findViewById2 = appCompatDialog2.findViewById(R.id.portToNewDeviceButton);
        Intrinsics.checkNotNull(findViewById2);
        TextView textView4 = (TextView) findViewById2;
        View findViewById3 = appCompatDialog2.findViewById(R.id.importFromDeviceButton);
        Intrinsics.checkNotNull(findViewById3);
        TextView textView5 = (TextView) findViewById3;
        View findViewById4 = appCompatDialog2.findViewById(R.id.newDeviceIdButton);
        Intrinsics.checkNotNull(findViewById4);
        TextView textView6 = (TextView) findViewById4;
        View findViewById5 = appCompatDialog2.findViewById(R.id.editwhiteListButton);
        Intrinsics.checkNotNull(findViewById5);
        ImageView imageView6 = (ImageView) findViewById5;
        View findViewById6 = appCompatDialog2.findViewById(R.id.whiteListEntriesText);
        Intrinsics.checkNotNull(findViewById6);
        TextView textView7 = (TextView) findViewById6;
        View findViewById7 = appCompatDialog2.findViewById(R.id.magicTextButton);
        Intrinsics.checkNotNull(findViewById7);
        Button button4 = (Button) findViewById7;
        View findViewById8 = appCompatDialog2.findViewById(R.id.bodyVariableSpinner);
        Intrinsics.checkNotNull(findViewById8);
        NDSpinner nDSpinner2 = (NDSpinner) findViewById8;
        View findViewById9 = appCompatDialog2.findViewById(R.id.addStringVariableButton);
        Intrinsics.checkNotNull(findViewById9);
        Button button5 = (Button) findViewById9;
        this.workingWhiteList = this.ipAddressWhiteList;
        this.workingSaveBodyVariableName = this.saveBodyVariableName;
        this.workingSaveBodyDictionaryKeys = this.saveBodyDictionaryKeys;
        String tinyUrl = Settings.getTinyUrl(getContext());
        if (tinyUrl != null) {
            if (textView3 == null) {
                nDSpinner = nDSpinner2;
            } else {
                String str = this.identifier;
                nDSpinner = nDSpinner2;
                textView3.setText(tinyUrl + RemoteSettings.FORWARD_SLASH_STRING + str);
            }
            if (button3 != null) {
                button3.setVisibility(0);
            }
            i4 = 8;
        } else {
            nDSpinner = nDSpinner2;
            if (imageView4 == null) {
                i4 = 8;
            } else {
                i4 = 8;
                imageView4.setVisibility(8);
            }
            if (imageView5 != null) {
                imageView5.setVisibility(i4);
            }
            if (textView3 != null) {
                textView3.setVisibility(i4);
            }
        }
        textView4.setPaintFlags(textView4.getPaintFlags() | i4);
        ViewExtensionsKt.onClick$default(textView4, null, new d(null), 1, null);
        textView5.setPaintFlags(textView5.getPaintFlags() | 8);
        ViewExtensionsKt.onClick$default(textView5, null, new e(textView2, null), 1, null);
        textView6.setPaintFlags(textView6.getPaintFlags() | 8);
        ViewExtensionsKt.onClick$default(textView6, null, new f(textView2, null), 1, null);
        if (editText != null) {
            editText.setText(this.identifier);
        }
        if (textView2 != null) {
            String uniqueId = Settings.getUniqueId(getContext(), false);
            String str2 = this.identifier;
            textView2.setText("https://trigger.macrodroid.com/" + uniqueId + RemoteSettings.FORWARD_SLASH_STRING + str2);
        }
        if (editText != null) {
            ViewExtensionsKt.afterTextChanged(editText, new g(textView2, this, textView3));
        }
        textView7.setText(A0(this.workingWhiteList));
        ViewExtensionsKt.onClick$default(imageView6, null, new h(textView7, null), 1, null);
        if (button3 != null) {
            textView = textView3;
            imageView = imageView5;
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.va
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebHookTrigger.M0(WebHookTrigger.this, textView3, imageView4, imageView5, button3, view);
                }
            });
        } else {
            textView = textView3;
            imageView = imageView5;
        }
        NDSpinner nDSpinner3 = nDSpinner;
        ViewExtensionsKt.onClick$default(button5, null, new k(nDSpinner3, null), 1, null);
        w0(nDSpinner3);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.bb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebHookTrigger.P0(WebHookTrigger.this, textView2, view);
                }
            });
        }
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.cb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebHookTrigger.Q0(WebHookTrigger.this, textView, view);
                }
            });
        }
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.db
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebHookTrigger.R0(textView2, this, view);
                }
            });
        }
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.eb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebHookTrigger.S0(textView, this, view);
                }
            });
        }
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.fb
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                WebHookTrigger.T0(editText, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.gb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebHookTrigger.U0(WebHookTrigger.this, magicTextListener, view);
            }
        });
        if (button != null) {
            appCompatDialog = appCompatDialog2;
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.hb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebHookTrigger.V0(editText, textView2, this, appCompatDialog, view);
                }
            });
        } else {
            appCompatDialog = appCompatDialog2;
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebHookTrigger.L0(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        p1();
        Z0();
        ToastCompat.makeText(getContext(), (int) R.string.retrying_upload, 0).show();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        boolean z3;
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            this.identifier = magicText[0];
        }
    }

    public final void setTinyUrlApi(@NotNull TinyUrlApi tinyUrlApi) {
        Intrinsics.checkNotNullParameter(tinyUrlApi, "<set-?>");
        this.tinyUrlApi = tinyUrlApi;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(@Nullable String str) {
        this.saveBodyVariableName = str;
    }

    public final void setWebTriggerInteractor(@NotNull WebTriggerInteractor webTriggerInteractor) {
        Intrinsics.checkNotNullParameter(webTriggerInteractor, "<set-?>");
        this.webTriggerInteractor = webTriggerInteractor;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.identifier);
        out.writeStringList(this.ipAddressWhiteList);
        out.writeString(this.saveBodyVariableName);
        out.writeParcelable(this.saveBodyDictionaryKeys, i4);
    }

    public WebHookTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this.identifier = "";
        this.ipAddressWhiteList = new ArrayList<>();
        this.workingWhiteList = new ArrayList<>();
        init();
        setActivity(activity);
        this.m_macro = macro;
    }

    public WebHookTrigger() {
        this.identifier = "";
        this.ipAddressWhiteList = new ArrayList<>();
        this.workingWhiteList = new ArrayList<>();
        init();
    }

    private WebHookTrigger(Parcel parcel) {
        super(parcel);
        this.identifier = "";
        this.ipAddressWhiteList = new ArrayList<>();
        this.workingWhiteList = new ArrayList<>();
        init();
        String readString = parcel.readString();
        this.identifier = readString != null ? readString : "";
        ArrayList<String> arrayList = new ArrayList<>();
        this.ipAddressWhiteList = arrayList;
        parcel.readStringList(arrayList);
        this.saveBodyVariableName = parcel.readString();
        this.saveBodyDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* compiled from: WebHookTrigger.kt */
    @SourceDebugExtension({"SMAP\nWebHookTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,905:1\n1855#2,2:906\n*S KotlinDebug\n*F\n+ 1 WebHookTrigger.kt\ncom/arlosoft/macrodroid/triggers/WebHookTrigger$Companion\n*L\n148#1:906,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(String str, String str2, Macro macro) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return WildCardHelper.matches(str, WildCardHelper.getRegexContainsPattern(lowerCase, false, true), false, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Map map, Macro macro) {
            Intrinsics.checkNotNullParameter(macro, "$macro");
            if (map != null) {
                for (String str : map.keySet()) {
                    Trigger triggerThatInvoked = macro.getTriggerThatInvoked();
                    Intrinsics.checkNotNullExpressionValue(triggerThatInvoked, "macro.triggerThatInvoked");
                    WebHookTrigger.Companion.e(str, (String) map.get(str), triggerThatInvoked);
                }
            }
            macro.invokeActions(macro.getTriggerContextInfo());
        }

        private final boolean d(String str, List<String> list, Macro macro) {
            boolean contains$default;
            List<String> split$default;
            if (str == null || list.isEmpty()) {
                return true;
            }
            for (String str2 : list) {
                String text = MagicText.replaceMagicText(MacroDroidApplication.Companion.getInstance(), str2, null, false, macro, false, true);
                Intrinsics.checkNotNullExpressionValue(text, "text");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) ",", false, 2, (Object) null);
                if (contains$default) {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) text, new String[]{","}, false, 0, 6, (Object) null);
                    for (String str3 : split$default) {
                        if (WebHookTrigger.Companion.b(str, str3, macro)) {
                            return true;
                        }
                    }
                    continue;
                } else if (b(str, text, macro)) {
                    return true;
                }
            }
            return false;
        }

        private final void e(String str, String str2, SelectableItem selectableItem) {
            boolean contains$default;
            boolean endsWith$default;
            int indexOf$default;
            String replace$default;
            String replace$default2;
            String replace$default3;
            List split$default;
            String str3;
            VariableValue stringValue;
            MacroDroidVariable variableByName = selectableItem.getVariableByName(str);
            if (variableByName == null) {
                try {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "(", false, 2, (Object) null);
                    if (contains$default) {
                        endsWith$default = kotlin.text.m.endsWith$default(str, ")", false, 2, null);
                        if (endsWith$default) {
                            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "(", 0, false, 6, (Object) null);
                            String substring = str.substring(0, indexOf$default);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                            MacroDroidVariable variableByName2 = selectableItem.getVariableByName(substring);
                            if (variableByName2 != null) {
                                String substring2 = str.substring(substring.length());
                                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                replace$default = kotlin.text.m.replace$default(substring2, ")(", ",", false, 4, (Object) null);
                                replace$default2 = kotlin.text.m.replace$default(replace$default, "(", "", false, 4, (Object) null);
                                replace$default3 = kotlin.text.m.replace$default(replace$default2, ")", "", false, 4, (Object) null);
                                split$default = StringsKt__StringsKt.split$default((CharSequence) replace$default3, new String[]{","}, false, 0, 6, (Object) null);
                                DictionaryKeys dictionaryKeys = new DictionaryKeys(split$default);
                                VariableValue.DictionaryEntry dictionaryEntryFromKeyList = variableByName2.getDictionaryEntryFromKeyList(dictionaryKeys.getKeys());
                                if (dictionaryEntryFromKeyList != null) {
                                    stringValue = VariableValue.Companion.fromTextValueForType(str2, dictionaryEntryFromKeyList.getVariable().getVariableType(), dictionaryKeys.getKeys());
                                } else {
                                    if (str2 == null) {
                                        str3 = "";
                                    } else {
                                        str3 = str2;
                                    }
                                    stringValue = new VariableValue.StringValue(str3, dictionaryKeys.getKeys());
                                }
                                selectableItem.variableUpdate(variableByName2, stringValue);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e4) {
                    SystemLog.logError("Webhook variable processing failed: " + e4 + "}");
                    return;
                }
            }
            selectableItem.variableUpdate(variableByName, VariableValue.Companion.fromTextValueForType$default(VariableValue.Companion, str2, variableByName.getType(), null, 4, null));
        }

        public final void checkTriggers(@NotNull String id, @Nullable final Map<String, String> map, @Nullable String str, @Nullable String str2) {
            List<String> emptyList;
            Intrinsics.checkNotNullParameter(id, "id");
            ArrayList<Macro> arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof WebHookTrigger) && Intrinsics.areEqual(((WebHookTrigger) next).getIdentifierWithMagicTextApplied(), id) && next.constraintsMet()) {
                        WebHookTrigger webHookTrigger = (WebHookTrigger) next;
                        ArrayList arrayList2 = webHookTrigger.ipAddressWhiteList;
                        Intrinsics.checkNotNullExpressionValue(macro, "macro");
                        if (d(str, arrayList2, macro)) {
                            TriggerContextInfo triggerContextInfo = new TriggerContextInfo(next, str);
                            if (macro.canInvoke(triggerContextInfo)) {
                                macro.setTriggerThatInvoked(next);
                                macro.setTriggerContextInfo(triggerContextInfo);
                                if (webHookTrigger.getSaveBodyVariableName() != null && str2 != null) {
                                    MacroDroidVariable variableByName = next.getVariableByName(webHookTrigger.getSaveBodyVariableName());
                                    if (variableByName != null) {
                                        Context context = webHookTrigger.getContext();
                                        Intrinsics.checkNotNullExpressionValue(context, "trigger.context");
                                        DictionaryKeys saveBodyDictionaryKeys = webHookTrigger.getSaveBodyDictionaryKeys();
                                        if (saveBodyDictionaryKeys == null || (emptyList = saveBodyDictionaryKeys.getKeys()) == null) {
                                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                                        }
                                        next.variableUpdate(variableByName, new VariableValue.StringValue(str2, VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, null, macro)));
                                    } else {
                                        Long macroGuid = webHookTrigger.getMacroGuid();
                                        Intrinsics.checkNotNullExpressionValue(macroGuid, "trigger.macroGuid");
                                        SystemLog.logError("Failed to save command line output to variable: " + webHookTrigger.getSaveBodyVariableName() + " not found", macroGuid.longValue());
                                    }
                                }
                                arrayList.add(macro);
                            }
                        }
                    }
                }
            }
            for (final Macro macro2 : arrayList) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.ib
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebHookTrigger.Companion.c(map, macro2);
                    }
                });
            }
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
