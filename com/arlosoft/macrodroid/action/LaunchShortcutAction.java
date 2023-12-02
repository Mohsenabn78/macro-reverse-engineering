package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.LaunchShortcutActionInfo;
import com.arlosoft.macrodroid.common.AppListAdapter;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class LaunchShortcutAction extends Action {
    public static final Parcelable.Creator<LaunchShortcutAction> CREATOR = new a();
    private static final int PICK_SHORTCUT_REQUEST_CODE = 124;
    private String m_appName;
    protected Intent m_intent;
    private String m_intentEncoded;
    protected String m_name;
    private transient Button m_okButton;
    private transient int m_selectedIndex;
    private String m_serializedExtras;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<LaunchShortcutAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LaunchShortcutAction createFromParcel(Parcel parcel) {
            return new LaunchShortcutAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LaunchShortcutAction[] newArray(int i4) {
            return new LaunchShortcutAction[i4];
        }
    }

    public LaunchShortcutAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private Bundle R(String str) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        gZIPInputStream.close();
                        obtain.unmarshall(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                        obtain.setDataPosition(0);
                        return obtain.readBundle();
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                obtain.recycle();
                return null;
            }
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(DialogInterface dialogInterface, int i4) {
        this.m_selectedIndex = i4;
        Button button = this.m_okButton;
        if (button != null) {
            button.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
        this.m_okButton = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(List list, Activity activity, String[] strArr, DialogInterface dialogInterface, int i4) {
        Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
        ActivityInfo activityInfo = ((ResolveInfo) list.get(this.m_selectedIndex)).activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        try {
            activity.startActivityForResult(intent, 124);
        } catch (Exception unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.error, 0).show();
        }
        this.m_appName = strArr[this.m_selectedIndex];
        this.m_okButton = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface) {
        this.m_okButton = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private String getPackageName() {
        try {
            String str = this.m_intentEncoded;
            return str.substring(str.indexOf("component=") + 10, this.m_intentEncoded.indexOf(RemoteSettings.FORWARD_SLASH_STRING));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.action_launch_shortcut) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_appName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_name;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LaunchShortcutActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + ": " + this.m_name;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == 124 && i5 == -1) {
            Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
            this.m_name = intent.getStringExtra("android.intent.extra.shortcut.NAME");
            if (intent2 != null) {
                this.m_intentEncoded = intent2.toURI();
                itemComplete();
                return;
            }
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.shortcut_not_compatible, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        final Activity activity = getActivity();
        PackageManager packageManager = activity.getPackageManager();
        final List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0);
        Collections.sort(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
        final String[] strArr = new String[queryIntentActivities.size()];
        for (int i4 = 0; i4 < queryIntentActivities.size(); i4++) {
            strArr[i4] = queryIntentActivities.get(i4).loadLabel(packageManager).toString();
        }
        AppListAdapter appListAdapter = new AppListAdapter(new ContextThemeWrapper(activity, m()), R.layout.application_item, queryIntentActivities, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.e9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                LaunchShortcutAction.this.S(dialogInterface, i5);
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(appListAdapter, 0, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.f9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                LaunchShortcutAction.this.T(dialogInterface, i5);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.g9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                LaunchShortcutAction.this.U(queryIntentActivities, activity, strArr, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.h9
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LaunchShortcutAction.this.V(dialogInterface);
            }
        });
        Button button = create.getButton(-1);
        this.m_okButton = button;
        button.setEnabled(false);
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.i9
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LaunchShortcutAction.this.W(dialogInterface);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        String packageName = getPackageName();
        if (packageName == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            intent2.addFlags(268435456);
            getContext().startActivity(intent2);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Bundle R;
        try {
            Intent intent = this.m_intent;
            String str = this.m_intentEncoded;
            if (str != null) {
                intent = Intent.getIntent(str);
            }
            if (intent != null) {
                String str2 = this.m_serializedExtras;
                if (str2 != null && (R = R(str2)) != null) {
                    intent.putExtras(R);
                }
                intent.addFlags(268435456);
                getContext().startActivity(intent);
                return;
            }
            Util.displayNotification(getContext(), SelectableItem.r(R.string.action_launch_failed_to_launch) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_name, SelectableItem.r(R.string.action_launch_shortcut_been_removed), false);
        } catch (SecurityException e4) {
            SystemLog.logError("Failed to launch shortcut, MacroDroid may need a permission: " + e4.toString(), getMacroGuid().longValue());
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) e4.toString(), 1).show();
        } catch (Exception e5) {
            Util.displayNotification(getContext(), SelectableItem.r(R.string.action_launch_failed_to_launch) + this.m_name, SelectableItem.r(R.string.action_launch_shortcut_could_not_start) + " :" + e5.toString(), false);
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to launch shortcut: ");
            sb.append(e5.toString());
            SystemLog.logError(sb.toString(), getMacroGuid().longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (this.m_intent == null && this.m_intentEncoded == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.action_launch_shortcut_select);
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_name);
        parcel.writeString(this.m_appName);
        parcel.writeParcelable(this.m_intent, i4);
        parcel.writeString(this.m_serializedExtras);
        parcel.writeString(this.m_intentEncoded);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaunchShortcutAction() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LaunchShortcutAction(Parcel parcel) {
        super(parcel);
        this.m_name = parcel.readString();
        this.m_appName = parcel.readString();
        this.m_intent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.m_serializedExtras = parcel.readString();
        this.m_intentEncoded = parcel.readString();
    }
}
