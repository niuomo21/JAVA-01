#### 串行GC

java -XX:+UseSerialGC 

-Xms512m -Xmx512m 

-Xloggc:gc.demo.log 

-XX:+PrintGCDetails 

-XX:+PrintGCDateStamps 

GCLogAnalysis 



对年轻代使用 标记-复制算法 

对老年代使用标记-清楚-整理算法

适合堆内存比较小几百兆的环境



#### 并行GC

java -XX:+UseParallelGC 

-Xms512m -Xmx512m 

-Xloggc:gc.demo.log 

-XX:+PrintGCDetails 

-XX:+PrintGCDateStamps 

GCLogAnalysis 



对年轻代使用 标记-复制算法 

对老年代使用标记-清楚-整理算法

垃圾收集线程和用户线程交替工作

堆内存适中



#### CMS

java -XX:+UseConcMarkSweepGC 

-Xms512m -Xmx512m 

-Xloggc:gc.demo.log 

-XX:+PrintGCDetails 

-XX:+PrintGCDateStamps 

GCLogAnalysis 

初始标记-并发标记-并发预气你管理-最终标记-并发清楚-并发重置

对年轻代使用 标记-复制算法 

对老年代使用标记-清除算法

吃CPU-已废弃



#### G1

java -XX:+UseG1GC 

-Xms512m -Xmx512m 

-Xloggc:gc.demo.log 

-XX:+PrintGCDetails 

-XX:+PrintGCDateStamps 

GCLogAnalysis 

无年轻代和老年代之分，整体换分为多个小堆区，每个堆区都可能作为Eden区、Survivor区、Old区

处理原则：哪的垃圾多久优先清理谁

堆内存较大

