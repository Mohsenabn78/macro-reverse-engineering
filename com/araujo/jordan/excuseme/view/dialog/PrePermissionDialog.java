package com.araujo.jordan.excuseme.view.dialog;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.araujo.jordan.excuseme.R;
import com.araujo.jordan.excuseme.utils.DesignUtils;
import com.araujo.jordan.excuseme.view.InvisibleActivity;
import com.google.mlkit.nl.translate.TranslateLanguage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PrePermissionDialog.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0011B)\b\u0016\u0012\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\f\u0010\u0013J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R0\u0010\u000b\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/araujo/jordan/excuseme/view/dialog/PrePermissionDialog;", "Lcom/araujo/jordan/excuseme/view/dialog/ExcuseMeDialog;", "Lcom/araujo/jordan/excuseme/view/InvisibleActivity;", "act", "", "showDialogForPermission", "(Lcom/araujo/jordan/excuseme/view/InvisibleActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "f", "Lkotlin/jvm/functions/Function1;", "customRequest", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "", "title", "reason", "(Ljava/lang/String;Ljava/lang/String;)V", "customDialogRequest", "(Lkotlin/jvm/functions/Function1;)V", "excuseme_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class PrePermissionDialog extends ExcuseMeDialog {

    /* renamed from: f  reason: collision with root package name */
    private Function1<? super Function1<? super Boolean, Unit>, Unit> f1939f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrePermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", TranslateLanguage.ITALIAN, "", "invoke"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            PrePermissionDialog.this.a(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrePermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", TranslateLanguage.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PrePermissionDialog.this.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrePermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", TranslateLanguage.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PrePermissionDialog.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PrePermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", TranslateLanguage.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            PrePermissionDialog.this.a(false);
        }
    }

    public PrePermissionDialog() {
        super(false);
    }

    @Override // com.araujo.jordan.excuseme.view.dialog.ExcuseMeDialog
    @SuppressLint({"InflateParams"})
    @Nullable
    public Object showDialogForPermission(@NotNull InvisibleActivity invisibleActivity, @NotNull Continuation<? super Boolean> continuation) {
        Function1<? super Function1<? super Boolean, Unit>, Unit> function1 = this.f1939f;
        if (function1 != null) {
            if (function1 != null) {
                function1.invoke(new a());
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(invisibleActivity);
            View v3 = invisibleActivity.getLayoutInflater().inflate(R.layout.dialog_gently_ask, (ViewGroup) null);
            Intrinsics.checkExpressionValueIsNotNull(v3, "v");
            int i4 = R.id.excuseMeGentlyTitle;
            TextView textView = (TextView) v3.findViewById(i4);
            if (textView != null) {
                textView.setText(d());
            }
            int i5 = R.id.excuseMeGentlyDescriptionText;
            TextView textView2 = (TextView) v3.findViewById(i5);
            if (textView2 != null) {
                textView2.setText(c());
            }
            int i6 = R.id.excuseMeGentlyYesBtn;
            Button button = (Button) v3.findViewById(i6);
            if (button != null) {
                button.setOnClickListener(new b());
            }
            Button button2 = (Button) v3.findViewById(i6);
            if (button2 != null) {
                button2.setTextColor(DesignUtils.Companion.resolveColor(invisibleActivity, "colorPrimaryDark"));
            }
            int i7 = R.id.excuseMeGentlyNoBtn;
            Button button3 = (Button) v3.findViewById(i7);
            if (button3 != null) {
                button3.setTextColor(DesignUtils.Companion.resolveColor(invisibleActivity, "colorPrimaryDark"));
            }
            TextView textView3 = (TextView) v3.findViewById(i4);
            if (textView3 != null) {
                textView3.setBackgroundColor(DesignUtils.Companion.resolveColor(invisibleActivity, "colorPrimary"));
            }
            TextView textView4 = (TextView) v3.findViewById(i5);
            if (textView4 != null) {
                textView4.setTextColor(DesignUtils.Companion.resolveColor(invisibleActivity, "#0c0c0c"));
            }
            Button button4 = (Button) v3.findViewById(i7);
            if (button4 != null) {
                button4.setOnClickListener(new c());
            }
            builder.setOnCancelListener(new d());
            builder.setView(v3);
            builder.setCancelable(false);
            e(builder.show());
        }
        return super.showDialogForPermission(invisibleActivity, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrePermissionDialog(@NotNull String title, @NotNull String reason) {
        super(title, reason);
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(reason, "reason");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrePermissionDialog(@NotNull Function1<? super Function1<? super Boolean, Unit>, Unit> customDialogRequest) {
        super(true);
        Intrinsics.checkParameterIsNotNull(customDialogRequest, "customDialogRequest");
        this.f1939f = customDialogRequest;
    }
}
