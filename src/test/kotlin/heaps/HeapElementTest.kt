package heaps

import io.kotlintest.specs.BehaviorSpec
import io.kotlintest.matchers.shouldBe

class HeapElementTest: BehaviorSpec() {
    init {
        given("binary heap elements") {
            When("a pair with different keys") {
                Then("it should be possible to compare them") {
                    val elemLow = HeapElement(1, "Low")
                    val elemHigh = HeapElement(10, "High")
                    (elemLow < elemHigh) shouldBe true
                    (elemLow > elemHigh) shouldBe false
                }
            }
        }
    }
}
