package com.h6ah4i.android.widget.advrecyclerview.headerfooter;

import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPathSegment;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.composedadapter.ComposedAdapter;
import com.h6ah4i.android.widget.advrecyclerview.composedadapter.ComposedChildAdapterTag;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class AbstractHeaderFooterWrapperAdapter<HeaderVH extends RecyclerView.ViewHolder, FooterVH extends RecyclerView.ViewHolder> extends ComposedAdapter {
    public static final int SEGMENT_TYPE_FOOTER = 2;
    public static final int SEGMENT_TYPE_HEADER = 0;
    public static final int SEGMENT_TYPE_NORMAL = 1;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.Adapter f33892d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView.Adapter f33893e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.Adapter f33894f;

    /* renamed from: g  reason: collision with root package name */
    private ComposedChildAdapterTag f33895g;

    /* renamed from: h  reason: collision with root package name */
    private ComposedChildAdapterTag f33896h;

    /* renamed from: i  reason: collision with root package name */
    private ComposedChildAdapterTag f33897i;

    /* loaded from: classes6.dex */
    public static class BaseFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        protected AbstractHeaderFooterWrapperAdapter f33898a;

        public BaseFooterAdapter(AbstractHeaderFooterWrapperAdapter abstractHeaderFooterWrapperAdapter) {
            this.f33898a = abstractHeaderFooterWrapperAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f33898a.getFooterItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i4) {
            return this.f33898a.getFooterItemId(i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i4) {
            return this.f33898a.getFooterItemViewType(i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
            throw new IllegalStateException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
            return this.f33898a.onCreateFooterItemViewHolder(viewGroup, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i4, @NonNull List<Object> list) {
            this.f33898a.onBindFooterItemViewHolder(viewHolder, i4, list);
        }
    }

    /* loaded from: classes6.dex */
    public static class BaseHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        protected AbstractHeaderFooterWrapperAdapter f33899a;

        public BaseHeaderAdapter(AbstractHeaderFooterWrapperAdapter abstractHeaderFooterWrapperAdapter) {
            this.f33899a = abstractHeaderFooterWrapperAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f33899a.getHeaderItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i4) {
            return this.f33899a.getHeaderItemId(i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i4) {
            return this.f33899a.getHeaderItemViewType(i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
            throw new IllegalStateException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
            return this.f33899a.onCreateHeaderItemViewHolder(viewGroup, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i4, @NonNull List<Object> list) {
            this.f33899a.onBindHeaderItemViewHolder(viewHolder, i4, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.composedadapter.ComposedAdapter
    public void g() {
        super.g();
        this.f33895g = null;
        this.f33896h = null;
        this.f33897i = null;
        this.f33892d = null;
        this.f33893e = null;
        this.f33894f = null;
    }

    @Nullable
    public RecyclerView.Adapter getFooterAdapter() {
        return this.f33894f;
    }

    public abstract int getFooterItemCount();

    @IntRange(from = ItemIdComposer.MIN_WRAPPED_ID, to = ItemIdComposer.MAX_WRAPPED_ID)
    public long getFooterItemId(int i4) {
        if (hasStableIds()) {
            return -1L;
        }
        return i4;
    }

    @IntRange(from = -8388608, to = 8388607)
    public int getFooterItemViewType(int i4) {
        return 0;
    }

    @NonNull
    public AdapterPathSegment getFooterSegment() {
        return new AdapterPathSegment(this.f33894f, this.f33897i);
    }

    @Nullable
    public RecyclerView.Adapter getHeaderAdapter() {
        return this.f33892d;
    }

    public abstract int getHeaderItemCount();

    @IntRange(from = ItemIdComposer.MIN_WRAPPED_ID, to = ItemIdComposer.MAX_WRAPPED_ID)
    public long getHeaderItemId(int i4) {
        if (hasStableIds()) {
            return -1L;
        }
        return i4;
    }

    @IntRange(from = -8388608, to = 8388607)
    public int getHeaderItemViewType(int i4) {
        return 0;
    }

    @NonNull
    public AdapterPathSegment getHeaderSegment() {
        return new AdapterPathSegment(this.f33892d, this.f33895g);
    }

    @Nullable
    public RecyclerView.Adapter getWrappedAdapter() {
        return this.f33893e;
    }

    @NonNull
    public AdapterPathSegment getWrappedAdapterSegment() {
        return new AdapterPathSegment(this.f33893e, this.f33896h);
    }

    @NonNull
    protected RecyclerView.Adapter h() {
        return new BaseFooterAdapter(this);
    }

    @NonNull
    protected RecyclerView.Adapter i() {
        return new BaseHeaderAdapter(this);
    }

    public abstract void onBindFooterItemViewHolder(@NonNull FooterVH footervh, int i4);

    public void onBindFooterItemViewHolder(@NonNull FooterVH footervh, int i4, List<Object> list) {
        onBindFooterItemViewHolder(footervh, i4);
    }

    public abstract void onBindHeaderItemViewHolder(@NonNull HeaderVH headervh, int i4);

    public void onBindHeaderItemViewHolder(@NonNull HeaderVH headervh, int i4, List<Object> list) {
        onBindHeaderItemViewHolder(headervh, i4);
    }

    @NonNull
    public abstract FooterVH onCreateFooterItemViewHolder(@NonNull ViewGroup viewGroup, int i4);

    @NonNull
    public abstract HeaderVH onCreateHeaderItemViewHolder(@NonNull ViewGroup viewGroup, int i4);

    @NonNull
    public AbstractHeaderFooterWrapperAdapter setAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        if (this.f33893e == null) {
            this.f33893e = adapter;
            this.f33892d = i();
            this.f33894f = h();
            boolean hasStableIds = adapter.hasStableIds();
            this.f33892d.setHasStableIds(hasStableIds);
            this.f33894f.setHasStableIds(hasStableIds);
            setHasStableIds(hasStableIds);
            this.f33895g = addAdapter(this.f33892d);
            this.f33896h = addAdapter(this.f33893e);
            this.f33897i = addAdapter(this.f33894f);
            return this;
        }
        throw new IllegalStateException("setAdapter() can call only once");
    }
}
