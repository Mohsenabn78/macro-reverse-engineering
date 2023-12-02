package com.arlosoft.macrodroid.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.TorchActivity;
import com.arlosoft.macrodroid.action.info.CameraFlashLightActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasIntegerVariableName;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class CameraFlashLightAction extends Action implements HasIntegerVariableName {
    public static final Parcelable.Creator<CameraFlashLightAction> CREATOR = new e();
    private static Camera s_camera = null;
    private static boolean s_cameraLightOn = false;
    private int brightnessPercent;
    private transient boolean ignoreCallback;
    private boolean m_launchForeground;
    private int m_state;
    private boolean supportsBrightness;
    private DictionaryKeys varDictionaryKeys;
    private String variableName;
    private transient DictionaryKeys workingDictionaryKeys;
    private transient int workingState;
    private transient String workingVariableName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends CameraManager.TorchCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CameraManager f2097a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TriggerContextInfo f2098b;

        a(CameraManager cameraManager, TriggerContextInfo triggerContextInfo) {
            this.f2097a = cameraManager;
            this.f2098b = triggerContextInfo;
        }

        @Override // android.hardware.camera2.CameraManager.TorchCallback
        public void onTorchModeChanged(@NonNull String str, boolean z3) {
            boolean z4;
            super.onTorchModeChanged(str, z3);
            if (CameraFlashLightAction.this.ignoreCallback) {
                return;
            }
            try {
                if (((Integer) this.f2097a.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                    return;
                }
            } catch (Exception unused) {
            }
            int i4 = CameraFlashLightAction.this.m_state;
            if (i4 != 0) {
                if (i4 == 1 || i4 != 2) {
                    z4 = false;
                } else {
                    z4 = !z3;
                }
            } else {
                z4 = true;
            }
            try {
                CameraFlashLightAction.this.ignoreCallback = true;
                this.f2097a.unregisterTorchCallback(this);
            } catch (IllegalArgumentException unused2) {
            }
            try {
                CameraCharacteristics cameraCharacteristics = this.f2097a.getCameraCharacteristics(str);
                if (!z4 || Build.VERSION.SDK_INT < 33 || ((Integer) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_STRENGTH_MAXIMUM_LEVEL)).intValue() <= 1) {
                    this.f2097a.setTorchMode(str, z4);
                    return;
                }
                int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_STRENGTH_MAXIMUM_LEVEL)).intValue();
                int i5 = CameraFlashLightAction.this.brightnessPercent;
                if (CameraFlashLightAction.this.variableName != null) {
                    CameraFlashLightAction cameraFlashLightAction = CameraFlashLightAction.this;
                    MacroDroidVariable variableByName = cameraFlashLightAction.getVariableByName(cameraFlashLightAction.variableName);
                    if (variableByName != null) {
                        Long longValue = variableByName.getLongValue(CameraFlashLightAction.this.varDictionaryKeys);
                        if (longValue != null) {
                            i5 = Math.max(0, Math.min(longValue.intValue(), 100));
                        } else {
                            SystemLog.logError("Variable: " + CameraFlashLightAction.this.variableName + VariableHelper.getFormattedDictionaryKeys(CameraFlashLightAction.this.varDictionaryKeys) + " was not found. Defaulting to 50%", CameraFlashLightAction.this.getMacroGuid().longValue());
                            return;
                        }
                    } else {
                        SystemLog.logError("Variable: " + CameraFlashLightAction.this.variableName + VariableHelper.getFormattedDictionaryKeys(CameraFlashLightAction.this.varDictionaryKeys) + " was not found. Defaulting to 50%", CameraFlashLightAction.this.getMacroGuid().longValue());
                        return;
                    }
                }
                int i6 = (int) (intValue * (i5 / 100.0f));
                if (i6 == 0) {
                    i6 = 1;
                }
                this.f2097a.turnOnTorchWithStrengthLevel(str, i6);
            } catch (CameraAccessException unused3) {
                SystemLog.logError("Could not access camera flash", CameraFlashLightAction.this.getMacroGuid().longValue());
            } catch (SecurityException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
                PermissionsHelper.showNeedsPermission(CameraFlashLightAction.this.getContext(), "android.permission.CAMERA", CameraFlashLightAction.this.getName(), true, false);
            } catch (Exception e5) {
                SystemLog.logError("Failed to set torch mode, trying legacy mechanism: " + e5.toString(), CameraFlashLightAction.this.getMacroGuid().longValue());
                CameraFlashLightAction.this.f0(this.f2098b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends CameraManager.TorchCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CameraManager f2100a;

        b(CameraManager cameraManager) {
            this.f2100a = cameraManager;
        }

        @Override // android.hardware.camera2.CameraManager.TorchCallback
        public void onTorchModeChanged(@NonNull String str, boolean z3) {
            super.onTorchModeChanged(str, z3);
            try {
                this.f2100a.unregisterTorchCallback(this);
            } catch (IllegalArgumentException unused) {
            }
            try {
                CameraCharacteristics cameraCharacteristics = this.f2100a.getCameraCharacteristics(str);
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                    return;
                }
                int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_STRENGTH_MAXIMUM_LEVEL)).intValue();
                if (CameraFlashLightAction.this.workingState == 1 || intValue <= 1) {
                    CameraFlashLightAction.this.supportsBrightness = false;
                    CameraFlashLightAction cameraFlashLightAction = CameraFlashLightAction.this;
                    cameraFlashLightAction.m_state = cameraFlashLightAction.workingState;
                    CameraFlashLightAction.this.itemComplete();
                } else {
                    CameraFlashLightAction.this.showBrightnessLevelDialog();
                }
            } catch (Exception unused2) {
                CameraFlashLightAction.this.supportsBrightness = false;
                CameraFlashLightAction cameraFlashLightAction2 = CameraFlashLightAction.this;
                cameraFlashLightAction2.m_state = cameraFlashLightAction2.workingState;
                CameraFlashLightAction.this.itemComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2102a;

        c(ViewGroup viewGroup) {
            this.f2102a = viewGroup;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            this.f2102a.setVisibility(0);
            CameraFlashLightAction.this.workingVariableName = null;
            CameraFlashLightAction.this.workingDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            this.f2102a.setVisibility(8);
            CameraFlashLightAction.this.workingVariableName = macroDroidVariable.getName();
            CameraFlashLightAction cameraFlashLightAction = CameraFlashLightAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            cameraFlashLightAction.workingDictionaryKeys = dictionaryKeys;
        }
    }

    /* loaded from: classes2.dex */
    class e implements Parcelable.Creator<CameraFlashLightAction> {
        e() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CameraFlashLightAction createFromParcel(Parcel parcel) {
            return new CameraFlashLightAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CameraFlashLightAction[] newArray(int i4) {
            return new CameraFlashLightAction[i4];
        }
    }

    /* synthetic */ CameraFlashLightAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] d0() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_camera_flash_light_light_on), MacroDroidApplication.getInstance().getString(R.string.action_camera_flash_light_light_off), MacroDroidApplication.getInstance().getString(R.string.action_camera_flash_light_light_toggle)};
    }

    @SuppressLint({"NewApi"})
    private void e0(TriggerContextInfo triggerContextInfo) {
        CameraManager cameraManager = (CameraManager) getContext().getSystemService("camera");
        this.ignoreCallback = false;
        try {
            cameraManager.registerTorchCallback(new a(cameraManager, triggerContextInfo), (Handler) null);
        } catch (Exception e4) {
            SystemLog.logError("Failed to set torch mode, tring legacy mechanism: " + e4.toString(), getMacroGuid().longValue());
            f0(triggerContextInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f0(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        boolean z4;
        int i4 = this.m_state;
        if (i4 != 0) {
            if (i4 == 1 || i4 != 2) {
                z3 = false;
            } else {
                if (this.m_launchForeground) {
                    z4 = TorchActivity.isTorchActive();
                } else {
                    z4 = s_cameraLightOn;
                }
                z3 = !z4;
            }
        } else {
            z3 = true;
        }
        if (this.m_launchForeground) {
            if (z3) {
                Intent intent = new Intent(getContext(), TorchActivity.class);
                intent.addFlags(268435456);
                getContext().startActivity(intent);
            } else {
                TorchActivity.kill();
            }
        } else {
            try {
                if (z3) {
                    if (!s_cameraLightOn) {
                        if (s_camera == null) {
                            s_camera = Camera.open();
                        }
                        s_cameraLightOn = true;
                        Camera.Parameters parameters = s_camera.getParameters();
                        parameters.setFlashMode("torch");
                        s_camera.setParameters(parameters);
                        s_camera.startPreview();
                    }
                } else if (s_cameraLightOn) {
                    if (s_camera == null) {
                        s_camera = Camera.open();
                    }
                    s_cameraLightOn = false;
                    s_camera.stopPreview();
                    s_camera.release();
                    s_camera = null;
                }
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Error enabling camera flash light: " + e4.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(DialogInterface dialogInterface, int i4) {
        this.workingState = i4;
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_camera_flash_light_background), MacroDroidApplication.getInstance().getString(R.string.action_camera_flash_light_foreground)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(DialogInterface dialogInterface, int i4) {
        if (Build.VERSION.SDK_INT >= 33) {
            CameraManager cameraManager = (CameraManager) getContext().getSystemService("camera");
            cameraManager.registerTorchCallback(new b(cameraManager), (Handler) null);
            return;
        }
        this.m_state = this.workingState;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean i0(Spinner spinner, View view, MotionEvent motionEvent) {
        if (spinner.getAdapter().getCount() > 1) {
            return false;
        }
        ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_integer_variables_defined, 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Spinner spinner, SeekBar seekBar, AppCompatDialog appCompatDialog, View view) {
        this.supportsBrightness = true;
        spinner.getSelectedItemPosition();
        this.m_state = this.workingState;
        this.variableName = this.workingVariableName;
        this.varDictionaryKeys = this.workingDictionaryKeys;
        this.brightnessPercent = seekBar.getProgress();
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3 = true;
        if (i4 != 1) {
            z3 = false;
        }
        this.m_launchForeground = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_launchForeground ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return d0()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String valueOf;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33 && this.supportsBrightness) {
            if (this.m_state == 1) {
                return "";
            }
            String r4 = SelectableItem.r(R.string.torch_brightness_level);
            Object[] objArr = new Object[1];
            if (this.variableName != null) {
                valueOf = this.variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
            } else {
                valueOf = String.valueOf(this.brightnessPercent);
            }
            objArr[0] = valueOf;
            return String.format(r4, objArr);
        } else if (i4 >= 23) {
            return "";
        } else {
            return getOptions()[this.m_launchForeground ? 1 : 0];
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return CameraFlashLightActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.variableName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.m_launchForeground = false;
            secondaryItemConfirmed();
            return;
        }
        super.handleItemSelected();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (Build.VERSION.SDK_INT >= 23) {
            e0(triggerContextInfo);
        } else {
            f0(triggerContextInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        String r4 = SelectableItem.r(R.string.select_option);
        this.workingState = this.m_state;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(r4);
        builder.setSingleChoiceItems(d0(), this.m_state, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.i1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CameraFlashLightAction.this.g0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.j1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CameraFlashLightAction.this.h0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(@Nullable String str) {
        this.variableName = str;
    }

    public void showBrightnessLevelDialog() {
        String str;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_torch_brightness);
        appCompatDialog.setTitle(R.string.action_android_wear_set_brightness);
        this.workingVariableName = this.variableName;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.seek_bar);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.option_spinner);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.seek_bar_layout);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.percent_text);
        getAllIntegerVariables();
        int i4 = this.brightnessPercent;
        textView.setText(this.brightnessPercent + "%");
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.use_slider_value));
        Activity activity = getActivity();
        Macro macro = getMacro();
        if (this.variableName != null) {
            str = this.variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureNumberVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList, str, "", false, new c(viewGroup));
        if (this.workingVariableName == null) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        spinner.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.action.f1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean i02;
                i02 = CameraFlashLightAction.this.i0(spinner, view, motionEvent);
                return i02;
            }
        });
        seekBar.setProgress(Math.round(i4));
        seekBar.setOnSeekBarChangeListener(new d(textView));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraFlashLightAction.this.j0(spinner, seekBar, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
        parcel.writeInt(this.m_launchForeground ? 1 : 0);
        parcel.writeInt(this.brightnessPercent);
        parcel.writeString(this.variableName);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
        parcel.writeInt(this.supportsBrightness ? 1 : 0);
    }

    public CameraFlashLightAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private CameraFlashLightAction() {
        this.brightnessPercent = 100;
        this.supportsBrightness = true;
        this.m_launchForeground = false;
    }

    private CameraFlashLightAction(Parcel parcel) {
        super(parcel);
        this.brightnessPercent = 100;
        this.supportsBrightness = true;
        this.m_state = parcel.readInt();
        this.m_launchForeground = parcel.readInt() != 0;
        this.brightnessPercent = parcel.readInt();
        this.variableName = parcel.readString();
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.supportsBrightness = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f2104a;

        d(TextView textView) {
            this.f2104a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            TextView textView = this.f2104a;
            textView.setText(i4 + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
