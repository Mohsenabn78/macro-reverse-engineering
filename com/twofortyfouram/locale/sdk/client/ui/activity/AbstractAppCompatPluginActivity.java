package com.twofortyfouram.locale.sdk.client.ui.activity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.twofortyfouram.locale.sdk.client.internal.c;

/* loaded from: classes6.dex */
public abstract class AbstractAppCompatPluginActivity extends AppCompatActivity implements IPluginActivity {
    protected boolean mIsCancelled = false;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final c<AbstractAppCompatPluginActivity> f38104a = new c<>();

    @Override // android.app.Activity
    public void finish() {
        c.a(this, this.mIsCancelled);
        super.finish();
    }

    @Override // com.twofortyfouram.locale.sdk.client.ui.activity.IPluginActivity
    @Nullable
    public final String getPreviousBlurb() {
        return c.a(this);
    }

    @Override // com.twofortyfouram.locale.sdk.client.ui.activity.IPluginActivity
    @Nullable
    public final Bundle getPreviousBundle() {
        return c.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        c.a(this, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        c.b(this, bundle);
    }
}
