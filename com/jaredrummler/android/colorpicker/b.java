package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPaletteAdapter.java */
/* loaded from: classes6.dex */
public class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    final a f34572a;

    /* renamed from: b  reason: collision with root package name */
    final int[] f34573b;

    /* renamed from: c  reason: collision with root package name */
    int f34574c;

    /* renamed from: d  reason: collision with root package name */
    int f34575d;

    /* compiled from: ColorPaletteAdapter.java */
    /* loaded from: classes6.dex */
    interface a {
        void onColorSelected(int i4);
    }

    /* compiled from: ColorPaletteAdapter.java */
    /* renamed from: com.jaredrummler.android.colorpicker.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private final class C0178b {

        /* renamed from: a  reason: collision with root package name */
        View f34576a;

        /* renamed from: b  reason: collision with root package name */
        ColorPanelView f34577b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f34578c;

        /* renamed from: d  reason: collision with root package name */
        int f34579d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ColorPaletteAdapter.java */
        /* renamed from: com.jaredrummler.android.colorpicker.b$b$a */
        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f34581a;

            a(int i4) {
                this.f34581a = i4;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = b.this;
                int i4 = bVar.f34574c;
                int i5 = this.f34581a;
                if (i4 != i5) {
                    bVar.f34574c = i5;
                    bVar.notifyDataSetChanged();
                }
                b bVar2 = b.this;
                bVar2.f34572a.onColorSelected(bVar2.f34573b[this.f34581a]);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ColorPaletteAdapter.java */
        /* renamed from: com.jaredrummler.android.colorpicker.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnLongClickListenerC0179b implements View.OnLongClickListener {
            View$OnLongClickListenerC0179b() {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C0178b.this.f34577b.showHint();
                return true;
            }
        }

        C0178b(Context context) {
            int i4;
            if (b.this.f34575d == 0) {
                i4 = R.layout.cpv_color_item_square;
            } else {
                i4 = R.layout.cpv_color_item_circle;
            }
            View inflate = View.inflate(context, i4, null);
            this.f34576a = inflate;
            this.f34577b = (ColorPanelView) inflate.findViewById(R.id.cpv_color_panel_view);
            this.f34578c = (ImageView) this.f34576a.findViewById(R.id.cpv_color_image_view);
            this.f34579d = this.f34577b.getBorderColor();
            this.f34576a.setTag(this);
        }

        private void a(int i4) {
            b bVar = b.this;
            if (i4 == bVar.f34574c && ColorUtils.calculateLuminance(bVar.f34573b[i4]) >= 0.65d) {
                this.f34578c.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
            } else {
                this.f34578c.setColorFilter((ColorFilter) null);
            }
        }

        private void b(int i4) {
            this.f34577b.setOnClickListener(new a(i4));
            this.f34577b.setOnLongClickListener(new View$OnLongClickListenerC0179b());
        }

        void c(int i4) {
            int i5;
            int i6 = b.this.f34573b[i4];
            int alpha = Color.alpha(i6);
            this.f34577b.setColor(i6);
            ImageView imageView = this.f34578c;
            if (b.this.f34574c == i4) {
                i5 = R.drawable.cpv_preset_checked;
            } else {
                i5 = 0;
            }
            imageView.setImageResource(i5);
            if (alpha != 255) {
                if (alpha <= 165) {
                    this.f34577b.setBorderColor(i6 | (-16777216));
                    this.f34578c.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
                } else {
                    this.f34577b.setBorderColor(this.f34579d);
                    this.f34578c.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                }
            } else {
                a(i4);
            }
            b(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int[] iArr, int i4, @ColorShape int i5) {
        this.f34572a = aVar;
        this.f34573b = iArr;
        this.f34574c = i4;
        this.f34575d = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f34574c = -1;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f34573b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        return Integer.valueOf(this.f34573b[i4]);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        View view2;
        C0178b c0178b;
        if (view == null) {
            c0178b = new C0178b(viewGroup.getContext());
            view2 = c0178b.f34576a;
        } else {
            view2 = view;
            c0178b = (C0178b) view.getTag();
        }
        c0178b.c(i4);
        return view2;
    }
}
