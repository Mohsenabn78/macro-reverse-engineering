package com.afollestad.materialdialogs.simplelist;

import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import com.afollestad.materialdialogs.internal.MDAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MaterialSimpleListAdapter extends RecyclerView.Adapter<a> implements MDAdapter {

    /* renamed from: a  reason: collision with root package name */
    private MaterialDialog f1189a;

    /* renamed from: b  reason: collision with root package name */
    private List<MaterialSimpleListItem> f1190b = new ArrayList(4);

    /* renamed from: c  reason: collision with root package name */
    private Callback f1191c;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onMaterialListItemSelected(MaterialDialog materialDialog, int i4, MaterialSimpleListItem materialSimpleListItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f1192a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f1193b;

        /* renamed from: c  reason: collision with root package name */
        final MaterialSimpleListAdapter f1194c;

        a(View view, MaterialSimpleListAdapter materialSimpleListAdapter) {
            super(view);
            this.f1192a = (ImageView) view.findViewById(16908294);
            this.f1193b = (TextView) view.findViewById(16908310);
            this.f1194c = materialSimpleListAdapter;
            view.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f1194c.f1191c != null) {
                this.f1194c.f1191c.onMaterialListItemSelected(this.f1194c.f1189a, getAdapterPosition(), this.f1194c.getItem(getAdapterPosition()));
            }
        }
    }

    public MaterialSimpleListAdapter(Callback callback) {
        this.f1191c = callback;
    }

    public void add(MaterialSimpleListItem materialSimpleListItem) {
        this.f1190b.add(materialSimpleListItem);
        notifyItemInserted(this.f1190b.size() - 1);
    }

    public void clear() {
        this.f1190b.clear();
        notifyDataSetChanged();
    }

    public MaterialSimpleListItem getItem(int i4) {
        return this.f1190b.get(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1190b.size();
    }

    @Override // com.afollestad.materialdialogs.internal.MDAdapter
    public void setDialog(MaterialDialog materialDialog) {
        this.f1189a = materialDialog;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i4) {
        if (this.f1189a != null) {
            MaterialSimpleListItem materialSimpleListItem = this.f1190b.get(i4);
            if (materialSimpleListItem.getIcon() != null) {
                aVar.f1192a.setImageDrawable(materialSimpleListItem.getIcon());
                aVar.f1192a.setPadding(materialSimpleListItem.getIconPadding(), materialSimpleListItem.getIconPadding(), materialSimpleListItem.getIconPadding(), materialSimpleListItem.getIconPadding());
                aVar.f1192a.getBackground().setColorFilter(materialSimpleListItem.getBackgroundColor(), PorterDuff.Mode.SRC_ATOP);
            } else {
                aVar.f1192a.setVisibility(8);
            }
            aVar.f1193b.setTextColor(this.f1189a.getBuilder().getItemColor());
            aVar.f1193b.setText(materialSimpleListItem.getContent());
            MaterialDialog materialDialog = this.f1189a;
            materialDialog.setTypeface(aVar.f1193b, materialDialog.getBuilder().getRegularFont());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i4) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.md_simplelist_item, viewGroup, false), this);
    }
}
