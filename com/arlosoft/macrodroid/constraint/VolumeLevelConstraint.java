package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.VolumeLevelConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes3.dex */
public class VolumeLevelConstraint extends Constraint {
    private static final int EQUALS = 2;
    private static final int GREATER_THAN = 1;
    private static final int LESS_THAN = 0;
    private static final int MAX_AUDIO_LEVEL = 100;
    private int m_comparison;
    private boolean[] m_streamIndexArray;
    private int m_volume;
    private static final int[] s_streamConstants = {4, 3, 5, 2, 1, 0, 6};
    public static final Parcelable.Creator<VolumeLevelConstraint> CREATOR = new b();

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<VolumeLevelConstraint> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VolumeLevelConstraint createFromParcel(Parcel parcel) {
            return new VolumeLevelConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VolumeLevelConstraint[] newArray(int i4) {
            return new VolumeLevelConstraint[i4];
        }
    }

    /* synthetic */ VolumeLevelConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String U(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return "=";
            }
            return ">";
        }
        return "<";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(DialogInterface dialogInterface, int i4, boolean z3) {
        boolean z4;
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        Button button = alertDialog.getButton(-1);
        if (alertDialog.getListView().getCheckedItemCount() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        button.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface, int i4) {
        this.m_streamIndexArray = new boolean[s_streamConstants.length];
        SparseBooleanArray checkedItemPositions = ((AlertDialog) dialogInterface).getListView().getCheckedItemPositions();
        for (int i5 = 0; i5 < checkedItemPositions.size(); i5++) {
            if (checkedItemPositions.valueAt(i5)) {
                this.m_streamIndexArray[checkedItemPositions.keyAt(i5)] = true;
            }
        }
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(RadioButton radioButton, RadioButton radioButton2, AppCompatDialog appCompatDialog, View view) {
        int i4;
        if (radioButton.isChecked()) {
            i4 = 0;
        } else if (radioButton2.isChecked()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        this.m_comparison = i4;
        appCompatDialog.dismiss();
        itemComplete();
    }

    private void Z() {
        boolean z3;
        boolean z4;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_volume_constraint);
        appCompatDialog.setTitle(R.string.constraint_volume_level);
        SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.levelSeekBar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.percentLabel);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.greaterThanRadioButton);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.lessThanRadioButton);
        RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.equalsRadioButton);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        seekBar.setProgress(this.m_volume);
        textView.setText(this.m_volume + "%");
        boolean z5 = false;
        if (this.m_comparison == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton2.setChecked(z3);
        if (this.m_comparison == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        radioButton.setChecked(z4);
        if (this.m_comparison == 2) {
            z5 = true;
        }
        radioButton3.setChecked(z5);
        seekBar.setOnSeekBarChangeListener(new a(textView));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.x4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VolumeLevelConstraint.this.X(radioButton2, radioButton, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.y4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private String[] getAudioStreams() {
        return new String[]{SelectableItem.r(R.string.action_set_volume_alarm), SelectableItem.r(R.string.action_set_volume_music), SelectableItem.r(R.string.action_set_volume_notification), SelectableItem.r(R.string.action_set_volume_ringer), SelectableItem.r(R.string.action_set_volume_system_sounds), SelectableItem.r(R.string.action_set_volume_voice_call), SelectableItem.r(R.string.action_set_volume_bluetooth_voice)};
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.m_streamIndexArray;
            if (i4 >= zArr.length) {
                return true;
            }
            if (zArr[i4]) {
                int[] iArr = s_streamConstants;
                int round = (int) Math.round((audioManager.getStreamVolume(iArr[i4]) / audioManager.getStreamMaxVolume(iArr[i4])) * 100.0d);
                int i5 = this.m_comparison;
                if (i5 == 0 && round >= this.m_volume) {
                    return false;
                }
                if (i5 == 1 && round <= this.m_volume) {
                    return false;
                }
                if (i5 == 2 && round != this.m_volume) {
                    return false;
                }
            }
            i4++;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.constraint_volume_level) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + U(this.m_comparison) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_volume + "%";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.m_streamIndexArray;
            if (i4 >= zArr.length) {
                break;
            }
            if (zArr[i4]) {
                sb.append(getAudioStreams()[i4]);
                sb.append(", ");
            }
            i4++;
        }
        if (sb.length() != 0) {
            return sb.substring(0, sb.length() - 2);
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return VolumeLevelConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setMultiChoiceItems(getAudioStreams(), this.m_streamIndexArray, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.v4
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i4, boolean z3) {
                VolumeLevelConstraint.V(dialogInterface, i4, z3);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.w4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                VolumeLevelConstraint.this.W(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.getButton(-1).setEnabled(false);
        for (boolean z3 : this.m_streamIndexArray) {
            if (z3) {
                create.getButton(-1).setEnabled(true);
                return;
            }
        }
    }

    public void setVolume(int i4) {
        this.m_volume = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_streamIndexArray.length);
        parcel.writeBooleanArray(this.m_streamIndexArray);
        parcel.writeInt(this.m_volume);
        parcel.writeInt(this.m_comparison);
    }

    public VolumeLevelConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public VolumeLevelConstraint() {
        this.m_streamIndexArray = new boolean[s_streamConstants.length];
        this.m_volume = 50;
        this.m_comparison = 0;
    }

    private VolumeLevelConstraint(Parcel parcel) {
        super(parcel);
        this.m_streamIndexArray = new boolean[s_streamConstants.length];
        boolean[] zArr = new boolean[parcel.readInt()];
        this.m_streamIndexArray = zArr;
        parcel.readBooleanArray(zArr);
        this.m_volume = parcel.readInt();
        this.m_comparison = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f10242a;

        a(TextView textView) {
            this.f10242a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            VolumeLevelConstraint.this.m_volume = i4;
            TextView textView = this.f10242a;
            textView.setText(VolumeLevelConstraint.this.m_volume + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
