package com.arlosoft.macrodroid.common;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.PebbleHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class PebbleHelper {

    /* loaded from: classes3.dex */
    public interface PebbleDialogHandler {
        void continueSelected();
    }

    public static void displayPebbleInfo(final Activity activity, final PebbleDialogHandler pebbleDialogHandler) {
        String string = activity.getString(R.string.pebble_info_message);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getString(R.string.pebble_info_title));
        builder.setMessage(string);
        builder.setPositiveButton(activity.getString(R.string.pebble_info_button_install), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.k0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleHelper.installPebbleApp(activity);
            }
        });
        builder.setNeutralButton(activity.getString(R.string.pebble_info_button_continue), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleHelper.e(PebbleHelper.PebbleDialogHandler.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(activity.getString(17039360), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.m0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleHelper.f(dialogInterface, i4);
            }
        });
        builder.show();
        Settings.setShownPebbelInfo(activity, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(PebbleDialogHandler pebbleDialogHandler, DialogInterface dialogInterface, int i4) {
        if (pebbleDialogHandler != null) {
            pebbleDialogHandler.continueSelected();
        }
    }

    public static void installPebbleApp(Context context) {
        String str = context.getExternalFilesDir(null) + RemoteSettings.FORWARD_SLASH_STRING + "macrodroid_watchface.pbw";
        try {
            InputStream open = context.getAssets().open("macrodroid_watchface.pbw");
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            open.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(Uri.fromFile(new File(str)));
            if (ApplicationChecker.isPebbleTimeInstalled()) {
                intent.setClassName("com.getpebble.android.basalt", "com.getpebble.android.activity_home_screen.activity.MainActivity");
            } else {
                intent.setClassName("com.getpebble.android", "com.getpebble.android.ui.UpdateActivity");
            }
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Util.displayNotification(context, "Pebble Install Failed", "Could not install watch app", false);
            }
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to copy the pebble watch face app: " + e4.toString()));
            Util.displayNotification(context, "Pebble Install Failed", "Could not install watchc app", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(DialogInterface dialogInterface, int i4) {
    }
}
