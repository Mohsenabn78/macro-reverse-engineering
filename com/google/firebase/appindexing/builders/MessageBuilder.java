package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Date;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class MessageBuilder extends IndexableBuilder<MessageBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageBuilder() {
        super("Message");
    }

    @NonNull
    public MessageBuilder setDateRead(@NonNull Date date) {
        Preconditions.checkNotNull(date);
        put("dateRead", date.getTime());
        return this;
    }

    @NonNull
    public MessageBuilder setDateReceived(@NonNull Date date) {
        Preconditions.checkNotNull(date);
        put("dateReceived", date.getTime());
        return this;
    }

    @NonNull
    public MessageBuilder setDateSent(@NonNull Date date) {
        Preconditions.checkNotNull(date);
        put("dateSent", date.getTime());
        return this;
    }

    @NonNull
    public MessageBuilder setMessageAttachment(@NonNull IndexableBuilder<?>... indexableBuilderArr) {
        a("messageAttachment", indexableBuilderArr);
        return this;
    }

    @NonNull
    public MessageBuilder setRecipient(@NonNull PersonBuilder... personBuilderArr) {
        a("recipient", personBuilderArr);
        return this;
    }

    @NonNull
    public MessageBuilder setSender(@NonNull PersonBuilder personBuilder) {
        a("sender", personBuilder);
        return this;
    }

    @NonNull
    public MessageBuilder setText(@NonNull String str) {
        put("text", str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageBuilder(String str) {
        super("EmailMessage");
    }
}
