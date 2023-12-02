package com.github.javiersantos.piracychecker;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.github.javiersantos.piracychecker.utils.LibraryUtilsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PiracyCheckerDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/github/javiersantos/piracychecker/PiracyCheckerDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "show", "", "context", "Landroid/content/Context;", "Companion", "library_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class PiracyCheckerDialog extends DialogFragment {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private static PiracyCheckerDialog f18445b;

    /* renamed from: c  reason: collision with root package name */
    private static String f18446c;

    /* renamed from: d  reason: collision with root package name */
    private static String f18447d;

    /* compiled from: PiracyCheckerDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/github/javiersantos/piracychecker/PiracyCheckerDialog$Companion;", "", "()V", FirebaseAnalytics.Param.CONTENT, "", "pcDialog", "Lcom/github/javiersantos/piracychecker/PiracyCheckerDialog;", "title", TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, "dialogTitle", "dialogContent", "library_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final PiracyCheckerDialog newInstance(@NotNull String dialogTitle, @NotNull String dialogContent) {
            Intrinsics.checkParameterIsNotNull(dialogTitle, "dialogTitle");
            Intrinsics.checkParameterIsNotNull(dialogContent, "dialogContent");
            PiracyCheckerDialog.f18445b = new PiracyCheckerDialog();
            PiracyCheckerDialog.f18446c = dialogTitle;
            PiracyCheckerDialog.f18447d = dialogContent;
            return PiracyCheckerDialog.f18445b;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        AlertDialog alertDialog;
        super.onCreateDialog(bundle);
        setCancelable(false);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String str = f18446c;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            String str3 = f18447d;
            if (str3 != null) {
                str2 = str3;
            }
            alertDialog = LibraryUtilsKt.buildUnlicensedDialog(activity, str, str2);
        } else {
            alertDialog = null;
        }
        if (alertDialog == null) {
            Intrinsics.throwNpe();
        }
        return alertDialog;
    }

    public final void show(@NotNull Context context) {
        PiracyCheckerDialog piracyCheckerDialog;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (!(context instanceof AppCompatActivity)) {
            context = null;
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        if (appCompatActivity != null && (piracyCheckerDialog = f18445b) != null) {
            piracyCheckerDialog.show(appCompatActivity.getSupportFragmentManager(), "[LICENSE_DIALOG]");
        }
    }
}
