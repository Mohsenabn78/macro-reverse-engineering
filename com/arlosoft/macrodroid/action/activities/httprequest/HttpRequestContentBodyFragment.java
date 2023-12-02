package com.arlosoft.macrodroid.action.activities.httprequest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.Observer;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.HttpRequestConfig;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.databinding.FragmentHttpRequestContentBodyBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
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

/* compiled from: HttpRequestContentBodyFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nHttpRequestContentBodyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestContentBodyFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestContentBodyFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,174:1\n262#2,2:175\n262#2,2:177\n262#2,2:179\n262#2,2:219\n262#2,2:221\n65#3,16:181\n93#3,3:197\n65#3,16:200\n93#3,3:216\n*S KotlinDebug\n*F\n+ 1 HttpRequestContentBodyFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestContentBodyFragment\n*L\n124#1:175,2\n129#1:177,2\n132#1:179,2\n170#1:219,2\n171#1:221,2\n162#1:181,16\n162#1:197,3\n166#1:200,16\n166#1:216,3\n*E\n"})
/* loaded from: classes2.dex */
public final class HttpRequestContentBodyFragment extends MacroDroidDaggerBaseFragment {
    public static final int REQUEST_CODE_PICK_FILE = 0;
    public static final int VIEW_FLIPPER_INDEX_CONTENT = 1;
    public static final int VIEW_FLIPPER_INDEX_NO_CONTENT = 0;

    /* renamed from: b  reason: collision with root package name */
    private FragmentHttpRequestContentBodyBinding f3035b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Macro f3036c;
    @Inject
    public HttpRequestConfigViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HttpRequestContentBodyFragment.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HttpRequestContentBodyFragment newInstance(long j4) {
            HttpRequestContentBodyFragment httpRequestContentBodyFragment = new HttpRequestContentBodyFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(Constants.EXTRA_MACRO_GUID, j4);
            httpRequestContentBodyFragment.setArguments(bundle);
            return httpRequestContentBodyFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestContentBodyFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<HttpRequestConfigAndAction, Unit> {
        a() {
            super(1);
        }

        public final void a(HttpRequestConfigAndAction httpRequestConfigAndAction) {
            HttpRequestContentBodyFragment.this.e(httpRequestConfigAndAction.getRequestConfig());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpRequestConfigAndAction httpRequestConfigAndAction) {
            a(httpRequestConfigAndAction);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestContentBodyFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MagicText.MagicTextListener $bodyMagicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MagicText.MagicTextListener magicTextListener, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$bodyMagicTextListener = magicTextListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$bodyMagicTextListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(HttpRequestContentBodyFragment.this.getActivity(), this.$bodyMagicTextListener, HttpRequestContentBodyFragment.this.f3036c, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestContentBodyFragment.kt */
    @SourceDebugExtension({"SMAP\nHttpRequestContentBodyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestContentBodyFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestContentBodyFragment$initialiseUi$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,174:1\n262#2,2:175\n262#2,2:177\n*S KotlinDebug\n*F\n+ 1 HttpRequestContentBodyFragment.kt\ncom/arlosoft/macrodroid/action/activities/httprequest/HttpRequestContentBodyFragment$initialiseUi$2\n*L\n81#1:175,2\n82#1:177,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class c extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        c(Continuation<? super c> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            c cVar = new c(continuation);
            cVar.Z$0 = z3;
            return cVar.invokeSuspend(Unit.INSTANCE);
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
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding = HttpRequestContentBodyFragment.this.f3035b;
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding2 = null;
                if (fragmentHttpRequestContentBodyBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestContentBodyBinding = null;
                }
                LinearLayout linearLayout = fragmentHttpRequestContentBodyBinding.bodyTextLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bodyTextLayout");
                int i5 = 0;
                if (z3) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                linearLayout.setVisibility(i4);
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding3 = HttpRequestContentBodyFragment.this.f3035b;
                if (fragmentHttpRequestContentBodyBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentHttpRequestContentBodyBinding2 = fragmentHttpRequestContentBodyBinding3;
                }
                LinearLayout linearLayout2 = fragmentHttpRequestContentBodyBinding2.bodyFileLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bodyFileLayout");
                if ((!z3 ? 1 : 0) == 0) {
                    i5 = 8;
                }
                linearLayout2.setVisibility(i5);
                HttpRequestContentBodyFragment.this.getViewModel().setContentBodySource(!z3 ? 1 : 0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestContentBodyFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                try {
                    Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType("*/*");
                    HttpRequestContentBodyFragment.this.startActivityForResult(intent, 0);
                } catch (Exception unused) {
                    Context context = HttpRequestContentBodyFragment.this.getContext();
                    Intrinsics.checkNotNull(context);
                    Context applicationContext = context.getApplicationContext();
                    String string = HttpRequestContentBodyFragment.this.getString(R.string.not_supported);
                    ToastCompat.makeText(applicationContext, (CharSequence) ("ACTION_OPEN_DOCUMENT " + string), 0).show();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestContentBodyFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f3041a;

        e(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f3041a = function;
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
            return this.f3041a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f3041a.invoke(obj);
        }
    }

    private final void d() {
        getViewModel().getHttpRequestConfig().observe(getViewLifecycleOwner(), new e(new a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(final HttpRequestConfig httpRequestConfig) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.d
            @Override // java.lang.Runnable
            public final void run() {
                HttpRequestContentBodyFragment.f(HttpRequestContentBodyFragment.this, httpRequestConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final HttpRequestContentBodyFragment this$0, HttpRequestConfig config) {
        boolean z3;
        int indexOf;
        boolean z4;
        boolean z5;
        boolean z6;
        String contentBodyFileDisplayName;
        boolean z7;
        int i4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(config, "$config");
        final String[] stringArray = this$0.getResources().getStringArray(R.array.http_content_types);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…array.http_content_types)");
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding = this$0.f3035b;
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding2 = null;
        if (fragmentHttpRequestContentBodyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding = null;
        }
        fragmentHttpRequestContentBodyBinding.viewFlipper.setDisplayedChild(config.hasBody() ? 1 : 0);
        String contentType = config.getContentType();
        boolean z8 = true;
        int i5 = 0;
        if (contentType != null && contentType.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            indexOf = ArraysKt___ArraysKt.indexOf(stringArray, config.getContentType());
            if (indexOf > 0) {
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding3 = this$0.f3035b;
                if (fragmentHttpRequestContentBodyBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestContentBodyBinding3 = null;
                }
                fragmentHttpRequestContentBodyBinding3.contentTypeSpinner.setSelection(indexOf);
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding4 = this$0.f3035b;
                if (fragmentHttpRequestContentBodyBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestContentBodyBinding4 = null;
                }
                EditText editText = fragmentHttpRequestContentBodyBinding4.contentTypeCustom;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.contentTypeCustom");
                editText.setVisibility(8);
            } else {
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding5 = this$0.f3035b;
                if (fragmentHttpRequestContentBodyBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestContentBodyBinding5 = null;
                }
                fragmentHttpRequestContentBodyBinding5.contentTypeSpinner.setSelection(stringArray.length - 1);
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding6 = this$0.f3035b;
                if (fragmentHttpRequestContentBodyBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestContentBodyBinding6 = null;
                }
                EditText editText2 = fragmentHttpRequestContentBodyBinding6.contentTypeCustom;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.contentTypeCustom");
                editText2.setVisibility(0);
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding7 = this$0.f3035b;
                if (fragmentHttpRequestContentBodyBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestContentBodyBinding7 = null;
                }
                fragmentHttpRequestContentBodyBinding7.contentTypeCustom.setText(config.getContentType());
            }
        } else {
            FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding8 = this$0.f3035b;
            if (fragmentHttpRequestContentBodyBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHttpRequestContentBodyBinding8 = null;
            }
            fragmentHttpRequestContentBodyBinding8.contentTypeSpinner.setSelection(0);
            FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding9 = this$0.f3035b;
            if (fragmentHttpRequestContentBodyBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHttpRequestContentBodyBinding9 = null;
            }
            EditText editText3 = fragmentHttpRequestContentBodyBinding9.contentTypeCustom;
            Intrinsics.checkNotNullExpressionValue(editText3, "binding.contentTypeCustom");
            editText3.setVisibility(8);
        }
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding10 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding10 = null;
        }
        RadioButton radioButton = fragmentHttpRequestContentBodyBinding10.radioButtonText;
        if (config.getContentBodySource() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        radioButton.setChecked(z4);
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding11 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding11 = null;
        }
        RadioButton radioButton2 = fragmentHttpRequestContentBodyBinding11.radioButtonFile;
        if (config.getContentBodySource() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        radioButton2.setChecked(z5);
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding12 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding12 = null;
        }
        fragmentHttpRequestContentBodyBinding12.contentTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestContentBodyFragment$configureUi$1$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@NotNull AdapterView<?> parent, @Nullable View view, int i6, long j4) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding13 = null;
                if (i6 == 0) {
                    FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding14 = HttpRequestContentBodyFragment.this.f3035b;
                    if (fragmentHttpRequestContentBodyBinding14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentHttpRequestContentBodyBinding13 = fragmentHttpRequestContentBodyBinding14;
                    }
                    EditText editText4 = fragmentHttpRequestContentBodyBinding13.contentTypeCustom;
                    Intrinsics.checkNotNullExpressionValue(editText4, "binding.contentTypeCustom");
                    editText4.setVisibility(8);
                    HttpRequestContentBodyFragment.this.getViewModel().setContentType("");
                } else if (i6 == stringArray.length - 1) {
                    FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding15 = HttpRequestContentBodyFragment.this.f3035b;
                    if (fragmentHttpRequestContentBodyBinding15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestContentBodyBinding15 = null;
                    }
                    EditText editText5 = fragmentHttpRequestContentBodyBinding15.contentTypeCustom;
                    Intrinsics.checkNotNullExpressionValue(editText5, "binding.contentTypeCustom");
                    editText5.setVisibility(0);
                    HttpRequestConfigViewModel viewModel = HttpRequestContentBodyFragment.this.getViewModel();
                    FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding16 = HttpRequestContentBodyFragment.this.f3035b;
                    if (fragmentHttpRequestContentBodyBinding16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentHttpRequestContentBodyBinding13 = fragmentHttpRequestContentBodyBinding16;
                    }
                    viewModel.setContentType(fragmentHttpRequestContentBodyBinding13.contentTypeCustom.getText().toString());
                } else {
                    FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding17 = HttpRequestContentBodyFragment.this.f3035b;
                    if (fragmentHttpRequestContentBodyBinding17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentHttpRequestContentBodyBinding17 = null;
                    }
                    EditText editText6 = fragmentHttpRequestContentBodyBinding17.contentTypeCustom;
                    Intrinsics.checkNotNullExpressionValue(editText6, "binding.contentTypeCustom");
                    editText6.setVisibility(8);
                    HttpRequestConfigViewModel viewModel2 = HttpRequestContentBodyFragment.this.getViewModel();
                    FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding18 = HttpRequestContentBodyFragment.this.f3035b;
                    if (fragmentHttpRequestContentBodyBinding18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentHttpRequestContentBodyBinding13 = fragmentHttpRequestContentBodyBinding18;
                    }
                    viewModel2.setContentType(fragmentHttpRequestContentBodyBinding13.contentTypeSpinner.getSelectedItem().toString());
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@NotNull AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding13 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding13 = null;
        }
        EditText editText4 = fragmentHttpRequestContentBodyBinding13.contentTypeCustom;
        Intrinsics.checkNotNullExpressionValue(editText4, "binding.contentTypeCustom");
        editText4.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestContentBodyFragment$configureUi$lambda$3$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                HttpRequestConfigViewModel viewModel = HttpRequestContentBodyFragment.this.getViewModel();
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding14 = HttpRequestContentBodyFragment.this.f3035b;
                if (fragmentHttpRequestContentBodyBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestContentBodyBinding14 = null;
                }
                viewModel.setContentType(fragmentHttpRequestContentBodyBinding14.contentTypeCustom.getText().toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
            }
        });
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding14 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding14 = null;
        }
        fragmentHttpRequestContentBodyBinding14.contentBodyText.setText(config.getContentBodyText());
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding15 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding15 = null;
        }
        AppCompatEditText appCompatEditText = fragmentHttpRequestContentBodyBinding15.contentBodyText;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "binding.contentBodyText");
        appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestContentBodyFragment$configureUi$lambda$3$$inlined$addTextChangedListener$default$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                HttpRequestConfigViewModel viewModel = HttpRequestContentBodyFragment.this.getViewModel();
                FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding16 = HttpRequestContentBodyFragment.this.f3035b;
                if (fragmentHttpRequestContentBodyBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentHttpRequestContentBodyBinding16 = null;
                }
                viewModel.setContentBodyText(String.valueOf(fragmentHttpRequestContentBodyBinding16.contentBodyText.getText()));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
            }
        });
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding16 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding16 = null;
        }
        TextView textView = fragmentHttpRequestContentBodyBinding16.bodyFilePath;
        String contentBodyFileDisplayName2 = config.getContentBodyFileDisplayName();
        if (contentBodyFileDisplayName2 != null && contentBodyFileDisplayName2.length() != 0) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (z6) {
            contentBodyFileDisplayName = this$0.getString(R.string.action_play_sound_choose_file);
        } else {
            contentBodyFileDisplayName = config.getContentBodyFileDisplayName();
        }
        textView.setText(contentBodyFileDisplayName);
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding17 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding17 = null;
        }
        LinearLayout linearLayout = fragmentHttpRequestContentBodyBinding17.bodyTextLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bodyTextLayout");
        if (config.getContentBodySource() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        linearLayout.setVisibility(i4);
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding18 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHttpRequestContentBodyBinding2 = fragmentHttpRequestContentBodyBinding18;
        }
        LinearLayout linearLayout2 = fragmentHttpRequestContentBodyBinding2.bodyFileLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bodyFileLayout");
        if (config.getContentBodySource() != 1) {
            z8 = false;
        }
        if (!z8) {
            i5 = 8;
        }
        linearLayout2.setVisibility(i5);
    }

    private final void g() {
        MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.c
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                HttpRequestContentBodyFragment.h(HttpRequestContentBodyFragment.this, magicTextPair);
            }
        };
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding = this.f3035b;
        if (fragmentHttpRequestContentBodyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding = null;
        }
        Button button = fragmentHttpRequestContentBodyBinding.bodyMagicTextButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.bodyMagicTextButton");
        ViewExtensionsKt.onClick$default(button, null, new b(magicTextListener, null), 1, null);
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding2 = this.f3035b;
        if (fragmentHttpRequestContentBodyBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding2 = null;
        }
        RadioButton radioButton = fragmentHttpRequestContentBodyBinding2.radioButtonText;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.radioButtonText");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton, (CoroutineContext) null, new c(null), 1, (Object) null);
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding3 = this.f3035b;
        if (fragmentHttpRequestContentBodyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding3 = null;
        }
        ImageButton imageButton = fragmentHttpRequestContentBodyBinding3.selectFileButton;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.selectFileButton");
        ViewExtensionsKt.onClick$default(imageButton, null, new d(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(HttpRequestContentBodyFragment this$0, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding = this$0.f3035b;
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding2 = null;
        if (fragmentHttpRequestContentBodyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding = null;
        }
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestContentBodyBinding.contentBodyText.getSelectionStart(), 0);
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding3 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding3 = null;
        }
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(fragmentHttpRequestContentBodyBinding3.contentBodyText.getSelectionEnd(), 0);
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding4 = this$0.f3035b;
        if (fragmentHttpRequestContentBodyBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHttpRequestContentBodyBinding2 = fragmentHttpRequestContentBodyBinding4;
        }
        Editable text = fragmentHttpRequestContentBodyBinding2.contentBodyText.getText();
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
        if (i5 == -1 && i4 == 0) {
            Intrinsics.checkNotNull(intent);
            Uri data = intent.getData();
            Intrinsics.checkNotNull(data);
            requireContext().getContentResolver().takePersistableUriPermission(data, 1);
            DocumentFile fromSingleUri = DocumentFile.fromSingleUri(requireContext(), data);
            String str = (fromSingleUri == null || (str = fromSingleUri.getName()) == null) ? "" : "";
            FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding = this.f3035b;
            if (fragmentHttpRequestContentBodyBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHttpRequestContentBodyBinding = null;
            }
            fragmentHttpRequestContentBodyBinding.bodyFilePath.setText(str);
            HttpRequestConfigViewModel viewModel = getViewModel();
            String uri = data.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
            viewModel.setbodyFileDetails(uri, str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        long j4;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentHttpRequestContentBodyBinding inflate = FragmentHttpRequestContentBodyBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f3035b = inflate;
        Bundle arguments = getArguments();
        if (arguments != null) {
            j4 = arguments.getLong(Constants.EXTRA_MACRO_GUID);
        } else {
            j4 = 0;
        }
        this.f3036c = MacroStore.getInstance().getMacroByGUID(j4);
        g();
        d();
        FragmentHttpRequestContentBodyBinding fragmentHttpRequestContentBodyBinding = this.f3035b;
        if (fragmentHttpRequestContentBodyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHttpRequestContentBodyBinding = null;
        }
        return fragmentHttpRequestContentBodyBinding.getRoot();
    }

    public final void setViewModel(@NotNull HttpRequestConfigViewModel httpRequestConfigViewModel) {
        Intrinsics.checkNotNullParameter(httpRequestConfigViewModel, "<set-?>");
        this.viewModel = httpRequestConfigViewModel;
    }
}
