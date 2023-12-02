package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SecureSettingsActionInfo;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.ArrayList;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SecureSettingsAction extends LaunchShortcutAction {
    public static final Parcelable.Creator<SecureSettingsAction> CREATOR = new a();
    private static final int PICK_SHORTCUT_REQUEST_CODE = 124;
    protected String m_secondaryClassType;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SecureSettingsAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SecureSettingsAction createFromParcel(Parcel parcel) {
            return new SecureSettingsAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SecureSettingsAction[] newArray(int i4) {
            return new SecureSettingsAction[i4];
        }
    }

    /* synthetic */ SecureSettingsAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(Activity activity, DialogInterface dialogInterface, int i4) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.intangibleobject.securesettings.plugin")));
        } catch (ActivityNotFoundException unused) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.intangibleobject.securesettings.plugin"));
            activity.startActivity(intent);
        }
    }

    @Override // com.arlosoft.macrodroid.action.LaunchShortcutAction, com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getName();
    }

    @Override // com.arlosoft.macrodroid.action.LaunchShortcutAction, com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_name;
    }

    @Override // com.arlosoft.macrodroid.action.LaunchShortcutAction, com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SecureSettingsActionInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.LaunchShortcutAction, com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        final Activity activity = getActivity();
        if (!ApplicationChecker.isSecureSettingsInstalled()) {
            String r4 = SelectableItem.r(R.string.action_secure_settings_description);
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
            builder.setTitle(SelectableItem.r(R.string.action_secure_settings));
            builder.setMessage(r4);
            builder.setPositiveButton(R.string.download_app, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dh
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    SecureSettingsAction.Y(activity, dialogInterface, i4);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.show();
            return;
        }
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(SelectableItem.r(R.string.applications));
        bundle.putStringArrayList("android.intent.extra.shortcut.NAME", arrayList);
        bundle.putParcelableArrayList("android.intent.extra.shortcut.ICON_RESOURCE", new ArrayList<>());
        try {
            Intent intent = new Intent();
            intent.setClassName("com.intangibleobject.securesettings.plugin", "com.intangibleobject.securesettings.plugin.Activities.ShortcutActivity");
            activity.startActivityForResult(intent, 124);
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.action_secure_settings_not_found, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.LaunchShortcutAction, com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.select_application);
    }

    public SecureSettingsAction(Activity activity, Macro macro) {
        super(activity, macro);
        this.m_secondaryClassType = "SecureSettingsAction";
    }

    public SecureSettingsAction() {
        this.m_secondaryClassType = "SecureSettingsAction";
    }

    private SecureSettingsAction(Parcel parcel) {
        super(parcel);
        this.m_secondaryClassType = "SecureSettingsAction";
    }
}
