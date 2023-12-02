package com.twofortyfouram.locale.sdk.client.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.assertion.BundleAssertions;
import com.twofortyfouram.locale.sdk.client.ui.activity.IPluginActivity;
import com.twofortyfouram.spackle.bundle.BundleComparer;
import com.twofortyfouram.spackle.bundle.BundleScrubber;
import net.jcip.annotations.Immutable;

@Immutable
/* loaded from: classes6.dex */
public final class c<T extends Activity & IPluginActivity> {
    private static boolean a(@NonNull Intent intent) {
        Assertions.assertNotNull(intent, "intent");
        String action = intent.getAction();
        return com.twofortyfouram.locale.api.Intent.ACTION_EDIT_CONDITION.equals(action) || com.twofortyfouram.locale.api.Intent.ACTION_EDIT_SETTING.equals(action);
    }

    public static void b(@NonNull T t3, @Nullable Bundle bundle) {
        Assertions.assertNotNull(t3, "activity");
        if (a(t3.getIntent()) && bundle == null) {
            T t4 = t3;
            Bundle previousBundle = t4.getPreviousBundle();
            String previousBlurb = t4.getPreviousBlurb();
            if (previousBundle == null || previousBlurb == null) {
                return;
            }
            t4.onPostCreateWithPreviousResult(previousBundle, previousBlurb);
        }
    }

    public static void a(@NonNull T t3, @Nullable Bundle bundle) {
        Assertions.assertNotNull(t3, "activity");
        Intent intent = t3.getIntent();
        if (!a(intent) || BundleScrubber.scrub(intent)) {
            return;
        }
        BundleScrubber.scrub(t3.getPreviousBundle());
    }

    @Nullable
    public static Bundle b(@NonNull T t3) {
        Assertions.assertNotNull(t3, "activity");
        Bundle bundleExtra = t3.getIntent().getBundleExtra(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE);
        if (bundleExtra == null || !t3.isBundleValid(bundleExtra)) {
            return null;
        }
        return bundleExtra;
    }

    public static void a(@NonNull T t3, boolean z3) {
        T t4;
        Bundle resultBundle;
        if (!a(t3.getIntent()) || z3 || (resultBundle = (t4 = t3).getResultBundle()) == null) {
            return;
        }
        BundleAssertions.assertSerializable(resultBundle);
        String resultBlurb = t4.getResultBlurb(resultBundle);
        Assertions.assertNotNull(resultBlurb, "blurb");
        if (BundleComparer.areBundlesEqual(resultBundle, t4.getPreviousBundle()) && resultBlurb.equals(t4.getPreviousBlurb())) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE, resultBundle);
        intent.putExtra(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BLURB, resultBlurb);
        t3.setResult(-1, intent);
    }

    @Nullable
    public static String a(@NonNull T t3) {
        return t3.getIntent().getStringExtra(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BLURB);
    }
}
