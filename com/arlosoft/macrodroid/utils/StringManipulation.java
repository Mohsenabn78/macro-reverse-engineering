package com.arlosoft.macrodroid.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.utils.StringManipulation;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class StringManipulation {

    /* renamed from: a  reason: collision with root package name */
    private static Pair<String, String> f16077a = new Pair<>("{left(x,text)}", "Takes the leftmost 'x' character from the text");

    /* renamed from: b  reason: collision with root package name */
    private static Pair<String, String> f16078b = new Pair<>("{right(x,text)}", "Takes the righmost 'x' characters from the text");

    /* renamed from: c  reason: collision with root package name */
    private static Pair<String, String> f16079c = new Pair<>("{replace(original,new)}", "Replaces all instances of the original string with the new string");

    /* renamed from: d  reason: collision with root package name */
    private static List<Pair<String, String>> f16080d;

    /* loaded from: classes3.dex */
    public static class StringManipOptionsAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private final List<Pair<String, String>> f16081a;

        /* renamed from: b  reason: collision with root package name */
        private final MagicText.MagicTextListener f16082b;

        /* renamed from: c  reason: collision with root package name */
        private final Dialog f16083c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.string_manipulation_description)
            TextView description;
            @BindView(R.id.divider)
            View divider;
            @BindView(R.id.string_manipulation_entry)
            ViewGroup entry;
            @BindView(R.id.string_manipulation_text)
            TextView text;

            public ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c(MagicText.MagicTextListener magicTextListener, Pair pair, View view) {
                if (magicTextListener != null) {
                    magicTextListener.magicTextSelected(new MagicText.MagicTextPair((String) pair.first, ""));
                }
                StringManipOptionsAdapter.this.f16083c.dismiss();
            }

            public void b(final Pair<String, String> pair, boolean z3, final MagicText.MagicTextListener magicTextListener) {
                int i4;
                this.text.setText(pair.first);
                this.description.setText(pair.second);
                this.entry.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.utils.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StringManipulation.StringManipOptionsAdapter.ViewHolder.this.c(magicTextListener, pair, view);
                    }
                });
                View view = this.divider;
                if (z3) {
                    i4 = 8;
                } else {
                    i4 = 0;
                }
                view.setVisibility(i4);
            }
        }

        /* loaded from: classes3.dex */
        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: a  reason: collision with root package name */
            private ViewHolder f16085a;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f16085a = viewHolder;
                viewHolder.entry = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.string_manipulation_entry, "field 'entry'", ViewGroup.class);
                viewHolder.text = (TextView) Utils.findRequiredViewAsType(view, R.id.string_manipulation_text, "field 'text'", TextView.class);
                viewHolder.description = (TextView) Utils.findRequiredViewAsType(view, R.id.string_manipulation_description, "field 'description'", TextView.class);
                viewHolder.divider = Utils.findRequiredView(view, R.id.divider, "field 'divider'");
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.f16085a;
                if (viewHolder != null) {
                    this.f16085a = null;
                    viewHolder.entry = null;
                    viewHolder.text = null;
                    viewHolder.description = null;
                    viewHolder.divider = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public StringManipOptionsAdapter(List<Pair<String, String>> list, Dialog dialog, MagicText.MagicTextListener magicTextListener) {
            this.f16081a = list;
            this.f16082b = magicTextListener;
            this.f16083c = dialog;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f16081a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i4) {
            viewHolder.b(this.f16081a.get(i4), i4 == getItemCount() - 1, this.f16082b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_string_manipulation, viewGroup, false));
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f16080d = arrayList;
        arrayList.add(f16077a);
        f16080d.add(f16078b);
        f16080d.add(f16079c);
    }

    public static void showTextManipulationOptions(Activity activity, int i4, MagicText.MagicTextListener magicTextListener) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, i4);
        appCompatDialog.setContentView(R.layout.dialog_string_manipulation);
        appCompatDialog.setTitle(R.string.select_option);
        RecyclerView recyclerView = (RecyclerView) appCompatDialog.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new StringManipOptionsAdapter(f16080d, appCompatDialog, magicTextListener));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        appCompatDialog.show();
        appCompatDialog.getWindow().setAttributes(layoutParams);
    }
}
