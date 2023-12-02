package com.arlosoft.macrodroid.permissions;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionRequestActivity;
import com.arlosoft.macrodroid.triggers.FloatingButtonTrigger;
import com.arlosoft.macrodroid.triggers.SwipeTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class PermissionRequestActivity extends AppCompatActivity {
    public static final String EXTRA_PERMISSION = "permission";
    public static final String EXTRA_REQUEST_FILE_ACCESS = "request_file_access";
    public static final String EXTRA_SPECIAL_PERMISSION_ID = "special_permission_id";
    public static final String EXTRA_TITLE = "title";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(DialogInterface dialogInterface, int i4) {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            intent.addFlags(131);
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(this, (int) R.string.error, 0).show();
            SystemLog.logError("No app installed that can handle the intent: OPEN_DOCUMENT_TREE");
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(Activity activity, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            s(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(final Activity activity, DialogInterface dialogInterface, int i4) {
        new RxPermissions((FragmentActivity) activity).request("android.permission.RECORD_AUDIO").observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: f0.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PermissionRequestActivity.p(activity, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(Activity activity) {
        try {
            activity.startActivity(new Intent("android.settings.SETTINGS"));
            activity.finish();
        } catch (Exception unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_settings), 1).show();
        }
    }

    private static void s(Activity activity) {
        try {
            activity.startActivity(new Intent("android.settings.VOICE_INPUT_SETTINGS"));
            activity.finish();
        } catch (Exception unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_settings), 1).show();
        }
    }

    public static void showDefaultAppsSettings(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.default_assist_title);
        builder.setMessage(R.string.default_assist_description).setCancelable(false).setNegativeButton(R.string.settings, new DialogInterface.OnClickListener() { // from class: f0.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionRequestActivity.r(activity);
            }
        }).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionRequestActivity.q(activity, dialogInterface, i4);
            }
        });
        builder.show();
    }

    private void t() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.file_access_permission);
        builder.setMessage(R.string.file_access_permission_detail).setCancelable(false).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionRequestActivity.this.m(dialogInterface, i4);
            }
        }).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionRequestActivity.this.n(dialogInterface, i4);
            }
        });
        builder.show();
    }

    private void u(int i4, String str) {
        switch (i4) {
            case 1:
                z();
                return;
            case 2:
                PermissionsHelper.showCanDrawOverlaysRequiredDialog(this, false, true);
                return;
            case 3:
                y();
                return;
            case 4:
                PermissionsHelper.showAccessibilityRequiredDialog(this, true, false, false, false, true);
                return;
            case 5:
                PermissionsHelper.showDeviceAdminRequiredDialog(this, new ComponentName(this, MacroDroidDeviceAdminReceiver.class), true, true);
                return;
            case 6:
                w();
                return;
            case 7:
                x();
                return;
            case 8:
                PermissionsHelper.showAccessibilityRequiredDialog(this, true, true, false, false, true);
                return;
            case 9:
                PermissionsHelper.showAccessibilityRequiredDialog(this, true, false, true, false, true);
                return;
            case 10:
                PermissionsHelper.showAccessibilityRequiredDialog(this, true, false, false, true, true);
                return;
            case 11:
                v();
                PermissionsHelper.showLocationServicesRequiredDialog(this, true, true);
                return;
            case 12:
                showDefaultAppsSettings(this);
                return;
            case 13:
                setTitle(R.string.helper_apk_required);
                PermissionsHelper.showNeedsNewHelperFileDialog(this, true, true, str);
                return;
            case 14:
                PermissionsHelper.showBackgroundLocationPermissionRequest(this, null);
                finish();
                return;
            default:
                return;
        }
    }

    private void v() {
        try {
            startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(getApplicationContext(), (CharSequence) "DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN not supported on this device", 1).show();
        }
        finish();
    }

    private void w() {
        try {
            startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        } catch (Exception unused) {
            ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.cannot_launch_notification_settings), 1).show();
        }
        finish();
    }

    private void x() {
        try {
            startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
        } catch (Exception unused) {
            ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.cannot_launch_notification_settings), 1).show();
        }
        finish();
    }

    private void y() {
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        intent.addFlags(268435456);
        try {
            startActivityForResult(intent, 0);
        } catch (Exception unused) {
            ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.cannot_launch_accessibility_settings), 1).show();
        }
        finish();
    }

    private void z() {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:com.arlosoft.macrodroid"));
        intent.addFlags(268435456);
        try {
            startActivity(intent);
        } catch (Exception unused) {
            ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.cannot_launch_settings), 1).show();
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        boolean canDrawOverlays;
        super.onActivityResult(i4, i5, intent);
        if (i4 == 0) {
            if (i5 == -1) {
                Uri data = intent.getData();
                getContentResolver().takePersistableUriPermission(data, 3);
                SystemLog.logVerbose("Taken file access permission: " + data);
            }
        } else if (i4 == 1) {
            canDrawOverlays = Settings.canDrawOverlays(this);
            if (canDrawOverlays) {
                for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
                    Iterator<Trigger> it = macro.getTriggerList().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof FloatingButtonTrigger) || (next instanceof SwipeTrigger)) {
                            if (macro.isEnabled()) {
                                next.disableTriggerThreadSafe();
                                next.enableTriggerThreadSafe();
                            }
                        }
                    }
                }
            }
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(EXTRA_PERMISSION);
        String stringExtra2 = getIntent().getStringExtra("title");
        int intExtra = getIntent().getIntExtra(EXTRA_SPECIAL_PERMISSION_ID, 0);
        if (getIntent().getBooleanExtra(EXTRA_REQUEST_FILE_ACCESS, false)) {
            t();
        } else if (intExtra != 0) {
            u(intExtra, stringExtra2);
        } else if (stringExtra != null) {
            if (ContextCompat.checkSelfPermission(this, stringExtra) != 0) {
                ActivityCompat.requestPermissions(this, new String[]{stringExtra}, 34);
                return;
            }
            ToastCompat.makeText(getApplicationContext(), (int) R.string.permission_already_enabled, 0).show();
            finish();
        } else {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i4 != 34) {
            super.onRequestPermissionsResult(i4, strArr, iArr);
            return;
        }
        if (iArr.length > 0 && iArr[0] != 0) {
            String permissionName = PermissionsHelper.getPermissionName(strArr[0]);
            Context applicationContext = getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (permissionName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(R.string.permission_denied)), 0).show();
        }
        finish();
    }
}
