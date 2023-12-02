package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SpeakTextActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.PreferencesActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SpeakTextAction extends Action implements TextToSpeech.OnInitListener, SupportsMagicText, BlockingAction {
    private static final int RESTART_TTS_MIN_PERIOD_MS = 60000;
    private static int s_actionCounter;
    private static boolean s_initialised;
    private static TextToSpeech s_tts;
    private transient Locale localeToSpeakWhileConfiguring;
    private transient Locale localeWhileConfiguring;
    private int m_audioStream;
    private transient TriggerContextInfo m_contextInfo;
    private transient TriggerContextInfo m_delayedContextInfo;
    private transient long m_lastRetryTimestamp;
    private Locale m_locale;
    private transient boolean m_oldReadNumbersIndividually;
    private float m_pitch;
    private boolean m_queue;
    private boolean m_readNumbersIndividually;
    private boolean m_specifyAudioStream;
    private float m_speed;
    private String m_textToSay;
    private boolean m_waitToFinish;
    private transient h speechCompletedListener;
    private transient TextToSpeech tempTTS;
    private transient String uniqueId;
    private transient PowerManager.WakeLock wakelock;
    private static final Set<Long> s_enabledSet = new HashSet();
    public static final Parcelable.Creator<SpeakTextAction> CREATOR = new g();

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FirebaseAnalyticsEventLogger.log("Invoking actions with delayed context info");
            SpeakTextAction speakTextAction = SpeakTextAction.this;
            speakTextAction.P0(speakTextAction.m_delayedContextInfo, SpeakTextAction.this.uniqueId, SpeakTextAction.this.m_audioStream, SpeakTextAction.this.speechCompletedListener);
            SpeakTextAction.this.m_delayedContextInfo = null;
        }
    }

    /* loaded from: classes2.dex */
    class g implements Parcelable.Creator<SpeakTextAction> {
        g() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpeakTextAction createFromParcel(Parcel parcel) {
            return new SpeakTextAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SpeakTextAction[] newArray(int i4) {
            return new SpeakTextAction[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface h {
        void a(String str);
    }

    /* synthetic */ SpeakTextAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(DialogInterface dialogInterface) {
        this.m_readNumbersIndividually = this.m_oldReadNumbersIndividually;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(CompoundButton compoundButton, boolean z3) {
        this.m_readNumbersIndividually = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(AppCompatDialog appCompatDialog, EditText editText, SeekBar seekBar, SeekBar seekBar2, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, Spinner spinner, int[] iArr, View view) {
        appCompatDialog.dismiss();
        this.m_textToSay = editText.getText().toString();
        this.m_pitch = N0(seekBar.getProgress());
        this.m_speed = N0(seekBar2.getProgress());
        this.m_queue = checkBox.isChecked();
        this.m_waitToFinish = checkBox2.isChecked();
        this.m_readNumbersIndividually = checkBox3.isChecked();
        this.m_locale = this.localeWhileConfiguring;
        if (spinner.getSelectedItemPosition() == 0) {
            this.m_specifyAudioStream = false;
        } else {
            this.m_specifyAudioStream = true;
            this.m_audioStream = iArr[spinner.getSelectedItemPosition() - 1];
        }
        this.localeWhileConfiguring = null;
        this.localeToSpeakWhileConfiguring = null;
        this.tempTTS = null;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(EditText editText, SeekBar seekBar, SeekBar seekBar2, Spinner spinner, int[] iArr, View view) {
        int i4;
        int i5 = this.m_audioStream;
        this.m_textToSay = editText.getText().toString();
        this.m_pitch = N0(seekBar.getProgress());
        this.m_speed = N0(seekBar2.getProgress());
        if (spinner.getSelectedItemPosition() == 0) {
            this.m_specifyAudioStream = false;
        } else {
            this.m_specifyAudioStream = true;
            spinner.getSelectedItemPosition();
            i5 = iArr[spinner.getSelectedItemPosition() - 1];
        }
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (!this.m_specifyAudioStream) {
            i4 = Settings.getSpokenTextAudioStream(getContext().getApplicationContext());
        } else {
            i4 = i5;
        }
        if (audioManager.getStreamVolume(i4) == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) String.format(SelectableItem.r(R.string.audio_stream_name_is_currently_zero), t0(i4)), 1).show();
        } else {
            P0(null, "0", i5, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(AppCompatDialog appCompatDialog, View view) {
        this.localeWhileConfiguring = null;
        this.localeToSpeakWhileConfiguring = null;
        this.tempTTS = null;
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(DialogInterface dialogInterface) {
        this.localeToSpeakWhileConfiguring = null;
        this.localeWhileConfiguring = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(Activity activity, View view) {
        try {
            Intent intent = new Intent("com.android.settings.TTS_SETTINGS");
            intent.setFlags(268435456);
            activity.startActivity(intent);
        } catch (Exception e4) {
            SystemLog.logError("Could not open TTS settings: " + e4.toString(), getMacroGuid().longValue());
            ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.error, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I0(Activity activity, View view) {
        Intent intent = new Intent(activity, PreferencesActivity.class);
        intent.putExtra(PreferencesActivity.EXTRA_SHORTCUT, 4);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack stack, ResumeMacroInfo resumeMacroInfo) {
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(String str, boolean z3, final int i4, final TriggerContextInfo triggerContextInfo, final boolean z4, final Stack stack, final ResumeMacroInfo resumeMacroInfo, String str2) {
        if (str.equals(str2) && this.m_waitToFinish && !z3) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.action.ao
                @Override // java.lang.Runnable
                public final void run() {
                    SpeakTextAction.this.J0(i4, triggerContextInfo, z4, stack, resumeMacroInfo);
                }
            });
        }
        PowerManager.WakeLock wakeLock = this.wakelock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.wakelock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(DialogInterface dialogInterface, int i4) {
        Intent intent = new Intent();
        intent.setAction("android.speech.tts.engine.INSTALL_TTS_DATA");
        getActivity().startActivity(intent);
    }

    private float N0(int i4) {
        return (i4 / 50.0f) + 0.01f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.no_speech_data_files);
        builder.setMessage(R.string.no_speech_info);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SpeakTextAction.this.L0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.go
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SpeakTextAction.M0(dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void P0(TriggerContextInfo triggerContextInfo, String str, int i4, @Nullable h hVar) {
        int i5;
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        this.speechCompletedListener = hVar;
        this.uniqueId = str;
        try {
            if (s_initialised) {
                Locale locale = this.localeToSpeakWhileConfiguring;
                if (locale == null && (locale = this.m_locale) == null) {
                    locale = Settings.getSpokenLocale(getContext().getApplicationContext());
                }
                TextToSpeech textToSpeech = s_tts;
                if (textToSpeech != null) {
                    int i6 = 1;
                    if (textToSpeech.isLanguageAvailable(locale) != -1 && s_tts.isLanguageAvailable(locale) != -2) {
                        s_tts.setLanguage(locale);
                    } else if (System.currentTimeMillis() - this.m_lastRetryTimestamp < ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS) {
                        String format = String.format(SelectableItem.r(R.string.speak_text_error_language_not_available), locale.getDisplayLanguage());
                        Util.displayNotification(getContext(), SelectableItem.r(R.string.error), format, false);
                        SystemLog.logError(format, getMacroGuid().longValue());
                    }
                    this.m_contextInfo = triggerContextInfo;
                    if (!this.m_specifyAudioStream) {
                        i5 = Settings.getSpokenTextAudioStream(getContext().getApplicationContext());
                    } else {
                        i5 = i4;
                    }
                    String str2 = this.m_textToSay;
                    s_tts.setPitch(this.m_pitch);
                    s_tts.setSpeechRate(this.m_speed);
                    s_tts.setOnUtteranceProgressListener(new a(audioManager, hVar));
                    String g4 = g(str2, this.m_contextInfo);
                    if (this.m_readNumbersIndividually) {
                        for (int i7 = 0; i7 < 9; i7++) {
                            String valueOf = String.valueOf(i7);
                            g4 = g4.replace(valueOf, i7 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        }
                        g4 = g4.replace("0", "0 ");
                    }
                    int streamVolume = audioManager.getStreamVolume(i5);
                    if (streamVolume == 0) {
                        ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) String.format(SelectableItem.r(R.string.audio_stream_name_is_currently_zero), t0(i5)), 1).show();
                        SystemLog.logError(getConfiguredName() + " - " + String.format(SelectableItem.r(R.string.audio_stream_name_is_currently_zero), t0(i5)), getMacroGuid().longValue());
                    } else {
                        SystemLog.logVerbose(getConfiguredName() + " - " + SelectableItem.r(R.string.current_volume) + " = " + streamVolume, getMacroGuid().longValue());
                    }
                    audioManager.requestAudioFocus(null, i5, 3);
                    if (!this.m_queue) {
                        i6 = 0;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("streamType", i5);
                    if (s_tts.speak(g4, i6, bundle, str) == -1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.m_lastRetryTimestamp > ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS) {
                            this.m_lastRetryTimestamp = currentTimeMillis;
                            SystemLog.logVerbose("SpeakTextAction: Text To Speech not working - retrying once", getMacroGuid().longValue());
                            this.m_delayedContextInfo = triggerContextInfo;
                            s_initialised = false;
                            try {
                                s_tts.stop();
                            } catch (Exception unused) {
                            }
                            try {
                                s_tts.shutdown();
                            } catch (Exception unused2) {
                            }
                            s_tts = new TextToSpeech(getContext().getApplicationContext(), this, Settings.getTTSEnginePackage(getContext()));
                        } else {
                            SystemLog.logError("Failed to initialise text to speech engine. Please check the text to speech engine is working properly via your phone's settings app.");
                        }
                    }
                } else {
                    SystemLog.logError("Text to speech engine is null, cannot speak text", getMacroGuid().longValue());
                }
            } else {
                audioManager.abandonAudioFocus(null);
                this.m_delayedContextInfo = triggerContextInfo;
                SystemLog.logError("Text to Speech not initialised - attempting to re-initialise", getMacroGuid().longValue());
                try {
                    s_tts.stop();
                } catch (Exception unused3) {
                }
                try {
                    s_tts.shutdown();
                } catch (Exception unused4) {
                }
                s_tts = new TextToSpeech(getContext().getApplicationContext(), this, Settings.getTTSEnginePackage(getContext()));
            }
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SpeakTextAction: Exception while invoking SpeakTextAction: " + e4.toString()));
        }
    }

    private void q0(final Activity activity, final Spinner spinner) {
        this.localeWhileConfiguring = this.m_locale;
        this.tempTTS = new TextToSpeech(MacroDroidApplication.getInstance(), new TextToSpeech.OnInitListener() { // from class: com.arlosoft.macrodroid.action.do
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public final void onInit(int i4) {
                SpeakTextAction.this.v0(activity, spinner, i4);
            }
        });
    }

    private void r0() {
        if (!checkActivityAlive()) {
            return;
        }
        this.m_oldReadNumbersIndividually = this.m_readNumbersIndividually;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.speak_action_config_dialog);
        appCompatDialog.setVolumeControlStream(3);
        appCompatDialog.setTitle(R.string.action_speak_text);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.speak_action_config_dialog_button_test);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.speak_action_config_dialog_text_to_say);
        final SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.speak_action_config_dialog_pitch_seekbar);
        final SeekBar seekBar2 = (SeekBar) appCompatDialog.findViewById(R.id.speak_action_config_dialog_speed_seekbar);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.speak_action_config_dialog_button_special_text);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.speak_action_config_dialog_queue_checkbox);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.speak_action_config_dialog_wait_checkbox);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.speak_digits_individually_checkbox);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.audio_stream);
        Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.language_to_speak);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.ttsSettingsLink);
        TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.ttsEngineLink);
        ImageView imageView = (ImageView) appCompatDialog.findViewById(R.id.language_to_speak_help);
        seekBar2.setMax(180);
        seekBar.setOnSeekBarChangeListener(new c((TextView) appCompatDialog.findViewById(R.id.pitch_value)));
        seekBar2.setOnSeekBarChangeListener(new d((TextView) appCompatDialog.findViewById(R.id.speed_value)));
        seekBar.setProgress(s0(this.m_pitch));
        seekBar2.setProgress(s0(this.m_speed));
        checkBox.setChecked(this.m_queue);
        checkBox2.setChecked(this.m_waitToFinish);
        checkBox3.setChecked(this.m_readNumbersIndividually);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.ho
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                SpeakTextAction.this.B0(compoundButton, z3);
            }
        });
        String str = this.m_textToSay;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        if (editText.getText().length() > 0) {
            button.setEnabled(true);
            button3.setEnabled(true);
        }
        String[] stringArray = activity.getResources().getStringArray(R.array.audio_streams);
        final int[] intArray = activity.getResources().getIntArray(R.array.audio_streams_values_int);
        String[] strArr = new String[stringArray.length + 1];
        int i4 = 0;
        strArr[0] = SelectableItem.r(R.string.macrodroid_default);
        int i5 = 0;
        while (i4 < stringArray.length) {
            int i6 = i4 + 1;
            strArr[i6] = stringArray[i4];
            String[] strArr2 = stringArray;
            if (this.m_audioStream == intArray[i4]) {
                i5 = i6;
            }
            i4 = i6;
            stringArray = strArr2;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, (int) R.layout.simple_spinner_item, strArr);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        if (!this.m_specifyAudioStream) {
            spinner.setSelection(0, false);
        } else {
            spinner.setSelection(i5, false);
        }
        q0(activity, spinner2);
        editText.addTextChangedListener(new e(button, editText, button3));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.jo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeakTextAction.this.C0(appCompatDialog, editText, seekBar, seekBar2, checkBox, checkBox2, checkBox3, spinner, intArray, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ko
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeakTextAction.this.D0(editText, seekBar, seekBar2, spinner, intArray, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.lo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeakTextAction.this.E0(appCompatDialog, view);
            }
        });
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.mo
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SpeakTextAction.this.F0(dialogInterface);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.no
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SpeakTextAction.G0(editText, magicTextPair);
            }
        };
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.oo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeakTextAction.this.H0(activity, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.po
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeakTextAction.I0(activity, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.yn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeakTextAction.this.y0(view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeakTextAction.this.z0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.io
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SpeakTextAction.this.A0(dialogInterface);
            }
        });
        appCompatDialog.show();
    }

    private int s0(float f4) {
        return (int) ((f4 - 0.01f) * 50.0f);
    }

    private String t0(int i4) {
        int[] intArray = getContext().getResources().getIntArray(R.array.audio_streams_values_int);
        String[] stringArray = getContext().getResources().getStringArray(R.array.audio_streams);
        for (int i5 = 0; i5 < intArray.length; i5++) {
            if (intArray[i5] == i4) {
                return stringArray[i5];
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int u0(Locale locale, Locale locale2) {
        return locale.getDisplayName().compareTo(locale2.getDisplayName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(Activity activity, Spinner spinner, int i4) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(SelectableItem.r(R.string.macrodroid_default));
            arrayList2.add(null);
            Locale[] localeArr = Settings.SUPPORTED_LOCALES;
            Arrays.sort(localeArr, new Comparator() { // from class: com.arlosoft.macrodroid.action.eo
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int u02;
                    u02 = SpeakTextAction.u0((Locale) obj, (Locale) obj2);
                    return u02;
                }
            });
            int i5 = 0;
            int i6 = 1;
            for (Locale locale : localeArr) {
                TextToSpeech textToSpeech = this.tempTTS;
                if (textToSpeech != null) {
                    int isLanguageAvailable = textToSpeech.isLanguageAvailable(locale);
                    String displayName = locale.getDisplayName();
                    if (isLanguageAvailable != -2) {
                        arrayList2.add(locale);
                        if (locale.equals(this.m_locale)) {
                            i5 = i6;
                        }
                        if (this.tempTTS.isLanguageAvailable(locale) == -1) {
                            arrayList.add(displayName + " (*)");
                        } else {
                            arrayList.add(displayName);
                        }
                        i6++;
                    }
                }
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(activity, (int) R.layout.simple_spinner_item, arrayList);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
            spinner.setSelection(i5);
            spinner.setOnItemSelectedListener(new f(arrayList, arrayList2));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(DialogInterface dialogInterface, int i4) {
        try {
            Intent intent = new Intent("com.android.settings.TTS_SETTINGS");
            intent.setFlags(268435456);
            getActivity().startActivity(intent);
        } catch (Exception e4) {
            SystemLog.logError("Could not open TTS settings: " + e4.toString(), getMacroGuid().longValue());
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.error, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.language_to_speak);
        builder.setMessage(R.string.speak_text_language_missing_info);
        builder.setNeutralButton(R.string.open_text_to_speech_settings, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SpeakTextAction.this.w0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.co
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SpeakTextAction.x0(dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected synchronized void doDisable() {
        if (getMacro() != null) {
            Set<Long> set = s_enabledSet;
            if (set.contains(Long.valueOf(getMacro().getGUID()))) {
                set.remove(Long.valueOf(getMacro().getGUID()));
                int i4 = s_actionCounter - 1;
                s_actionCounter = i4;
                if (i4 == 0) {
                    s_initialised = false;
                    TextToSpeech textToSpeech = s_tts;
                    if (textToSpeech != null) {
                        textToSpeech.stop();
                        s_tts.shutdown();
                        s_tts = null;
                    }
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doEnable() {
        if (getMacro() != null) {
            Set<Long> set = s_enabledSet;
            if (!set.contains(Long.valueOf(getMacro().getGUID()))) {
                set.add(Long.valueOf(getMacro().getGUID()));
                if (s_actionCounter == 0 && !s_initialised && s_tts == null) {
                    s_tts = new TextToSpeech(getContext().getApplicationContext(), this, Settings.getTTSEnginePackage(getContext()));
                }
                s_actionCounter++;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void enableForEditMacro() {
        if (s_tts == null) {
            s_tts = new TextToSpeech(getContext().getApplicationContext(), this, Settings.getTTSEnginePackage(getContext()));
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return "'" + this.m_textToSay + "'";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SpeakTextActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getName() + " (" + MDTextUtils.truncateIfRequired(this.m_textToSay, 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_textToSay};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getName() + " (" + g(this.m_textToSay, triggerContextInfo) + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (s_tts == null) {
            s_tts = new TextToSpeech(getContext().getApplicationContext(), this, Settings.getTTSEnginePackage(getContext()));
        }
        r0();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public synchronized void onInit(int i4) {
        if (i4 == 0) {
            try {
                s_initialised = true;
                Locale locale = this.localeToSpeakWhileConfiguring;
                if (locale == null && (locale = this.m_locale) == null) {
                    locale = Settings.getSpokenLocale(getContext().getApplicationContext());
                }
                TextToSpeech textToSpeech = s_tts;
                if (textToSpeech != null) {
                    if (textToSpeech.isLanguageAvailable(locale) != -1 && s_tts.isLanguageAvailable(locale) != -2) {
                        s_tts.setLanguage(locale);
                        s_tts.getLanguage();
                    } else {
                        SystemLog.logError("Desired language is not available: " + locale.getLanguage(), getMacroGuid().longValue());
                    }
                    if (this.m_delayedContextInfo != null) {
                        new Handler().postDelayed(new b(), 500L);
                    }
                } else {
                    SystemLog.logError("Text to speech engine is null, cannot speak text", getMacroGuid().longValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_textToSay = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    public void setText(String str) {
        this.m_textToSay = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_textToSay);
        parcel.writeFloat(this.m_pitch);
        parcel.writeFloat(this.m_speed);
        parcel.writeInt(this.m_queue ? 1 : 0);
        parcel.writeInt(this.m_specifyAudioStream ? 1 : 0);
        parcel.writeInt(this.m_audioStream);
        parcel.writeInt(this.m_waitToFinish ? 1 : 0);
        parcel.writeInt(this.m_readNumbersIndividually ? 1 : 0);
        parcel.writeSerializable(this.m_locale);
    }

    public SpeakTextAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@NonNull final TriggerContextInfo triggerContextInfo, final int i4, final boolean z3, @NonNull final Stack<Integer> stack, @Nullable final ResumeMacroInfo resumeMacroInfo, final boolean z4) {
        final String valueOf = String.valueOf(UUID.randomUUID().getLeastSignificantBits());
        PowerManager.WakeLock wakeLock = this.wakelock;
        if (wakeLock != null) {
            wakeLock.acquire(30000L);
        }
        P0(triggerContextInfo, valueOf, this.m_audioStream, new h() { // from class: com.arlosoft.macrodroid.action.xn
            @Override // com.arlosoft.macrodroid.action.SpeakTextAction.h
            public final void a(String str) {
                SpeakTextAction.this.K0(valueOf, z4, i4, triggerContextInfo, z3, stack, resumeMacroInfo, str);
            }
        });
        if (this.m_waitToFinish || z4) {
            return;
        }
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
    }

    public SpeakTextAction() {
        this.m_pitch = 1.0f;
        this.m_speed = 1.0f;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "macrodroid:SpeakTextAction");
        this.wakelock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    private SpeakTextAction(Parcel parcel) {
        super(parcel);
        this.m_textToSay = parcel.readString();
        this.m_pitch = parcel.readFloat();
        this.m_speed = parcel.readFloat();
        this.m_queue = parcel.readInt() != 0;
        this.m_specifyAudioStream = parcel.readInt() != 0;
        this.m_audioStream = parcel.readInt();
        this.m_waitToFinish = parcel.readInt() != 0;
        this.m_readNumbersIndividually = parcel.readInt() != 0;
        this.m_locale = (Locale) parcel.readSerializable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends UtteranceProgressListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AudioManager f2605a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f2606b;

        a(AudioManager audioManager, h hVar) {
            this.f2605a = audioManager;
            this.f2606b = hVar;
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(String str) {
            this.f2605a.abandonAudioFocus(null);
            h hVar = this.f2606b;
            if (hVar != null) {
                hVar.a(str);
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(String str) {
            this.f2605a.abandonAudioFocus(null);
            h hVar = this.f2606b;
            if (hVar != null) {
                hVar.a(str);
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f2609a;

        c(TextView textView) {
            this.f2609a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            int max = (int) ((i4 / seekBar.getMax()) * 100.0d);
            TextView textView = this.f2609a;
            textView.setText("(" + max + ")");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f2611a;

        d(TextView textView) {
            this.f2611a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            int max = (int) ((i4 / seekBar.getMax()) * 100.0d);
            TextView textView = this.f2611a;
            textView.setText("(" + max + ")");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f2617a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f2618b;

        f(List list, List list2) {
            this.f2617a = list;
            this.f2618b = list2;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (((String) this.f2617a.get(i4)).contains("(*)")) {
                SpeakTextAction.this.O0();
            }
            if (i4 == 0) {
                SpeakTextAction.this.localeWhileConfiguring = null;
                SpeakTextAction speakTextAction = SpeakTextAction.this;
                speakTextAction.localeToSpeakWhileConfiguring = Settings.getSpokenLocale(speakTextAction.getContext());
            } else {
                SpeakTextAction.this.localeWhileConfiguring = (Locale) this.f2618b.get(i4);
                SpeakTextAction.this.localeToSpeakWhileConfiguring = (Locale) this.f2618b.get(i4);
            }
            if (SpeakTextAction.s_tts.isLanguageAvailable(SpeakTextAction.this.localeToSpeakWhileConfiguring) != -1 && SpeakTextAction.s_tts.isLanguageAvailable(SpeakTextAction.this.localeToSpeakWhileConfiguring) != -2) {
                SpeakTextAction.s_tts.setLanguage(SpeakTextAction.this.localeToSpeakWhileConfiguring);
                SpeakTextAction.s_tts.getLanguage();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2613a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2614b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Button f2615c;

        e(Button button, EditText editText, Button button2) {
            this.f2613a = button;
            this.f2614b = editText;
            this.f2615c = button2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2613a;
            boolean z4 = true;
            if (this.f2614b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
            Button button2 = this.f2615c;
            if (this.f2614b.getText().length() <= 0) {
                z4 = false;
            }
            button2.setEnabled(z4);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
