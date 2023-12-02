package com.arlosoft.macrodroid.drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.ui.DrawItemListener;
import com.arlosoft.macrodroid.drawer.ui.DrawerActionBlockViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerAppShortcutViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerLogViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerMacroViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerOpenShortcutViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerSeparatorViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerStopWatchViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerTextViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerVariableViewHolder;
import com.arlosoft.macrodroid.settings.Settings;
import java.util.List;

/* loaded from: classes3.dex */
public class MacroDroidDrawerAdapter extends RecyclerView.Adapter<DrawerItemViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private List<DrawerItem> f11464a;

    /* renamed from: b  reason: collision with root package name */
    private DrawItemListener f11465b;

    /* renamed from: c  reason: collision with root package name */
    private MacroDroidRoomDatabase f11466c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11467d;

    public MacroDroidDrawerAdapter(@NonNull Context context, MacroDroidRoomDatabase macroDroidRoomDatabase, List<DrawerItem> list, DrawItemListener drawItemListener) {
        this.f11464a = list;
        this.f11465b = drawItemListener;
        this.f11466c = macroDroidRoomDatabase;
    }

    public static DrawerItemViewHolder getViewHolder(MacroDroidRoomDatabase macroDroidRoomDatabase, ViewGroup viewGroup, int i4, DrawItemListener drawItemListener) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i4, viewGroup, false);
        int drawerTextSize = Settings.getDrawerTextSize(viewGroup.getContext());
        switch (i4) {
            case R.layout.drawer_item_action_block /* 2131558716 */:
                return new DrawerActionBlockViewHolder(inflate, drawItemListener, drawerTextSize);
            case R.layout.drawer_item_add /* 2131558717 */:
            default:
                return null;
            case R.layout.drawer_item_app_shortcut /* 2131558718 */:
                return new DrawerAppShortcutViewHolder(inflate, drawItemListener, drawerTextSize);
            case R.layout.drawer_item_log /* 2131558719 */:
                return new DrawerLogViewHolder(macroDroidRoomDatabase, inflate, drawItemListener, drawerTextSize);
            case R.layout.drawer_item_macro /* 2131558720 */:
                return new DrawerMacroViewHolder(inflate, drawItemListener, drawerTextSize);
            case R.layout.drawer_item_open_shortcut /* 2131558721 */:
                return new DrawerOpenShortcutViewHolder(inflate, drawItemListener, drawerTextSize);
            case R.layout.drawer_item_seperator /* 2131558722 */:
                return new DrawerSeparatorViewHolder(inflate, drawItemListener);
            case R.layout.drawer_item_stopwatch /* 2131558723 */:
                return new DrawerStopWatchViewHolder(inflate, drawItemListener, drawerTextSize);
            case R.layout.drawer_item_text /* 2131558724 */:
                return new DrawerTextViewHolder(inflate, drawItemListener, drawerTextSize);
            case R.layout.drawer_item_variable /* 2131558725 */:
                return new DrawerVariableViewHolder(inflate, drawItemListener, drawerTextSize);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f11464a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        this.f11464a.get(i4).getGuid();
        return this.f11464a.get(i4).getGuid();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        return this.f11464a.get(i4).getLayoutResId();
    }

    public List<DrawerItem> getItems() {
        return this.f11464a;
    }

    public boolean getReorder() {
        return this.f11467d;
    }

    public void setReorder(boolean z3) {
        this.f11467d = z3;
        notifyDataSetChanged();
    }

    public void updateItems(List<DrawerItem> list) {
        this.f11464a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(DrawerItemViewHolder drawerItemViewHolder, int i4, List list) {
        onBindViewHolder2(drawerItemViewHolder, i4, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DrawerItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        return getViewHolder(this.f11466c, viewGroup, i4, this.f11465b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(DrawerItemViewHolder drawerItemViewHolder) {
        drawerItemViewHolder.unbind();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DrawerItemViewHolder drawerItemViewHolder, int i4) {
        drawerItemViewHolder.onBind(this.f11464a.get(i4), this.f11467d);
    }

    /* renamed from: onBindViewHolder  reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(DrawerItemViewHolder drawerItemViewHolder, int i4, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(drawerItemViewHolder, i4);
            return;
        }
        for (Object obj : list) {
            if (obj instanceof RefreshPayload) {
                drawerItemViewHolder.refresh();
                return;
            }
        }
    }
}
