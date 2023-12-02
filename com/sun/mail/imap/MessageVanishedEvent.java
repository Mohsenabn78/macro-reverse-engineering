package com.sun.mail.imap;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.event.MessageCountEvent;

/* loaded from: classes6.dex */
public class MessageVanishedEvent extends MessageCountEvent {

    /* renamed from: a  reason: collision with root package name */
    private static final Message[] f37803a = new Message[0];
    private static final long serialVersionUID = 2142028010250024922L;
    private long[] uids;

    public MessageVanishedEvent(Folder folder, long[] jArr) {
        super(folder, 2, true, f37803a);
        this.uids = jArr;
    }

    public long[] getUIDs() {
        return this.uids;
    }
}
