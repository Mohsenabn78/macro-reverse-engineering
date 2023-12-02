package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.sun.mail.imap.IMAPStore;

/* loaded from: classes3.dex */
public class LegacySystemCommands {
    private static boolean a(Context context) {
        if (ApplicationChecker.isMacroDroidHelperInstalled()) {
            return true;
        }
        return false;
    }

    public static void sendSystemCommandInt(Context context, String str, int i4, String str2) {
        if (!a(context)) {
            return;
        }
        Intent intent = new Intent("com.arlosoft.macrodroid.settingshelper.COMMAND");
        intent.putExtra(IMAPStore.ID_COMMAND, "system_put_int");
        intent.putExtra("settings_field", str);
        intent.putExtra("param", i4);
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_MACRO_NAME, str2);
        intent.addFlags(32);
        context.sendBroadcast(intent);
    }
}
