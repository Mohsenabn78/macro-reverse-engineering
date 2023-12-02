package com.arlosoft.macrodroid.triggers.activities;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.triggers.NFCTrigger;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class ScanTagActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    private NfcAdapter f14535c;

    /* renamed from: d  reason: collision with root package name */
    private PendingIntent f14536d;

    /* renamed from: e  reason: collision with root package name */
    private IntentFilter[] f14537e;

    /* renamed from: f  reason: collision with root package name */
    private String[][] f14538f;

    /* renamed from: g  reason: collision with root package name */
    private String f14539g;

    private static boolean h(NdefMessage ndefMessage, Tag tag) {
        int length = ndefMessage.toByteArray().length;
        try {
            Ndef ndef = Ndef.get(tag);
            if (ndef != null) {
                ndef.connect();
                if (!ndef.isWritable() || ndef.getMaxSize() < length) {
                    return false;
                }
                ndef.writeNdefMessage(ndefMessage);
                return true;
            }
            NdefFormatable ndefFormatable = NdefFormatable.get(tag);
            if (ndefFormatable != null) {
                try {
                    ndefFormatable.connect();
                    ndefFormatable.format(ndefMessage);
                    return true;
                } catch (IOException unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            Log.w("TAG", "Failed to write data to NFC Tag");
            return false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.scan_tag_view);
        if (getIntent().hasExtra(NFCTrigger.TAG_NAME_EXTRA)) {
            this.f14539g = getIntent().getExtras().getString(NFCTrigger.TAG_NAME_EXTRA);
        }
        this.f14535c = NfcAdapter.getDefaultAdapter(this);
        this.f14536d = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(536870912), PendingIntentHelper.FLAG_MUTABLE);
        if (this.f14539g != null) {
            setTitle(R.string.action_set_nfc_writing);
            IntentFilter intentFilter = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
            IntentFilter intentFilter2 = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
            IntentFilter intentFilter3 = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
            try {
                intentFilter.addDataType("*/*");
                intentFilter2.addDataScheme("http");
            } catch (IntentFilter.MalformedMimeTypeException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ScanTagActivity: MalformedMimeTypeException: " + e4.getMessage()));
            }
            this.f14537e = new IntentFilter[]{intentFilter, intentFilter2, intentFilter3};
        } else {
            setTitle(R.string.scan_compatible_nfc_tag);
            IntentFilter intentFilter4 = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
            intentFilter4.addDataScheme("http");
            intentFilter4.addDataPath("www.macrodroid.com", 2);
            intentFilter4.addDataScheme("macrodroid");
            intentFilter4.addDataPath("tag", 2);
            this.f14537e = new IntentFilter[]{intentFilter4};
        }
        this.f14538f = new String[][]{new String[]{NfcF.class.getName()}};
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("Foreground dispatch", "Discovered tag with intent: " + intent);
        Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        Intent intent2 = new Intent();
        if (this.f14539g == null) {
            Ndef ndef = Ndef.get(tag);
            if (ndef == null) {
                ToastCompat.makeText(getApplicationContext(), (int) R.string.error, 0).show();
                return;
            }
            NdefMessage cachedNdefMessage = ndef.getCachedNdefMessage();
            if (cachedNdefMessage != null) {
                NdefRecord[] records = cachedNdefMessage.getRecords();
                int length = records.length;
                String[] strArr = new String[length];
                for (int i4 = 0; i4 < length; i4++) {
                    String str = new String(records[i4].getType());
                    strArr[i4] = str;
                    if (str.startsWith(NFCTrigger.NFC_TRIGGER_MACRODROID_URL)) {
                        String substring = strArr[i4].substring(17);
                        setResult(-1, intent2);
                        intent2.putExtra(NFCTrigger.TAG_NAME_EXTRA, substring);
                        finish();
                    }
                }
            }
            setResult(0, intent2);
            finish();
            return;
        }
        if (h(new NdefMessage(new NdefRecord[]{new NdefRecord((short) 3, (NFCTrigger.NFC_TRIGGER_MACRODROID_URL + this.f14539g).getBytes(StandardCharsets.UTF_8), new byte[0], new byte[0])}), tag)) {
            setResult(-1, intent2);
            finish();
            return;
        }
        setResult(0, intent2);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        NfcAdapter nfcAdapter = this.f14535c;
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        NfcAdapter nfcAdapter = this.f14535c;
        if (nfcAdapter != null) {
            nfcAdapter.enableForegroundDispatch(this, this.f14536d, this.f14537e, this.f14538f);
        }
    }
}
