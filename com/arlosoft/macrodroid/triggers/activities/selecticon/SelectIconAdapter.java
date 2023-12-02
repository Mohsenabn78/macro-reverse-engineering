package com.arlosoft.macrodroid.triggers.activities.selecticon;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.triggers.activities.selecticon.SelectIconAdapter;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class SelectIconAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f14627a = new ThreadPoolExecutor(8, 8, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f14628b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f14629c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f14630d;

    /* renamed from: e  reason: collision with root package name */
    private final IconSelectFragment f14631e;

    /* renamed from: f  reason: collision with root package name */
    private Resources f14632f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_item_icon_image)
        ImageView icon;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private ViewHolder f14633a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f14633a = viewHolder;
            viewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.list_item_icon_image, "field 'icon'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.f14633a;
            if (viewHolder != null) {
                this.f14633a = null;
                viewHolder.icon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public SelectIconAdapter(IconSelectFragment iconSelectFragment, List<Integer> list, List<String> list2, List<String> list3) {
        this.f14631e = iconSelectFragment;
        this.f14628b = list;
        this.f14629c = list2;
        this.f14630d = list3;
        try {
            if (list2.size() > 1 && this.f14629c.get(0).equals(this.f14629c.get(1))) {
                this.f14632f = iconSelectFragment.getActivity().getPackageManager().getResourcesForApplication(this.f14629c.get(0));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(ViewHolder viewHolder, Drawable drawable) {
        viewHolder.icon.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str, String str2, int i4, final ViewHolder viewHolder) {
        final Drawable drawable;
        try {
            try {
                Resources resources = this.f14632f;
                if (resources != null) {
                    drawable = this.f14632f.getDrawable(resources.getIdentifier(str, "drawable", str2));
                } else {
                    drawable = this.f14631e.getActivity().getPackageManager().getResourcesForApplication(str2).getDrawable(this.f14628b.get(i4).intValue());
                }
            } catch (OutOfMemoryError unused) {
                System.gc();
                drawable = null;
            }
            if (drawable != null) {
                this.f14631e.getActivity().runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        SelectIconAdapter.e(SelectIconAdapter.ViewHolder.this, drawable);
                    }
                });
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i4, View view) {
        this.f14631e.setIcon(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h(int i4, View view) {
        this.f14631e.handleLongClick(i4);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f14628b.size();
    }

    public void updateItems(List<Integer> list, List<String> list2, List<String> list3) {
        this.f14628b = list;
        this.f14629c = list2;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i4) {
        if (this.f14629c.size() == 0 || this.f14630d.size() == 0 || i4 >= this.f14629c.size() || i4 >= this.f14630d.size()) {
            return;
        }
        final String str = this.f14629c.get(i4);
        final String str2 = this.f14630d.get(i4);
        if (str == null) {
            try {
                viewHolder.icon.setImageDrawable(this.f14631e.getResources().getDrawable(this.f14628b.get(i4).intValue()));
            } catch (Exception unused) {
            }
        } else if (str.equals(Constants.USER_ICON_OPTION_PACKAGE)) {
            viewHolder.icon.setImageBitmap(BitmapFactory.decodeFile(str2));
        } else {
            viewHolder.icon.setImageDrawable(null);
            this.f14627a.execute(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.l
                @Override // java.lang.Runnable
                public final void run() {
                    SelectIconAdapter.this.f(str2, str, i4, viewHolder);
                }
            });
        }
        viewHolder.icon.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectIconAdapter.this.g(i4, view);
            }
        });
        viewHolder.icon.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.n
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean h4;
                h4 = SelectIconAdapter.this.h(i4, view);
                return h4;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_icon_selection, viewGroup, false));
    }
}
