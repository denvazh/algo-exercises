package heaps

interface Heap {
    fun insert(elem: HeapElement)
    fun extract(): HeapElement
    fun peek(): HeapElement
    fun size(): Int
    fun isEmpty(): Boolean
}
