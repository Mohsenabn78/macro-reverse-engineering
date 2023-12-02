package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.PriorityModeConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class PriorityModeConstraint extends Constraint {
    public static final Parcelable.Creator<PriorityModeConstraint> CREATOR = new a();
    private boolean m_inMode;
    private int m_selectedIndex;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<PriorityModeConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PriorityModeConstraint createFromParcel(Parcel parcel) {
            return new PriorityModeConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PriorityModeConstraint[] newArray(int i4) {
            return new PriorityModeConstraint[i4];
        }
    }

    /* synthetic */ PriorityModeConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] S() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_priority_mode_is_in_mode), MacroDroidApplication.getInstance().getString(R.string.constraint_priority_mode_not_in_mode)};
    }

    private String[] T() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_set_priority_mode_all), MacroDroidApplication.getInstance().getString(R.string.action_set_priority_mode_priority), MacroDroidApplication.getInstance().getString(R.string.action_set_priority_mode_none)};
    }

    private String[] U() {
        return new String[]{SelectableItem.r(R.string.action_set_priority_mode_all), SelectableItem.r(R.string.action_set_priority_mode_priority), SelectableItem.r(R.string.action_set_priority_mode_none), SelectableItem.r(R.string.action_set_priority_mode_alarm_only)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface, int i4) {
        this.m_selectedIndex = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_inMode = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int currentInterruptionFilter;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (Build.VERSION.SDK_INT >= 23) {
            currentInterruptionFilter = ((NotificationManager) getContext().getSystemService("notification")).getCurrentInterruptionFilter();
            int i4 = this.m_selectedIndex;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return true;
                        }
                        if (currentInterruptionFilter == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6 != this.m_inMode) {
                            return false;
                        }
                        return true;
                    }
                    if (currentInterruptionFilter == 3) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5 != this.m_inMode) {
                        return false;
                    }
                    return true;
                }
                if (currentInterruptionFilter == 2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4 != this.m_inMode) {
                    return false;
                }
                return true;
            }
            boolean z7 = this.m_inMode;
            if (currentInterruptionFilter == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 != z7) {
                return false;
            }
            return true;
        }
        int i5 = Settings.Global.getInt(getContext().getContentResolver(), "zen_mode", 0);
        if (this.m_inMode) {
            if (i5 != this.m_selectedIndex) {
                return false;
            }
            return true;
        } else if (i5 == this.m_selectedIndex) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_inMode ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return S()[!this.m_inMode ? 1 : 0] + ": " + U()[this.m_selectedIndex];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return PriorityModeConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getExtendedDetail();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return S();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        String[] T;
        if (checkActivityAlive()) {
            if (Build.VERSION.SDK_INT >= 23) {
                T = U();
            } else {
                T = T();
            }
            if (this.m_selectedIndex >= T.length) {
                this.m_selectedIndex = 0;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(S()[!this.m_inMode ? 1 : 0]);
            builder.setSingleChoiceItems(T, this.m_selectedIndex, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.y3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    PriorityModeConstraint.this.V(dialogInterface, i4);
                }
            });
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.z3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    PriorityModeConstraint.this.W(dialogInterface, i4);
                }
            });
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.a4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    PriorityModeConstraint.this.X(dialogInterface, i4);
                }
            });
            AlertDialog create = builder.create();
            create.show();
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.constraint.b4
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    PriorityModeConstraint.this.Y(dialogInterface);
                }
            });
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_selectedIndex);
        parcel.writeInt(this.m_inMode ? 1 : 0);
    }

    public PriorityModeConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private PriorityModeConstraint() {
        this.m_selectedIndex = 0;
        this.m_inMode = true;
    }

    private PriorityModeConstraint(Parcel parcel) {
        super(parcel);
        this.m_selectedIndex = parcel.readInt();
        this.m_inMode = parcel.readInt() != 0;
    }
}
