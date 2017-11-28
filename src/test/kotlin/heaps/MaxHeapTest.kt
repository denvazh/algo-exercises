package heaps

import io.kotlintest.specs.BehaviorSpec
import io.kotlintest.matchers.shouldBe

class MaxHeapTest : BehaviorSpec() {
    init {
        given("an empty binary heap") {
            When("isEmpty is called") {
                Then("it should be True") {
                    MaxHeap().isEmpty() shouldBe true
                }
            }
            When("size is called") {
                Then("it should be 0") {
                    MaxHeap().size() shouldBe 0
                }
            }
            When("a new element is added") {
                Then("heap should not be empty and its size should be 1") {
                    val heapUnderTest = MaxHeap()
                    heapUnderTest.insert(HeapElement(0, "somestring"))
                    heapUnderTest.isEmpty() shouldBe false
                    heapUnderTest.size() shouldBe 1
                }
            }
        }

        given("a binary heap") {
            When("one element is added") {
                Then("peek should return that very element") {
                    val testElem = HeapElement(10, "Ten")
                    val heapUnderTest = MaxHeap()
                    heapUnderTest.insert(testElem)
                    heapUnderTest.peek() shouldBe testElem
                }
            }
            When("several elements added") {
                Then("peek should return one with maximum value for the key") {
                    val elem1 = HeapElement(1, "One")
                    val elem2 = HeapElement(2, "Two")
                    val elem10 = HeapElement(10, "Ten")
                    val elem5 = HeapElement(5, "Five")
                    val heapUnderTest = MaxHeap()
                    heapUnderTest.insert(elem1)
                    heapUnderTest.peek() shouldBe elem1
                    heapUnderTest.insert(elem2)
                    heapUnderTest.peek() shouldBe elem2
                    heapUnderTest.insert(elem10)
                    heapUnderTest.peek() shouldBe elem10
                    heapUnderTest.insert(elem5)
                    heapUnderTest.peek() shouldBe elem10
                }

                Then("remove should return element with maximum value for the key") {
                    val elem1 = HeapElement(1, "One")
                    val elem10 = HeapElement(10, "Ten")
                    val elem2 = HeapElement(2, "Two")
                    val heapUnderTest = MaxHeap()
                    heapUnderTest.insert(elem2)
                    heapUnderTest.insert(elem10)
                    heapUnderTest.insert(elem1)
                    heapUnderTest.peek() shouldBe elem10
                    heapUnderTest.extract() shouldBe elem10
                    heapUnderTest.peek() shouldBe elem2
                }
            }
        }
    }
}
