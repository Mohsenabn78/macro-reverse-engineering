package com.sun.mail.imap;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.sun.mail.util.MailLogger;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;

/* loaded from: classes6.dex */
public class IdleManager {

    /* renamed from: a  reason: collision with root package name */
    private Executor f37788a;

    /* renamed from: c  reason: collision with root package name */
    private MailLogger f37790c;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f37792e;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f37791d = false;

    /* renamed from: f  reason: collision with root package name */
    private Queue<IMAPFolder> f37793f = new ConcurrentLinkedQueue();

    /* renamed from: g  reason: collision with root package name */
    private Queue<IMAPFolder> f37794g = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    private Selector f37789b = Selector.open();

    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IdleManager.this.f37790c.fine("IdleManager select starting");
            try {
                IdleManager.this.f37792e = true;
                IdleManager.this.g();
            } finally {
                IdleManager.this.f37792e = false;
                IdleManager.this.f37790c.fine("IdleManager select terminating");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IMAPFolder f37796a;

        b(IMAPFolder iMAPFolder) {
            this.f37796a = iMAPFolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37796a.F();
        }
    }

    public IdleManager(Session session, Executor executor) throws IOException {
        this.f37788a = executor;
        this.f37790c = new MailLogger(getClass(), "DEBUG IMAP", session.getDebug(), session.getDebugOut());
        executor.execute(new a());
    }

    private static String d(Folder folder) {
        try {
            return folder.getURLName().toString();
        } catch (MessagingException unused) {
            return folder.getStore().toString() + RemoteSettings.FORWARD_SLASH_STRING + folder.toString();
        }
    }

    private void e() throws IOException {
        Iterator<SelectionKey> it = this.f37789b.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            next.cancel();
            IMAPFolder iMAPFolder = (IMAPFolder) next.attachment();
            MailLogger mailLogger = this.f37790c;
            Level level = Level.FINEST;
            if (mailLogger.isLoggable(level)) {
                this.f37790c.log(level, "IdleManager selected folder: {0}", d(iMAPFolder));
            }
            next.channel().configureBlocking(true);
            try {
                if (iMAPFolder.C(false)) {
                    if (this.f37790c.isLoggable(level)) {
                        this.f37790c.log(level, "IdleManager continue watching folder {0}", d(iMAPFolder));
                    }
                    this.f37793f.add(iMAPFolder);
                } else if (this.f37790c.isLoggable(level)) {
                    this.f37790c.log(level, "IdleManager done watching folder {0}", d(iMAPFolder));
                }
            } catch (MessagingException e4) {
                MailLogger mailLogger2 = this.f37790c;
                Level level2 = Level.FINEST;
                mailLogger2.log(level2, "IdleManager got exception for folder: " + d(iMAPFolder), (Throwable) e4);
            }
        }
        while (true) {
            IMAPFolder poll = this.f37794g.poll();
            if (poll != null) {
                MailLogger mailLogger3 = this.f37790c;
                Level level3 = Level.FINEST;
                if (mailLogger3.isLoggable(level3)) {
                    this.f37790c.log(level3, "IdleManager aborting IDLE for folder: {0}", d(poll));
                }
                SocketChannel v3 = poll.v();
                if (v3 != null) {
                    SelectionKey keyFor = v3.keyFor(this.f37789b);
                    if (keyFor != null) {
                        keyFor.cancel();
                    }
                    v3.configureBlocking(true);
                    Socket socket = v3.socket();
                    if (socket != null && socket.getSoTimeout() > 0) {
                        this.f37790c.finest("IdleManager requesting DONE with timeout");
                        this.f37793f.remove(poll);
                        this.f37788a.execute(new b(poll));
                    } else {
                        poll.E();
                        this.f37793f.add(poll);
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f37791d = false;
        while (!this.f37791d) {
            try {
                try {
                    try {
                        try {
                            i();
                            this.f37790c.finest("IdleManager waiting...");
                            int select = this.f37789b.select();
                            MailLogger mailLogger = this.f37790c;
                            Level level = Level.FINEST;
                            if (mailLogger.isLoggable(level)) {
                                this.f37790c.log(level, "IdleManager selected {0} channels", Integer.valueOf(select));
                            }
                            if (this.f37791d || Thread.currentThread().isInterrupted()) {
                                break;
                            }
                            while (true) {
                                e();
                                if (this.f37789b.selectNow() > 0 || !this.f37794g.isEmpty()) {
                                }
                            }
                        } catch (Exception e4) {
                            this.f37790c.log(Level.FINEST, "IdleManager got exception", (Throwable) e4);
                            this.f37791d = true;
                            this.f37790c.finest("IdleManager unwatchAll");
                            try {
                                h();
                                this.f37789b.close();
                            } catch (IOException e5) {
                                e = e5;
                                this.f37790c.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e);
                                this.f37790c.fine("IdleManager exiting");
                            }
                        }
                    } catch (IOException e6) {
                        this.f37790c.log(Level.FINEST, "IdleManager got I/O exception", (Throwable) e6);
                        this.f37791d = true;
                        this.f37790c.finest("IdleManager unwatchAll");
                        try {
                            h();
                            this.f37789b.close();
                        } catch (IOException e7) {
                            e = e7;
                            this.f37790c.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e);
                            this.f37790c.fine("IdleManager exiting");
                        }
                    }
                } catch (InterruptedIOException e8) {
                    this.f37790c.log(Level.FINEST, "IdleManager interrupted", (Throwable) e8);
                    this.f37791d = true;
                    this.f37790c.finest("IdleManager unwatchAll");
                    try {
                        h();
                        this.f37789b.close();
                    } catch (IOException e9) {
                        e = e9;
                        this.f37790c.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e);
                        this.f37790c.fine("IdleManager exiting");
                    }
                }
            } catch (Throwable th) {
                this.f37791d = true;
                this.f37790c.finest("IdleManager unwatchAll");
                try {
                    h();
                    this.f37789b.close();
                } catch (IOException e10) {
                    this.f37790c.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e10);
                }
                this.f37790c.fine("IdleManager exiting");
                throw th;
            }
        }
        this.f37791d = true;
        this.f37790c.finest("IdleManager unwatchAll");
        try {
            h();
            this.f37789b.close();
        } catch (IOException e11) {
            e = e11;
            this.f37790c.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e);
            this.f37790c.fine("IdleManager exiting");
        }
        this.f37790c.fine("IdleManager exiting");
    }

    private void h() {
        for (SelectionKey selectionKey : this.f37789b.keys()) {
            selectionKey.cancel();
            IMAPFolder iMAPFolder = (IMAPFolder) selectionKey.attachment();
            MailLogger mailLogger = this.f37790c;
            Level level = Level.FINEST;
            if (mailLogger.isLoggable(level)) {
                this.f37790c.log(level, "IdleManager no longer watching folder: {0}", d(iMAPFolder));
            }
            try {
                selectionKey.channel().configureBlocking(true);
                iMAPFolder.F();
            } catch (IOException e4) {
                MailLogger mailLogger2 = this.f37790c;
                Level level2 = Level.FINEST;
                mailLogger2.log(level2, "IdleManager exception while aborting idle for folder: " + d(iMAPFolder), (Throwable) e4);
            }
        }
        while (true) {
            IMAPFolder poll = this.f37793f.poll();
            if (poll != null) {
                MailLogger mailLogger3 = this.f37790c;
                Level level3 = Level.FINEST;
                if (mailLogger3.isLoggable(level3)) {
                    this.f37790c.log(level3, "IdleManager aborting IDLE for unwatched folder: {0}", d(poll));
                }
                SocketChannel v3 = poll.v();
                if (v3 != null) {
                    try {
                        v3.configureBlocking(true);
                        poll.F();
                    } catch (IOException e5) {
                        MailLogger mailLogger4 = this.f37790c;
                        Level level4 = Level.FINEST;
                        mailLogger4.log(level4, "IdleManager exception while aborting idle for folder: " + d(poll), (Throwable) e5);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void i() {
        while (true) {
            IMAPFolder poll = this.f37793f.poll();
            if (poll != null) {
                MailLogger mailLogger = this.f37790c;
                Level level = Level.FINEST;
                if (mailLogger.isLoggable(level)) {
                    this.f37790c.log(level, "IdleManager adding {0} to selector", d(poll));
                }
                try {
                    SocketChannel v3 = poll.v();
                    if (v3 != null) {
                        v3.configureBlocking(false);
                        v3.register(this.f37789b, 1, poll);
                    }
                } catch (IOException e4) {
                    this.f37790c.log(Level.FINEST, "IdleManager can't register folder", (Throwable) e4);
                } catch (CancelledKeyException e5) {
                    this.f37790c.log(Level.FINEST, "IdleManager can't register folder", (Throwable) e5);
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(IMAPFolder iMAPFolder) {
        this.f37794g.add(iMAPFolder);
        this.f37789b.wakeup();
    }

    public boolean isRunning() {
        return this.f37792e;
    }

    public synchronized void stop() {
        this.f37791d = true;
        this.f37790c.fine("IdleManager stopping");
        this.f37789b.wakeup();
    }

    public void watch(Folder folder) throws MessagingException {
        if (!this.f37791d) {
            if (folder instanceof IMAPFolder) {
                IMAPFolder iMAPFolder = (IMAPFolder) folder;
                if (iMAPFolder.v() == null) {
                    if (folder.isOpen()) {
                        throw new MessagingException("Folder is not using SocketChannels");
                    }
                    throw new MessagingException("Folder is not open");
                }
                MailLogger mailLogger = this.f37790c;
                Level level = Level.FINEST;
                if (mailLogger.isLoggable(level)) {
                    this.f37790c.log(level, "IdleManager watching {0}", d(iMAPFolder));
                }
                int i4 = 0;
                while (!iMAPFolder.P(this)) {
                    MailLogger mailLogger2 = this.f37790c;
                    Level level2 = Level.FINEST;
                    if (mailLogger2.isLoggable(level2)) {
                        this.f37790c.log(level2, "IdleManager.watch startIdle failed for {0}", d(iMAPFolder));
                    }
                    i4++;
                }
                MailLogger mailLogger3 = this.f37790c;
                Level level3 = Level.FINEST;
                if (mailLogger3.isLoggable(level3)) {
                    if (i4 > 0) {
                        MailLogger mailLogger4 = this.f37790c;
                        mailLogger4.log(level3, "IdleManager.watch startIdle succeeded for {0} after " + i4 + " tries", d(iMAPFolder));
                    } else {
                        this.f37790c.log(level3, "IdleManager.watch startIdle succeeded for {0}", d(iMAPFolder));
                    }
                }
                synchronized (this) {
                    this.f37793f.add(iMAPFolder);
                    this.f37789b.wakeup();
                }
                return;
            }
            throw new MessagingException("Can only watch IMAP folders");
        }
        throw new MessagingException("IdleManager is not running");
    }
}
