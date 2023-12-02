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
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemActionBlock;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.EmptyTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes3.dex */
public class DrawerActionBlockViewHolder extends DrawerItemViewHolder {
    @BindView(R.id.action_block_name)
    TextView actionBlockName;
    @BindView(R.id.drag_handle)
    ImageView dragHandle;

    /* renamed from: e  reason: collision with root package name */
    private ActionBlock f11470e;

    /* renamed from: f  reason: collision with root package name */
    private DrawerItemActionBlock f11471f;
    @BindView(R.id.icon)
    ImageView icon;

    public DrawerActionBlockViewHolder(@NonNull View view, DrawItemListener drawItemListener, int i4) {
        super(view, drawItemListener);
        ButterKnife.bind(this, view);
        this.actionBlockName.setTextSize(2, i4);
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    protected ImageView[] e() {
        return new ImageView[]{this.icon};
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    @Nullable
    protected TextView[] f() {
        return new TextView[]{this.actionBlockName};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.macro_container})
    public void handleClick() {
        if (this.f11470e.isValid()) {
            d();
            SystemLog.logInfo("Invoking action block from drawer: " + this.f11470e.getName());
            ActionBlock cloneActionBlock = this.f11470e.cloneActionBlock(false, true);
            TriggerContextInfo triggerContextInfo = new TriggerContextInfo(new EmptyTrigger());
            cloneActionBlock.setIsClonedInstance(true);
            MacroStore.getInstance().addActionBlock(cloneActionBlock);
            cloneActionBlock.invokeActions((TriggerContextInfo) null, true, new ResumeMacroInfo(cloneActionBlock.getGUID(), -1, triggerContextInfo, true, new Stack(), null, this.f11471f.getActionBlockData().getOutputVarsMap()), (Map<String, String>) this.f11471f.getActionBlockData().getInputVarsMap(), Collections.emptyMap(), (Macro) null);
        }
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void onBind(@NonNull DrawerItem drawerItem, boolean z3) {
        int i4;
        super.onBind(drawerItem, z3);
        if (drawerItem instanceof DrawerItemActionBlock) {
            ImageView imageView = this.icon;
            if (drawerItem.hideIcon()) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            imageView.setVisibility(i4);
            this.f11471f = (DrawerItemActionBlock) drawerItem;
            setIcon(this.icon, drawerItem, R.drawable.launcher_no_border);
            setColor(this.f11471f.getColor());
            this.f11470e = MacroStore.getInstance().getActionBlockByGuid(this.f11471f.getActionBlockGuid());
            this.actionBlockName.setText(this.f11471f.getName());
            if (z3) {
                this.dragHandle.setVisibility(0);
                i(this.dragHandle);
                return;
            }
            this.dragHandle.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("DrawerItemActionBlock required");
    }
}
