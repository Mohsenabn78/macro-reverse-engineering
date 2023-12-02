package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.speech.tts.TextToSpeech;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SayTimeActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public class SayTimeAction extends Action implements TextToSpeech.OnInitListener {
    private static final int RESTART_TTS_MIN_PERIOD_MS = 60000;
    private static int s_actionCounter;
    private static boolean s_initialised;
    private static TextToSpeech s_tts;
    private boolean m_12Hour;
    private transient TriggerContextInfo m_delayedContextInfo;
    private transient long m_lastRetryTimestamp;
    private static final Set<Long> s_enabledSet = new HashSet();
    public static final Parcelable.Creator<SayTimeAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SayTimeAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SayTimeAction createFromParcel(Parcel parcel) {
            return new SayTimeAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SayTimeAction[] newArray(int i4) {
            return new SayTimeAction[i4];
        }
    }

    /* synthetic */ SayTimeAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_say_time_24_hour), SelectableItem.r(R.string.action_say_time_12_hour)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3 = true;
        if (i4 != 1) {
            z3 = false;
        }
        this.m_12Hour = z3;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doDisable() {
        if (getMacro() != null) {
            Set<Long> set = s_enabledSet;
            if (set.contains(Long.valueOf(getMacro().getGUID()))) {
                if (getMacro() != null) {
                    set.remove(Long.valueOf(getMacro().getGUID()));
                }
                int i4 = s_actionCounter - 1;
                s_actionCounter = i4;
                if (i4 == 0) {
                    TextToSpeech textToSpeech = s_tts;
                    if (textToSpeech != null) {
                        textToSpeech.stop();
                        s_tts.shutdown();
                        s_tts = null;
                    }
                    s_initialised = false;
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
                    s_tts = new TextToSpeech(getContext().getApplicationContext(), this);
                }
                s_actionCounter++;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void enableForEditMacro() {
        if (s_tts == null) {
            s_tts = new TextToSpeech(getContext().getApplicationContext(), this);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_12Hour ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4;
        if (this.m_12Hour) {
            i4 = R.string.action_say_time_12_hour_clock;
        } else {
            i4 = R.string.action_say_time_24_hour_clock;
        }
        return SelectableItem.r(i4);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SayTimeActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        TextToSpeech textToSpeech;
        SimpleDateFormat simpleDateFormat;
        try {
            if (s_initialised) {
                Locale spokenLocale = Settings.getSpokenLocale(getContext());
                final AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
                if (spokenLocale != null && (textToSpeech = s_tts) != null) {
                    textToSpeech.setLanguage(spokenLocale);
                    s_tts.setPitch(1.0f);
                    s_tts.setSpeechRate(1.0f);
                    int spokenTextAudioStream = Settings.getSpokenTextAudioStream(getContext());
                    if (this.m_12Hour) {
                        simpleDateFormat = new SimpleDateFormat("h:mm aa");
                    } else {
                        simpleDateFormat = new SimpleDateFormat("H:mm");
                    }
                    String format = simpleDateFormat.format(new Date());
                    int streamVolume = audioManager.getStreamVolume(spokenTextAudioStream);
                    if (streamVolume == 0) {
                        SystemLog.logError(getConfiguredName() + " - " + SelectableItem.r(R.string.current_volume) + " = " + streamVolume, getMacroGuid().longValue());
                    }
                    s_tts.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener() { // from class: com.arlosoft.macrodroid.action.bh
                        @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
                        public final void onUtteranceCompleted(String str) {
                            audioManager.abandonAudioFocus(null);
                        }
                    });
                    audioManager.requestAudioFocus(null, spokenTextAudioStream, 3);
                    Bundle bundle = new Bundle();
                    bundle.putInt("streamType", spokenTextAudioStream);
                    if (s_tts.speak(format, 0, bundle, "SpokenText") == -1) {
                        audioManager.abandonAudioFocus(null);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.m_lastRetryTimestamp > ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS) {
                            this.m_lastRetryTimestamp = currentTimeMillis;
                            this.m_delayedContextInfo = triggerContextInfo;
                            s_initialised = false;
                            s_tts.stop();
                            s_tts.shutdown();
                            s_tts = new TextToSpeech(getContext().getApplicationContext(), this);
                            return;
                        }
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SayTimeAction: Text To Speech cannot retry"));
                        return;
                    }
                    return;
                }
                return;
            }
            this.m_delayedContextInfo = triggerContextInfo;
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int i4) {
        TextToSpeech textToSpeech;
        if (i4 == 0) {
            s_initialised = true;
            Locale spokenLocale = Settings.getSpokenLocale(getContext());
            if (spokenLocale != null && (textToSpeech = s_tts) != null) {
                try {
                    int isLanguageAvailable = textToSpeech.isLanguageAvailable(spokenLocale);
                    if (isLanguageAvailable != -1 && isLanguageAvailable != -2) {
                        s_tts.setLanguage(spokenLocale);
                    }
                } catch (Exception e4) {
                    SystemLog.logError("Failed to set language: " + e4.toString(), getMacroGuid().longValue());
                }
            }
            TriggerContextInfo triggerContextInfo = this.m_delayedContextInfo;
            if (triggerContextInfo != null) {
                invokeAction(triggerContextInfo);
                this.m_delayedContextInfo = null;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(!this.m_12Hour ? 1 : 0);
    }

    public SayTimeAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SayTimeAction() {
        this.m_12Hour = false;
    }

    private SayTimeAction(Parcel parcel) {
        super(parcel);
        this.m_12Hour = parcel.readInt() == 0;
    }
}
