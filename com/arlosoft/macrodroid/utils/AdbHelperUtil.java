package com.arlosoft.macrodroid.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Arrays;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AdbHelperUtil.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AdbHelperUtil {
    public static final int $stable = 0;
    @NotNull
    public static final AdbHelperUtil INSTANCE = new AdbHelperUtil();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdbHelperUtil.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Activity activity, AppCompatDialog appCompatDialog, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$activity = activity;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$activity, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(PermissionsHelper.ADB_HACK_INFO_LINK));
                    intent.addFlags(268435456);
                    this.$activity.startActivity(intent);
                } catch (Exception unused) {
                }
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdbHelperUtil.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ Function0<Unit> $dismissCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AppCompatDialog appCompatDialog, Function0<Unit> function0, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
            this.$dismissCallback = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$dialog, this.$dismissCallback, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                Function0<Unit> function0 = this.$dismissCallback;
                if (function0 != null) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private AdbHelperUtil() {
    }

    @JvmStatic
    public static final void showAdbHackDetails(@NotNull Activity activity, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showAdbHackDetails(activity, list, null);
    }

    @JvmStatic
    public static final void showAdbHackDetails(@NotNull Activity activity, @Nullable List<String> list, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog_NoTitle);
        appCompatDialog.setContentView(R.layout.dialog_adb_hack_instructions);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.adbHackPC);
        Intrinsics.checkNotNull(findViewById);
        TextView textView = (TextView) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.adbToolDownload);
        Intrinsics.checkNotNull(findViewById2);
        TextView textView2 = (TextView) findViewById2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = activity.getString(R.string.abd_hack_need_a_pc);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.abd_hack_need_a_pc)");
        String format = String.format(string, Arrays.copyOf(new Object[]{"\n\nhttps://developer.android.com/studio/releases/platform-tools"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        Linkify.addLinks(textView, 15);
        String string2 = activity.getString(R.string.adb_hack_connect_to_device);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…b_hack_connect_to_device)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{"\n\nhttps://developer.android.com/studio/command-line/adb.html"}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView2.setText(format2);
        Linkify.addLinks(textView2, 15);
        String joinToString$default = list != null ? CollectionsKt___CollectionsKt.joinToString$default(list, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "adb shell pm grant com.arlosoft.macrodroid ", null, 0, null, null, 60, null) : null;
        View findViewById3 = appCompatDialog.findViewById(R.id.terminalCommands);
        Intrinsics.checkNotNull(findViewById3);
        ((TextView) findViewById3).setText(joinToString$default);
        View findViewById4 = appCompatDialog.findViewById(R.id.forumButton);
        Intrinsics.checkNotNull(findViewById4);
        ViewExtensionsKt.onClick$default(findViewById4, null, new a(activity, appCompatDialog, null), 1, null);
        View findViewById5 = appCompatDialog.findViewById(R.id.adbHackOkButton);
        Intrinsics.checkNotNull(findViewById5);
        ViewExtensionsKt.onClick$default(findViewById5, null, new b(appCompatDialog, function0, null), 1, null);
        appCompatDialog.show();
    }
}
