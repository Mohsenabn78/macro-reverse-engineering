package com.arlosoft.macrodroid.utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RawRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: VersionHistoryHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VersionHistoryHelper {
    public static final int $stable = 0;
    @NotNull
    public static final VersionHistoryHelper INSTANCE = new VersionHistoryHelper();

    private VersionHistoryHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final String c(Activity activity, @RawRes int i4) {
        InputStream openRawResource = activity.getResources().openRawResource(i4);
        Intrinsics.checkNotNullExpressionValue(openRawResource, "activity.resources.openRawResource(resource)");
        byte[] bArr = new byte[openRawResource.available()];
        openRawResource.read(bArr);
        String str = new String(bArr, Charsets.UTF_8);
        openRawResource.close();
        return str;
    }

    @JvmStatic
    public static final void displayVersionHistory(@NotNull FragmentActivity activity, boolean z3) {
        String string;
        WindowManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(activity, "activity");
        PackageManager packageManager = activity.getPackageManager();
        String packageName = activity.getPackageName();
        try {
            VersionHistoryHelper versionHistoryHelper = INSTANCE;
            String c4 = versionHistoryHelper.c(activity, R.raw.version_info_new);
            String c5 = versionHistoryHelper.c(activity, R.raw.version_info);
            if (z3) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                    Intrinsics.checkNotNullExpressionValue(packageInfo, "packageManager.getPackageInfo(packageName, 0)");
                    string = ExifInterface.GPS_MEASUREMENT_INTERRUPTED + packageInfo.versionName + " - " + activity.getString(R.string.whats_new);
                } catch (Exception unused) {
                }
            } else {
                string = activity.getString(R.string.version_history);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.version_history)");
            }
            final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog_WhatsNew);
            appCompatDialog.setContentView(R.layout.whats_new_dialog);
            appCompatDialog.setCancelable(true);
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
            Window window = appCompatDialog.getWindow();
            if (window != null) {
                layoutParams = window.getAttributes();
            } else {
                layoutParams = null;
            }
            layoutParams2.copyFrom(layoutParams);
            layoutParams2.width = -1;
            Window window2 = appCompatDialog.getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams2);
            }
            View findViewById = appCompatDialog.findViewById(R.id.titleText);
            Intrinsics.checkNotNull(findViewById);
            ((TextView) findViewById).setText(string);
            View findViewById2 = appCompatDialog.findViewById(R.id.whatsNewText);
            Intrinsics.checkNotNull(findViewById2);
            ((TextView) findViewById2).setText(c4 + "\n\n" + c5);
            View findViewById3 = appCompatDialog.findViewById(R.id.okButton);
            Intrinsics.checkNotNull(findViewById3);
            ((Button) findViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VersionHistoryHelper.b(AppCompatDialog.this, view);
                }
            });
            appCompatDialog.show();
        } catch (IOException e4) {
            FirebaseCrashlytics.getInstance().recordException(new RuntimeException("Error Setting up Whats New Dialog: " + e4.getMessage()));
        }
    }
}
