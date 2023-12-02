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
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemAppShortcut;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class DrawerAppShortcutViewHolder extends DrawerItemViewHolder {
    @BindView(R.id.app_name)
    TextView appName;
    @BindView(R.id.drag_handle)
    ImageView dragHandle;

    /* renamed from: e  reason: collision with root package name */
    private DrawerItemAppShortcut f11476e;
    @BindView(R.id.icon)
    ImageView icon;

    public DrawerAppShortcutViewHolder(@NonNull View view, DrawItemListener drawItemListener, int i4) {
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
        if (this.f11476e.isValid()) {
            d();
            Intent launchIntentForPackage = getContext().getPackageManager().getLaunchIntentForPackage(this.f11476e.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(2097152);
                launchIntentForPackage.addFlags(268435456);
                getContext().startActivity(launchIntentForPackage);
                return;
            }
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.app_not_found, 0).show();
        }
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void onBind(@NonNull DrawerItem drawerItem, boolean z3) {
        int i4;
        super.onBind(drawerItem, z3);
        if (drawerItem instanceof DrawerItemAppShortcut) {
            ImageView imageView = this.icon;
            if (drawerItem.hideIcon()) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            imageView.setVisibility(i4);
            this.f11476e = (DrawerItemAppShortcut) drawerItem;
            this.appName.setText(MagicText.replaceMagicText(getContext(), this.f11476e.getText(), null, null).replace("\\n", "\n"));
            setNonTintImageViews(this.icon);
            if (drawerItem.getImageResourceName() != null) {
                setIcon(this.icon, drawerItem, R.drawable.launcher_no_border);
            } else {
                try {
                    this.icon.setImageDrawable(getContext().getPackageManager().getApplicationIcon(this.f11476e.getPackageName()));
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            setColor(this.f11476e.getColor());
            if (z3) {
                this.dragHandle.setVisibility(0);
                i(this.dragHandle);
                return;
            }
            this.dragHandle.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("DrawerItemAppShortcut required");
    }
}
