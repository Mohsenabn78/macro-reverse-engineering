package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.PebbleHelper;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.PebbleConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.getpebble.android.kit.PebbleKit;

/* loaded from: classes3.dex */
public class PebbleConstraint extends Constraint {
    private static final int OPTION_PEBBLE_CONNECTED = 0;
    private static final int OPTION_PEBBLE_NOT_CONNECTED = 1;
    private int m_option;
    private static final String[] s_options = {MacroDroidApplication.getInstance().getString(R.string.constraint_pebble_connected), MacroDroidApplication.getInstance().getString(R.string.constraint_pebble_not_connected)};
    public static final Parcelable.Creator<PebbleConstraint> CREATOR = new a();

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<PebbleConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PebbleConstraint createFromParcel(Parcel parcel) {
            return new PebbleConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PebbleConstraint[] newArray(int i4) {
            return new PebbleConstraint[i4];
        }
    }

    /* synthetic */ PebbleConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        super.handleItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                return true;
            }
            return !PebbleKit.isWatchConnected(getContext());
        }
        return PebbleKit.isWatchConnected(getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return s_options[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return PebbleConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Settings.getShownPebbleInfo(getContext())) {
            super.handleItemSelected();
        } else {
            PebbleHelper.displayPebbleInfo(getActivity(), new PebbleHelper.PebbleDialogHandler() { // from class: com.arlosoft.macrodroid.constraint.w3
                @Override // com.arlosoft.macrodroid.common.PebbleHelper.PebbleDialogHandler
                public final void continueSelected() {
                    PebbleConstraint.this.Q();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return s_options;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public PebbleConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private PebbleConstraint() {
        this.m_option = 0;
    }

    private PebbleConstraint(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
