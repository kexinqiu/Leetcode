如果要删除node，一般会提前加上dummynode， 方便处理删除head的情况
最后返回dummynode.next 而不是head 

创建两个pointers，先移动fast pointer n+1，此时fast和slow距离为n
同时移动两个pointers，当fast pointer到了末尾， slow pointer指向 target node  前一个node

