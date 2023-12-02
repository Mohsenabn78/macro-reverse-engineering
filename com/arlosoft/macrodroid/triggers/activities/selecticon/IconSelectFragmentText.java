package com.arlosoft.macrodroid.triggers.activities.selecticon;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.databinding.SelectIconTextBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IconSelectFragmentText.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nIconSelectFragmentText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IconSelectFragmentText.kt\ncom/arlosoft/macrodroid/triggers/activities/selecticon/IconSelectFragmentText\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
/* loaded from: classes3.dex */
public final class IconSelectFragmentText extends Fragment {
    @NotNull
    public static final String EXTRA_DEFAULT_TEXT = "default_text";

    /* renamed from: b  reason: collision with root package name */
    private SelectIconTextBinding f14618b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: IconSelectFragmentText.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final IconSelectFragmentText newInstance(@Nullable String str, long j4) {
            IconSelectFragmentText iconSelectFragmentText = new IconSelectFragmentText();
            Bundle bundle = new Bundle();
            bundle.putString(IconSelectFragmentText.EXTRA_DEFAULT_TEXT, str);
            bundle.putLong(Constants.EXTRA_MACRO_GUID, j4);
            iconSelectFragmentText.setArguments(bundle);
            return iconSelectFragmentText;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IconSelectFragmentText.kt */
    /* loaded from: classes3.dex */
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
                IconSelectFragmentText iconSelectFragmentText = IconSelectFragmentText.this;
                SelectIconTextBinding selectIconTextBinding = iconSelectFragmentText.f14618b;
                if (selectIconTextBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    selectIconTextBinding = null;
                }
                iconSelectFragmentText.e(String.valueOf(selectIconTextBinding.notificationIconText.getText()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IconSelectFragmentText.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Macro $macro;
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MagicText.MagicTextListener magicTextListener, Macro macro, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$magicTextListener = magicTextListener;
            this.$macro = macro;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$magicTextListener, this.$macro, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MagicText.displaySelectionDialog(IconSelectFragmentText.this.getActivity(), this.$magicTextListener, this.$macro, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void c() {
        String str;
        long j4;
        Bundle arguments = getArguments();
        SelectIconTextBinding selectIconTextBinding = null;
        if (arguments != null) {
            str = arguments.getString(EXTRA_DEFAULT_TEXT);
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            j4 = arguments2.getLong(Constants.EXTRA_MACRO_GUID);
        } else {
            j4 = 0;
        }
        SelectIconTextBinding selectIconTextBinding2 = this.f14618b;
        if (selectIconTextBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectIconTextBinding2 = null;
        }
        Button button = selectIconTextBinding2.addUserIconButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.addUserIconButton");
        ViewExtensionsKt.onClick$default(button, null, new a(null), 1, null);
        MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.k
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                IconSelectFragmentText.d(IconSelectFragmentText.this, magicTextPair);
            }
        };
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(j4);
        SelectIconTextBinding selectIconTextBinding3 = this.f14618b;
        if (selectIconTextBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectIconTextBinding3 = null;
        }
        Button button2 = selectIconTextBinding3.magicTextButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.magicTextButton");
        ViewExtensionsKt.onClick$default(button2, null, new b(magicTextListener, macroByGUID, null), 1, null);
        if (str != null) {
            SelectIconTextBinding selectIconTextBinding4 = this.f14618b;
            if (selectIconTextBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                selectIconTextBinding = selectIconTextBinding4;
            }
            selectIconTextBinding.notificationIconText.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IconSelectFragmentText this$0, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectIconTextBinding selectIconTextBinding = this$0.f14618b;
        SelectIconTextBinding selectIconTextBinding2 = null;
        if (selectIconTextBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectIconTextBinding = null;
        }
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(selectIconTextBinding.notificationIconText.getSelectionStart(), 0);
        SelectIconTextBinding selectIconTextBinding3 = this$0.f14618b;
        if (selectIconTextBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectIconTextBinding3 = null;
        }
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(selectIconTextBinding3.notificationIconText.getSelectionEnd(), 0);
        SelectIconTextBinding selectIconTextBinding4 = this$0.f14618b;
        if (selectIconTextBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            selectIconTextBinding2 = selectIconTextBinding4;
        }
        Editable text = selectIconTextBinding2.notificationIconText.getText();
        if (text != null) {
            int min = Math.min(coerceAtLeast, coerceAtLeast2);
            int max = Math.max(coerceAtLeast, coerceAtLeast2);
            String str = magicTextPair.magicText;
            text.replace(min, max, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String str) {
        Intent intent = new Intent();
        intent.putExtra(Util.ICON_TEXT_EXTRA, str);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @JvmStatic
    @NotNull
    public static final IconSelectFragmentText newInstance(@Nullable String str, long j4) {
        return Companion.newInstance(str, j4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        SelectIconTextBinding inflate = SelectIconTextBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f14618b = inflate;
        c();
        SelectIconTextBinding selectIconTextBinding = this.f14618b;
        if (selectIconTextBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectIconTextBinding = null;
        }
        LinearLayout root = selectIconTextBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }
}
