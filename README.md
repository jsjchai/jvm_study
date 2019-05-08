## jvm_study
### jvm args
> \- 标准参数,所有的JVM都应该支持<br>
  -X 非标准参数，每个JVM都应该实现<br>
  -XX 不稳定参数（扩展参数），下一个版本可能会取消<br>
  * -Xms 设置JVM初始堆内存
  * -Xmx 设置JVM最大堆内存
  * -XX:+HeapDumpOnOutOfMemoryError 内存溢出异常时dump出当前内存快照
  * -Xss 减少栈内存容量
