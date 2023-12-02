package com.sun.mail.util;

import java.io.InputStream;
import javax.mail.MessagingException;

/* loaded from: classes6.dex */
public interface ReadableMime {
    InputStream getMimeStream() throws MessagingException;
}
