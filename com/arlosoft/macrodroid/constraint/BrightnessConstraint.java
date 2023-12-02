package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.BrightnessConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.PieBrightnessLookup;
import com.arlosoft.macrodroid.utils.UIUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes3.dex */
public class BrightnessConstraint extends Constraint {
    public static final Parcelable.Creator<BrightnessConstraint> CREATOR = new b();
    private static final int DEFAULT_BRIGHTNESS_LEVEL = 50;
    private int m_brightness;
    private boolean m_equals;
    private boolean m_forcePieMode;
    private boolean m_greaterThan;
    private boolean m_isAutoBrightness;
    private transient int m_minBrightness;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<BrightnessConstraint> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BrightnessConstraint createFromParcel(Parcel parcel) {
            return new BrightnessConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BrightnessConstraint[] newArray(int i4) {
            return new BrightnessConstraint[i4];
        }
    }

    /* synthetic */ BrightnessConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(ViewGroup viewGroup, CompoundButton compoundButton, boolean z3) {
        int i4;
        if (z3) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        viewGroup.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(RadioButton radioButton, RadioButton radioButton2, CheckBox checkBox, CheckBox checkBox2, AppCompatDialog appCompatDialog, View view) {
        this.m_greaterThan = radioButton.isChecked();
        this.m_equals = radioButton2.isChecked();
        this.m_isAutoBrightness = checkBox.isChecked();
        this.m_forcePieMode = checkBox2.isChecked();
        appCompatDialog.cancel();
        itemComplete();
    }

    private void init() {
        this.m_minBrightness = UIUtils.getMinimumScreenBrightnessSetting(getContext());
        this.m_greaterThan = false;
        this.m_brightness = 50;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int round;
        try {
            if (this.m_isAutoBrightness) {
                if (Settings.System.getInt(getContext().getContentResolver(), "screen_brightness_mode") == 1) {
                    return true;
                }
                return false;
            }
            int i4 = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
            if (Build.VERSION.SDK_INT >= 28 && this.m_forcePieMode) {
                round = PieBrightnessLookup.lookup(i4, true);
            } else {
                int i5 = this.m_minBrightness;
                round = Math.round(((i4 - i5) / (255 - i5)) * 100.0f);
            }
            if (this.m_equals) {
                if (round == this.m_brightness) {
                    return true;
                }
                return false;
            } else if (this.m_greaterThan) {
                if (round > this.m_brightness) {
                    return true;
                }
                return false;
            } else if (round < this.m_brightness) {
                return true;
            } else {
                return false;
            }
        } catch (Settings.SettingNotFoundException unused) {
            return true;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        if (this.m_isAutoBrightness) {
            return SelectableItem.r(R.string.auto_brightness);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getString(R.string.action_set_brightness));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (this.m_equals) {
            str = "=";
        } else if (this.m_greaterThan) {
            str = ">";
        } else {
            str = "<";
        }
        sb.append(str);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.m_brightness);
        sb.append("%");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BrightnessConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int i4;
        int i5;
        int i6;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.battery_constraint_dialog);
        appCompatDialog.setTitle(R.string.action_set_brightness);
        SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.batteryLevelSeekBar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.batteryPercentLabel);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.greaterThanRadioButton);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.lessThanRadioButton);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.equalsRadioButton);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.auto_brightness_checkbox);
        final ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.value_container);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.use_android_pie_checkbox);
        TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.use_android_pie_text);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView2.setVisibility(i4);
        if (i7 >= 28) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        checkBox2.setVisibility(i5);
        checkBox2.setChecked(this.m_forcePieMode);
        checkBox.setVisibility(0);
        checkBox.setChecked(this.m_isAutoBrightness);
        if (this.m_isAutoBrightness) {
            i6 = 8;
        } else {
            i6 = 0;
        }
        viewGroup.setVisibility(i6);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.v
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                BrightnessConstraint.T(viewGroup, compoundButton, z3);
            }
        });
        seekBar.setProgress(this.m_brightness);
        textView.setText(this.m_brightness + "%");
        if (this.m_equals) {
            radioButton3.setChecked(true);
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
        } else {
            radioButton.setChecked(this.m_greaterThan);
            radioButton2.setChecked(true ^ this.m_greaterThan);
            radioButton3.setChecked(false);
        }
        seekBar.setOnSeekBarChangeListener(new a(textView));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BrightnessConstraint.this.U(radioButton, radioButton3, checkBox, checkBox2, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_greaterThan ? 1 : 0);
        parcel.writeInt(this.m_equals ? 1 : 0);
        parcel.writeInt(this.m_brightness);
        parcel.writeInt(this.m_isAutoBrightness ? 1 : 0);
        parcel.writeInt(this.m_forcePieMode ? 1 : 0);
    }

    public BrightnessConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private BrightnessConstraint() {
        init();
    }

    private BrightnessConstraint(Parcel parcel) {
        super(parcel);
        init();
        this.m_greaterThan = parcel.readInt() != 0;
        this.m_equals = parcel.readInt() != 0;
        this.m_brightness = parcel.readInt();
        this.m_isAutoBrightness = parcel.readInt() != 0;
        this.m_forcePieMode = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f10165a;

        a(TextView textView) {
            this.f10165a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            BrightnessConstraint.this.m_brightness = i4;
            TextView textView = this.f10165a;
            textView.setText(BrightnessConstraint.this.m_brightness + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
