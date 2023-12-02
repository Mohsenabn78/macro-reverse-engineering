package com.arlosoft.macrodroid.action.activities.httprequest;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.HttpParam;
import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestParamsFragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.databinding.FragmentHttpRequestParamListBinding;
import com.arlosoft.macrodroid.databinding.ListItemHttpRequestParamBinding;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestParamsFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nHttpRequestParamsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestParamsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestParamsFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,266:1\n262#2,2:267\n262#2,2:269\n262#2,2:271\n262#2,2:273\n*S KotlinDebug\n*F\n+ 1 HttpRequestParamsFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestParamsFragment\n*L\n97#1:267,2\n98#1:269,2\n100#1:271,2\n101#1:273,2\n*E\n"})
/* loaded from: classes2.dex */
public final class HttpRequestParamsFragment extends MacroDroidDaggerBaseFragment implements ParamSelectedListener {

    /* renamed from: b  reason: collision with root package name */
    private FragmentHttpRequestParamListBinding f3043b;

    /* renamed from: c  reason: collision with root package name */
    private ParamType f3044c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Macro f3045d;
    @Inject
    public HttpRequestConfigViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HttpRequestParamsFragment newInstance(@NotNull ParamType paramType, long j4) {
            Intrinsics.checkNotNullParameter(paramType, "paramType");
            HttpRequestParamsFragment httpRequestParamsFragment = new HttpRequestParamsFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("param_Type", paramType);
            bundle.putLong(Constants.EXTRA_MACRO_GUID, j4);
            httpRequestParamsFragment.setArguments(bundle);
            return httpRequestParamsFragment;
        }
    }

    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public final class ParamListAdapter extends RecyclerView.Adapter<ParamsViewHolder> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final List<HttpParam> f3046a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final ParamSelectedListener f3047b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ HttpRequestParamsFragment f3048c;

        /* compiled from: HttpRequestParamsFragment.kt */
        /* loaded from: classes2.dex */
        public final class ParamsViewHolder extends RecyclerView.ViewHolder {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final ListItemHttpRequestParamBinding f3049a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ParamListAdapter f3050b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: HttpRequestParamsFragment.kt */
            /* loaded from: classes2.dex */
            public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
                final /* synthetic */ HttpParam $param;
                int label;
                final /* synthetic */ ParamListAdapter this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(ParamListAdapter paramListAdapter, HttpParam httpParam, Continuation<? super a> continuation) {
                    super(3, continuation);
                    this.this$0 = paramListAdapter;
                    this.$param = httpParam;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                /* renamed from: a */
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                    return new a(this.this$0, this.$param, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.f3047b.onParamSelected(this.$param);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ParamsViewHolder(@NotNull ParamListAdapter paramListAdapter, ListItemHttpRequestParamBinding binding) {
                super(binding.getRoot());
                Intrinsics.checkNotNullParameter(binding, "binding");
                this.f3050b = paramListAdapter;
                this.f3049a = binding;
            }

            public final void bind(@NotNull HttpParam param) {
                Intrinsics.checkNotNullParameter(param, "param");
                this.f3049a.paramName.setText(param.getParamName());
                this.f3049a.paramValue.setText(param.getParamValue());
                LinearLayout linearLayout = this.f3049a.container;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.container");
                ViewExtensionsKt.onClick$default(linearLayout, null, new a(this.f3050b, param, null), 1, null);
            }
        }

        public ParamListAdapter(@NotNull HttpRequestParamsFragment httpRequestParamsFragment, @NotNull List<HttpParam> params, ParamSelectedListener paramSelectedListener) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(paramSelectedListener, "paramSelectedListener");
            this.f3048c = httpRequestParamsFragment;
            this.f3046a = params;
            this.f3047b = paramSelectedListener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f3046a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull ParamsViewHolder holder, int i4) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.bind(this.f3046a.get(i4));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public ParamsViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ListItemHttpRequestParamBinding inflate = ListItemHttpRequestParamBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
            return new ParamsViewHolder(this, inflate);
        }
    }

    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public enum ParamType {
        HEADER_PARAMS,
        QUERY_PARAMS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HttpRequestParamsFragment.this.j();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<HttpParam, Unit> {
        final /* synthetic */ HttpParam $param;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(HttpParam httpParam) {
            super(1);
            this.$param = httpParam;
        }

        public final void a(@NotNull HttpParam newPair) {
            Intrinsics.checkNotNullParameter(newPair, "newPair");
            HttpRequestConfigViewModel viewModel = HttpRequestParamsFragment.this.getViewModel();
            ParamType paramType = HttpRequestParamsFragment.this.f3044c;
            if (paramType == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paramType");
                paramType = null;
            }
            viewModel.updateParam(paramType, this.$param, newPair);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpParam httpParam) {
            a(httpParam);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f3052a;

        c(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f3052a = function;
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
            return this.f3052a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f3052a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends Lambda implements Function1<HttpParam, Unit> {
        d() {
            super(1);
        }

        public final void a(@NotNull HttpParam param) {
            Intrinsics.checkNotNullParameter(param, "param");
            HttpRequestConfigViewModel viewModel = HttpRequestParamsFragment.this.getViewModel();
            ParamType paramType = HttpRequestParamsFragment.this.f3044c;
            if (paramType == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paramType");
                paramType = null;
            }
            viewModel.addParam(paramType, param);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpParam httpParam) {
            a(httpParam);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $nameMagicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(MagicText.MagicTextListener magicTextListener, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$nameMagicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$nameMagicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(HttpRequestParamsFragment.this.getActivity(), this.$nameMagicTextListener, HttpRequestParamsFragment.this.f3045d, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $valueMagicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(MagicText.MagicTextListener magicTextListener, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$valueMagicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$valueMagicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(HttpRequestParamsFragment.this.getActivity(), this.$valueMagicTextListener, HttpRequestParamsFragment.this.f3045d, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ HttpParam $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(HttpParam httpParam, AppCompatDialog appCompatDialog, Continuation<? super g> continuation) {
            super(3, continuation);
            this.$param = httpParam;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(this.$param, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HttpRequestParamsFragment httpRequestParamsFragment = HttpRequestParamsFragment.this;
                FragmentActivity requireActivity = httpRequestParamsFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                ParamType paramType = HttpRequestParamsFragment.this.f3044c;
                if (paramType == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paramType");
                    paramType = null;
                }
                httpRequestParamsFragment.g(requireActivity, paramType, this.$param, this.$dialog);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ Function1<HttpParam, Unit> $handleOk;
        final /* synthetic */ EditText $paramName;
        final /* synthetic */ EditText $paramValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        h(EditText editText, EditText editText2, Function1<? super HttpParam, Unit> function1, AppCompatDialog appCompatDialog, Continuation<? super h> continuation) {
            super(3, continuation);
            this.$paramName = editText;
            this.$paramValue = editText2;
            this.$handleOk = function1;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(this.$paramName, this.$paramValue, this.$handleOk, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Editable text = this.$paramName.getText();
                Intrinsics.checkNotNullExpressionValue(text, "paramName.text");
                boolean z4 = true;
                if (text.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    Editable text2 = this.$paramValue.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "paramValue.text");
                    if (text2.length() <= 0) {
                        z4 = false;
                    }
                    if (z4) {
                        this.$handleOk.invoke(new HttpParam(this.$paramName.getText().toString(), this.$paramValue.getText().toString()));
                        this.$dialog.dismiss();
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestParamsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(AppCompatDialog appCompatDialog, Continuation<? super i> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new i(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    private final void e(final ParamType paramType) {
        getViewModel().getHttpRequestConfig().observe(getViewLifecycleOwner(), new c(new Function1<HttpRequestConfigAndAction, Unit>() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestParamsFragment$bindViewModel$1

            /* compiled from: HttpRequestParamsFragment.kt */
            /* loaded from: classes2.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[HttpRequestParamsFragment.ParamType.values().length];
                    try {
                        iArr[HttpRequestParamsFragment.ParamType.HEADER_PARAMS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[HttpRequestParamsFragment.ParamType.QUERY_PARAMS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(HttpRequestConfigAndAction httpRequestConfigAndAction) {
                int i4 = WhenMappings.$EnumSwitchMapping$0[HttpRequestParamsFragment.ParamType.this.ordinal()];
                if (i4 == 1) {
                    this.i(httpRequestConfigAndAction.getRequestConfig().getHeaderParams(), HttpRequestParamsFragment.ParamType.this);
                } else if (i4 == 2) {
                    this.i(httpRequestConfigAndAction.getRequestConfig().getQueryParams(), HttpRequestParamsFragment.ParamType.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestConfigAndAction httpRequestConfigAndAction) {
                a(httpRequestConfigAndAction);
                return Unit.INSTANCE;
            }
        }));
    }

    private final void f() {
        FragmentHttpRequestParamListBinding fragmentHttpRequestParamListBinding = this.f3043b;
        if (fragmentHttpRequestParamListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestParamListBinding = null;
        }
        FloatingActionButton floatingActionButton = fragmentHttpRequestParamListBinding.addParamButton;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.addParamButton");
        ViewExtensionsKt.onClick$default(floatingActionButton, null, new a(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Activity activity, final ParamType paramType, final HttpParam httpParam, final Dialog dialog) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog_Action);
        builder.setTitle(R.string.delete);
        builder.setMessage(activity.getString(R.string.http_request_confirm_delete_parameter));
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                HttpRequestParamsFragment.h(HttpRequestParamsFragment.this, paramType, httpParam, dialog, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(HttpRequestParamsFragment this$0, ParamType paramType, HttpParam param, Dialog dialogToClose, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paramType, "$paramType");
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(dialogToClose, "$dialogToClose");
        this$0.getViewModel().deleteParam(paramType, param);
        dialogToClose.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(List<HttpParam> list, ParamType paramType) {
        FragmentHttpRequestParamListBinding fragmentHttpRequestParamListBinding = null;
        if (list.isEmpty()) {
            FragmentHttpRequestParamListBinding fragmentHttpRequestParamListBinding2 = this.f3043b;
            if (fragmentHttpRequestParamListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHttpRequestParamListBinding2 = null;
            }
            TextView textView = fragmentHttpRequestParamListBinding2.emptyView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.emptyView");
            textView.setVisibility(0);
            FragmentHttpRequestParamListBinding fragmentHttpRequestParamListBinding3 = this.f3043b;
            if (fragmentHttpRequestParamListBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentHttpRequestParamListBinding = fragmentHttpRequestParamListBinding3;
            }
            RecyclerView recyclerView = fragmentHttpRequestParamListBinding.paramsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.paramsRecyclerView");
            recyclerView.setVisibility(8);
            return;
        }
        FragmentHttpRequestParamListBinding fragmentHttpRequestParamListBinding4 = this.f3043b;
        if (fragmentHttpRequestParamListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestParamListBinding4 = null;
        }
        TextView textView2 = fragmentHttpRequestParamListBinding4.emptyView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.emptyView");
        textView2.setVisibility(8);
        FragmentHttpRequestParamListBinding fragmentHttpRequestParamListBinding5 = this.f3043b;
        if (fragmentHttpRequestParamListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestParamListBinding5 = null;
        }
        RecyclerView recyclerView2 = fragmentHttpRequestParamListBinding5.paramsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.paramsRecyclerView");
        recyclerView2.setVisibility(0);
        ParamListAdapter paramListAdapter = new ParamListAdapter(this, list, this);
        FragmentHttpRequestParamListBinding fragmentHttpRequestParamListBinding6 = this.f3043b;
        if (fragmentHttpRequestParamListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHttpRequestParamListBinding = fragmentHttpRequestParamListBinding6;
        }
        fragmentHttpRequestParamListBinding.paramsRecyclerView.setAdapter(paramListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        String string = getString(R.string.http_request_add_parameter);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.http_request_add_parameter)");
        k(null, string, new d());
    }

    private final void k(HttpParam httpParam, String str, Function1<? super HttpParam, Unit> function1) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(requireActivity(), R.style.Theme_App_Dialog_Action_NoTitle);
        appCompatDialog.setContentView(R.layout.dialog_http_request_params);
        int i4 = 0;
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        View findViewById = appCompatDialog.findViewById(R.id.title);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog.findViewById(R.id.paramName);
        Intrinsics.checkNotNull(findViewById2);
        final EditText editText = (EditText) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.paramValue);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText2 = (EditText) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById4);
        Button button = (Button) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById5);
        Button button2 = (Button) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.paramNameMagicTextButton);
        Intrinsics.checkNotNull(findViewById6);
        View findViewById7 = appCompatDialog.findViewById(R.id.paramValueMagicTextButton);
        Intrinsics.checkNotNull(findViewById7);
        View findViewById8 = appCompatDialog.findViewById(R.id.deleteButton);
        Intrinsics.checkNotNull(findViewById8);
        ImageButton imageButton = (ImageButton) findViewById8;
        ((TextView) findViewById).setText(str);
        ViewExtensionsKt.onClick$default((Button) findViewById6, null, new e(new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.f
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                HttpRequestParamsFragment.l(editText, magicTextPair);
            }
        }, null), 1, null);
        ViewExtensionsKt.onClick$default((Button) findViewById7, null, new f(new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.g
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                HttpRequestParamsFragment.m(editText2, magicTextPair);
            }
        }, null), 1, null);
        if (httpParam == null) {
            i4 = 4;
        }
        imageButton.setVisibility(i4);
        if (httpParam != null) {
            editText.setText(httpParam.getParamName());
            editText2.setText(httpParam.getParamValue());
            ViewExtensionsKt.onClick$default(imageButton, null, new g(httpParam, appCompatDialog, null), 1, null);
        }
        ViewExtensionsKt.setCursorAtEnd(editText);
        ViewExtensionsKt.setCursorAtEnd(editText2);
        ViewExtensionsKt.onClick$default(button, null, new h(editText, editText2, function1, appCompatDialog, null), 1, null);
        ViewExtensionsKt.onClick$default(button2, null, new i(appCompatDialog, null), 1, null);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(EditText paramName, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        Intrinsics.checkNotNullParameter(paramName, "$paramName");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(paramName.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(paramName.getSelectionEnd(), 0);
        Editable text = paramName.getText();
        if (text != null) {
            int min = Math.min(coerceAtLeast, coerceAtLeast2);
            int max = Math.max(coerceAtLeast, coerceAtLeast2);
            String str = magicTextPair.magicText;
            text.replace(min, max, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(EditText paramValue, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(paramValue, "$paramValue");
        int max = Math.max(paramValue.getSelectionStart(), 0);
        int max2 = Math.max(paramValue.getSelectionEnd(), 0);
        Editable text = paramValue.getText();
        if (text != null) {
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            String str = magicTextPair.magicText;
            text.replace(min, max3, str, 0, str.length());
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
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Serializable serializable;
        long j4;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentHttpRequestParamListBinding inflate = FragmentHttpRequestParamListBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f3043b = inflate;
        Bundle arguments = getArguments();
        if (arguments == null || (serializable = arguments.getSerializable("param_Type")) == null) {
            serializable = ParamType.HEADER_PARAMS;
        }
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestParamsFragment.ParamType");
        this.f3044c = (ParamType) serializable;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            j4 = arguments2.getLong(Constants.EXTRA_MACRO_GUID);
        } else {
            j4 = 0;
        }
        this.f3045d = MacroStore.getInstance().getMacroByGUID(j4);
        ParamType paramType = this.f3044c;
        FragmentHttpRequestParamListBinding fragmentHttpRequestParamListBinding = null;
        if (paramType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paramType");
            paramType = null;
        }
        e(paramType);
        f();
        FragmentHttpRequestParamListBinding fragmentHttpRequestParamListBinding2 = this.f3043b;
        if (fragmentHttpRequestParamListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHttpRequestParamListBinding = fragmentHttpRequestParamListBinding2;
        }
        return fragmentHttpRequestParamListBinding.getRoot();
    }

    @Override // com.arlosoft.macrodroid.action.activities.httprequest.ParamSelectedListener
    public void onParamSelected(@NotNull HttpParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        String string = getString(R.string.http_request_edit_parameter);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.http_request_edit_parameter)");
        k(param, string, new b(param));
    }

    public final void setViewModel(@NotNull HttpRequestConfigViewModel httpRequestConfigViewModel) {
        Intrinsics.checkNotNullParameter(httpRequestConfigViewModel, "<set-?>");
        this.viewModel = httpRequestConfigViewModel;
    }
}
