EventBusDemo
========
EventBus框架使用Demo。<br/>
EventBus是一款针对Android优化的发布/订阅事件总线。<br/><br/>
GitHub地址：https://github.com/greenrobot/EventBus<br/><br/>
主要功能：替代Intent、Handler、BroadCast在Fragment、Activity、Service或线程之间传递消息<br/>
优点：开销小，代码更优雅，以及将发送者和接收者解耦<br/><br/>
EventBus类：
```java
/**
 * 获取EventBus单例对象
 **/
static EventBus getDefault()
/**
 * 注册EventBus，指定subscriber为事件接收对象
 *
 * @param subscriber 事件接收对象
 */
void register(Object subscriber)
/**
 * 解注EventBus
 *
 * @param subscriber 事件接收对象
 */
void unregister(Object subscriber)
/**
 * 发送指定事件
 * 
 * @param event 事件对象
 */
void post(Object event)
```
被注册为接收（订阅）事件的类需要定义的方法：
```java
/**
 * 用于接收指定事件。
 * <p/>
 * 使用该函数作为订阅函数时，事件在哪个线程发布出来onEvent就会在这个线程中运行，即发布事件和接收事件线程在同一个线程。
 * <p/>
 * 注：使用这个方法时，在onEvent方法中不能执行耗时操作，若执行耗时操作，容易导致事件分发延迟。
 * <p/>
 *
 * @param event 事件对象
 */
public void onEvent(Object event)
/**
 * 用于接收指定事件。
 * <p/>
 * 使用该函数作为订阅函数时，不论事件是在哪个线程中发布出来的，onEventMainThread都会在UI线程中执行，接收事件就会在UI线程中运行（适用于更新UI）。
 * <p/>
 * 注：在onEvnetMainThread方法中是不能执行耗时操作。
 * <p/>
 * 
 * @param event 事件对象
 */
public void onEventMainThread(Object event)
/**
 * 用于接收指定事件。
 * <p/>
 * 使用该函数作为订阅函数时，若事件是在UI线程中发布出来的，那么onEventBackground就会在新创建的子线程中运行；若事件本来就是子线程中发布出来的，那么onEventBackground函数就直接在该子线程中执行。
 * <p/>
 * 
 * @param event 事件对象
 */
public void onEventBackground(Object event)
/**
 * 用于接收指定事件。
 * <p/>
 * 使用该函数作为订阅函数时，无论事件在哪个线程发布，都会创建新的子线程再执行onEventAsync。
 * <p/>
 *
 * @param event 事件对象
 */
public void onEventAsync(Object event)
```