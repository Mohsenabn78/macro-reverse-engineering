package com.thoughtbot.expandablerecyclerview.viewholders;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.thoughtbot.expandablerecyclerview.listeners.OnGroupClickListener;

/* loaded from: classes6.dex */
public abstract class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private OnGroupClickListener f38090a;

    public GroupViewHolder(View view) {
        super(view);
        view.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnGroupClickListener onGroupClickListener = this.f38090a;
        if (onGroupClickListener != null) {
            if (onGroupClickListener.onGroupClick(getAdapterPosition())) {
                collapse();
            } else {
                expand();
            }
        }
    }

    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        this.f38090a = onGroupClickListener;
    }

    public void collapse() {
    }

    public void expand() {
    }
}
