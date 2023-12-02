package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.TakePictureActivity;
import com.arlosoft.macrodroid.action.info.TakePictureActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.HasAndroid10FilePathIssues;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class TakePictureAction extends Action implements HasAndroid10FilePathIssues {
    public static final String CAMERA_ID_EXTRA = "CameraId";
    public static final Parcelable.Creator<TakePictureAction> CREATOR = new a();
    public static final String FILE_PATH = "FilePath";
    public static final String FILE_PATH_URI = "FilePathUri";
    public static final int FLASH_AUTO = 2;
    public static final int FLASH_OFF = 0;
    public static final int FLASH_ON = 1;
    public static final String FLASH_OPTION_EXTRA = "FlashOption";
    private static final int PICKER_ID_SAF = 9876;
    public static final String SHOW_ICON_EXTRA = "ShowIcon";
    private transient TextView dirText;
    private int m_flashOption;
    private String m_path;
    private boolean m_showIcon;
    private boolean m_useFrontCamera;
    private String newPath;
    private String pathName;
    private String pathUri;
    private transient String temporaryPathName;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<TakePictureAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TakePictureAction createFromParcel(Parcel parcel) {
            return new TakePictureAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TakePictureAction[] newArray(int i4) {
            return new TakePictureAction[i4];
        }
    }

    /* synthetic */ TakePictureAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void V() {
        String str;
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && (str = this.pathUri) != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", str);
            }
            getActivity().startActivityForResult(intent, PICKER_ID_SAF);
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) ("   " + SelectableItem.r(R.string.action_write_to_file_select_folder) + "   "), 1).show();
        } catch (Exception unused) {
            Context applicationContext2 = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext2, (CharSequence) ("ACTION_OPEN_DOCUMENT_TREE " + SelectableItem.r(R.string.not_supported)), 0).show();
        }
    }

    private void W() {
        if (!checkActivityAlive()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_take_picture_flash_mode);
        builder.setSingleChoiceItems(a0(), this.m_flashOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.mp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TakePictureAction.this.c0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.np
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TakePictureAction.this.d0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void X() {
        if (!checkActivityAlive()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_take_picture_display_icon);
        builder.setSingleChoiceItems(b0(), !this.m_showIcon ? 1 : 0, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.kp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TakePictureAction.this.e0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.lp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TakePictureAction.this.f0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void Y() {
        if (Build.VERSION.SDK_INT >= 30) {
            this.m_path = null;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_set_path);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        ImageButton imageButton = (ImageButton) appCompatDialog.findViewById(R.id.pick_dir_button);
        ((ViewGroup) appCompatDialog.findViewById(R.id.customFilenameLayout)).setVisibility(8);
        ((RadioGroup) appCompatDialog.findViewById(R.id.filename_radio_buttons)).setVisibility(8);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.directory_text);
        this.dirText = textView;
        String str = this.pathName;
        this.temporaryPathName = str;
        if (this.m_path != null) {
            textView.setText(getPath());
        } else if (str != null) {
            textView.setText(str);
        } else {
            textView.setText("<" + SelectableItem.r(R.string.action_write_to_file_select_folder) + ">");
        }
        this.temporaryPathName = this.pathName;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.op
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TakePictureAction.this.g0(view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TakePictureAction.this.h0(appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private String[] Z() {
        return new String[]{SelectableItem.r(R.string.action_take_picture_front_facing), SelectableItem.r(R.string.action_take_picture_rear_facing)};
    }

    private String[] a0() {
        return new String[]{SelectableItem.r(R.string.action_take_picture_flash_off), SelectableItem.r(R.string.action_take_picture_flash_on), SelectableItem.r(R.string.action_take_picture_flash_auto)};
    }

    private String[] b0() {
        return new String[]{SelectableItem.r(R.string.action_take_picture_show_icon), SelectableItem.r(R.string.action_take_picture_hide_icon)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface, int i4) {
        this.m_flashOption = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(DialogInterface dialogInterface, int i4) {
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(DialogInterface dialogInterface, int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_showIcon = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(DialogInterface dialogInterface, int i4) {
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        V();
    }

    private String getPath() {
        String str = this.newPath;
        if (str != null) {
            return str;
        }
        String str2 = this.m_path;
        if (str2 != null) {
            return str2;
        }
        return new File(Environment.getExternalStorageDirectory(), "MacroDroid/Photos").getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(AppCompatDialog appCompatDialog, View view) {
        String str = this.temporaryPathName;
        if (str == null && this.m_path == null) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.action_write_to_file_select_folder, 1).show();
            return;
        }
        this.pathName = str;
        appCompatDialog.dismiss();
        this.m_path = null;
        this.newPath = null;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(DialogInterface dialogInterface, int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_useFrontCamera = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(DialogInterface dialogInterface, int i4) {
        if (this.m_useFrontCamera) {
            this.m_flashOption = 0;
            X();
            return;
        }
        W();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean canRunWhenInvalid() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        if (!isValid()) {
            return SelectableItem.r(R.string.requires_file_path_reconfiguration_android_10_plus);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = "";
        if (Camera.getNumberOfCameras() <= 1) {
            return "";
        }
        if (this.m_useFrontCamera) {
            return Z()[0];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Z()[1]);
        if (this.m_flashOption != 0) {
            str = ", " + a0()[this.m_flashOption];
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return TakePictureActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT < 30) {
            return new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        return new String[]{"android.permission.CAMERA"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        String str;
        if (i4 == PICKER_ID_SAF && i5 == -1) {
            Uri data = intent.getData();
            this.pathUri = data.toString();
            getContext().getContentResolver().takePersistableUriPermission(data, 3);
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), data);
            DocumentFile documentFileParent = Util.getDocumentFileParent(fromTreeUri);
            StringBuilder sb = new StringBuilder();
            if (documentFileParent != null) {
                str = documentFileParent.getName();
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(fromTreeUri.getName());
            String sb2 = sb.toString();
            this.temporaryPathName = sb2;
            TextView textView = this.dirText;
            if (textView != null) {
                textView.setText(sb2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Camera.getNumberOfCameras() > 1) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i4 = 0; i4 < Camera.getNumberOfCameras(); i4++) {
                Camera.getCameraInfo(i4, cameraInfo);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(R.string.action_take_picture);
            builder.setSingleChoiceItems(Z(), 1 ^ (this.m_useFrontCamera ? 1 : 0), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ip
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    TakePictureAction.this.j0(dialogInterface, i5);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.jp
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    TakePictureAction.this.k0(dialogInterface, i5);
                }
            });
            builder.create().show();
            return;
        }
        X();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4;
        int i5 = 0;
        if (Camera.getNumberOfCameras() > 1) {
            try {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                for (int i6 = 0; i6 < Camera.getNumberOfCameras(); i6++) {
                    Camera.getCameraInfo(i6, cameraInfo);
                    boolean z3 = this.m_useFrontCamera;
                    if ((z3 || cameraInfo.facing != 0) && (!z3 || cameraInfo.facing != 1)) {
                    }
                    i5 = i6;
                }
                i4 = i5;
            } catch (RuntimeException e4) {
                SystemLog.logError("Exception calling getCameraInfo: " + e4.toString(), getMacroGuid().longValue());
            }
            TakePictureActivity.invoke(getContext(), i4, this.m_showIcon, this.m_flashOption, this.pathUri, getPath(), getMacro().getName(), getMacroGuid().longValue());
        }
        i4 = 0;
        TakePictureActivity.invoke(getContext(), i4, this.m_showIcon, this.m_flashOption, this.pathUri, getPath(), getMacro().getName(), getMacroGuid().longValue());
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasAndroid10FilePathIssues
    public boolean isBrokenOnAndroid10() {
        if (Build.VERSION.SDK_INT < 30 || this.m_path == null) {
            return false;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return !isBrokenOnAndroid10();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(!this.m_useFrontCamera ? 1 : 0);
        parcel.writeInt(!this.m_showIcon ? 1 : 0);
        parcel.writeInt(this.m_flashOption);
        parcel.writeString(this.m_path);
        parcel.writeString(this.newPath);
        parcel.writeString(this.pathUri);
        parcel.writeString(this.pathName);
    }

    public TakePictureAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_flashOption = 0;
    }

    public TakePictureAction() {
        this.m_useFrontCamera = true;
        this.m_showIcon = true;
        this.m_path = null;
    }

    private TakePictureAction(Parcel parcel) {
        super(parcel);
        this.m_useFrontCamera = parcel.readInt() == 0;
        this.m_showIcon = parcel.readInt() == 0;
        this.m_flashOption = parcel.readInt();
        this.m_path = parcel.readString();
        this.newPath = parcel.readString();
        this.pathUri = parcel.readString();
        this.pathName = parcel.readString();
    }
}
