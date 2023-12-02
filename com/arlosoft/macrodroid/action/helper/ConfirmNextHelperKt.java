package com.arlosoft.macrodroid.action.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.IfThenConfirmDialogActivity;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Stack;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConfirmNextHelper.kt */
@SourceDebugExtension({"SMAP\nConfirmNextHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfirmNextHelper.kt\ncom/arlosoft/macrodroid/action/helper/ConfirmNextHelperKt\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,199:1\n262#2,2:200\n262#2,2:202\n262#2,2:204\n*S KotlinDebug\n*F\n+ 1 ConfirmNextHelper.kt\ncom/arlosoft/macrodroid/action/helper/ConfirmNextHelperKt\n*L\n115#1:200,2\n119#1:202,2\n121#1:204,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ConfirmNextHelperKt {
    @NotNull
    public static final String EXTRA_CANCEL_AFTER_TIMEOUT = "cancel_after_timeout";
    @NotNull
    public static final String EXTRA_TIMEOUT_SECONDS = "timeout_seconds";

    private static final String m(Context context, Macro macro, String str, TriggerContextInfo triggerContextInfo) {
        String replace$default;
        String replaceMagicText = MagicText.replaceMagicText(context, str, triggerContextInfo, macro);
        Intrinsics.checkNotNullExpressionValue(replaceMagicText, "replaceMagicText(context…text, contextInfo, macro)");
        replace$default = m.replace$default(replaceMagicText, "\\n", "\n", false, 4, (Object) null);
        return replace$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ViewGroup timeoutOptions, CompoundButton compoundButton, boolean z3) {
        int i4;
        Intrinsics.checkNotNullParameter(timeoutOptions, "$timeoutOptions");
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        timeoutOptions.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function7 onConfirmListener, EditText editText, EditText editText2, EditText editText3, EditText editText4, CheckBox quitOnBackPressedCheckBox, CheckBox cancelAfterTimeoutCheckBox, SeekBar timeoutSeekbar, AppCompatDialog dialog, View view) {
        Editable editable;
        Editable editable2;
        Editable editable3;
        Intrinsics.checkNotNullParameter(onConfirmListener, "$onConfirmListener");
        Intrinsics.checkNotNullParameter(quitOnBackPressedCheckBox, "$quitOnBackPressedCheckBox");
        Intrinsics.checkNotNullParameter(cancelAfterTimeoutCheckBox, "$cancelAfterTimeoutCheckBox");
        Intrinsics.checkNotNullParameter(timeoutSeekbar, "$timeoutSeekbar");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Editable editable4 = null;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        if (editText2 != null) {
            editable2 = editText2.getText();
        } else {
            editable2 = null;
        }
        String valueOf2 = String.valueOf(editable2);
        if (editText3 != null) {
            editable3 = editText3.getText();
        } else {
            editable3 = null;
        }
        String valueOf3 = String.valueOf(editable3);
        if (editText4 != null) {
            editable4 = editText4.getText();
        }
        onConfirmListener.invoke(valueOf, valueOf2, valueOf3, String.valueOf(editable4), Boolean.valueOf(quitOnBackPressedCheckBox.isChecked()), Boolean.valueOf(cancelAfterTimeoutCheckBox.isChecked()), Integer.valueOf((timeoutSeekbar.getProgress() + 1) * 10));
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Activity activity, MagicText.MagicTextListener magicTextListener, Macro macro, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(macro, "$macro");
        MagicText.displaySelectionDialog(activity, magicTextListener, macro, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        int max = Math.max(it.getSelectionStart(), 0);
        int max2 = Math.max(it.getSelectionEnd(), 0);
        Editable text = it.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        int max = Math.max(it.getSelectionStart(), 0);
        int max2 = Math.max(it.getSelectionEnd(), 0);
        Editable text = it.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Activity activity, MagicText.MagicTextListener magicTextListener, Macro macro, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(macro, "$macro");
        MagicText.displaySelectionDialog(activity, magicTextListener, macro, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0204  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void showConfirmNextConfigDialog(@org.jetbrains.annotations.NotNull final android.app.Activity r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.macro.Macro r22, int r23, @org.jetbrains.annotations.Nullable java.lang.String r24, @org.jetbrains.annotations.Nullable java.lang.String r25, @org.jetbrains.annotations.Nullable java.lang.String r26, @org.jetbrains.annotations.Nullable java.lang.String r27, @org.jetbrains.annotations.NotNull java.lang.String r28, @org.jetbrains.annotations.NotNull java.lang.String r29, boolean r30, boolean r31, boolean r32, int r33, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function7<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Boolean, ? super java.lang.Boolean, ? super java.lang.Integer, kotlin.Unit> r34, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r35) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.helper.ConfirmNextHelperKt.showConfirmNextConfigDialog(android.app.Activity, java.lang.String, com.arlosoft.macrodroid.macro.Macro, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, int, kotlin.jvm.functions.Function7, kotlin.jvm.functions.Function0):void");
    }

    public static final void showIfThenConfirmNextDialog(@NotNull Context context, @NotNull Macro macro, @Nullable TriggerContextInfo triggerContextInfo, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4, boolean z5, boolean z6, int i5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        Intent intent = new Intent(companion.getInstance(), IfThenConfirmDialogActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("Title", m(context, macro, str, triggerContextInfo));
        intent.putExtra("Message", m(context, macro, str2, triggerContextInfo));
        intent.putExtra(Constants.POSITIVE_TEXT_EXTRA, m(context, macro, str3, triggerContextInfo));
        intent.putExtra(Constants.NEGATIVE_TEXT_EXTRA, m(context, macro, str4, triggerContextInfo));
        intent.putExtra(Util.EXTRA_GUID, macro.getGUID());
        intent.putExtra(Constants.EXTRA_TRIGGER_THAT_INVOKED, macro.getTriggerThatInvoked());
        intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
        intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
        intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, skipEndifIndexStack);
        intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, z3);
        intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
        intent.putExtra(Constants.EXTRA_IS_TEST, z4);
        intent.putExtra(IfThenConfirmDialogActivity.EXTRA_QUIT_ON_BACK_PRESSED, z5);
        intent.putExtra(EXTRA_CANCEL_AFTER_TIMEOUT, z6);
        intent.putExtra(EXTRA_TIMEOUT_SECONDS, i5);
        intent.addFlags(268435456);
        companion.getInstance().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function0 onCancelListener, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(onCancelListener, "$onCancelListener");
        onCancelListener.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function0 onCancelListener, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(onCancelListener, "$onCancelListener");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        onCancelListener.invoke();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        int max = Math.max(it.getSelectionStart(), 0);
        int max2 = Math.max(it.getSelectionEnd(), 0);
        Editable text = it.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Activity activity, MagicText.MagicTextListener magicTextListener, Macro macro, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(macro, "$macro");
        MagicText.displaySelectionDialog(activity, magicTextListener, macro, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(EditText it, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(it, "$it");
        int max = Math.max(it.getSelectionStart(), 0);
        int max2 = Math.max(it.getSelectionEnd(), 0);
        Editable text = it.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Activity activity, MagicText.MagicTextListener magicTextListener, Macro macro, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(macro, "$macro");
        MagicText.displaySelectionDialog(activity, magicTextListener, macro, true, true, true, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }
}
