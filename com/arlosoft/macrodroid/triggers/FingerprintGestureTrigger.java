package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.FingerprintGestureTriggerInfo;

/* loaded from: classes3.dex */
public class FingerprintGestureTrigger extends Trigger {
    public static final Parcelable.Creator<FingerprintGestureTrigger> CREATOR = new a();
    public static final int OPTION_DOWN = 1;
    public static final int OPTION_LEFT = 2;
    public static final int OPTION_RIGHT = 3;
    public static final int OPTION_UP = 0;
    private int option;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<FingerprintGestureTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FingerprintGestureTrigger createFromParcel(Parcel parcel) {
            return new FingerprintGestureTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FingerprintGestureTrigger[] newArray(int i4) {
            return new FingerprintGestureTrigger[i4];
        }
    }

    /* synthetic */ FingerprintGestureTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(DialogInterface dialogInterface, int i4) {
        super.onItemSelected();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_fingerprint_swipe_up), SelectableItem.r(R.string.trigger_fingerprint_swipe_down), SelectableItem.r(R.string.trigger_fingerprint_swipe_left), SelectableItem.r(R.string.trigger_fingerprint_swipe_right)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    public boolean checkMatchesGesture(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 != 8 || this.option != 1) {
                        return false;
                    }
                    return true;
                } else if (this.option != 0) {
                    return false;
                } else {
                    return true;
                }
            } else if (this.option != 2) {
                return false;
            } else {
                return true;
            }
        } else if (this.option != 3) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return FingerprintGestureTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getName() + " (" + getOptions()[this.option] + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.trigger_fingerprint_gesture);
        builder.setMessage(R.string.trigger_fingerprint_gesture_help);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.u2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                FingerprintGestureTrigger.this.N(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresFingerprintGestureAccessibility() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.option);
    }

    public FingerprintGestureTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public FingerprintGestureTrigger() {
    }

    private FingerprintGestureTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
