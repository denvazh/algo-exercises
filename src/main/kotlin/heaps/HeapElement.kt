package heaps

data class HeapElement(val key: Int, val value: String) : Comparable<HeapElement> {
    override fun compareTo(other: HeapElement): Int {
        if (this.key > other.key) return 1
        if (this.key < other.key) return -1
        return 0
    }
}
