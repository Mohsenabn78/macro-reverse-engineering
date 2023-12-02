package com.arlosoft.macrodroid.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.FileProvider;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.data.MacroExportData;
import com.arlosoft.macrodroid.data.UserIconData;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: MacroUtils.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nMacroUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroUtils.kt\ncom/arlosoft/macrodroid/utils/MacroUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,172:1\n1855#2,2:173\n*S KotlinDebug\n*F\n+ 1 MacroUtils.kt\ncom/arlosoft/macrodroid/utils/MacroUtils\n*L\n125#1:173,2\n*E\n"})
/* loaded from: classes3.dex */
public final class MacroUtils {
    public static final int $stable = 0;
    @NotNull
    public static final MacroUtils INSTANCE = new MacroUtils();

    private MacroUtils() {
    }

    private final String e(Macro macro, boolean z3) {
        List<UserIconData> list;
        Gson macroGson = GsonUtils.getMacroGson();
        if (z3) {
            list = macro.getUserIconData();
        } else {
            list = null;
        }
        String json = macroGson.toJson(new MacroExportData(1, macro, list));
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(macroExport)");
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Activity activity, ActionBlock actionBlock, ActionBlockStore actionBlockStore, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(actionBlock, "$actionBlock");
        Intrinsics.checkNotNullParameter(actionBlockStore, "$actionBlockStore");
        j(activity, actionBlock, actionBlockStore, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Activity activity, ActionBlock actionBlock, ActionBlockStore actionBlockStore, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(actionBlock, "$actionBlock");
        Intrinsics.checkNotNullParameter(actionBlockStore, "$actionBlockStore");
        j(activity, actionBlock, actionBlockStore, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Activity activity, Macro macro, ActionBlockStore actionBlockStore, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(macro, "$macro");
        Intrinsics.checkNotNullParameter(actionBlockStore, "$actionBlockStore");
        INSTANCE.k(activity, macro, actionBlockStore, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Activity activity, Macro macro, ActionBlockStore actionBlockStore, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(macro, "$macro");
        Intrinsics.checkNotNullParameter(actionBlockStore, "$actionBlockStore");
        INSTANCE.k(activity, macro, actionBlockStore, false);
    }

    @JvmStatic
    private static final void j(Activity activity, ActionBlock actionBlock, ActionBlockStore actionBlockStore, boolean z3) {
        MacroUtils macroUtils = INSTANCE;
        File filesDir = activity.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "activity.filesDir");
        File createJsonFile = macroUtils.createJsonFile(filesDir, actionBlock, actionBlockStore, z3);
        if (createJsonFile != null) {
            try {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                Gradients gradients = Gradients.INSTANCE;
                MacroDroidApplication context = gradients.getContext();
                String packageName = gradients.getContext().getPackageName();
                arrayList.add(FileProvider.getUriForFile(context, packageName + ".provider", createJsonFile));
                Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                intent.addFlags(268435456);
                intent.setType("text/plain");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                activity.startActivity(Intent.createChooser(intent, activity.getString(R.string.menu_share)));
            } catch (Exception e4) {
                ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.export_failed, 0).show();
                SystemLog.logError("Failed to export file: " + e4);
            }
        }
    }

    private final void k(Activity activity, Macro macro, ActionBlockStore actionBlockStore, boolean z3) {
        macro.configureForExport();
        File filesDir = activity.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "activity.filesDir");
        File createJsonFile = createJsonFile(filesDir, macro, actionBlockStore, z3);
        if (createJsonFile != null) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Gradients gradients = Gradients.INSTANCE;
            MacroDroidApplication context = gradients.getContext();
            String packageName = gradients.getContext().getPackageName();
            arrayList.add(FileProvider.getUriForFile(context, packageName + ".provider", createJsonFile));
            Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
            intent.addFlags(268435456);
            intent.setType("text/plain");
            try {
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                activity.startActivity(Intent.createChooser(intent, activity.getString(R.string.menu_share)));
            } catch (Exception e4) {
                ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.export_failed, 0).show();
                SystemLog.logError("Failed to export file: " + e4);
            }
        }
    }

    private final String l(String str) {
        String replace$default;
        replace$default = kotlin.text.m.replace$default(str, ' ', '_', false, 4, (Object) null);
        return new Regex("[\\\\/:*?\"<>|]").replace(replace$default, "-");
    }

    @JvmStatic
    public static final void onShareActionBlock(@NotNull final Activity activity, @NotNull final ActionBlock actionBlock, @NotNull final ActionBlockStore actionBlockStore) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        Intrinsics.checkNotNullParameter(actionBlockStore, "actionBlockStore");
        List<UserIconData> icons = actionBlock.getUserIconData();
        Intrinsics.checkNotNullExpressionValue(icons, "icons");
        if (!icons.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog_Action);
            builder.setTitle(R.string.share_action_block);
            builder.setMessage(R.string.share_macro_include_user_icons_question);
            builder.setPositiveButton(R.string.dialog_option_yes, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    MacroUtils.f(activity, actionBlock, actionBlockStore, dialogInterface, i4);
                }
            });
            builder.setNegativeButton(R.string.dialog_option_no, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    MacroUtils.g(activity, actionBlock, actionBlockStore, dialogInterface, i4);
                }
            });
            builder.show();
            return;
        }
        j(activity, actionBlock, actionBlockStore, false);
    }

    @JvmStatic
    public static final void onShareMacro(@NotNull final Activity activity, @NotNull final Macro macro, @NotNull final ActionBlockStore actionBlockStore) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(actionBlockStore, "actionBlockStore");
        List<UserIconData> icons = macro.getUserIconData();
        Intrinsics.checkNotNullExpressionValue(icons, "icons");
        if (!icons.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog_Action);
            builder.setTitle(R.string.menu_share);
            builder.setMessage(R.string.share_macro_include_user_icons_question);
            builder.setPositiveButton(R.string.dialog_option_yes, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    MacroUtils.h(activity, macro, actionBlockStore, dialogInterface, i4);
                }
            });
            builder.setNegativeButton(R.string.dialog_option_no, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    MacroUtils.i(activity, macro, actionBlockStore, dialogInterface, i4);
                }
            });
            builder.show();
            return;
        }
        INSTANCE.k(activity, macro, actionBlockStore, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.File createJsonFile(@org.jetbrains.annotations.NotNull java.io.File r5, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.macro.Macro r6, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.macro.ActionBlockStore r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.utils.MacroUtils.createJsonFile(java.io.File, com.arlosoft.macrodroid.macro.Macro, com.arlosoft.macrodroid.macro.ActionBlockStore, boolean):java.io.File");
    }
}
