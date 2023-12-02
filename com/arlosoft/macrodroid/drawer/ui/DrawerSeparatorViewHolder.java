package com.arlosoft.macrodroid.drawer.ui;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemSeparator;

/* loaded from: classes3.dex */
public class DrawerSeparatorViewHolder extends DrawerItemViewHolder {
    @BindView(R.id.drag_handle)
    ImageView dragHandle;

    public DrawerSeparatorViewHolder(@NonNull View view, DrawItemListener drawItemListener) {
        super(view, drawItemListener);
        ButterKnife.bind(this, view);
        setColor(ContextCompat.getColor(getContext(), R.color.drawer_text_color));
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void onBind(@NonNull DrawerItem drawerItem, boolean z3) {
        super.onBind(drawerItem, z3);
        if (drawerItem instanceof DrawerItemSeparator) {
            if (z3) {
                this.dragHandle.setVisibility(0);
                i(this.dragHandle);
                return;
            }
            this.dragHandle.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("DrawerItemSeparator required");
    }
}
