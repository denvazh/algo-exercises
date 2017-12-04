package heaps

class MaxHeap : BinaryHeap() {
    override var elements: ArrayList<HeapElement> = ArrayList()
    override fun siftUp(i: Int) {
        if (i == 0) {
            return
        }

        val iParent = parentIndex(i) // index of parent node
        if (elements[i] > elements[iParent]) { // swap elements if newly added one is greater that its parent
            swap(i, iParent)
            siftUp(iParent) // repeat for the element that is now in the parent position
        }
    }

    override fun siftDown(i: Int) {
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
}
