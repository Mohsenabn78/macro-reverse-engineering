package com.arlosoft.macrodroid.action.email;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.arlosoft.macrodroid.utils.GmailHelper;

/* loaded from: classes2.dex */
public class EmailOauthConfigureActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    private GmailHelper f3447c;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        this.f3447c.handleActivityResult(i4, i5, intent);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GmailHelper gmailHelper = GmailHelper.getInstance(this);
        this.f3447c = gmailHelper;
        gmailHelper.chooseAccount(gmailHelper.getCredentials(), this);
    }
}
