package heaps

abstract class BinaryHeap : Heap {
    abstract protected var elements: ArrayList<HeapElement>
    abstract protected fun siftUp(i: Int)
    abstract protected fun siftDown(i: Int)

    protected fun parentIndex(i: Int) = (i - 1) / 2
    protected fun leftChildIndex(i: Int) = (i * 2) + 1
    protected fun rightChildIndex(i: Int) = (i * 2) + 2
    protected fun swap(i: Int, j: Int) {
        val temp = elements[i]
        elements[i] = elements[j]
        elements[j] = temp
    }

    /**
     * Adds a new element to the heap
     */
    override fun insert(elem: HeapElement) {
        if (elements.isEmpty()) {
            elements.add(0, elem)
        } else {
            elements.add(elem)
        }
        siftUp(elements.size - 1) // restores the heap property
    }

    /**
     * Returns the element with the maximum key value, removing it from the heap
     */
    override fun extract(): HeapElement {
        if (elements.isEmpty()) throw NoSuchElementException("MaxHeap is empty.")
        val maxElem = peek() // take element at the top
        elements[0] = elements[elements.size - 1] // put last element at the top of the heap
        elements.removeAt(elements.size - 1) // remove reference to the last element
        siftDown(0) // restores the heap property
        return maxElem
    }

    /**
     * Returns the element with the maximum key value, leaving it in the heap
     */
    override fun peek(): HeapElement {
        if (elements.isEmpty()) throw NoSuchElementException("MaxHeap is empty.")
        return elements[0]
    }

    /**
     * Returns true if the heap contains no elements
     */
    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    /**
     * Returns the number of items in the heap
     */
    override fun size(): Int {
        return elements.size
    }
}
