package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.MediaButtonPressedTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.MediaButtonTriggerReceiver;

/* loaded from: classes3.dex */
public class MediaButtonPressedTrigger extends Trigger {
    private static AudioManager s_audioManager;
    private static Handler s_handler;
    private static MediaButtonTriggerReceiver s_mediaButtonTriggerReceiver;
    private static ComponentName s_remoteControlResponder;
    private static ScreenOnOffReceiver s_screenOnOffTriggerReceiver;
    private boolean m_cancelPress;
    private String m_option;
    public static final String PRESS = MacroDroidApplication.getInstance().getString(R.string.trigger_media_button_pressed_single_press);
    public static final String DOUBLE_PRESS = MacroDroidApplication.getInstance().getString(R.string.trigger_media_button_pressed_2_presses);
    public static final String TRIPLE_PRESS = MacroDroidApplication.getInstance().getString(R.string.trigger_media_button_pressed_3_presses);
    public static final String LONG_PRESS = MacroDroidApplication.getInstance().getString(R.string.trigger_media_button_pressed_long_press);
    private static int s_triggerCounter = 0;
    public static final Parcelable.Creator<MediaButtonPressedTrigger> CREATOR = new b();

    /* loaded from: classes3.dex */
    public static class ScreenOnOffReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            intent.getAction().equals("android.intent.action.SCREEN_ON");
            if (MediaButtonPressedTrigger.s_audioManager != null) {
                MediaButtonPressedTrigger.s_audioManager.registerMediaButtonEventReceiver(MediaButtonPressedTrigger.s_remoteControlResponder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaButtonPressedTrigger.s_audioManager.registerMediaButtonEventReceiver(MediaButtonPressedTrigger.s_remoteControlResponder);
            MediaButtonPressedTrigger.s_handler.postDelayed(this, 5000L);
        }
    }

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<MediaButtonPressedTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MediaButtonPressedTrigger createFromParcel(Parcel parcel) {
            return new MediaButtonPressedTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaButtonPressedTrigger[] newArray(int i4) {
            return new MediaButtonPressedTrigger[i4];
        }
    }

    /* synthetic */ MediaButtonPressedTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, AppCompatDialog appCompatDialog, View view) {
        if (radioButton.isChecked()) {
            this.m_option = PRESS;
        } else if (radioButton2.isChecked()) {
            this.m_option = DOUBLE_PRESS;
        } else if (radioButton3.isChecked()) {
            this.m_option = TRIPLE_PRESS;
        } else {
            this.m_option = LONG_PRESS;
        }
        appCompatDialog.dismiss();
        secondaryItemConfirmed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(ResolveInfo resolveInfo, DialogInterface dialogInterface, int i4) {
        getContext().startActivity(newAppDetailsIntent(getContext(), resolveInfo.activityInfo.packageName));
        super.secondaryItemConfirmed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface, int i4) {
        super.secondaryItemConfirmed();
    }

    private String[] getOptions() {
        return new String[]{PRESS, DOUBLE_PRESS, TRIPLE_PRESS, LONG_PRESS};
    }

    public static Intent newAppDetailsIntent(Context context, String str) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("package:" + str));
        return intent;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_mediaButtonTriggerReceiver);
                s_audioManager.unregisterMediaButtonEventReceiver(s_remoteControlResponder);
                MacroDroidApplication.getInstance().unregisterReceiver(s_screenOnOffTriggerReceiver);
                s_handler.removeCallbacksAndMessages(null);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_mediaButtonTriggerReceiver = null;
            s_screenOnOffTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_mediaButtonTriggerReceiver = new MediaButtonTriggerReceiver();
            s_screenOnOffTriggerReceiver = new ScreenOnOffReceiver();
            s_audioManager = (AudioManager) MacroDroidApplication.getInstance().getSystemService("audio");
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.setPriority(Integer.MAX_VALUE);
            MacroDroidApplication.getInstance().registerReceiver(s_mediaButtonTriggerReceiver, intentFilter);
            ComponentName componentName = new ComponentName(getContext().getPackageName(), MediaButtonTriggerReceiver.class.getName());
            s_remoteControlResponder = componentName;
            s_audioManager.registerMediaButtonEventReceiver(componentName);
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter2.addAction("android.intent.action.SCREEN_OFF");
            MacroDroidApplication.getInstance().registerReceiver(s_screenOnOffTriggerReceiver, intentFilter2);
            Handler handler = new Handler();
            s_handler = handler;
            handler.postDelayed(new a(), 5000L);
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MediaButtonPressedTriggerInfo.getInstance();
    }

    public String getOption() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_media_button_pressed_options);
        appCompatDialog.setTitle(R.string.trigger_media_button_pressed_title);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.single_press);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.double_press);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.treble_press);
        RadioButton radioButton4 = (RadioButton) appCompatDialog.findViewById(R.id.long_press);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        if (this.m_option.equals(DOUBLE_PRESS)) {
            radioButton2.setChecked(true);
        } else if (this.m_option.equals(TRIPLE_PRESS)) {
            radioButton3.setChecked(true);
        } else if (this.m_option.equals(LONG_PRESS)) {
            radioButton4.setChecked(true);
        } else {
            radioButton.setChecked(true);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.e5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaButtonPressedTrigger.this.T(radioButton, radioButton2, radioButton3, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.f5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (!this.m_option.equals(LONG_PRESS)) {
            super.secondaryItemConfirmed();
            return;
        }
        PackageManager packageManager = getContext().getPackageManager();
        final ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.speech.action.WEB_SEARCH"), 65536);
        String str = resolveActivity.activityInfo.packageName;
        String charSequence = resolveActivity.loadLabel(packageManager).toString();
        if (!str.equals(BuildConfig.APPLICATION_ID) && !str.equals("android")) {
            new AlertDialog.Builder(getActivity(), m()).setTitle(R.string.trigger_media_button_pressed).setMessage(String.format(getContext().getString(R.string.clear_long_press_default), charSequence)).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.g5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    MediaButtonPressedTrigger.this.V(resolveActivity, dialogInterface, i4);
                }
            }).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.h5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    MediaButtonPressedTrigger.this.W(dialogInterface, i4);
                }
            }).show();
        } else {
            super.secondaryItemConfirmed();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_option);
        parcel.writeInt(this.m_cancelPress ? 1 : 0);
    }

    public MediaButtonPressedTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_cancelPress = false;
    }

    private MediaButtonPressedTrigger() {
        this.m_option = getOptions()[0];
    }

    private MediaButtonPressedTrigger(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readString();
        this.m_cancelPress = parcel.readInt() == 0;
    }
}
