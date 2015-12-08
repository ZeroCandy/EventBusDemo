EventBusDemo
========
EventBus框架使用Demo。<br/>
EventBus是一款针对Android优化的发布/订阅事件总线。<br/><br/>
GitHub地址：https://github.com/greenrobot/EventBus<br/><br/>
主要功能：替代Intent、Handler、BroadCast在Fragment、Activity、Service或线程之间传递消息<br/>
优点：开销小，代码更优雅，以及将发送者和接收者解耦<br/><br/>
EventBus类：<br/>
```java
/**
 * 获取EventBus单例对象
 **/
static EventBus getDefault()
/**
 * 注册EventBus，指定subscriber为事件接收对象
 */
void register(Object subscriber)
/**
 * 解注EventBus
 */
void unregister(Object subscriber)
/**
 * 发送指定事件
 */
void post(Object event)
```