package com.twofortyfouram.locale.sdk.client.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.twofortyfouram.locale.sdk.client.internal.c;
import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes6.dex */
public abstract class AbstractPluginActivity extends Activity implements IPluginActivity {
    protected boolean mIsCancelled = false;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final c<AbstractPluginActivity> f38106a = new c<>();

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

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        c.a(this, bundle);
    }

    @Override // android.app.Activity
    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        c.b(this, bundle);
    }
}
