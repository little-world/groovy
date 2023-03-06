static void main(String[] args) {

   def x = 2

   def d = 3.14

   def str = "hello, world $x"
   def str2 = 'hello $x'

   def b = true

   println(str)
   println(str2)

   def div =  3 / 4
   println div

   def pw = 3 ** 2
   println pw


   if (x != 2)
      println("equals")
   else
      println("not")

   int i = 0
   while (i++ < 4) {
      print(i)
   }

   for (int n1 = 0; n1 < 5; n1++) {
      print(": $n1")
   }

   def ll = [1, 2, 3, 4]

   for(int aa in ll) {
      println(aa)
   }


   def filter = ll.findAll {n -> n > 3}
   def map =  ll.collect {it * 2}
   def fold =  ll.inject(1) {q, r -> q * r}
   ll.each {print it }


   println("          ============        ")
   for(int aa in ll) {
      println(aa)
   }

}