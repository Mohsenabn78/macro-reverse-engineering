package com.arlosoft.macrodroid.contacts;

import com.arlosoft.macrodroid.common.Contact;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContactsHelper.kt */
/* loaded from: classes3.dex */
public interface ContactSelectionListener {
    void contactsSelected(@NotNull List<? extends Contact> list, boolean z3);
}
