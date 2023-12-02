package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.PlaySoundActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.UriHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class PlaySoundAction extends FileSelectionAction implements BlockingAction {
    private static final int ANDROID_5_PICKER_ID = 1067;
    private int audioStream;
    private String m_fileDisplayName;
    private String m_fileUri;
    private transient MediaPlayer m_mediaPlayer;
    private int m_selectedIndex;
    private boolean specifyAudioStream;
    private boolean waitToFinish;
    private transient PowerManager.WakeLock wakelock;
    private static final List<PlaySoundAction> s_activePlaySoundActions = Collections.synchronizedList(new ArrayList());
    public static final Parcelable.Creator<PlaySoundAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<PlaySoundAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PlaySoundAction createFromParcel(Parcel parcel) {
            return new PlaySoundAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PlaySoundAction[] newArray(int i4) {
            return new PlaySoundAction[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void a(long j4);
    }

    /* synthetic */ PlaySoundAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void W() {
        if (this.m_mediaPlayer == null) {
            this.m_mediaPlayer = new MediaPlayer();
            s_activePlaySoundActions.add(this);
            this.m_mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.arlosoft.macrodroid.action.of
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    PlaySoundAction.this.a0(mediaPlayer);
                }
            });
            this.m_mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.arlosoft.macrodroid.action.pf
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
                    boolean b02;
                    b02 = PlaySoundAction.this.b0(mediaPlayer, i4, i5);
                    return b02;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(AdapterView adapterView, View view, int i4, long j4) {
        Util.stopRingtone();
        if (i4 > 1) {
            Util.playRingtone(getContext(), i4 - 2, 2, Settings.getPlaySoundAudioStream(getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(CheckBox checkBox, ListView listView, Spinner spinner, int[] iArr, String[] strArr, Activity activity, AppCompatDialog appCompatDialog, View view) {
        this.waitToFinish = checkBox.isChecked();
        Util.stopRingtone();
        this.m_selectedIndex = listView.getCheckedItemPosition();
        if (spinner.getSelectedItemPosition() == 0) {
            this.specifyAudioStream = false;
        } else {
            this.specifyAudioStream = true;
            this.audioStream = iArr[spinner.getSelectedItemPosition() - 1];
        }
        int i4 = this.m_selectedIndex;
        if (i4 > 1) {
            this.m_fileDisplayName = null;
            this.m_fileUri = null;
            this.m_filePath = strArr[i4];
            secondaryItemConfirmed();
        } else if (i4 == 0) {
            try {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                activity.startActivityForResult(intent, ANDROID_5_PICKER_ID);
            } catch (Exception unused) {
                Context applicationContext = getContext().getApplicationContext();
                ToastCompat.makeText(applicationContext, (CharSequence) ("ACTION_OPEN_DOCUMENT " + SelectableItem.r(R.string.not_supported)), 0).show();
            }
        } else if (i4 == 1) {
            this.m_filePath = null;
            this.m_fileUri = null;
            this.m_fileDisplayName = null;
            secondaryItemConfirmed();
        }
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(MediaPlayer mediaPlayer) {
        cleanupMediaPlayer(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b0(MediaPlayer mediaPlayer, int i4, int i5) {
        ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        cleanupMediaPlayer(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack stack, ResumeMacroInfo resumeMacroInfo) {
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(long j4, boolean z3, final int i4, final TriggerContextInfo triggerContextInfo, final boolean z4, final Stack stack, final ResumeMacroInfo resumeMacroInfo, long j5) {
        if (j4 == j5 && this.waitToFinish && !z3) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.action.qf
                @Override // java.lang.Runnable
                public final void run() {
                    PlaySoundAction.this.c0(i4, triggerContextInfo, z4, stack, resumeMacroInfo);
                }
            });
        }
        PowerManager.WakeLock wakeLock = this.wakelock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.wakelock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(AudioManager audioManager, b bVar, long j4, MediaPlayer mediaPlayer) {
        audioManager.abandonAudioFocus(null);
        cleanupMediaPlayer(true);
        bVar.a(j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(AudioManager audioManager, b bVar, long j4, MediaPlayer mediaPlayer) {
        audioManager.abandonAudioFocus(null);
        cleanupMediaPlayer(true);
        bVar.a(j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(AudioManager audioManager, b bVar, long j4, MediaPlayer mediaPlayer) {
        audioManager.abandonAudioFocus(null);
        cleanupMediaPlayer(true);
        bVar.a(j4);
    }

    private void h0(TriggerContextInfo triggerContextInfo, final long j4, final b bVar) {
        int i4;
        Cursor cursor;
        final AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (!this.specifyAudioStream) {
            i4 = Settings.getPlaySoundAudioStream(getContext());
        } else {
            i4 = this.audioStream;
        }
        audioManager.requestAudioFocus(null, i4, 3);
        String str = this.m_filePath;
        boolean z3 = false;
        if (str == null && this.m_fileUri == null) {
            for (PlaySoundAction playSoundAction : s_activePlaySoundActions) {
                playSoundAction.cleanupMediaPlayer(false);
            }
            s_activePlaySoundActions.clear();
            audioManager.abandonAudioFocus(null);
            bVar.a(j4);
        } else if (this.m_fileUri != null) {
            W();
            try {
                if (!this.m_mediaPlayer.isPlaying()) {
                    this.m_mediaPlayer.reset();
                    this.m_mediaPlayer.setDataSource(getContext(), Uri.parse(this.m_fileUri));
                    this.m_mediaPlayer.setAudioStreamType(i4);
                    this.m_mediaPlayer.prepare();
                    this.m_mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.arlosoft.macrodroid.action.lf
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            PlaySoundAction.this.e0(audioManager, bVar, j4, mediaPlayer);
                        }
                    });
                    this.m_mediaPlayer.start();
                }
            } catch (Exception e4) {
                SystemLog.logError("Error playing media file: " + this.m_fileUri + "\n" + e4.toString(), getMacroGuid().longValue());
                audioManager.abandonAudioFocus(null);
                cleanupMediaPlayer(true);
                bVar.a(j4);
            }
        } else if (!str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
            W();
            List<String> ringtoneSounds = Util.getRingtoneSounds(getContext(), 2, false);
            int i5 = 0;
            while (true) {
                if (i5 >= ringtoneSounds.size()) {
                    break;
                } else if (ringtoneSounds.get(i5).equals(this.m_filePath)) {
                    RingtoneManager ringtoneManager = new RingtoneManager(getContext().getApplicationContext());
                    ringtoneManager.setType(2);
                    try {
                        cursor = ringtoneManager.getCursor();
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                    }
                    try {
                        Uri ringtoneUri = ringtoneManager.getRingtoneUri(i5);
                        this.m_mediaPlayer.reset();
                        this.m_mediaPlayer.setDataSource(getContext(), ringtoneUri);
                        this.m_mediaPlayer.setAudioStreamType(i4);
                        this.m_mediaPlayer.prepare();
                        this.m_mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.arlosoft.macrodroid.action.mf
                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                PlaySoundAction.this.f0(audioManager, bVar, j4, mediaPlayer);
                            }
                        });
                        this.m_mediaPlayer.start();
                        try {
                            cursor.close();
                        } catch (Exception unused) {
                        }
                        z3 = true;
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            SystemLog.logError("Failed to play sound: " + th.toString(), getMacroGuid().longValue());
                            audioManager.abandonAudioFocus(null);
                            cleanupMediaPlayer(true);
                            bVar.a(j4);
                            try {
                                return;
                            } catch (Exception unused2) {
                                return;
                            }
                        } finally {
                            try {
                                cursor.close();
                            } catch (Exception unused3) {
                            }
                        }
                    }
                } else {
                    i5++;
                }
            }
            if (!z3) {
                SystemLog.logError("Sound file not found: " + this.m_filePath, getMacroGuid().longValue());
                SystemLog.logVerbose("Files found were: " + ringtoneSounds, getMacroGuid().longValue());
                audioManager.abandonAudioFocus(null);
                cleanupMediaPlayer(true);
                bVar.a(j4);
            }
        } else {
            W();
            try {
                if (!this.m_mediaPlayer.isPlaying()) {
                    this.m_mediaPlayer.reset();
                    this.m_mediaPlayer.setDataSource(this.m_filePath);
                    this.m_mediaPlayer.setAudioStreamType(i4);
                    this.m_mediaPlayer.prepare();
                    this.m_mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.arlosoft.macrodroid.action.nf
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            PlaySoundAction.this.g0(audioManager, bVar, j4, mediaPlayer);
                        }
                    });
                    this.m_mediaPlayer.start();
                }
            } catch (Exception unused4) {
                SystemLog.logError("Error playing media file: " + this.m_filePath, getMacroGuid().longValue());
                audioManager.abandonAudioFocus(null);
                cleanupMediaPlayer(true);
                bVar.a(j4);
            }
        }
    }

    public void cleanupMediaPlayer(boolean z3) {
        MediaPlayer mediaPlayer = this.m_mediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
            } catch (Exception unused) {
            }
            try {
                this.m_mediaPlayer.release();
            } catch (Exception unused2) {
            }
            if (z3) {
                s_activePlaySoundActions.remove(this);
            }
            this.m_mediaPlayer = null;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (!TextUtils.isEmpty(this.m_fileDisplayName)) {
            return SelectableItem.r(R.string.action_play_sound_play) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_fileDisplayName;
        }
        String str = this.m_fileUri;
        if (str != null) {
            try {
                String decode = Uri.decode(str);
                String substring = decode.substring(decode.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1);
                return SelectableItem.r(R.string.action_play_sound_play) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + substring;
            } catch (Exception unused) {
                return SelectableItem.r(R.string.action_play_sound_play) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_fileUri;
            }
        }
        String str2 = this.m_filePath;
        if (str2 == null) {
            return SelectableItem.r(R.string.action_play_sound_stop_sounds);
        }
        if (str2.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
            StringBuilder sb = new StringBuilder();
            sb.append(SelectableItem.r(R.string.action_play_sound_play));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            String str3 = this.m_filePath;
            sb.append(str3.substring(str3.lastIndexOf(47) + 1));
            return sb.toString();
        }
        return SelectableItem.r(R.string.action_play_sound_play) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_filePath;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return PlaySoundActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.FileSelectionAction, com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i5 == -1) {
            if (i4 == ANDROID_5_PICKER_ID) {
                try {
                    Uri data = intent.getData();
                    getContext().getContentResolver().takePersistableUriPermission(data, 3);
                    this.m_fileUri = data.toString();
                    this.m_fileDisplayName = UriHelper.getDisplayNameFromUri(getContext(), data);
                    this.m_filePath = null;
                } catch (SecurityException unused) {
                    ToastCompat.makeText(getContext(), (CharSequence) SelectableItem.r(R.string.file_explorer_broken), 1).show();
                    SystemLog.logError(SelectableItem.r(R.string.file_explorer_broken));
                }
            } else {
                this.m_filePath = intent.getExtras().getString(Util.FILE_SELECTION_EXTRA);
            }
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_sound_chooser);
        appCompatDialog.setTitle(R.string.action_play_sound_select);
        final ListView listView = (ListView) appCompatDialog.findViewById(R.id.sound_list);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.wait_to_complete_checkbox);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.audio_stream);
        List<String> ringtoneSounds = Util.getRingtoneSounds(getContext(), 2, false);
        ringtoneSounds.add(0, SelectableItem.r(R.string.action_play_sound_choose_file));
        ringtoneSounds.add(1, SelectableItem.r(R.string.action_play_sound_stop_existing_sound));
        final String[] strArr = (String[]) ringtoneSounds.toArray(new String[0]);
        if (this.m_filePath == null) {
            this.m_filePath = strArr[1];
        }
        if (this.m_selectedIndex > strArr.length - 1) {
            this.m_selectedIndex = strArr.length - 1;
        }
        String[] stringArray = activity.getResources().getStringArray(R.array.audio_streams);
        final int[] intArray = activity.getResources().getIntArray(R.array.audio_streams_values_int);
        String[] strArr2 = new String[stringArray.length + 1];
        strArr2[0] = SelectableItem.r(R.string.macrodroid_default);
        int i4 = 0;
        int i5 = 0;
        while (i5 < stringArray.length) {
            int i6 = i5 + 1;
            strArr2[i6] = stringArray[i5];
            String[] strArr3 = stringArray;
            if (this.audioStream == intArray[i5]) {
                i4 = i6;
            }
            i5 = i6;
            stringArray = strArr3;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, (int) R.layout.simple_spinner_item, strArr2);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        if (!this.specifyAudioStream) {
            spinner.setSelection(0, false);
        } else {
            spinner.setSelection(i4, false);
        }
        checkBox.setChecked(this.waitToFinish);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(new ContextThemeWrapper(activity, getDialogTheme()), (int) R.layout.single_choice_list_item, ringtoneSounds);
        listView.setChoiceMode(1);
        listView.setAdapter((ListAdapter) arrayAdapter2);
        listView.setItemChecked(this.m_selectedIndex, true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.arlosoft.macrodroid.action.if
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i7, long j4) {
                PlaySoundAction.this.X(adapterView, view, i7, j4);
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.jf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.kf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaySoundAction.this.Z(checkBox, listView, spinner, intArray, strArr, activity, appCompatDialog, view);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void kill() {
        s_activePlaySoundActions.remove(this);
        MediaPlayer mediaPlayer = this.m_mediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                this.m_mediaPlayer = null;
            } catch (Exception unused) {
            }
        }
    }

    public void useDefaultSound() {
        List<String> ringtoneSounds = Util.getRingtoneSounds(getContext(), 2, false);
        if (ringtoneSounds.size() > 0) {
            this.m_filePath = ringtoneSounds.get(0);
            this.m_selectedIndex = 1;
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_filePath);
        parcel.writeString(this.m_fileUri);
        parcel.writeString(this.m_fileDisplayName);
        parcel.writeInt(this.waitToFinish ? 1 : 0);
        parcel.writeInt(this.specifyAudioStream ? 1 : 0);
        parcel.writeInt(this.audioStream);
    }

    public PlaySoundAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "macrodroid:PlaySoundAction");
        this.wakelock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable final TriggerContextInfo triggerContextInfo, final int i4, final boolean z3, @NotNull final Stack<Integer> stack, @Nullable final ResumeMacroInfo resumeMacroInfo, final boolean z4) {
        final long leastSignificantBits = UUID.randomUUID().getLeastSignificantBits();
        PowerManager.WakeLock wakeLock = this.wakelock;
        if (wakeLock != null) {
            wakeLock.acquire(30000L);
        }
        h0(triggerContextInfo, leastSignificantBits, new b() { // from class: com.arlosoft.macrodroid.action.hf
            @Override // com.arlosoft.macrodroid.action.PlaySoundAction.b
            public final void a(long j4) {
                PlaySoundAction.this.d0(leastSignificantBits, z4, i4, triggerContextInfo, z3, stack, resumeMacroInfo, j4);
            }
        });
        if (this.waitToFinish || z4) {
            return;
        }
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
    }

    public PlaySoundAction() {
        this.waitToFinish = false;
        this.m_selectedIndex = 0;
    }

    private PlaySoundAction(Parcel parcel) {
        super(parcel);
        this.waitToFinish = false;
        this.m_filePath = parcel.readString();
        this.m_fileUri = parcel.readString();
        this.m_fileDisplayName = parcel.readString();
        this.waitToFinish = parcel.readInt() != 0;
        this.specifyAudioStream = parcel.readInt() != 0;
        this.audioStream = parcel.readInt();
    }
}
