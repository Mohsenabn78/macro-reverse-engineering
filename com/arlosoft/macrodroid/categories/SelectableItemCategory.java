package com.arlosoft.macrodroid.categories;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class SelectableItemCategory implements Comparable<SelectableItemCategory> {

    /* renamed from: a  reason: collision with root package name */
    private String f9607a;
    @DrawableRes

    /* renamed from: b  reason: collision with root package name */
    private int f9608b;

    /* renamed from: c  reason: collision with root package name */
    private List<SelectableItemInfo> f9609c;

    public SelectableItemCategory(String str, @DrawableRes int i4, List<SelectableItemInfo> list) {
        this.f9607a = str;
        this.f9608b = i4;
        this.f9609c = list;
    }

    public String getCategoryName() {
        return this.f9607a;
    }

    @DrawableRes
    public int getIconRes() {
        return this.f9608b;
    }

    public List<SelectableItemInfo> getItems() {
        return this.f9609c;
    }

    public void setItems(List<SelectableItemInfo> list) {
        this.f9609c = list;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull SelectableItemCategory selectableItemCategory) {
        return this.f9607a.compareTo(selectableItemCategory.f9607a);
    }
}
