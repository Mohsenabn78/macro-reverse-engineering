package com.arlosoft.macrodroid.drawer.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemOpenShortcut;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class DrawerOpenShortcutViewHolder extends DrawerItemViewHolder {
    @BindView(R.id.app_name)
    TextView appName;
    @BindView(R.id.drag_handle)
    ImageView dragHandle;

    /* renamed from: e  reason: collision with root package name */
    private DrawerItemOpenShortcut f11497e;
    @BindView(R.id.icon)
    ImageView icon;

    public DrawerOpenShortcutViewHolder(@NonNull View view, DrawItemListener drawItemListener, int i4) {
        super(view, drawItemListener);
        ButterKnife.bind(this, view);
        this.appName.setTextSize(2, i4);
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    protected ImageView[] e() {
        return new ImageView[]{this.icon};
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    @Nullable
    protected TextView[] f() {
        return new TextView[]{this.appName};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.macro_container})
    public void handleClick() {
        Intent intent;
        if (this.f11497e.isValid()) {
            d();
            try {
                try {
                    intent = Intent.getIntent(this.f11497e.getIntent());
                } catch (SecurityException e4) {
                    e = e4;
                    intent = null;
                }
                try {
                    if (intent.getAction().equals("android.intent.action.CALL_PRIVILEGED")) {
                        intent.setAction("android.intent.action.CALL");
                    }
                    intent.addFlags(268435456);
                    getContext().startActivity(intent);
                } catch (SecurityException e5) {
                    e = e5;
                    if (intent != null && intent.getAction().equals("android.intent.action.CALL")) {
                        PermissionsHelper.showNeedsPermission(getContext(), "android.permission.CALL_PHONE", null, true, true);
                        return;
                    }
                    SystemLog.logError("Failed to launch shortcut, MacroDroid may need a permission: " + e.toString());
                    ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) e.toString(), 1).show();
                }
            } catch (Exception unused) {
                Util.displayNotification(getContext(), getContext().getString(R.string.action_launch_failed_to_launch) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f11497e.getName(), getContext().getString(R.string.action_launch_shortcut_been_removed), false);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void onBind(@NonNull DrawerItem drawerItem, boolean z3) {
        int i4;
        super.onBind(drawerItem, z3);
        if (drawerItem instanceof DrawerItemOpenShortcut) {
            ImageView imageView = this.icon;
            if (drawerItem.hideIcon()) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            imageView.setVisibility(i4);
            this.f11497e = (DrawerItemOpenShortcut) drawerItem;
            this.appName.setText(MagicText.replaceMagicText(getContext(), this.f11497e.getText(), null, null).replace("\\n", "\n"));
            setNonTintImageViews(this.icon);
            if (drawerItem.getImageResourceName() != null) {
                setIcon(this.icon, drawerItem, R.drawable.launcher_no_border);
            } else {
                try {
                    this.icon.setImageDrawable(getContext().getPackageManager().getApplicationIcon(this.f11497e.getPackageName()));
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            setColor(this.f11497e.getColor());
            if (z3) {
                this.dragHandle.setVisibility(0);
                i(this.dragHandle);
                return;
            }
            this.dragHandle.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("DrawerItemOpenShortcut required");
    }
}
