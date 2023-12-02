package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.WifiHotSpotConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;

/* loaded from: classes3.dex */
public class WifiHotSpotConstraint extends Constraint {
    public static final int AP_STATE_DISABLED = 1;
    public static final int AP_STATE_DISABLING = 0;
    public static final int AP_STATE_ENABLED = 3;
    public static final int AP_STATE_ENABLING = 2;
    public static final int AP_STATE_FAILED = 4;
    private static final int COMPARISON_EQUALS = 0;
    private static final int COMPARISON_GREATER_THAN = 2;
    private static final int COMPARISON_LESS_THAN = 1;
    public static final Parcelable.Creator<WifiHotSpotConstraint> CREATOR = new b();
    private boolean m_checkConnections;
    private int m_comparisonValue;
    private int m_connectedCount;
    private boolean m_enabled;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<WifiHotSpotConstraint> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WifiHotSpotConstraint createFromParcel(Parcel parcel) {
            return new WifiHotSpotConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WifiHotSpotConstraint[] newArray(int i4) {
            return new WifiHotSpotConstraint[i4];
        }
    }

    /* synthetic */ WifiHotSpotConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private int U(boolean z3) {
        int i4;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        BufferedReader bufferedReader = null;
        int i5 = 0;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/net/arp"));
            i4 = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split(" +");
                        if (split != null && split.length > 4 && split[3].matches("..:..:..:..:..:..") && (!z3 || InetAddress.getByName(split[0]).isReachable(200))) {
                            i4++;
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                } catch (Exception unused2) {
                    i5 = i4;
                    bufferedReader = bufferedReader2;
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                    i4 = i5;
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().build());
                    return i4;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                    throw th;
                }
            }
            bufferedReader2.close();
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().build());
        return i4;
    }

    private void V() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.hotspot_devices_constraint_dialog);
        appCompatDialog.setTitle(R.string.constraint_wifi_hotspot_devices_connected);
        SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.hotspot_devices_constraint_dialog_seek_bar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.hotspot_devices_constraint_dialog_value);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.hotspot_devices_constraint_dialog_equals);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.hotspot_devices_constraint_dialog_greater_than);
        RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.hotspot_devices_constraint_dialog_less_than);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        seekBar.setProgress(this.m_connectedCount);
        textView.setText("" + this.m_connectedCount);
        int i4 = this.m_comparisonValue;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    radioButton2.setChecked(true);
                }
            } else {
                radioButton3.setChecked(true);
            }
        } else {
            radioButton.setChecked(true);
        }
        seekBar.setOnSeekBarChangeListener(new a(textView));
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.f5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                WifiHotSpotConstraint.this.X(compoundButton, z3);
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.g5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                WifiHotSpotConstraint.this.Y(compoundButton, z3);
            }
        });
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.h5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                WifiHotSpotConstraint.this.Z(compoundButton, z3);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.i5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiHotSpotConstraint.this.a0(appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.j5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private String[] W() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_wifi_hotspot_on), MacroDroidApplication.getInstance().getString(R.string.constraint_wifi_hotspot_off)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(CompoundButton compoundButton, boolean z3) {
        if (z3) {
            this.m_comparisonValue = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(CompoundButton compoundButton, boolean z3) {
        if (z3) {
            this.m_comparisonValue = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(CompoundButton compoundButton, boolean z3) {
        if (z3) {
            this.m_comparisonValue = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(AppCompatDialog appCompatDialog, View view) {
        appCompatDialog.cancel();
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_wifi_hotspot_on), MacroDroidApplication.getInstance().getString(R.string.constraint_wifi_hotspot_count), MacroDroidApplication.getInstance().getString(R.string.constraint_wifi_hotspot_off)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    this.m_enabled = false;
                    this.m_checkConnections = false;
                    return;
                }
                return;
            } else if (Build.VERSION.SDK_INT < 29) {
                this.m_enabled = true;
                this.m_checkConnections = true;
                return;
            } else {
                this.m_enabled = false;
                this.m_checkConnections = false;
                return;
            }
        }
        this.m_enabled = true;
        this.m_checkConnections = false;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int intValue;
        WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService("wifi");
        try {
            Method declaredMethod = wifiManager.getClass().getDeclaredMethod("getWifiApState", new Class[0]);
            declaredMethod.setAccessible(true);
            intValue = ((Integer) declaredMethod.invoke(wifiManager, null)).intValue();
            if (intValue > 10) {
                intValue -= 10;
            }
        } catch (Exception e4) {
            SystemLog.logError("Error getting wifi AP State: " + e4.getMessage(), getMacroGuid().longValue());
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Error getting wifi AP State: " + e4.getMessage()));
        }
        if (intValue != 0 && intValue != 1) {
            if (intValue != 2 && intValue != 3) {
                if (intValue != 4) {
                }
            } else {
                if (this.m_checkConnections && Build.VERSION.SDK_INT < 29) {
                    int U = U(true);
                    int i4 = this.m_comparisonValue;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2 || U > this.m_connectedCount) {
                                return true;
                            }
                            return false;
                        } else if (U < this.m_connectedCount) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (U == this.m_connectedCount) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return this.m_enabled;
            }
            return true;
        }
        return !this.m_enabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.m_enabled) {
                if (this.m_checkConnections) {
                    return 1;
                }
                return 0;
            }
            return 2;
        }
        return !this.m_enabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredNameFlowControl() {
        return getExtendedDetail();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        if (this.m_enabled) {
            if (this.m_checkConnections && Build.VERSION.SDK_INT < 29) {
                StringBuilder sb = new StringBuilder();
                sb.append(SelectableItem.r(R.string.constraint_wifi_hotspot_devices_connected));
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                int i4 = this.m_comparisonValue;
                if (i4 == 0) {
                    str = "=";
                } else if (i4 == 1) {
                    str = "<";
                } else {
                    str = ">";
                }
                sb.append(str);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append(this.m_connectedCount);
                return sb.toString();
            }
            return getOptions()[0];
        }
        return getOptions()[2];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return WifiHotSpotConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        if (Build.VERSION.SDK_INT < 29) {
            return getOptions();
        }
        return W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.constraint_wifi_hotspot_select_state);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_checkConnections) {
            V();
        } else {
            super.secondaryItemConfirmed();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_enabled ? 1 : 0);
        parcel.writeInt(this.m_connectedCount);
        parcel.writeInt(this.m_comparisonValue);
        parcel.writeInt(this.m_checkConnections ? 1 : 0);
    }

    public WifiHotSpotConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private WifiHotSpotConstraint() {
        this.m_enabled = true;
        this.m_connectedCount = 0;
        this.m_comparisonValue = 0;
        this.m_checkConnections = false;
    }

    private WifiHotSpotConstraint(Parcel parcel) {
        super(parcel);
        this.m_enabled = parcel.readInt() != 0;
        this.m_connectedCount = parcel.readInt();
        this.m_comparisonValue = parcel.readInt();
        this.m_checkConnections = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f10247a;

        a(TextView textView) {
            this.f10247a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            WifiHotSpotConstraint.this.m_connectedCount = i4;
            TextView textView = this.f10247a;
            textView.setText("" + i4);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
