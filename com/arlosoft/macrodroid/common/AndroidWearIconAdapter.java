package com.arlosoft.macrodroid.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.IconTextView;

/* loaded from: classes3.dex */
public class AndroidWearIconAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9833a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f9834b;

    /* renamed from: c  reason: collision with root package name */
    private final IconSelectedListener f9835c;

    /* renamed from: d  reason: collision with root package name */
    private int f9836d;

    /* loaded from: classes3.dex */
    public interface IconSelectedListener {
        void iconSelected(String str);

        void iconStringSelected(String str);
    }

    /* loaded from: classes3.dex */
    class a {

        /* renamed from: a  reason: collision with root package name */
        IconTextView f9837a;

        /* renamed from: b  reason: collision with root package name */
        IconTextView f9838b;

        /* renamed from: c  reason: collision with root package name */
        IconTextView f9839c;

        /* renamed from: d  reason: collision with root package name */
        IconTextView f9840d;

        a() {
        }
    }

    public AndroidWearIconAdapter(Context context, String[] strArr, int i4, IconSelectedListener iconSelectedListener) {
        this.f9834b = strArr;
        this.f9835c = iconSelectedListener;
        this.f9833a = context;
        this.f9836d = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i4, View view) {
        this.f9835c.iconSelected(str);
        this.f9835c.iconStringSelected(this.f9833a.getString(i4));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9834b.length / 4;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.f9833a.getSystemService("layout_inflater")).inflate(R.layout.select_android_wear_icon_list_row, (ViewGroup) null);
            aVar = new a();
            aVar.f9837a = (IconTextView) view.findViewById(R.id.select_android_wear_icon_1);
            aVar.f9838b = (IconTextView) view.findViewById(R.id.select_android_wear_icon_2);
            aVar.f9839c = (IconTextView) view.findViewById(R.id.select_android_wear_icon_3);
            aVar.f9840d = (IconTextView) view.findViewById(R.id.select_android_wear_icon_4);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        IconTextView[] iconTextViewArr = {aVar.f9837a, aVar.f9838b, aVar.f9839c, aVar.f9840d};
        for (int i5 = 0; i5 < 4; i5++) {
            int i6 = (i4 * 4) + i5;
            if (i6 < getCount() * 4) {
                final String str = this.f9834b[i6];
                if (str == null) {
                    iconTextViewArr[i5].setVisibility(8);
                } else {
                    iconTextViewArr[i5].setVisibility(0);
                    final int identifier = this.f9833a.getResources().getIdentifier(str, "string", this.f9833a.getPackageName());
                    iconTextViewArr[i5].setText(identifier);
                    iconTextViewArr[i5].setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.common.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            AndroidWearIconAdapter.this.b(str, identifier, view2);
                        }
                    });
                    iconTextViewArr[i5].setBackgroundTintList(ColorStateList.valueOf(this.f9836d));
                }
            }
        }
        return view;
    }

    public void setIconBgColor(int i4) {
        this.f9836d = i4;
        notifyDataSetChanged();
    }
}
