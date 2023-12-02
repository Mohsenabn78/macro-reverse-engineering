package com.arlosoft.macrodroid.triggers.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.arlosoft.macrodroid.triggers.services.NFCTriggeredService;

/* loaded from: classes3.dex */
public class NFCTriggeredActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ("android.nfc.action.NDEF_DISCOVERED".equals(getIntent().getAction())) {
            Intent intent = new Intent(this, NFCTriggeredService.class);
            intent.putExtra("android.nfc.extra.NDEF_MESSAGES", getIntent().getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES"));
            startService(intent);
        }
        finish();
    }
}
