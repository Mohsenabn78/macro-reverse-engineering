package com.arlosoft.macrodroid.drawer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.drawer.MacroDroidDrawer;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemMacro;
import com.arlosoft.macrodroid.drawer.model.DrawerItemSeparator;
import com.arlosoft.macrodroid.drawer.model.RefreshableDrawerItem;
import com.arlosoft.macrodroid.drawer.ui.DrawItemListener;
import com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder;
import com.arlosoft.macrodroid.drawer.ui.DrawerOptionsActivity;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.events.CloseDrawerEvent;
import com.arlosoft.macrodroid.events.DrawerRefreshEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.OverlayUtils;
import com.github.pwittchen.swipe.library.rx2.Swipe;
import com.github.pwittchen.swipe.library.rx2.SwipeEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class MacroDroidDrawer extends RecyclerView implements DrawItemListener {

    /* renamed from: a  reason: collision with root package name */
    private DrawerConfiguration f11450a;

    /* renamed from: b  reason: collision with root package name */
    private MacroDroidDrawerAdapter f11451b;

    /* renamed from: c  reason: collision with root package name */
    private ItemTouchHelper f11452c;

    /* renamed from: d  reason: collision with root package name */
    private Timer f11453d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayoutManager f11454e;

    /* renamed from: f  reason: collision with root package name */
    private Swipe f11455f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f11456g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f11457h;

    /* renamed from: i  reason: collision with root package name */
    private Runnable f11458i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    MacroDroidRoomDatabase f11459j;

    /* renamed from: k  reason: collision with root package name */
    ItemTouchHelper.Callback f11460k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Handler f11462a;

        b(Handler handler) {
            this.f11462a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            List<DrawerItem> items = MacroDroidDrawer.this.f11451b.getItems();
            RefreshPayload refreshPayload = new RefreshPayload();
            for (int i4 = 0; i4 < items.size(); i4++) {
                if (items.get(i4) instanceof RefreshableDrawerItem) {
                    MacroDroidDrawer.this.f11451b.notifyItemChanged(i4, refreshPayload);
                }
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f11462a.post(new Runnable() { // from class: com.arlosoft.macrodroid.drawer.a
                @Override // java.lang.Runnable
                public final void run() {
                    MacroDroidDrawer.b.this.b();
                }
            });
        }
    }

    public MacroDroidDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11453d = new Timer();
        this.f11457h = new Handler();
        this.f11458i = new Runnable() { // from class: z.k
            @Override // java.lang.Runnable
            public final void run() {
                MacroDroidDrawer.i();
            }
        };
        this.f11460k = new a();
        MacroDroidApplication.appComponentInstance.inject(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.f11454e = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        this.f11450a = Settings.getDrawerConfiguration(getContext());
        MacroDroidDrawerAdapter macroDroidDrawerAdapter = new MacroDroidDrawerAdapter(getContext(), this.f11459j, this.f11450a.drawerItems, this);
        this.f11451b = macroDroidDrawerAdapter;
        macroDroidDrawerAdapter.setHasStableIds(true);
        setAdapter(this.f11451b);
        setItemAnimator(null);
        this.f11452c = new ItemTouchHelper(this.f11460k);
        setPadding(0, 0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.margin_medium));
        setClipToPadding(false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), this.f11454e.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.drawer_divider));
        addItemDecoration(dividerItemDecoration);
        m();
    }

    private void g() {
        this.f11450a.drawerItems.add(new DrawerItemSeparator());
        Settings.setDrawerConfiguration(getContext(), this.f11450a);
        EventBusUtils.getEventBus().post(new DrawerRefreshEvent(1));
        ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.drawer_item_added, 0).show();
    }

    private void h(boolean z3) {
        getContext().startActivity(DrawerOptionsActivity.getLogIntent(getContext(), -1L, z3));
        EventBusUtils.getEventBus().post(new CloseDrawerEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i() {
        EventBusUtils.getEventBus().post(new CloseDrawerEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(SwipeEvent swipeEvent) throws Exception {
        if (swipeEvent == SwipeEvent.SWIPED_RIGHT && !this.f11450a.leftSide) {
            EventBusUtils.getEventBus().post(new CloseDrawerEvent());
        } else if (swipeEvent == SwipeEvent.SWIPED_LEFT && this.f11450a.leftSide) {
            EventBusUtils.getEventBus().post(new CloseDrawerEvent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(String[] strArr, DrawerItem drawerItem, DialogInterface dialogInterface, int i4) {
        if (strArr[i4].equals(getContext().getString(R.string.edit))) {
            getContext().startActivity(DrawerOptionsActivity.getEditIntent(getContext(), drawerItem.getGuid()));
            EventBusUtils.getEventBus().post(new CloseDrawerEvent());
        } else if (strArr[i4].equals(getContext().getString(R.string.delete))) {
            this.f11450a.drawerItems.remove(drawerItem);
            Settings.setDrawerConfiguration(getContext(), this.f11450a);
            this.f11451b.updateItems(this.f11450a.drawerItems);
            this.f11451b.notifyDataSetChanged();
        } else if (strArr[i4].equals(getContext().getString(R.string.edit_macro))) {
            Intent intent = new Intent(getContext(), EditMacroActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(Constants.EXTRA_MACRO_GUID, ((DrawerItemMacro) drawerItem).getMacroGuid());
            getContext().startActivity(intent);
            EventBusUtils.getEventBus().post(new CloseDrawerEvent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(DialogInterface dialogInterface, int i4) {
        switch (i4) {
            case 0:
                getContext().startActivity(DrawerOptionsActivity.getIntent(getContext(), 1));
                break;
            case 1:
                getContext().startActivity(DrawerOptionsActivity.getIntent(getContext(), 2));
                break;
            case 2:
                getContext().startActivity(DrawerOptionsActivity.getIntent(getContext(), 3));
                break;
            case 3:
                getContext().startActivity(DrawerOptionsActivity.getIntent(getContext(), 4));
                break;
            case 4:
                getContext().startActivity(DrawerOptionsActivity.getIntent(getContext(), 5));
                break;
            case 5:
                h(false);
                break;
            case 6:
                h(true);
                break;
            case 7:
                getContext().startActivity(DrawerOptionsActivity.getIntent(getContext(), 7));
                break;
            case 8:
                getContext().startActivity(DrawerOptionsActivity.getIntent(getContext(), 8));
                break;
            case 9:
                g();
                break;
        }
        EventBusUtils.getEventBus().post(new CloseDrawerEvent());
    }

    private void m() {
        if (Settings.getDrawerAutoClose(getContext())) {
            this.f11457h.removeCallbacksAndMessages(null);
            this.f11457h.postDelayed(this.f11458i, Settings.getDrawerAutoCloseTimeoutSeconds(getContext()) * 1000);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f11455f.dispatchTouchEvent(motionEvent);
        m();
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Handler handler = new Handler();
        try {
            EventBusUtils.getEventBus().register(this);
        } catch (Throwable unused) {
        }
        this.f11453d.scheduleAtFixedRate(new b(handler), 0L, 1000L);
        Swipe swipe = new Swipe(getContext().getResources().getDimensionPixelSize(R.dimen.swiping_threshold), getContext().getResources().getDimensionPixelSize(R.dimen.swiped_threshold));
        this.f11455f = swipe;
        this.f11456g = swipe.observe().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: z.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MacroDroidDrawer.this.j((SwipeEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBusUtils.getEventBus().unregister(this);
        this.f11453d.cancel();
        this.f11457h.removeCallbacksAndMessages(null);
        Disposable disposable = this.f11456g;
        if (disposable != null && !disposable.isDisposed()) {
            this.f11456g.dispose();
        }
    }

    public void onEventMainThread(DrawerRefreshEvent drawerRefreshEvent) {
        DrawerConfiguration drawerConfiguration = Settings.getDrawerConfiguration(getContext());
        this.f11450a = drawerConfiguration;
        this.f11451b.updateItems(drawerConfiguration.drawerItems);
        if (drawerRefreshEvent.eventType == 1) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.drawer_item_added, 0).show();
            smoothScrollToPosition(this.f11451b.getItemCount() - 1);
        }
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawItemListener
    public void onLongPress(DrawerItemViewHolder drawerItemViewHolder) {
        final String[] strArr;
        final DrawerItem drawerItem = drawerItemViewHolder.getDrawerItem();
        if (drawerItem == null) {
            return;
        }
        if (drawerItem.isValid() && drawerItem.isEditable()) {
            strArr = drawerItem instanceof DrawerItemMacro ? new String[]{getContext().getString(R.string.edit), getContext().getString(R.string.delete), getContext().getString(R.string.edit_macro)} : new String[]{getContext().getString(R.string.edit), getContext().getString(R.string.delete)};
        } else {
            strArr = new String[]{getContext().getString(R.string.delete)};
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.Theme_App_Dialog);
        builder.setTitle(drawerItem.getName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: z.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroDroidDrawer.this.k(strArr, drawerItem, dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.getWindow().setType(OverlayUtils.getOverlayTypeDrawer(getContext()));
        create.show();
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawItemListener
    public void onStartDrag(DrawerItemViewHolder drawerItemViewHolder) {
        this.f11452c.startDrag(drawerItemViewHolder);
    }

    public void setBackgroundTint() {
        Drawable wrap = DrawableCompat.wrap(getBackground());
        DrawableCompat.setTint(wrap, this.f11450a.backgroundColor);
        setBackground(wrap);
    }

    public void showAddDrawerItemDialog() {
        this.f11457h.removeCallbacksAndMessages(null);
        String[] strArr = {getContext().getString(R.string.app_shortcut), getContext().getString(R.string.action_disable_macro_macro), getContext().getString(R.string.action_action_block), getContext().getString(R.string.action_share_location_option_variable), getContext().getString(R.string.action_stop_watch), getContext().getString(R.string.system_log), getContext().getString(R.string.user_log), getContext().getString(R.string.text), getContext().getString(R.string.shortcut_link), getContext().getString(R.string.separator)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.Theme_App_Dialog);
        builder.setTitle(R.string.add_drawer_item);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: z.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroDroidDrawer.this.l(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.getWindow().setType(OverlayUtils.getOverlayTypeDrawer(getContext()));
        create.show();
    }

    public void toggleReorderState() {
        m();
        MacroDroidDrawerAdapter macroDroidDrawerAdapter = this.f11451b;
        macroDroidDrawerAdapter.setReorder(!macroDroidDrawerAdapter.getReorder());
        if (this.f11451b.getReorder()) {
            this.f11452c.attachToRecyclerView(this);
        } else {
            this.f11452c.attachToRecyclerView(null);
        }
    }

    /* loaded from: classes3.dex */
    class a extends ItemTouchHelper.Callback {
        a() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return ItemTouchHelper.Callback.makeFlag(2, 51);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            Collections.swap(MacroDroidDrawer.this.f11450a.drawerItems, viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            Settings.setDrawerConfiguration(MacroDroidDrawer.this.getContext(), MacroDroidDrawer.this.f11450a);
            MacroDroidDrawer.this.f11451b.notifyItemMoved(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i4) {
        }
    }
}
