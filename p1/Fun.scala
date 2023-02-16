// 1a) Create a Scala file (Fun.scala) with the following code
//singleton object
object Fun {
def func1(x : Double, y :Int) = x + (70*y)
def ex(a: Double) = 50 * a

/*
2 a) Define a method that receives two pairs of integers and returns a pair of integers. The
first element of the result being the sum of the first input pair, and the second element
of the result pair the product of the second input pair.
Fun.func2a((2,4), (4,8))
*/
def func2a(a:(Int, Int), b:(Int, Int)): (Int, Int) = {
	(a._1 + a._2, b._1 * b._2)
}

/*
2b) Write a method that, given three Int numbers, returns a pair containing the largest
element in the first element, and the second largest number in the second element.
*/
def maior(x:Int, y:Int): Int = {
	if(x>y) x else y
}

def menor(x:Int, y:Int): Int = {
	if(x<y) x else y
}

def maiorDe3(a:Int, b:Int, c:Int): Int = {
	maior(maior(a,b),c)
}

/*
acho os 2 maiores, depois vou ver qual deles é o menor
 
scala> Fun.middle3(1,2,2)
res8: Int = 2

scala> Fun.middle3(1,2,8)
res9: Int = 2

scala> Fun.middle3(3,7,2)
res10: Int = 3
*/
def middle3(a:Int, b:Int, c:Int): Int = {
	(menor (maior(a,b), maior(menor(a,b),c)))
}

/*
2c) Write a method that receives a triple of Int numbers and returns a triple where the same
numbers are ordered in descending order.
scala> Fun.sort3(12,4,8)
res13: (Int, Int, Int) = (12,8,4)

scala> Fun.sort3(12,8,4)
res14: (Int, Int, Int) = (12,8,4)

scala> Fun.sort3(1,8,4)
res15: (Int, Int, Int) = (8,4,1)

*/

def menorDe3(a:Int, b:Int, c:Int): Int = {
	menor(menor(a,b),c)
}

def sort3(a:Int, b:Int, c:Int): (Int, Int, Int) = {
	(maiorDe3(a,b,c), middle3(a,b,c), menorDe3(a,b,c))
}

/*
2d)
The sides of any triangle respect the following constraint: the sum of the lengths of any
two sides, is greater than the length of the third side. Write a method that receive the
length of three segments and return a Boolean value indicating whether the constraint
is satisfied.

scala> Fun.isTriangle(1,2,3)
res0: Boolean = false

scala> Fun.isTriangle(2,5,4)
res2: Boolean = true

scala> Fun.isTriangle(4,4,4)
res3: Boolean = true
*/
def isTriangle(a:Double, b:Double, c:Double): Boolean = {
	((a+b>c) && (a+c>b) && (b+c>a)) 
}

/*
2e)
Write a method abrev that receives a string containing a person's name and returns a
string with the first and last name.
For example, abrev "José Carlos Martins Sousa" = "José Sousa"

scala> Fun.abrev("José Carlos Martins Sousa")
res19: String = José Sousa

*/
def abrev(s:String): String = {
	val words = s.split(" ")
	(words(0) + " " + words(words.length - 1)) 
}

/*
Now consider the following mathematical definition of the factorial function for non-negative
integers:
0! = 1
n! = n*(n-1)*(n-2)*...*1
Being n! = n*(n-1)! a possible Scala definition of the factorial method is:
def fact(n: Int):Int = if (n==0) 1 else n * fact(n-1)
Note that this method is recursive, i.e. it appears in the expression that defines it. The method
is also said to invoke itself. The method calculation ends because the stop case is always reached
(n = 0).
*/
def fact(n: Int):Int = if (n==0) 1 else n * fact(n-1)
	
/*
a) Define a method that calculates the result (Int) of the following exponentiation xy
without resorting to predefined functions.
*/
def exp(x:Int, y: Int):Int = if (y==0) 1 else x * exp(x, y-1)

/*
b) Define a method that receives a Int List and constructs a pair with the first and the last
element of the list.

scala> Fun.getPair(List(2,3))
res16: (Int, Int) = (2,3)

scala> Fun.getPair(List(2,3,4,5,7))
res17: (Int, Int) = (2,7)

scala> Fun.getPair(List(2,3,4,5,7,1))
res18: (Int, Int) = (2,1)
*/

def getPair(input: List[Int]): (Int, Int) = (input.head, input.last)


/*
c) Define a method that, given a Int list, gives the pair with that list and its length.

scala> Fun.getPair2(List(2,3,4,5,7,1))
res19: (List[Int], Int) = (List(2, 3, 4, 5, 7, 1),6)
*/

def getPair2(input: List[Int]): (List[Int], Int) = (input, input.length)

/*
d) Define a method that, given a Double list, calculates its average. The pre-defined
function tail of List might be useful.

scala> Fun.average(List(2,3,4,5,7,1))
res8: Double = 3.6666666666666665
*/

def sum(lst: List[Double]): Double = if(lst.isEmpty) 0 else
lst.head + sum(lst.tail)

def average(lst: List[Double]) = sum(lst) / lst.length	

// ou

def average1(lst: List[Double]) = lst.sum / lst.length
}
