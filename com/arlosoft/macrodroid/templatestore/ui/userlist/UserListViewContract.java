package com.arlosoft.macrodroid.templatestore.ui.userlist;

import androidx.lifecycle.LifecycleOwner;
import androidx.paging.PagedList;
import com.arlosoft.macrodroid.templatestore.model.User;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserListViewContract.kt */
/* loaded from: classes3.dex */
public interface UserListViewContract extends LifecycleOwner {
    void initialiseList();

    void refresh();

    void showLoadDataError();

    void showLoadingState(boolean z3);

    void showPirateUserError();

    void updateList(@Nullable PagedList<User> pagedList);
}
