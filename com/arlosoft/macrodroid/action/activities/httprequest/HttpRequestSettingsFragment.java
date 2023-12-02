package com.arlosoft.macrodroid.action.activities.httprequest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.HttpRequestAction;
import com.arlosoft.macrodroid.action.HttpRequestConfig;
import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.databinding.FragmentHttpRequestSettingsBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestSettingsFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nHttpRequestSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,340:1\n65#2,16:341\n93#2,3:357\n65#2,16:360\n93#2,3:376\n65#2,16:379\n93#2,3:395\n65#2,16:398\n93#2,3:414\n65#2,16:417\n93#2,3:433\n262#3,2:436\n262#3,2:438\n262#3,2:440\n*S KotlinDebug\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment\n*L\n99#1:341,16\n99#1:357,3\n105#1:360,16\n105#1:376,3\n108#1:379,16\n108#1:395,3\n135#1:398,16\n135#1:414,3\n138#1:417,16\n138#1:433,3\n196#1:436,2\n251#1:438,2\n252#1:440,2\n*E\n"})
/* loaded from: classes2.dex */
public final class HttpRequestSettingsFragment extends MacroDroidDaggerBaseFragment {
    public static final int REQUEST_CODE_PICK_FOLDER = 0;

    /* renamed from: b  reason: collision with root package name */
    private FragmentHttpRequestSettingsBinding f3054b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Macro f3055c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private transient String f3056d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private transient DictionaryKeys f3057e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private transient String f3058f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private transient DictionaryKeys f3059g;
    @Inject
    public HttpRequestConfigViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HttpRequestSettingsFragment newInstance(long j4) {
            HttpRequestSettingsFragment httpRequestSettingsFragment = new HttpRequestSettingsFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(Constants.EXTRA_MACRO_GUID, j4);
            httpRequestSettingsFragment.setArguments(bundle);
            return httpRequestSettingsFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<HttpRequestConfigAndAction, Unit> {
        a() {
            super(1);
        }

        public final void a(HttpRequestConfigAndAction httpRequestConfigAndAction) {
            HttpRequestSettingsFragment.this.g(httpRequestConfigAndAction.getRequestConfig(), httpRequestConfigAndAction.getHttpRequestionAction());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpRequestConfigAndAction httpRequestConfigAndAction) {
            a(httpRequestConfigAndAction);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    @SourceDebugExtension({"SMAP\nHttpRequestSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment$configureUi$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,340:1\n262#2,2:341\n262#2,2:343\n*S KotlinDebug\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment$configureUi$1\n*L\n200#1:341,2\n206#1:343,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpRequestAction $action;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(HttpRequestAction httpRequestAction, Continuation<? super b> continuation) {
            super(4, continuation);
            this.$action = httpRequestAction;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            b bVar = new b(this.$action, continuation);
            bVar.Z$0 = z3;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z3 = this.Z$0;
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = null;
                if (z3) {
                    HttpRequestSettingsFragment httpRequestSettingsFragment = HttpRequestSettingsFragment.this;
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = httpRequestSettingsFragment.f3054b;
                    if (fragmentHttpRequestSettingsBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestSettingsBinding2 = null;
                    }
                    NDSpinner nDSpinner = fragmentHttpRequestSettingsBinding2.responseCodeVariableSpinner;
                    Intrinsics.checkNotNullExpressionValue(nDSpinner, "binding.responseCodeVariableSpinner");
                    httpRequestSettingsFragment.h(nDSpinner, this.$action);
                }
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestSettingsBinding3 = null;
                }
                LinearLayout linearLayout = fragmentHttpRequestSettingsBinding3.responseCodeSelectionLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.responseCodeSelectionLayout");
                if (z3) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                linearLayout.setVisibility(i4);
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding4 = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestSettingsBinding4 = null;
                }
                float f4 = 0.4f;
                if (fragmentHttpRequestSettingsBinding4.responseCodeVariableSpinner.getCount() <= 1) {
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding5 = HttpRequestSettingsFragment.this.f3054b;
                    if (fragmentHttpRequestSettingsBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestSettingsBinding5 = null;
                    }
                    if (Intrinsics.areEqual(fragmentHttpRequestSettingsBinding5.responseCodeVariableSpinner.getItemAtPosition(0), HttpRequestSettingsFragment.this.getString(R.string.trigger_variable_no_variables))) {
                        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding6 = HttpRequestSettingsFragment.this.f3054b;
                        if (fragmentHttpRequestSettingsBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            fragmentHttpRequestSettingsBinding6 = null;
                        }
                        LinearLayout linearLayout2 = fragmentHttpRequestSettingsBinding6.responseCodeSelectionLayout;
                        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.responseCodeSelectionLayout");
                        linearLayout2.setVisibility(8);
                        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding7 = HttpRequestSettingsFragment.this.f3054b;
                        if (fragmentHttpRequestSettingsBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            fragmentHttpRequestSettingsBinding7 = null;
                        }
                        fragmentHttpRequestSettingsBinding7.saveHttpResponseCodeCheckbox.setChecked(false);
                        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding8 = HttpRequestSettingsFragment.this.f3054b;
                        if (fragmentHttpRequestSettingsBinding8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            fragmentHttpRequestSettingsBinding = fragmentHttpRequestSettingsBinding8;
                        }
                        fragmentHttpRequestSettingsBinding.responseCodeVariableSpinner.setAlpha(0.4f);
                        ToastCompat.makeText(HttpRequestSettingsFragment.this.requireActivity().getApplicationContext(), (int) R.string.trigger_variable_no_variables, 0).show();
                        return Unit.INSTANCE;
                    }
                }
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding9 = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestSettingsBinding9 = null;
                }
                fragmentHttpRequestSettingsBinding9.responseCodeVariableSpinner.setEnabled(z3);
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding10 = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentHttpRequestSettingsBinding = fragmentHttpRequestSettingsBinding10;
                }
                NDSpinner nDSpinner2 = fragmentHttpRequestSettingsBinding.responseCodeVariableSpinner;
                if (z3) {
                    f4 = 1.0f;
                }
                nDSpinner2.setAlpha(f4);
                HttpRequestSettingsFragment.this.getViewModel().setSaveReturnCodeInIntegerVariable(z3);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpRequestAction $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(HttpRequestAction httpRequestAction, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$action = httpRequestAction;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(HttpRequestSettingsFragment httpRequestSettingsFragment, HttpRequestAction httpRequestAction, MacroDroidVariable macroDroidVariable) {
            httpRequestSettingsFragment.f3056d = macroDroidVariable.getName();
            FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = null;
            httpRequestSettingsFragment.f3057e = null;
            httpRequestSettingsFragment.getViewModel().setSaveHttpResponseCodeVariableName(macroDroidVariable.getName(), null);
            FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = httpRequestSettingsFragment.f3054b;
            if (fragmentHttpRequestSettingsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentHttpRequestSettingsBinding = fragmentHttpRequestSettingsBinding2;
            }
            NDSpinner nDSpinner = fragmentHttpRequestSettingsBinding.responseCodeVariableSpinner;
            Intrinsics.checkNotNullExpressionValue(nDSpinner, "binding.responseCodeVariableSpinner");
            httpRequestSettingsFragment.h(nDSpinner, httpRequestAction);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$action, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FragmentActivity requireActivity = HttpRequestSettingsFragment.this.requireActivity();
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestSettingsBinding = null;
                }
                NDSpinner nDSpinner = fragmentHttpRequestSettingsBinding.responseCodeVariableSpinner;
                final HttpRequestAction httpRequestAction = this.$action;
                final HttpRequestSettingsFragment httpRequestSettingsFragment = HttpRequestSettingsFragment.this;
                VariablesHelper.createNewVariable(requireActivity, nDSpinner, httpRequestAction, (int) R.style.Theme_App_Dialog_Action, 1, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.l
                    @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                    public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                        HttpRequestSettingsFragment.c.c(HttpRequestSettingsFragment.this, httpRequestAction, macroDroidVariable);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    @SourceDebugExtension({"SMAP\nHttpRequestSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment$configureUi$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,340:1\n262#2,2:341\n262#2,2:343\n*S KotlinDebug\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment$configureUi$3\n*L\n225#1:341,2\n226#1:343,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class d extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        d(Continuation<? super d> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            d dVar = new d(continuation);
            dVar.Z$0 = z3;
            return dVar.invokeSuspend(Unit.INSTANCE);
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
                if (this.Z$0) {
                    HttpRequestSettingsFragment.this.getViewModel().setSaveResponseType(0);
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = HttpRequestSettingsFragment.this.f3054b;
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = null;
                    if (fragmentHttpRequestSettingsBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestSettingsBinding = null;
                    }
                    LinearLayout linearLayout = fragmentHttpRequestSettingsBinding.responseVariableLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.responseVariableLayout");
                    linearLayout.setVisibility(8);
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = HttpRequestSettingsFragment.this.f3054b;
                    if (fragmentHttpRequestSettingsBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentHttpRequestSettingsBinding2 = fragmentHttpRequestSettingsBinding3;
                    }
                    LinearLayout linearLayout2 = fragmentHttpRequestSettingsBinding2.responseFileLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.responseFileLayout");
                    linearLayout2.setVisibility(8);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    @SourceDebugExtension({"SMAP\nHttpRequestSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment$configureUi$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,340:1\n262#2,2:341\n262#2,2:343\n*S KotlinDebug\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment$configureUi$4\n*L\n233#1:341,2\n234#1:343,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class e extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpRequestAction $action;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(HttpRequestAction httpRequestAction, Continuation<? super e> continuation) {
            super(4, continuation);
            this.$action = httpRequestAction;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            e eVar = new e(this.$action, continuation);
            eVar.Z$0 = z3;
            return eVar.invokeSuspend(Unit.INSTANCE);
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
                if (this.Z$0) {
                    HttpRequestSettingsFragment httpRequestSettingsFragment = HttpRequestSettingsFragment.this;
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = httpRequestSettingsFragment.f3054b;
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = null;
                    if (fragmentHttpRequestSettingsBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestSettingsBinding = null;
                    }
                    NDSpinner nDSpinner = fragmentHttpRequestSettingsBinding.httpResponseVariableSpinner;
                    Intrinsics.checkNotNullExpressionValue(nDSpinner, "binding.httpResponseVariableSpinner");
                    httpRequestSettingsFragment.i(nDSpinner, this.$action);
                    HttpRequestSettingsFragment.this.getViewModel().setSaveResponseType(1);
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = HttpRequestSettingsFragment.this.f3054b;
                    if (fragmentHttpRequestSettingsBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestSettingsBinding3 = null;
                    }
                    LinearLayout linearLayout = fragmentHttpRequestSettingsBinding3.responseVariableLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.responseVariableLayout");
                    linearLayout.setVisibility(0);
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding4 = HttpRequestSettingsFragment.this.f3054b;
                    if (fragmentHttpRequestSettingsBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentHttpRequestSettingsBinding2 = fragmentHttpRequestSettingsBinding4;
                    }
                    LinearLayout linearLayout2 = fragmentHttpRequestSettingsBinding2.responseFileLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.responseFileLayout");
                    linearLayout2.setVisibility(8);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    @SourceDebugExtension({"SMAP\nHttpRequestSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment$configureUi$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,340:1\n262#2,2:341\n262#2,2:343\n*S KotlinDebug\n*F\n+ 1 HttpRequestSettingsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestSettingsFragment$configureUi$5\n*L\n240#1:341,2\n241#1:343,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class f extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        f(Continuation<? super f> continuation) {
            super(4, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(HttpRequestSettingsFragment httpRequestSettingsFragment) {
            FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = httpRequestSettingsFragment.f3054b;
            if (fragmentHttpRequestSettingsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHttpRequestSettingsBinding = null;
            }
            fragmentHttpRequestSettingsBinding.scrollView.fullScroll(130);
        }

        @Nullable
        public final Object b(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            f fVar = new f(continuation);
            fVar.Z$0 = z3;
            return fVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return b(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.Z$0) {
                    HttpRequestSettingsFragment.this.getViewModel().setSaveResponseType(2);
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = HttpRequestSettingsFragment.this.f3054b;
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = null;
                    if (fragmentHttpRequestSettingsBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestSettingsBinding = null;
                    }
                    LinearLayout linearLayout = fragmentHttpRequestSettingsBinding.responseVariableLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.responseVariableLayout");
                    linearLayout.setVisibility(8);
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = HttpRequestSettingsFragment.this.f3054b;
                    if (fragmentHttpRequestSettingsBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestSettingsBinding3 = null;
                    }
                    LinearLayout linearLayout2 = fragmentHttpRequestSettingsBinding3.responseFileLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.responseFileLayout");
                    linearLayout2.setVisibility(0);
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding4 = HttpRequestSettingsFragment.this.f3054b;
                    if (fragmentHttpRequestSettingsBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentHttpRequestSettingsBinding2 = fragmentHttpRequestSettingsBinding4;
                    }
                    ScrollView scrollView = fragmentHttpRequestSettingsBinding2.scrollView;
                    final HttpRequestSettingsFragment httpRequestSettingsFragment = HttpRequestSettingsFragment.this;
                    scrollView.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            HttpRequestSettingsFragment.f.c(HttpRequestSettingsFragment.this);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpRequestAction $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(HttpRequestAction httpRequestAction, Continuation<? super g> continuation) {
            super(3, continuation);
            this.$action = httpRequestAction;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(HttpRequestSettingsFragment httpRequestSettingsFragment, HttpRequestAction httpRequestAction, MacroDroidVariable macroDroidVariable) {
            httpRequestSettingsFragment.f3058f = macroDroidVariable.getName();
            FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = null;
            httpRequestSettingsFragment.f3059g = null;
            httpRequestSettingsFragment.getViewModel().setSaveHttpResponseVariableName(macroDroidVariable.getName(), null);
            FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = httpRequestSettingsFragment.f3054b;
            if (fragmentHttpRequestSettingsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentHttpRequestSettingsBinding = fragmentHttpRequestSettingsBinding2;
            }
            NDSpinner nDSpinner = fragmentHttpRequestSettingsBinding.httpResponseVariableSpinner;
            Intrinsics.checkNotNullExpressionValue(nDSpinner, "binding.httpResponseVariableSpinner");
            httpRequestSettingsFragment.i(nDSpinner, httpRequestAction);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(this.$action, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FragmentActivity requireActivity = HttpRequestSettingsFragment.this.requireActivity();
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestSettingsBinding = null;
                }
                NDSpinner nDSpinner = fragmentHttpRequestSettingsBinding.httpResponseVariableSpinner;
                final HttpRequestAction httpRequestAction = this.$action;
                final HttpRequestSettingsFragment httpRequestSettingsFragment = HttpRequestSettingsFragment.this;
                VariablesHelper.createNewVariable(requireActivity, nDSpinner, httpRequestAction, (int) R.style.Theme_App_Dialog_Action, 2, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.n
                    @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                    public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                        HttpRequestSettingsFragment.g.c(HttpRequestSettingsFragment.this, httpRequestAction, macroDroidVariable);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $authUsernameTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(MagicText.MagicTextListener magicTextListener, Continuation<? super h> continuation) {
            super(3, continuation);
            this.$authUsernameTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(this.$authUsernameTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(HttpRequestSettingsFragment.this.getActivity(), this.$authUsernameTextListener, HttpRequestSettingsFragment.this.f3055c, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $authPasswordTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(MagicText.MagicTextListener magicTextListener, Continuation<? super i> continuation) {
            super(3, continuation);
            this.$authPasswordTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new i(this.$authPasswordTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(HttpRequestSettingsFragment.this.getActivity(), this.$authPasswordTextListener, HttpRequestSettingsFragment.this.f3055c, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class j extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $filenameMagicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(MagicText.MagicTextListener magicTextListener, Continuation<? super j> continuation) {
            super(3, continuation);
            this.$filenameMagicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new j(this.$filenameMagicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(HttpRequestSettingsFragment.this.getActivity(), this.$filenameMagicTextListener, HttpRequestSettingsFragment.this.f3055c, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        k(Continuation<? super k> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    HttpRequestSettingsFragment.this.startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 0);
                } catch (Exception unused) {
                    Context applicationContext = HttpRequestSettingsFragment.this.requireContext().getApplicationContext();
                    String string = HttpRequestSettingsFragment.this.getString(R.string.not_supported);
                    ToastCompat.makeText(applicationContext, (CharSequence) ("ACTION_OPEN_DOCUMENT " + string), 0).show();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class l extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        l(Continuation<? super l> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            l lVar = new l(continuation);
            lVar.Z$0 = z3;
            return lVar.invokeSuspend(Unit.INSTANCE);
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
                HttpRequestSettingsFragment.this.getViewModel().setBlockNextActions(this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class m extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        m(Continuation<? super m> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            m mVar = new m(continuation);
            mVar.Z$0 = z3;
            return mVar.invokeSuspend(Unit.INSTANCE);
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
                HttpRequestSettingsFragment.this.getViewModel().setAllowAnyCertificate(this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class n extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        n(Continuation<? super n> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            n nVar = new n(continuation);
            nVar.Z$0 = z3;
            return nVar.invokeSuspend(Unit.INSTANCE);
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
                HttpRequestSettingsFragment.this.getViewModel().setFollowRedirects(this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class o extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        o(Continuation<? super o> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            o oVar = new o(continuation);
            oVar.Z$0 = z3;
            return oVar.invokeSuspend(Unit.INSTANCE);
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
                HttpRequestSettingsFragment.this.getViewModel().setBasicAuthEnabled(this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class p extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $urlMagicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(MagicText.MagicTextListener magicTextListener, Continuation<? super p> continuation) {
            super(3, continuation);
            this.$urlMagicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new p(this.$urlMagicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(HttpRequestSettingsFragment.this.getActivity(), this.$urlMagicTextListener, HttpRequestSettingsFragment.this.f3055c, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestSettingsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class q implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f3070a;

        q(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f3070a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f3070a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f3070a.invoke(obj);
        }
    }

    private final void f() {
        getViewModel().getHttpRequestConfig().observe(getViewLifecycleOwner(), new q(new a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(HttpRequestConfig httpRequestConfig, HttpRequestAction httpRequestAction) {
        float f4;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        boolean z7;
        float f5;
        String saveResponseFolderPathDisplayName;
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = this.f3054b;
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = null;
        if (fragmentHttpRequestSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding = null;
        }
        fragmentHttpRequestSettingsBinding.timeoutSecondsText.setText(String.valueOf(httpRequestConfig.getRequestTimeOutSeconds()));
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding3 = null;
        }
        fragmentHttpRequestSettingsBinding3.blockNextActionCheckBox.setChecked(httpRequestConfig.getBlockNextAction());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding4 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding4 = null;
        }
        fragmentHttpRequestSettingsBinding4.allowAnyCertificateCheckBox.setChecked(httpRequestConfig.getAllowAnyCertificate());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding5 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding5 = null;
        }
        fragmentHttpRequestSettingsBinding5.url.setText(httpRequestConfig.getUrlToOpen());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding6 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding6 = null;
        }
        fragmentHttpRequestSettingsBinding6.requestTypeSpinner.setSelection(httpRequestConfig.getRequestType());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding7 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding7 = null;
        }
        fragmentHttpRequestSettingsBinding7.saveHttpResponseCodeCheckbox.setChecked(httpRequestConfig.getSaveReturnCodeToVariable());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding8 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding8 = null;
        }
        fragmentHttpRequestSettingsBinding8.responseCodeVariableSpinner.setEnabled(httpRequestConfig.getSaveReturnCodeToVariable());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding9 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding9 = null;
        }
        NDSpinner nDSpinner = fragmentHttpRequestSettingsBinding9.responseCodeVariableSpinner;
        float f6 = 1.0f;
        if (httpRequestConfig.getSaveReturnCodeToVariable()) {
            f4 = 1.0f;
        } else {
            f4 = 0.4f;
        }
        nDSpinner.setAlpha(f4);
        this.f3056d = httpRequestConfig.getReturnCodeVariableName();
        this.f3057e = httpRequestConfig.getReturnCodeDictionaryKeys();
        this.f3058f = httpRequestConfig.getResponseVariableName();
        this.f3059g = httpRequestConfig.getResponseDictionaryKeys();
        if (httpRequestConfig.getSaveReturnCodeToVariable()) {
            FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding10 = this.f3054b;
            if (fragmentHttpRequestSettingsBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHttpRequestSettingsBinding10 = null;
            }
            NDSpinner nDSpinner2 = fragmentHttpRequestSettingsBinding10.responseCodeVariableSpinner;
            Intrinsics.checkNotNullExpressionValue(nDSpinner2, "binding.responseCodeVariableSpinner");
            h(nDSpinner2, httpRequestAction);
        }
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding11 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding11 = null;
        }
        LinearLayout linearLayout = fragmentHttpRequestSettingsBinding11.responseCodeSelectionLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.responseCodeSelectionLayout");
        int i6 = 8;
        boolean z8 = false;
        if (httpRequestConfig.getSaveReturnCodeToVariable()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        linearLayout.setVisibility(i4);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding12 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding12 = null;
        }
        CheckBox checkBox = fragmentHttpRequestSettingsBinding12.saveHttpResponseCodeCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.saveHttpResponseCodeCheckbox");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox, (CoroutineContext) null, new b(httpRequestAction, null), 1, (Object) null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding13 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding13 = null;
        }
        Button button = fragmentHttpRequestSettingsBinding13.addIntegerVariableButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.addIntegerVariableButton");
        ViewExtensionsKt.onClick$default(button, null, new c(httpRequestAction, null), 1, null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding14 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding14 = null;
        }
        RadioButton radioButton = fragmentHttpRequestSettingsBinding14.dontSaveResponseRadioButton;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.dontSaveResponseRadioButton");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton, (CoroutineContext) null, new d(null), 1, (Object) null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding15 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding15 = null;
        }
        RadioButton radioButton2 = fragmentHttpRequestSettingsBinding15.saveResponseInVariableRadioButton;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.saveResponseInVariableRadioButton");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton2, (CoroutineContext) null, new e(httpRequestAction, null), 1, (Object) null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding16 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding16 = null;
        }
        RadioButton radioButton3 = fragmentHttpRequestSettingsBinding16.saveResponseInFileRadioButton;
        Intrinsics.checkNotNullExpressionValue(radioButton3, "binding.saveResponseInFileRadioButton");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton3, (CoroutineContext) null, new f(null), 1, (Object) null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding17 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding17 = null;
        }
        RadioButton radioButton4 = fragmentHttpRequestSettingsBinding17.dontSaveResponseRadioButton;
        if (httpRequestConfig.getSaveResponseType() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton4.setChecked(z3);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding18 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding18 = null;
        }
        RadioButton radioButton5 = fragmentHttpRequestSettingsBinding18.saveResponseInVariableRadioButton;
        if (httpRequestConfig.getSaveResponseType() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        radioButton5.setChecked(z4);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding19 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding19 = null;
        }
        RadioButton radioButton6 = fragmentHttpRequestSettingsBinding19.saveResponseInFileRadioButton;
        if (httpRequestConfig.getSaveResponseType() == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        radioButton6.setChecked(z5);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding20 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding20 = null;
        }
        LinearLayout linearLayout2 = fragmentHttpRequestSettingsBinding20.responseVariableLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.responseVariableLayout");
        if (httpRequestConfig.getSaveResponseType() == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        linearLayout2.setVisibility(i5);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding21 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding21 = null;
        }
        LinearLayout linearLayout3 = fragmentHttpRequestSettingsBinding21.responseFileLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.responseFileLayout");
        if (httpRequestConfig.getSaveResponseType() == 2) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            i6 = 0;
        }
        linearLayout3.setVisibility(i6);
        if (httpRequestConfig.getSaveResponseType() == 1) {
            FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding22 = this.f3054b;
            if (fragmentHttpRequestSettingsBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHttpRequestSettingsBinding22 = null;
            }
            NDSpinner nDSpinner3 = fragmentHttpRequestSettingsBinding22.httpResponseVariableSpinner;
            Intrinsics.checkNotNullExpressionValue(nDSpinner3, "binding.httpResponseVariableSpinner");
            i(nDSpinner3, httpRequestAction);
        }
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding23 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding23 = null;
        }
        Button button2 = fragmentHttpRequestSettingsBinding23.addStringVariableButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.addStringVariableButton");
        ViewExtensionsKt.onClick$default(button2, null, new g(httpRequestAction, null), 1, null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding24 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding24 = null;
        }
        fragmentHttpRequestSettingsBinding24.followRedirectsCheckbox.setChecked(httpRequestConfig.getFollowRedirects());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding25 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding25 = null;
        }
        fragmentHttpRequestSettingsBinding25.basicAuthCheckbox.setChecked(httpRequestConfig.getBasicAuthEnabled());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding26 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding26 = null;
        }
        fragmentHttpRequestSettingsBinding26.basicAuthUsername.setText(httpRequestConfig.getBasicAuthUsername());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding27 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding27 = null;
        }
        fragmentHttpRequestSettingsBinding27.basicAuthUsername.setEnabled(httpRequestConfig.getBasicAuthEnabled());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding28 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding28 = null;
        }
        fragmentHttpRequestSettingsBinding28.basicAuthUsernameMagicTextButton.setEnabled(httpRequestConfig.getBasicAuthEnabled());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding29 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding29 = null;
        }
        Button button3 = fragmentHttpRequestSettingsBinding29.basicAuthUsernameMagicTextButton;
        if (httpRequestConfig.getBasicAuthEnabled()) {
            f5 = 1.0f;
        } else {
            f5 = 0.4f;
        }
        button3.setAlpha(f5);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding30 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding30 = null;
        }
        fragmentHttpRequestSettingsBinding30.basicAuthPassword.setText(httpRequestConfig.getBasicAuthPassword());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding31 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding31 = null;
        }
        fragmentHttpRequestSettingsBinding31.basicAuthPassword.setEnabled(httpRequestConfig.getBasicAuthEnabled());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding32 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding32 = null;
        }
        fragmentHttpRequestSettingsBinding32.basicAuthPasswordMagicTextButton.setEnabled(httpRequestConfig.getBasicAuthEnabled());
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding33 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding33 = null;
        }
        Button button4 = fragmentHttpRequestSettingsBinding33.basicAuthPasswordMagicTextButton;
        if (!httpRequestConfig.getBasicAuthEnabled()) {
            f6 = 0.4f;
        }
        button4.setAlpha(f6);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding34 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding34 = null;
        }
        TextView textView = fragmentHttpRequestSettingsBinding34.saveResponsePath;
        String saveResponseFolderPathDisplayName2 = httpRequestConfig.getSaveResponseFolderPathDisplayName();
        if ((saveResponseFolderPathDisplayName2 == null || saveResponseFolderPathDisplayName2.length() == 0) ? true : true) {
            saveResponseFolderPathDisplayName = "[" + getString(R.string.action_write_to_file_select_folder) + "]";
        } else {
            saveResponseFolderPathDisplayName = httpRequestConfig.getSaveResponseFolderPathDisplayName();
        }
        textView.setText(saveResponseFolderPathDisplayName);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding35 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHttpRequestSettingsBinding2 = fragmentHttpRequestSettingsBinding35;
        }
        fragmentHttpRequestSettingsBinding2.saveResponseFilename.setText(httpRequestConfig.getSaveResponseFileName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final Spinner spinner, HttpRequestAction httpRequestAction) {
        String str;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Macro macro = this.f3055c;
        ArrayList arrayList = new ArrayList();
        String str2 = this.f3056d;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.f3057e);
        } else {
            str = null;
        }
        VariableHelper.configureNumberVarSpinner(requireActivity, R.style.Theme_App_Dialog_Action, httpRequestAction, spinner, macro, arrayList, str, "", true, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment$initialiseResponseCodeVariableSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                HttpRequestSettingsFragment.this.getViewModel().setSaveHttpResponseCodeVariableName(variable.getName(), list);
                spinner.setEnabled(true);
                spinner.setAlpha(1.0f);
                HttpRequestSettingsFragment.this.f3056d = variable.getName();
                HttpRequestSettingsFragment httpRequestSettingsFragment = HttpRequestSettingsFragment.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                httpRequestSettingsFragment.f3057e = dictionaryKeys;
            }
        });
        if (spinner.getCount() == 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(getString(R.string.trigger_variable_no_variables));
            ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), 17367048, arrayList2);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(final Spinner spinner, HttpRequestAction httpRequestAction) {
        String str;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Macro macro = this.f3055c;
        ArrayList arrayList = new ArrayList();
        String str2 = this.f3058f;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.f3059g);
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(requireActivity, R.style.Theme_App_Dialog_Action, httpRequestAction, spinner, macro, arrayList, str, true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment$initialiseResponseTextVariableSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                HttpRequestSettingsFragment.this.getViewModel().setSaveHttpResponseVariableName(variable.getName(), list);
                spinner.setEnabled(true);
                HttpRequestSettingsFragment.this.f3058f = variable.getName();
                HttpRequestSettingsFragment httpRequestSettingsFragment = HttpRequestSettingsFragment.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                httpRequestSettingsFragment.f3059g = dictionaryKeys;
            }
        });
        if (spinner.getCount() == 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(getString(R.string.trigger_variable_no_variables));
            ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), 17367048, arrayList2);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    private final void j() {
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = this.f3054b;
        if (fragmentHttpRequestSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding = null;
        }
        fragmentHttpRequestSettingsBinding.requestTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment$initialiseUi$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@NotNull AdapterView<?> parent, @Nullable View view, int i4, long j4) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                HttpRequestSettingsFragment.this.getViewModel().setRequestType(i4);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@NotNull AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding2 = null;
        }
        CheckBox checkBox = fragmentHttpRequestSettingsBinding2.blockNextActionCheckBox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.blockNextActionCheckBox");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox, (CoroutineContext) null, new l(null), 1, (Object) null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding3 = null;
        }
        CheckBox checkBox2 = fragmentHttpRequestSettingsBinding3.allowAnyCertificateCheckBox;
        Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.allowAnyCertificateCheckBox");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox2, (CoroutineContext) null, new m(null), 1, (Object) null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding4 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding4 = null;
        }
        CheckBox checkBox3 = fragmentHttpRequestSettingsBinding4.followRedirectsCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox3, "binding.followRedirectsCheckbox");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox3, (CoroutineContext) null, new n(null), 1, (Object) null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding5 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding5 = null;
        }
        TextInputEditText textInputEditText = fragmentHttpRequestSettingsBinding5.url;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.url");
        textInputEditText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment$initialiseUi$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                HttpRequestConfigViewModel viewModel = HttpRequestSettingsFragment.this.getViewModel();
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding6 = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestSettingsBinding6 = null;
                }
                viewModel.setUrlText(String.valueOf(fragmentHttpRequestSettingsBinding6.url.getText()));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding6 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding6 = null;
        }
        CheckBox checkBox4 = fragmentHttpRequestSettingsBinding6.basicAuthCheckbox;
        Intrinsics.checkNotNullExpressionValue(checkBox4, "binding.basicAuthCheckbox");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox4, (CoroutineContext) null, new o(null), 1, (Object) null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding7 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding7 = null;
        }
        EditText editText = fragmentHttpRequestSettingsBinding7.basicAuthUsername;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.basicAuthUsername");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment$initialiseUi$$inlined$addTextChangedListener$default$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                HttpRequestConfigViewModel viewModel = HttpRequestSettingsFragment.this.getViewModel();
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding8 = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestSettingsBinding8 = null;
                }
                viewModel.setBasicAuthUsername(fragmentHttpRequestSettingsBinding8.basicAuthUsername.getText().toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding8 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding8 = null;
        }
        EditText editText2 = fragmentHttpRequestSettingsBinding8.basicAuthPassword;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.basicAuthPassword");
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment$initialiseUi$$inlined$addTextChangedListener$default$3
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                HttpRequestConfigViewModel viewModel = HttpRequestSettingsFragment.this.getViewModel();
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding9 = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestSettingsBinding9 = null;
                }
                viewModel.setBasicAuthPassword(fragmentHttpRequestSettingsBinding9.basicAuthPassword.getText().toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.h
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                HttpRequestSettingsFragment.k(HttpRequestSettingsFragment.this, magicTextPair);
            }
        };
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding9 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding9 = null;
        }
        Button button = fragmentHttpRequestSettingsBinding9.urlMagicTextButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.urlMagicTextButton");
        ViewExtensionsKt.onClick$default(button, null, new p(magicTextListener, null), 1, null);
        MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.i
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                HttpRequestSettingsFragment.l(HttpRequestSettingsFragment.this, magicTextPair);
            }
        };
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding10 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding10 = null;
        }
        Button button2 = fragmentHttpRequestSettingsBinding10.basicAuthUsernameMagicTextButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.basicAuthUsernameMagicTextButton");
        ViewExtensionsKt.onClick$default(button2, null, new h(magicTextListener2, null), 1, null);
        MagicText.MagicTextListener magicTextListener3 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.j
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                HttpRequestSettingsFragment.m(HttpRequestSettingsFragment.this, magicTextPair);
            }
        };
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding11 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding11 = null;
        }
        Button button3 = fragmentHttpRequestSettingsBinding11.basicAuthPasswordMagicTextButton;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.basicAuthPasswordMagicTextButton");
        ViewExtensionsKt.onClick$default(button3, null, new i(magicTextListener3, null), 1, null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding12 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding12 = null;
        }
        EditText editText3 = fragmentHttpRequestSettingsBinding12.saveResponseFilename;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.saveResponseFilename");
        editText3.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment$initialiseUi$$inlined$addTextChangedListener$default$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                HttpRequestConfigViewModel viewModel = HttpRequestSettingsFragment.this.getViewModel();
                FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding13 = HttpRequestSettingsFragment.this.f3054b;
                if (fragmentHttpRequestSettingsBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestSettingsBinding13 = null;
                }
                viewModel.setSaveResponseFilename(fragmentHttpRequestSettingsBinding13.saveResponseFilename.getText().toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding13 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding13 = null;
        }
        EditText editText4 = fragmentHttpRequestSettingsBinding13.timeoutSecondsText;
        Intrinsics.checkNotNullExpressionValue(editText4, "binding.timeoutSecondsText");
        editText4.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment$initialiseUi$$inlined$addTextChangedListener$default$5
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                int i4;
                try {
                    FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding14 = HttpRequestSettingsFragment.this.f3054b;
                    if (fragmentHttpRequestSettingsBinding14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestSettingsBinding14 = null;
                    }
                    i4 = Integer.parseInt(fragmentHttpRequestSettingsBinding14.timeoutSecondsText.getText().toString());
                } catch (Exception unused) {
                    i4 = 0;
                }
                HttpRequestSettingsFragment.this.getViewModel().setTimeoutSeconds(i4);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        MagicText.MagicTextListener magicTextListener4 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.k
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                HttpRequestSettingsFragment.n(HttpRequestSettingsFragment.this, magicTextPair);
            }
        };
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding14 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding14 = null;
        }
        Button button4 = fragmentHttpRequestSettingsBinding14.saveResponseFilenameMagicTextButton;
        Intrinsics.checkNotNullExpressionValue(button4, "binding.saveResponseFilenameMagicTextButton");
        ViewExtensionsKt.onClick$default(button4, null, new j(magicTextListener4, null), 1, null);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding15 = this.f3054b;
        if (fragmentHttpRequestSettingsBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding15 = null;
        }
        ImageButton imageButton = fragmentHttpRequestSettingsBinding15.selectFolderButton;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.selectFolderButton");
        ViewExtensionsKt.onClick$default(imageButton, null, new k(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(HttpRequestSettingsFragment this$0, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = this$0.f3054b;
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = null;
        if (fragmentHttpRequestSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding = null;
        }
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestSettingsBinding.url.getSelectionStart(), 0);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = this$0.f3054b;
        if (fragmentHttpRequestSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding3 = null;
        }
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestSettingsBinding3.url.getSelectionEnd(), 0);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding4 = this$0.f3054b;
        if (fragmentHttpRequestSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHttpRequestSettingsBinding2 = fragmentHttpRequestSettingsBinding4;
        }
        Editable text = fragmentHttpRequestSettingsBinding2.url.getText();
        if (text != null) {
            coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
            coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
            String str = magicTextPair.magicText;
            text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(HttpRequestSettingsFragment this$0, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = this$0.f3054b;
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = null;
        if (fragmentHttpRequestSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding = null;
        }
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestSettingsBinding.basicAuthUsername.getSelectionStart(), 0);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = this$0.f3054b;
        if (fragmentHttpRequestSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding3 = null;
        }
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestSettingsBinding3.basicAuthUsername.getSelectionEnd(), 0);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding4 = this$0.f3054b;
        if (fragmentHttpRequestSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHttpRequestSettingsBinding2 = fragmentHttpRequestSettingsBinding4;
        }
        Editable text = fragmentHttpRequestSettingsBinding2.basicAuthUsername.getText();
        if (text != null) {
            coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
            coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
            String str = magicTextPair.magicText;
            text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(HttpRequestSettingsFragment this$0, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = this$0.f3054b;
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = null;
        if (fragmentHttpRequestSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding = null;
        }
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestSettingsBinding.basicAuthPassword.getSelectionStart(), 0);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = this$0.f3054b;
        if (fragmentHttpRequestSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding3 = null;
        }
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestSettingsBinding3.basicAuthPassword.getSelectionEnd(), 0);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding4 = this$0.f3054b;
        if (fragmentHttpRequestSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHttpRequestSettingsBinding2 = fragmentHttpRequestSettingsBinding4;
        }
        Editable text = fragmentHttpRequestSettingsBinding2.basicAuthPassword.getText();
        if (text != null) {
            coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
            coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
            String str = magicTextPair.magicText;
            text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(HttpRequestSettingsFragment this$0, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = this$0.f3054b;
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding2 = null;
        if (fragmentHttpRequestSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding = null;
        }
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestSettingsBinding.saveResponseFilename.getSelectionStart(), 0);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding3 = this$0.f3054b;
        if (fragmentHttpRequestSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding3 = null;
        }
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestSettingsBinding3.saveResponseFilename.getSelectionEnd(), 0);
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding4 = this$0.f3054b;
        if (fragmentHttpRequestSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHttpRequestSettingsBinding2 = fragmentHttpRequestSettingsBinding4;
        }
        Editable text = fragmentHttpRequestSettingsBinding2.saveResponseFilename.getText();
        if (text != null) {
            coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
            coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
            String str = magicTextPair.magicText;
            text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
        }
    }

    @NotNull
    public final HttpRequestConfigViewModel getViewModel() {
        HttpRequestConfigViewModel httpRequestConfigViewModel = this.viewModel;
        if (httpRequestConfigViewModel != null) {
            return httpRequestConfigViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        String str;
        if (i4 == 0 && i5 == -1) {
            Intrinsics.checkNotNull(intent);
            Uri data = intent.getData();
            Intrinsics.checkNotNull(data);
            requireContext().getContentResolver().takePersistableUriPermission(data, 3);
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(requireContext(), data);
            DocumentFile documentFileParent = Util.getDocumentFileParent(fromTreeUri);
            if (documentFileParent != null) {
                str = documentFileParent.getName();
            } else {
                str = "";
            }
            Intrinsics.checkNotNull(fromTreeUri);
            String str2 = str + RemoteSettings.FORWARD_SLASH_STRING + fromTreeUri.getName();
            FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = this.f3054b;
            if (fragmentHttpRequestSettingsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHttpRequestSettingsBinding = null;
            }
            fragmentHttpRequestSettingsBinding.saveResponsePath.setText(str2);
            HttpRequestConfigViewModel viewModel = getViewModel();
            String uri = data.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
            viewModel.setSaveResponseInFolderDetails(uri, str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        long j4;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentHttpRequestSettingsBinding inflate = FragmentHttpRequestSettingsBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f3054b = inflate;
        Bundle arguments = getArguments();
        if (arguments != null) {
            j4 = arguments.getLong(Constants.EXTRA_MACRO_GUID);
        } else {
            j4 = 0;
        }
        this.f3055c = MacroStore.getInstance().getMacroByGUID(j4);
        j();
        f();
        FragmentHttpRequestSettingsBinding fragmentHttpRequestSettingsBinding = this.f3054b;
        if (fragmentHttpRequestSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestSettingsBinding = null;
        }
        return fragmentHttpRequestSettingsBinding.getRoot();
    }

    public final void setViewModel(@NotNull HttpRequestConfigViewModel httpRequestConfigViewModel) {
        Intrinsics.checkNotNullParameter(httpRequestConfigViewModel, "<set-?>");
        this.viewModel = httpRequestConfigViewModel;
    }
}
