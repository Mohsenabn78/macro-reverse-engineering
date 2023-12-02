package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.ConfigureNotificationBarActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NotificationButton;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.activities.SelectNotificationButtonActivity;
import com.arlosoft.macrodroid.triggers.info.NotificationButtonTriggerInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class NotificationButtonTrigger extends Trigger {
    public static final Parcelable.Creator<NotificationButtonTrigger> CREATOR = new a();
    private int REQUEST_CODE_SELECT_BUTTON;
    private boolean m_collapseNotification;
    private int m_id;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<NotificationButtonTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NotificationButtonTrigger createFromParcel(Parcel parcel) {
            return new NotificationButtonTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NotificationButtonTrigger[] newArray(int i4) {
            return new NotificationButtonTrigger[i4];
        }
    }

    /* synthetic */ NotificationButtonTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(Activity activity, DialogInterface dialogInterface, int i4) {
        activity.startActivity(new Intent(activity, ConfigureNotificationBarActivity.class));
    }

    public boolean getCollapseNotification() {
        return this.m_collapseNotification;
    }

    public int getId() {
        return this.m_id;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return NotificationButtonTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == this.REQUEST_CODE_SELECT_BUTTON && i5 == -1) {
            boolean booleanExtra = intent.getBooleanExtra(SelectNotificationButtonActivity.EXTRA_COLLAPSE_ON_PRESS, true);
            if (booleanExtra && Build.VERSION.SDK_INT >= 31 && !Util.isMacroDroidAccessibilityEnabled(getContext())) {
                PermissionsHelper.showAccessibilityRequiredDialog(activity, false, false, false, false, false);
                return;
            }
            this.m_id = intent.getIntExtra(Util.NOTIFICATION_BUTTON_EXTRA, 0);
            this.m_collapseNotification = booleanExtra;
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        List<NotificationButton> notificationButtons = Settings.getNotificationButtons(getContext());
        final Activity activity = getActivity();
        if (notificationButtons.size() > 0) {
            Intent intent = new Intent(activity, SelectNotificationButtonActivity.class);
            intent.putExtra(SelectNotificationButtonActivity.EXTRA_COLLAPSE_ON_PRESS, this.m_collapseNotification);
            activity.startActivityForResult(intent, this.REQUEST_CODE_SELECT_BUTTON);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setIcon(17301543);
        builder.setMessage(R.string.trigger_notification_button_select_ok).setCancelable(true).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.u5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                NotificationButtonTrigger.N(activity, dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        for (NotificationButton notificationButton : Settings.getNotificationButtons(getContext())) {
            if (notificationButton.getId() == this.m_id) {
                return true;
            }
        }
        return false;
    }

    public void setId(int i4) {
        this.m_id = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_id);
        parcel.writeInt(this.m_collapseNotification ? 1 : 0);
    }

    public NotificationButtonTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public NotificationButtonTrigger() {
        this.REQUEST_CODE_SELECT_BUTTON = 427824;
        this.m_collapseNotification = true;
    }

    private NotificationButtonTrigger(Parcel parcel) {
        super(parcel);
        this.REQUEST_CODE_SELECT_BUTTON = 427824;
        this.m_id = parcel.readInt();
        this.m_collapseNotification = parcel.readInt() != 0;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
