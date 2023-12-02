package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.action.info.SetRingtoneActionInfo;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetRingtoneAction extends Action {
    public static final Parcelable.Creator<SetRingtoneAction> CREATOR = new a();
    private static final int REQUEST_CODE_RINGTONE_PICKER = 3898423;
    private String m_ringtoneName;
    private String m_ringtoneUri;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetRingtoneAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetRingtoneAction createFromParcel(Parcel parcel) {
            return new SetRingtoneAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetRingtoneAction[] newArray(int i4) {
            return new SetRingtoneAction[i4];
        }
    }

    /* synthetic */ SetRingtoneAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = this.m_ringtoneName;
        if (str != null) {
            return str;
        }
        if (this.m_ringtoneUri != null) {
            try {
                return RingtoneManager.getRingtone(getContext(), Uri.parse(this.m_ringtoneUri)).getTitle(getContext());
            } catch (Exception unused) {
            }
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetRingtoneActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            return new String[]{"android.permission.READ_MEDIA_AUDIO"};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        if (i4 == REQUEST_CODE_RINGTONE_PICKER) {
            if (i5 == -1) {
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                if (uri != null) {
                    this.m_ringtoneUri = uri.toString();
                    this.m_ringtoneName = null;
                } else {
                    this.m_ringtoneName = Constants.RINGTONE_NONE;
                    this.m_ringtoneUri = null;
                }
                itemComplete();
                return;
            }
            handleItemCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        try {
            Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
            intent.putExtra("android.intent.extra.ringtone.TYPE", 1);
            intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", false);
            intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
            String str = this.m_ringtoneUri;
            if (str != null) {
                intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Uri.parse(str));
                intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(this.m_ringtoneUri));
            }
            getActivity().startActivityForResult(intent, REQUEST_CODE_RINGTONE_PICKER);
        } catch (SecurityException e4) {
            SystemLog.logError("This device does not allow the ringtone picker to be called from a third party app: " + e4.toString());
            ToastCompat.makeText(getContext(), (CharSequence) "This device does not allow the ringtone picker to be called from a third party app", 1).show();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        RingtoneManager ringtoneManager = new RingtoneManager(getContext());
        if (this.m_ringtoneUri != null) {
            try {
                RingtoneManager.setActualDefaultRingtoneUri(getContext(), 1, Uri.parse(this.m_ringtoneUri));
            } catch (SecurityException unused) {
                if (Build.VERSION.SDK_INT >= 33) {
                    PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_MEDIA_AUDIO", getName(), true, false);
                } else {
                    PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_EXTERNAL_STORAGE", getName(), true, false);
                }
            } catch (Exception e4) {
                SystemLog.logError("Failed to set ringtone: " + e4.toString(), getMacroGuid().longValue());
            }
        } else if (this.m_ringtoneName.equals(Constants.RINGTONE_NONE)) {
            RingtoneManager.setActualDefaultRingtoneUri(getContext(), 1, null);
        } else {
            List<String> ringtoneSounds = Util.getRingtoneSounds(getContext(), 1, false);
            for (int i4 = 0; i4 < ringtoneSounds.size(); i4++) {
                if (ringtoneSounds.get(i4).equals(this.m_ringtoneName)) {
                    Cursor cursor = ringtoneManager.getCursor();
                    RingtoneManager.setActualDefaultRingtoneUri(getContext(), 1, ringtoneManager.getRingtoneUri(i4));
                    cursor.close();
                    return;
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresWriteSettings() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_ringtoneName);
        parcel.writeString(this.m_ringtoneUri);
    }

    public SetRingtoneAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetRingtoneAction() {
    }

    private SetRingtoneAction(Parcel parcel) {
        super(parcel);
        this.m_ringtoneName = parcel.readString();
        this.m_ringtoneUri = parcel.readString();
    }
}
