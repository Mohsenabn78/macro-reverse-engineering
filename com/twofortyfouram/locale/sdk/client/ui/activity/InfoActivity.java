package com.twofortyfouram.locale.sdk.client.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.client.internal.a;
import com.twofortyfouram.locale.sdk.client.internal.b;
import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes6.dex */
public final class InfoActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        Intent addFlags;
        super.onCreate(bundle);
        Context applicationContext = getApplicationContext();
        PackageManager packageManager = getPackageManager();
        String packageName = getPackageName();
        Assertions.assertNotNull(applicationContext, "context");
        Assertions.assertNotNull(packageManager, "manager");
        Assertions.assertNotNull(packageName, "myPackageName");
        String a4 = b.a(packageManager);
        if (a4 != null) {
            addFlags = packageManager.getLaunchIntentForPackage(a4);
            addFlags.addFlags(268435456);
        } else {
            addFlags = new Intent("android.intent.action.VIEW", Uri.parse(applicationContext.getString(a.C0218a.com_twofortyfouram_locale_sdk_client_app_store_deep_link_format, "com.twofortyfouram.locale", packageName))).addFlags(67108864);
        }
        try {
            startActivity(addFlags);
        } catch (Exception unused) {
        }
        finish();
    }
}
