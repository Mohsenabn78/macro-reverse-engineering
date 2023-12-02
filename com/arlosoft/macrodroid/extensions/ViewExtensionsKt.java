package com.arlosoft.macrodroid.extensions;

import android.graphics.Rect;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewExtensions.kt */
/* loaded from: classes3.dex */
public final class ViewExtensionsKt {

    /* compiled from: ViewExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, View, Continuation<? super Unit>, Object> $handler;
        final /* synthetic */ View $v;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3, View view, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$handler = function3;
            this.$v = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(this.$handler, this.$v, continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Function3<CoroutineScope, View, Continuation<? super Unit>, Object> function3 = this.$handler;
                View view = this.$v;
                this.label = 1;
                if (function3.invoke((CoroutineScope) this.L$0, view, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, View, Continuation<? super Unit>, Object> $handler;
        final /* synthetic */ View $v;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3, View view, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$handler = function3;
            this.$v = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = new b(this.$handler, this.$v, continuation);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Function3<CoroutineScope, View, Continuation<? super Unit>, Object> function3 = this.$handler;
                View view = this.$v;
                this.label = 1;
                if (function3.invoke((CoroutineScope) this.L$0, view, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static final <T extends View> void afterMeasured(@NotNull final T t3, @NotNull final Function1<? super T, Unit> f4) {
        Intrinsics.checkNotNullParameter(t3, "<this>");
        Intrinsics.checkNotNullParameter(f4, "f");
        t3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.arlosoft.macrodroid.extensions.ViewExtensionsKt$afterMeasured$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (t3.getMeasuredWidth() > 0 && t3.getMeasuredHeight() > 0) {
                    t3.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    f4.invoke(t3);
                }
            }
        });
    }

    public static final void afterTextChanged(@NotNull EditText editText, @NotNull final Function1<? super String, Unit> textChanged) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(textChanged, "textChanged");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.extensions.ViewExtensionsKt$afterTextChanged$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                textChanged.invoke(String.valueOf(editable));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
    }

    public static final void e(View this_expandTouchArea, int i4, View myParent) {
        Intrinsics.checkNotNullParameter(this_expandTouchArea, "$this_expandTouchArea");
        Intrinsics.checkNotNullParameter(myParent, "$myParent");
        Rect rect = new Rect();
        this_expandTouchArea.getHitRect(rect);
        rect.top -= i4;
        rect.bottom += i4;
        rect.left -= i4;
        rect.right += i4;
        myParent.setTouchDelegate(new TouchDelegate(rect, this_expandTouchArea));
    }

    public static final void expandTouchArea(@NotNull final View view, final int i4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent;
        view2.post(new Runnable() { // from class: com.arlosoft.macrodroid.extensions.a
            @Override // java.lang.Runnable
            public final void run() {
                ViewExtensionsKt.e(view, i4, view2);
            }
        });
    }

    public static final void f(final View view) {
        if (view.isFocused()) {
            view.post(new Runnable() { // from class: com.arlosoft.macrodroid.extensions.d
                @Override // java.lang.Runnable
                public final void run() {
                    ViewExtensionsKt.g(view);
                }
            });
        }
    }

    public static final void focusAndShowKeyboard(@NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.requestFocus();
        if (view.hasWindowFocus()) {
            f(view);
        } else {
            view.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.arlosoft.macrodroid.extensions.ViewExtensionsKt$focusAndShowKeyboard$1
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z3) {
                    if (z3) {
                        ViewExtensionsKt.f(view);
                        view.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
                    }
                }
            });
        }
    }

    public static final void g(View this_showTheKeyboardNow) {
        Intrinsics.checkNotNullParameter(this_showTheKeyboardNow, "$this_showTheKeyboardNow");
        Object systemService = this_showTheKeyboardNow.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(this_showTheKeyboardNow, 1);
    }

    public static final void h(CoroutineContext context, Function3 handler, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        BuildersKt.launch(GlobalScope.INSTANCE, context, CoroutineStart.DEFAULT, new a(handler, view, null));
    }

    public static final void hideKeyboard(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object systemService = view.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static final boolean i(CoroutineContext context, boolean z3, Function3 handler, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        BuildersKt.launch(GlobalScope.INSTANCE, context, CoroutineStart.DEFAULT, new b(handler, view, null));
        return z3;
    }

    public static final void itemSelected(@NotNull Spinner spinner, @NotNull final Function1<? super Integer, Unit> itemSelected) {
        Intrinsics.checkNotNullParameter(spinner, "<this>");
        Intrinsics.checkNotNullParameter(itemSelected, "itemSelected");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.extensions.ViewExtensionsKt$itemSelected$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@NotNull AdapterView<?> parent, @Nullable View view, int i4, long j4) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                itemSelected.invoke(Integer.valueOf(i4));
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@NotNull AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
    }

    public static final void onClick(@NotNull View view, @NotNull final CoroutineContext context, @NotNull final Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> handler) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.extensions.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewExtensionsKt.h(CoroutineContext.this, handler, view2);
            }
        });
    }

    public static /* synthetic */ void onClick$default(View view, CoroutineContext coroutineContext, Function3 function3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onClick(view, coroutineContext, function3);
    }

    public static final void onClickWithDebounce(@NotNull View view, final long j4, @NotNull final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.extensions.ViewExtensionsKt$onClickWithDebounce$1

            /* renamed from: a  reason: collision with root package name */
            private long f11994a;

            @Override // android.view.View.OnClickListener
            public void onClick(@NotNull View v3) {
                Intrinsics.checkNotNullParameter(v3, "v");
                if (SystemClock.elapsedRealtime() - this.f11994a < j4) {
                    return;
                }
                action.invoke();
                this.f11994a = SystemClock.elapsedRealtime();
            }
        });
    }

    public static /* synthetic */ void onClickWithDebounce$default(View view, long j4, Function0 function0, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = 500;
        }
        onClickWithDebounce(view, j4, function0);
    }

    public static final void onLongClick(@NotNull View view, @NotNull final CoroutineContext context, final boolean z3, @NotNull final Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> handler) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.extensions.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean i4;
                i4 = ViewExtensionsKt.i(CoroutineContext.this, z3, handler, view2);
                return i4;
            }
        });
    }

    public static /* synthetic */ void onLongClick$default(View view, CoroutineContext coroutineContext, boolean z3, Function3 function3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        onLongClick(view, coroutineContext, z3, function3);
    }

    public static final void setCursorAtEnd(@NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.setSelection(editText.getText().length());
    }

    public static final void setMarginStart(@NotNull View view, int i4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginStart(i4);
        view.setLayoutParams(marginLayoutParams);
    }

    public static final void setMarginTop(@NotNull View view, int i4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, i4, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        view.setLayoutParams(marginLayoutParams);
    }

    public static final void setMargins(@NotNull View view, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            return;
        }
        if (num != null) {
            i4 = num.intValue();
        } else {
            i4 = marginLayoutParams.leftMargin;
        }
        if (num2 != null) {
            i5 = num2.intValue();
        } else {
            i5 = marginLayoutParams.topMargin;
        }
        if (num3 != null) {
            i6 = num3.intValue();
        } else {
            i6 = marginLayoutParams.rightMargin;
        }
        if (num4 != null) {
            i7 = num4.intValue();
        } else {
            i7 = marginLayoutParams.rightMargin;
        }
        marginLayoutParams.setMargins(i4, i5, i6, i7);
        view.setLayoutParams(marginLayoutParams);
    }

    public static /* synthetic */ void setMargins$default(View view, Integer num, Integer num2, Integer num3, Integer num4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            num = null;
        }
        if ((i4 & 2) != 0) {
            num2 = null;
        }
        if ((i4 & 4) != 0) {
            num3 = null;
        }
        if ((i4 & 8) != 0) {
            num4 = null;
        }
        setMargins(view, num, num2, num3, num4);
    }

    public static final void setPaddingTop(@NotNull View view, int i4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), i4, view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final void showKeyboard(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object systemService = view.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(view, 1);
    }
}
