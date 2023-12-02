package com.arlosoft.macrodroid.permissions;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.RefreshEditMacroPageEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class PermissionsHelper {
    public static final String ADB_HACK_INFO_LINK = "https://macrodroidforum.com/index.php?threads/adb-hack-granting-extra-capabilities-via-the-adb-tool.48/";
    public static final String HELPER_FILE_LINK = "https://macrodroidforum.com/index.php?threads/macrodroid-helper-apk.1/";
    public static final int SPECIAL_PERMISSION_ACCESSIBILITY = 4;
    public static final int SPECIAL_PERMISSION_BACKGROUND_LOCATION_ACCESS = 14;
    public static final int SPECIAL_PERMISSION_DEFAULT_ASSIST_APP = 12;
    public static final int SPECIAL_PERMISSION_DEVICE_ADMIN = 5;
    public static final int SPECIAL_PERMISSION_DRAW_OVERLAY = 2;
    public static final int SPECIAL_PERMISSION_FINGERPRINT_ACCESSIBILITY = 9;
    public static final int SPECIAL_PERMISSION_LOCATION_SERVICES = 11;
    public static final int SPECIAL_PERMISSION_NEW_HELPER_APP = 13;
    public static final int SPECIAL_PERMISSION_NONE = 0;
    public static final int SPECIAL_PERMISSION_NOTIFICATION_ACCESS = 6;
    public static final int SPECIAL_PERMISSION_NOTIFICATION_POLICY_ACCESS = 7;
    public static final int SPECIAL_PERMISSION_UI_INTERACTION_ACCESSIBILITY = 10;
    public static final int SPECIAL_PERMISSION_USAGE_ACCESS = 3;
    public static final int SPECIAL_PERMISSION_VOLUME_ACCESSIBILITY = 8;
    public static final int SPECIAL_PERMISSION_WRITE_SETTINGS = 1;

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Integer> f13040a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Integer, Integer> f13041b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f13042a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f13043b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ComponentName f13044c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f13045d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f13046e;

        a(AppCompatDialog appCompatDialog, Activity activity, ComponentName componentName, boolean z3, boolean z4) {
            this.f13042a = appCompatDialog;
            this.f13043b = activity;
            this.f13044c = componentName;
            this.f13045d = z3;
            this.f13046e = z4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13042a.dismiss();
            PermissionsHelper.showDeviceAdminRequiredDialog2(this.f13043b, this.f13044c, this.f13045d, this.f13046e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f13047a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f13048b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f13049c;

        b(AppCompatDialog appCompatDialog, boolean z3, Activity activity) {
            this.f13047a = appCompatDialog;
            this.f13048b = z3;
            this.f13049c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13047a.dismiss();
            if (this.f13048b) {
                this.f13049c.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f13050a;

        c(Button button) {
            this.f13050a = button;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            this.f13050a.setEnabled(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f13051a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentName f13052b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f13053c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f13054d;

        d(AppCompatDialog appCompatDialog, ComponentName componentName, Activity activity, boolean z3) {
            this.f13051a = appCompatDialog;
            this.f13052b = componentName;
            this.f13053c = activity;
            this.f13054d = z3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13051a.dismiss();
            try {
                Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
                intent.putExtra("android.app.extra.DEVICE_ADMIN", this.f13052b);
                this.f13053c.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                ToastCompat.makeText(this.f13053c.getApplicationContext(), (CharSequence) "DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN not supported on this device", 1).show();
            }
            if (this.f13054d) {
                this.f13053c.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f13055a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f13056b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f13057c;

        e(AppCompatDialog appCompatDialog, boolean z3, Activity activity) {
            this.f13055a = appCompatDialog;
            this.f13056b = z3;
            this.f13057c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13055a.dismiss();
            if (this.f13056b) {
                this.f13057c.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f13058a;

        f(Button button) {
            this.f13058a = button;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            this.f13058a.setEnabled(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f13059a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f13060b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f13061c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f13062d;

        g(Activity activity, boolean z3, boolean z4, AppCompatDialog appCompatDialog) {
            this.f13059a = activity;
            this.f13060b = z3;
            this.f13061c = z4;
            this.f13062d = appCompatDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PermissionsHelper.b0(this.f13059a, this.f13060b, this.f13061c);
            this.f13062d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f13063a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f13064b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f13065c;

        h(Activity activity, AppCompatDialog appCompatDialog, boolean z3) {
            this.f13063a = activity;
            this.f13064b = appCompatDialog;
            this.f13065c = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(AppCompatDialog appCompatDialog, Activity activity, boolean z3, Boolean bool) throws Exception {
            if (bool.booleanValue()) {
                appCompatDialog.dismiss();
                PermissionRequestActivity.showDefaultAppsSettings(activity);
                if (z3) {
                    activity.finish();
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Observable<Boolean> observeOn = new RxPermissions((FragmentActivity) this.f13063a).request("android.permission.RECORD_AUDIO").observeOn(AndroidSchedulers.mainThread());
            final AppCompatDialog appCompatDialog = this.f13064b;
            final Activity activity = this.f13063a;
            final boolean z3 = this.f13065c;
            observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.permissions.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PermissionsHelper.h.b(AppCompatDialog.this, activity, z3, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f13066a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f13067b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f13068c;

        i(AppCompatDialog appCompatDialog, boolean z3, Activity activity) {
            this.f13066a = appCompatDialog;
            this.f13067b = z3;
            this.f13068c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13066a.dismiss();
            if (this.f13067b) {
                this.f13068c.finish();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f13040a = hashMap;
        HashMap hashMap2 = new HashMap();
        f13041b = hashMap2;
        hashMap.put("android.permission.READ_CALENDAR", 8003001);
        hashMap.put("android.permission.WRITE_CALENDAR", 8003002);
        hashMap.put("android.permission.CAMERA", 8003003);
        hashMap.put("android.permission.READ_CONTACTS", 8003004);
        hashMap.put("android.permission.WRITE_CONTACTS", 8003005);
        hashMap.put("android.permission.GET_ACCOUNTS", 8003006);
        hashMap.put("android.permission.ACCESS_FINE_LOCATION", 8003007);
        hashMap.put("android.permission.ACCESS_COARSE_LOCATION", 8003008);
        hashMap.put("android.permission.RECORD_AUDIO", 8003009);
        hashMap.put("android.permission.READ_PHONE_STATE", 8003010);
        hashMap.put("android.permission.CALL_PHONE", 8003011);
        hashMap.put("android.permission.READ_CALL_LOG", 8003012);
        hashMap.put("android.permission.WRITE_CALL_LOG", 8003013);
        hashMap.put("android.permission.USE_SIP", 8003014);
        hashMap.put("android.permission.PROCESS_OUTGOING_CALLS", 8003015);
        hashMap.put("android.permission.BODY_SENSORS", 8003016);
        hashMap.put("android.permission.SEND_SMS", 8003017);
        hashMap.put("android.permission.RECEIVE_SMS", 8003018);
        hashMap.put("android.permission.READ_SMS", 8003019);
        hashMap.put("android.permission.RECEIVE_WAP_PUSH", 8003020);
        hashMap.put("android.permission.RECEIVE_MMS", 8003021);
        hashMap.put("android.permission.READ_EXTERNAL_STORAGE", 8003022);
        hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", 8003023);
        hashMap2.put(1, 8004001);
        hashMap2.put(2, 8004002);
        hashMap2.put(3, 8004003);
        hashMap2.put(4, 8004004);
        hashMap2.put(5, 8004005);
        hashMap2.put(6, 8004006);
        hashMap2.put(7, 8004007);
        hashMap2.put(8, 8004008);
        hashMap2.put(9, 8004009);
        hashMap2.put(10, 8004010);
        hashMap2.put(11, 8004011);
        hashMap2.put(12, 8003012);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        try {
            activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 0);
        } catch (Exception unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_accessibility_settings), 1).show();
        }
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(SelectableItem selectableItem, Boolean bool) throws Exception {
        if (bool.booleanValue() && selectableItem != null) {
            selectableItem.onItemSelected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:com.arlosoft.macrodroid"));
        try {
            activity.startActivityForResult(intent, 1);
        } catch (Exception unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_settings), 1).show();
        }
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        Settings.setIgnoreDefaultAssistWarning(activity, true);
        EventBusUtils.getEventBus().post(new RefreshEditMacroPageEvent());
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(final SelectableItem selectableItem, final Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
        if (selectableItem != null) {
            strArr = selectableItem.getRequiredPermissions();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str.equals("android.permission.ACCESS_FINE_LOCATION") || str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                arrayList.add(str);
            }
        }
        new RxPermissions((FragmentActivity) activity).request((String[]) arrayList.toArray(new String[0])).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: f0.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PermissionsHelper.K(SelectableItem.this, activity, (Boolean) obj);
            }
        });
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(SelectableItem selectableItem, Activity activity, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            if (Build.VERSION.SDK_INT >= 30) {
                if (selectableItem != null) {
                    selectableItem.onItemSelected();
                }
                showBackgroundLocationPermissionRequest(activity, selectableItem);
            } else if (selectableItem != null) {
                selectableItem.onItemSelected();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        try {
            activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) "DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN not supported on this device", 1).show();
        }
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:com.arlosoft.macrodroid"));
        intent.addFlags(268435456);
        try {
            activity.startActivity(intent);
            if (z3) {
                activity.finish();
            }
        } catch (Exception unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_settings), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(Activity activity, DialogInterface dialogInterface, int i4) {
        activity.startActivity(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + activity.getPackageName())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(Activity activity, DialogInterface dialogInterface, int i4) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(HELPER_FILE_LINK)));
        } catch (ActivityNotFoundException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(Activity activity, DialogInterface dialogInterface, int i4) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(HELPER_FILE_LINK)));
        } catch (ActivityNotFoundException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        try {
            activity.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        } catch (Exception unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_notification_settings), 1).show();
        }
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        try {
            activity.startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
        } catch (Exception unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_notification_settings), 1).show();
        }
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        Settings.setIgnoreDoNotDisturb(activity, true);
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(Activity activity, boolean z3, DialogInterface dialogInterface, int i4) {
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        intent.addFlags(268435456);
        try {
            activity.startActivityForResult(intent, 0);
        } catch (Exception unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_accessibility_settings), 1).show();
        }
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(boolean z3, Activity activity, DialogInterface dialogInterface, int i4) {
        if (z3) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b0(final Activity activity, final boolean z3, final boolean z4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.are_you_sure);
        builder.setMessage(R.string.already_enabled_default_assist_app_confirm);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.G(activity, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.H(z4, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static boolean checkForNormalPermissions(Context context, SelectableItem selectableItem, boolean z3) {
        String[] requiredPermissions;
        if (z3) {
            requiredPermissions = selectableItem.getPermissionsOnImport();
        } else {
            requiredPermissions = selectableItem.getRequiredPermissions();
        }
        if (requiredPermissions != null && requiredPermissions.length != 0) {
            for (String str : requiredPermissions) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkForSpecialPermissions(android.app.Activity r10, com.arlosoft.macrodroid.common.SelectableItem r11, boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.permissions.PermissionsHelper.checkForSpecialPermissions(android.app.Activity, com.arlosoft.macrodroid.common.SelectableItem, boolean, boolean):boolean");
    }

    public static String getPermissionName(String str) {
        if (str.contains(".")) {
            return str.substring(str.lastIndexOf(".") + 1);
        }
        return str;
    }

    public static void handleRequestPermissionResult(SelectableItem selectableItem, String[] strArr, int[] iArr) {
        for (int i4 : iArr) {
            if (i4 != 0) {
                selectableItem.permissionsDenied(strArr, iArr);
                return;
            }
        }
        selectableItem.permissionsGranted();
    }

    public static void showAccessibilityRequiredDialog(final Activity activity, final boolean z3, boolean z4, boolean z5, boolean z6, final boolean z7) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.accessibility_required);
        if (z4) {
            String str = activity.getString(R.string.accessibility_volume_description) + "\n\n" + activity.getString(R.string.accessibility_service_detail_volume_button_monitor);
            if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
                str = str + "\n\n" + activity.getString(R.string.xiaomi_accessibility_warning);
            }
            builder.setMessage(str);
        } else if (z5) {
            builder.setMessage(activity.getString(R.string.accessibility_fingerprint_description) + "\n\n" + activity.getString(R.string.accessibility_service_detail_finger_print_gesture_detector));
        } else if (z6) {
            String str2 = activity.getString(R.string.accessibility_ui_interaction_description) + "\n\n" + activity.getString(R.string.accessibility_service_detail_ui_interaction);
            if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
                str2 = str2 + "\n\n" + activity.getString(R.string.xiaomi_accessibility_warning);
            }
            builder.setMessage(str2);
        } else {
            builder.setMessage(activity.getString(R.string.accessibility_description) + "\n\n" + activity.getString(R.string.accessibility_service_detail_main));
        }
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.B(activity, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.C(z7, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        AlertDialog show = builder.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(show.getWindow().getAttributes());
        layoutParams.width = -1;
        show.getWindow().setAttributes(layoutParams);
    }

    public static void showBackgroundLocationPermissionRequest(Activity activity, final SelectableItem selectableItem) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            new RxPermissions((FragmentActivity) activity).request("android.permission.ACCESS_BACKGROUND_LOCATION").observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: f0.v
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PermissionsHelper.D(SelectableItem.this, (Boolean) obj);
                }
            });
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivity(intent);
            ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.navigate_to_location_permissions_and_allow_all_the_time, 1).show();
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) "android.settings.APPLICATION_DETAILS_SETTINGS not supported on this device", 1).show();
        }
    }

    public static void showCanDrawOverlaysRequiredDialog(final Activity activity, final boolean z3, final boolean z4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.requires_draw_overlays);
        builder.setMessage(R.string.requires_draw_overlays_details);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.E(activity, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.F(z4, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showDefaultAssistRequiredDialog(Activity activity, boolean z3, boolean z4) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.dialog_default_assist_warning);
        appCompatDialog.setTitle(R.string.permission_required);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.alreadyConfiguredText);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView.setOnClickListener(new g(activity, z3, z4, appCompatDialog));
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new h(activity, appCompatDialog, z3));
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new i(appCompatDialog, z4, activity));
        appCompatDialog.show();
    }

    public static void showDeviceAdminRequiredDialog(Activity activity, ComponentName componentName, boolean z3, boolean z4) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.dialog_device_admin_warning);
        appCompatDialog.setTitle(R.string.required_device_administrator);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        button.setEnabled(false);
        button.setOnClickListener(new a(appCompatDialog, activity, componentName, z3, z4));
        button2.setOnClickListener(new b(appCompatDialog, z4, activity));
        ((CheckBox) appCompatDialog.findViewById(R.id.confirmReadCheckbox)).setOnCheckedChangeListener(new c(button));
        appCompatDialog.show();
    }

    public static void showDeviceAdminRequiredDialog2(Activity activity, ComponentName componentName, boolean z3, boolean z4) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity);
        appCompatDialog.setContentView(R.layout.dialog_device_admin_warning_2);
        appCompatDialog.setTitle(R.string.required_device_administrator);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        button.setEnabled(false);
        button.setOnClickListener(new d(appCompatDialog, componentName, activity, z3));
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new e(appCompatDialog, z4, activity));
        ((CheckBox) appCompatDialog.findViewById(R.id.confirmReadCheckbox)).setOnCheckedChangeListener(new f(button));
        appCompatDialog.show();
    }

    public static void showLocationDisclosureInfoDialog(final Activity activity, @Nullable final SelectableItem selectableItem, final boolean z3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.location_permission_required);
        builder.setMessage(R.string.location_data_use_disclosure);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.I(SelectableItem.this, activity, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.J(z3, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showLocationServicesRequiredDialog(final Activity activity, final boolean z3, final boolean z4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.location_services_disabled);
        builder.setMessage(R.string.location_service_must_be_enabled);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.c0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.L(activity, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.d0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.M(z4, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showManageWriteSettingsRequiredDialog(final Activity activity, final boolean z3, final boolean z4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.requires_write_settings);
        builder.setMessage(R.string.requires_write_settings_details);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.N(activity, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.O(z4, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showNeedsExactAlarmPermissionDialog(final Activity activity, boolean z3, final boolean z4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.permission_required);
        builder.setMessage(R.string.permission_to_set_exact_alarms_required);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.P(activity, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.Q(z4, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showNeedsFileAccess(Context context) {
        if (context == null) {
            return;
        }
        String str = context.getString(R.string.macrodroid) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context.getString(R.string.requires) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context.getString(R.string.file_access_permission);
        Intent intent = new Intent(context, PermissionRequestActivity.class);
        intent.putExtra(PermissionRequestActivity.EXTRA_REQUEST_FILE_ACCESS, true);
        PendingIntent activity = PendingIntent.getActivity(context, 8005000, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle(context.getString(R.string.macrodroid_requires_permission)).setWhen(System.currentTimeMillis()).setContentText(str).setContentIntent(activity).setSmallIcon(R.drawable.ic_warning_white_24dp).setAutoCancel(true).setColor(ContextCompat.getColor(context, R.color.md_red_500)).setStyle(new NotificationCompat.BigTextStyle().bigText(str)).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY);
        ((NotificationManager) context.getSystemService("notification")).notify(8005000, builder.build());
    }

    public static void showNeedsNewHelperFileDialog(Activity activity, boolean z3, boolean z4, String str) {
        showNeedsNewHelperFileDialog(activity, z3, z4, str, null);
    }

    public static void showNeedsNewHelperFileWifiSSIDsDialog(final Activity activity, String str, DialogInterface.OnClickListener onClickListener) {
        if (activity == null) {
            return;
        }
        if ((activity instanceof MacroDroidBaseActivity) && ((MacroDroidBaseActivity) activity).isDestroyedOrFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(str);
        builder.setMessage(String.format(activity.getString(R.string.feature_requires_helper_file_wifi_ssids), HELPER_FILE_LINK));
        builder.setPositiveButton(R.string.pebble_info_button_continue, onClickListener);
        builder.setNeutralButton(R.string.get_helper_file, new DialogInterface.OnClickListener() { // from class: f0.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.T(activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        create.show();
        TextView textView = (TextView) create.findViewById(16908299);
        Linkify.addLinks(textView, 15);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void showNeedsPermission(Context context, String str, String str2, boolean z3, boolean z4) {
        String str3;
        if (context == null) {
            return;
        }
        String permissionName = getPermissionName(str);
        if (z3) {
            StringBuilder sb = new StringBuilder();
            if (str2 == null) {
                str3 = context.getString(R.string.macrodroid);
            } else {
                str3 = str2;
            }
            sb.append(str3);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(context.getString(R.string.requires));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(permissionName);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(context.getString(R.string.permission));
            String sb2 = sb.toString();
            Integer num = f13040a.get(str);
            if (num == null) {
                num = 8003000;
            }
            Intent intent = new Intent(context, PermissionRequestActivity.class);
            intent.putExtra(PermissionRequestActivity.EXTRA_PERMISSION, str);
            intent.putExtra("title", str2);
            PendingIntent activity = PendingIntent.getActivity(context, num.intValue(), intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setContentTitle(context.getString(R.string.macrodroid_requires_permission)).setWhen(System.currentTimeMillis()).setContentText(sb2).setContentIntent(activity).setSmallIcon(R.drawable.ic_warning_white_24dp).setAutoCancel(true).setColor(ContextCompat.getColor(context, R.color.md_red_500)).setStyle(new NotificationCompat.BigTextStyle().bigText(sb2)).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY);
            ((NotificationManager) context.getSystemService("notification")).notify(num.intValue(), builder.build());
        }
    }

    public static void showNeedsSpecialPermission(Context context, String str, int i4) {
        showNeedsSpecialPermission(context, str, i4, null);
    }

    public static void showNotificationAccessRequiredDialog(final Activity activity, final boolean z3, final boolean z4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.notification_access_required);
        builder.setMessage(R.string.notification_access_description);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.U(activity, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.V(z4, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showNotificationPolicyAccessRequiredDialog(final Activity activity, final boolean z3, final boolean z4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.permission_required);
        builder.setMessage(R.string.do_not_disturb_access);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.W(activity, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.a0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.X(z4, activity, dialogInterface, i4);
            }
        });
        builder.setNeutralButton(R.string.ignore, new DialogInterface.OnClickListener() { // from class: f0.b0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.Y(activity, z4, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showUsageAccessRequiredDialog(final Activity activity, final boolean z3, final boolean z4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.usage_access_required);
        builder.setMessage(R.string.usage_access_required_description);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.Z(activity, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.a0(z4, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public static void showNeedsNewHelperFileDialog(final Activity activity, boolean z3, final boolean z4, String str, String str2) {
        if (activity == null) {
            return;
        }
        if ((activity instanceof MacroDroidBaseActivity) && ((MacroDroidBaseActivity) activity).isDestroyedOrFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(str);
        if (str2 == null) {
            builder.setMessage(String.format(activity.getString(R.string.feature_requires_helper_file), HELPER_FILE_LINK));
        } else {
            builder.setMessage(str2);
        }
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: f0.e0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.R(activity, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: f0.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PermissionsHelper.S(z4, activity, dialogInterface, i4);
            }
        });
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        create.show();
        TextView textView = (TextView) create.findViewById(16908299);
        Linkify.addLinks(textView, 15);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void showNeedsSpecialPermission(Context context, String str, int i4, @Nullable String str2) {
        if (context == null) {
            return;
        }
        String string = context.getString(R.string.macrodroid_requires_permission);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" - ");
        switch (i4) {
            case 1:
                sb.append(context.getString(R.string.requires_write_settings));
                break;
            case 2:
                sb.append(context.getString(R.string.requires_draw_overlays));
                break;
            case 3:
                sb.append(context.getString(R.string.usage_access_required));
                break;
            case 4:
            case 8:
            case 9:
            case 10:
                sb.append(context.getString(R.string.accessibility_required));
                break;
            case 5:
                sb.append(context.getString(R.string.required_device_administrator));
                break;
            case 6:
                sb.append(context.getString(R.string.notification_access_required));
                break;
            case 7:
                sb.append(context.getString(R.string.do_not_disturb_access));
                break;
            case 11:
                if (Settings.getShowLocationServiceWarningNotification(context)) {
                    string = context.getString(R.string.location_services_disabled);
                    sb.append(context.getString(R.string.location_service_must_be_enabled));
                    break;
                } else {
                    return;
                }
            case 12:
                sb.append(context.getString(R.string.requires_assist_and_voice_input));
                break;
            case 13:
                sb.append(context.getString(R.string.helper_apk_required));
                string = context.getString(R.string.helper_apk_required) + " (" + str2 + "+)";
                break;
            case 14:
                sb.append(context.getString(R.string.background_location_access_required_detail));
                string = context.getString(R.string.background_location_access_required_title);
                break;
        }
        Integer num = f13041b.get(Integer.valueOf(i4));
        if (num == null) {
            num = 8003000;
        }
        Intent intent = new Intent(context, PermissionRequestActivity.class);
        intent.putExtra(PermissionRequestActivity.EXTRA_SPECIAL_PERMISSION_ID, i4);
        intent.putExtra("title", str);
        PendingIntent activity = PendingIntent.getActivity(context, num.intValue(), intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        String sb2 = sb.toString();
        builder.setContentTitle(string).setWhen(System.currentTimeMillis()).setContentText(sb2).setContentIntent(activity).setSmallIcon(R.drawable.ic_warning_white_24dp).setAutoCancel(true).setColor(ContextCompat.getColor(context, R.color.md_red_500)).setStyle(new NotificationCompat.BigTextStyle().bigText(sb2)).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY);
        ((NotificationManager) context.getSystemService("notification")).notify(num.intValue(), builder.build());
        SystemLog.logErrorDontTrigger(sb2);
    }
}
