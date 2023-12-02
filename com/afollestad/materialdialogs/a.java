package com.afollestad.materialdialogs;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.util.DialogUtils;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultRvAdapter.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private final MaterialDialog f1061a;
    @LayoutRes

    /* renamed from: b  reason: collision with root package name */
    private final int f1062b;

    /* renamed from: c  reason: collision with root package name */
    private final GravityEnum f1063c;

    /* renamed from: d  reason: collision with root package name */
    private c f1064d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultRvAdapter.java */
    /* renamed from: com.afollestad.materialdialogs.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0063a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1065a;

        static {
            int[] iArr = new int[MaterialDialog.f.values().length];
            f1065a = iArr;
            try {
                iArr[MaterialDialog.f.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1065a[MaterialDialog.f.MULTI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultRvAdapter.java */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        final CompoundButton f1066a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f1067b;

        /* renamed from: c  reason: collision with root package name */
        final a f1068c;

        b(View view, a aVar) {
            super(view);
            this.f1066a = (CompoundButton) view.findViewById(R.id.md_control);
            this.f1067b = (TextView) view.findViewById(R.id.md_title);
            this.f1068c = aVar;
            view.setOnClickListener(this);
            if (aVar.f1061a.f977c.F != null) {
                view.setOnLongClickListener(this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CharSequence charSequence;
            if (this.f1068c.f1064d != null && getAdapterPosition() != -1) {
                if (this.f1068c.f1061a.f977c.f1018l != null && getAdapterPosition() < this.f1068c.f1061a.f977c.f1018l.size()) {
                    charSequence = this.f1068c.f1061a.f977c.f1018l.get(getAdapterPosition());
                } else {
                    charSequence = null;
                }
                this.f1068c.f1064d.onItemSelected(this.f1068c.f1061a, view, getAdapterPosition(), charSequence, false);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            CharSequence charSequence;
            if (this.f1068c.f1064d != null && getAdapterPosition() != -1) {
                if (this.f1068c.f1061a.f977c.f1018l != null && getAdapterPosition() < this.f1068c.f1061a.f977c.f1018l.size()) {
                    charSequence = this.f1068c.f1061a.f977c.f1018l.get(getAdapterPosition());
                } else {
                    charSequence = null;
                }
                return this.f1068c.f1064d.onItemSelected(this.f1068c.f1061a, view, getAdapterPosition(), charSequence, true);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultRvAdapter.java */
    /* loaded from: classes2.dex */
    public interface c {
        boolean onItemSelected(MaterialDialog materialDialog, View view, int i4, CharSequence charSequence, boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MaterialDialog materialDialog, @LayoutRes int i4) {
        this.f1061a = materialDialog;
        this.f1062b = i4;
        this.f1063c = materialDialog.f977c.f1006f;
    }

    @TargetApi(17)
    private boolean c() {
        if (this.f1061a.getBuilder().getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @TargetApi(17)
    private void g(ViewGroup viewGroup) {
        ((LinearLayout) viewGroup).setGravity(this.f1063c.getGravityInt() | 16);
        if (viewGroup.getChildCount() == 2) {
            if (this.f1063c == GravityEnum.END && !c() && (viewGroup.getChildAt(0) instanceof CompoundButton)) {
                View view = (CompoundButton) viewGroup.getChildAt(0);
                viewGroup.removeView(view);
                TextView textView = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView);
                textView.setPadding(textView.getPaddingRight(), textView.getPaddingTop(), textView.getPaddingLeft(), textView.getPaddingBottom());
                viewGroup.addView(textView);
                viewGroup.addView(view);
            } else if (this.f1063c == GravityEnum.START && c() && (viewGroup.getChildAt(1) instanceof CompoundButton)) {
                View view2 = (CompoundButton) viewGroup.getChildAt(1);
                viewGroup.removeView(view2);
                TextView textView2 = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView2);
                textView2.setPadding(textView2.getPaddingRight(), textView2.getPaddingTop(), textView2.getPaddingRight(), textView2.getPaddingBottom());
                viewGroup.addView(view2);
                viewGroup.addView(textView2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(b bVar, int i4) {
        int i5;
        boolean z3;
        View view = bVar.itemView;
        boolean isIn = DialogUtils.isIn(Integer.valueOf(i4), this.f1061a.f977c.Q);
        if (isIn) {
            i5 = DialogUtils.adjustAlpha(this.f1061a.f977c.f1011h0, 0.4f);
        } else {
            i5 = this.f1061a.f977c.f1011h0;
        }
        bVar.itemView.setEnabled(!isIn);
        int i6 = C0063a.f1065a[this.f1061a.f994t.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                CheckBox checkBox = (CheckBox) bVar.f1066a;
                boolean contains = this.f1061a.f995u.contains(Integer.valueOf(i4));
                MaterialDialog.Builder builder = this.f1061a.f977c;
                ColorStateList colorStateList = builder.f1036u;
                if (colorStateList != null) {
                    MDTintHelper.setTint(checkBox, colorStateList);
                } else {
                    MDTintHelper.setTint(checkBox, builder.f1034t);
                }
                checkBox.setChecked(contains);
                checkBox.setEnabled(!isIn);
            }
        } else {
            RadioButton radioButton = (RadioButton) bVar.f1066a;
            MaterialDialog.Builder builder2 = this.f1061a.f977c;
            if (builder2.O == i4) {
                z3 = true;
            } else {
                z3 = false;
            }
            ColorStateList colorStateList2 = builder2.f1036u;
            if (colorStateList2 != null) {
                MDTintHelper.setTint(radioButton, colorStateList2);
            } else {
                MDTintHelper.setTint(radioButton, builder2.f1034t);
            }
            radioButton.setChecked(z3);
            radioButton.setEnabled(!isIn);
        }
        bVar.f1067b.setText(this.f1061a.f977c.f1018l.get(i4));
        bVar.f1067b.setTextColor(i5);
        MaterialDialog materialDialog = this.f1061a;
        materialDialog.setTypeface(bVar.f1067b, materialDialog.f977c.S);
        ViewGroup viewGroup = (ViewGroup) view;
        g(viewGroup);
        int[] iArr = this.f1061a.f977c.f1039v0;
        if (iArr != null) {
            if (i4 < iArr.length) {
                view.setId(iArr[i4]);
            } else {
                view.setId(-1);
            }
        }
        if (viewGroup.getChildCount() == 2) {
            if (viewGroup.getChildAt(0) instanceof CompoundButton) {
                viewGroup.getChildAt(0).setBackground(null);
            } else if (viewGroup.getChildAt(1) instanceof CompoundButton) {
                viewGroup.getChildAt(1).setBackground(null);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public b onCreateViewHolder(ViewGroup viewGroup, int i4) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f1062b, viewGroup, false);
        DialogUtils.setBackgroundCompat(inflate, this.f1061a.e());
        return new b(inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(c cVar) {
        this.f1064d = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<CharSequence> arrayList = this.f1061a.f977c.f1018l;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }
}
