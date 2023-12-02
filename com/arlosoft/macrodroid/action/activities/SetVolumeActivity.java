package com.arlosoft.macrodroid.action.activities;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcelable;
import com.arlosoft.macrodroid.action.SetVolumeAction;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes2.dex */
public class SetVolumeActivity extends NonAppActivity {

    /* loaded from: classes2.dex */
    class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
            }
            SetVolumeActivity.this.finish();
        }
    }

    private void h(boolean[] zArr, int[] iArr, MacroDroidVariable[] macroDroidVariableArr, DictionaryKeys[] dictionaryKeysArr, long j4) {
        double d4;
        String[] audioStreams = SetVolumeAction.getAudioStreams();
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        for (int i4 = 0; i4 < zArr.length; i4++) {
            if (zArr[i4]) {
                try {
                    int[] iArr2 = SetVolumeAction.s_streamConstants;
                    int streamMaxVolume = audioManager.getStreamMaxVolume(iArr2[i4]);
                    if (streamMaxVolume == 0) {
                        SystemLog.logError("Max volume for " + audioStreams[i4] + " is zero", j4);
                        d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    } else {
                        d4 = 100 / streamMaxVolume;
                    }
                    try {
                        audioManager.setStreamVolume(iArr2[i4], (int) (((streamMaxVolume * iArr[i4]) + (d4 / 2.0d)) / 100.0d), 0);
                    } catch (Exception e4) {
                        SystemLog.logError("Set volume failed: " + e4.toString(), j4);
                    }
                } catch (IllegalArgumentException unused) {
                    SystemLog.logWarning("Could not use audioStream: " + SetVolumeAction.s_streamConstants[i4] + " on this device");
                }
            }
        }
    }

    public static void invoke(Context context, boolean[] zArr, int[] iArr, MacroDroidVariable[] macroDroidVariableArr, DictionaryKeys[] dictionaryKeysArr, long j4) {
        MacroDroidVariable variableByName;
        Long longValue;
        String[] audioStreams = SetVolumeAction.getAudioStreams();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(j4);
        for (int i4 = 0; i4 < zArr.length; i4++) {
            if (zArr[i4]) {
                try {
                    int streamMaxVolume = audioManager.getStreamMaxVolume(SetVolumeAction.s_streamConstants[i4]);
                    if (streamMaxVolume == 0) {
                        SystemLog.logError("Max volume for " + audioStreams[i4] + " is zero", j4);
                    } else {
                        int i5 = 100 / streamMaxVolume;
                    }
                    MacroDroidVariable macroDroidVariable = macroDroidVariableArr[i4];
                    if (macroDroidVariable != null && macroByGUID != null && (variableByName = macroByGUID.getVariableByName(macroDroidVariable.getName())) != null) {
                        DictionaryKeys dictionaryKeys = dictionaryKeysArr[i4];
                        if (dictionaryKeys != null) {
                            longValue = variableByName.getLongValue(VariableHelper.applyMagicTextToDictionaryKeys(context, dictionaryKeys.getKeys(), null, macroByGUID));
                        } else {
                            longValue = variableByName.getLongValue((List<String>) null);
                        }
                        if (longValue != null) {
                            iArr[i4] = longValue.intValue();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        Intent intent = new Intent(context, SetVolumeActivity.class);
        intent.putExtra("stream_index_array", zArr);
        intent.putExtra("stream_volume_array", iArr);
        intent.putExtra("variables", macroDroidVariableArr);
        intent.putExtra("dictionary_keys", dictionaryKeysArr);
        intent.putExtra(Constants.EXTRA_MACRO_GUID, j4);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        boolean[] booleanArrayExtra = getIntent().getBooleanArrayExtra("stream_index_array");
        int[] intArrayExtra = getIntent().getIntArrayExtra("stream_volume_array");
        long longExtra = getIntent().getLongExtra(Constants.EXTRA_MACRO_GUID, 0L);
        Parcelable[] parcelableArrayExtra = getIntent().getParcelableArrayExtra("variables");
        Parcelable[] parcelableArrayExtra2 = getIntent().getParcelableArrayExtra("dictionary_keys");
        MacroDroidVariable[] macroDroidVariableArr = new MacroDroidVariable[parcelableArrayExtra.length];
        for (int i4 = 0; i4 < parcelableArrayExtra.length; i4++) {
            macroDroidVariableArr[i4] = (MacroDroidVariable) parcelableArrayExtra[i4];
        }
        DictionaryKeys[] dictionaryKeysArr = new DictionaryKeys[parcelableArrayExtra2.length];
        for (int i5 = 0; i5 < parcelableArrayExtra2.length; i5++) {
            dictionaryKeysArr[i5] = (DictionaryKeys) parcelableArrayExtra2[i5];
        }
        h(booleanArrayExtra, intArrayExtra, macroDroidVariableArr, dictionaryKeysArr, longExtra);
        new a().start();
    }
}
