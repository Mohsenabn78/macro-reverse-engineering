package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TimePicker;
import androidx.appcompat.view.ContextThemeWrapper;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.TimeOfDayConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.widget.MacroDroidTimePickerDialog;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class TimeOfDayConstraint extends Constraint {
    public static final Parcelable.Creator<TimeOfDayConstraint> CREATOR = new a();
    private int m_endHour;
    private int m_endMinute;
    private int m_startHour;
    private int m_startMinute;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<TimeOfDayConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeOfDayConstraint createFromParcel(Parcel parcel) {
            return new TimeOfDayConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TimeOfDayConstraint[] newArray(int i4) {
            return new TimeOfDayConstraint[i4];
        }
    }

    /* synthetic */ TimeOfDayConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(MacroDroidTimePickerDialog macroDroidTimePickerDialog, DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        TimePicker timePicker = macroDroidTimePickerDialog.getTimePicker();
        timePicker.clearFocus();
        this.m_endMinute = timePicker.getCurrentMinute().intValue();
        this.m_endHour = timePicker.getCurrentHour().intValue();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(MacroDroidTimePickerDialog macroDroidTimePickerDialog, DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        TimePicker timePicker = macroDroidTimePickerDialog.getTimePicker();
        timePicker.clearFocus();
        this.m_startMinute = timePicker.getCurrentMinute().intValue();
        this.m_startHour = timePicker.getCurrentHour().intValue();
        W();
    }

    private void W() {
        final MacroDroidTimePickerDialog macroDroidTimePickerDialog = new MacroDroidTimePickerDialog(new ContextThemeWrapper(getActivity(), m()), null, this.m_endHour, this.m_endMinute, true);
        macroDroidTimePickerDialog.setTitle(R.string.end_time);
        macroDroidTimePickerDialog.setButton(-2, SelectableItem.r(17039360), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.p4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        macroDroidTimePickerDialog.setButton(-1, SelectableItem.r(17039370), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.q4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TimeOfDayConstraint.this.T(macroDroidTimePickerDialog, dialogInterface, i4);
            }
        });
        macroDroidTimePickerDialog.show();
    }

    private void X() {
        final MacroDroidTimePickerDialog macroDroidTimePickerDialog = new MacroDroidTimePickerDialog(new ContextThemeWrapper(getActivity(), m()), null, this.m_startHour, this.m_startMinute, true);
        macroDroidTimePickerDialog.setTitle(R.string.start_time);
        macroDroidTimePickerDialog.setButton(-2, SelectableItem.r(17039360), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.n4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        macroDroidTimePickerDialog.setButton(-1, SelectableItem.r(17039370), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.o4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TimeOfDayConstraint.this.V(macroDroidTimePickerDialog, dialogInterface, i4);
            }
        });
        macroDroidTimePickerDialog.show();
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        Calendar calendar = Calendar.getInstance();
        int i4 = (calendar.get(11) * 60) + calendar.get(12);
        int i5 = (this.m_startHour * 60) + this.m_startMinute;
        int i6 = (this.m_endHour * 60) + this.m_endMinute;
        if (i4 >= i5) {
            if (i6 < i5 || i4 <= i6) {
                return true;
            }
        } else if (i6 <= i5 && i4 <= i6) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return String.format("%02d", Integer.valueOf(this.m_startHour)) + ":" + String.format("%02d", Integer.valueOf(this.m_startMinute)) + " - " + String.format("%02d", Integer.valueOf(this.m_endHour)) + ":" + String.format("%02d", Integer.valueOf(this.m_endMinute));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return TimeOfDayConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getExtendedDetail();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        X();
    }

    public void setEndTime(int i4, int i5) {
        this.m_endHour = i4;
        this.m_endMinute = i5;
    }

    public void setStartTime(int i4, int i5) {
        this.m_startHour = i4;
        this.m_startMinute = i5;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_startHour);
        parcel.writeInt(this.m_startMinute);
        parcel.writeInt(this.m_endHour);
        parcel.writeInt(this.m_endMinute);
    }

    public TimeOfDayConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public TimeOfDayConstraint() {
        this.m_startHour = 0;
        this.m_startMinute = 0;
        this.m_endHour = 0;
        this.m_endMinute = 0;
    }

    private TimeOfDayConstraint(Parcel parcel) {
        super(parcel);
        this.m_startHour = 0;
        this.m_startMinute = 0;
        this.m_endHour = 0;
        this.m_endMinute = 0;
        this.m_startHour = parcel.readInt();
        this.m_startMinute = parcel.readInt();
        this.m_endHour = parcel.readInt();
        this.m_endMinute = parcel.readInt();
    }
}
