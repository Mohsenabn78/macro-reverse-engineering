package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.TouchScreenActionInfo;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class TouchScreenAction extends Action {
    public static final Parcelable.Creator<TouchScreenAction> CREATOR = new c();
    private static final int REQUEST_CODE = 3245;
    private int m_xLocation;
    private int m_yLocation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f2672a;

        a(Activity activity) {
            this.f2672a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i4;
            String str;
            try {
                i4 = Settings.System.getInt(TouchScreenAction.this.getContext().getContentResolver(), "pointer_location");
            } catch (Exception unused) {
                i4 = 0;
            }
            if (i4 == 0) {
                str = "1";
            } else {
                str = "0";
            }
            try {
                if (!RootToolsHelper.isAccessGiven()) {
                    if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
                        HelperSystemCommands.sendSystemSetting(TouchScreenAction.this.getContext(), HelperCommandsKt.HELPER_SETTING_TYPE_SYSTEM, HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT, "pointer_location", str);
                    } else {
                        PermissionsHelper.showNeedsNewHelperFileDialog(this.f2672a, false, false, SelectableItem.r(R.string.helper_apk_required), String.format(SelectableItem.r(R.string.helper_app_required_setting), PermissionsHelper.HELPER_FILE_LINK));
                    }
                } else {
                    Util.runAsRoot(new String[]{"settings put system pointer_location " + str});
                }
            } catch (Exception e4) {
                SystemLog.logError("Could not set pointer_location system setting: " + e4);
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<TouchScreenAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TouchScreenAction createFromParcel(Parcel parcel) {
            return new TouchScreenAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TouchScreenAction[] newArray(int i4) {
            return new TouchScreenAction[i4];
        }
    }

    /* synthetic */ TouchScreenAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Q() {
        int i4;
        Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_ui_interaction_touch_screen_config);
        appCompatDialog.setTitle(R.string.action_touch_screen);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.touch_screen_config_x_location);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.touch_screen_config_y_location);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.touch_screen_resolution_label);
        ((Button) appCompatDialog.findViewById(R.id.showTouchOverlayButton)).setOnClickListener(new a(activity));
        editText.setText("" + this.m_xLocation);
        editText.setSelection(editText.length());
        editText2.setText("" + this.m_yLocation);
        editText2.setSelection(editText2.length());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i5 = 0;
        try {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            i4 = displayMetrics.widthPixels;
        } catch (NoSuchMethodException e4) {
            e = e4;
            i4 = 0;
        }
        try {
            i5 = displayMetrics.heightPixels;
        } catch (NoSuchMethodException e5) {
            e = e5;
            e.printStackTrace();
            textView.setText(SelectableItem.r(R.string.screen_resolution) + ": " + i4 + ", " + i5);
            b bVar = new b(button, editText, editText2);
            editText.addTextChangedListener(bVar);
            editText2.addTextChangedListener(bVar);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TouchScreenAction.this.R(appCompatDialog, editText, editText2, view);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.yq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppCompatDialog.this.cancel();
                }
            });
            appCompatDialog.show();
        }
        textView.setText(SelectableItem.r(R.string.screen_resolution) + ": " + i4 + ", " + i5);
        b bVar2 = new b(button, editText, editText2);
        editText.addTextChangedListener(bVar2);
        editText2.addTextChangedListener(bVar2);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TouchScreenAction.this.R(appCompatDialog, editText, editText2, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.yq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(AppCompatDialog appCompatDialog, EditText editText, EditText editText2, View view) {
        appCompatDialog.cancel();
        try {
            this.m_xLocation = Integer.valueOf(editText.getText().toString()).intValue();
        } catch (Exception unused) {
            this.m_xLocation = 0;
        }
        try {
            this.m_yLocation = Integer.valueOf(editText2.getText().toString()).intValue();
        } catch (Exception unused2) {
            this.m_yLocation = 0;
        }
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_xLocation + "," + this.m_yLocation;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return TouchScreenActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        if (i4 == REQUEST_CODE && i5 != 0) {
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Q();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Util.runAsRoot(new String[]{"input tap " + this.m_xLocation + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_yLocation});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.select_application);
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_xLocation);
        parcel.writeInt(this.m_yLocation);
    }

    public TouchScreenAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private TouchScreenAction() {
    }

    private TouchScreenAction(Parcel parcel) {
        super(parcel);
        this.m_xLocation = parcel.readInt();
        this.m_yLocation = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2674a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2675b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2676c;

        b(Button button, EditText editText, EditText editText2) {
            this.f2674a = button;
            this.f2675b = editText;
            this.f2676c = editText2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2674a;
            if (this.f2675b.getText().length() > 0 && this.f2676c.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
