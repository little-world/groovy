class Doer {
    def doing(String s) {
        println("doing: " + s)
    }


    def static dele(@DelegatesTo(Doer) Closure closure) {
        Doer doer = new Doer()
        closure.delegate = doer
        closure()
    }
}


int totalPrices(prices, selector) {
    int total = 0
    for (int price : prices)
        if (selector(price)) total += price
    total
}


static void main(String[] args) {
    Doer.dele {
        doing 'hallo'
    }

    def prices = [1,2,3,4,5,6,7, 8,9]
    def result = totalPrices(prices) {a -> a > 5}

    println(result)
}