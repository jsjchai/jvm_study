## jvm_study
### jvm args
> \- 标准参数,所有的JVM都应该支持<br>
  -X 非标准参数，每个JVM都应该实现<br>
  -XX 不稳定参数（扩展参数），下一个版本可能会取消<br>
  * -Xms 设置JVM初始堆内存
  * -Xmx 设置JVM最大堆内存
  * -Xmn 设置JVM最小堆内存
  * -XX:+HeapDumpOnOutOfMemoryError 内存溢出异常时dump出当前内存快照
  * -Xss 减少栈内存大小
  * -XX:PermSize 设置永久代(perm gen)初始值，物理内存的1/64
  * -XX:MaxPermSize 设置永久代最大值，物理内存的1/4
  * -XX:MaxDirectMemorySize 用于设置New I/O(java.nio) direct-buffer allocations的最大大小，size的单位可以使用k/K、m/M、g/G；如果没有设置该参数则默认值为0，意味着JVM自己自动给NIO direct-buffer allocations选择最大大小
  * -XX:+PrintGCDetails 用于告诉虚拟机在发生垃圾收集行为时打印内存回收日志，并且在进程退出的时候输出当前内存的各区域分配情况
  * -verbose:gc -XX:+PrintGC的别名
  * -XX:+PrintGC 打印GC信息
  * -XX:SurvivorRatio  新生代中Eden区域与Survivor区域的容量比
  * -XX:PretenureSizeThreshold  直接晋升到老年代的对象大小,设置这个参数后,大于这个参数的对象将直接在老年代分配
  * -XX:MaxTenuringThreshold  晋升到老年代的对象年龄,每个对象在坚持过一次Minor GC之后,年龄就+1,当超过这个参数值时就进入老年代
  * -XX:+PrintTenuringDistribution 打印GC后新生代各个年龄对象的大小
  * (JDK 6 Update 24已弃用)-XX:-HandlePromotionFailure 是否允许分配担保失败,即老年代的剩余空间不足以应付新生代的整个Eden和Survivor区的所有对象都存活的极端情况
  
### 参考文档
* [jdk1.8详细参数说明](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/java.html)