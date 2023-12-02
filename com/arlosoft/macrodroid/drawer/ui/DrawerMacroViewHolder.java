package com.arlosoft.macrodroid.drawer.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemMacro;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.InvokedByDrawerTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class DrawerMacroViewHolder extends DrawerItemViewHolder {
    @BindView(R.id.drag_handle)
    ImageView dragHandle;

    /* renamed from: e  reason: collision with root package name */
    private Macro f11491e;

    /* renamed from: f  reason: collision with root package name */
    private DrawerItemMacro f11492f;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.macro_name)
    TextView macroName;

    public DrawerMacroViewHolder(@NonNull View view, DrawItemListener drawItemListener, int i4) {
        super(view, drawItemListener);
        ButterKnife.bind(this, view);
        this.macroName.setTextSize(2, i4);
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    protected ImageView[] e() {
        return new ImageView[]{this.icon};
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    @Nullable
    protected TextView[] f() {
        return new TextView[]{this.macroName};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.macro_container})
    public void handleClick() {
        if (this.f11492f.isValid()) {
            TriggerContextInfo triggerContextInfo = new TriggerContextInfo(InvokedByDrawerTrigger.getInstance());
            if (!this.f11492f.getEnforceConstraints() || this.f11491e.canInvoke(triggerContextInfo)) {
                if (!this.f11492f.getKeepDrawerOpenOnPress()) {
                    d();
                }
                SystemLog.logInfo("Invoking macro from drawer: " + this.f11491e.getName());
                this.f11491e.setTriggerThatInvoked(InvokedByDrawerTrigger.getInstance());
                this.f11491e.invokeActions(new TriggerContextInfo(""));
            }
        }
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void onBind(@NonNull DrawerItem drawerItem, boolean z3) {
        int i4;
        super.onBind(drawerItem, z3);
        if (drawerItem instanceof DrawerItemMacro) {
            ImageView imageView = this.icon;
            if (drawerItem.hideIcon()) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            imageView.setVisibility(i4);
            this.f11492f = (DrawerItemMacro) drawerItem;
            setIcon(this.icon, drawerItem, R.drawable.launcher_no_border);
            setColor(this.f11492f.getColor());
            this.f11491e = MacroStore.getInstance().getMacroByGUID(this.f11492f.getMacroGuid());
            this.macroName.setText(this.f11492f.getName());
            if (z3) {
                this.dragHandle.setVisibility(0);
                i(this.dragHandle);
                return;
            }
            this.dragHandle.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("DrawerItemMacro required");
    }
}
