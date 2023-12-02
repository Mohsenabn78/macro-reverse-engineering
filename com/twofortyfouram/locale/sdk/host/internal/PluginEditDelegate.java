package com.twofortyfouram.locale.sdk.host.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.plugins.comments.PluginCommentsActivity;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.assertion.BundleAssertions;
import com.twofortyfouram.locale.sdk.host.TaskerPlugin;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginErrorEdit;
import com.twofortyfouram.locale.sdk.host.model.PluginInstanceData;
import com.twofortyfouram.locale.sdk.host.ui.fragment.IPluginEditFragment;
import com.twofortyfouram.log.Lumberjack;
import com.twofortyfouram.spackle.bundle.BundleScrubber;
import java.util.EnumSet;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class PluginEditDelegate {
    @NonNull
    public static Plugin getCurrentPlugin(@NonNull Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable(IPluginEditFragment.ARG_EXTRA_PARCELABLE_CURRENT_PLUGIN);
        if (parcelable != null) {
            if (parcelable instanceof Plugin) {
                return (Plugin) parcelable;
            }
            throw new IllegalArgumentException(Lumberjack.formatMessage("Arg %s is the wrong type", IPluginEditFragment.ARG_EXTRA_PARCELABLE_CURRENT_PLUGIN));
        }
        throw new IllegalArgumentException(Lumberjack.formatMessage("Arg %s is missing", IPluginEditFragment.ARG_EXTRA_PARCELABLE_CURRENT_PLUGIN));
    }

    @NonNull
    public static Intent getPluginStartIntent(@NonNull Plugin plugin, @Nullable PluginInstanceData pluginInstanceData, @Nullable String str) {
        Bundle bundle;
        Assertions.assertNotNull(plugin, PluginCommentsActivity.EXTRA_PLUGIN_DETAIL);
        Intent intent = new Intent(plugin.getType().getActivityIntentAction());
        intent.setClassName(plugin.getPackageName(), plugin.getActivityClassName());
        intent.putExtra(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BREADCRUMB, str);
        TaskerPlugin.Host.addCapabilities(intent, 126);
        if (pluginInstanceData != null) {
            try {
                bundle = BundleSerializer.deserializeFromByteArray(pluginInstanceData.getSerializedBundle());
            } catch (AssertionError | Exception unused) {
                bundle = null;
            }
            if (bundle != null) {
                intent.putExtra(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE, bundle);
                intent.putExtra(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BLURB, pluginInstanceData.getBlurb());
                if (plugin.getConfiguration().isBackwardsCompatibilityEnabled()) {
                    intent.putExtras(bundle);
                }
            }
        }
        return intent;
    }

    @Nullable
    public static PluginInstanceData getPreviousPluginInstanceData(@NonNull Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable(IPluginEditFragment.ARG_EXTRA_PARCELABLE_PREVIOUS_PLUGIN_INSTANCE_DATA);
        if (parcelable != null) {
            if (parcelable instanceof PluginInstanceData) {
                return (PluginInstanceData) parcelable;
            }
            throw new IllegalArgumentException(Lumberjack.formatMessage("Arg %s is the wrong type", IPluginEditFragment.ARG_EXTRA_PARCELABLE_PREVIOUS_PLUGIN_INSTANCE_DATA));
        }
        return null;
    }

    @NonNull
    public static EnumSet<PluginErrorEdit> isIntentValid(@Nullable Intent intent, @NonNull Plugin plugin) {
        EnumSet<PluginErrorEdit> noneOf = EnumSet.noneOf(PluginErrorEdit.class);
        if (intent == null) {
            noneOf.add(PluginErrorEdit.INTENT_NULL);
        } else {
            if (BundleScrubber.scrub(intent)) {
                noneOf.add(PluginErrorEdit.PRIVATE_SERIALIZABLE);
            }
            Bundle extras = intent.getExtras();
            if (extras == null) {
                noneOf.add(PluginErrorEdit.BLURB_MISSING);
                noneOf.add(PluginErrorEdit.BUNDLE_MISSING);
            } else {
                Bundle bundle = extras.getBundle(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE);
                if (BundleScrubber.scrub(bundle)) {
                    noneOf.add(PluginErrorEdit.PRIVATE_SERIALIZABLE);
                }
                if (bundle == null) {
                    if (plugin.getConfiguration().isBackwardsCompatibilityEnabled()) {
                        Bundle bundle2 = new Bundle(intent.getExtras());
                        bundle2.remove(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BLURB);
                        intent.putExtra(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE, bundle2);
                    } else {
                        noneOf.add(PluginErrorEdit.BUNDLE_MISSING);
                    }
                }
                try {
                    if (extras.getString(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BLURB) == null) {
                        extras.putString(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BLURB, "");
                    }
                    BundleAssertions.assertHasString(extras, com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BLURB, false, true);
                } catch (AssertionError unused) {
                    noneOf.add(PluginErrorEdit.BLURB_MISSING);
                }
            }
        }
        return noneOf;
    }

    @NonNull
    public static Bundle newArgs(@NonNull Plugin plugin, @Nullable PluginInstanceData pluginInstanceData) {
        Assertions.assertNotNull(plugin, PluginCommentsActivity.EXTRA_PLUGIN_DETAIL);
        Bundle bundle = new Bundle();
        bundle.putParcelable(IPluginEditFragment.ARG_EXTRA_PARCELABLE_CURRENT_PLUGIN, plugin);
        if (pluginInstanceData != null) {
            bundle.putParcelable(IPluginEditFragment.ARG_EXTRA_PARCELABLE_PREVIOUS_PLUGIN_INSTANCE_DATA, pluginInstanceData);
        }
        return bundle;
    }

    @Nullable
    public static byte[] serializeBundle(@NonNull Bundle bundle, @NonNull EnumSet<PluginErrorEdit> enumSet) {
        byte[] bArr;
        Assertions.assertNotNull(bundle, "bundle");
        try {
            bArr = BundleSerializer.serializeToByteArray(bundle);
        } catch (Exception unused) {
            enumSet.add(PluginErrorEdit.BUNDLE_NOT_SERIALIZABLE);
            bArr = null;
        }
        if (bArr != null && 25000 < bArr.length) {
            enumSet.add(PluginErrorEdit.BUNDLE_TOO_LARGE);
            return null;
        }
        return bArr;
    }
}
