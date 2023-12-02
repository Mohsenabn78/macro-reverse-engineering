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
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.InvokedByDrawerTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class DrawerTextViewHolder extends DrawerItemViewHolder {
    @BindView(R.id.drag_handle)
    ImageView dragHandle;

    /* renamed from: e  reason: collision with root package name */
    private DrawerItemText f11540e;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.text)
    TextView text;

    public DrawerTextViewHolder(@NonNull View view, DrawItemListener drawItemListener, int i4) {
        super(view, drawItemListener);
        ButterKnife.bind(this, view);
        this.text.setTextSize(2, i4);
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    protected ImageView[] e() {
        return new ImageView[]{this.icon};
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    @Nullable
    protected TextView[] f() {
        return new TextView[]{this.text};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.macro_container})
    public void handleClick() {
        if (this.f11540e.getMacroGuid() != 0) {
            Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(this.f11540e.getMacroGuid());
            d();
            if (macroByGUID != null) {
                TriggerContextInfo triggerContextInfo = new TriggerContextInfo(InvokedByDrawerTrigger.getInstance());
                if (!this.f11540e.getEnforceConstraints() || macroByGUID.canInvoke(triggerContextInfo)) {
                    macroByGUID.setTriggerThatInvoked(InvokedByDrawerTrigger.getInstance());
                    macroByGUID.invokeActions(new TriggerContextInfo(""));
                    return;
                }
                return;
            }
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.macro_not_found, 0).show();
        }
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void onBind(@NonNull DrawerItem drawerItem, boolean z3) {
        int i4;
        super.onBind(drawerItem, z3);
        if (drawerItem instanceof DrawerItemText) {
            ImageView imageView = this.icon;
            if (drawerItem.hideIcon()) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            imageView.setVisibility(i4);
            this.f11540e = (DrawerItemText) drawerItem;
            String replace = MagicText.replaceMagicText(getContext(), this.f11540e.getText(), null, null).replace("\\n", "\n");
            setIcon(this.icon, drawerItem, R.drawable.ic_format_text_white_24dp);
            setColor(this.f11540e.getColor());
            this.text.setMaxLines(this.f11540e.getMaxLines());
            this.text.setText(replace);
            if (z3) {
                this.dragHandle.setVisibility(0);
                i(this.dragHandle);
                return;
            }
            this.dragHandle.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("DrawerItemText required");
    }
}
