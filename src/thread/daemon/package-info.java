/**
 * https://blog.csdn.net/tanga842428/article/details/52793069
 * <p>
 * Java中有两类线程：User Thread(用户线程)、Daemon Thread(守护线程)
 * 用户线程：非守护线程，包括常规的用户线程或诸如用于处理GUI事件的事件调度线程，Java虚拟机在它所有非守护线程已经离开后自动离开。
 * 守护线程：守护线程则是用来服务用户线程的，比如说GC线程。如果没有其他用户线程在运行，那么就没有可服务对象，也就没有理由继续下去。
 * <p>
 * 守护线程并非只有虚拟机内部可以提供，用户也可以自行的设定守护线程（Thread.setDaemon)，但是有几点需要注意：
 * （一） Thread.setDaemon必须在Thread.start之前设置，否则会跑出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程。
 * （二） 在Daemon线程中产生的新线程也是Daemon的。
 * （三） 不是所有的应用都可以分配给Daemon线程来进行服务，比如读写操作或者计算逻辑。因为在Daemon Thread还没来的及进行操作时，虚拟机可能已经退出了。
 * <p>
 * 守护线程实际应用在比如： Web服务器中的Servlet。容器启动时后台初始化一个服务线程，即调度线程，负责处理http请求，
 * 然后每个请求过来调度线程从线程池中取出一个工作者线程来处理该请求，从而实现并发控制的目的。
 */
package thread.daemon;