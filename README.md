## jvm_study
### jvm args
> \- 标准参数,所有的JVM都应该支持<br>
  -X 非标准参数，每个JVM都应该实现<br>
  -XX 不稳定参数（扩展参数），下一个版本可能会取消<br>
  * -Xms 设置JVM初始堆内存
  * -Xmx 设置JVM最大堆内存
  * -XX:+HeapDumpOnOutOfMemoryError 内存溢出异常时dump出当前内存快照
  * -Xss 减少栈内存大小
  * -XX:PermSize 设置持久代(perm gen)初始值，物理内存的1/64
  * -XX:MaxPermSize 设置持久代最大值，物理内存的1/4
  * -XX:MaxDirectMemorySize 用于设置New I/O(java.nio) direct-buffer allocations的最大大小，size的单位可以使用k/K、m/M、g/G；如果没有设置该参数则默认值为0，意味着JVM自己自动给NIO direct-buffer allocations选择最大大小
