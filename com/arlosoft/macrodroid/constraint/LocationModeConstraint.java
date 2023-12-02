package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.location.LocationManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.LocationModeConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes3.dex */
public class LocationModeConstraint extends Constraint {
    public static final Parcelable.Creator<LocationModeConstraint> CREATOR = new a();
    private boolean hasNewConfig;
    private boolean[] m_options;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<LocationModeConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LocationModeConstraint createFromParcel(Parcel parcel) {
            return new LocationModeConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LocationModeConstraint[] newArray(int i4) {
            return new LocationModeConstraint[i4];
        }
    }

    /* synthetic */ LocationModeConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] T() {
        return new String[]{SelectableItem.r(R.string.action_set_location_mode_off), SelectableItem.r(R.string.action_set_location_mode_on)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i4, boolean z3) {
        this.m_options[i4] = z3;
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= 4) {
                break;
            } else if (this.m_options[i5]) {
                z4 = true;
                break;
            } else {
                i5++;
            }
        }
        ((AlertDialog) dialogInterface).getButton(-1).setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface, int i4) {
        this.hasNewConfig = true;
        secondaryItemConfirmed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface, int i4) {
        boolean[] zArr = this.m_options;
        zArr[0] = false;
        zArr[1] = false;
        this.m_options[((AlertDialog) dialogInterface).getListView().getCheckedItemPosition()] = true;
        this.hasNewConfig = true;
        secondaryItemConfirmed();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_location_mode_off), SelectableItem.r(R.string.action_set_location_mode_device_only), SelectableItem.r(R.string.action_set_location_mode_battery_saving), SelectableItem.r(R.string.action_set_location_mode_high_accuracy)};
    }

    protected AlertDialog R() {
        AlertDialog create = new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.select_option).setMultiChoiceItems(o(), this.m_options, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.k2
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i4, boolean z3) {
                LocationModeConstraint.this.U(dialogInterface, i4, z3);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.l2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                LocationModeConstraint.this.V(dialogInterface, i4);
            }
        }).create();
        create.show();
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= 4) {
                break;
            } else if (this.m_options[i4]) {
                z3 = true;
                break;
            } else {
                i4++;
            }
        }
        create.getButton(-1).setEnabled(z3);
        return create;
    }

    protected AlertDialog S() {
        AlertDialog create = new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.select_option).setSingleChoiceItems(o(), !this.m_options[0] ? 1 : 0, (DialogInterface.OnClickListener) null).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.m2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                LocationModeConstraint.this.W(dialogInterface, i4);
            }
        }).create();
        create.show();
        return create;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        boolean isLocationEnabled;
        try {
            int i4 = Settings.Secure.getInt(getContext().getContentResolver(), "location_mode");
            if (Build.VERSION.SDK_INT >= 29) {
                isLocationEnabled = ((LocationManager) getContext().getSystemService(FirebaseAnalytics.Param.LOCATION)).isLocationEnabled();
                if (isLocationEnabled) {
                    if (this.hasNewConfig) {
                        return this.m_options[1];
                    }
                    boolean[] zArr = this.m_options;
                    if (zArr[1] || zArr[2] || zArr[3]) {
                        return true;
                    }
                    return false;
                }
                return this.m_options[0];
            }
            return this.m_options[i4];
        } catch (Settings.SettingNotFoundException unused) {
            SystemLog.logError("Cannot query LOCATION_MODE", getMacroGuid().longValue());
            return true;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        String[] o4 = o();
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean[] zArr = this.m_options;
            if (i4 >= zArr.length || i4 >= o4.length) {
                break;
            }
            if (zArr[i4]) {
                if (i5 == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                sb.append(str);
                sb.append(o4[i4]);
                i5++;
            }
            i4++;
        }
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LocationModeConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected AlertDialog l() {
        if (Build.VERSION.SDK_INT >= 29) {
            return S();
        }
        return R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        if (Build.VERSION.SDK_INT >= 29) {
            return T();
        }
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeBooleanArray(this.m_options);
        parcel.writeInt(this.hasNewConfig ? 1 : 0);
    }

    public LocationModeConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private LocationModeConstraint() {
        boolean[] zArr = new boolean[4];
        this.m_options = zArr;
        if (Build.VERSION.SDK_INT >= 29) {
            zArr[0] = true;
        }
    }

    private LocationModeConstraint(Parcel parcel) {
        super(parcel);
        boolean[] zArr = new boolean[4];
        this.m_options = zArr;
        parcel.readBooleanArray(zArr);
        this.hasNewConfig = parcel.readInt() != 0;
    }
}
