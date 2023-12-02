package com.twofortyfouram.locale.sdk.host.ui.fragment;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.plugins.comments.PluginCommentsActivity;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.TaskerPlugin;
import com.twofortyfouram.locale.sdk.host.internal.BundleSerializer;
import com.twofortyfouram.locale.sdk.host.internal.PluginEditDelegate;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginErrorEdit;
import com.twofortyfouram.locale.sdk.host.model.PluginInstanceData;
import com.twofortyfouram.log.Lumberjack;
import java.util.EnumSet;

@TargetApi(11)
/* loaded from: classes6.dex */
public abstract class AbstractPluginEditFragment extends Fragment implements IPluginEditFragment {
    private static final int REQUEST_CODE_EDIT_PLUGIN = 1;
    @NonNull
    private static final String STATE_BOOLEAN_IS_SAVED_INSTANCE = AbstractSupportPluginEditFragment.class.getName() + ".state.BOOLEAN_IS_SAVED_INSTANCE";
    @Nullable
    private Plugin mPlugin = null;
    @Nullable
    private PluginInstanceData mPreviousPluginInstanceData = null;

    private void handleCancelInternal(@NonNull Plugin plugin) {
        Assertions.assertNotNull(plugin, PluginCommentsActivity.EXTRA_PLUGIN_DETAIL);
        handleCancel(plugin);
        removeSelf();
    }

    private void handleErrorsInternal(@NonNull Plugin plugin, @NonNull EnumSet<PluginErrorEdit> enumSet) {
        handleErrors(plugin, enumSet);
        removeSelf();
    }

    private void handleSaveInternal(@NonNull Bundle bundle, @NonNull String str, @Nullable Bundle bundle2, @Nullable String str2, @Nullable String[] strArr) {
        EnumSet<PluginErrorEdit> noneOf = EnumSet.noneOf(PluginErrorEdit.class);
        byte[] serializeBundle = serializeBundle(bundle, noneOf);
        if (serializeBundle != null) {
            handleSave(this.mPlugin, new PluginInstanceData(this.mPlugin.getType(), this.mPlugin.getRegistryName(), serializeBundle, str), strArr);
            removeSelf();
            return;
        }
        handleErrorsInternal(this.mPlugin, noneOf);
    }

    @NonNull
    public static Bundle newArgs(@NonNull Plugin plugin, @Nullable PluginInstanceData pluginInstanceData) {
        Assertions.assertNotNull(plugin, PluginCommentsActivity.EXTRA_PLUGIN_DETAIL);
        return PluginEditDelegate.newArgs(plugin, pluginInstanceData);
    }

    private void removeSelf() {
        getFragmentManager().beginTransaction().remove(this).commit();
    }

    @Nullable
    private static byte[] serializeBundle(@NonNull Bundle bundle, @NonNull EnumSet<PluginErrorEdit> enumSet) {
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

    @Override // android.app.Fragment
    public final void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        String blurb;
        Bundle bundle;
        if (1 == i4) {
            if (i5 != -1) {
                if (i5 != 0) {
                    Lumberjack.always("ERROR: Received illegal result code %d", Integer.valueOf(i5));
                    handleErrorsInternal(this.mPlugin, EnumSet.of(PluginErrorEdit.UNKNOWN_ACTIVITY_RESULT_CODE));
                    return;
                }
                Lumberjack.always("Received result code RESULT_CANCELED", new Object[0]);
                handleCancelInternal(this.mPlugin);
                return;
            }
            Lumberjack.always("Received result code RESULT_OK", new Object[0]);
            EnumSet<PluginErrorEdit> isIntentValid = PluginEditDelegate.isIntentValid(intent, this.mPlugin);
            if (isIntentValid.isEmpty()) {
                Bundle bundleExtra = intent.getBundleExtra(com.twofortyfouram.locale.api.Intent.EXTRA_BUNDLE);
                String stringExtra = intent.getStringExtra(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BLURB);
                PluginInstanceData pluginInstanceData = this.mPreviousPluginInstanceData;
                Bundle bundle2 = null;
                if (pluginInstanceData != null) {
                    try {
                        bundle2 = BundleSerializer.deserializeFromByteArray(pluginInstanceData.getSerializedBundle());
                    } catch (ClassNotFoundException unused) {
                    }
                    blurb = this.mPreviousPluginInstanceData.getBlurb();
                    bundle = bundle2;
                } else {
                    bundle = null;
                    blurb = null;
                }
                handleSaveInternal(bundleExtra, stringExtra, bundle, blurb, TaskerPlugin.getRelevantVariableList(intent.getExtras()));
                return;
            }
            handleErrorsInternal(this.mPlugin, isIntentValid);
            return;
        }
        super.onActivityResult(i4, i5, intent);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mPlugin = PluginEditDelegate.getCurrentPlugin(arguments);
            this.mPreviousPluginInstanceData = PluginEditDelegate.getPreviousPluginInstanceData(arguments);
            return;
        }
        throw new IllegalArgumentException("arguments are missing");
    }

    @Override // android.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        CharSequence subtitle;
        super.onCreate(bundle);
        if (bundle == null) {
            ActionBar actionBar = getActivity().getActionBar();
            if (actionBar != null && (subtitle = actionBar.getSubtitle()) != null) {
                str = subtitle.toString();
            } else {
                str = null;
            }
            try {
                startActivityForResult(PluginEditDelegate.getPluginStartIntent(this.mPlugin, this.mPreviousPluginInstanceData, str), 1);
            } catch (ActivityNotFoundException unused) {
                handleErrorsInternal(this.mPlugin, EnumSet.of(PluginErrorEdit.ACTIVITY_NOT_FOUND_EXCEPTION));
            } catch (SecurityException unused2) {
                handleErrorsInternal(this.mPlugin, EnumSet.of(PluginErrorEdit.SECURITY_EXCEPTION));
            }
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(STATE_BOOLEAN_IS_SAVED_INSTANCE, true);
    }
}
