package heaps

class MaxHeap {

    private var elements: ArrayList<HeapElement> = ArrayList()

    private fun parentIndex(i: Int) = (i - 1) / 2
    private fun leftChildIndex(i: Int) = (i * 2) + 1
    private fun rightChildIndex(i: Int) = (i * 2) + 2
    private fun swap(i: Int, j: Int) {
        val temp = elements[i]
        elements[i] = elements[j]
        elements[j] = temp
    }

    private fun siftUp(i: Int) {
        if (i == 0) {
            return
        }

        val iParent = parentIndex(i) // index of parent node
        if (elements[i] > elements[iParent]) { // swap elements if newly added one is greater that its parent
            swap(i, iParent)
            siftUp(iParent) // repeat for the element that is now in the parent position
        }
    }

    private fun siftDown(i: Int) {
        if (i >= elements.size / 2) { // unable to sift down leaf nodes
            return
        }

        val iLeft = leftChildIndex(i)
        val iRight = rightChildIndex(i)
        var iLargerChild = iLeft
        if (iRight < elements.size && elements[iLeft] < elements[iRight]) {
            iLargerChild = iRight
        }

        if (elements[i] < elements[iLargerChild]) {
            swap(i, iLargerChild)
            siftDown(iLargerChild)
        }
    }

    /**
     * Adds a new element to the heap
     */
    fun insert(elem: HeapElement) {
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
    fun extract(): HeapElement {
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
    fun peek(): HeapElement {
        if (elements.isEmpty()) throw NoSuchElementException("MaxHeap is empty.")
        return elements[0]
    }

    /**
     * Returns true if the heap contains no elements
     */
    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    /**
     * Returns the number of items in the heap
     */
    fun size(): Int {
        return elements.size
    }
}
