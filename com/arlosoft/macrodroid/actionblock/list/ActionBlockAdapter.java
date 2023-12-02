package com.arlosoft.macrodroid.actionblock.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.databinding.ViewActionBlockListItemBinding;
import com.arlosoft.macrodroid.interfaces.UsesActionBlocks;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActionBlockAdapter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nActionBlockAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockAdapter.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,246:1\n1855#2,2:247\n766#2:249\n857#2,2:250\n*S KotlinDebug\n*F\n+ 1 ActionBlockAdapter.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockAdapter\n*L\n175#1:247,2\n220#1:249\n220#1:250,2\n*E\n"})
/* loaded from: classes.dex */
public final class ActionBlockAdapter extends RecyclerView.Adapter<ActionBlockViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<ActionBlock> f5584a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5585b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ActionBlockClickListener f5586c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, ArrayList<Macro>> f5587d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private List<ActionBlock> f5588e;

    public ActionBlockAdapter(@NotNull List<ActionBlock> actionBlocksList, boolean z3, @NotNull ActionBlockClickListener actionBlockClickListener) {
        Intrinsics.checkNotNullParameter(actionBlocksList, "actionBlocksList");
        Intrinsics.checkNotNullParameter(actionBlockClickListener, "actionBlockClickListener");
        this.f5584a = actionBlocksList;
        this.f5585b = z3;
        this.f5586c = actionBlockClickListener;
        this.f5587d = new HashMap<>();
        this.f5588e = actionBlocksList;
        setHasStableIds(true);
        refresh();
    }

    private final void a(String str, Macro macro) {
        ArrayList<Macro> arrayList = this.f5587d.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (!arrayList.contains(macro)) {
            arrayList.add(macro);
            this.f5587d.put(str, arrayList);
        }
    }

    private final boolean b(ActionBlock actionBlock, String str) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        String name = actionBlock.getName();
        Intrinsics.checkNotNullExpressionValue(name, "actionBlock.name");
        Locale locale = Locale.ROOT;
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str, false, 2, (Object) null);
        if (contains$default) {
            return true;
        }
        if (actionBlock.getDescription() != null) {
            String description = actionBlock.getDescription();
            Intrinsics.checkNotNullExpressionValue(description, "actionBlock.description");
            String lowerCase2 = description.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str, false, 2, (Object) null);
            if (contains$default4) {
                return true;
            }
        }
        Iterator<Action> it = actionBlock.getActions().iterator();
        while (it.hasNext()) {
            Action next = it.next();
            String c4 = c(next.getConfiguredName());
            String c5 = c(next.getName());
            Intrinsics.checkNotNull(c4);
            String lowerCase3 = c4.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) str, false, 2, (Object) null);
            if (!contains$default2) {
                Intrinsics.checkNotNull(c5);
                String lowerCase4 = c5.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase()");
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) str, false, 2, (Object) null);
                if (contains$default3) {
                }
            }
            return true;
        }
        return false;
    }

    private final String c(String str) {
        if (str == null) {
            return null;
        }
        String normalize = Normalizer.normalize(str, Normalizer.Form.NFD);
        Intrinsics.checkNotNullExpressionValue(normalize, "normalize(text, Normalizer.Form.NFD)");
        String replace = new Regex("\\p{InCombiningDiacriticalMarks}+").replace(normalize, "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = replace.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f5588e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f5588e.get(i4).getGUID();
    }

    public final void refresh() {
        List<Macro> allCompletedMacrosWithActionBlocksSortedMacrosFirst = MacroStore.getInstance().getAllCompletedMacrosWithActionBlocksSortedMacrosFirst();
        this.f5587d.clear();
        for (Macro macro : allCompletedMacrosWithActionBlocksSortedMacrosFirst) {
            Iterator<Action> it = macro.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                if (next instanceof UsesActionBlocks) {
                    for (String str : ((UsesActionBlocks) next).getActionBlockNames()) {
                        Intrinsics.checkNotNullExpressionValue(macro, "macro");
                        a(str, macro);
                    }
                }
            }
        }
    }

    public final void setFilter(@NotNull String text) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(text, "text");
        endsWith$default = m.endsWith$default(text, "_", false, 2, null);
        if (endsWith$default) {
            text = text.substring(0, text.length() - 1);
            Intrinsics.checkNotNullExpressionValue(text, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        String c4 = c(text);
        Intrinsics.checkNotNull(c4);
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f5584a) {
            String lowerCase = c4.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (b((ActionBlock) obj, lowerCase)) {
                arrayList.add(obj);
            }
        }
        this.f5588e = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ActionBlockViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f5588e.get(i4), this.f5587d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ActionBlockViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewActionBlockListItemBinding inflate = ViewActionBlockListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ActionBlockViewHolder(inflate, this.f5585b, this.f5586c);
    }
}
